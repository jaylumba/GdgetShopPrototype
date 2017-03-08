package jcl.com.gadgetshop.events;

import jcl.com.gadgetshop.data.dao.Product;

/**
 * Created by jayan on 3/9/2017.
 */

public class PostProductEvent {
    Product product;

    public PostProductEvent(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
