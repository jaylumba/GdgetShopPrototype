package jcl.com.gadgetshop.data.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import jcl.com.gadgetshop.data.dao.Order;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.OrderMapping;
import jcl.com.gadgetshop.data.dao.PaymentInfo;
import jcl.com.gadgetshop.data.dao.Product;
import jcl.com.gadgetshop.data.dao.ShippingInfo;
import jcl.com.gadgetshop.data.dao.User;

import jcl.com.gadgetshop.data.dao.OrderDao;
import jcl.com.gadgetshop.data.dao.OrderLineDao;
import jcl.com.gadgetshop.data.dao.OrderMappingDao;
import jcl.com.gadgetshop.data.dao.PaymentInfoDao;
import jcl.com.gadgetshop.data.dao.ProductDao;
import jcl.com.gadgetshop.data.dao.ShippingInfoDao;
import jcl.com.gadgetshop.data.dao.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig orderDaoConfig;
    private final DaoConfig orderLineDaoConfig;
    private final DaoConfig orderMappingDaoConfig;
    private final DaoConfig paymentInfoDaoConfig;
    private final DaoConfig productDaoConfig;
    private final DaoConfig shippingInfoDaoConfig;
    private final DaoConfig userDaoConfig;

    private final OrderDao orderDao;
    private final OrderLineDao orderLineDao;
    private final OrderMappingDao orderMappingDao;
    private final PaymentInfoDao paymentInfoDao;
    private final ProductDao productDao;
    private final ShippingInfoDao shippingInfoDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        orderDaoConfig = daoConfigMap.get(OrderDao.class).clone();
        orderDaoConfig.initIdentityScope(type);

        orderLineDaoConfig = daoConfigMap.get(OrderLineDao.class).clone();
        orderLineDaoConfig.initIdentityScope(type);

        orderMappingDaoConfig = daoConfigMap.get(OrderMappingDao.class).clone();
        orderMappingDaoConfig.initIdentityScope(type);

        paymentInfoDaoConfig = daoConfigMap.get(PaymentInfoDao.class).clone();
        paymentInfoDaoConfig.initIdentityScope(type);

        productDaoConfig = daoConfigMap.get(ProductDao.class).clone();
        productDaoConfig.initIdentityScope(type);

        shippingInfoDaoConfig = daoConfigMap.get(ShippingInfoDao.class).clone();
        shippingInfoDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        orderDao = new OrderDao(orderDaoConfig, this);
        orderLineDao = new OrderLineDao(orderLineDaoConfig, this);
        orderMappingDao = new OrderMappingDao(orderMappingDaoConfig, this);
        paymentInfoDao = new PaymentInfoDao(paymentInfoDaoConfig, this);
        productDao = new ProductDao(productDaoConfig, this);
        shippingInfoDao = new ShippingInfoDao(shippingInfoDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(Order.class, orderDao);
        registerDao(OrderLine.class, orderLineDao);
        registerDao(OrderMapping.class, orderMappingDao);
        registerDao(PaymentInfo.class, paymentInfoDao);
        registerDao(Product.class, productDao);
        registerDao(ShippingInfo.class, shippingInfoDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        orderDaoConfig.clearIdentityScope();
        orderLineDaoConfig.clearIdentityScope();
        orderMappingDaoConfig.clearIdentityScope();
        paymentInfoDaoConfig.clearIdentityScope();
        productDaoConfig.clearIdentityScope();
        shippingInfoDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public OrderLineDao getOrderLineDao() {
        return orderLineDao;
    }

    public OrderMappingDao getOrderMappingDao() {
        return orderMappingDao;
    }

    public PaymentInfoDao getPaymentInfoDao() {
        return paymentInfoDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public ShippingInfoDao getShippingInfoDao() {
        return shippingInfoDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
