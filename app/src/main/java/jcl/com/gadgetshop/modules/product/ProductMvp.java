package jcl.com.gadgetshop.modules.product;

import java.util.ArrayList;

import jcl.com.gadgetshop.base.BaseMvp;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.enums.PRODUCT_CATEGORY;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class ProductMvp {
    interface Interactor{
        void retrieveProducts(PRODUCT_CATEGORY productCategory);
    }

    interface View extends BaseMvp.View{
        void displayProducts(ArrayList<Product> products);
    }

    interface Presenter extends BaseMvp.Presenter{
        void displayProducts(ArrayList<Product> products);
    }
}
