package student3;

import shared.Book;

public class CatalogBST {

    private static class Node {
        Book book;
        Node left, right;

        public Node(Book book) {
            this.book = book;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public CatalogBST() {
        this.root = null;
    }

    public void insert(Book book) {
        root = insertRec(root, book);
    }

    private Node insertRec(Node root, Book book) {
        if (root == null) {
            return new Node(book);
        }

        int cmp = book.isbn.compareTo(root.book.isbn);
        if (cmp < 0) {
            root.left = insertRec(root.left, book);
        }

        else if (cmp > 0) {
            root.right = insertRec(root.right, book);
        }
        return root;
    }

    public Book search(String isbn) {
        return searchRec(root, isbn);
    }

    private Book searchRec(Node root, String isbn) {
        if (root == null || root.book.isbn.equals(isbn)) {
            return root == null ? null : root.book;
        }

        if (isbn.compareTo(root.book.isbn) < 0) {
            return searchRec(root.left, isbn);
        }
        return searchRec(root.right, isbn);
    }

    public void inOrderTraversal() {
        System.out.println("=== Katalog Buku (urut ISBN) ===");
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);

            String status = root.book.available ? "[tersedia]" : "[tidak tersedia]";

            System.out.println(String.format("[%s] %-21s - %-14s (%d) %s", root.book.isbn, root.book.title, root.book.author, root.book.year, status));

            inOrderRec(root.right);
        }
    }

    public String getFirstIsbn() {
        if (root == null) return null;
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.book.isbn;
    }
}