//package com.baconfire.onboardwebapp.domain.common;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//public class MyUserDetails implements UserDetails {
//
//    private String userName;
//    private String password;
//    private boolean active;
//    private List<SimpleGrantedAuthority> authorities;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    @JsonIgnore
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
//
//    public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
//        this.authorities = authorities;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    @JsonIgnore
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}