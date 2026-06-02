package bankmanager.src;

public class Account {

    public String id;
    public double balance;
    public double limitSpecialChecking;

    public String getId() {
        return id;
    };

    public double getBalance() {
        return balance;
    };
    public final double getLimitSpecialChecking() {
        return limitSpecialChecking;
    };

    public void setId(String id) {
        this.id = id;
    };

    public void setBalance(double balance) {
        this.balance = balance;
        if (
            this.balance <= 500){
                setLimitSpecialChecking(50);
            } else {
                setLimitSpecialChecking(this.balance * 0.5);
            }
    };

    public void setLimitSpecialChecking(double limitSpecialChecking) {
        this.limitSpecialChecking = limitSpecialChecking;
    };

}
