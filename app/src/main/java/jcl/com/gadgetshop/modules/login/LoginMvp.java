package jcl.com.gadgetshop.modules.login;

import jcl.com.gadgetshop.base.BaseMvp;
import jcl.com.gadgetshop.events.LoginSuccessEvent;

/**
 * Created by jayan on 3/5/2017.
 */

public interface LoginMvp {

    interface Interactor{
        void retrieveLastUser();
        void authenticateUser(String email, String password);
        void postLoginSuccessEvent(LoginSuccessEvent loginSuccessEvent);
    }

    interface View extends BaseMvp.View{
        String getEmail();
        String getPassword();
        void onLoginClicked();

        void showLastUser(String email);
        void showLoginLoading();
        void showLoginSuccess();

        void showIncompleteFieldsError();
        void showInvalidLoginError();
    }

    interface Presenter extends  BaseMvp.Presenter{
        void onViewLoad();
        void requestShowLastUser(String email);
        void requestLogin();
        void requestShowLoginSuccess();

        void requestShowInvalidLoginError();
    }

}
