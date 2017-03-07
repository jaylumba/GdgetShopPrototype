package jcl.com.gadgetshop.modules.product;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.adapters.ProductAdapter;
import jcl.com.gadgetshop.base.BaseFragment;
import jcl.com.gadgetshop.callbacks.OnAddToCartClick;
import jcl.com.gadgetshop.callbacks.OnListItemClick;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.enums.PRODUCT_CATEGORY;

public class ProductFragment extends BaseFragment implements ProductMvp.View{

    @BindView(R.id.rv_products)
    RecyclerView rv_products;

    private PRODUCT_CATEGORY productCategory;
    private OnAddToCartClick addToCartClick;
    private OnListItemClick callback;
    ProductMvp.Presenter mPresenter;

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

        mPresenter = new ProductPresenter(this);
        mPresenter.retrieveProducts(productCategory);
//        if (productCategory == PRODUCT_CATEGORY.PHONES) tvDesc.setText("Phones");
//        else if (productCategory == PRODUCT_CATEGORY.TABLET) tvDesc.setText("Tablets");
//        else tvDesc.setText("Phones and Tablet");

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void displayProducts(ArrayList<Product> products) {
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        rv_products.setLayoutManager(lm);
        rv_products.setItemAnimator(new DefaultItemAnimator());
        rv_products.setAdapter(new ProductAdapter(products, addToCartClick,callback));
    }
}