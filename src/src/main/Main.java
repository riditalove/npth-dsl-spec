package src.main;
import src.output.*;
import src.custom.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        // Take the input from the command line or hardcoded string (DSL input)
        String inputCode = "MyRect1: create Rectangle yellow  " +
                "(MyCircle1: create Circle blue" +
                "(MyRect2 : create Rectangle pink" + "(MyCircle2: create Circle blue)))";

        // Step 1: Create a CharStream from the input string
        CharStream input = CharStreams.fromString(inputCode);

        // Step 2: Create the lexer
        DSL2Lexer lexer = new DSL2Lexer(input);

        // Step 3: Tokenize the input using a token stream
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Step 4: Create the parser
        DSL2Parser parser = new DSL2Parser(tokens);

        // Step 5: Parse the input starting from the 'program' rule
        ParseTree tree = parser.program();

        // Step 6: Print the parse tree (for debugging purposes)
        System.out.println("Parse Tree:");
        System.out.println(tree.toStringTree(parser));

        // Step 7: Visit the tree and generate the AST
        MyVisitor visitor = new MyVisitor();
        ASTNode ast = visitor.visit(tree);
        // ASTNode.printAST(ast," ");

        // Step 8: Making the AST to Json
        JSONObject ans = new JSONObject();
        ans = ASTtoJson.convertToJson(ast);
        System.out.println(ans.toString(4));

        // Step 9: Creating Nodes in a Linked List
        MainNode head = LinkedList.makeList(ast);
        MainNode node1 = LinkedList.makeList(ast);
        AtomicInteger count = new AtomicInteger();
        LinkedList.addChildren(node1,ast,count );
        System.out.println("LINKEDLIST!!!!!!!!!!!");
        LinkedList.traverse(head);

        // Step 10: creating SVG

        try {
            LinkedListToSVG.generateSVG(head,"C:/out/graph.svg");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}