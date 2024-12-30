package com.example.Contact_manager_web.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Builder
public class User {

    @Id
    private String userId;

    @Column(name = "userName", nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 1000)
    private String about;

    @Column(length = 1000)
    private String profilePic;

    private String phoneNumber;

    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    @Enumerated(value = EnumType.STRING)
//    SELF, GOOGLE, GITHUB;
    private Providers provider = Providers.SELF;
    private String provideId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

    @Builder
    public static User create(String userId, String name, String email, String password, String about,
                              String profilePic, String phoneNumber, boolean enabled, boolean emailVerified,
                              boolean phoneVerified, Providers provider, String provideId) {
        User user = new User();
        user.userId = userId;
        user.name = name;
        user.email = email;
        user.password = password;
        user.about = about;
        user.profilePic = profilePic;
        user.phoneNumber = phoneNumber;
        user.enabled = enabled;
        user.emailVerified = emailVerified;
        user.phoneVerified = phoneVerified;
        user.provider = provider;
        user.provideId = provideId;
        return user;
    }

}
