package com.ashokit.phonebookapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CONTACT_DTLS")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contactId;
    private String contactName;
    private String contactEmail;
    private Long contactNum;
    private String activeSw;
}
