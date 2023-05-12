package br.com.eduardo.smartcart.models;

public class Purchase implements Comparable<Purchase> {
    private String description;
    private double amount;

    public Purchase(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    @Override
    public int compareTo(Purchase anotherPurchase) {
        return Double.valueOf(this.amount).compareTo(Double.valueOf(anotherPurchase.amount));
    }

    @Override
    public String toString() {
        return "Purchase: description = " + description + ", amount = " + amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}
