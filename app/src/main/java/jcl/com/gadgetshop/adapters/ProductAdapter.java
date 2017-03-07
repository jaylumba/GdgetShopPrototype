package jcl.com.gadgetshop.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.callbacks.OnAddToCartClick;
import jcl.com.gadgetshop.callbacks.OnListItemClick;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.sinlgetons.PicassoSingleton;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder> {
    List<Product> productList;
    OnAddToCartClick onAddToCartClick;
    OnListItemClick callback;
    Context context;

    class ProductAdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.root_layout)
        RelativeLayout rootLayout;
        @BindView(R.id.iv_product)
        ImageView ivProduct;
        @BindView(R.id.tv_product_name)
        TextView tvProductName;
        @BindView(R.id.tv_product_price)
        TextView tvProductPrice;
        @BindView(R.id.btn_add)
        Button btnAdd;

        public ProductAdapterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }

    public ProductAdapter(List<Product> productList,OnAddToCartClick onAddToCartClick, OnListItemClick callback) {
        this.productList = productList;
        this.onAddToCartClick = onAddToCartClick;
        this.callback = callback;
    }

    @Override
    public ProductAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        int layoutResourceId = R.layout.adapter_product;
        View itemView = LayoutInflater.from(context).inflate(layoutResourceId, parent, false);
        return new ProductAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductAdapterViewHolder holder, int position) {
        if (holder != null) {
            final Product currentItem = productList.get(position);

            PicassoSingleton.getInstance().getPicasso()
                    .load(currentItem.getPicResId())
                    .placeholder(R.drawable.ic_gadgetshop_logo)
                    .into(holder.ivProduct);

            holder.tvProductName.setText(currentItem.getName());
            NumberFormat formatter = new DecimalFormat("#,###.00");
            holder.tvProductPrice.setText("₱" + formatter.format(currentItem.getPrice()));
            holder.btnAdd.setOnClickListener(view -> {
                if (onAddToCartClick != null)
                onAddToCartClick.onAdd(currentItem);
            });

            if (callback != null) {
                holder.rootLayout.setOnClickListener(v -> {
                    if (callback != null)
                    callback.onItemClick(currentItem);
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

}
