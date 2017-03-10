package jcl.com.gadgetshop.modules.checkout.review;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.adapters.CartAdapter;
import jcl.com.gadgetshop.adapters.ReviewAdapter;
import jcl.com.gadgetshop.base.BaseStepFragment;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.ShippingInfo;
import jcl.com.gadgetshop.events.PostCartToCheckoutEvent;
import jcl.com.gadgetshop.events.PostShippingEvent;

/**
 * Created by jayan on 3/9/2017.
 */

public class ReviewFragment extends BaseStepFragment implements ReviewMvp.View {

    View view;
    @BindView(R.id.tv_sub_total)
    TextView tvSubTotal;
    @BindView(R.id.tv_shipping_fee)
    TextView tvShippingFee;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_contact_number)
    TextView tvContactNumber;
    @BindView(R.id.rv_items)
    RecyclerView rvItems;
    @BindView(R.id.sv_review)
    ScrollView svReview;

    ReviewPresenter presenter;
    ShippingInfo shippingInfo;
    ArrayList<OrderLine> items;

    @SuppressLint("ValidFragment")
    private ReviewFragment() {
        //Use to avoid using the new constructor.
    }

    public static ReviewFragment newInstance() {
        ReviewFragment fragment = new ReviewFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_review, container, false);
        ButterKnife.bind(this, view);
        presenter = new ReviewPresenter(this);
        EventBus.getDefault().register(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.btn_back)
    public void back(){
        presenter.back();
    }

    @OnClick(R.id.btn_continue)
    public void placeOrder(){
        presenter.next();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onReceiveShippingDetails(PostShippingEvent event){
        shippingInfo = event.getShippingInfo();
        presenter.displayShippingInfo(shippingInfo);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onReceiveItems(PostCartToCheckoutEvent event){
        items = event.getOrderLines();
        presenter.displayItems(items);
    }

    @Override
    public String name() {
        return "Review";
    }

    @Override
    public boolean isOptional() {
        return false;
    }

    @Override
    public String error() {
        return "Please complete all required fields.";
    }

    @Override
    public void setSubTotal(String subTotal) {
        tvSubTotal.setText(subTotal);
    }

    @Override
    public void setShippingFee(String shippingFee) {
        tvShippingFee.setText(shippingFee);
    }

    @Override
    public void setTotal(String total) {
        tvTotal.setText(total);
    }

    @Override
    public void setShipTo(String name) {
        tvName.setText(name);
    }

    @Override
    public void setAddress(String address) {
        tvAddress.setText(address);
    }

    @Override
    public void setContactNumber(String contactNumber) {
        tvContactNumber.setText(contactNumber);
    }

    @Override
    public void displayItems(ArrayList<OrderLine> orderLines) {
        if (orderLines != null) {
            LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            rvItems.setLayoutManager(lm);
            rvItems.setItemAnimator(new DefaultItemAnimator());
            rvItems.setAdapter(new ReviewAdapter(getActivity(), orderLines, null));
        }
    }
}
