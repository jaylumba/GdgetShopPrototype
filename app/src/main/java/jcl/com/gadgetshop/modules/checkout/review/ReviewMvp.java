package jcl.com.gadgetshop.modules.checkout.review;

import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseMvp;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.PaymentInfo;
import jcl.com.gadgetshop.data.dao.ShippingInfo;

/**
 * Created by jayanthony.lumba on 3/10/2017.
 */

public class ReviewMvp {

    interface Interactor{
        void postPlaceOrder();
        void postBackAction();
    }

    interface View extends BaseMvp.View{
        void setSubTotal(String subTotal);
        void setShippingFee(String shippingFee);
        void setTotal(String total);
        void setShipTo(String name);
        void setAddress(String address);
        void setContactNumber(String contactNumber);
        void displayItems(ArrayList<OrderLine> orderLines);

    }

    interface Presenter extends BaseMvp.Presenter{
        void displayShippingInfo(ShippingInfo shippingInfo);
        void displayItems(ArrayList<OrderLine> orderLines);
        void next();
        void back();
    }

}
