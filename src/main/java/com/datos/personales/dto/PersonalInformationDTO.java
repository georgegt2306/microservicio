package com.datos.personales.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.datos.personales.model.PersonalInformation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(toBuilder = true)
public class PersonalInformationDTO implements Serializable {
	

	@Serial
	private static final long serialVersionUID = 1L;
	
    @EqualsAndHashCode.Include
	private Integer id;
    
    private String firstName;

    private String lastName;

    private Integer age;
    
    private String address;
    
    private String email;
    
	private Date birthDate;
    
	private String phone;
    
	private String estate;

}
