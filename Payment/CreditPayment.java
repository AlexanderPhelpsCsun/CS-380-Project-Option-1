


import java.util.Scanner;
/**
*Handles credits payments. CreditPayment class which will inherits from Payment class. 
*
*@author Alexander
*@version 0.8
*/

public class CreditPayment extends Payment {

    boolean isPaid = false;
    boolean hasPaymentInfo = false;
    Scanner scanner = new Scanner(System.in);

    String creditCardNumber;
    String pin;
    String expiration;
   

/**
*Constructor that initliazes amount that must be payed and the isPaid flag is set to false
*
*@param Amount of money the transaction requires to complete passed as a Double
*/

    public CreditPayment(double amount) {
        super(amount);
    }
/**
*InputCredit will take the credit info and process it. It goes through System.in and System.out.
*
*@param none
*@return void
*/
    public void inputCredit()
    {
        System.out.print("Enter Credit card Number: ");
        creditCardNumber = scanner.nextLine();
        System.out.print("Enter Expiration date in form mm/yy: ");
        expiration = scanner.nextLine();
        System.out.print("Enter pin in form mm/yy: ");
        pin = scanner.nextLine();
        //if(creditCardNumber.leng)
    }


/**
*The actual payment function which sets the Ispaid flag to true after the payment

*@param Cost of transaction in double format
*@return void
*/
    public void pay(double amount)
    {
        if(hasPaymentInfo == true)
        {
            isPaid = true;
        }
        else
        {
            return;
        }
    }


/**
*Used to check payment status for other classes/methods to determine if the user can be issued a ticket/confirmation yet

*@return true if payment is complete, return false if payment isn’t complete.
*/
    public boolean getPaymentStatus()
    {
        return isPaid;
    }
}

