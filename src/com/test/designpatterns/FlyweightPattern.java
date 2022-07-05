package com.test.designpatterns;

//https://refactoring.guru/design-patterns/flyweight
/**Flyweight is a structural design pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state 
between multiple objects instead of keeping all of the data in each object.
Use the Flyweight pattern only when your program must support a huge number of objects which barely fit into available RAM.

 The benefit of applying the pattern depends heavily on how and where it’s used. It’s most useful when:
an application needs to spawn a huge number of similar objects
this drains all available RAM on a target device
the objects contain duplicate states which can be extracted and shared between multiple objects
*
*/

/**Pros and Cons
You can save lots of RAM, assuming your program has tons of similar objects.
You might be trading RAM over CPU cycles when some of the context data needs to be recalculated each time somebody calls a flyweight method.
 The code becomes much more complicated. New team members will always be wondering why the state of an entity was separated in such a way.
*/

/**Flyweight is when you have many different kinds of a single thing.
Singleton is when you have a single thing.
For example, you might use the Flyweight Pattern to represent keyboard characters. One object for a, one for b, etc. 
They are both characters, but different kinds of characters.
In contrast, you might use a singleton to represent the keyboard. There can only be one.*/
import java.util.HashMap;

public class FlyweightPattern {
	
	public interface CarStatusPlan {
	    public void getStatus();
	    public void setKmCovered(int p);
	    public void setMileage(int p);

	}
	
	public static class CarProvider {
	    private static HashMap<String, CarStatusPlan> hm = new HashMap<String, CarStatusPlan>();

	    public static CarStatusPlan getCarStatus(String type) {
	        CarStatusPlan c = null;
	        FlyweightPattern flyweightPattern = new FlyweightPattern();

	        if (hm.containsKey(type))
	            c = hm.get(type);
	        else {
	            switch (type) {
	            case "sports":
	                c = flyweightPattern.new SportsCarStatus();
	                break;
	            case "sedan":
	                c = flyweightPattern.new SedanCarStatus();
	                break;
	            case "luxury":
	                c = flyweightPattern.new LuxuryCarStatus();
	                break;
	            default:
	                System.out.println("Unreachable code!");
	            }
	            hm.put(type, c);
	        }
	        return c;
	    }
	}
	
	public class LuxuryCarStatus implements CarStatusPlan
	{
	    private String type = "luxury";
	    public int kmCovered;
	    public int mileage;

	    public void setKmCovered(int kmCovered){
	        this.kmCovered = kmCovered;
	    }

	    public void setMileage(int mileage){
	        this.mileage = mileage;
	    }
	    public void getStatus() {
	        if(kmCovered/mileage > 10){
	            System.out.println("You should consider servicing your car");
	        }
	        else{
	            System.out.println("Everything is fine with your "+ this.type + " car");
	        }
	    }
	}
	
	public class SedanCarStatus implements CarStatusPlan
	{
	    private String type = "sedan";
	    public int kmCovered;
	    public int mileage;

	    public void setKmCovered(int kmCovered){
	        this.kmCovered = kmCovered;
	    }

	    public void setMileage(int mileage){
	        this.mileage = mileage;
	    }

	    public void getStatus() {
	        if(kmCovered/mileage > 30){
	            System.out.println("You should consider servicing your car");
	        }
	        else{
	            System.out.println("Everything is fine with your "+ this.type + " car");
	        }
	    }
	}
	
	public class SportsCarStatus implements CarStatusPlan
	{
	    private String type = "sports";
	    public int kmCovered;
	    public int mileage;

	    public void setKmCovered(int kmCovered){
	        this.kmCovered = kmCovered;
	    }

	    public void setMileage(int mileage){
	        this.mileage = mileage;
	    }

	    public void getStatus() {
	        if(kmCovered/mileage > 20){
	            System.out.println("You should consider servicing your car");
	        }
	        else{
	            System.out.println("Everything is fine with your "+ this.type + " car");
	        }
	    }
	}
	
	

}
