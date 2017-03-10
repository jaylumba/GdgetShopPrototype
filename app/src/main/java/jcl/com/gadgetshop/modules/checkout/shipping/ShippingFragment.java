package jcl.com.gadgetshop.modules.checkout.shipping;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseStepFragment;

/**
 * Created by jayan on 3/9/2017.
 */

public class ShippingFragment extends BaseStepFragment implements ShippingMvp.View {

    @BindView(R.id.et_fullname)
    EditText etFullname;
    @BindView(R.id.et_complete_address)
    EditText etCompleteAddress;
    @BindView(R.id.et_contact_number)
    EditText etContactNumber;
    @BindView(R.id.btn_continue)
    Button btnContinue;

    ShippingPresenter presenter;

    @SuppressLint("ValidFragment")
    private ShippingFragment() {
        //Use to avoid using the new constructor.
    }

    public static ShippingFragment newInstance() {
        ShippingFragment fragment = new ShippingFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shipping, container, false);
        ButterKnife.bind(this, view);
        presenter = new ShippingPresenter(this);
        presenter.onLoad();
        return view;
    }

    @Override
    public String name() {
        return "Shipping";
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
    public void initViews() {
        btnContinue.setOnClickListener(view1 -> {
            presenter.next();
        });
    }

    @Override
    public String getFullname() {
        return etFullname.getText().toString();
    }

    @Override
    public String getAddress() {
        return etCompleteAddress.getText().toString();
    }

    @Override
    public String getContactNumber() {
        return etContactNumber.getText().toString();
    }
}
