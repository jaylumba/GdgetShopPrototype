package jcl.com.gadgetshop;

import android.app.Application;
import android.content.Context;

import java.io.File;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;

import jcl.com.gadgetshop.data.DataManager;
import jcl.com.gadgetshop.data.local.DbHelper;
import jcl.com.gadgetshop.data.local.SharedPrefHelper;
import jcl.com.gadgetshop.sinlgetons.PicassoSingleton;
import jcl.com.gadgetshop.util.encryption.AesCbcWithIntegrity;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by jayan on 3/5/2017.
 */


public class App extends Application {

    private static final int CONNECTION_TIME_OUT = 30;
    private static final int READ_TIME_OUT = 30;

    private static App instance;
    private static AesCbcWithIntegrity.SecretKeys keys;

    private SharedPrefHelper sharedPrefHelper;
    private DbHelper dbHelper;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        try {
            keys = AesCbcWithIntegrity.generateKeyFromPassword(BuildConfig.SECRET_KEY, BuildConfig.SECRET_KEY);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        //Initialize DataManager Singleton
        sharedPrefHelper = new SharedPrefHelper(getApplicationContext());
        dbHelper = new DbHelper(this);
        DataManager dataManager = DataManager.getInstance();
        dataManager.initialize(sharedPrefHelper, dbHelper);

        /** initialize calligraphy */
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/OpenSans-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        /** initialize okhttp client */
        File cacheDir = getExternalCacheDir();
        if (cacheDir == null) {
            cacheDir = getCacheDir();
        }

        final Cache cache = new Cache(cacheDir, 10 * 1024 * 1024);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        if (BuildConfig.DEBUG)
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        else
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        /** initialize ok http client */
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .cache(cache)
                .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .build();

        /** initialize picasso */
        final PicassoSingleton picassoSingleton = PicassoSingleton.getInstance();
        picassoSingleton.initPicasso(this, okHttpClient);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        dbHelper.destroy();
    }

    public static AesCbcWithIntegrity.SecretKeys getKeys() {
        return keys;
    }

    public static App getInstance() {
        return instance;
    }

}

