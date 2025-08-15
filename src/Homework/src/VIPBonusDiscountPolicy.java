/*
 * 4. VIPBonusDiscountPolicy class
 * This class applies a base percentage anan additional bonus if the amount exceeds a threshold.
 */

public class VIPBonusDiscountPolicy implements DiscountPolicy{
    private int basePercent; //ส่วนลดพื้นฐานที่ลูกค้า VIP ได้รับเสมอ
    private int bonusPercent; //ส่วนลดพิเศษที่จะได้รับเพิ่มจาก basePercent
    //เงื่อนไขโดยยอดเงิน(amount)ที่จ่ายมากกว่า bonusTheshold
    //ส่วนลดพิเศษ(bonusPercent) จะถูกนำมาบวกเพิ่มกับ basePercent
    private double bonusTheshold;

    public VIPBonusDiscountPolicy(int basePercent, int bonusPercent, double bonusTheshold){
        if (basePercent < 0 || basePercent > 100) {
            throw new IllegalArgumentException("Base percentage must be between 0 - 100");
        }
        if (bonusPercent < 0 || bonusPercent > 100) {
            throw new IllegalArgumentException("Bonus percentage must be between 0 - 100");
        }
        if (bonusTheshold < 0 ) {
            throw new IllegalArgumentException("Bonus Theshold must be between 0 - 100");
        }

        this.basePercent = basePercent;
        this.bonusPercent = bonusPercent;
        this.bonusTheshold = bonusTheshold;
    }

    @Override
    public double applyDiscount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non negative.");
        }
        int totalPercent = basePercent;
        if (amount > bonusTheshold) {
            totalPercent += bonusPercent;
        }
        
        //Cap the total discount at 100% to prevent negative price
        if (totalPercent > 100) {
            totalPercent = 100;
        }

        return amount * (1 - totalPercent / 100.0);
    }

    @Override
    public String toString() {
        return String.format("%d%% base + %d%% bonus over %.2f", basePercent, bonusPercent, bonusTheshold);
    }

}
