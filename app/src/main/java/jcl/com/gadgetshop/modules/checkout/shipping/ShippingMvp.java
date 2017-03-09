package jcl.com.gadgetshop.modules.checkout.shipping;

import jcl.com.gadgetshop.base.BaseMvp;

/**
 * Created by jayan on 3/10/2017.
 */

public class ShippingMvp {

    interface Interactor {

    }

    interface View extends BaseMvp.View {

    }

    interface Presenter extends BaseMvp.Presenter {
        void onLoad();
        void next();
    }

}
