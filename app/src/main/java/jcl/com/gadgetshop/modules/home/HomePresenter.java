package jcl.com.gadgetshop.modules.home;

import jcl.com.gadgetshop.base.BasePresenter;
import jcl.com.gadgetshop.data.dao.User;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class HomePresenter extends BasePresenter implements HomeMvp.Presenter{

    private HomeMvp.View mView;

    public HomePresenter(HomeMvp.View view){
        mView = view;
        attachView(mView);
    }

    @Override
    public void onLoad(User user) {
        mView.initToolbarAndDrawer();
        mView.displayNameAndProfilePicture(user);
    }

    @Override
    public void onNavTabletClicked() {
        mView.showTablets();
    }

    @Override
    public void onNavMobilePhoneClicked() {
        mView.showMobilePhones();
    }

    @Override
    public void onNavLogoutClicked() {
        mView.logoutUser();
    }
}
