package jcl.com.gadgetshop.modules.cart;

import java.util.ArrayList;
import java.util.HashMap;

import jcl.com.gadgetshop.base.BasePresenter;
import jcl.com.gadgetshop.data.dao.OrderLine;

/**
 * Created by jayanthony.lumba on 3/9/2017.
 */

public class CartPresenter extends BasePresenter implements CartMvp.Presenter {

    CartMvp.View view;
    CartInteractor interactor;

    public CartPresenter(CartMvp.View view) {
        this.view = view;
        this.interactor = new CartInteractor(this);
        attachView(view);
    }

    @Override
    public void onLoad() {
        view.initToolbar();
        view.initCallbacks();
    }

    @Override
    public void displayCart(HashMap<Long, OrderLine> cart) {
        ArrayList<OrderLine> orderLines = new ArrayList<>();
        for (Long key: cart.keySet()){
            orderLines.add(cart.get(key));
        }
        view.displayCart(orderLines);
    }
}
