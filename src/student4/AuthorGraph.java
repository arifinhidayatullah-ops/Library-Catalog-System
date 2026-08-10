student4
package student4;

import shared.Book;

/**
 * Custom Graph Implementation for Author Collaboration Network.
 * Strictly avoids java.util.* collection classes.
 * Uses shared.Book without modifying shared package.
 */

public class AuthorGraph {

    // Custom Inner Class for Edge Nodes (LinkedList of Adjacency)
    
    private static class EdgeNode {
        String targetAuthor;
        EdgeNode next;

        public EdgeNode(String targetAuthor) {
            this.targetAuthor = targetAuthor;
            this.next =null;
        }
    }

    // Custom Inner Class for Author Nodes (Bucket Array Chain)
    private static class AuthorNode {
        String authorName;
        EdgeNode adjacencyHead;
        AuthorNode nextInBucket;

        public AuthorNode(String authorName) {
            this.authorName = authorName;
            this.adjacencyHead = null;
            this.nextInBucket = null;
        }
    }

    private AuthorNode[] headBuckets;
    private int authorCount;
    private int edgeCount;
    private static final int DEFAULT_CAPACITY = 16;

    public AuthorGraph() {
        this(DEFAULT_CAPACITY);
    }

    public AuthorGraph(int initialCapacity) {
        this.headBuckets = new AuthorNode[initialCapacity];
        this.authorCount = 0;
        this.edgeCount = 0;
    }

    private int getBucketindex(String authorName) {
        if (authorName == null) return 0;
        int hashCode = authorName.hashCode();
        return Math.abs(hashCode) % headBuckets.length;
    }

    private AuthorNode findNode(String authorName) {
        if (authorName == null || isEmpty()) return null;
        int index = getBucketindex(authorName);
        AuthorNode current = headBuckets[index];
        while (current != null) {
            if (current.authorName.equalsIgnoreCase(authorName)) {
                return current;
            }
            current = current.nextInBucket;
        }
        return null;
    }

    //1. Add Author Name directly
    public boolean addAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) return false;

        //Duplicate Handling
        if (findNode(authorName) != null) {
            return false;
        }

        int index = getBucketindex(authorName);
        AuthorNode newNode = new AuthorNode(authorName);
        newNode.nextInBucket = headBuckets[index];
        headBuckets[index] = newNode;
        authorCount++;
        return true;
    }

    //Helper: Add c0-authorship from a shared Book object
    public void addCoAuthorsFroomBook(Book book, String author1, String author2) {
        if (book == null) return;
        addAuthor(author1);
        addAuthor(author2);
        addCoAuthorship(author1, author2);
    }

    //2. add co-Authorship (Undirected Edge)
    public boolean addCoAuthorship(String author1, String author2) {
        if (author1 == null || author2 == null || author1.equalsIgnoreCase(author2)) return false;

        AuthorNode node1 = findNode(author1);
        AuthorNode node2 = findNode(author2);

        //Not-Found Handling
        if (node1 == null || node2 == null) return false;

        //Check Duplicate Edge
        if (hasDirectEdge(node1, author2)) return false;

        //Add edge noe1 > node2
        EdgeNode edge1 = new EdgeNode(node2.authorName);
        edge1.next = node1.adjacencyHead;
        node1.adjacencyHead = edge1;

        //add edge node2 / node1
        EdgeNode edge2 = new EdgeNode(node1.authorName);
        edge2.next = node2.adjacencyHead;
        node2.adjacencyHead = edge2;

        edgeCount++;
        return true;
    }

    private boolean hasDirectEdge(AuthorNode source, String targetAuthor) {
        EdgeNode current = source.adjacencyHead;
        while ( (current != null)) {
            if (current.targetAuthor.equalsIgnoreCase(targetAuthor)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //3. Get Direct Co- Authors
    public String[] getCoAuthors(String authorName) {
        AuthorNode node = findNode(authorName);

        if (node == null || node.adjacencyHead == null) {
            return new String[0];
        }

        int count = 0;
        EdgeNode curr = node.adjacencyHead;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        String[] result = new String[count];
        curr = node.adjacencyHead;
        for (int i = 0; i < count; i++) {
            result[i] = curr.targetAuthor;
            curr = curr.next;
        }
        return result;
    }

    //4. BFS traversal - find shortest collaboration path
    public String[] findShortestCollaborationPath(String startAuthor, String targetAuthor) {
        AuthorNode startNode = findNode(startAuthor);
        AuthorNode targetNode =findNode(targetAuthor);

        if (startNode == null || targetNode == null) return new String[0];

        AuthorNode[] queue = new AuthorNode[authorCount];
        int[] parentIndex = new int[authorCount];
        AuthorNode[] visited = new AuthorNode[authorCount];

        int head = 0, tail = 0, visitedCount = 0;

        queue[tail] = startNode;
        parentIndex[tail] = -1;
        visited[visitedCount++] = startNode;
        tail++;

         int targetFoundIndex = -1;

         while (head < tail) {
            AuthorNode current = queue[head];

            if (current.authorName.equalsIgnoreCase(targetAuthor)) {
                targetFoundIndex = head;
                break;
            }

            EdgeNode edge = current.adjacencyHead;
            while (edge != null) {
                AuthorNode neighbor = findNode(edge.targetAuthor);
                if (neighbor != null && !containsNode(visited, visitedCount, neighbor)) {
                    visited[visitedCount++] = neighbor;
                    queue[tail] = neighbor;
                    parentIndex[tail] = head;
                    tail++;
                }
                edge = edge.next;
            }
            head++;
         }

         if (targetFoundIndex == -1) return new String[0];

         int pathLength = 0;
         int curridx = targetFoundIndex;
         while (curridx != -1) {
            pathLength++;
            curridx = parentIndex[curridx];
         }

         String[] path = new String[pathLength];
         curridx = targetFoundIndex;
         for (int i = pathLength - 1; i >= 0; i--) {
            path[i] = queue[curridx].authorName;
            curridx = parentIndex[curridx];
         }
         return path;
    }

    private boolean containsNode(AuthorNode[] array, int size, AuthorNode target) {
        for (int i = 0; i < size; i++) {
            if (array[i] == target) return true;
        }
        return false;
    }

    public int getAuthorCount() { return authorCount;}
    public int getEdgeCount() { return edgeCount;}
    public boolean isEmpty() { return authorCount == 0;}

package student4;

import shared.Book;

/**
 * Custom Graph Implementation for Author Collaboration Network.
 * Strictly avoids java.util.* collection classes.
 * Uses shared.Book without modifying shared package.
 */

public class AuthorGraph {

    // Custom Inner Class for Edge Nodes (LinkedList of Adjacency)
    
    private static class EdgeNode {
        String targetAuthor;
        EdgeNode next;

        public EdgeNode(String targetAuthor) {
            this.targetAuthor = targetAuthor;
            this.next =null;
        }
    }

    // Custom Inner Class for Author Nodes (Bucket Array Chain)
    private static class AuthorNode {
        String authorName;
        EdgeNode adjacencyHead;
        AuthorNode nextInBucket;

        public AuthorNode(String authorName) {
            this.authorName = authorName;
            this.adjacencyHead = null;
            this.nextInBucket = null;
        }
    }

    private AuthorNode[] headBuckets;
    private int authorCount;
    private int edgeCount;
    private static final int DEFAULT_CAPACITY = 16;

    public AuthorGraph() {
        this(DEFAULT_CAPACITY);
    }

    public AuthorGraph(int initialCapacity) {
        this.headBuckets = new AuthorNode[initialCapacity];
        this.authorCount = 0;
        this.edgeCount = 0;
    }

    private int getBucketindex(String authorName) {
        if (authorName == null) return 0;
        int hashCode = authorName.hashCode();
        return Math.abs(hashCode) % headBuckets.length;
    }

    private AuthorNode findNode(String authorName) {
        if (authorName == null || isEmpty()) return null;
        int index = getBucketindex(authorName);
        AuthorNode current = headBuckets[index];
        while (current != null) {
            if (current.authorName.equalsIgnoreCase(authorName)) {
                return current;
            }
            current = current.nextInBucket;
        }
        return null;
    }

    //1. Add Author Name directly
    public boolean addAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) return false;

        //Duplicate Handling
        if (findNode(authorName) != null) {
            return false;
        }

        int index = getBucketindex(authorName);
        AuthorNode newNode = new AuthorNode(authorName);
        newNode.nextInBucket = headBuckets[index];
        headBuckets[index] = newNode;
        authorCount++;
        return true;
    }

    //Helper: Add c0-authorship from a shared Book object
    public void addCoAuthorsFroomBook(Book book, String author1, String author2) {
        if (book == null) return;
        addAuthor(author1);
        addAuthor(author2);
        addCoAuthorship(author1, author2);
    }

    //2. add co-Authorship (Undirected Edge)
    public boolean addCoAuthorship(String author1, String author2) {
        if (author1 == null || author2 == null || author1.equalsIgnoreCase(author2)) return false;

        AuthorNode node1 = findNode(author1);
        AuthorNode node2 = findNode(author2);

        //Not-Found Handling
        if (node1 == null || node2 == null) return false;

        //Check Duplicate Edge
        if (hasDirectEdge(node1, author2)) return false;

        //Add edge noe1 > node2
        EdgeNode edge1 = new EdgeNode(node2.authorName);
        edge1.next = node1.adjacencyHead;
        node1.adjacencyHead = edge1;

        //add edge node2 / node1
        EdgeNode edge2 = new EdgeNode(node1.authorName);
        edge2.next = node2.adjacencyHead;
        node2.adjacencyHead = edge2;

        edgeCount++;
        return true;
    }

    private boolean hasDirectEdge(AuthorNode source, String targetAuthor) {
        EdgeNode current = source.adjacencyHead;
        while ( (current != null)) {
            if (current.targetAuthor.equalsIgnoreCase(targetAuthor)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //3. Get Direct Co- Authors
    public String[] getCoAuthors(String authorName) {
        AuthorNode node = findNode(authorName);

        if (node == null || node.adjacencyHead == null) {
            return new String[0];
        }

        int count = 0;
        EdgeNode curr = node.adjacencyHead;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        String[] result = new String[count];
        curr = node.adjacencyHead;
        for (int i = 0; i < count; i++) {
            result[i] = curr.targetAuthor;
            curr = curr.next;
        }
        return result;
    }

    //4. BFS traversal - find shortest collaboration path
    public String[] findShortestCollaborationPath(String startAuthor, String targetAuthor) {
        AuthorNode startNode = findNode(startAuthor);
        AuthorNode targetNode =findNode(targetAuthor);

        if (startNode == null || targetNode == null) return new String[0];

        AuthorNode[] queue = new AuthorNode[authorCount];
        int[] parentIndex = new int[authorCount];
        AuthorNode[] visited = new AuthorNode[authorCount];

        int head = 0, tail = 0, visitedCount = 0;

        queue[tail] = startNode;
        parentIndex[tail] = -1;
        visited[visitedCount++] = startNode;
        tail++;

         int targetFoundIndex = -1;

         while (head < tail) {
            AuthorNode current = queue[head];

            if (current.authorName.equalsIgnoreCase(targetAuthor)) {
                targetFoundIndex = head;
                break;
            }

            EdgeNode edge = current.adjacencyHead;
            while (edge != null) {
                AuthorNode neighbor = findNode(edge.targetAuthor);
                if (neighbor != null && !containsNode(visited, visitedCount, neighbor)) {
                    visited[visitedCount++] = neighbor;
                    queue[tail] = neighbor;
                    parentIndex[tail] = head;
                    tail++;
                }
                edge = edge.next;
            }
            head++;
         }

         if (targetFoundIndex == -1) return new String[0];

         int pathLength = 0;
         int curridx = targetFoundIndex;
         while (curridx != -1) {
            pathLength++;
            curridx = parentIndex[curridx];
         }

         String[] path = new String[pathLength];
         curridx = targetFoundIndex;
         for (int i = pathLength - 1; i >= 0; i--) {
            path[i] = queue[curridx].authorName;
            curridx = parentIndex[curridx];
         }
         return path;
    }

    private boolean containsNode(AuthorNode[] array, int size, AuthorNode target) {
        for (int i = 0; i < size; i++) {
            if (array[i] == target) return true;
        }
        return false;
    }

    public int getAuthorCount() { return authorCount;}
    public int getEdgeCount() { return edgeCount;}
    public boolean isEmpty() { return authorCount == 0;}
main
}