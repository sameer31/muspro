package com.muspro.adminpanel.admin;

import java.io.Serializable;

public class AdminLoginRequest implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -2785574274864796707L;

    private String userName;

    private String password;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
