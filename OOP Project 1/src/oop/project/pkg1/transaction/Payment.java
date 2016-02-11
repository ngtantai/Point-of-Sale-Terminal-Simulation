package oop.project.pkg1.transaction;

/**
 * Abstract class to standardize all payment types
 *
 */
public class Payment {

	private double amount;
	private String type; // payment methods

	public Payment(double amount, String type) {
		this.amount = amount;
		this.type = type;
	}
        public Payment(String type){
                this.type = type;
        }

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isItCash(String cash) {
                if(this.type == cash)
                    return true;
                return false;
	}
        public boolean isItCredit(String credit) {
                if(this.type == credit)
                    return true;
                return false;
	}
        
        public boolean isItCheck(String check) {
                if(this.type == check)
                    return true;
                return false;
	}

	public void setType(String type) {
		this.type = type;
	}
}
