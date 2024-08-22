package Simple_Bank_Project;

public class User {
    public static void main(String[] args) {
        Bank user1 = new Bank();
        int choice;

        do {
            choice = getChoice(user1);
            checkChoice(user1,choice);
        }while (choice != 6);
    }

    public static int getChoice(Bank user){
        System.out.println("1. Login");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Check Balance");
        System.out.println("5. Change Password");
        System.out.println("6. Exit");
        System.out.println("_________________________");

        System.out.print("Please enter one of the option : ");
        return user.input.nextInt();
    }

    public static void checkChoice(Bank user,int choice){
        switch (choice){
            case 1 -> choice1(user);
            case 2 -> choice2(user);
            case 3 -> choice3(user);
            case 4 -> choice4(user);
            case 5 -> choice5(user);
            case 6 -> choice6(user);
        }
    }

    public static void choice4(Bank user){
        if(user.loginStatus){
            System.out.println("Your account balance is " + user.getBalance());
        } else {
            System.out.println("Please login first");
        }
    }

    public static void choice5(Bank user){
        if (!user.loginStatus){
            System.out.println("plz login first");
            return;
        }
        System.out.print("Please enter your password : ");
        int status = user.setPassword(user.input.next());

        if (status == 1){
            System.out.println("Password change successfully");
        } else {
            System.out.println("New password is not match with re-password");
        }
    }

    public static void choice6(Bank user){
        user.setLoginStatus(false);
        System.out.println("Your have exit the bank");
    }

    public static void choice3(Bank user){
        System.out.print("Enter the amount that you want to withdraw : ");
        user.withDrawAmount(user.input.nextDouble());
    }

    public static void choice2(Bank user){
        System.out.print("Enter the amount you want to add : ");
        user.depositAmount(user.input.nextDouble());
    }

    public static void choice1(Bank user){
        if (user.loginStatus){
            System.out.println("Your are already login");
            return;
        }

        System.out.print("Please enter your account number : ");
        String  accountNo =  user.input.next();
        System.out.print("Also enter your password : ");
        String  password =  user.input.next();

        user.userLogin(accountNo,password);
    }
}
