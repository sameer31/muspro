package com.muspro.adminpanel.usermanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_account")
public class UserAccount
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String screenUserName;

    @OneToOne
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getScreenUserName()
    {
        return screenUserName;
    }

    public void setScreenUserName(String screenUserName)
    {
        this.screenUserName = screenUserName;
    }

    public UserDetails getUserDetails()
    {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails)
    {
        this.userDetails = userDetails;
    }
}
