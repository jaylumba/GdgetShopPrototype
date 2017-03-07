package jcl.com.gadgetshop.modules.home;

import jcl.com.gadgetshop.base.BaseMvp;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class HomeMvp {

    interface View extends BaseMvp.View{
        void showLaptops();
        void showMobilePhones();
        void logoutUser();
    }

    interface Presenter extends BaseMvp.Presenter{
        void onNavLaptopClicked();
        void onNavMobilePhoneClicked();
        void onNavLogoutClicked();
    }
}
