package com.test.designpatterns;

/**
 * https://refactoring.guru/design-patterns/abstract-factory
 * Abstract Factory is a creational design pattern that 
 * lets you produce families of related objects without specifying their concrete classes.
 * 
 * Applicability
 Use the Abstract Factory when your code needs to work with various families of related products, but you don’t want it to 
 depend on the concrete classes of those products—they might be unknown beforehand or you simply want to allow for future 
 extensibility.
 * 
 * Pros and Cons
 You can be sure that the products you’re getting from a factory are compatible with each other.
 You avoid tight coupling between concrete products and client code.
 Single Responsibility Principle. You can extract the product creation code into one place, making the code easier to support.
 Open/Closed Principle. You can introduce new variants of products without breaking existing client code.
 The code may become more complicated than it should be, since a lot of new interfaces and classes are introduced along with the pattern.
 */

public class AbstractFactoryPattern {
	
	static class myabstractfactory {
	    enum cartype {
	        SEDAN_USA, SPORTSCAR_USA, LUXURYCAR_USA, SEDAN_INDIA, SPORTSCAR_INDIA, LUXURYCAR_INDIA, SEDAN_CHINA,
	        SPORTSCAR_CHINA, LUXURYCAR_CHINA;
	    };

	    static car createCar(cartype car) throws Exception {
	        switch (car) {
	        case SEDAN_USA:
	            return usafactory.createCarIn(car);
	        case SPORTSCAR_USA:
	            return usafactory.createCarIn(car);
	        case SEDAN_INDIA:
	            return indiafactory.createCarIn(car);
	        case SPORTSCAR_CHINA:
	            return chinafactory.createCarIn(car);
	        case LUXURYCAR_INDIA:
	            return indiafactory.createCarIn(car);
	        default:
	            return indiafactory.createCarIn(cartype.SEDAN_INDIA);
	        }
	    }
	}
	
	static class usafactory extends myabstractfactory {
	    static car createCarIn(myabstractfactory.cartype cart) throws Exception {
	    	AbstractFactoryPattern abstractFactoryPattern = new AbstractFactoryPattern();
	        switch (cart) {
	        case SEDAN_USA:
	            return abstractFactoryPattern.new sedan("USA");
	        case LUXURYCAR_USA:
	            return abstractFactoryPattern.new luxurycar("USA");
	        case SPORTSCAR_USA:
	            return abstractFactoryPattern.new sportscar("USA");
	        default:
	            return abstractFactoryPattern.new sedan("USA");
	        }
	    }
	}

	static class indiafactory extends myabstractfactory {
	    static car createCarIn(myabstractfactory.cartype cart) {
	    	AbstractFactoryPattern abstractFactoryPattern = new AbstractFactoryPattern();
	        switch (cart) {
	        case SEDAN_INDIA:
	            return abstractFactoryPattern.new sedan("INDIA");
	        case LUXURYCAR_INDIA:
	            return abstractFactoryPattern.new luxurycar("INDIA");
	        case SPORTSCAR_INDIA:
	            return abstractFactoryPattern.new sportscar("INDIA");
	        default:
	            return abstractFactoryPattern.new sedan("USA");
	        }
	    }
	}

	static class chinafactory extends myabstractfactory {
	    static car createCarIn(myabstractfactory.cartype cart) {
	    	AbstractFactoryPattern abstractFactoryPattern = new AbstractFactoryPattern();
	        switch (cart) {
	        case SEDAN_CHINA:
	            return abstractFactoryPattern.new sedan("CHINA");
	        case LUXURYCAR_CHINA:
	            return abstractFactoryPattern.new luxurycar("CHINA");
	        case SPORTSCAR_CHINA:
	            return abstractFactoryPattern.new sportscar("CHINA");
	        default:
	            return abstractFactoryPattern.new sedan("USA");
	        }
	    }
	}
	
	class car
	{
	    protected String location;
	    protected int id;
	    protected String type;
	    car()
	    {

	    }
	    void getDetails()
	    {
	        System.out.println("I am a " + this.type + " with id "+ this.id + ", manufactured in " + this.location);
	    };
	    void getLocation(){
	        System.out.println("I was manufactured in " + this.location);
	    };
	}
	
	class sedan extends car
	{   
	    int globalId = 0;
	    sedan(String location)
	    {
	        globalId++;
	        this.id = globalId;
	        this.location = location;
	        this.type = "sedan";
	    }
	}

	class sportscar extends car
	{   
	    int globalId = 0;
	    sportscar(String location)
	    {
	        globalId++;
	        this.id = globalId;
	        this.location = location;
	        this.type = "sports car";
	    }
	}

	class luxurycar extends car
	{   
	    int globalId = 0;
	    luxurycar(String location)
	    {
	        globalId++;
	        this.id = globalId;
	        this.location = location;
	        this.type = "luxury car";
	    }
	}
	
	public static void main(String[] args)
	{	
        try{
            car car1 = myabstractfactory.createCar(myabstractfactory.cartype.SEDAN_USA);
            car1.getDetails();
            car car2 = myabstractfactory.createCar(myabstractfactory.cartype.SEDAN_USA);
            car2.getDetails();
            car car3 = myabstractfactory.createCar(myabstractfactory.cartype.SPORTSCAR_CHINA);
            car3.getDetails();
            car car4 = myabstractfactory.createCar(myabstractfactory.cartype.LUXURYCAR_INDIA);
            car4.getDetails();
            car car5 = myabstractfactory.createCar(myabstractfactory.cartype.LUXURYCAR_USA);
            car5.getDetails();
        }
        catch(Exception e){
            System.out.println("whatsup");
        }
	}
}
