package br.com.eduardo.smartcart.main;

import br.com.eduardo.smartcart.models.CreditCard;
import br.com.eduardo.smartcart.models.Purchase;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter credit card limit: ");
        double limit = sc.nextDouble();

        CreditCard card = new CreditCard(limit);

        int option = 1;
        while (option != 0) {
            System.out.println("Enter purchase description: ");
            String description = sc.next();

            System.out.println("Enter purchase amount: $ ");
            double amount = sc.nextDouble();

            Purchase purchase = new Purchase(description, amount);
            boolean isPurchaseMade = card.addPurchase(purchase);

            if (isPurchaseMade) {
                System.out.println("Purchase made!");
                System.out.println("Enter 0 to exit or 1 to continue: ");
                option = sc.nextInt();
            } else {
                System.out.println("Insufficient balance!");
                option = 0;
            }
        }

        System.out.println("-----------------------");
        System.out.println("Purchases made:\n");

        Collections.sort(card.getPurchases());

        for (Purchase p : card.getPurchases()) {
            System.out.println(p.getDescription() + " - " + p.getAmount());
        }

        System.out.println("\n-----------------------");

        System.out.println("\nCard balance: $ " + card.getBalance());
    }
}
