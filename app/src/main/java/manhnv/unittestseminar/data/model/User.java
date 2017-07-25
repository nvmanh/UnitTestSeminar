package manhnv.unittestseminar.data.model;

import manhnv.unittestseminar.base.BaseModel;

/**
 * Created by root on 7/25/17.
 */

public class User extends BaseModel{
    private String userName;
    private String email;
    public User(){
        super();
    }
    public User(String username, String email){
        this.email = email;
        this.userName = username;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
}
