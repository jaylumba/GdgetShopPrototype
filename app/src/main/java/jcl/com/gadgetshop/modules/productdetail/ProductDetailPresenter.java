package jcl.com.gadgetshop.modules.productdetail;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import jcl.com.gadgetshop.base.BasePresenter;
import jcl.com.gadgetshop.data.dao.Product;

/**
 * Created by jayan on 3/9/2017.
 */

public class ProductDetailPresenter extends BasePresenter implements ProductDetailMvp.Presenter{

    ProductDetailMvp.View view;
    ProductDetailInteractor interactor;

    public ProductDetailPresenter(ProductDetailMvp.View view) {
        this.view = view;
        this.interactor = new ProductDetailInteractor(this);
        attachView(view);
    }

    @Override
    public void onLoad() {
        view.initToolbar();
    }

    @Override
    public void displayDetails(Product product) {
        view.setProductImage(product.getPicResId());
        view.setProductName(product.getName());
        NumberFormat formatter = new DecimalFormat("#,###.00");
        view.setProductPrice("₱" + formatter.format(product.getPrice()));
        view.setScreenSize(product.getDisplay());
        view.setCamera(product.getCamera());
        view.setRam(product.getRam());
        view.setBattery(product.getBattery());
        view.setStorage(product.getStorage());
        view.setOs(product.getOs());
        view.setDateReleased(product.getDateRelease());
    }

    @Override
    public void addToCart() {
        interactor.addToCart(view.getProduct());
    }

    @Override
    public void addingSuccessful() {
        view.finishActivity();
        view.showToast("Successfully added!");
    }
}
