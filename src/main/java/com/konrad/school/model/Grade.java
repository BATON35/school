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
@Table(name = "grade")
public class Grade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grade")
    private int id;
    @Column(name = "grade")
    private String grade;
    @Column(name = "grade_mark")
    private String gradeMark;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_grade",
            joinColumns = {@JoinColumn(name = "id_grade")},
            inverseJoinColumns = {@JoinColumn(name = "id_student")})
    private List<Student> students;
}
