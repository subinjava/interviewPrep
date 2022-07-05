package com.test.designpatterns;

/**
 * 
 * @author SUBIN
 * Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside 
 * special wrapper objects that contain the behaviors.
 * 
 *  Use the Decorator pattern when you need to be able to assign extra behaviors to objects at runtime without breaking the 
 *  code that uses these objects.
 *  Use the pattern when it’s awkward or not possible to extend an object’s behavior using inheritance.
 *
 * Pros and Cons
 You can extend an object’s behavior without making a new subclass.
 You can add or remove responsibilities from an object at runtime.
 You can combine several behaviors by wrapping an object into multiple decorators.
 Single Responsibility Principle. You can divide a monolithic class that implements many possible variants of behavior into 
 several smaller classes.
 
  It’s hard to remove a specific wrapper from the wrappers stack.
 It’s hard to implement a decorator in such a way that its behavior doesn’t depend on the order in the decorators stack.
 The initial configuration code of layers might look pretty ugly.
 */

public class DecoratorPattern {

	public interface Account {
		String getTotalBenefits();
	}

	public static class SavingAccount implements Account {

		@Override
		public String getTotalBenefits() {
			return "This account has 4% interest rate with per day $5000 withdrwal limit";
		}

	}

	public static class CurrentAccount implements Account {

		@Override
		public String getTotalBenefits() {
			return "There is no withdrwal limit for current account";
		}

	}

	public static abstract class AccountDecorator implements Account {

		abstract String applyOtherBenefits();

	}

	public static class Privilege extends AccountDecorator {

		Account account;

		public Privilege(Account account) {
			super();
			this.account = account;
		}

		@Override
		public String getTotalBenefits() {
			return account.getTotalBenefits() + " other benefits are " + applyOtherBenefits();
		}

		@Override
		String applyOtherBenefits() {
			return " an accident insurance of up to $1,600 and an overdraft facility of $84";
		}

	}
	
	public static class SeniorCitizen extends AccountDecorator {

		Account account;

		public SeniorCitizen(Account account) {
			super();
			this.account = account;
		}

		@Override
		public String getTotalBenefits() {
			return account.getTotalBenefits() + " other benefits are " + applyOtherBenefits();
		}

		@Override
		String applyOtherBenefits() {
			return " an accident insurance of up to $1,600 and an overdraft facility of $84";
		}

	}

	public static void main(String[] args) {
		/* Saving account with no decoration */
		Account basicSavingAccount = new SavingAccount();
		System.out.println(basicSavingAccount.getTotalBenefits());

		
		/*Saving account with senior citizen benefits decoration*/
		Account seniorCitizenSavingAccount = new SavingAccount();
		seniorCitizenSavingAccount = new SeniorCitizen(seniorCitizenSavingAccount);
		System.out.println(seniorCitizenSavingAccount.getTotalBenefits());

		/* Saving account with privilege decoration */
		Account privilegeCitizenSavingAccount = new SavingAccount();
		privilegeCitizenSavingAccount = new Privilege(privilegeCitizenSavingAccount);
		System.out.println(privilegeCitizenSavingAccount.getTotalBenefits());
	}

}
