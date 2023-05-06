package BillPackage;

import CustomerPackage.Customer;
import java.util.*;

public class Payments {

	public String cardNumber;
	public String expiryDate;
	public int cvv;

	public int pin;

	public String cardHolderName;

	public Payments(double totalAmt) {
		get_card_details();
		makePayment(totalAmt);
	}

	public void generateBills() {
		System.out.println("Generating Bill....");
		new Bill().displayBill();
	}

	public boolean makePayment(double amount) {
		if (validateCard()) {
			boolean charged = chargeCard(amount);
			if (charged) {
//                for (Bill bill : bills) {
//                    bill.setPaid(true);
//                }
				System.out.println("Payment successful!");
				return true;
			} else {
				System.out.println("Error: Unable to charge card.");
				return false;
			}
		} else {
			System.out.println("Error: Invalid card information.");
			return false;
		}
	}

	public boolean validateCard() {
//        if (isDebitCard) {
//            if (accountNumber.length() == 8 && pin >= 1000 && pin <= 9999) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            if (cardNumber.length() == 16 && expiryDate.matches("\\d{2}/\\d{2}")) {
//                return true;
//            } else {
//                return false;
//            }
//        }
		return true;
	}

	public boolean cash_on_delivery(double amount) {
		System.out.println("This is a cash on delivery option ");
		boolean paid = makePayment(amount);
		if (paid) {
			System.out.println("payment recieved on delivery :");
			return true;
		} else {
			System.out.println("payment not recieved ");
			return false;
		}
	}

	public boolean chargeCard(double amount) {
		return true;
	}

	public void get_card_details() {
		Scanner in = new Scanner(System.in);
		int flag = 0;
		while (flag != 1) {
			System.out.println("Enter the Card Holder name: ");
			cardHolderName = in.nextLine();
			System.out.println("Enter the card details: ");
			System.out.println("Enter the card number: ");
			cardNumber = in.nextLine();
			if (validateCard()) {
				flag = 1;
			}
			System.out.println("Enter the Pin: ");
			pin = in.nextInt();
			in.nextLine();
			if (validateCard()) {
				flag = 1;
			}
			System.out.println("Enter the expiry date: ");
			expiryDate = in.nextLine();
			if (validateCard()) {
				flag = 1;
			}

		}
		System.out.println("***********************************************");
	}
}