package com.konrad.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import sun.util.resources.LocaleData;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "test")
public class Test implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test")
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TestType type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocaleData date;
    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

}
