package com.job.web.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * JobSeeker
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@Table(name = "Jobseekers")
public class Jobseeker implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "seeker_id") private String seekerId;
    @Column(name = "seeker_name") private String seekerName;
    @Column(name = "password") private String password;
    @Column(name = "birth_6") private String birth6;
    @Column(name = "phone") private String phone;
    @Column(name = "email") private String email;
    @Column(name = "industry") private String industry;
    @Column(name = "location") private String location;

    public String toString(){
        return String.format("고객정보 No: %d\n"
        +"ID: %s\n"
        +"NAME: %s\n"
        +"PASS: %s\n"
        +"SSN: %s\n"
        +"PHONE: %s\n"
        +"EMAIL: %s\n"
        +"INDUSTRY: %s\n"
        +"LOCATION: %s\n"
        , id, seekerId, seekerName, password, birth6, phone, email, industry, location);
    }

    @Builder
    private Jobseeker(String seekerId, String seekerName, String password, 
                    String birth6, String phone, String email, String industry,
                    String location){
        this.seekerId = seekerId;
        this.seekerName = seekerName;
        this.password = password;
        this.birth6 = birth6;
        this.phone = phone;
        this.email = email;
        this.industry = industry;
        this.location = location;
    }
}