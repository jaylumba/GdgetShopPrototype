package jcl.com.gadgetshop.modules.cart;

import jcl.com.gadgetshop.data.DataManager;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.data.local.SharedPrefHelper;

/**
 * Created by jayanthony.lumba on 3/9/2017.
 */

public class CartInteractor implements CartMvp.Interactor {

    CartPresenter presenter;

    public CartInteractor(CartPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void increaseQty(Product product) {

    }

    @Override
    public void decreaseQty(Product product) {

    }

    @Override
    public void removeOrderLine(OrderLine orderLine) {

    }
}
