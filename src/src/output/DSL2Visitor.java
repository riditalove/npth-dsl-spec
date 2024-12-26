// Generated from C:/Users/HP/Desktop/DSLLL/src/Grammar/DSL2.g4 by ANTLR 4.13.2
package src.output;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DSL2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DSL2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DSL2Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DSL2Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL2Parser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(DSL2Parser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL2Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DSL2Parser.StatementContext ctx);
}