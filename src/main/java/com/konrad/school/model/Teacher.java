package com.konrad.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String position;

    private School school;
    // TODO: 01.08.2018 Let's delete col id_school from teacher table and this field
    // TODO: 01.08.2018 remove position from teacher table
}
