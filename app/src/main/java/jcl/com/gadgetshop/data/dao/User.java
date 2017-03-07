package jcl.com.gadgetshop.data.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jayan on 3/5/2017.
 */

@Entity
public class User {

    @Unique
    String email;
    @Property
    String password;
    @Property
    String name;
    @Generated(hash = 664108361)
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
