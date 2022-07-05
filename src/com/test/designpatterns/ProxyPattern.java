package com.test.designpatterns;

/**
 * 
 * @author SUBIN
 * Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. 
 * A proxy controls access to the original object, allowing you to perform something either before or after the request gets 
 * through to the original object.
 * 
 *  Lazy initialization (virtual proxy). This is when you have a heavyweight service object that wastes system resources by being 
 *  always up, even though you only need it from time to time.
 *  
 *  https://refactoring.guru/design-patterns/proxy
 *
 */

public class ProxyPattern {
	
	public interface CarPlan {

	    public void driveCar();
	    
	}
	
	public class Car implements CarPlan
	{
	    public void driveCar()
	    {
	        System.out.println("The car is Driven");
	    }
	}
	
	public class CarProxy implements CarPlan
	{
	    Driver driver=null;
	    Car car;

	    CarProxy(){
	        this.car = new Car();
	    }

	    public void driveCar()
	    {
	        if(this.driver == null){
	            System.out.println("Error : Car needs a driver");
	        }
	        else if(this.driver.age<18){
	            System.out.println("Error : Drivers age must be graeter than 18");
	        }else{
	            this.car.driveCar();
	        }
	    }

	    public void setDriver(Driver d)
	    {
	        this.driver = d;
	    }
	}
	
	public class Driver
	{
	    public int age;
	    public String name;
	    Driver(int age, String name){
	        this.age = age;
	        this.name = name;
	    }
	}
	
    public static void main(String[] args)
	{	
        try
        {
        	ProxyPattern proxyPattern = new ProxyPattern();
            Driver d = proxyPattern.new Driver(26, "shubham");
            CarProxy c = proxyPattern.new CarProxy();
            c.setDriver(d);
            c.driveCar();
        }
        catch(Exception e){
            System.out.println("whatsup");
        }
	}

}
