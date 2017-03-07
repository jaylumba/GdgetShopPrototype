package jcl.com.gadgetshop.modules.product;

import java.util.List;

import jcl.com.gadgetshop.data.DataManager;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.data.dao.ProductDao;
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
        List<Product> products;
        ProductDao dao = DataManager.getInstance().getDbHelper().newSession().getProductDao();
        products = dao.queryBuilder()
                .where(ProductDao.Properties.Category.eq(productCategory.toString()))
                .list();
        presenter.displayProducts(products);
    }
}
