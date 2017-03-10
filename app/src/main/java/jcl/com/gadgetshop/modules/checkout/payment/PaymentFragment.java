package jcl.com.gadgetshop.modules.checkout.payment;

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
import jcl.com.gadgetshop.textwatchers.ExpiryDateTextWatcher;

/**
 * Created by jayan on 3/9/2017.
 */

public class PaymentFragment extends BaseStepFragment implements PaymentMvp.View {

    @BindView(R.id.et_cardholders_name)
    EditText etCardholdersName;
    @BindView(R.id.et_credit_card_number)
    EditText etCreditCardNumber;
    @BindView(R.id.et_expiry_date)
    EditText etExpiryDate;
    @BindView(R.id.et_cvv)
    EditText etCvv;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_continue)
    Button btnContinue;

    PaymentPresenter presenter;

    @SuppressLint("ValidFragment")
    private PaymentFragment() {
        //Use to avoid using the new constructor.
    }

    public static PaymentFragment newInstance() {
        PaymentFragment fragment = new PaymentFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        ButterKnife.bind(this, view);
        presenter = new PaymentPresenter(this);
        presenter.onLoad();
        return view;
    }

    @Override
    public String name() {
        return "Payment";
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

    @Override
    public void initViews() {
        etExpiryDate.addTextChangedListener(new ExpiryDateTextWatcher(etExpiryDate));

        btnContinue.setOnClickListener(view1 -> {
            presenter.next();
        });

        btnBack.setOnClickListener(view1 -> {
            presenter.back();
        });
    }

    @Override
    public String getCardholdersName() {
        return etCardholdersName.getText().toString();
    }

    @Override
    public String getCreditCardNumber() {
        return etCreditCardNumber.getText().toString();
    }

    @Override
    public String getExpiryDate() {
        return etExpiryDate.getText().toString();
    }

    @Override
    public String getCvv() {
        return etCvv.getText().toString();
    }

    @Override
    public boolean hasError() {
        return false;
    }
}
