package jcl.com.gadgetshop.data.mock;

import jcl.com.gadgetshop.data.DataManager;
import jcl.com.gadgetshop.data.dao.User;
import jcl.com.gadgetshop.data.dao.UserDao;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class MockData {
    public static void initialize(){
        if (DataManager.getInstance().getSharedPrefHelper().isFirstLaunced()){
            createUser("jay@gmail.com","pass","Jay Anthony Lumba");
            createUser("test1@gmail.com","pass","Test Account 1");
            createUser("test2@gmail.com","pass","Test Account 2");
            DataManager.getInstance().getSharedPrefHelper().saveFirstLaunched(false);
        }
    }

    private static void createUser(String email, String password, String name){
        UserDao userDao = DataManager.getInstance().getDbHelper().newSession().getUserDao();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        userDao.insertOrReplace(user);
    }

}
