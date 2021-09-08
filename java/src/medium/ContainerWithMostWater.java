package medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length-1;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[right], height[left]));
            if (height[left] < height[right]) {
                left++;
            } else if (height[right] < height[left]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxArea;
    }
    public int maxArea_brute(int[] height) {
        int maxArea = 0;
        for (int i=0; i<height.length-1; i++) {
            int currentMax = 0;
            for (int j=height.length-1; j>i; j--) {
                currentMax = Math.max(currentMax, (j-i)*Math.min(height[i], height[j]));
                if (height[j] >= height[i])
                    break;
            }
            maxArea = Math.max(maxArea, currentMax);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();
        int[] height;


        height = new int[] {1,1};
        System.out.println(sol.maxArea(height));

        height = new int[] {4,3,2,1,4};
        System.out.println(sol.maxArea(height));

        height = new int[] {1,2};
        System.out.println(sol.maxArea(height));

        height = new int[] {1,2,1};
        System.out.println(sol.maxArea(height));

        height = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(sol.maxArea(height));
    }
}
