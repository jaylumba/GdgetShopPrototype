package jcl.com.gadgetshop.modules.product;

import java.util.List;

import jcl.com.gadgetshop.base.BasePresenter;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.enums.PRODUCT_CATEGORY;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class ProductPresenter extends BasePresenter implements ProductMvp.Presenter {

    ProductMvp.View view;
    ProductInteractor interactor;

    public ProductPresenter(ProductMvp.View view) {
        this.view = view;
        this.interactor = new ProductInteractor(this);
        attachView(view);
    }

    @Override
    public void onLoad() {
        view.initCallbacks();
    }

    @Override
    public void retrieveProducts(PRODUCT_CATEGORY productCategory) {
        interactor.retrieveProducts(productCategory);
    }

    @Override
    public void displayProducts(List<Product> products) {
        view.displayProducts(products);
    }
}
