package jcl.com.gadgetshop.modules.productdetail;

import org.greenrobot.eventbus.EventBus;

import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.events.AddProductToCartEvent;

/**
 * Created by jayan on 3/9/2017.
 */

public class ProductDetailInteractor implements ProductDetailMvp.Interactor {

    ProductDetailPresenter presenter;

    public ProductDetailInteractor(ProductDetailPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addToCart(Product product) {
        OrderLine orderLine = new OrderLine();
        orderLine.setProductId(product.getId());
        orderLine.setQuantity(1);
        EventBus.getDefault().postSticky(new AddProductToCartEvent(orderLine));
        presenter.addingSuccessful();
    }
}
