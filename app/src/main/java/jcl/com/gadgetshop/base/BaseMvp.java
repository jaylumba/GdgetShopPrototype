package jcl.com.gadgetshop.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

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
        void moveToOtherActivity(Class clz);
        void moveToOtherActivity(Class clz, Bundle bundle);
        void moveToOtherActivityWithSharedElements(Class clz, android.view.View view, String transitionName);
        void moveToOtherActivityWithSharedElements(Class clz, ActivityOptionsCompat options);
        void finishActivity();
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
