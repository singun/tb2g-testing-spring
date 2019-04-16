package org.springframework.samples.petclinic.sfp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
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
