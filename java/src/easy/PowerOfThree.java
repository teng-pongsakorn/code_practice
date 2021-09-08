package easy;

public class PowerOfThree {

    public static boolean solve(int n) {
        return (n > 0) && (Math.pow(3, 19) % n == 0);
    }
    public static void main(String[] args) {
        System.out.println(PowerOfThree.solve(1));
        System.out.println(PowerOfThree.solve(3));
        System.out.println(PowerOfThree.solve(9));
        System.out.println(PowerOfThree.solve(27));
        System.out.println(PowerOfThree.solve(81));
        System.out.println(PowerOfThree.solve(82));
        System.out.println(PowerOfThree.solve(4));
        System.out.println(PowerOfThree.solve(2));
        System.out.println(PowerOfThree.solve(10));
        System.out.println(PowerOfThree.solve(12));

        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(27));
        System.out.println(Integer.toBinaryString(81));
        System.out.println(Integer.toBinaryString(81*3));
        System.out.println(Integer.toBinaryString(81*9));
        System.out.println((Math.pow(2, 31)-1) > Math.pow(3, 19));
        System.out.println(Math.pow(3, 19));
    }
}
