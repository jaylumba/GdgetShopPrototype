package jcl.com.gadgetshop.modules.login;


import jcl.com.gadgetshop.base.BasePresenter;

public class LoginPresenter extends BasePresenter implements LoginMvp.Presenter {

    LoginMvp.View mView;
    LoginInteractor mInteractor;

    public LoginPresenter(LoginMvp.View mView) {
        this.mView = mView;
        this.mInteractor = new LoginInteractor(this);
        attachView(mView);
    }

    @Override
    public void onViewLoad() {
        mInteractor.retrieveLastUser();
    }

    @Override
    public void requestShowLastUser(String email) {
        mView.showLastUser(email);
    }

    @Override
    public void requestLogin() {
        mView.showLoginLoading();
        if (!mView.getEmail().isEmpty() && !mView.getPassword().isEmpty()) {
            mInteractor.authenticateUser(mView.getEmail(), mView.getPassword());
        } else {
            mView.dismissLoading();
            mView.showIncompleteFieldsError();
        }
    }

    @Override
    public void requestShowLoginSuccess() {
        mView.showLoginSuccess();
    }

    @Override
    public void requestShowInvalidLoginError() {
        mView.showInvalidLoginError();
    }

}
