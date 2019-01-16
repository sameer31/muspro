package com.muspro.app.dahira;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dahira_info")
public class DahiraInfoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;

    private String address;

    private String jawrigne;

    private String phone;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getJawrigne()
    {
        return jawrigne;
    }

    public void setJawrigne(String jawrigne)
    {
        this.jawrigne = jawrigne;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @Override
    public int hashCode()
    {
        return id;
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
        DahiraInfoEntity other = (DahiraInfoEntity) obj;

        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("DahiraInfoEntity [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", location=");
        builder.append(location);
        builder.append(", address=");
        builder.append(address);
        builder.append(", jawrigne=");
        builder.append(jawrigne);
        builder.append(", phone=");
        builder.append(phone);
        builder.append("]");
        return builder.toString();
    }
}
