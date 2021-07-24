package com.mua.hbs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class LoginCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loginCredentialId;

    @Column(unique = true)
    private String username;
    private String password;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private User user;
}
