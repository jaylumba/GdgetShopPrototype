package jcl.com.gadgetshop.modules.checkout;

/**
 * Created by jayan on 3/9/2017.
 */

public class CheckoutInteractor implements CheckoutMvp.Interactor {

    CheckoutPresenter presenter;

    public CheckoutInteractor(CheckoutPresenter presenter) {
        this.presenter = presenter;
    }
}
