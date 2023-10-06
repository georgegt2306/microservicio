package com.datos.personales.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.datos.personales.dto.PersonalInformationDTO;
import com.datos.personales.execption.ModelNotFoundException;
import com.datos.personales.execption.NewModelNotFoundException;
import com.datos.personales.model.PersonalInformation;
import com.datos.personales.service.IPersonalInformationService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/informations")
public class PersonalInformationController {
	
	    @Qualifier("defaultMapper")
	    private final ModelMapper mapper;
	    
	    private final IPersonalInformationService service;
	    
	    @GetMapping
	    public ResponseEntity<List<PersonalInformationDTO>> findAll(){
	        List<PersonalInformationDTO> list = service.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	        return new ResponseEntity<>(list, OK);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<PersonalInformationDTO> findById(@PathVariable("id") Integer id){
	    	PersonalInformation obj = service.findById(id);

	        if(obj == null){
	            throw new ModelNotFoundException("ID NOT FOUND" + id);
	        }
	        return new ResponseEntity<>(this.convertToDto(obj), OK);
	    }
	    
	    @Transactional
	    @PostMapping
	    public ResponseEntity<Void> save(@Valid @RequestBody PersonalInformationDTO dto){
	    	PersonalInformation obj = service.save(convertToEntity(dto));
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	        return ResponseEntity.created(location).build();
	    }
	    
	    @Transactional
	    @PutMapping("/{id}")
	    public ResponseEntity<PersonalInformationDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody PersonalInformationDTO dto){
	    	PersonalInformation obja = service.findById(id);
	        if(obja == null){
	            throw new ModelNotFoundException("ID NOT FOUND" + id);
	        }
	        dto.setId(id);
	        PersonalInformation objb = service.update(convertToEntity(dto), id);
	        return new ResponseEntity<>(convertToDto(objb), OK);
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
	    	PersonalInformation obj = service.findById(id);

	        if(obj == null){
	            throw new NewModelNotFoundException("ID  FOUND " + id);
	        }
	        service.delete(id);
	        return new ResponseEntity<>(NO_CONTENT);
	    }
	   
	    private PersonalInformationDTO convertToDto(PersonalInformation obj){
	        return mapper.map(obj, PersonalInformationDTO.class);
	    }
	
	    private PersonalInformation convertToEntity(PersonalInformationDTO dto){
	        return mapper.map(dto, PersonalInformation.class);
	    }

}
