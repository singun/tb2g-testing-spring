package org.springframework.samples.petclinic.sfp;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("yanny")
@Component
@Primary
public class YannyWordProducer implements WordProducer {
	@Override
	public String getWord() {
		return "Yanny";
	}
}
