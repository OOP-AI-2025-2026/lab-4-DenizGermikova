package ua.opnu.inheritance.bill;

public class DiscountBill2 {
    private GroceryBill bill;
    private boolean preferred;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean preferred) {
        this.bill = new GroceryBill(clerk);
        this.preferred = preferred;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    public Employee getClerk() {
        return bill.getClerk();
    }

    public void add(Item item) {
        bill.add(item);
        if (preferred && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (Item item : bill.getItems()) {
            if (preferred) {
                total += item.getPrice() - item.getDiscount();
            } else {
                total += item.getPrice();
            }
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public int getDiscountCount() {
        return preferred ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return preferred ? Math.round(discountAmount * 100.0) / 100.0 : 0.0;
    }

    public double getDiscountPercent() {
        if (!preferred) return 0.0;

        double fullPrice = 0.0;
        double discountedPrice = 0.0;

        for (Item item : bill.getItems()) {
            fullPrice += item.getPrice();
            discountedPrice += item.getPrice() - item.getDiscount();
        }

        if (fullPrice == 0.0) return 0.0;

        double percent = 100 - (discountedPrice * 100 / fullPrice);
        return Math.round(percent * 10000000000000.0) / 10000000000000.0;
    }
}