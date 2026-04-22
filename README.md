# Library Catalog System
Sistem manajemen perpustakaan berbasis konsol (CLI) yang diimplementasikan menggunakan berbagai konsep struktur data fundamental untuk efisiensi pengelolaan data.

Program ini dibuat untuk memenuhi tugas kelompok pada mata kuliah Struktur Data.

## Anggota Kelompok dan Pembagian Tugas
* **Abrar (S1):** Manajemen Koleksi Buku (Dynamic Array)
* **Muhamad Arifin Hidayatullah (S2):** Antrean Peminjaman (Queue - Linked Nodes)
* **Rofi (S3):** Riwayat Pengembalian (Stack - Linked Nodes)
* **Mufi (S4):** Indeks Peminjaman Anggota (HashMap - Array of Buckets)

---

## Arsitektur dan Struktur Data
Proyek ini mengintegrasikan empat modul utama dengan implementasi struktur data spesifik sesuai dengan panduan instruksi:

| Modul Class | Struktur Data | Metode Utama |
| :--- | :--- | :--- |
| **BookCollection.java** | **Dynamic Array** | addBook, removeBook, findByIsbn, findByAuthor, listAvailable |
| **BorrowingQueue.java** | **Queue (Linked Nodes)** | enqueue, dequeue, peek, isEmpty, displayQueue |
| **ReturnHistoryStack.java** | **Stack (Linked Nodes)** | push, pop (undo return), peek, displayHistory |
| **MemberLoanIndex.java** | **HashMap (Buckets)** | put, get, containsKey, listAllKeys |

---

## Entitas Data (Shared Classes)
Sistem menggunakan kelas entitas bersama yang mendefinisikan objek utama dalam aplikasi:
* **Book.java:** Mengelola data buku (ISBN, judul, penulis, tahun, status ketersediaan).
* **Member.java:** Mengelola data anggota (ID, nama, email, jumlah pinjaman).
* **BorrowRecord.java:** Mencatat transaksi (ID anggota, ISBN buku, tanggal pinjam, tanggal kembali).

## Fitur Aplikasi
1. **Inventaris Dinamis:** Menambah dan menghapus buku tanpa batasan ukuran tetap.
2. **Antrean Peminjaman:** Memproses antrean anggota berdasarkan urutan masuk (FIFO).
3. **Riwayat Pengembalian:** Mencatat histori pengembalian dengan fungsi pembatalan (Undo) menggunakan Stack.
4. **Indeks Pencarian Cepat:** Akses data pinjaman anggota secara instan melalui implementasi Hash Table.

## Teknologi dan Lingkungan
* **Bahasa Pemrograman:** Java
* **Antarmuka:** Terminal / Command Line Interface (CLI)
* **Penyimpanan:** Local File Persistence (Data tersimpan dalam penyimpanan lokal laptop).

---

## Panduan Menjalankan Aplikasi
Ikuti langkah-langkah berikut untuk menjalankan program di perangkat Anda:

1. Pastikan Java Development Kit (JDK) sudah terinstal.
2. Buka terminal atau command prompt.
3. Masuk ke direktori tempat file proyek disimpan.
4. Kompilasi seluruh file Java dengan perintah:
   ```bash
   javac *.java
5. jalankan aplikasi utama dengan perintah:
   java Main
