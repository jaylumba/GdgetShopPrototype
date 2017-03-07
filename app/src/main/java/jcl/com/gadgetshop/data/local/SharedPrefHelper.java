package jcl.com.gadgetshop.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import jcl.com.gadgetshop.util.encryption.EncryptionUtil;

import static java.lang.Boolean.getBoolean;


public class SharedPrefHelper {
    private final String SHARED_PREF_NAME = "gadgetshop_pref_file";
    private final String SHARED_PREF_FIRSTLAUNCHED = "is_first_launched";
    private final String SHARED_PREF_LASTUSER = "last_user";

    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;

    public SharedPrefHelper(Context context){
        mPref = context.getSharedPreferences(SHARED_PREF_NAME,context.MODE_PRIVATE);
    }

    public void clear(){
        mPref.edit().clear().apply();
    }

    private boolean save(String key, String value){
        if(mPref != null){
            mEditor = mPref.edit();
            mEditor.putString(key, EncryptionUtil.encrypt(value));
            return mEditor.commit();
        }else{
            return false;
        }
    }

    private boolean save(String key, boolean value){
        if(mPref != null){
            mEditor = mPref.edit();
            mEditor.putBoolean(key, value);
            return mEditor.commit();
        }else{
            return false;
        }
    }

    private String get(String key){
        if(mPref != null){
            String value = mPref.getString(key,"");
            return value.equals("") ? "": EncryptionUtil.decrypt(value);
        }else{
            return "";
        }
    }

    public void saveFirstLaunched(boolean isFirstLaunched){
        save(SHARED_PREF_FIRSTLAUNCHED,isFirstLaunched);
    }

    public boolean isFirstLaunced(){
        return mPref.getBoolean(SHARED_PREF_FIRSTLAUNCHED,true);
    }

    public void saveLastUser(String email){
        save(SHARED_PREF_LASTUSER,email);
    }

    public String getLastUser(){
        return get(SHARED_PREF_LASTUSER);
    }
}
