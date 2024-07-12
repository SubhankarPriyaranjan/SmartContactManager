package com.scm.entities;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user") // This is for creating Table and use as entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private String userid;

    @Column(name = "username", nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;
    private String phone_number;
    private String password;

    @Column(length = 1000)
    private String about;

    private String proflePic;

    private boolean enabled = false;

    private boolean emailVerified = false;

    private boolean phoneVerified = false;

    // SELF, GOOGLE, Github,
    private Providers provider = Providers.SELF;

    private String providerId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contacts> contacts=new ArrayList<>();
    // /* mappedBy = "user" -This is for one user having many contact and many contact having one user
    // One User: A single User object can have multiple Contacts associated with it.
    // Many Contacts: Each Contact object belongs to exactly one User.*/

    
    
}
