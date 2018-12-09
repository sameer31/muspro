package com.muspro.adminpanel.usermanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//      CREATE TABLE `user_external_login` (
//        `id` int(11) NOT NULL,
//        `user_account_id` int(11) DEFAULT NULL,
//        `external_authentication_provider_id` int(11) DEFAULT NULL,
//        `external_user_id` varchar(255) NOT NULL,
//        `name` varchar(45) DEFAULT NULL,
//        `first_name` varchar(45) DEFAULT NULL,
//        `last_name` varchar(45) DEFAULT NULL,
//        `email` varchar(100) DEFAULT NULL,
//        `login_name` varchar(45) DEFAULT NULL,
//        PRIMARY KEY (`id`),
//        KEY `fk_user_account_id_idx` (`user_account_id`),
//        KEY `fk_external_authentication_provider_id_idx` (`external_authentication_provider_id`),
//        CONSTRAINT `fk_external_authentication_provider_id` FOREIGN KEY (`external_authentication_provider_id`) REFERENCES `external_authentication_provider` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
//        CONSTRAINT `fk_user_account_id` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
//      )

@Entity
public class UserExternalLogin
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userAccountId;

    private int externalAuthenticationProviderId;

    private String externalUserId;

    private String name;

    private String firstName;

    private String lastName;

    private String email;

    private String loginName;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getUserAccountId()
    {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId)
    {
        this.userAccountId = userAccountId;
    }

    public int getExternalAuthenticationProviderId()
    {
        return externalAuthenticationProviderId;
    }

    public void setExternalAuthenticationProviderId(int externalAuthenticationProviderId)
    {
        this.externalAuthenticationProviderId = externalAuthenticationProviderId;
    }

    public String getExternalUserId()
    {
        return externalUserId;
    }

    public void setExternalUserId(String externalUserId)
    {
        this.externalUserId = externalUserId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + externalAuthenticationProviderId;
        result = prime * result + ((externalUserId == null) ? 0 : externalUserId.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + id;
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((loginName == null) ? 0 : loginName.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + userAccountId;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserExternalLogin other = (UserExternalLogin) obj;
        if (email == null)
        {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (externalAuthenticationProviderId != other.externalAuthenticationProviderId)
            return false;
        if (externalUserId == null)
        {
            if (other.externalUserId != null)
                return false;
        }
        else if (!externalUserId.equals(other.externalUserId))
            return false;
        if (firstName == null)
        {
            if (other.firstName != null)
                return false;
        }
        else if (!firstName.equals(other.firstName))
            return false;
        if (id != other.id)
            return false;
        if (lastName == null)
        {
            if (other.lastName != null)
                return false;
        }
        else if (!lastName.equals(other.lastName))
            return false;
        if (loginName == null)
        {
            if (other.loginName != null)
                return false;
        }
        else if (!loginName.equals(other.loginName))
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (userAccountId != other.userAccountId)
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("UserExternalLogin [id=");
        builder.append(id);
        builder.append(", userAccountId=");
        builder.append(userAccountId);
        builder.append(", externalAuthenticationProviderId=");
        builder.append(externalAuthenticationProviderId);
        builder.append(", externalUserId=");
        builder.append(externalUserId);
        builder.append(", name=");
        builder.append(name);
        builder.append(", firstName=");
        builder.append(firstName);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", email=");
        builder.append(email);
        builder.append(", loginName=");
        builder.append(loginName);
        builder.append("]");
        return builder.toString();
    }
}
