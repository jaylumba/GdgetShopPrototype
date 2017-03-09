package jcl.com.gadgetshop.modules.checkout.shipping;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.ButterKnife;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseStepFragment;

/**
 * Created by jayan on 3/9/2017.
 */

public class ShippingFragment extends BaseStepFragment implements ShippingMvp.View{

    EditText etFullname;
    EditText etCompleteAddress;
    EditText etContactNumber;
    Button btnContinue;

    ShippingPresenter presenter;

    @SuppressLint("ValidFragment")
    private ShippingFragment() {
        //Use to avoid using the new constructor.
    }

    @Override
    public String name() {
        return "Shipping";
    }

    public static ShippingFragment newInstance() {
        ShippingFragment fragment = new ShippingFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shipping, container, false);

        etFullname = ButterKnife.findById(view,R.id.et_fullname);
        etCompleteAddress = ButterKnife.findById(view,R.id.et_complete_address);
        etContactNumber = ButterKnife.findById(view,R.id.et_contact_number);
        btnContinue = ButterKnife.findById(view,R.id.btn_continue);
        btnContinue.setOnClickListener(view1 -> {
            if (etFullname.getText().toString().isEmpty()
                    || etCompleteAddress.getText().toString().isEmpty()
                    || etContactNumber.getText().toString().isEmpty())
                showToast("Please complete all required fields!");
            else presenter.next();
        });

        presenter = new ShippingPresenter(this);
        presenter.onLoad();
        return view;
    }

    @Override
    public boolean isOptional() {
        return false;
    }

    @Override
    public String error() {
        return "Please complete all required fields.";
    }
}
