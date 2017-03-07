package jcl.com.gadgetshop.callbacks;

import android.view.View;

public interface OnListItemClick {
    void onItemClick(Object item);
    void onItemClickWithTransition(Object itme, View view);
}
