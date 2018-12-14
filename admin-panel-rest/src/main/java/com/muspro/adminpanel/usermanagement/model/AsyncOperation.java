package com.muspro.adminpanel.usermanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AsyncOperation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int externalAuthenticationProviderId;

    private int asyncOperationStatusTypeId;

    private int userExternalLoginId;

    public AsyncOperation()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getExternalAuthenticationProviderId()
    {
        return externalAuthenticationProviderId;
    }

    public void setExternalAuthenticationProviderId(int externalAuthenticationProviderId)
    {
        this.externalAuthenticationProviderId = externalAuthenticationProviderId;
    }

    public int getAsyncOperationStatusTypeId()
    {
        return asyncOperationStatusTypeId;
    }

    public void setAsyncOperationStatusTypeId(int asyncOperationStatusTypeId)
    {
        this.asyncOperationStatusTypeId = asyncOperationStatusTypeId;
    }

    public int getUserExternalLoginId()
    {
        return userExternalLoginId;
    }

    public void setUserExternalLoginId(int userExternalLoginId)
    {
        this.userExternalLoginId = userExternalLoginId;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + asyncOperationStatusTypeId;
        result = prime * result + externalAuthenticationProviderId;
        result = prime * result + id;
        result = prime * result + userExternalLoginId;
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
        AsyncOperation other = (AsyncOperation) obj;
        if (asyncOperationStatusTypeId != other.asyncOperationStatusTypeId)
            return false;
        if (externalAuthenticationProviderId != other.externalAuthenticationProviderId)
            return false;
        if (id != other.id)
            return false;
        if (userExternalLoginId != other.userExternalLoginId)
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("AsyncOperation [id=");
        builder.append(id);
        builder.append(", externalAuthenticationProviderId=");
        builder.append(externalAuthenticationProviderId);
        builder.append(", asyncOperationStatusTypeId=");
        builder.append(asyncOperationStatusTypeId);
        builder.append(", userExternalLoginId=");
        builder.append(userExternalLoginId);
        builder.append("]");
        return builder.toString();
    }

}
