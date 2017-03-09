package jcl.com.gadgetshop.modules.checkout;

import jcl.com.gadgetshop.base.BaseMvp;

/**
 * Created by jayan on 3/9/2017.
 */

public class CheckoutMvp {

    interface Interactor{

    }

    interface View extends BaseMvp.View{
        void initToolbar();
    }

    interface Presenter extends BaseMvp.Presenter{
        void onLoad();
    }

}
