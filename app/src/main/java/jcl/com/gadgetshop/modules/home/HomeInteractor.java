package jcl.com.gadgetshop.modules.home;

import jcl.com.gadgetshop.data.DataManager;
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
}
