package atmInterface;

public class UserAccount {
	String name, accNo, cardNum;
	int pin;
	float balance;
	
	UserAccount(String name, String accNo, String cardNum, int pin, float balance) {
		this.name = name;
		this.accNo = accNo;
		this.cardNum = cardNum;
		this.pin = pin;
		this.balance = balance;
	}
	
	//checking the entered account number is matched or not
	public boolean checkAccountNumber(String enteredAccNo) {
		return accNo.equals(enteredAccNo);
	}
	
	//checking the entered pin is matched or not
	public boolean checkPin(int enteredPin) {
		return pin==enteredPin;
	}
	//setting new pin
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	//returning the available
	public float getBalance() {
		return balance;
	}
	//setting updated balance
	public void setBalance(float balance) {
		this.balance = balance;
	}
}
