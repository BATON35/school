package com.konrad.school.model;

import com.konrad.school.validation.CourseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @Column(name = "id_school")
    private int id;
    @Size(min = 2, message = " more then two sign")
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "proper convention is xx-xxx , x is number from 0-9")
    @Column(name = "tell_number")
    private String tellNumber;
    @Column(name = "mail")
    private String mail;
    @CourseCode()
    @Column(name = "patron")
    private String patron;
    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Classroom> classrooms;
}

