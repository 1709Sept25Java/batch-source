package com.revature.exceptions;

public class Calculator {		
		
		public Calculator() {
			super();
		}

		/*Addition using Numbers as defined in Math SuperClass
		 * We determine datatype by getting the class of one of the numbers
		 * Then we switch based on the datatype, get values and add the numbers
		 */
		public Number addition(Number n1, Number n2) {
			String datatype = n1.getClass().getSimpleName();
			Number n;
			switch(datatype) {
		    	case "Integer":
		    		n = n1.intValue() + n2.intValue(); 
		    		break;
		    	case "Double":
		    		n = n1.doubleValue() + n2.doubleValue(); 
		    		break;
		    	case "Float":
		    		n = n1.floatValue() + n2.floatValue();
		    		break;
		    	case "Byte":
		    		n = n1.byteValue() + n2.byteValue();
		    		break;
		    	case "Short":
		    		n = n1.shortValue() + n2.shortValue();
		    		break;
		    	case "Long": 
		    		n = n1.longValue() + n2.longValue();
		    		break;
		    	default:
		    		n =  -1000000000; //error case
			}
			return n;
		
		}

		/*Multiplication using Numbers as defined in Math SuperClass
		 * We determine datatype by getting the class of one of the numbers
		 * Then we switch based on the datatype, get values and multiply the numbers
		 */
		public Number multiplication(Number n1, Number n2) {
			String datatype = n1.getClass().getSimpleName();
			Number n;
			switch(datatype) {
		    	case "Integer":
		    		n = n1.intValue() * n2.intValue(); 
		    		break;
		    	case "Double":
		    		n = n1.doubleValue() * n2.doubleValue(); 
		    		break;
		    	case "Float":
		    		n = n1.floatValue() * n2.floatValue();
		    		break;
		    	case "Byte":
		    		n = n1.byteValue() * n2.byteValue();
		    		break;
		    	case "Short":
		    		n = n1.shortValue() * n2.shortValue();
		    		break;
		    	case "Long": 
		    		n = n1.longValue() * n2.longValue();
		    		break;
		    	default:
		    		n =  -1000000000;
			}
			return n;
		}

		
		/*Division using Numbers as defined in Math SuperClass
		 * We determine datatype by getting the class of one of the numbers
		 * Then we switch based on the datatype, get values and divide the numbers
		 */
		public Number division(Integer n1, Integer n2) throws ZeroException {
			
			if (n2.equals(0)) {
				throw new ZeroException();
			}
			
			return n1/n2;
		}

}
