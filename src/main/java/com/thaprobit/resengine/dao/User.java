package com.thaprobit.resengine.dao;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
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

    @Column(name = "role")
    private String role;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Reservation> reservations;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;


    @Column(name = "province")
    private String province;

    @Column(name = "country")
    private String country;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_preferred_properties",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "prop_id"))
    private Set<Property> preferredProperties;

//    public User(long userId, String address1, String address2, String city, String district, String province, String country) {
//        this.userId = userId;
//        this.address1 = address1;
//        this.address2 = address2;
//        this.city = city;
//        this.district = district;
//        this.province = province;
//        this.country = country;
//    }

    public User(){

    }



    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

}
