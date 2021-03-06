package com.tts.eCommerceProject.ecommerceproject.models;

import java.util.Collection;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {
//    This is how you make an auto-generated Id!! //////
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    Strings for username that can't be null/empty
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

//    Map for the "cart"
    @ElementCollection
    Map<Product, Integer> cart;

//    lines 29-52 are generated when implementing UserDetails
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

//    empty constructor
    public User() {
    }

//  constructor w/ everything but id
    public User(@NotEmpty String username, @NotEmpty String password, Map<Product, Integer> cart) {
        this.username = username;
        this.password = password;
        this.cart = cart;
    }

//    Getters (with everything)

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }


//    Setters (omit id)

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

//    toSting method (including everything)
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cart=" + cart +
                '}';
    }
}
