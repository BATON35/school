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
@Table(name = "parent")
public class Parent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parent")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "mail")
    private String mail;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_parent",
    joinColumns = {@JoinColumn(name = "id_parent")},
    inverseJoinColumns = {@JoinColumn(name = "id_student")})
    private List<Student> students;


}
