/**
*CashPayment class is a child of abstract payment class and handles basic cash payments for flight reservations.
*
*@author Alexander
*@version 1.0
*/

public class CashPayment extends Payment 
{
    boolean isPaid = false;
    /**
    *Constructor which initializes amount to be paid
    
    *@param Cost of transaction in double format
    */
    public CashPayment(double amount) {
        super(amount);
    }


   /**
   *The actual payment function which sets the Ispaid flag to true after the payment
	
   *@param Cost of transaction in double format
   *@return void
   */
    public void pay(double amount)
    {
        isPaid = true;
    }


/**
*Used to check payment status for other classes/methods to determine if the user can be issued a ticket/confirmation yet
*
*@return true if payment is complete, return false if payment isn’t complete.
*/
    public boolean getPaymentStatus()
    {
        return isPaid;
    }
}

