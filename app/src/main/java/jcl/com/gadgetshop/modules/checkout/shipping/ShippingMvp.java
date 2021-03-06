package jcl.com.gadgetshop.modules.checkout.shipping;

import jcl.com.gadgetshop.base.BaseMvp;
import jcl.com.gadgetshop.data.dao.ShippingInfo;

/**
 * Created by jayan on 3/10/2017.
 */

public class ShippingMvp {

    interface Interactor {
        void postShippingInfo(ShippingInfo shippingInfo);
    }

    interface View extends BaseMvp.View {
        void initViews();
        String getFullname();
        String getAddress();
        String getContactNumber();
    }

    interface Presenter extends BaseMvp.Presenter {
        void onLoad();
        void next();
    }

}
