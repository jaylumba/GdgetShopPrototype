package jcl.com.gadgetshop.modules.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jcl.com.gadgetshop.base.BaseMvp;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.Product;

/**
 * Created by jayan on 3/9/2017.
 */

public class CartMvp {

    interface Interactor{
        void increaseQty(Product product);
        void decreaseQty(Product product);
        void removeOrderLine(OrderLine orderLine);
    }

    interface View extends BaseMvp.View{
        void initToolbar();
        void initCallbacks();
        void displayCart(ArrayList<OrderLine> orderLines);
        void setEstimatedTotal(String estimatedTotal);
    }

    interface Presenter extends BaseMvp.Presenter{
        void onLoad();
        void displayCart(HashMap<Long,OrderLine> cart);
    }

}
