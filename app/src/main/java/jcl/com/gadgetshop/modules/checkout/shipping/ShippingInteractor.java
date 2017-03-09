package jcl.com.gadgetshop.modules.checkout.shipping;

/**
 * Created by jayan on 3/10/2017.
 */

public class ShippingInteractor implements ShippingMvp.Interactor {
    ShippingPresenter presenter;

    public ShippingInteractor(ShippingPresenter presenter) {
        this.presenter = presenter;
    }
}
