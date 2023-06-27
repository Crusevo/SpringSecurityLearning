package com.example.SpringSec.Security;

import com.example.SpringSec.Emplo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailSer implements UserDetails {

    private String name;

    private String pass;

    private String role;



    public UserDetailSer (Emplo emplo){

        this.name = emplo.getName();

        this.pass = emplo.getPass();

        this.role = emplo.getRole();

    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList((new SimpleGrantedAuthority(role)));
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
