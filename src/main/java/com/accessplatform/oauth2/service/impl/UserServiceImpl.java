package com.accessplatform.oauth2.service.impl;

import java.util.List;

import com.accessplatform.oauth2.domain.*;
import com.accessplatform.oauth2.dao.UserDao;
import com.accessplatform.oauth2.dao.impl.UserDetailsImpl;
import com.accessplatform.oauth2.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author lichaofan
 */
@Service("userService")
public class UserServiceImpl implements UserService 
{

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
    	String hql = "select u from User u where u.username=?1";
		List<User>users = userDao.find(hql, username);
		User user = users.get(0);
        if (user == null) 
        {
            throw new UsernameNotFoundException("Not found any user for username[" + username + "]");
        }

        return new UserDetailsImpl(user);
    }
}