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

    public void removeBalance(double amount) {
        if(this.balance - amount >=0){
            this.balance -= amount;
        } else {
            if(this.balance + this.limitSpecialChecking - (amount*0.2) >= 0){
                this.limitSpecialChecking -= ((amount*0.2) - this.balance);
                this.balance = 0;
                System.out.println("You are using the special checking limit. Remaining limit: " + this.limitSpecialChecking);
            } else {
                System.out.println("Insufficient funds.");
            }
        }
    };

    public void setLimitSpecialChecking(double limitSpecialChecking) {
        this.limitSpecialChecking = limitSpecialChecking;
    };

}
