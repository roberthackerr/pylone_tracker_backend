package com.example.demo.entity;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "User")
public class User implements UserDetails {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id; 
private String name;
private String lastname;
private String birthday;
private String email;
private String phoneNumber;
private String password;
public void setPassword(String password) {
    this.password = password;
}

public User(String name, String lastname, String birthday, String email, String phoneNumber, String password) {
    this.name = name;
    this.lastname = lastname;
    this.birthday = birthday;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.password = password;
}
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(
    name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id")
)
private Set<Role> roles=new HashSet<>();
public Set<Role> getRoles() {
    return roles;
}

public User(){

}
public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getLastname() {
    return lastname;
}
public void setLastname(String lastname) {
    this.lastname = lastname;
}
public String getBirthday() {
    return birthday;
}
public void setBirthday(String birthday) {
    this.birthday = birthday;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getPhoneNumber() {
    return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    Set<SimpleGrantedAuthority> authorities = new HashSet<>();
    for (Role role : roles) {
        authorities.add(new SimpleGrantedAuthority(role.getName()));
    }
    return authorities;
}
@Override
public String getPassword() {
    return this.password;
}
@Override
public String getUsername() {
    return this.getEmail();
}

@Override
public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return UserDetails.super.isAccountNonExpired();
}

@Override
public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
}

@Override
public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
}

@Override
public boolean isEnabled() {
    // TODO Auto-generated method stub
    return false;
}
}
