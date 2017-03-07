package jcl.com.gadgetshop.events;

import jcl.com.gadgetshop.data.dao.User;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

public class LoginSuccessEvent {
    User user;
    public LoginSuccessEvent(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
}
