/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */

import java.util.*;

public class TicketMachine
{
    static Scanner key = new Scanner(System.in);
    
     // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    /**
     * Create a machine that issues tickets of the given price.
     */
    
    /**
     * Exercise 2.44 - creating two different constructors
     */
    public TicketMachine(int Cost)
    {
        price = Cost;
        balance = 0;
        total = 0;
    }
    
    public TicketMachine()
    {
        /**
         * Exercise 2.43
         * 
         * The effects of removing the parameter and making price fixed essentially prevents the user to add a custom price to the tickets in the object bench.
         * In conscequently, it had gotten rid of many object which I created because the price was not set at 1000 cents.
         * It can help to set a price for each specific ticket that's going to a specific area.
         */
        
        price = 1000;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }
    
    public int EmptyCredits()
    {
        balance = 0;
        
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("Payment accepted.");
            System.out.println();
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
            
            System.out.println("Balance left: " + balance + " cents");
            
            System.out.println();
            
            System.out.println("Do you want to empty your balance? (yes/no)");
            
            String a = key.nextLine();
            
            if(a == "yes")
            {
                System.out.println("You've emptied your balance.");
                
                System.out.println();
                
                EmptyCredits();
                
                System.out.println("Balance: " + balance + " cents");
                
                System.out.println();
            }
            else if(a == "no")
            {
                System.out.println("Your balance has not been changed.");
                
                System.out.println();
            }
        }
        else {
            System.out.println("Unfortunately you don't have enough balance to get a ticket.");
            
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
            
            System.out.println();
        }
        
        
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
