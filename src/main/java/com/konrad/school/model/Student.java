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
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "mail")
    private String mail;
    @ManyToOne
    @JoinColumn(name = "id_group")
    private Group group;

    @ManyToMany(mappedBy = "students",fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Parent> parents;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "student_grade",
            joinColumns = {@JoinColumn(name = "id_student")},
            inverseJoinColumns = {@JoinColumn(name = "id_grade")})
    private List<Student> students;
}
