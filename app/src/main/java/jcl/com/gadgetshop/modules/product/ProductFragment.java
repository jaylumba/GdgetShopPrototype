package jcl.com.gadgetshop.modules.product;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseFragment;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.enums.PRODUCT_CATEGORY;

public class ProductFragment extends BaseFragment implements ProductMvp.View{

    @BindView(R.id.tv_desc)
    TextView tvDesc;

    private ArrayList<Product> products;
    private PRODUCT_CATEGORY productCategory;

    @SuppressLint("ValidFragment")
    private ProductFragment() {
        //Use to avoid using the new constructor.
    }

    public static ProductFragment newInstance(PRODUCT_CATEGORY productCategory) {
        ProductFragment fragment = new ProductFragment();
        fragment.productCategory = productCategory;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        ButterKnife.bind(this, view);

        if (productCategory == PRODUCT_CATEGORY.PHONES) tvDesc.setText("Phones");
        else if (productCategory == PRODUCT_CATEGORY.TABLET) tvDesc.setText("Tablets");
        else tvDesc.setText("Phones and Tablet");

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void displayProducts(ArrayList<Product> products) {

    }
}