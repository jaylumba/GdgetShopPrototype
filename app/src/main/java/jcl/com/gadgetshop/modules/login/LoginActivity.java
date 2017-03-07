package jcl.com.gadgetshop.modules.login;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseActivity;
import jcl.com.gadgetshop.data.DataManager;
import jcl.com.gadgetshop.data.dao.User;
import jcl.com.gadgetshop.data.dao.UserDao;
import jcl.com.gadgetshop.modules.home.HomeActivity;
import jcl.com.gadgetshop.util.PermissionUtil;

public class LoginActivity extends BaseActivity implements LoginMvp.View {

    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_tagline)
    TextView tvTagline;
    @BindView(R.id.et_emailadd)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_fb)
    Button btnFb;

    LoginPresenter presenter;

    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);
        presenter.onViewLoad();

        if (Build.VERSION.SDK_INT >= 23) {
            PermissionUtil.setupPermissions(this);
        }

        userDao = DataManager.getInstance().getDbHelper().newSession().getUserDao();
        if (DataManager.getInstance().getSharedPrefHelper().isFirstLaunced()){
            User user = new User();
            user.setEmail("jay@gmail.com");
            user.setPassword("pass");
            user.setName("Jay Anthony Lumba");
            userDao.insertOrReplace(user);
            DataManager.getInstance().getSharedPrefHelper().saveFirstLaunched(false);
        }

    }

    @Override
    public String getEmail() {
        return etEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    @OnClick(R.id.btn_login)
    public void onLoginClicked() {
        presenter.requestLogin();
    }

    @OnClick(R.id.btn_fb)
    public void onFbClicked() {
        showToast("This is for design purpose only. Feature not implemented.");
    }

    @Override
    public void showLastUser(String email) {
        if (email != null) {
            if (etEmail != null) {
                etEmail.setText(email);
            }else{
                Log.i("LoginActivity","NULL EMAIL VIEW");
            }
        }
    }

    @Override
    public void showLoginLoading() {
        showLoading();
        setProgressDialogMessage(R.string.login_msg_authenticating);
    }

    @Override
    public void showLoginSuccess() {
        moveToOtherActivity(HomeActivity.class);
        finish();
    }

    @Override
    public void showIncompleteFieldsError() {
        showToast(R.string.all_message_error_requiredfield);
    }

    @Override
    public void showInvalidLoginError() {
        showToast(R.string.login_invalid);
    }
}

