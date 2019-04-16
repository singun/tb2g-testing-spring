package org.springframework.samples.petclinic.sfp;

import org.springframework.stereotype.Component;

@Component
public class YannyWordProducer implements WordProducer {
	@Override
	public String getWord() {
		return "Yanny";
	}
}
