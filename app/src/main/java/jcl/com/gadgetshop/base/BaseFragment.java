package jcl.com.gadgetshop.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.util.NetworkUtil;


public abstract class BaseFragment extends Fragment implements BaseMvp.View {
    private ProgressDialog progressDialog;
    private Toast toast;

    @Override
    public boolean isConnected() {
        return NetworkUtil.isConnected(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initProgressDialog();
        return null;
    }

    @Override
    public void showToast(int stringId) {
        if(toast != null){
            toast.cancel();
        }
        toast = Toast.makeText(getActivity(), getStringFromResource(stringId),Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showToast(String message) {
        if(toast != null){
            toast.cancel();
        }
        toast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showLoading() {
        if (progressDialog!= null) progressDialog.show();
    }

    @Override
    public void dismissLoading() {
        if (progressDialog!= null)  progressDialog.hide();
    }

    @Override
    public void setProgressDialogTitle(String title) {
        progressDialog.setTitle(title);
    }

    @Override
    public void setProgressDialogMessage(String message) {
        progressDialog.setMessage(message);
    }

    @Override
    public void setProgressDialogTitle(int stringId) {
        progressDialog.setTitle(getStringFromResource(stringId));
    }

    @Override
    public void setProgressDialogMessage(int stringId) {
        progressDialog.setMessage(getStringFromResource(stringId));
    }

    private void initProgressDialog(){
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("");
        progressDialog.setMessage(getStringFromResource(R.string.all_pleasewait));
        progressDialog.setProgress(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
    }

    protected String getStringFromResource(int stringId){
        return getResources().getString(stringId);
    }

    @Override
    public void showNetworkError() {
        showToast(R.string.all_message_error_noconnection);
    }

    @Override
    public void showServerError() {
        showToast(R.string.all_message_error_servererror);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        progressDialog = null;
    }
}
