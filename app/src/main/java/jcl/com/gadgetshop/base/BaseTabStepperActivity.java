package jcl.com.gadgetshop.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.github.fcannizzaro.materialstepper.style.TabStepper;

import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.util.NetworkUtil;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public abstract class BaseTabStepperActivity extends TabStepper implements BaseMvp.View {
    private ProgressDialog progressDialog;
    private Toast toast;
    private static Context contextStatic;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public boolean isConnected() {
        return NetworkUtil.isConnected(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initProgressDialog();
        contextStatic = this;
    }

    @Override
    public void showToast(int stringId) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getApplicationContext(), getStringFromResource(stringId), Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showToast(String message) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void dismissLoading() {
        progressDialog.hide();
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

    private void initProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("");
        progressDialog.setMessage(getStringFromResource(R.string.all_pleasewait));
        progressDialog.setProgress(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
    }

    protected String getStringFromResource(int stringId) {
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
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (progressDialog != null) progressDialog.cancel();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private void animateToLeft(Activity activity) {
        activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    private void animateToRight(Activity activity) {
        activity.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override
    public void moveToOtherActivity(Class clz) {
        startActivity(new Intent(this, clz));
        animateToLeft(this);
    }

    @Override
    public void moveToOtherActivity(Class clz, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
        animateToLeft(this);
    }

    @Override
    public void moveToOtherActivityWithSharedElements(Class clz, View view, String transitionName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(this, (View) view, transitionName);
            startActivity(new Intent(this, clz), options.toBundle());
        } else {
            startActivity(new Intent(this, clz));
        }
    }

    @Override
    public void moveToOtherActivityWithSharedElements(Class clz, ActivityOptionsCompat options) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(new Intent(this, clz), options.toBundle());
        } else {
            startActivity(new Intent(this, clz));
        }
    }

//    public static void displayIdleDialog(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(contextStatic);
//        builder.setTitle("Session Timeout")
//                .setMessage("You have been logged out due to inactivity.")
//                .setCancelable(false)
//                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.dismiss();
//                        Intent intent = new Intent(contextStatic, LoginActivity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        contextStatic.startActivity(intent);
//                    }
//                });
//        AlertDialog alert = builder.create();
//        alert.show();
//    }

    @Override
    public void finishActivity() {
        finish();
        animateToRight(this);
    }
}
