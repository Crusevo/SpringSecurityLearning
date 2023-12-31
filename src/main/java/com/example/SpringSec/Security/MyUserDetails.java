package com.example.SpringSec.Security;

import com.example.SpringSec.Model.Employee;
import com.example.SpringSec.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


public class MyUserDetails implements UserDetails {

    @Autowired
    Employee employee;

    public MyUserDetails(Employee employee){
        this.employee = employee;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> emploRoles = employee.getEmploRoles();

        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();
        for(Role role : emploRoles){

            simpleGrantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));

        }

        return simpleGrantedAuthorityList;

    }

    @Override
    public String getPassword() {
       return employee.getPassword();
    }

    @Override
    public String getUsername() {
        return employee.getEmploName();
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
