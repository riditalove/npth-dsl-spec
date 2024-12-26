package src.custom;

import src.output.*;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

public class MyVisitor extends DSL2BaseVisitor<ASTNode>
{
    public ASTNode visitProgram(DSL2Parser.ProgramContext ctx)
    {
        ASTNode programNode = new ASTNode("program","","","",null );
        for(DSL2Parser.StatementContext stmt : ctx.statements().statement())
        {
            programNode.addChild(visit(stmt));
        }
        return programNode;
    }
    public ASTNode visitStatement(DSL2Parser.StatementContext ctx)
    {
        ASTNode statementNode = new ASTNode("Statement","","","",null);
        statementNode.setName(ctx.NAME().getText());
        statementNode.setAction(ctx.ACTION().getText());
        statementNode.setShape(ctx.SHAPE().getText());
        if(ctx.COLOR()!=null)
        {
            statementNode.setColor(ctx.COLOR().getText());
        }
   // "context" in ANTLR is essentially a node in the parse tree that holds information about a specific rule.
        if(ctx.LPAREN()!=null)
        {
            for (DSL2Parser.StatementContext childStmt : ctx.statements().statement()) {
                statementNode.addChild(visit(childStmt));
            }
        }
        return statementNode;

    }



}