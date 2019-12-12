package com.remote.united_shop.Core.Security;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;
import com.remote.united_shop.data.entities.AppUser;
import com.remote.united_shop.services.AbstractService.AbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AbstractUserService userService;

    /***
     *
     * @param email
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = null;
        try {
            appUser = userService.loadUserByEmail(email);
        } catch (NoDataFoundException e) {
            e.printStackTrace();
        }
        if(appUser ==null) throw new UsernameNotFoundException("invalid user");
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        appUser.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getName()));
        });
        return new User(appUser.getEmail(), appUser.getPassword(),authorities);
    }
}
