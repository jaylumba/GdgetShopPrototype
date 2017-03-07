package jcl.com.gadgetshop.callbacks;

import android.view.View;

import jcl.com.gadgetshop.data.dao.Product;

public interface OnAddToCartClick {
    void onAdd(Product product);
}
