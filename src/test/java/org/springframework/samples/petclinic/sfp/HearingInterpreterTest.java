package org.springframework.samples.petclinic.sfp;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HearingInterpreterTest {

	HearingInterpreter hearingInterpreter;

	@Before
	public void setUp() {
		hearingInterpreter = new HearingInterpreter(new LaurelWordProducer());
	}

	@Test
	public void whatIHeard() {
		String word = hearingInterpreter.whatIHeard();
		assertThat(word).isEqualTo("Laurel");
	}
}