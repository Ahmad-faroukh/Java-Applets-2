package Archive.PR3_CH5_Q2;

import java.io.Serializable;

public class Account implements Serializable{
    
    private int Account_Number;
    private String Account_Name;
    private float Account_Balance;

    public Account(int Account_Number, String accName, float accBalance) {
        this.Account_Number = Account_Number;
        this.Account_Name = accName;
        this.Account_Balance = accBalance;
    }

    public int getAccount_Number() {
        return Account_Number;
    }

    public void setAccount_Number(int account_Number) {
        this.Account_Number = account_Number;
    }

    public String getAccount_Name() {
        return Account_Name;
    }

    public void setAccount_Name(String account_Name) {
        this.Account_Name = account_Name;
    }

    public float getAccount_Balance() {
        return Account_Balance;
    }

    public void setAccount_Balance(float account_Balance) {
        this.Account_Balance = account_Balance;
    }

    @Override
    public String toString() {
        return "Number : " + this.Account_Number + "\nName : " + this.Account_Name +
                "\nBalance : " + this.Account_Balance;
    }

}