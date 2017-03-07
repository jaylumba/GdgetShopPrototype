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
            createProduct(R.drawable.img_prod_iphone_5
                    , "Apple iPhone 5" //name
                    , 12490 //price
                    , "Released 2012, September" //dateRelease
                    , "112g, 7.6mm thickness" //weight
                    , "iOS 6, up to iOS 10.2" //os
                    , "16GB storage, no card slot" //storage
                    , "4.0\" (640x1136 pixels)" //display
                    , "8MP (1080p)" //camera
                    , "1GB RAM (Apple A6)" //ram
                    , "1440mAh (Li-Po)" //battery
                    , PRODUCT_CATEGORY.PHONES.toString());

            createProduct(R.drawable.img_prod_iphone_5s
                    , "Apple iPhone 5s" //name
                    , 145000 //price
                    , "Released 2013, September" //dateRelease
                    , "112g, 7.6mm thickness" //weight
                    , "iOS 7, up to iOS 10.2" //os
                    , "32GB storage, no card slot" //storage
                    , "4.0\" (640x1136 pixels)" //display
                    , "8MP (1080p)" //camera
                    , "1GB RAM (Apple A7)" //ram
                    , "1560mAh (Li-Po)" //battery
                    , PRODUCT_CATEGORY.PHONES.toString());


            createProduct(R.drawable.img_prod_iphone_se
                    , "Apple iPhone SE"
                    , 14900
                    , "Released 2016, March"
                    , "113g, 7.6mm thickness"
                    , "iOS 9.3.2, up to iOS 10.2"
                    , "16GB storage, no card slot"
                    , "4.0\" (640x1136 pixels)"
                    , "12MP (2160p)"
                    , "2GB RAM (Apple A9)"
                    , "1624mAh (Li-Po)"
                    , PRODUCT_CATEGORY.PHONES.toString());

            createProduct(R.drawable.img_prod_iphone_6s
                    , "Apple iPhone 6s" //name
                    , 27000 //price
                    , "Released 2015, September" //dateRelease
                    , "143g, 7.1mm thickness" //weight
                    , "iOS 9, up to iOS 10.2" //os
                    , "64GB storage, no card slot" //storage
                    , "4.7\" (750x1334 pixels)" //display
                    , "12MP (160p)" //camera
                    , "2GB RAM (Apple A9)" //ram
                    , "1715mAh (Li-Ion)" //battery
                    , PRODUCT_CATEGORY.PHONES.toString());

            createProduct(R.drawable.img_prod_iphone_6s_plus
                    , "Apple iPhone 6s Plus" //name
                    , 24900 //price
                    , "Released 2015, September" //dateRelease
                    , "192g, 7.3mm thickness" //weight
                    , "iOS 9, up to iOS 10.2" //os
                    , "64GB storage, no card slot" //storage
                    , "5.5\" (1080x1920 pixels)" //display
                    , "12MP (2160p)" //camera
                    , "2GB RAM (Apple A9)" //ram
                    , "2750mAh (Li-Ion)" //battery
                    , PRODUCT_CATEGORY.PHONES.toString());

            createProduct(R.drawable.img_prod_iphone_7
                    , "Apple iPhone 7" //name
                    , 27500 //price
                    , "Released 2016, September" //dateRelease
                    , "138g, 7.1mm thickness" //weight
                    , "iOS 10.0.1, up to iOS 10.2" //os
                    , "128GB storage, no card slot" //storage
                    , "4.7\" (750x1334 pixels)" //display
                    , "12MP (2160p)" //camera
                    , "2GB RAM (Apple A10 Fusion)" //ram
                    , "1960mAh (Li-Ion)" //battery
                    , PRODUCT_CATEGORY.PHONES.toString());

            createProduct(R.drawable.img_prod_ipad_air_2
                    , "Apple iPad Air 2" //name
                    , 23200 //price
                    , "Released 2014, October" //dateRelease
                    , "437g (Wi-Fi) / 444g (3G/LTE), 6.1mm thickness" //weight
                    , "iOS 8.1, up to iOS 10.2" //os
                    , "64GB storage, no card slot" //storage
                    , "9.7\" (1536x2048 pixels)" //display
                    , "8MP (1080p)" //camera
                    , "2GB RAM (Apple A8X)" //ram
                    , "7340mAh (Li-Po)" //battery
                    , PRODUCT_CATEGORY.TABLET.toString());

            createProduct(R.drawable.img_prod_apple_ipad_pro
                    , "Apple iPad Pro" //name
                    , 33200 //price
                    , "Released 2015, November" //dateRelease
                    , "713g (Wi-Fi) / 723g (LTE), 6.9mm thickness" //weight
                    , "iOS 9, up to iOS 10.2" //os
                    , "32/128/256GB storage, no card slot" //storage
                    , "12.9\" ((2048x2732 pixels)" //display
                    , "8MP (1080p)" //camera
                    , "4GB RAM (Apple A9X)" //ram
                    , "10307mAh (Li-Ion)" //battery
                    , PRODUCT_CATEGORY.TABLET.toString());

            createProduct(R.drawable.img_prod_apple_ipad_mini_4
                    , "Apple iPad mini 4" //name
                    , 25000 //price
                    , "Released 2015, September" //dateRelease
                    , "299g (Wi-Fi) / 304g (3G/LTE), 6.1mm thickness" //weight
                    , "iOS 9, up to iOS 10.2" //os
                    , "128GB storage, no card slot" //storage
                    , "7.9\" (1536x2048 pixels)" //display
                    , "8MP (1080p)" //camera
                    , "2GB RAM (Apple A8)" //ram
                    , "5124mAh (Li-Ion)" //battery
                    , PRODUCT_CATEGORY.TABLET.toString());

            createProduct(R.drawable.img_prod_apple_ipad_mini_3
                    , "Apple iPad mini 3" //name
                    , 15990 //price
                    , "Released 2014, October" //dateRelease
                    , "331g (Wi-Fi) / 341g (3G/LTE), 7.5mm thickness" //weight
                    , "iOS 8.1, up to iOS 10.2" //os
                    , "128GB storage, no card slot" //storage
                    , "7.9\" (1536x2048 pixels)" //display
                    , "5MP (1080p)" //camera
                    , "1GB RAM (Apple A7)" //ram
                    , "6470mAh (Li-Po)" //battery
                    , PRODUCT_CATEGORY.TABLET.toString());

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
        productDao.insert(product);
    }

}
