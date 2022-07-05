package com.test.designpatterns;

/**
 * https://refactoring.guru/design-patterns/factory-method
 * Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, 
but allows subclasses to alter the type of objects that will be created.

*
* Pros and Cons
 You avoid tight coupling between the creator and the concrete products.
 Single Responsibility Principle. You can move the product creation code into one place in the program, making the code easier to support.
 Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code.
 
  The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern. 
  The best case scenario is when you’re introducing the pattern into an existing hierarchy of creator classes.
*/

public class FactoryPattern {

	
	static class mercedesfactory {
	    enum carType {
	        SEDAN, SPORTSCAR, LUXURYCAR;
	    };

	    static mercedesfactory create(carType car) throws Exception{
	    	FactoryPattern factoryPattern = new FactoryPattern();
	        switch (car) {
	        case SEDAN:
	            return factoryPattern.new sedan();
	        case SPORTSCAR:
	            return factoryPattern.new sportscar();
	        case LUXURYCAR:
	            return factoryPattern.new luxurycar();
	        default:
	            throw new Exception(" This Car type is not supported now");
	        }
	    }

	    void showme() {
	    };
	}
	
	class sedan extends mercedesfactory
	{
	    int globalid = 0;
	    int carId;
	    public sedan(){
	        globalid++;
	        this.carId = globalid;
	    }

	    public void showme()
	    {
	        System.out.println("I am sedan car with id " + this.carId);
	    }
	}

	class sportscar extends mercedesfactory
	{
	    int globalid = 0;
	    int carId;
	    public sportscar(){
	        globalid++;
	        this.carId = globalid;
	    }

	    void showme()
	    {
	        System.out.println("I am sports car with id " + this.carId);
	    }
	}

	class luxurycar extends mercedesfactory
	{
	    int globalid = 0;
	    int carId;
	    luxurycar(){
	        globalid++;
	        this.carId = globalid;
	    }

	    void showme()
	    {
	        System.out.println("I am luxury car with id " + this.carId);
	    }
	}
	
	static class Main
	{
		public static void main(String[] args)
		{	
	        try{
	            mercedesfactory car1 = mercedesfactory.create(mercedesfactory.carType.SEDAN);
	            car1.showme();
	            mercedesfactory car2 = mercedesfactory.create(mercedesfactory.carType.LUXURYCAR);
	            car2.showme();
	            mercedesfactory car3 = mercedesfactory.create(mercedesfactory.carType.SPORTSCAR);
	            car3.showme();
	            mercedesfactory car4 = mercedesfactory.create(mercedesfactory.carType.SEDAN);
	            car4.showme();
	        }
	        catch(Exception e){

	        }
		}
	}
}
