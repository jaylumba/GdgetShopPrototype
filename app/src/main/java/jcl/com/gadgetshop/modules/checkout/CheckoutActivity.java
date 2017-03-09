package jcl.com.gadgetshop.modules.checkout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ViewSwitcher;

import com.github.fcannizzaro.materialstepper.AbstractStep;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseTabStepperActivity;
import jcl.com.gadgetshop.events.OnNextEvent;
import jcl.com.gadgetshop.events.OnPreviousEvent;
import jcl.com.gadgetshop.modules.checkout.payment.PaymentFragment;
import jcl.com.gadgetshop.modules.checkout.shipping.ShippingFragment;

public class CheckoutActivity extends BaseTabStepperActivity implements CheckoutMvp.View {

    CheckoutPresenter presenter;
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean linear = getIntent().getBooleanExtra("linear", false);

        setErrorTimeout(1500);
        setLinear(linear);
        setTitle("Checkout");
        setAlternativeTab(false);
        setDisabledTouch();
        setPreviousVisible();

        addStep(createFragment(ShippingFragment.newInstance()));
        addStep(createFragment(PaymentFragment.newInstance()));
        addStep(createFragment(ShippingFragment.newInstance()));

        super.onCreate(savedInstanceState);

        presenter = new CheckoutPresenter(this);
        presenter.onLoad();

        EventBus.getDefault().register(this);

    }

    private AbstractStep createFragment(AbstractStep fragment) {
        Bundle b = new Bundle();
        b.putInt("position", i++);
        fragment.setArguments(b);
        return fragment;
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
    public void initToolbar() {
        setSupportActionBar(getToolbar());
        getSupportActionBar().setTitle("Checkout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ViewSwitcher stepSwitcher = (ViewSwitcher) findViewById(R.id.stepSwitcher);
        stepSwitcher.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onComplete() {
        super.onComplete();
        showToast("Completed");
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void moveNext(OnNextEvent onNextEvent){
        EventBus.getDefault().removeStickyEvent(onNextEvent);
        this.onClick(null);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void movePrevious(OnPreviousEvent onPreviousEvent){
        EventBus.getDefault().removeStickyEvent(onPreviousEvent);
        this.onPrevious();
    }

}
