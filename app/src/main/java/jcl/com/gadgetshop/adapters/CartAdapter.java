package jcl.com.gadgetshop.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.callbacks.OnCartItemCallback;
import jcl.com.gadgetshop.data.DataManager;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.data.dao.ProductDao;
import jcl.com.gadgetshop.sinlgetons.PicassoSingleton;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    List<OrderLine> orderLines;
    Context context;
    OnCartItemCallback callback;
    Activity activity;

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.root_layout)
        RelativeLayout rootLayout;
        @BindView(R.id.iv_product)
        ImageView ivProduct;
        @BindView(R.id.tv_product_name)
        TextView tvProductName;
        @BindView(R.id.tv_product_price)
        TextView tvProductPrice;
        @BindView(R.id.tv_qty)
        TextView tvQty;
        @BindView(R.id.btn_add_qty)
        ImageButton btnAddQty;
        @BindView(R.id.btn_minus_qty)
        ImageButton btnMinusQty;
        @BindView(R.id.btn_remove)
        ImageButton btnRemove;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }

    public CartAdapter(Activity activity, List<OrderLine> orderLines, OnCartItemCallback callback) {
        this.activity = activity;
        this.orderLines = orderLines;
        this.callback = callback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        int layoutResourceId = R.layout.adapter_product_on_cart;
        View itemView = LayoutInflater.from(context).inflate(layoutResourceId, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder != null) {
            final OrderLine currentItem = orderLines.get(position);
            Product product = DataManager.getInstance().getDbHelper().newSession()
                    .getProductDao().queryBuilder()
                    .where(ProductDao.Properties.Id.eq(currentItem.getProductId()))
                    .unique();
            PicassoSingleton.getInstance().getPicasso()
                    .load(product.getPicResId())
                    .placeholder(R.drawable.ic_gadgetshop_logo)
                    .into(holder.ivProduct);

            holder.tvProductName.setText(product.getName());
            NumberFormat formatter = new DecimalFormat("#,###.00");
            holder.tvProductPrice.setText("₱" + formatter.format(product.getPrice()));
            holder.tvQty.setText(String.valueOf(currentItem.getQuantity()));
            holder.btnAddQty.setOnClickListener(view -> {
                if (callback != null) {
                    OrderLine orderLine = new OrderLine();
                    orderLine.setProductId(currentItem.getProductId());
                    orderLine.setQuantity(1);
                    callback.onIncrease(orderLine);
                }
            });
            holder.btnMinusQty.setOnClickListener(view -> {
                if (callback != null) {
                    if (currentItem.getQuantity() > 1) {
                        OrderLine orderLine = new OrderLine();
                        orderLine.setProductId(currentItem.getProductId());
                        orderLine.setQuantity(1);
                        callback.onDecrease(orderLine);
                    }
                }
            });
            holder.btnRemove.setOnClickListener(view -> {
                if (callback != null)
                    callback.onRemove(currentItem);
            });
        }
    }

    @Override
    public int getItemCount() {
        return orderLines.size();
    }

}
