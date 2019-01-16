package com.muspro.app.dahira;

public class DahiraResponse
{
    private String name;

    private String location;

    private String address;

    private String jawrigne;

    private String phone;

    public String getName()
    {
        return name;
    }

    DahiraResponse()
    {

    }

    DahiraResponse(DahiraInfoEntity dahiraInfoEntity)
    {
        this.setName(dahiraInfoEntity.getName());
        this.setLocation(dahiraInfoEntity.getLocation());
        this.setAddress(dahiraInfoEntity.getAddress());
        this.setJawrigne(dahiraInfoEntity.getJawrigne());
        this.setPhone(dahiraInfoEntity.getPhone());
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
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("DahiraResponse [name=");
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
