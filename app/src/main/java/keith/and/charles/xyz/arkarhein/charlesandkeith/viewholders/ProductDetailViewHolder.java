package keith.and.charles.xyz.arkarhein.charlesandkeith.viewholders;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import keith.and.charles.xyz.arkarhein.charlesandkeith.R;
import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;

public class ProductDetailViewHolder extends RelativeLayout {

    @BindView(R.id.iv_product_detail)
    ImageView ivProductDetail;

    @BindView(R.id.tv_item_detail_name)
    TextView tvItemDetailName;

    public ProductDetailViewHolder(Context context) {
        super(context);
    }

    public ProductDetailViewHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProductDetailViewHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setData(NewProductVO data) {
        Glide.with(ivProductDetail.getContext())
                .load(data.getProductImage())
                .into(ivProductDetail);
        tvItemDetailName.setText(data.getProductTitle());
    }
}
