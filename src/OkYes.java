import java.util.Scanner;

public class OkYes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("masukan data n : ");
        int n = scanner.nextInt();

        for (int i = 1; i < n; i++) {
            if ( i % 3 == 0 && i % 4 == 0){
                System.out.print("OKYES ");
            } else if (i % 4 == 0) {
                System.out.print("YES ");
            } else if (i % 3 == 0) {
                System.out.print("OK ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}