package com.mimmey.engine.business.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Data
public class User implements UserDetails {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotBlank
    @Email(regexp = ".+\\..+")
    private String email;

    @Column
    @NotBlank
    @Size(min = 5, message = "Password should contain at least 5 characters")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Quiz> quizzes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Completion> completions;

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
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
