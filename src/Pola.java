import java.util.Scanner;

public class Pola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan nilai n: ");
        int n = scanner.nextInt();

        soal2a(n);
        soal2b(n);
        soal2c(n);
        soal2d(n);
    }

    public static void soal2a(int n) {
        System.out.println("Soal 2a:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void soal2b(int n) {
        System.out.println("Soal 2b:");
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void soal2c(int n) {
        System.out.println("Soal 2c:");
        for (int i = 1; i <= n; i++) {
            int num = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
                num++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void soal2d(int n) {
        System.out.println("Soal 2d:");
        int[][] matrix = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][(i % 2 == 0) ? i : (n - 1 - i)] = num++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
