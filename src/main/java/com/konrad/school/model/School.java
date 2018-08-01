package com.konrad.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "school")
public class School implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "names")
    private String names;
    @Column(name = "addres")
    private String address;
    @Column(name = "tel_number")
    private String tellNumber;
    @Column(name = "mail")
    private String mail;
    @Column(name = "patron")
    private String patron;
    @OneToMany(mappedBy = "school")
    private List<Classroom> classrooms;
}

