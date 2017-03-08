package jcl.com.gadgetshop.modules.login;


import jcl.com.gadgetshop.base.BasePresenter;

public class LoginPresenter extends BasePresenter implements LoginMvp.Presenter {

    LoginMvp.View view;
    LoginInteractor interactor;

    public LoginPresenter(LoginMvp.View view) {
        this.view = view;
        this.interactor = new LoginInteractor(this);
        attachView(view);
    }

    @Override
    public void onViewLoad() {
        interactor.retrieveLastUser();
    }

    @Override
    public void requestShowLastUser(String email) {
        view.showLastUser(email);
    }

    @Override
    public void requestLogin() {
        view.showLoginLoading();
        if (!view.getEmail().isEmpty() && !view.getPassword().isEmpty()) {
            interactor.authenticateUser(view.getEmail(), view.getPassword());
        } else {
            view.dismissLoading();
            view.showIncompleteFieldsError();
        }
    }

    @Override
    public void requestShowLoginSuccess() {
        view.showLoginSuccess();
    }

    @Override
    public void requestShowInvalidLoginError() {
        view.showInvalidLoginError();
    }

}
