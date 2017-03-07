package jcl.com.gadgetshop.data.local;

import android.app.Application;

import jcl.com.gadgetshop.data.dao.DaoMaster;
import jcl.com.gadgetshop.data.dao.DaoSession;

public class DbHelper {

    private final static String DB_NAME = "gadgetshop.db";
    private static DaoMaster.DevOpenHelper sDevOpenHelper;
    private static DaoMaster sDaoMaster;

    public DbHelper(Application app) {
        sDevOpenHelper = new DaoMaster.DevOpenHelper(app, DB_NAME, null);
        sDaoMaster = new DaoMaster(sDevOpenHelper.getWritableDatabase());
    }

    public void destroy() {
        try {
            if (sDaoMaster != null) {
                sDaoMaster.getDatabase().close();
                sDaoMaster = null;
            }

            if (sDevOpenHelper != null) {
                sDevOpenHelper.close();
                sDevOpenHelper = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DaoSession newSession() {
        if (sDaoMaster == null) {
            throw new RuntimeException("sDaoMaster is null.");
        }
        return sDaoMaster.newSession();
    }
}
