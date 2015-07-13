package com.accessplatform.oauth2.dao.impl;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.accessplatform.oauth2.domain.*;

public class UserDetailsImpl implements UserDetails 
{

    protected static final String ROLE_PREFIX = "ROLE_";
    protected static final GrantedAuthority DEFAULT_USER_ROLE = new SimpleGrantedAuthority(ROLE_PREFIX + "USER");

    protected User user;


    public UserDetailsImpl() 
    {
    }

    public UserDetailsImpl(User user) 
    {
        this.user = user;
    }

    
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return Arrays.asList(DEFAULT_USER_ROLE, new SimpleGrantedAuthority(ROLE_PREFIX + "UNITY"), new SimpleGrantedAuthority(ROLE_PREFIX + "MOBILE"));
    }

    @Override
    public String getPassword() 
    {
        return user.getPassword();
    }

    @Override
    public String getUsername() 
    {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() 
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isEnabled() 
    {
        return true;
    }

    public User getUser() 
    {
        return user;
    }


    @Override
    public String toString() 
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("{user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
