package com.revature.utility;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="CalculatorService")
@Scope(value="prototype")
public class CalculatorService {


	public static void main(String[] args) {

	}
	
	private Number add;
	private Number subtract;
	private Number multiply;
	private Number divide;
	public CalculatorService() {
		super();
		
	}
	public CalculatorService(Number add, Number subtract, Number multiply, Number divide) {
		super();
		this.add = add;
		this.subtract = subtract;
		this.multiply = multiply;
		this.divide = divide;
	}
	public Number getAdd (Number a, Number b) { 
	
		if(a instanceof Double && b instanceof Double) {
	        add  = new Double(a.doubleValue() + b.doubleValue());
	        return add;
	    } else if(a instanceof Float && b instanceof Float) {
	        add = new Float(a.floatValue() + b.floatValue());
	        return add;
	    } else if(a instanceof Long && b instanceof Long) {
	        add = new Long(a.longValue() + b.longValue());
	        return add;
	    } else {
	       add= new Integer(a.intValue() + b.intValue());
	       return add;
	    }
		
	}
	public void setAdd(Number add) {
		this.add = add;
	}
	public Number getSubtract( Number a, Number b) {
		if(a instanceof Double && b instanceof Double) {
	        subtract = new Double(a.doubleValue() - b.doubleValue());
	        return subtract ;
	    } else if(a instanceof Float && b instanceof Float) {
	        subtract = new Float(a.floatValue() - b.floatValue());
	        return subtract;
	    } else if(a instanceof Long && b instanceof Long) {
	        subtract = new Long(a.longValue() - b.longValue());
	        return subtract;
	    } else {
	       subtract= new Integer(a.intValue() - b.intValue());
	       return subtract;
	    }
		
		
	}
	public void setSubtract(Number subtract) {
		this.subtract = subtract;
	}
	public Number getMultiply() {
		return multiply;
	}
	public void setMultiply(Number multiply) {
		this.multiply = multiply;
	}
	public Number getDivide() {
		return divide;
	}
	public void setDivide(Number divide) {
		this.divide = divide;
	}
	
	

}
