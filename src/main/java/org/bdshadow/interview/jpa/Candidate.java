package org.bdshadow.interview.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidate")
@Data
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "money")
    private Integer money;
}


