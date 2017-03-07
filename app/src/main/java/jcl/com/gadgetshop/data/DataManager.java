package jcl.com.gadgetshop.data;


import jcl.com.gadgetshop.data.local.DbHelper;
import jcl.com.gadgetshop.data.local.SharedPrefHelper;

public class DataManager {
    private static DataManager instance = null;
    private SharedPrefHelper mSharedPrefHelper;
    private DbHelper mDbHelper;

    protected DataManager(){
    }

    public static DataManager getInstance(){
        if(instance == null){
            instance = new DataManager();
        }
        return instance;
    }

    public void initialize(SharedPrefHelper sharedPrefHelper, DbHelper dbHelper){
        mSharedPrefHelper = sharedPrefHelper;
        mDbHelper = dbHelper;
    }

    public SharedPrefHelper getSharedPrefHelper(){
        return mSharedPrefHelper;
    }

    public DbHelper getDbHelper() {
        return mDbHelper;
    }
}
