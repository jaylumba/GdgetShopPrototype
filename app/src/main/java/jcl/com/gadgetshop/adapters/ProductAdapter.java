package jcl.com.gadgetshop.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
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
import jcl.com.gadgetshop.callbacks.OnListItemClickWithSharedElement;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.sinlgetons.PicassoSingleton;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder> {
    List<Product> productList;
    OnAddToCartClick onAddToCartClick;
    OnListItemClickWithSharedElement callback;
    Context context;
    Activity activity;

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

    public ProductAdapter(Activity activity, List<Product> productList, OnAddToCartClick onAddToCartClick, OnListItemClickWithSharedElement callback) {
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
                    if (callback != null) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            Pair<View, String> v1 = Pair.create((View) holder.ivProduct, holder.ivProduct.getTransitionName());
                            Pair<View, String> v2 = Pair.create((View) holder.tvProductName, holder.tvProductName.getTransitionName());
                            Pair<View, String> v3 = Pair.create((View) holder.tvProductPrice, holder.tvProductPrice.getTransitionName());
                            Pair<View, String> v4 = Pair.create((View) holder.btnAdd, holder.btnAdd.getTransitionName());
                            ActivityOptionsCompat options = ActivityOptionsCompat.
                                    makeSceneTransitionAnimation(activity, v1,v2,v3,v4);
                            callback.onItemClick(currentItem, position, options);
                        } else {
                            callback.onItemClick(currentItem, position, null);
                        }
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

}
