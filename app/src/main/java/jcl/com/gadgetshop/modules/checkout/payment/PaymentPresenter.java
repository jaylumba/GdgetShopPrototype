package jcl.com.gadgetshop.modules.checkout.payment;

import org.greenrobot.eventbus.EventBus;

import jcl.com.gadgetshop.base.BaseMvp;
import jcl.com.gadgetshop.base.BasePresenter;
import jcl.com.gadgetshop.events.OnNextEvent;

/**
 * Created by jayanthony.lumba on 3/10/2017.
 */

public class PaymentPresenter extends BasePresenter implements PaymentMvp.Presenter {

    PaymentMvp.View view;
    PaymentInteractor interactor;

    public PaymentPresenter(PaymentMvp.View view){
        this.view = view;
        interactor = new PaymentInteractor(this);
        attachView(view);
    }


    @Override
    public void onLoad() {
        view.initViews();
    }

    @Override
    public void next() {
        if (view.getCardholdersName().isEmpty() || view.getCreditCardNumber().isEmpty() || view.getExpiryDate().isEmpty()
                || view.getCvv().isEmpty())
            view.showToast("Please complete all required fields!");
        else
            EventBus.getDefault().postSticky(new OnNextEvent());
    }
}
