package jcl.com.gadgetshop.modules.productdetail;

import jcl.com.gadgetshop.base.BaseMvp;
import jcl.com.gadgetshop.data.dao.Product;

/**
 * Created by jayan on 3/9/2017.
 */

public class ProductDetailMvp {

    interface Interactor{

    }

    interface View extends BaseMvp.View{
        void initToolbar();
        void setProductImage(int picResId);
        void setProductName(String productName);
        void setProductPrice(String productPrice);
        void setScreenSize(String screenSize);
        void setCamera(String camera);
        void setRam(String ram);
        void setBattery(String battery);
        void setStorage(String storage);
        void setOs(String os);
        void setDateReleased(String dateReleased);
    }

    interface Presenter extends BaseMvp.Presenter{
        void onLoad();
        void displayDetails(Product product);
    }

}
