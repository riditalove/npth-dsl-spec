// Generated from C:/Users/HP/Desktop/DSLLL/src/Grammar/DSL2.g4 by ANTLR 4.13.2
package src.output;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DSL2Parser}.
 */
public interface DSL2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DSL2Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DSL2Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL2Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DSL2Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL2Parser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(DSL2Parser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL2Parser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(DSL2Parser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DSL2Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DSL2Parser.StatementContext ctx);
}