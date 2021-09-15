package com.bootSpring.Springboot.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data   // Lombok => getter , setters , ToString  ..
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    /*  Some validation annotations :
    *   @Lenght(max=5,min=1)
    *   @Size(max=10,min=0)
    *   @Email  // for Email we can add the regex ofc :)
    *   @Positive
    *   @Negative
    *   @PositiveOrZeRo
    *   @Future
    *   @FutureOrPresent
    *   @Past
    *   @PastOrPresent
    *   @NotNull
    *   ...
    * */

    @NotBlank(message = "Please enter the department name !")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

   @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "school_id"
    )
   @JsonIgnore
   private School school;

}
