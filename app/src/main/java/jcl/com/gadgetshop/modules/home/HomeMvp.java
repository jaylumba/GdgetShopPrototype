package jcl.com.gadgetshop.modules.home;

import java.util.ArrayList;
import java.util.HashMap;

import jcl.com.gadgetshop.base.BaseMvp;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.User;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class HomeMvp {

    interface Interactor{
        void clearLastUser();
        void addProductToCart(OrderLine orderLine);
        void removeProductToCart(OrderLine orderLine);
    }

    interface View extends BaseMvp.View{
        void initToolbarAndDrawer();
        void displayNameAndProfilePicture(User user);
        void showTablets();
        void showMobilePhones();
        HashMap<Long,OrderLine> getCart();
        void setCart(HashMap<Long,OrderLine> cart);
        void setBadgeCount();
        void logoutUser();
    }

    interface Presenter extends BaseMvp.Presenter{
        void onLoad();
        void displayNameAndProfilePicture(User user);
        void onNavTabletClicked();
        void onNavMobilePhoneClicked();
        void onNavLogoutClicked();
        void addProductToCart(OrderLine orderLine);
        void removeProductToCart(OrderLine orderLine);
        HashMap<Long,OrderLine> getCart();
        void setCart(HashMap<Long,OrderLine> cart);
        int getProductCountOnCart();
    }
}
