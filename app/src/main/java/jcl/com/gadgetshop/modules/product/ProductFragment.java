package jcl.com.gadgetshop.modules.product;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.adapters.ProductAdapter;
import jcl.com.gadgetshop.base.BaseFragment;
import jcl.com.gadgetshop.callbacks.OnAddToCartClick;
import jcl.com.gadgetshop.callbacks.OnListItemClickWithSharedElement;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.enums.PRODUCT_CATEGORY;
import jcl.com.gadgetshop.events.AddProductToCartEvent;
import jcl.com.gadgetshop.events.PostProductDetailEvent;
import jcl.com.gadgetshop.modules.productdetail.ProductDetailActivity;

public class ProductFragment extends BaseFragment implements ProductMvp.View {

    @BindView(R.id.rv_products)
    RecyclerView rvProducts;

    private PRODUCT_CATEGORY productCategory;
    private OnAddToCartClick addToCartClick;
    private OnListItemClickWithSharedElement callback;
    ProductMvp.Presenter presenter;

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

        presenter = new ProductPresenter(this);
        presenter.onLoad();
        presenter.retrieveProducts(productCategory);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void initCallbacks() {
        addToCartClick = product -> {
            OrderLine orderLine = new OrderLine();
            orderLine.setProductId(product.getId());
            orderLine.setQuantity(1);
            EventBus.getDefault().postSticky(new AddProductToCartEvent(orderLine));
        };

        callback = (obj, pos, options) -> {
            EventBus.getDefault().postSticky(new PostProductDetailEvent((Product) obj));
            if (options != null)
                moveToOtherActivityWithSharedElements(ProductDetailActivity.class, options);
            else
                moveToOtherActivity(ProductDetailActivity.class);
        };
    }

    @Override
    public void displayProducts(List<Product> products) {
        if (products != null) {
            GridLayoutManager lm = new GridLayoutManager(getActivity(), 2);
            rvProducts.setLayoutManager(lm);
            rvProducts.setItemAnimator(new DefaultItemAnimator());
            rvProducts.setAdapter(new ProductAdapter(getActivity(), products, addToCartClick, callback));
        }
    }
}