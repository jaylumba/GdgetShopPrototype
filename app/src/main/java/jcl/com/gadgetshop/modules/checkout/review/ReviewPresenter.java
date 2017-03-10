package jcl.com.gadgetshop.modules.checkout.review;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import jcl.com.gadgetshop.base.BasePresenter;
import jcl.com.gadgetshop.data.DataManager;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.PaymentInfo;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.data.dao.ProductDao;
import jcl.com.gadgetshop.data.dao.ShippingInfo;
import jcl.com.gadgetshop.modules.checkout.review.ReviewMvp;

/**
 * Created by jayanthony.lumba on 3/10/2017.
 */

public class ReviewPresenter extends BasePresenter implements ReviewMvp.Presenter{
    ReviewMvp.View view;
    ReviewInteractor interactor;

    public ReviewPresenter(ReviewMvp.View view) {
        this.view = view;
        this.interactor = new ReviewInteractor(this);
        attachView(view);
    }

    @Override
    public void displayShippingInfo(ShippingInfo shippingInfo) {
        view.setShipTo(shippingInfo.getShipTo());
        view.setAddress(shippingInfo.getAddress());
        view.setContactNumber(shippingInfo.getContactNo());
    }

    @Override
    public void displayItems(ArrayList<OrderLine> orderLines) {
        double shippingFee = 300;
        double subTotal = 0;
        for (OrderLine orderLine: orderLines){
            Product product = DataManager.getInstance().getDbHelper().newSession().getProductDao()
                    .queryBuilder()
                    .where(ProductDao.Properties.Id.eq(orderLine.getProductId()))
                    .unique();
            subTotal += product.getPrice() * orderLine.getQuantity();
        }

        NumberFormat formatter = new DecimalFormat("#,###.00");
        view.setSubTotal("₱" + formatter.format(subTotal));
        view.setShippingFee("₱" + formatter.format(shippingFee));
        view.setTotal("₱" + formatter.format(subTotal + shippingFee));
        view.displayItems(orderLines);
    }

    @Override
    public void next() {
       interactor.postPlaceOrder();
    }

    @Override
    public void back() {
        interactor.postBackAction();
    }
}
