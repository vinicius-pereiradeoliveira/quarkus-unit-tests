package org.acme.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    private String registry;

    private String phone;

}
