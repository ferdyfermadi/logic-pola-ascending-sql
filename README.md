# Soal 1

## Problem

Buatlah algoritma untuk menampilkan angka 1 s/d n, dengan ketentuan:
kelipatan 3 diganti "OK", kelipatan 4 diganti "YES", kelipatan 3 & 4 diganti "OKYES"

## Input
n = 15

## Output
1 2 OK YES 5 OK 7 YES OK 10 11 OKYES 13 14 OK

## Source Code

```java
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
```

# Soal 2

## Problem

Buatlah algoritma untuk empat soal di bawah ini, sesuai dengan nilai "n"

## Input
n = 5

## Output

### a.

1

22

333

4444

5555

### b.

1

21

321

4321

54321

### c.

1

23

454

3212

34543

### d.

1  10  11  20  21

2  9   12  19  22  
  
3  8   13  18  23

4  7   14  17  24

5  6   15  16  25

## Source Code

```java
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
```

# Soal 3

## Problem
n = [12, 9, 13, 6, 10, 4, 7, 2]
buatlah algoritma untuk membuang semua nilai dengan kelipatan tidak dan mengurutkan sisanya ke dalam array baru secara ascending (dari kecil ke besar)

## Output
n = [2, 4, 7, 10, 13]

## Source Code

```java
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
```

# Soal 4

## Problem

| pelanggan   |
|-------------|
| KODE        |
| NAMA        |
| ALAMAT      |


| transaksi        |
|------------------|
| KODE             |
| TANGGAL          |
| KODE_PELANGGAN   |
| KODE_BARANG      |
| JUMLAH_BARANG    |

| barang  |
|---------|
| KODE    |
| NAMA    |
| HARGA   |


Sesuaikan gambar relasi dan data table di atas, buatlah empat Query SQL untuk menampilkan data sesuai ketentuan :
- Data Barang dengan harga lebih besar dari 10.000 diurut berdasarkan Harga Satuan (ascending)
- Data Pelanggan yang namanya mengandung huruf "g" dengan alamat "BANDUNG"
- Data seluruh transaksi sesuai dengan tampilan di soal
- Data rekap nama, jumlah dan total harga pembelian sesuai dengan tampilan di soal

## Source Code

```sql
/* BAGIAN A */

SELECT *
FROM barang
WHERE harga > 10000
ORDER BY harga ASC;

/* BAGIAN B */

SELECT *
FROM pelanggan
WHERE nama LIKE '%g%' AND alamat = 'Bandung';


/* BAGIAN c */

SELECT
    t.kode AS kode,
    t.tanggal AS tanggal,
    p.nama AS "nama pelanggan",
    b.nama AS "nama barang",
    t.jumlah_barang AS jumlah,
    b.harga AS "harga satuan",
    t.jumlah_barang * b.harga AS total
FROM
    transaksi t
        JOIN
    pelanggan p ON t.kode_pelanggan = p.kode
        JOIN
    barang b ON t.kode_barang = b.kode
ORDER BY
    p.nama ASC, t.kode ASC;

/* BAGIAN D */
SELECT
    p.nama AS "nama pelanggan",
    SUM(t.jumlah_barang) AS jumlah,
    SUM(t.jumlah_barang * b.harga) AS "total harga"
FROM
    transaksi t
        JOIN
    pelanggan p ON t.kode_pelanggan = p.kode
        JOIN
    barang b ON t.kode_barang = b.kode
GROUP BY
    p.nama;
```





