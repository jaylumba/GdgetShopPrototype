package jcl.com.gadgetshop.modules.checkout.payment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseStepFragment;

/**
 * Created by jayan on 3/9/2017.
 */

public class PaymentFragment extends BaseStepFragment{

    @SuppressLint("ValidFragment")
    private PaymentFragment() {
        //Use to avoid using the new constructor.
    }

    @Override
    public String name() {
        return "Payment";
    }

    public static PaymentFragment newInstance() {
        PaymentFragment fragment = new PaymentFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        return view;
    }

    @Override
    public boolean isOptional() {
        return false;
    }

    @Override
    public boolean nextIf() {
        return true;
    }

    @Override
    public String error() {
        return "Please complete all required fields.";
    }

    @Override
    public void onNext() {
        super.onNext();
    }

    @Override
    public void onPrevious() {
        super.onPrevious();
    }
}
