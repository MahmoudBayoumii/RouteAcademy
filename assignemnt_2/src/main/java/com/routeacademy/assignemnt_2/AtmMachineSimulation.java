package com.routeacademy.assignemnt_2;
import java.util.Scanner;
/**
 *
 * @author Mahmoud Bayoumi
 */
public class AtmMachineSimulation {

    static int failed_attempts = 0; 
    static float balance = 2500.75f;
    static Scanner scanner = new Scanner(System.in);
    static int user_choice;
    static int deposite_transactions=0;
    static int withdraw_transactions=0;
    static int failed_transactions=0;
    static boolean login_status = false;
    static int correct_pin =1234;
    public static void main(String[] args) {
        main_loop:while(login_status==false){
            System.out.println("Enter your pin:");
            int user_pin = scanner.nextInt();
            if(user_pin==correct_pin){
                options_loop:do{
                    System.out.println("=========ATM=========");
                    System.out.println("1.Check Balance");
                    System.out.println("2.Deposit");
                    System.out.println("3.Withdraw");
                    System.out.println("4.Show Account Status");
                    System.out.println("5.Exit");
                    user_choice = scanner.nextInt();
                    switch(user_choice){
                        case 1:
                            System.out.println("Current balance is "+balance);
                            break;
                        case 2:
                            System.out.println("Enter the deposite amount:");
                            float deposite = scanner.nextFloat();
                            if(deposite<=0){
                                System.out.println("Invalid ammount");
                                failed_transactions++;
                            }                           
                            else{
                                balance+=deposite;
                                System.out.println("Your new balance is: "+balance+ "EGP");
                                deposite_transactions++;
                            }
                            break;
                        case 3:
                            System.out.println("Enter the withdraw amount:");
                            float withdraw = scanner.nextFloat();
                            if(withdraw>balance){
                                System.out.println("Insuffecient balance");
                                failed_transactions++;
                            }
                            else if(withdraw <=0){
                                System.out.println("Invalid amount");
                                failed_transactions++;
                            }
                            else
                            {
                                balance-=withdraw;
                                System.out.println("Your new balance is: "+balance+ "EGP");
                                withdraw_transactions++;
                            }
                            break;
                        case 4:
                            if(balance >=5000)
                                System.out.println("You are a VIP Customer");
                            else if(balance>1000&&balance<5000)
                                System.out.println("You are a Regular Customer");
                            else
                                System.out.println("You are a Poor Customer");
                            break;
                        case 5:
                            System.out.println("----Exiting---");
                            System.out.println("Deposite Transactions count: "+deposite_transactions);
                            System.out.println("Withdraw Transactions count: "+withdraw_transactions);
                            System.out.println("Failed Transactions count: "+failed_transactions);
                            System.out.println("See you soon, Good bye!");
                            break main_loop;
                    }
                }while(user_choice!=5);

            }else{
                failed_attempts++;
                if(failed_attempts>=3){
                    System.out.println("You entered your pin worng for 3 times, your account is locked, please contact the bank customer service!");
                    break main_loop;
                }
            }
        }
        
    }
}
