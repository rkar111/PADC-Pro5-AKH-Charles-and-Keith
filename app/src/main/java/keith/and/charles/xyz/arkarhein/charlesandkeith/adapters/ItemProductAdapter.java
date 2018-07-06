package keith.and.charles.xyz.arkarhein.charlesandkeith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import keith.and.charles.xyz.arkarhein.charlesandkeith.R;
import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;
import keith.and.charles.xyz.arkarhein.charlesandkeith.delegates.NewProductDelegate;
import keith.and.charles.xyz.arkarhein.charlesandkeith.viewholders.BaseViewHolder;
import keith.and.charles.xyz.arkarhein.charlesandkeith.viewholders.ItemProductViewHolder;

public class ItemProductAdapter extends BaseRecyclerAdapter<BaseViewHolder, NewProductVO> {
    private NewProductDelegate mNewProductDelegate;

    public ItemProductAdapter(Context context, NewProductDelegate newProductDelegate) {
        super(context);
        mNewProductDelegate = newProductDelegate;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_products, parent, false);
        return new ItemProductViewHolder(view, mNewProductDelegate);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }
}
