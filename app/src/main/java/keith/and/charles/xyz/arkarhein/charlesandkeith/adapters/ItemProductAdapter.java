package keith.and.charles.xyz.arkarhein.charlesandkeith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import keith.and.charles.xyz.arkarhein.charlesandkeith.R;
import keith.and.charles.xyz.arkarhein.charlesandkeith.viewholders.ItemProductViewHolder;

public class ItemProductAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemProductView = inflater.inflate(R.layout.item_products, parent, false);
        ItemProductViewHolder itemProductViewHolder = new ItemProductViewHolder(itemProductView);
        return itemProductViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
