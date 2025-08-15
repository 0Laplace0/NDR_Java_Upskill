/*
 * 6. Invoice class
 * This class represent an invoice, linking a custromer to a total amount.
 * Composition Concept
 * Relationship 'has a' (มี class Customer)
 * เช่น รถยนต์ ต้องมี เครื่องยนตร์, ล้อ
 */

public class Invoice {
    private int id;
    private Customer customer; //Composition Concept
    private double amount;

    public Invoice(int id, Customer customer, double amount){
        if (id < 0) {
            throw new IllegalArgumentException("Customer ID must be non negative.");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non negative.");
        }

        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() { return id; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        this.customer = customer;
    }

    public double getAmount() { return amount; }

    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non negative.");
        }
        this.amount = amount;
    }

    public int getCustomerId(){  return customer.getId(); }

    public String getCustomerName(){ return customer.getName(); }

    
    // public int getCustomerDiscount(){ return customer.getDiscount(); }

    //คำนวนยอดเงินหลังหักส่วนลด
    // Core business logist: apply the customer's discount policy
    public double getAmountAfterDiscount(){
        //1.คำนวนหาส่วนลดจริง
        //  double discountAmount = this.amount * (customer.getDiscount() / 100.0);
        //2.คำนวนหายอดเงินสุทธิ
        //  return this.amount - discountAmount;

        // return this.amount * ( 1 - customer.getDiscount() / 100.0);

        return this.customer.getDiscountPolicy().applyDiscount(this.amount);
    }

    @Override
    public String toString() {
        // return String.format("Invoice[id=%d, customer=%s, amount=%.2f]", this.id, customer, this,amount);

        return "Invoice( " + "id= " + id + ", customerId= " + getCustomerId() + ", customerName= " + getCustomerName() + 
               ", originalAmount= " + String.format("%.2f", amount) + ", " + 
               String.format("%.2f", getAmountAfterDiscount()) + ")";
    }

}
