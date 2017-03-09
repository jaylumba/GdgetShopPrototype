package jcl.com.gadgetshop.modules.checkout;

import jcl.com.gadgetshop.base.BasePresenter;

/**
 * Created by jayan on 3/9/2017.
 */

public class CheckoutPresenter extends BasePresenter implements CheckoutMvp.Presenter{

    CheckoutMvp.View view;
    CheckoutInteractor interactor;

    public CheckoutPresenter(CheckoutMvp.View view) {
        this.view = view;
        this.interactor = new CheckoutInteractor(this);
        attachView(view);
    }

    @Override
    public void onLoad() {
        view.initToolbar();
    }
}
