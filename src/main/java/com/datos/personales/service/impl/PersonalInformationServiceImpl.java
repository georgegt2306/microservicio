package com.datos.personales.service.impl;

import org.springframework.stereotype.Service;
import com.datos.personales.irepo.IGenericRepo;
import com.datos.personales.irepo.IPersonalInformationRepo;
import com.datos.personales.model.PersonalInformation;
import com.datos.personales.service.IPersonalInformationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonalInformationServiceImpl extends CRUDImpl<PersonalInformation, Integer> 
	implements IPersonalInformationService {
	
	private final IPersonalInformationRepo repo;

	@Override
	protected IGenericRepo<PersonalInformation, Integer> getRepo() {
		return repo;
	}

}
