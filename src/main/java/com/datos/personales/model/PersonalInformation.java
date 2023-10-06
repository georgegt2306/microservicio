package com.datos.personales.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TBL_INFORMATION")
public class PersonalInformation {
	
    @jakarta.persistence.Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INF_ID", unique = true, nullable = false)
    private Integer id;
    

    @Column(name = "INF_FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "INF_LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "INF_AGE", nullable = false)
    private Integer age;
    
    @Column(name = "INF_ADDRESS", nullable = false)
    private String address;
    
    @Column(name = "INF_EMAIL", nullable = false)
    private String email;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INF_BIRTH_DATE", nullable = false)
	private Date birthDate;
    
    @Column(name = "INF_PHONE", nullable = false)
	private String phone;
    
    @Column(name = "INF_ESTATE", nullable = false)
	private String estate;

}
