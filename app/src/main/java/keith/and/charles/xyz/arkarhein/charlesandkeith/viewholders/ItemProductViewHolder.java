package keith.and.charles.xyz.arkarhein.charlesandkeith.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import keith.and.charles.xyz.arkarhein.charlesandkeith.R;
import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;
import keith.and.charles.xyz.arkarhein.charlesandkeith.delegates.NewProductDelegate;

public class ItemProductViewHolder extends BaseViewHolder<NewProductVO> {

    @BindView(R.id.iv_product)
    ImageView ivProduct;

    @BindView(R.id.tv_product_name)
    TextView tvProductName;

    private NewProductDelegate mNewProductDelegate;
    private NewProductVO productVO;

    public ItemProductViewHolder(View itemView, NewProductDelegate newProductDelegate) {
        super(itemView);
        this.mNewProductDelegate = newProductDelegate;
    }

    @Override
    public void setData(NewProductVO data) {
        productVO = data;
        Glide.with(itemView.getContext())
                .load(data.getProductImage())
                .into(ivProduct);
        tvProductName.setText(data.getProductTitle());
    }

    @Override
    public void onClick(View v) {
        mNewProductDelegate.onTapProduct();
    }
}
