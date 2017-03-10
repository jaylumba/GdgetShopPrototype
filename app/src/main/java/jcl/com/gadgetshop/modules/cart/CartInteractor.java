package jcl.com.gadgetshop.modules.cart;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import jcl.com.gadgetshop.data.DataManager;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.data.local.SharedPrefHelper;
import jcl.com.gadgetshop.events.PostCartToCheckoutEvent;

/**
 * Created by jayanthony.lumba on 3/9/2017.
 */

public class CartInteractor implements CartMvp.Interactor {

    CartPresenter presenter;

    public CartInteractor(CartPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void postCartToCheckout(ArrayList<OrderLine> orderLines) {
        EventBus.getDefault().postSticky(new PostCartToCheckoutEvent(orderLines));
    }
}
