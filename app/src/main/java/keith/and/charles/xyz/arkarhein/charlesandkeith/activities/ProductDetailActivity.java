package keith.and.charles.xyz.arkarhein.charlesandkeith.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import keith.and.charles.xyz.arkarhein.charlesandkeith.R;
import keith.and.charles.xyz.arkarhein.charlesandkeith.adapters.ProductDetailImagePagerAdapter;
import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;
import keith.and.charles.xyz.arkarhein.charlesandkeith.mvp.presenters.ProductDetailPresenter;
import keith.and.charles.xyz.arkarhein.charlesandkeith.mvp.views.ProductDetailView;

public class ProductDetailActivity extends BaseActivity implements ProductDetailView {

    @BindView(R.id.vp_products_detail)
    ViewPager vpProductDetail;

    @BindView(R.id.toolbar_detail)
    Toolbar toolbarDetail;

    private ProductDetailImagePagerAdapter mAdapter;
    private ProductDetailPresenter mPresenter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ProductDetailActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this, this);
        setSupportActionBar(toolbarDetail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Product Detail");
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mAdapter = new ProductDetailImagePagerAdapter(getApplicationContext());
        vpProductDetail.setAdapter(mAdapter);

        mPresenter = ViewModelProviders.of(this).get(ProductDetailPresenter.class);
        mPresenter.initPresenter(this);

        mPresenter.getProductDetail().observe(this, new Observer<List<NewProductVO>>() {
            @Override
            public void onChanged(@Nullable List<NewProductVO> newProductVOS) {
                displayProductDetail(newProductVOS);
            }
        });
    }

    public void displayProductDetail(List<NewProductVO> newProductVOS) {
        mAdapter.setmProducts(newProductVOS);
    }
}
