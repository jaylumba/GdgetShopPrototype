package jcl.com.gadgetshop.modules.product;

import java.util.ArrayList;

import jcl.com.gadgetshop.base.BasePresenter;
import jcl.com.gadgetshop.data.dao.Product;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class ProductPresenter extends BasePresenter implements ProductMvp.Presenter {

    ProductMvp.View mView;
    ProductInteractor mInteractor;

    public ProductPresenter(ProductMvp.View mView) {
        this.mView = mView;
        this.mInteractor = new ProductInteractor(this);
        attachView(mView);
    }

    @Override
    public void displayProducts(ArrayList<Product> products) {
        mView.displayProducts(products);
    }
}
