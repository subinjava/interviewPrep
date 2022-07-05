package com.test.designpatterns;

/**
 * 
 * @author SUBIN
 * Prototype is a creational design pattern that lets you copy existing objects without making your code dependent on their classes.
 * 
 * Use the Prototype pattern when your code shouldn’t depend on the concrete classes of objects that you need to copy.
 * Use the pattern when you want to reduce the number of subclasses that only differ in the way they initialize their respective 
 * objects.
 * 
 * Pros and Cons
 You can clone objects without coupling to their concrete classes.
 You can get rid of repeated initialization code in favor of cloning pre-built prototypes.
 You can produce complex objects more conveniently.
 You get an alternative to inheritance when dealing with configuration presets for complex objects.
 Cloning complex objects that have circular references might be very tricky.
 *
 */

public class PrototypePattern {
	
	static class DatabasePlanet
	{
	    static String getPlanet() // a method that is very costly
	    {   
	        System.out.println("this operation took 1 minute");
	        return "Mars";
	    }
	}
	
	public abstract class SuperCarPlan implements Cloneable 
	{
	    public Object getClone()
	    {
	        Object car = null;
	        try{
	            car = super.clone();
	        }
	        catch (CloneNotSupportedException e) 
	        {
	            e.printStackTrace();
	        }
	        return car;
	    }
	}
	
	public class SuperAlienCar extends SuperCarPlan
	{
	    String planet;
	    private String alienDriver = "jadoo"; // by default
	    SuperAlienCar()
	    {
	        this.planet = DatabasePlanet.getPlanet(); // costly operation
	    }

	    public void setDriver(String name)
	    {
	        this.alienDriver = name;
	    }

	    public void getDetails()
	    {
	        System.out.println("driver name is " + this.alienDriver);
	        System.out.println("planet name is " + this.planet);
	    }


	}
	
//	static class Main{
    public static void main(String[] args) {
        try {
        	PrototypePattern prototypePattern = new PrototypePattern();
            SuperAlienCar S1 = prototypePattern.new SuperAlienCar();
            S1.getDetails();
            System.out.println(S1);
            SuperAlienCar S2 = (SuperAlienCar) S1.getClone(); 
            S2.setDriver("ET");
            S2.getDetails();
            System.out.println(S2);
        } catch (Exception e) {
            System.out.println("whatsup");
        }
    }
//	}

}
