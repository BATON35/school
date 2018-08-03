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
    @Column(name = "day")
    private String Day;
    @ManyToOne
    @JoinColumn(name = "id_classroom")
    private Classroom classroom;
    private int subject;
    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;
    private int group;
}
