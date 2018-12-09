package com.muspro.adminpanel.usermanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//      CREATE TABLE `user_account` (
//        `id` int(11) NOT NULL,
//        `screen_user_name` varchar(45) DEFAULT NULL,
//        `user_details_id` int(11) DEFAULT NULL,
//        PRIMARY KEY (`id`),
//        UNIQUE KEY `user_details_id_UNIQUE` (`user_details_id`),
//        CONSTRAINT `fk_user_det_id` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
//      )

@Entity
@Table(name = "user_account")
public class UserAccount
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
