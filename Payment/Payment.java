/**
*Abstract payment class which will be the parent for CashPayment class and for CreditPayment class

*@author Alexander
*@version 1.0
*/

abstract class Payment {
    double amount;
    boolean isPaid;

/**
*Constructor that initliazes amount that must be payed and the isPaid flag is set to false

*@param Amount of money the transaction requires to complete passed as a Double
*/
    public Payment(double amount) {
        this.amount = amount;
        this.isPaid = false;
    }

/**
*The actual payment function which sets the Ispaid flag to true after the payment

*@param Cost of transaction in double format
*@return void
*/

    public abstract void pay(double amount);
/**
*Used to check payment status for other classes/methods to determine if the user can be issued a ticket/confirmation yet

*@return true if payment is complete, return false if payment isn’t complete.
*/


    public abstract boolean getPaymentStatus();
}


