package com.accessplatform.oauth2.domain;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import com.accessplatform.oauth2.domain.*;
import com.accessplatform.oauth2.utils.GuidGenerator;

import javax.persistence.*;

@Entity
@Table(name="user_")
public class User implements Serializable
{

    @Id
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    //Default user is initial when create database, do not delete
    private boolean defaultUser = false;
    private int archived;
    private Date lastLoginTime;
    private Date create_time;
    protected String guid = GuidGenerator.generate();
 
    public User(Integer id, String username, String password, String phone, String email, boolean defaultUser, int archived, Date lastLoginTime, Date create_time) 
    {
    	this.id = id;
    	this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.defaultUser = defaultUser;
        this.lastLoginTime = lastLoginTime;
        this.create_time = create_time;
    }
    public User()
    {
    	
    }
  
    public User(String username, String password, String phone, String email) 
    {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
    public String getGuid() 
    {
        return guid;
    }

    public void setGuid(String guid) 
    {
        this.guid = guid;
    }

    public Date getCreate_time()
    {
    	return create_time;
    }
    public void setCreate_time(Date time)
    {
    	this.create_time = time;
    }
    public int getArchived()
    {
    	return archived;
    }
    public void setArchived(int archived)
    {
    	this.archived = archived;
    }

    public boolean getDefaultUser() 
    {
        return defaultUser;
    }

    public String getUsername() 
    {
        return username;
    }  
    
    public void setUsername(String username) 
    {
        this.username = username;
        
    }


    public String getPassword() 
    {
        return password;
    }
    
    public void setPassword(String password)
    {
    	this.password = password;
    }

    public String getPhone() 
    {
        return phone;
    } 
    
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }


    public String getEmail() 
    {
        return email;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    } 
    
    public Date getLastLoginTime() 
    {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) 
    {
        this.lastLoginTime = lastLoginTime;
    }
    
    @Override
    public boolean equals(Object o) 
    {
        if (this == o) 
        {
            return true;
        }
        if (!(o instanceof User)) 
        {
            return false;
        }
        User that = (User) o;
        return guid.equals(that.guid);
    }

    @Override
    public int hashCode() 
    {
        return guid.hashCode();
    }
    @Override
    public String toString() 
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("{username='").append(username).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", guid='").append(guid).append('\'');
        sb.append(", defaultUser='").append(defaultUser).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
    
    
 
}