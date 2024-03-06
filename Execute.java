package Bank;

import java.util.Scanner;
/** main class here  it will process whole bank options menu starts form here*/
public class Execute {
    /**   default 3 customers
     * 1  account no=> TNAB041001    password=> AB04001
     * 2  account no=> TNAB041002    password=> AB04002
     * 3  account no=> TNAB041003    password=> AB04003
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Options options=new Options();
        System.out.println("\t \t \t Welcome to Adithya Bank ");
        /** basic it has 2 option  1 is creating account and 2 is login account */
        while (true){
            int choices=0;
            System.out.println("\t Home  ");
            System.out.println(" \t Enter no 1 for new account open");
            System.out.println("\t  Enter no 2 existing account holder");
            System.out.println(" \t  Enter other numbers for exit");
            choices=input.nextInt();
            switch (choices){
                case 1:
                    System.out.println("\t \t \t    Create new Account ");
                    System.out.println(" \t Enter your name:  ");
                    String name=input.next();
                    System.out.println("Enter your age:");
                    int age=input.nextInt();
                    System.out.println(" Enter your gender ");
                    String gender=input.next();
                    System.out.println(" Initial deposit amount ");
                    int amount=input.nextInt();
                    options.Add_Customer(name,age,gender,amount);
                    break;
                case 2:
                    System.out.println("--------Login Here----------");
                    System.out.println(" Enter your account no: ");
                    String acc=input.next();
                    System.out.println(" Enter your password");
                    String pass=input.next();
                    boolean verify=options.Account_details(acc,pass);
                    if(verify){
                        boolean mode=true;
                      while (mode){
                          System.out.println(" Enter no 1 for withdraw  ");
                          System.out.println(" Enter no 2 for deposit");
                          System.out.println(" Enter no 3 for Transactions history");
                          System.out.println(" Enter no 4 for Transfer money to another account");
                          System.out.println(" Enter other number for exit");
                          int choice=input.nextInt();
                          int amt=0;
                          switch (choice){
                              case 1:
                                  System.out.println(" Enter amount for withdraw");
                                  amt=input.nextInt();
                                  options.withDraw(acc,pass,amt);
                               break;
                              case 2:
                                  System.out.println("Enter amount for deposit ");
                                  amt=input.nextInt();
                                  options.Deposit(acc,pass,amt);
                              break;
                              case 3:
                                  options.Show_Transactions(acc,pass);
                               break;
                              case 4:
                                  System.out.println(" Enter receiver account no ");
                                  String get=input.next();
                                  System.out.println(" Enter amount to transfer");
                                  amt=input.nextInt();
                                  options.Transfer(acc,pass,get,amt);
                              break;
                              default:
                                  mode=false;
                              break;
                          }
                      }
                    }
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
