import java.security.InvalidParameterException;

public class Main {
    public static void main(String[] args) {
        System.out.println(material(new int[] {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3}));
        System.out.println(material(new int[] {6, 2, 1, 1, 8, 0, 5, 5, 0, 1, 8, 9, 6, 9, 4, 8, 0, 0}));
    }

    public static int material(int[] spaceship) {
        if (spaceship.length < 3) return 0;
        int leftMax = 0, rightMax = 0;
        int maxArea = 0;
        for (int left = 0, right = spaceship.length - 1; left < right;) {
            if (spaceship[left] < 0 || spaceship[right] < 0) throw new InvalidParameterException("All walls must be non-negative");
            if (spaceship[left] < spaceship[right]) {
                if (spaceship[left] > leftMax) {
                    leftMax = spaceship[left];
                } else {
                    maxArea += leftMax - spaceship[left];
                }
                left++;
            } else {
                if (spaceship[right] > rightMax) {
                    rightMax = spaceship[right];
                } else {
                    maxArea += rightMax - spaceship[right];
                }
                right--;
            }
        }

        return maxArea;
    }
}