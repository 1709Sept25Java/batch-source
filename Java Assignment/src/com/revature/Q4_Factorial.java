package com.revature;

public class Q4_Factorial {
		//method for calculating a factorial number
        public static void main(String args[]){ 
        	
         int i,fact=1;  
         int number=10;  
         for(i=1;i<=number;i++){    
             fact=fact*i;    
         }    
         System.out.println("Factorial of "+number+" is: "+fact);    
        }  
       }  

