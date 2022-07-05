package com.test.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author SUBIN
 * Composite is a structural design pattern that lets you compose objects into tree structures and then work with these structures
 * as if they were individual objects.
 * 
 * Use the Composite pattern when you have to implement a tree-like object structure.
 * The Composite pattern provides you with two basic element types that share a common interface: simple leaves and complex 
 * containers. A container can be composed of both leaves and other containers. 
 * This lets you construct a nested recursive object structure that resembles a tree.
 * 
 * Use the pattern when you want the client code to treat both simple and complex elements uniformly.
 * All elements defined by the Composite pattern share a common interface. Using this interface, 
 * the client doesn’t have to worry about the concrete class of the objects it works with.
 * 
 * Pros and Cons
 You can work with complex tree structures more conveniently: use polymorphism and recursion to your advantage.
 Open/Closed Principle. You can introduce new element types into the app without breaking the existing code, 
 which now works with the object tree.
 
  It might be difficult to provide a common interface for classes whose functionality differs too much. 
  In certain scenarios, you’d need to overgeneralize the component interface, making it harder to comprehend.
 *
 */

public class CompositePattern {
	
	public interface EmployeePlan {
	    public void add(Employee e1);
	    public void remove(Employee e1);
	    public void showSubordinatesDetails();

	}
	
	public class Employee implements EmployeePlan
	{
	    String name, designation;
	    int salary;
	    List<Employee> subordinates;
	    Employee(String name, String designation, int salary)
	    {
	        this.name = name;
	        this.designation = designation;
	        this.salary = salary;
	        this.subordinates = new ArrayList<Employee>();
	    }

	    public void add(Employee e1) {
	        this.subordinates.add(e1);
	    }

	    public void remove(Employee e1) {
	        this.subordinates.remove(e1);
	    }

	    public void showSubordinatesDetails(){
	        // for (int i = 0; i < this.subordinates.size(); i++) {
			// 	System.out.println(this.subordinates.get(i));
			// }
	        this.subordinates.forEach((item)-> {
	            System.out.println("name :" + item.name + " position :" + item.designation + " salary :" + item.salary);
	            item.showSubordinatesDetails();
	        });
	    }
	}
	
	/** When you want to keep the list of same type of objects inside the same object; using composition; 
	 * you can also craete a directory class and storing all the objects there and calling getdetails() from there.
	 */
    public static void main(String[] args)
	{	
        try
        {
        	CompositePattern compositePattern = new CompositePattern();
            Employee director = compositePattern.new Employee("john", "Director", 1200);
            Employee leadmanager = compositePattern.new Employee("Kate", "Manager", 1000);
            Employee sportsmanager = compositePattern.new Employee("robert", "Sports Manager", 900);
            Employee sedanmanager = compositePattern.new Employee("ludo", "Sedan Manager", 900);
            Employee luxurymanager = compositePattern.new Employee("kevin", "Luxury Manager", 900);
            Employee engineer1 = compositePattern.new Employee("tom", "car Engineer", 700);
            Employee engineer2 = compositePattern.new Employee("leonard", "car engineer", 700);
            Employee worker1 = compositePattern.new Employee("mike", "worker", 500);
            Employee worker2 = compositePattern.new Employee("steve", "worker", 500);

            director.add(leadmanager);

            leadmanager.add(sportsmanager);
            leadmanager.add(sedanmanager);
            leadmanager.add(luxurymanager);

            sportsmanager.add(engineer1);
            sedanmanager.add(engineer2);

            engineer1.add(worker1);
            engineer2.add(worker2);

            sportsmanager.showSubordinatesDetails();
        }
        catch(Exception e){
            System.out.println("whatsup");
        }
	}

}
