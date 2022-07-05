package com.test.designpatterns;

/**
 * 
 * @author SUBIN
 * Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. 
 * Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
 * 
 * Use the Chain of Responsibility pattern when your program is expected to process different kinds of requests in various ways, 
 * but the exact types of requests and their sequences are unknown beforehand.
 * 
 * Use the pattern when it’s essential to execute several handlers in a particular order.
 *  Use the CoR pattern when the set of handlers and their order are supposed to change at runtime.
 *  
 *  Pros and Cons
 You can control the order of request handling.
 Single Responsibility Principle. You can decouple classes that invoke operations from classes that perform operations.
 Open/Closed Principle. You can introduce new handlers into the app without breaking the existing client code.
 Some requests may end up unhandled.

 */

public class ChainOfResponsibility {
	
	public class CarAiVirus
	{
	    private int threatLevel;
	    CarAiVirus(int p)
	    {
	        this.threatLevel = p;
	    }

	    public int getThreat(){
	        return this.threatLevel;
	    }
	}
	
	abstract class DebuggerChainPlan {
	    DebuggerChainPlan next;

	    public void debug(CarAiVirus v) {
	    }

	    public void setNextDebugger(DebuggerChainPlan d) {
	        this.next = d;
	    }
	}
	
	class Engineer extends DebuggerChainPlan
	{    
	    public void debug(CarAiVirus v)
	    {
	        if(v.getThreat() > 2){
	            this.next.debug(v);
	        }
	        else
	        {
	            System.out.println("Virus removed by Engineer");
	        }
	    }
	}
	
	class Expert extends DebuggerChainPlan {

	    public void debug(CarAiVirus v) {
	        System.out.println("Virus removed by Expert");
	    }
	}
	
	class TeamLead extends DebuggerChainPlan
	{    
	    public void debug(CarAiVirus v)
	    {
	        if(v.getThreat() > 5){
	            this.next.debug(v);
	        }
	        else
	        {
	            System.out.println("Virus removed by TeamLead");
	        }
	    }
	}
	
	class TechnicalOfficer extends DebuggerChainPlan
	{    

	    public void debug(CarAiVirus v)
	    {
	        if(v.getThreat() > 10){
	            this.next.debug(v);
	        }
	        else
	        {
	            System.out.println("Virus removed by TechnicalOfficer");
	        }
	    }
	}
	
	public static void main(String[] args)
	{	
        try{
        	ChainOfResponsibility chainOfResponsibility = new ChainOfResponsibility();
            /* Creating a new virus instance and set the severity level just to test */
            CarAiVirus virus = chainOfResponsibility.new CarAiVirus(11);

            /* Creating testers instance */
            Engineer e1 = chainOfResponsibility.new Engineer();
            TeamLead t1 = chainOfResponsibility.new TeamLead();
            TechnicalOfficer ct1 = chainOfResponsibility.new TechnicalOfficer();
            Expert ee = chainOfResponsibility.new Expert();

            /* Set the hierarchy by using ofr each one by passing the instance of upper level tester */
            e1.setNextDebugger(t1);
            t1.setNextDebugger(ct1);
            ct1.setNextDebugger(ee);

            /* Give the virus to the lowest level tester */
            e1.debug(virus);
        }
        catch(Exception e){
            System.out.println(e + " :set the debugger chain correclty");
        }
	}

}
