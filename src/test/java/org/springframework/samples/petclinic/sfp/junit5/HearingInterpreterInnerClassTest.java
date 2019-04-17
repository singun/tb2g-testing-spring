package org.springframework.samples.petclinic.sfp.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfp.HearingInterpreter;
import org.springframework.samples.petclinic.sfp.LaurelWordProducer;
import org.springframework.samples.petclinic.sfp.WordProducer;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(classes = {
	HearingInterpreterInnerClassTest.TestConfig.class
})
public class HearingInterpreterInnerClassTest {

	@Configuration
	static class TestConfig {
		@Bean
		HearingInterpreter hearingInterpreter(WordProducer wordProducer) {
			return new HearingInterpreter(new LaurelWordProducer());
		}
	}

	@Autowired
	HearingInterpreter hearingInterpreter;

	@Test
	public void whatIHeard() {
		String word = hearingInterpreter.whatIHeard();
		assertThat(word).isEqualTo("Laurel");
	}
}