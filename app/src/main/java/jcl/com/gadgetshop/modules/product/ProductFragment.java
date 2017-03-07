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

/**
 * Created by Gilbert Pareno on 22/11/2016.
 */

public class ProductFragment extends BaseFragment {


    private ArrayList<Product> students;
    private View dialogView;

    private boolean isMale;


    @SuppressLint("ValidFragment")
    protected ProductFragment() {
    }

    public static ProductFragment newInstance(boolean isMale) {
        ProductFragment fragment = new ProductFragment();
        fragment.isMale = isMale;
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