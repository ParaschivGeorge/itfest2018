package com.twoguysonepanda.itfest2018.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.twoguysonepanda.itfest2018.entities.enums.UserType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class  User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType type;

    @JsonIgnore
    @Column(nullable = false)
    private boolean enabled;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
//    @NotNull
    private Date lastPasswordResetDate;

    @Column(name="last_login_date")
    private Date lastLoginDate;

    @JsonIgnore
    @Column(name="current_login_date")
    private Date currentLoginDate;

    @Lob
    private byte[] analyse;

    @OneToOne(mappedBy = "user")
    private Reservation reservation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Date lastDonationDate;

    private Date nextDonationDate;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getCurrentLoginDate() {
        return currentLoginDate;
    }

    public void setCurrentLoginDate(Date currentLoginDate) {
        this.currentLoginDate = currentLoginDate;
    }

    public User() {
    }

    public User(String username, String email, UserType type, boolean enabled, String password, Date lastPasswordResetDate, Date lastLoginDate, Date currentLoginDate) {
        this.username = username;
        this.email = email;
        this.type = type;
        this.enabled = enabled;
        this.password = password;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.lastLoginDate = lastLoginDate;
        this.currentLoginDate = currentLoginDate;
    }

    public byte[] getAnalyse() {
        return analyse;
    }

    public void setAnalyse(byte[] analyse) {
        this.analyse = analyse;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Date getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(Date lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }

    public Date getNextDonationDate() {
        return nextDonationDate;
    }

    public void setNextDonationDate(Date nextDonationDate) {
        this.nextDonationDate = nextDonationDate;
    }
}
