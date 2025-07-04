package Classes;

import Exceptions.InsufficientBalanceException;

public class User {
    private double balance;
    public User(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void decreaseBalance(double balance) throws InsufficientBalanceException{
        if (this.balance - balance < 0){
            throw new InsufficientBalanceException(balance, this.balance);
        }
        this.balance -= balance;
    }
}
