package com.konrad.school.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lesson")
public class Lesson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lesson")
    private int id;
    @Column(name = "begin_time")
    private String beginTime;
    @Column(name = "day")
    private String Day;

    private int idClassroom;
    private int idSubject;
    private int idTeacher;
    private int idGroup;
}
