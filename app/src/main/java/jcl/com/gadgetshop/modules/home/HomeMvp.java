package jcl.com.gadgetshop.modules.home;

import jcl.com.gadgetshop.base.BaseMvp;
import jcl.com.gadgetshop.data.dao.User;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class HomeMvp {

    interface View extends BaseMvp.View{
        void initToolbarAndDrawer();
        void displayNameAndProfilePicture(User user);
        void showTablets();
        void showMobilePhones();
        void logoutUser();
    }

    interface Presenter extends BaseMvp.Presenter{
        void onLoad(User user);
        void onNavTabletClicked();
        void onNavMobilePhoneClicked();
        void onNavLogoutClicked();
    }
}
