package jcl.com.gadgetshop.modules.home;

import java.util.HashMap;

import jcl.com.gadgetshop.data.DataManager;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.local.SharedPrefHelper;

/**
 * Created by jayan on 3/8/2017.
 */

public class HomeInteractor implements HomeMvp.Interactor {

    SharedPrefHelper sharedPrefHelper;
    HomePresenter presenter;

    public HomeInteractor(HomePresenter presenter){
        this.presenter = presenter;
        sharedPrefHelper = DataManager.getInstance().getSharedPrefHelper();
    }

    @Override
    public void clearLastUser() {
        sharedPrefHelper.saveLastUser("");
    }

    @Override
    public void addProductToCart(OrderLine orderLine) {
        HashMap<Long, OrderLine> cart = presenter.getCart();
        // Check if it already exist on the map
        if (cart.containsKey(orderLine.getProductId())){
            //If yes, just increase the quantity
            //Get the orderline using productId
            OrderLine currentOrderline = cart.get(orderLine.getProductId());
            //Add quantity of the new orderline to the existing quantity. Then set a new quantity.
            currentOrderline.setQuantity(currentOrderline.getQuantity() + orderLine.getQuantity());
            //Set it back to the map.
            cart.put(currentOrderline.getProductId(),currentOrderline);
        }else{
            // If no, add it to the map
            cart.put(orderLine.getProductId(),orderLine);
        }
        presenter.setCart(cart);
    }

    @Override
    public void removeProductToCart(OrderLine orderLine) {
        HashMap<Long, OrderLine> cart = presenter.getCart();
        // Check if it already exist on the cart
        if (cart.containsKey(orderLine.getProductId())){
            OrderLine currentOrderLine = cart.get(orderLine.getProductId());
            if (currentOrderLine.getQuantity() == orderLine.getQuantity()){
                cart.remove(currentOrderLine.getProductId());
            }else{
                //Subtract the quantity of the new orderline to the existing quantity. Then set a new quantity.
                currentOrderLine.setQuantity(currentOrderLine.getQuantity() - orderLine.getQuantity());
                //Set it back to the cart.
                cart.put(currentOrderLine.getProductId(),currentOrderLine);
            }
            presenter.setCart(cart);
        }
    }
}
