package jcl.com.gadgetshop.modules.successpage;

import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.OnClick;
import jcl.com.gadgetshop.R;
import jcl.com.gadgetshop.base.BaseActivity;
import jcl.com.gadgetshop.events.PostClearHomeEvent;
import jcl.com.gadgetshop.events.PostFinishCartEvent;

public class SuccessActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_finish)
    public void close(){
        EventBus.getDefault().postSticky(new PostFinishCartEvent());
        EventBus.getDefault().postSticky(new PostClearHomeEvent());
        finishActivity();
    }
}
