package jcl.com.gadgetshop.modules.login;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseActivity;
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
        etEmail.setText(email);
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

