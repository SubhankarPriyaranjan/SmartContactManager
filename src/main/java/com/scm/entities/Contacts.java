package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String picture;
    @Column(length = 1000)
    private String description;
    private String favorite;
    private String websitelink;
    private String linkedinlink;
    private List<String> socialLinks=new ArrayList<>();

    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SocialLink> Links=new ArrayList<>();
    @ManyToOne
    private User user;

}
