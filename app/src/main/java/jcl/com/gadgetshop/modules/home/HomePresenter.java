package jcl.com.gadgetshop.modules.home;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jcl.com.gadgetshop.base.BasePresenter;
import jcl.com.gadgetshop.data.dao.Order;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.User;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class HomePresenter extends BasePresenter implements HomeMvp.Presenter{

    private HomeMvp.View view;
    private HomeInteractor interactor;

    public HomePresenter(HomeMvp.View view){
        this.view = view;
        this.interactor = new HomeInteractor(this);
        attachView(view);
    }

    @Override
    public void onLoad() {
        view.initToolbarAndDrawer();
    }

    @Override
    public void displayNameAndProfilePicture(User user) {
        view.displayNameAndProfilePicture(user);
    }

    @Override
    public void onNavTabletClicked() {
        view.showTablets();
    }

    @Override
    public void onNavMobilePhoneClicked() {
        view.showMobilePhones();
    }

    @Override
    public void onNavLogoutClicked() {
        interactor.clearLastUser();
        view.logoutUser();
    }

    @Override
    public void addProductToCart(OrderLine orderLine) {
        interactor.addProductToCart(orderLine);
    }

    @Override
    public void removeProductToCart(OrderLine orderLine) {
        interactor.removeProductToCart(orderLine);
    }

    @Override
    public HashMap<Long, OrderLine> getCart() {
        return view.getCart();
    }

    @Override
    public void setCart(HashMap<Long, OrderLine> cart) {
        view.setCart(cart);
        view.setBadgeCount();
    }

    @Override
    public int getProductCountOnCart() {
        int count = 0;
        for (Long key : view.getCart().keySet()) {
            count += view.getCart().get(key).getQuantity();
        }
        return count;
    }
}
