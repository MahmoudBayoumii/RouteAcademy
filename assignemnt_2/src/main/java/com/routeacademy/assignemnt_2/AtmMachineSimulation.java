package com.routeacademy.assignemnt_2;
import java.util.Scanner;
/**
 *
 * @author Mahmoud Bayoumi
 */
public class AtmMachineSimulation {


    public static void main(String[] args) {
        int failed_attempts = 0; 
        double balance = 2500.75;
        Scanner scanner = new Scanner(System.in);
        int user_choice;
        int deposite_transactions=0;
        int withdraw_transactions=0;
        int failed_transactions=0;
        int correct_pin =1234;
        main_loop:while(true){
            System.out.println("Enter your pin:");
            int user_pin = scanner.nextInt();
            if(user_pin==correct_pin){
                do{
                    System.out.println("========= ATM 123=========");
                    System.out.println("1.Check Balance");
                    System.out.println("2.Deposit");
                    System.out.println("3.Withdraw");
                    System.out.println("4.Show Account Status");
                    System.out.println("5.Exit");
                    System.out.println("=======================");
                    user_choice = scanner.nextInt();
                    switch(user_choice){
                        case 1:
                            System.out.println("Current balance is "+balance+ " EGP.");
                            break;
                        case 2:
                            System.out.println("Enter the deposite amount:");
                            double deposite = scanner.nextDouble();
                            if(deposite<=0){
                                System.out.println("Invalid amount.");
                                failed_transactions++;
                            }                           
                            else{
                                balance+=deposite;
                                System.out.println("Your new balance is: "+balance+ " EGP.");
                                deposite_transactions++;
                            }
                            break;
                        case 3:
                            System.out.println("Enter the withdraw amount:");
                            double withdraw = scanner.nextDouble();
                            if(withdraw>balance){
                                System.out.println("Insufficient balance.");
                                failed_transactions++;
                            }
                            else if(withdraw <0){
                                System.out.println("Invalid amount.");
                                failed_transactions++;
                            } else if(withdraw ==0)
                                System.out.println("Transaction cancelled.");
                            else
                            {
                                balance-=withdraw;
                                System.out.println("Your new balance is: "+balance+ " EGP.");
                                withdraw_transactions++;
                                if (balance == 0) {
                                    System.out.println("Warning: Your account is empty.");
                                }
                            }
                            break;
                        case 4:
                            if(balance >=5000)
                                System.out.println("You are a VIP Customer.");
                            else if(balance>=1000&&balance<5000)
                                System.out.println("You are a Regular Customer.");
                            else
                                System.out.println("Low Balance.");
                            break;
                        case 5:
                            System.out.println("----Exiting---");
                            System.out.println("Deposite Transactions count: "+deposite_transactions);
                            System.out.println("Withdraw Transactions count: "+withdraw_transactions);
                            System.out.println("Failed Transactions count: "+failed_transactions);
                            System.out.println("Thank you for using our ATM.");
                            break main_loop;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                }while(user_choice!=5);

            }else{
                failed_attempts++;
                System.out.println("Incorrect PIN, you have "+(3-failed_attempts)+" times remaining.");
                if(failed_attempts>=3){
                    System.out.println("Your account has been locked.");
                    break main_loop;
                }
            }
        }
        
    }
}
