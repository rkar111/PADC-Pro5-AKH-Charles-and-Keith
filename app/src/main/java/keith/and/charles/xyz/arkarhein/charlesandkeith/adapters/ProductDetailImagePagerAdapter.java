package keith.and.charles.xyz.arkarhein.charlesandkeith.adapters;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import keith.and.charles.xyz.arkarhein.charlesandkeith.R;
import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;
import keith.and.charles.xyz.arkarhein.charlesandkeith.viewholders.ProductDetailViewHolder;

public class ProductDetailImagePagerAdapter extends PagerAdapter {

    private LayoutInflater mLayoutInflater;
    private List<NewProductVO> mProducts;

    public ProductDetailImagePagerAdapter(Context context) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.mProducts = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mProducts.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (View) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ProductDetailViewHolder view = (ProductDetailViewHolder) mLayoutInflater.inflate(R.layout.item_product_detail, container, false);
        view.setData(mProducts.get(position));
        container.addView(view);
        return view;
    }

    public void setmProducts(List<NewProductVO> mProducts) {
        this.mProducts = mProducts;
        notifyDataSetChanged();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
