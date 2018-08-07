package com.konrad.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "lesson")
public class Lesson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lesson")
    private int id;
    @Column(name = "begin_time")
    private String beginTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "day")
    private MyDay Day;
    @ManyToOne
    @JoinColumn(name = "id_classroom")
    private Classroom classroom;
    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;
    @Enumerated(EnumType.STRING)
    @Column(name = "subject")
    private Subject subject;
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lesson")
    private Test test;


}
