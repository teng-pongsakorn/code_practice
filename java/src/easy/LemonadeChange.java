package easy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int bill: bills) {
            System.out.println("$5="+fiveCount + " $10=" + tenCount + " bill=" + bill);
            if (bill == 5) {
                fiveCount++;
            } else if (bill == 10) {
                if (fiveCount < 1) {
                    return false;
                }
                fiveCount--;
                tenCount++;
            } else {
                if (fiveCount < 1 || (tenCount < 1 && fiveCount < 3) ) {
                    return false;
                }
                if (tenCount == 0) {
                    fiveCount -= 3;
                } else {
                    fiveCount--;
                    tenCount--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange sol = new LemonadeChange();
        int[] bills = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(sol.lemonadeChange(bills));
    }
}
