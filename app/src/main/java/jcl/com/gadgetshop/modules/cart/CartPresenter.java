package jcl.com.gadgetshop.modules.cart;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

import jcl.com.gadgetshop.base.BasePresenter;
import jcl.com.gadgetshop.data.DataManager;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.data.dao.ProductDao;

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
        double price = 0.0;
        ArrayList<OrderLine> orderLines = new ArrayList<>();
        for (Long key: cart.keySet()){
            orderLines.add(cart.get(key));

            Product product = DataManager.getInstance().getDbHelper().newSession().getProductDao()
                    .queryBuilder()
                    .where(ProductDao.Properties.Id.eq(cart.get(key).getProductId()))
                    .unique();
            price += product.getPrice() * cart.get(key).getQuantity();
        }
        view.displayCart(orderLines);

        NumberFormat formatter = new DecimalFormat("#,###.00");
        view.setEstimatedTotal("₱" + formatter.format(price));

        if (cart.size() == 0) view.disableCheckoutButton();
        
    }

    @Override
    public void onCheckout() {
        view.goToCheckoutActivity();
    }
}
