package com.test.designpatterns;

/**
 *  * @author SUBIN
 *Bridge is a structural design pattern that lets you split a large class or a set of closely related classes into two separate 
 *hierarchies—abstraction and implementation—which can be developed independently of each other.
 *
 *Use the Bridge pattern when you want to divide and organize a monolithic class that has several variants of some functionality.
 *The Bridge pattern lets you split the monolithic class into several class hierarchies. 
 *After this, you can change the classes in each hierarchy independently of the classes in the others. 
 *This approach simplifies code maintenance and minimizes the risk of breaking existing code.
 *
 *Use the pattern when you need to extend a class in several orthogonal (independent) dimensions.
 *
 * Pros and Cons
 You can create platform-independent classes and apps.
 The client code works with high-level abstractions. It isn’t exposed to the platform details.
 Open/Closed Principle. You can introduce new abstractions and implementations independently from each other.
 Single Responsibility Principle. You can focus on high-level logic in the abstraction and on platform details in the implementation.
 
 You might make the code more complicated by applying the pattern to a highly cohesive class.
 */

/**There are 2 abstarction here : colorfinish and car; we want them to vary indepenednly; so that if a differemt machine or some methods added in 
 * colorfinish we dont want to change the car class; So we built a bridge between car class and color class by using composition; putting color 
 * object inside car object and most importantly calling color objects method inside car; this way we can change colorFInish the way we like 
 * and car remains free.
 */

public class BridgePattern {
	
	public interface CarPlan 
	{
	    public void paintCar();
	    
	}
	
	public interface ColorFinishPlan {
	    public void paint();
	    public void chooseColor();
	    public void startPaintMachine();
	}
	
	public class GreenFinish implements ColorFinishPlan
	{
	    public void paint(){
	        this.chooseColor();
	        this.startPaintMachine();
	        System.out.println("Car Painted Successfully");
	    };
	    public void chooseColor(){
	        System.out.println("Green Color Chosen Successfully");
	    };
	    public void startPaintMachine(){
	        System.out.println("Paint Machine Started");
	    };
	}
	
	public class RedFinish implements ColorFinishPlan
	{
	    public void paint(){
	        this.chooseColor();
	        this.startPaintMachine();
	        System.out.println("Car Painted Successfully");
	    };
	    public void chooseColor(){
	        System.out.println("Red Color Chosen Successfully");
	    };
	    public void startPaintMachine(){
	        System.out.println("Paint Machine Started");
	    };
	}
	
	public class SedanCar implements CarPlan
	{
	    ColorFinishPlan cf;

	    SedanCar(ColorFinishPlan cf)
	    {
	        this.cf = cf;
	    }

	    public void paintCar()
	    {
	        this.cf.paint();
	    }
	}
	
	public class SportsCar implements CarPlan
	{
	    ColorFinishPlan cf;

	    SportsCar(ColorFinishPlan cf)
	    {
	        this.cf = cf;
	    }

	    public void paintCar()
	    {
	        this.cf.paint();
	    }
	}
	
    public static void main(String[] args)
	{	
        try
        {
        	BridgePattern bridgePattern = new BridgePattern();
            CarPlan sc1 = bridgePattern.new SportsCar(bridgePattern.new RedFinish());
            sc1.paintCar();
            CarPlan lc1 = bridgePattern.new SedanCar(bridgePattern.new GreenFinish());
            lc1.paintCar();
        }
        catch(Exception e){
            System.out.println("whatsup");
        }
	}

}
