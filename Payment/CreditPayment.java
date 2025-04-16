import java.util.Scanner;

public class CreditPayment extends Payment {

    boolean isPaid = false;
    boolean hasPaymentInfo = false;
    Scanner scanner = new Scanner(System.in);

    String creditCardNumber;
    String pin;
    String expiration;
   
    public CreditPayment(double amount) {
        super(amount);
    }

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



    public boolean getPaymentStatus()
    {
        return isPaid;
    }
}


