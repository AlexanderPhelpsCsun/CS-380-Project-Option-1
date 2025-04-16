public class CashPayment extends Payment 
{
    boolean isPaid = false;
    
    public CashPayment(double amount) {
        super(amount);
    }


    public void pay(double amount)
    {
        isPaid = true;
    }



    public boolean getPaymentStatus()
    {
        return isPaid;
    }
}
