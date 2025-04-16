abstract class Payment {
    double amount;
    boolean isPaid;

    public Payment(double amount) {
        this.amount = amount;
        this.isPaid = false;
    }


    public abstract void pay(double amount);
    public abstract boolean getPaymentStatus();
}
