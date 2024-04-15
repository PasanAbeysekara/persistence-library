package com.thaprobit.resengine.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

/*    @Column(name = "middle_name")
    private String middleName;*/

    @Column(name = "last_name")
    private String lastName;

/*    @Column(name = "birthday")
    private Date birthday;*/

    @Column(name = "role")
    private String role;

    @Column(name = "google_id")
    private String googleId;

    @Column(name = "facebook_id")
    private String facebookId;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Reservation> reservations;
    public User() {

    }


}