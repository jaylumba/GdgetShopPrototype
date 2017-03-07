package jcl.com.gadgetshop.modules.login;

import org.greenrobot.eventbus.EventBus;

import jcl.com.gadgetshop.data.DataManager;
import jcl.com.gadgetshop.data.dao.User;
import jcl.com.gadgetshop.data.dao.UserDao;
import jcl.com.gadgetshop.data.local.DbHelper;
import jcl.com.gadgetshop.data.local.SharedPrefHelper;
import jcl.com.gadgetshop.events.LoginSuccessEvent;

/**
 * Created by jayan on 3/5/2017.
 */

public class LoginInteractor implements LoginMvp.Interactor {

    DbHelper dbHelper;
    SharedPrefHelper sharedPrefHelper;
    LoginPresenter presenter;

    public LoginInteractor(LoginPresenter presenter) {
        this.presenter = presenter;
        dbHelper = DataManager.getInstance().getDbHelper();
        sharedPrefHelper = DataManager.getInstance().getSharedPrefHelper();
    }

    @Override
    public void retrieveLastUser() {
        if (!sharedPrefHelper.getLastUser().isEmpty())
            getLoggedUser(sharedPrefHelper.getLastUser());

    }

    @Override
    public void authenticateUser(String email, String password) {
        User user = dbHelper.newSession().getUserDao().queryBuilder().where(UserDao.Properties.Email.eq(email),
                UserDao.Properties.Password.eq(password)).unique();
        if (user != null){
            sharedPrefHelper.saveLastUser(email);
            postLoginSuccessEvent(new LoginSuccessEvent(user));
            presenter.requestDismissLoading();
        }else{
            presenter.requestShowInvalidLoginError();
            presenter.requestDismissLoading();
        }
    }

    @Override
    public void getLoggedUser(String email) {
        User user = dbHelper.newSession().getUserDao().queryBuilder().where(UserDao.Properties.Email.eq(email)).unique();
        if (user != null){
            postLoginSuccessEvent(new LoginSuccessEvent(user));
        }
    }

    @Override
    public void postLoginSuccessEvent(LoginSuccessEvent loginSuccessEvent) {
        EventBus.getDefault().postSticky(loginSuccessEvent);
        presenter.requestShowLoginSuccess();
    }

}
