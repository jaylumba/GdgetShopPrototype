package jcl.com.gadgetshop.base;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 * Created by jayanthony.lumba on 7/13/2016.
 */
public class BaseDialog implements BaseDialogView {

    protected BaseActivity activity;
    protected Dialog dialog;
    protected View viewLayout;

    @Override
    public void create(BaseActivity activity, int layoutId) {
        this.activity = activity;
        viewLayout = activity.getLayoutInflater().inflate(layoutId, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(viewLayout);
        dialog = builder.create();
    }

    @Override
    public void setCancelable(boolean isCancelable) {
        dialog.setCancelable(isCancelable);
    }

    @Override
    public boolean isConnected() {
        return activity.isConnected();
    }

    @Override
    public void showLoading() {
        activity.showLoading();
    }

    @Override
    public void showDialog() {
        if (dialog != null) dialog.show();
    }

    @Override
    public void dismissLoading() {
        activity.dismissLoading();
    }

    @Override
    public void setProgressDialogTitle(String title) {
        activity.setProgressDialogTitle(title);
    }

    @Override
    public void setProgressDialogMessage(String message) {
        activity.setProgressDialogMessage(message);
    }

    @Override
    public void setProgressDialogTitle(int stringId) {
        activity.setProgressDialogTitle(stringId);
    }

    @Override
    public void setProgressDialogMessage(int stringId) {
        activity.setProgressDialogMessage(stringId);
    }

    @Override
    public void showToast(int stringId) {
        activity.showToast(stringId);
    }

    @Override
    public void showToast(String message) {
        activity.showToast(message);
    }

    @Override
    public void showServerError() {
        activity.showServerError();
    }

    @Override
    public void showNetworkError() {
        activity.showNetworkError();
    }

    @Override
    public void dismissDialog() {
        dialog.dismiss();
    }
}
