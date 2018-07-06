package keith.and.charles.xyz.arkarhein.charlesandkeith.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;
import keith.and.charles.xyz.arkarhein.charlesandkeith.R;
import keith.and.charles.xyz.arkarhein.charlesandkeith.adapters.ItemProductAdapter;
import keith.and.charles.xyz.arkarhein.charlesandkeith.data.model.ProductModel;
import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;
import keith.and.charles.xyz.arkarhein.charlesandkeith.mvp.presenters.NewListPresenter;
import keith.and.charles.xyz.arkarhein.charlesandkeith.mvp.views.NewListView;

public class NewListActivity extends BaseActivity implements NewListView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_product_list)
    RecyclerView rvProductList;

    @BindView(R.id.tv_item_count)
    TextView tvItemCount;

    private ItemProductAdapter mItemProductAdapter;
    private NewListPresenter mPresenter;
    private PublishSubject<List<NewProductVO>> mProductPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);
        ProductModel.initProductModel(getApplicationContext());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("New Product");
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mPresenter = ViewModelProviders.of(this).get(NewListPresenter.class);
        mPresenter.initPresenter(this);

        mPresenter.getNewProductLD().observe(this, new Observer<List<NewProductVO>>() {
            @Override
            public void onChanged(@Nullable List<NewProductVO> newProductVOS) {
                displayProduct(newProductVOS);
            }
        });
        mPresenter.getErrorLD().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Snackbar.make(rvProductList, s, Snackbar.LENGTH_INDEFINITE).show();
            }
        });

        mItemProductAdapter = new ItemProductAdapter(getApplicationContext(), mPresenter);
        LinearLayoutManager productLinearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        rvProductList.setAdapter(mItemProductAdapter);
        rvProductList.setLayoutManager(productLinearLayoutManager);


    }

    public void displayProduct(List<NewProductVO> newProductVOS) {
        mItemProductAdapter.appendNewData(newProductVOS);
        tvItemCount.setText(mItemProductAdapter.getItemCount() + " ITEMS ");
    }

    @Override
    public void launchProductDetailScreen() {
        Intent intent = ProductDetailActivity.newIntent(getApplicationContext());
        startActivity(intent);
    }
}
