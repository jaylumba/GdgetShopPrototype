package jcl.com.gadgetshop.modules.home;

import jcl.com.gadgetshop.base.BasePresenter;
import jcl.com.gadgetshop.data.dao.User;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class HomePresenter extends BasePresenter implements HomeMvp.Presenter{

    private HomeMvp.View mView;
    private HomeInteractor interactor;

    public HomePresenter(HomeMvp.View view){
        mView = view;
        interactor = new HomeInteractor(this);
        attachView(mView);
    }

    @Override
    public void onLoad() {
        mView.initToolbarAndDrawer();
    }

    @Override
    public void displayNameAndProfilePicture(User user) {
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
        interactor.clearLastUser();
        mView.logoutUser();
    }
}
