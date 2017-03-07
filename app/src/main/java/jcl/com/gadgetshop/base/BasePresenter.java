package jcl.com.gadgetshop.base;

public class BasePresenter implements BaseMvp.Presenter{

    BaseMvp.View mView;

    @Override
    public boolean isViewAttached() {
        return mView != null;
    }

    @Override
    public void attachView(BaseMvp.View view) {
        mView = view;
    }

    @Override
    public void detachView(boolean retainInstance) {
        mView = null;
    }

    @Override
    public void requestShowLoading() {
        mView.showLoading();
    }

    @Override
    public void requestDismissLoading() {
        mView.dismissLoading();
    }

    @Override
    public void requestShowServerError() {
        mView.showServerError();
    }

    @Override
    public void requestShowNetworkError() {
        mView.showNetworkError();
    }

    @Override
    public void requestShowToast(String message) {
        mView.showToast(message);
    }

    @Override
    public void requestShowToast(int stringId) {
        mView.showToast(stringId);
    }
}
