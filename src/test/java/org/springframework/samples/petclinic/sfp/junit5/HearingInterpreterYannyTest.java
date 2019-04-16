package org.springframework.samples.petclinic.sfp.junit5;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.sfp.BaseConfig;
import org.springframework.samples.petclinic.sfp.HearingInterpreter;
import org.springframework.samples.petclinic.sfp.YannyConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(classes = {
	BaseConfig.class,
	YannyConfig.class
})
public class HearingInterpreterYannyTest {

	@Autowired
	HearingInterpreter hearingInterpreter;

	@Test
	public void whatIHeard() {
		String word = hearingInterpreter.whatIHeard();
		assertThat(word).isEqualTo("Yanny");
	}
}
