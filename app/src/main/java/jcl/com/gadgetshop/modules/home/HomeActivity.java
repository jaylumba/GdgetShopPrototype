package jcl.com.gadgetshop.modules.home;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseActivity;
import jcl.com.gadgetshop.base.BaseFragment;
import jcl.com.gadgetshop.data.dao.User;
import jcl.com.gadgetshop.enums.PRODUCT_CATEGORY;
import jcl.com.gadgetshop.events.LoginSuccessEvent;
import jcl.com.gadgetshop.modules.login.LoginActivity;
import jcl.com.gadgetshop.modules.product.ProductFragment;
import jcl.com.gadgetshop.sinlgetons.PicassoSingleton;
import jcl.com.gadgetshop.transforms.CircleTransform;

public class HomeActivity extends BaseActivity implements HomeMvp.View{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    //Views from navigation view
    ImageView ivProfilePic;
    TextView tvName;

    private ActionBarDrawerToggle drawerToggle;
    private HomeMvp.Presenter presenter;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        presenter = new HomePresenter(this);
        presenter.onLoad();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        //Release listener resources
        drawerLayout.removeDrawerListener(drawerToggle);
        drawerToggle = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cart, menu);

        //Change icon color to white
        for (int i = 0; i < menu.size(); i++) {
            Drawable drawable = menu.getItem(i).getIcon();
            if (drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);
            }
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_cart:
                showToast("Display Cart");
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public void initToolbarAndDrawer() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(getStringFromResource(R.id.nav_cellphone));
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navView.setNavigationItemSelectedListener(new DrawerItemClickListener());
        navView.getMenu().performIdentifierAction(R.id.nav_cellphone, 0);

        View header = navView.getHeaderView(0);
        tvName = ButterKnife.findById(header, R.id.tv_name);
        ivProfilePic = ButterKnife.findById(header, R.id.iv_profile_pic);
    }



    @Override
    public void displayNameAndProfilePicture(User user) {
        int picId;
        tvName.setText(user.getName());
        if (user.getEmail().equals("jay@gmail.com")) picId = R.drawable.sample_profile_pic;
        else picId = R.drawable.ic_gadgetshop_logo;
        PicassoSingleton.getInstance().getPicasso()
                .load(picId)
                .fit()
                .transform(new CircleTransform())
                .placeholder(R.drawable.ic_gadgetshop_logo)
                .into(ivProfilePic);
    }

    @Override
    public void showTablets() {
        setFragment(ProductFragment.newInstance(PRODUCT_CATEGORY.TABLET));
    }

    @Override
    public void showMobilePhones() {
        setFragment(ProductFragment.newInstance(PRODUCT_CATEGORY.PHONES));
    }

    @Override
    public void logoutUser() {
        moveToOtherActivity(LoginActivity.class);
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onLoginSuccess(LoginSuccessEvent loginSuccessEvent){
        user = loginSuccessEvent.getUser();
        EventBus.getDefault().removeStickyEvent(loginSuccessEvent);
        presenter.displayNameAndProfilePicture(user);
    }

    private void setFragment(final BaseFragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_home, fragment);
        transaction.commit();
    }

    class DrawerItemClickListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(final MenuItem item) {
            drawerLayout.closeDrawers();

            if (!item.isChecked() && item.getItemId() != R.id.nav_logout) {
                item.setChecked(true);
                switch (item.getItemId()) {
                    case R.id.nav_cellphone:
                        presenter.onNavMobilePhoneClicked();
                        break;

                    case R.id.nav_tablet:
                        presenter.onNavTabletClicked();
                        break;
                }
            } else if (item.getItemId() == R.id.nav_logout) {
                presenter.onNavLogoutClicked();
            }
            return true;
        }
    }
}
