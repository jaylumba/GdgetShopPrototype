package jcl.com.gadgetshop.modules.cart;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.adapters.CartAdapter;
import jcl.com.gadgetshop.base.BaseActivity;
import jcl.com.gadgetshop.callbacks.OnCartItemCallback;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.events.AddProductToCartEvent;
import jcl.com.gadgetshop.events.PostCartEvent;
import jcl.com.gadgetshop.events.RemoveProductToCartEvent;
import jcl.com.gadgetshop.modules.checkout.CheckoutActivity;

public class CartActivity extends BaseActivity implements CartMvp.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_cart)
    RecyclerView rvCart;
    @BindView(R.id.tv_estimated_total)
    TextView tvEstimatedTotal;
    @BindView(R.id.btn_checkout)
    Button btnCheckout;

    CartPresenter presenter;
    OnCartItemCallback callback;
    HashMap<Long, OrderLine> cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);

        presenter = new CartPresenter(this);
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
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initCallbacks() {
        callback = new OnCartItemCallback() {
            @Override
            public void onIncrease(OrderLine orderLine) {
                EventBus.getDefault().postSticky(new AddProductToCartEvent(orderLine));
            }

            @Override
            public void onDecrease(OrderLine orderLine) {
                EventBus.getDefault().postSticky(new RemoveProductToCartEvent(orderLine));
            }

            @Override
            public void onRemove(OrderLine orderLine) {
                EventBus.getDefault().postSticky(new RemoveProductToCartEvent(orderLine));
            }
        };
    }

    @Override
    public void displayCart(ArrayList<OrderLine> orderLines) {
        if (orderLines != null) {
            LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            rvCart.setLayoutManager(lm);
            rvCart.setItemAnimator(new DefaultItemAnimator());
            rvCart.setAdapter(new CartAdapter(this, orderLines, callback));
        }
    }

    @Override
    public void setEstimatedTotal(String estimatedTotal) {
        tvEstimatedTotal.setText(estimatedTotal);
    }

    @Override
    public void disableCheckoutButton() {
        btnCheckout.setEnabled(false);
    }

    @Override
    public void goToCheckoutActivity() {
        moveToOtherActivity(CheckoutActivity.class);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onReceiveCart(PostCartEvent postCartEvent) {
        cart = postCartEvent.getCart();
        EventBus.getDefault().removeStickyEvent(postCartEvent);
        presenter.displayCart(cart);
    }

    @OnClick(R.id.btn_checkout)
    public void onCheckout(){
        presenter.onCheckout();
    }
}
