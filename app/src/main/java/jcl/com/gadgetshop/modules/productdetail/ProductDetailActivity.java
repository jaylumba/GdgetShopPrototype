package jcl.com.gadgetshop.modules.productdetail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseActivity;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.events.PostProductToCartEvent;
import jcl.com.gadgetshop.sinlgetons.PicassoSingleton;

public class ProductDetailActivity extends BaseActivity implements ProductDetailMvp.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    ProductDetailPresenter presenter;
    @BindView(R.id.iv_product)
    ImageView ivProduct;
    @BindView(R.id.tv_product_name)
    TextView tvProductName;
    @BindView(R.id.tv_product_price)
    TextView tvProductPrice;
    @BindView(R.id.tv_screen_size)
    TextView tvScreenSize;
    @BindView(R.id.tv_camera)
    TextView tvCamera;
    @BindView(R.id.tv_ram)
    TextView tvRam;
    @BindView(R.id.tv_battery)
    TextView tvBattery;
    @BindView(R.id.tv_storage)
    TextView tvStorage;
    @BindView(R.id.tv_os)
    TextView tvOs;
    @BindView(R.id.tv_released_date)
    TextView tvReleasedDate;

    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);

        presenter = new ProductDetailPresenter(this);
        presenter.onLoad();

        EventBus.getDefault().register(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finishActivity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (product != null && presenter != null) presenter.displayDetails(product);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Product Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public void setProductImage(int picResId) {
        PicassoSingleton.getInstance().getPicasso()
                .load(picResId)
                .placeholder(R.drawable.ic_gadgetshop_logo)
                .into(ivProduct);
    }

    @Override
    public void setProductName(String productName) {
        tvProductName.setText(productName);
    }

    @Override
    public void setProductPrice(String productPrice) {
        tvProductPrice.setText(productPrice);
    }

    @Override
    public void setScreenSize(String screenSize) {
        tvScreenSize.setText(screenSize);
    }

    @Override
    public void setCamera(String camera) {
        tvCamera.setText(camera);
    }

    @Override
    public void setRam(String ram) {
        tvRam.setText(ram);
    }

    @Override
    public void setBattery(String battery) {
        tvBattery.setText(battery);
    }

    @Override
    public void setStorage(String storage) {
        tvStorage.setText(storage);
    }

    @Override
    public void setOs(String os) {
        tvOs.setText(os);
    }

    @Override
    public void setDateReleased(String dateReleased) {
        tvReleasedDate.setText(dateReleased);
    }

    @Override
    @OnClick(R.id.btn_add)
    public void addToCart() {
        presenter.addToCart();
    }

    @Override
    public void finishActivity() {
        finish();
        animateToRight(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onReceiveProductDetail(PostProductToCartEvent postProductEvent){
        product = postProductEvent.getProduct();
        EventBus.getDefault().removeStickyEvent(postProductEvent);
        presenter.displayDetails(product);
    }

}
