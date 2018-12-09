package com.muspro.adminpanel.usermanagement.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//      CREATE TABLE `link_external_item` (
//        `id` int(11) NOT NULL,
//        `user_account_id` int(11) DEFAULT NULL,
//        `name` varchar(45) DEFAULT NULL,
//        `is_done` tinyint(4) DEFAULT NULL,
//        `creation_date` date DEFAULT NULL,
//        `deadline_date` date DEFAULT NULL,
//        PRIMARY KEY (`id`),
//        KEY `fk_user_account_id_idx` (`user_account_id`),
//        KEY `fk_user_account_id_idx1` (`user_account_id`),
//        CONSTRAINT `fk_user_account_id1` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
//      )

@Entity
public class LinkExternalItem
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userAccountId;

    private String name;

    private boolean isDone;

    private Date creationDate;

    private Date deadlineDate;

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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isDone()
    {
        return isDone;
    }

    public void setDone(boolean isDone)
    {
        this.isDone = isDone;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public Date getDeadlineDate()
    {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate)
    {
        this.deadlineDate = deadlineDate;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result + ((deadlineDate == null) ? 0 : deadlineDate.hashCode());
        result = prime * result + id;
        result = prime * result + (isDone ? 1231 : 1237);
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
        LinkExternalItem other = (LinkExternalItem) obj;
        if (creationDate == null)
        {
            if (other.creationDate != null)
                return false;
        }
        else if (!creationDate.equals(other.creationDate))
            return false;
        if (deadlineDate == null)
        {
            if (other.deadlineDate != null)
                return false;
        }
        else if (!deadlineDate.equals(other.deadlineDate))
            return false;
        if (id != other.id)
            return false;
        if (isDone != other.isDone)
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
        builder.append("LinkExternalItem [id=");
        builder.append(id);
        builder.append(", userAccountId=");
        builder.append(userAccountId);
        builder.append(", name=");
        builder.append(name);
        builder.append(", isDone=");
        builder.append(isDone);
        builder.append(", creationDate=");
        builder.append(creationDate);
        builder.append(", deadlineDate=");
        builder.append(deadlineDate);
        builder.append("]");
        return builder.toString();
    }

}
