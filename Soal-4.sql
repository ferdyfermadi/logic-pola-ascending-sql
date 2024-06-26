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
