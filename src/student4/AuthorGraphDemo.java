package student4;

import java.util.Scanner;

public class AuthorGraphDemo {
    public static void main(String[] args) {
        AuthorGraph graph = new AuthorGraph();

        //1. Inisialisasi data penulis & relasi awal
        graph.addAuthor("Tere liye");
        graph.addAuthor("Habiburrahman");
        graph.addAuthor("Baskara");
        graph.addAuthor("Holmes");

        graph.addCoAuthorship("Tere liye", "Habiburrahman");
        graph.addCoAuthorship("Habiburrahman", "Baskara");
        graph.addCoAuthorship("Baskara", "Holmes");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("==============================================");
        System.out.println("=== DEMO AUTHOR GRAPH MODULE ===");
        System.out.println("==============================================");

        while (running) {
            System.out.println("\n-- PILIH FITUR YANG INGIN DITRY--");
            System.out.println("1. Jalankan Automated Demo Test (Output lengkap)");
            System.out.println("2. Cari teman kolaborasi langsung (Direct Co-authors)");
            System.out.println("3. Cari jalur kolaborasi terpendek (Shortest path BFS)");
            System.out.println("4. Tambah penulis baru (Add author)");
            System.out.println("5. Tambah relasi kolaborasi (Add Co-authorship)");
            System.out.println("6. Lihat statistik jaringan (total authors & relationship)");
            System.out.println("0. Keluar program");
            System.out.print("Masukkan pilihan anda (0-6)");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    System.out.println("\n=== RUNNING AUTOMATED DEMO TEST ===");
                    System.out.println("Duplicated add test (Tere liye): " + graph.addAuthor("Tere liye"));
                    System.out.println("Total authors: " + graph.getAuthorCount());
                    System.out.println("Total relationships: " + graph.getEdgeCount());

                    System.out.println("\nDirect Co-authors of Habiburrahman:");
                    String[] coAuthorsHab = graph.getCoAuthors("Habiburrahman");
                    for (String author : coAuthorsHab) {
                        System.out.println("- " + author);
                    }

                    System.out.println("\nShortest Collaboration Path (Tere liye -> Habiburrahman -> Baskara -> Holmes):");
                    String[] pathDemo = graph.findShortestCollaborationPath("Tere liye", "Holmes");
                    for (int i = 0; i < pathDemo.length; i++) {
                        System.out.print(pathDemo[i]);
                        if (i < pathDemo.length - 1) System.out.print(" -> ");
                    }
                    System.out.println();

                    System.out.println("\nNot-Found Test: " + (graph.getCoAuthors("Unknown Author").length == 0 ? "Handled gracefully (Empty Array)" : "Error"));
                    break;

                case "2":
                    System.out.print("\nMasukkan nama penulis yang ingin dicek: ");
                    String name = scanner.nextLine().trim();
                    String[] coAuthors = graph.getCoAuthors(name);

                    if (coAuthors.length == 0) {
                        System.out.println("Penulis tidak dapat ditemukan atau tidak memiliki teman kolaborasi.");
                    } else {
                        System.out.println("\nDirect Co-authors of " + name + ":");
                        for (String author : coAuthors) {
                            System.out.println("- " + author);
                        }
                    }
                    break;
                case "3":
                    System.out.println("\nMasukkan nama penulis asal (Start): ");
                    String start = scanner.nextLine().trim();
                    System.out.print("Masukkan nama penulis tujuan (Target): ");
                    String target = scanner.nextLine().trim();
                    
                    String [] path = graph.findShortestCollaborationPath(start, target);
                    if (path.length == 0) {
                        System.out.println("Tidak ditemukan jalur kolaborasi antara " + start + " dan " + target + ".");
                    } else {
                        System.out.println("\nShortest Collaboration Path (" + start + " -> " + target + "):");
                        for (int i = 0; i < path.length; i++) {
                            System.out.print(path[i]);
                            if (i < path.length - 1) System.out.print(" -> ");
                        }
                        System.out.println();
                    }
                    break;

                case "4":
                    System.out.print("\nMasukkan nama penulis baru yang ingin ditambahkan: ");
                    String newAuthor = scanner.nextLine().trim();
                    boolean added = graph.addAuthor(newAuthor);
                    if (added) {
                        System.out.println("Berhasil menambahkan penulis: " + newAuthor);
                    } else {
                        System.out.println("Gagal! Penulis sudah terdaftar atau nama tidak valid.");
                    }
                    break;

                case "5":
                    System.out.print("\nMasukkan nama penulis pertama: ");
                    String a1 = scanner.nextLine().trim();
                    System.out.print("Masukkan nama penulis kedua: ");
                    String a2 = scanner.nextLine().trim();

                    boolean linked = graph.addCoAuthorship(a1, a2);
                    if (linked) {
                        System.out.println("Berhasil menghubungkan kolaborasi" + a1 + " <-> " + a2);
                    } else {
                        System.out.println("Gagal! Pastikan kedua penulis sudah terdaftar dan belum terhubung.");
                    }
                    break;

                case "6":
                    System.out.println("\n=== STATISTIK JARINGAN AUTHOR ===");
                    System.out.println("Total penulis terdaftar: " + graph.getAuthorCount());
                    System.out.println("Total relasi kolaborasi: " + graph.getAuthorCount());
                    break;

                case "0":
                    System.out.println("\nTerima kasih! Program selesai.");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Masukkan angka 0-6.");
                    break;
            }
        }
        scanner.close();
    }
}
>>>>>>> 3e97873ae368a453ac70413c8b4a16fdceb59b64
