package org.springframework.samples.petclinic.service;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class ClinicServiceImplTest {

	@Mock
	PetRepository petRepository;

	@InjectMocks
	ClinicServiceImpl clinicService;

	@Test
	public void findPetTypes() {
		// given
		List<PetType> petTypeList = new ArrayList<>();
		given(petRepository.findPetTypes()).willReturn(petTypeList);

		// when
		Collection<PetType> petTypes = clinicService.findPetTypes();

		// then
		then(clinicService).should().findPetTypes();
		assertThat(petTypes).isNotNull();
	}
}