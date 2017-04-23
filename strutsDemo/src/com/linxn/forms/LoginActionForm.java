package com.linxn.forms;

import org.apache.struts.action.ActionForm;

/**
 * Created by linxn on 2017/4/19.
 */
public class LoginActionForm extends ActionForm {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    private String userpwd;
}
