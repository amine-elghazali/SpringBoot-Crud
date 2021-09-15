package com.bootSpring.Springboot.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class School implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long schoolId;

    @Column(
            columnDefinition = "TEXT"
    )
    private String schoolName;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "school",
            cascade = CascadeType.ALL
              // this one should be EAGER , to get the departments
    )
    private List<Department> departments;
}
