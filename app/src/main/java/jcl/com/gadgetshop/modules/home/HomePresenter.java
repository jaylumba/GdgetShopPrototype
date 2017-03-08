package jcl.com.gadgetshop.modules.home;

import jcl.com.gadgetshop.base.BasePresenter;
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
}
