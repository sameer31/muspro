package com.muspro.adminpanel.admin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "admin_credentials")

@NamedQuery(name = "AdminCredentialsEntity.fetchByUserName", query = "SELECT admin FROM AdminCredentialsEntity admin WHERE admin.userName =:userName")

public class AdminCredentialsEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    private String passwordSalt;

    private String passwordHash;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPasswordSalt()
    {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt)
    {
        this.passwordSalt = passwordSalt;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((passwordHash == null) ? 0 : passwordHash.hashCode());
        result = prime * result + ((passwordSalt == null) ? 0 : passwordSalt.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
        AdminCredentialsEntity other = (AdminCredentialsEntity) obj;
        if (id != other.id)
            return false;
        if (passwordHash == null)
        {
            if (other.passwordHash != null)
                return false;
        }
        else if (!passwordHash.equals(other.passwordHash))
            return false;
        if (passwordSalt == null)
        {
            if (other.passwordSalt != null)
                return false;
        }
        else if (!passwordSalt.equals(other.passwordSalt))
            return false;
        if (userName == null)
        {
            if (other.userName != null)
                return false;
        }
        else if (!userName.equals(other.userName))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("AdminCredentialsEntity [id=");
        builder.append(id);
        builder.append(", userName=");
        builder.append(userName);
        builder.append(", passwordSalt=");
        builder.append(passwordSalt);
        builder.append(", passwordHash=");
        builder.append(passwordHash);
        builder.append("]");
        return builder.toString();
    }
}
