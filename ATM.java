public class ATM {
private int balance;
private int pin;

public ATM(int balance,int pin)
{
    this.balance=balance;
    this.pin=pin;
}

public void displaymenu(){
    System.out.println("1. Check Balance");
    System.out.println("2. Deposit");
    System.out.println("3. Withdraw");
    System.out.println("4. Change Pin");
    System.out.println("5. Exit");
}

public void deposit(int amount)
{
    balance+=amount;
}
public void withdraw(int amount)
{
    if (balance<amount) {
        System.out.println("Insufficient Funds!");
        return;
    }
    balance-=amount;
}
 
public int getBalance(){
    return balance;
}

public boolean validatePin(int pin){
    return this.pin==pin;
}

public void ChangePin(int newpin){
    this.pin = newpin;
    System.out.println("Pin Changed!");
}

    public static void main(String[] args) throws Exception {
        ATM atm =new ATM(1000, 1234);
       System.out.print("Enter the pin:");
       int pin =Integer.parseInt(System.console().readLine());
       if (atm.validatePin(pin)) {
          int option =0;
          while (option!=5) {
            atm.displaymenu();
            option =Integer.parseInt(System.console().readLine());
           switch (option) {
            case 1:
                System.out.println("Balance: "+atm.getBalance());
                break;

             case 2:
                System.out.print("Enter Amount: ");
                int amount=Integer.parseInt(System.console().readLine());
                atm.deposit(amount);
                break;

            case 3:
                 System.out.print("Enter Amount: ");
            amount=Integer.parseInt(System.console().readLine());
            atm.withdraw(amount);
            break;
                
             case 4:
                  System.out.print("Enter New Pin: ");
                  int newpin =Integer.parseInt(System.console().readLine());
                atm.ChangePin(newpin);
                break;

             case 5:
                  System.out.println("Thank you for using ATM!");
                
                break;
           
            default:
                break;
           }
            
          }

         }
       else{
        System.out.println("You have entered Invalid Pin!");
       }
    }
}