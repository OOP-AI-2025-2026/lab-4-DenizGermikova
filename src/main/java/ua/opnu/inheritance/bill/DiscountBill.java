package ua.opnu.inheritance.bill;

public class DiscountBill extends GroceryBill {

    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    @Override
    public void add(Item item) {
        super.add(item);
        if (regularCustomer && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        double total = 0.0;
        for (Item i : getItems()) {
            if (regularCustomer) {
                total += i.getPrice() - i.getDiscount();
            } else {
                total += i.getPrice();
            }
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? Math.round(discountAmount * 100.0) / 100.0 : 0.0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer || getItems().isEmpty()) return 0.0;

        double fullPrice = 0.0;
        for (Item i : getItems()) {
            fullPrice += i.getPrice();
        }

        double discountedPrice = fullPrice - discountAmount;
        double percent = 100 - (discountedPrice * 100 / fullPrice);

        return Math.round(percent * 10000000000000.0) / 10000000000000.0;
    }
}