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
    private double price;
    // The amount of money entered by a customer so far.
    private double balance;
    // The total amount of money collected by this machine.
    private int total;
    
    private String Location;

    /**
     * Create a machine that issues tickets of the given price.
     */
    
    /**
     * Exercise 2.44 - creating two different constructors
     */
    public TicketMachine()
    {
        balance = 0;
        total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public double getPrice()
    {    
        return price;
    }
    
    public double TotalPrice(double n)
    {
        price = price * n;
        
        return price;
    }
    
    public double Location1()
    {        
        price = 70;
        
        return price;
    }
    
    public double Location2()
    {
        price = 138;
        
        return price;
    }
    
    public double Location3()
    {
        price = 17.60;
        
        return price;
    }
    
    public double Location4()
    {
        price = 211.78;
        
        return price;
    }
    
    public double Location5()
    {
        price = 126.50;
        
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public double getBalance()
    {
        return balance;
    }
    
    public double EmptyCredits()
    {
        balance = 0;
        
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(double amount)
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
        System.out.println("Welcome to bluej lines ticket machine.");
        
        System.out.println();
        
        System.out.println("What location do you want to travel to?");
        
        String Region = key.nextLine();
        
        if(Region.equals("Manchester"))
        {
            Location1();
        }
        else if(Region.equals("France"))
        {
            Location2();
        }
        else if(Region.equals("London"))
        {
            Location3();
        }
        else if(Region.equals("Amsterdam"))
        {
            Location4();
        }
        else if(Region.equals("Edinburgh"))
        {
            Location5();
        }
        
        while(!"Manchester".equals(Region) && !"France".equals(Region) && !"London".equals(Region) && !"Amsterdam".equals(Region) && !"Edinburgh".equals(Region))
        {
            System.out.println("ERROR!");
            
            System.out.println();
            
            System.out.println("Please try again");
            
            Region = key.nextLine();
        }
         
        System.out.println();
        
        System.out.println("How many tickets do you want to buy?");
        
        double tickets = key.nextDouble();
        
        TotalPrice(tickets);
        
        String a;
        
        if(balance >= price) 
        {
            // Simulate the printing of a ticket.
            System.out.println("Payment accepted.");
            System.out.println();
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Location: " + Region);
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total += price;
            // Reduce the balance by the prince.
            balance = balance -= price;
            
            System.out.println("Balance left: " + balance + " cents");
            
            System.out.println();
            
            System.out.println("Do you want to empty your balance? (yes/no)");
            
            a = key.next();
            
            if(a.equals("yes"))
            {
                System.out.println("You've emptied your balance.");
                
                System.out.println();
                
                EmptyCredits();
                
                System.out.println("Balance: " + balance + " cents");
                
                System.out.println();
            }
            else if(a.equals("no"))
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
    public double refundBalance()
    {
        double amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
