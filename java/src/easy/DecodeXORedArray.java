package easy;

public class DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        // encoded[i] = arr[i] XOR arr[i + 1]
        int[] arr = new int[encoded.length+1];
        arr[0] = first;
        for (int i=1; i<arr.length; i++) {
            arr[i] = encoded[i-1] ^ arr[i-1];
        }
        return arr;
    }
}
