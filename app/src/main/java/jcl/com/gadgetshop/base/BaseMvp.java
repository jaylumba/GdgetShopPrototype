package jcl.com.gadgetshop.base;

public interface BaseMvp {

    interface Interactor{

    }

    interface View{
        boolean isConnected();
        void showLoading();
        void dismissLoading();
        void showServerError();
        void showNetworkError();
        void setProgressDialogTitle(String title);
        void setProgressDialogMessage(String message);
        void setProgressDialogTitle(int stringId);
        void setProgressDialogMessage(int stringId);
        void showToast(int stringId);
        void showToast(String message);

    }

    interface Presenter {
        boolean isViewAttached();
        void attachView(BaseMvp.View view);
        void detachView(boolean retainInstance);
        void requestShowLoading();
        void requestDismissLoading();
        void requestShowServerError();
        void requestShowNetworkError();
        void requestShowToast(String message);
        void requestShowToast(int stringId);
    }

}
