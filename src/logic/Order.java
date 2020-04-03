package logic;

import fileHandling.FDish;

public class Order {
    private double totalPrice = 0.0;
    private String customerOrder = "";


    public double getTotalPrice() {
        return totalPrice;
    }

    public String getCustomerOrder() {
        return customerOrder;
    }

    public void calculateDishPrice(FDish dish, int quantity) {
        if (dish.getType().equalsIgnoreCase("main_course"))
            this.totalPrice = this.totalPrice + (quantity * (dish.getPrice() + (dish.getPrice() * 0.15)));
        else if (dish.getType().equalsIgnoreCase("appetizer"))
            this.totalPrice = this.totalPrice + +(quantity * (dish.getPrice() + (dish.getPrice() * 0.1)));
        else if (dish.getType().equalsIgnoreCase("desert"))
            this.totalPrice = this.totalPrice + +(quantity * (dish.getPrice() + (dish.getPrice() * 0.2)));
    }

    public void addToOrder(FDish dish, int quantity) {
        if (quantity > 0)
            this.customerOrder += quantity + "x " + dish.getName() + "\n";
    }
}
