package src.custom;

import java.util.concurrent.atomic.AtomicInteger;

public class LinkedList {

    // Method to create a linked list from an ASTNode
    public static MainNode makeList(ASTNode ast) {
        AtomicInteger counter = new AtomicInteger(1); // Counter for unique IDs

        // Create the head node
        MainNode head = new MainNode(
                0, // Parent ID for the root node is 0 (no parent)
                counter.getAndIncrement(), // Unique self ID
                ast.getName(),
                ast.getAction(),
                ast.getShape(),
                ast.getColor(),
                null
        );

        // Helper method to recursively add children
        addChildren(head, ast, counter);

        return head; // Return the head of the linked list
    }

    // Recursive method to add children nodes
    public static void addChildren(MainNode parent, ASTNode ast, AtomicInteger counter) {
        if (ast.getNested() != null && !ast.getNested().isEmpty()) {
            for (ASTNode childAST : ast.getNested()) {
                // Create a new child node
                MainNode child = new MainNode(
                        parent.selfId, // Parent ID is the current node's ID
                        counter.getAndIncrement(), // Unique self ID
                        childAST.getName(),
                        childAST.getAction(),
                        childAST.getShape(),
                        childAST.getColor(),
                        null
                );

                // Attach the child node
                if (parent.next == null) {
                    parent.next = child; // Set the first child
                } else {
                    MainNode temp = parent.next;
                    while (temp.next != null) {
                        temp = temp.next; // Traverse to the end of the sibling list
                    }
                    temp.next = child; // Add the child as the next sibling
                }

                // Recursively process the nested children
                addChildren(child, childAST, counter);
            }
        }
    }
    public static void traverse(MainNode node) {
        if (node == null) {
            return;
        }

        // Print the current node's information
        System.out.println("Node ID: " + node.selfId +
                ", Name: " + node.name +
                ", Action: " + node.action +
                ", Shape: " + node.shape +
                ", Color: " + node.color +
                ", Parent ID: " + node.parentId);

        // Traverse the sibling nodes (linked via the `next` field)
        MainNode current = node.next;
        while (current != null) {
            System.out.println("Node ID: " + current.selfId +
                    ", Name: " + current.name +
                    ", Action: " + current.action +
                    ", Shape: " + current.shape +
                    ", Color: " + current.color +
                    ", Parent ID: " + current.parentId);
            current = current.next;
        }
    }


}
