package jcl.com.gadgetshop.modules.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseActivity;
import jcl.com.gadgetshop.base.BaseFragment;
import jcl.com.gadgetshop.enums.PRODUCT_CATEGORY;
import jcl.com.gadgetshop.modules.login.LoginActivity;
import jcl.com.gadgetshop.modules.product.ProductFragment;

public class HomeActivity extends BaseActivity implements HomeMvp.View{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private ActionBarDrawerToggle drawerToggle;
    private HomeMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        presenter = new HomePresenter(this);
        setSupportActionBar(toolbar);
        initializeDrawer();

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
        //Release listener resources
        drawerLayout.removeDrawerListener(drawerToggle);
        drawerToggle = null;
    }

    private void initializeDrawer() {
        toolbar.setTitle(getStringFromResource(R.id.nav_laptop));
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
        navView.getMenu().performIdentifierAction(R.id.nav_laptop, 0);
    }

    private void setFragment(final BaseFragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_home, fragment);
        transaction.commit();
    }

    @Override
    public void showLaptops() {
        setFragment(ProductFragment.newInstance(PRODUCT_CATEGORY.LAPTOP));
    }

    @Override
    public void showMobilePhones() {
        setFragment(ProductFragment.newInstance(PRODUCT_CATEGORY.MOBILEPHONE));
    }

    @Override
    public void logoutUser() {
        moveToOtherActivity(LoginActivity.class);
        finish();
    }

    class DrawerItemClickListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(final MenuItem item) {
            drawerLayout.closeDrawers();

            if (!item.isChecked() && item.getItemId() != R.id.nav_logout) {
                item.setChecked(true);
                switch (item.getItemId()) {

                    case R.id.nav_laptop:
                        presenter.onNavLaptopClicked();
                        break;
                    case R.id.nav_cellphone:
                        presenter.onNavMobilePhoneClicked();
                        break;
                }
            } else if (item.getItemId() == R.id.nav_logout) {
                presenter.onNavLogoutClicked();
            }
            return true;
        }
    }
}
