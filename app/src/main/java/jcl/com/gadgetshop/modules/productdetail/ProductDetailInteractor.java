package jcl.com.gadgetshop.modules.productdetail;

/**
 * Created by jayan on 3/9/2017.
 */

public class ProductDetailInteractor implements ProductDetailMvp.Interactor {

    ProductDetailPresenter presenter;

    public ProductDetailInteractor(ProductDetailPresenter presenter) {
        this.presenter = presenter;
    }

}
