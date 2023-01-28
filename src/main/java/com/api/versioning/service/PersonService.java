package com.api.versioning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.versioning.model.PersonV1;
import com.api.versioning.model.PersonV2;

@Service
public class PersonService {

	private List<PersonV1> listV1;
	private List<PersonV2> listV2;
	
	public List<PersonV1> getAllV1() {

		listV1 = new ArrayList<PersonV1>(List.of(new PersonV1("Priyanka Chopra"),
				  new PersonV1("Deepika Padukon"), new PersonV1("Aishwarya Rai")
				));
		
		return listV1;
	}

	public List<PersonV2> getAllV2() {
		
		listV2 = new ArrayList<PersonV2>(List.of(new PersonV2("Priyanka", "Chopra"),
				 new PersonV2("Deepika", "Padukon"), new PersonV2("Rashi", "khanna"),
				 new PersonV2("Rashmika", "Mandana")));
		return listV2;
	}

}
