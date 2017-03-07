package jcl.com.gadgetshop.modules.product;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseFragment;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.enums.PRODUCT_CATEGORY;

/**
 * Created by Gilbert Pareno on 22/11/2016.
 */

public class ProductFragment extends BaseFragment {


    private ArrayList<Product> products;
    private View dialogView;

    private PRODUCT_CATEGORY productCategory;


    @SuppressLint("ValidFragment")
    protected ProductFragment() {
    }

    public static ProductFragment newInstance(PRODUCT_CATEGORY productCategory) {
        ProductFragment fragment = new ProductFragment();
        fragment.productCategory = productCategory;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
//        ButterKnife.bind(this, view);
//        EventBus.getDefault().register(this);
//        activity = (BaseActivity) getActivity();
//        apiRequestHelper = new ApiRequestHelper(this);
//        initRecycler();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}