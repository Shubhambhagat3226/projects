package Simple_Bank_Project;

import java.util.Scanner;

class Bank {


    float balance = 10000;
    String name = "Shubham Bhagat";
    String password = "12345678";
    String accountNo = "70001234";
    boolean loginStatus;
    Scanner input;

    public Bank(){
        loginStatus = false;
        input = new Scanner(System.in);
    }

    public float getBalance() {
        return balance;
    }


/*
      to log in the user
 */
    public void userLogin(String accountNo, String password){
        if (accountNo.equals(this.accountNo) && password.equals(this.password)){
            loginStatus = true;
            System.out.println("Login Successful");
        } else {
            System.out.println("Either account number or password is incorrect");
        }
    }



    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }



    /*
        method to add amount in balance
     */
    public void depositAmount(double amount){
        if (loginStatus){
            balance += amount;
            System.out.println("Amount successfully deposited");
            System.out.println("New balance is " + balance);
        } else {
            System.out.println("Please login first");
        }
    }


    /*
        method to withdraw amount
     */
    public void withDrawAmount(double amount){
        if (loginStatus){
            if (amount > balance){
                System.out.println("Your have insufficient balance");
            } else {
                balance -= amount;
                System.out.printf("Amount of Rs.%s is successfully debited\n",amount);
                System.out.println("Remaining balance is " + balance);
            }
        } else {
            System.out.println("Please login first");
        }
    }


/*
       to change password
 */
    public int setPassword(String password){
        int status = 0;
        if (password.equals(this.password)){
            System.out.print("Enter new password : ");
            String pass1 = input.next();
            System.out.print("Re-enter the password : ");
            String pass2 = input.next();
            if (pass1.equals(pass2)){
                this.password = pass1;
                status = 1;
            }
        } else {
            System.out.println("Password is incorrect");
        }
        return status;
    }
}
