package atmInterface;
import java.util.Scanner;
import java.util.ArrayList;

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<UserAccount> usersList = new ArrayList<>();
		
		//Adding users records
		usersList.add(new UserAccount("John","12121234343","1234 4321 1234",1020,10000));
		usersList.add(new UserAccount("Faizal","34343456565","5678 8765 5678",2255,20000));
		usersList.add(new UserAccount("Ganesh","56565678787","1256 6521 1256",7777,25000));
		usersList.add(new UserAccount("Abu","78787890909","1928 8291 1928",7860,20000));
		usersList.add(new UserAccount("David","12345678901","1001 2002 3003",6969,10000));
		
		//Enter your card number
		System.out.println("Please insert your card");
		String cardNum = sc.nextLine();
		UserAccount currUser = findByCardNum(cardNum,usersList);
	
		System.out.println("\nWelcome, " + currUser.name);
		System.out.println("Please choose the service you need");
		System.out.println("1. Withdraw amount\t2. Deposit amount");
		System.out.println("3. Balance enquiry\t4. Forgot pin / Set pin");
		
		int option = sc.nextInt();
		switch(option) {
			case 1:
				//withdraw
				System.out.print("\nEnter the amount: ");
				float withDrawAmount = sc.nextFloat();
				System.out.print("\nEnter your pin: ");
				int pinForWD = sc.nextInt();
				if(currUser.checkPin(pinForWD)) {
					float bal = currUser.getBalance();
					if(bal >= withDrawAmount) {
						currUser.setBalance(bal-withDrawAmount);
						System.out.println("\nPlease collect your card and wait for cash");
						System.out.println("Amount withdrawn successfully!!");
						System.out.println("\nBalance: " + currUser.getBalance());
					}
					else {
						System.out.println("\nInsufficient balance");
					}
				}
				else {
					System.out.println("\nYou've entered a wrong pin, please check it.");
				}
				break;
			case 2:
				//deposit
				System.out.print("\nEnter the amount: ");
				float depositAmount = sc.nextFloat();
				System.out.print("\nEnter your pin: ");
				int pinforDP = sc.nextInt();
				if(currUser.checkPin(pinforDP)) {
					float bal = currUser.getBalance();
					currUser.setBalance(bal+depositAmount);
					System.out.println("\nPlease collect your card");
					System.out.println("Amount deposited successfully!!");
					System.out.println("\nBalance: " + currUser.getBalance());
				}
				else {
					System.out.println("\nYou've entered a wrong pin, please check it.");
				}
				break;
			case 3:
				System.out.print("\nEnter your pin: ");
				int pinForEn = sc.nextInt();
				if(currUser.checkPin(pinForEn)) {
					System.out.println("\nBalance: " + currUser.getBalance());
				}
				else {
					System.out.println("\nYou've entered a wrong pin, please check it.");
				}
				break;
			case 4:
				System.out.print("\nEnter your account number: ");
				sc.nextLine();
				String accNo = sc.nextLine();
				if(currUser.checkAccountNumber(accNo)) {
					System.out.print("\nEnter new pin: ");
					int pin = sc.nextInt();
					currUser.setPin(pin);
					System.out.println("\nYour pin has been changed.");
				}
				else {
					System.out.println("\nYou've entered a wrong account number, please check it.");
				}
				break;
		}
		
		sc.close();
	}
	
	public static UserAccount findByCardNum(String cardNum, ArrayList<UserAccount> usersList) {
		for(UserAccount user : usersList) {
			if(cardNum.equals(user.cardNum))
				return user;
		}
		return null;
	}
}
