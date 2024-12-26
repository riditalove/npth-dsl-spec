package src.custom;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LinkedListToSVG {
    public static void generateSVG(MainNode head, String fileName) throws IOException {
        // Create a FileWriter and BufferedWriter to write the SVG file
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        // SVG header
        writer.write("<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\"\n");
        writer.write("width=\"800\" height=\"600\">\n");

        // Traverse the linked list starting from the head node
        int x = 100;  // Initial x position
        int y = 100;  // Initial y position
        int xOffset = 150;  // Horizontal offset for each sibling node
        int yOffset = 100;  // Vertical offset for child nodes

        MainNode currentNode = head;

        // Loop through the linked list using a while loop
        while (currentNode != null) {
            // Draw the node based on its shape
            String shapeElement = "";

            // Handle shapes based on 'shape' attribute
            if ("circle".equalsIgnoreCase(currentNode.shape)) {
                shapeElement = "<circle parentId=\"" +currentNode.parentId + "\" id=\"" + currentNode.selfId + "\" cx=\"" + x + "\" cy=\"" + y + "\" r=\"20\" fill=\"" + currentNode.color + "\" />";
            } else if ("rectangle".equalsIgnoreCase(currentNode.shape)) {
                shapeElement = "<rect parentId=\"" +currentNode.parentId + "\" id=\"" + currentNode.selfId + "\" x=\"" + (x - 20) + "\" y=\"" + (y - 20) + "\" width=\"40\" height=\"40\" fill=\"" + currentNode.color + "\" />";
            } else {
                // If the shape is not recognized, skip the current node
                currentNode = currentNode.next;
                continue;
            }

            // Write the shape to the SVG file
            writer.write(shapeElement + "\n");

            // Move to the next sibling (next node in the linked list)
            currentNode = currentNode.next;

            // Move the x position for the next sibling node
            y += yOffset; // Increase the y-position for the next sibling node
        }

        // SVG footer
        writer.write("</svg>");

        // Close the BufferedWriter
        writer.close();
    }


}
