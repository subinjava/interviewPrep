package com.test.designpatterns;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * 
 * @author SUBIN
 *Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.
 *
 *Use the Adapter class when you want to use some existing class, but its interface isn’t compatible with the rest of your code.
 *Use the pattern when you want to reuse several existing subclasses that lack some common functionality that can’t be added to 
 *the superclass.
 *
 *Pros and Cons
 Single Responsibility Principle. 
 You can separate the interface or data conversion code from the primary business logic of the program.
 Open/Closed Principle.  
 You can introduce new types of adapters into the program without breaking the existing client code, as long as they work with 
 the adapters through the client interface.
 
 The overall complexity of the code increases because you need to introduce a set of new interfaces and classes. 
 Sometimes it’s simpler just to change the service class so that it matches the rest of your code.
 */

public class AdaptorPattern {
	
	public interface Account {

		  BigDecimal getBalance();

		  boolean isOverdraftAvailable();

		  void creditAccount(final BigDecimal credit);
		}
	
	public class AbstractAccount implements Account {

	    private BigDecimal balance;
	    private boolean isOverdraftAvailable;

	    public AbstractAccount(BigDecimal size, boolean isOverdraftAvailable) {
	        this.balance = size;
	        this.isOverdraftAvailable = isOverdraftAvailable;
	    }

	    @Override
	    public BigDecimal getBalance() {

	        return balance;
	    }

	    @Override
	    public boolean isOverdraftAvailable() {

	        return isOverdraftAvailable;
	    }

	    @Override
	    public String toString() {
	        return getClass().getSimpleName() + " Balance=" + getBalance() + " Overdraft:" + isOverdraftAvailable();
	    }

	    @Override
	    public void creditAccount(BigDecimal credit) {

	        balance = balance.add(credit);
	    }
	}
	
	public class AccountAdapter extends AbstractAccount {

	    /**
	     * The class we are adapting from
	     */
	    private OffshoreAccount classBeingAdapted;

	    /**
	     * Constructor takes the class we are going to adapt as an argument.
	     *
	     * @param offShoreAccount the 3rd party API class we are going to adapt from.
	     */
	    public AccountAdapter(OffshoreAccount offShoreAccount) {
	        // pull the class into out hierarchy by adapting the diff methods names
	        super(offShoreAccount.getGrossBalance(), offShoreAccount.canHaveNegativeBalance());

	        // keep a reference to it for later
	        this.classBeingAdapted = offShoreAccount;
	    }

	    /**
	     * For the offshore account, we have to deduct the tax owed for that country when
	     * making the balance calculation.
	     */
	    @Override
	    public BigDecimal getBalance() {

	        // get the tax hit from our adapted class
	        final BigDecimal taxRate = classBeingAdapted.getOffshoreTaxRate();
	        final BigDecimal grossBalance = super.getBalance();

	        final BigDecimal taxableBalance = grossBalance.multiply(taxRate);
	        final BigDecimal balanceAfterTax = grossBalance.subtract(taxableBalance, MathContext.DECIMAL32);

	        return balanceAfterTax;
	    }
	}
	    
    public class OffshoreAccount {

        private BigDecimal balance;
        private boolean canHaveNegativeBalance;

        /**
         * The tax for the country where the account is held.
         */
        private final BigDecimal TAX_RATE = new BigDecimal("0.03");

        public OffshoreAccount(BigDecimal size, boolean canHaveNegativeBalance) {
            this.balance = size;
            this.canHaveNegativeBalance = canHaveNegativeBalance;
        }

        public BigDecimal getGrossBalance() {

            return balance;
        }

        public BigDecimal getOffshoreTaxRate() {

            return TAX_RATE;
        }

        public boolean canHaveNegativeBalance() {

            return canHaveNegativeBalance;
        }

        public void creditTheAccount(BigDecimal credit) {
            balance = balance.add(credit);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " Balance=" + getGrossBalance() + " -veBalanceAllowed:"
                    + canHaveNegativeBalance();
        }
    }
    
    /**
     * Platinum Account holder can have overdraft.*/
    public class PlatinumAccount extends AbstractAccount {

        public PlatinumAccount(final BigDecimal balance) {
            super(balance, true);
        }
    }
    
    /**
     * Standard Account holder cannot have overdraft.
     */
    public class StandardAccount extends AbstractAccount {

        public StandardAccount(final BigDecimal balance) {
            super(balance, false);
        }
    }
    

}
