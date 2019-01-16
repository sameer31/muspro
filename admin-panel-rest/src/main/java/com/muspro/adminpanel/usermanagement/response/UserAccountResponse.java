package com.muspro.adminpanel.usermanagement.response;

import com.muspro.adminpanel.usermanagement.model.UserAccountEntity;

public final class UserAccountResponse
{

    private String screenUserName;

    private String firstName;

    private String lastName;

    private String email;

    public UserAccountResponse()
    {

    }

    public UserAccountResponse(UserAccountEntity userAccountEntity)
    {
        this.setScreenUserName(userAccountEntity.getScreenUserName());
        this.setFirstName(userAccountEntity.getUserDetails().getFirstName());
        this.setLastName(userAccountEntity.getUserDetails().getLastName());
        this.setEmail(userAccountEntity.getUserDetails().getEmail());
    }

    public String getScreenUserName()
    {
        return screenUserName;
    }

    public void setScreenUserName(String screenUserName)
    {
        this.screenUserName = screenUserName;
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

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("UserAccountRequest [screenUserName=");
        builder.append(screenUserName);
        builder.append(", firstName=");
        builder.append(firstName);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", email=");
        builder.append(email);
        builder.append("]");
        return builder.toString();
    }

}
