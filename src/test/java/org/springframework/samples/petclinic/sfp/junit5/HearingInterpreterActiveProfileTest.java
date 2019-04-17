package org.springframework.samples.petclinic.sfp.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfp.HearingInterpreter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("yanny")
@SpringJUnitConfig(classes = {
	HearingInterpreterActiveProfileTest.TestConfig.class
})
class HearingInterpreterActiveProfileTest {

	@Configuration
	@ComponentScan("org.springframework.samples.petclinic.sfp")
	static class TestConfig {

	}

	@Autowired
	HearingInterpreter hearingInterpreter;

	@Test
	void whatIHeard() {
		String word = hearingInterpreter.whatIHeard();
		assertThat(word).isEqualTo("Laurel");
	}
}