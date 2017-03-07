package jcl.com.gadgetshop.modules.product;

import java.util.ArrayList;
import java.util.List;

import jcl.com.gadgetshop.base.BasePresenter;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.enums.PRODUCT_CATEGORY;

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
    public void retrieveProducts(PRODUCT_CATEGORY productCategory) {
        mInteractor.retrieveProducts(productCategory);
    }

    @Override
    public void displayProducts(List<Product> products) {
        mView.displayProducts(products);
    }
}
