package jcl.com.gadgetshop.modules.product;

import java.util.ArrayList;

import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.enums.PRODUCT_CATEGORY;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class ProductInteractor implements ProductMvp.Interactor {

    ProductPresenter presenter;

    public ProductInteractor(ProductPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void retrieveProducts(PRODUCT_CATEGORY productCategory) {
        ArrayList<Product> products = new ArrayList<>();
        presenter.displayProducts(products);
    }
}
