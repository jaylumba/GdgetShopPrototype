package jcl.com.gadgetshop.base;

/**
 * Created by jayanthony.lumba on 7/13/2016.
 */
public interface BaseDialogView extends BaseMvp.View{

    void create(BaseActivity activity, int layoutId);
    void setCancelable(boolean isCancelable);
    void showDialog();
    void dismissDialog();
    void finishActivity();

}
