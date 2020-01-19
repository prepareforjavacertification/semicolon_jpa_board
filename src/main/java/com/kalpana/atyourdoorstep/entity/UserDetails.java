package com.kalpana.atyourdoorstep.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "USER_DETAILS")
@Access(AccessType.FIELD)
public class UserDetails implements Serializable {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
    @SequenceGenerator(name = "user_id_gen", sequenceName = "USER_ID_SEQ1")
    private Long userId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "IS_PRIME")
    private boolean isPrime = Boolean.FALSE;

    @Column(name = "USER_FIRST_NAME")
    private String userFirstName;

    @Column(name = "USER_LAST_NAME")
    private String userLastName;

    @Column(name = "GENDER")
    private char gender;

    private transient String title;

    @Column(name = "FULL_NAME")
    @Transient
    private String fullName;

    @Column(name = "USER_CREATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userCreatedOn;

    @Column(name = "USER_UPDATED_PASSWORD_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userUpdatedPasswordOn;

    @Embedded
    private UserAddress userAddress;

    @Temporal(TemporalType.DATE)
    @Column(name = "SYS_CREATION_DATE")
    private Date sysCreationDate = new Date();

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "USER_IMAGE")
    private byte[] userImage;

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Access(AccessType.PROPERTY)
    public String getFullName() {
        StringBuilder fullNameSb = new StringBuilder();
        fullName = fullNameSb.append(title).append(" ").append(userFirstName).append(" ").append(userLastName).toString();
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsPrime() {
        return isPrime;
    }

    public void setIsPrime(boolean isPrime) {
        this.isPrime = isPrime;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public Date getUserCreatedOn() {
        return userCreatedOn;
    }

    public void setUserCreatedOn(Date userCreatedOn) {
        this.userCreatedOn = userCreatedOn;
    }

    public Date getUserUpdatedPasswordOn() {
        return userUpdatedPasswordOn;
    }

    public void setUserUpdatedPasswordOn(Date userUpdatedPasswordOn) {
        this.userUpdatedPasswordOn = userUpdatedPasswordOn;
    }

    public Date getSysCreationDate() {
        return sysCreationDate;
    }

    public void setSysCreationDate(Date sysCreationDate) {
        this.sysCreationDate = sysCreationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

}
