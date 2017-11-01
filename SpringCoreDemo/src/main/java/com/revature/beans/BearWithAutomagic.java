package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BearWithAutomagic extends Bear{

	@Autowired //@Inject is pretty much synonymous
	private Cave cave;
	
	public Cave getCave() {
		return this.cave;
	}
	
	public void methodInBear() {
		System.out.println("method in BearWithAutomagic, this is: "+this.toString());
		System.out.println("cave: "+cave.getName());
	}
	
	public void defaultInit() {
		System.out.println("default init from BearWithAutomagic");
	}
	
	public void defaultDestroy() {
		System.out.println("default destroy from BearWithAutomagic");
	}
}
