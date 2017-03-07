package jcl.com.gadgetshop.data.mock;

import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.data.DataManager;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.data.dao.ProductDao;
import jcl.com.gadgetshop.data.dao.User;
import jcl.com.gadgetshop.data.dao.UserDao;
import jcl.com.gadgetshop.enums.PRODUCT_CATEGORY;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class MockData {
    public static void initialize() {
        if (DataManager.getInstance().getSharedPrefHelper().isFirstLaunced()) {
            //Dummy users
            createUser("jay@gmail.com", "pass", "Jay Anthony Lumba");
            createUser("test1@gmail.com", "pass", "Test Account 1");
            createUser("test2@gmail.com", "pass", "Test Account 2");

            //Products
            createProduct(R.drawable.prod_apple_iphone_se
                    , "APPLE IPhone SE"
                    , 19900
                    , "Released 2016, March"
                    , "113g, 7.6mm thickness"
                    , "iOS 9.3.2, up to iOS 10.2"
                    , "16/64GB storage, no card slot"
                    , "4.0\" (640x1136 pixels)"
                    , "12MP (2160p)"
                    , "2GB RAM (Apple A9)"
                    , "1624mAh (Li-Po)"
                    , PRODUCT_CATEGORY.PHONES.toString());

            createProduct(R.drawable.prod_apple_iphone_se
                    , "APPLE IPhone SE"
                    , 19900
                    , "Released 2016, March"
                    , "113g, 7.6mm thickness"
                    , "iOS 9.3.2, up to iOS 10.2"
                    , "16/64GB storage, no card slot"
                    , "4.0\" (640x1136 pixels)"
                    , "12MP (2160p)"
                    , "2GB RAM (Apple A9)"
                    , "1624mAh (Li-Po)"
                    , PRODUCT_CATEGORY.PHONES.toString());

            //Not actual
            createProduct(R.drawable.prod_iphone_6
                    , "APPLE IPhone 6"
                    , 21800
                    , "Released 2014, September"
                    , "113g, 7.6mm thickness"
                    , "iOS 9.3.2, up to iOS 10.2"
                    , "16/64GB storage, no card slot"
                    , "4.0\" (640x1136 pixels)"
                    , "12MP (2160p)"
                    , "2GB RAM (Apple A9)"
                    , "1624mAh (Li-Po)"
                    , PRODUCT_CATEGORY.PHONES.toString());

            createProduct(R.drawable.prod_apple_iphone_6s
                    , "APPLE IPhone 6s"
                    , 21800
                    , "Released 2014, September"
                    , "113g, 7.6mm thickness"
                    , "iOS 9.3.2, up to iOS 10.2"
                    , "16/64GB storage, no card slot"
                    , "4.0\" (640x1136 pixels)"
                    , "12MP (2160p)"
                    , "2GB RAM (Apple A9)"
                    , "1624mAh (Li-Po)"
                    , PRODUCT_CATEGORY.PHONES.toString());

            createProduct(R.drawable.prod_apple_iphone_7
                    , "APPLE IPhone 7"
                    , 21800
                    , "Released 2014, September"
                    , "113g, 7.6mm thickness"
                    , "iOS 9.3.2, up to iOS 10.2"
                    , "16/64GB storage, no card slot"
                    , "4.0\" (640x1136 pixels)"
                    , "12MP (2160p)"
                    , "2GB RAM (Apple A9)"
                    , "1624mAh (Li-Po)"
                    , PRODUCT_CATEGORY.PHONES.toString());

            DataManager.getInstance().getSharedPrefHelper().saveFirstLaunched(false);
        }
    }

    private static void createUser(String email, String password, String name) {
        UserDao userDao = DataManager.getInstance().getDbHelper().newSession().getUserDao();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        userDao.insertOrReplace(user);
    }

    private static void createProduct(int picResid, String name, double price, String dateRelease,
                                      String weight, String os, String storage, String display,
                                      String camera, String ram, String battery, String category) {
        ProductDao productDao = DataManager.getInstance().getDbHelper().newSession().getProductDao();
        Product product = new Product();
        product.setPicResId(picResid);
        product.setName(name);
        product.setPrice(price);
        product.setDateRelease(dateRelease);
        product.setWeight(weight);
        product.setOs(os);
        product.setStorage(storage);
        product.setDisplay(display);
        product.setCamera(camera);
        product.setRam(ram);
        product.setBattery(battery);
        product.setCategory(category);
        productDao.insertOrReplace(product);
    }

}
