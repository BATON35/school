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
//@Entity
//@Table(name = "teacher")
public class Teacher implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String position;
}
