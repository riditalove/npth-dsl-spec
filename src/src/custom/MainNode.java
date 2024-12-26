package src.custom;

import src.output.*;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainNode {

    int parentId;  // Parent ID to represent the relationship
    int selfId;    // Unique ID for the current node
    String name;   // Node name
    String action; // Action associated with the node
    String shape;  // Shape associated with the node
    String color;  // Color of the node
    MainNode next; // Reference to the next node in a linked list-like structure

    // Constructor

    public MainNode(int parentId, int selfId, String name, String action, String shape, String color, MainNode next) {
        this.parentId = parentId;
        this.selfId = selfId;
        this.name = name;
        this.action = action;
        this.shape = shape;
        this.color = color;
        this.next = next;
    }

    // Getters and Setters (optional, if you need them)
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getSelfId() {
        return selfId;
    }

    public void setSelfId(int selfId) {
        this.selfId = selfId;
    }

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

    public MainNode getNext() {
        return next;
    }

    public void setNext(MainNode next) {
        this.next = next;
    }
}
