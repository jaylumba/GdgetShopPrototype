package jcl.com.gadgetshop.modules.home;

import jcl.com.gadgetshop.base.BasePresenter;

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
    public void onNavLaptopClicked() {
        mView.showLaptops();
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
