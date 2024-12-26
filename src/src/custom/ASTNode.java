package src.custom;

import java.util.ArrayList;

public class ASTNode {
    private String name;
    private String action;
    private String shape;
    private String color;
    private ArrayList<ASTNode> nested;  // A list to hold child nodes

    // Constructor
    public ASTNode()
    {

    }
    public ASTNode(String name, String action, String shape, String color, ArrayList<ASTNode> nested) {
        this.name = name;
        this.action = action;
        this.shape = shape;
        this.color = color;
        this.nested = nested != null ? nested : new ArrayList<>();
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<ASTNode> getNested() {
        return nested;
    }

    public void setNested(ArrayList<ASTNode> nested) {
        this.nested = nested;
    }

    // Method to add a child node to the nested list
    public void addChild(ASTNode child) {
        nested.add(child);
    }

    public static void printAST(ASTNode node, String prefix) {
        if (node == null) return; // Handle null node

        // Print details of the current node
        System.out.println(prefix + "Node:");
        System.out.println(prefix + "  Name: " + node.getName());
        System.out.println(prefix + "  Action: " + node.getAction());
        System.out.println(prefix + "  Shape: " + node.getShape());
        System.out.println(prefix + "  Color: " + node.getColor());

        // Print child nodes recursively with indentation
        for (ASTNode child : node.getNested()) {
            printAST(child, prefix + "    ");
        }
    }

    // Overloaded method for convenience (initial call)
    public static void printAST(ASTNode root) {
        printAST(root, "");
    }


}
