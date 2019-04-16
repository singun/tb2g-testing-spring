package org.springframework.samples.petclinic.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class VetControllerTest {

	@Mock
	ClinicService clinicService;

	@Mock
	Map<String, Object> model;

	@InjectMocks
	VetController vetController;

	List<Vet> vetList = new ArrayList<>();

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		vetList.add(new Vet());

		// given
		given(clinicService.findVets()).willReturn(vetList);
	}

	@Test
	public void showVetList() {
		// when
		String show= vetController.showVetList(model);

		// then
		then(clinicService).should().findVets();
		then(model).should().put(anyString(), any());
		assertThat(show).isEqualToIgnoringCase("vets/vetList");
	}

	@Test
	public void showResourcesVetList() {
		// when
		Vets vets = vetController.showResourcesVetList();

		// then
		then(clinicService).should().findVets();
		assertThat(vets).isNotNull();
	}
}