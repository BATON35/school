package com.konrad.school.model;

import com.konrad.school.validation.FieldMatch;
import com.konrad.school.validation.ValidEmail;
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
@FieldMatch.List({
        @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
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
    @ValidEmail
    @Column(name = "mail")
    private String mail;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_parent",
            joinColumns = {@JoinColumn(name = "id_parent")},
            inverseJoinColumns = {@JoinColumn(name = "id_student")})
    private List<Student> students;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "id_parent"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
            private List<Role> roles;

    // TODO: 16.08.2018 let's change users_roles to parent_role

}
