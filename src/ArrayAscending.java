import java.util.Arrays;

public class ArrayAscending {
    public static void main(String[] args) {

        int[] n = {12, 9, 13, 6, 10, 4, 7, 2};
        n = Arrays.stream(n).filter(i -> i % 3 != 0).toArray();
        Arrays.sort(n);
        System.out.print("n = [");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i]);
            if (i < n.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

    }
}
