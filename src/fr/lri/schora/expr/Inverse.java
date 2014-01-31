/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lri.schora.expr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inverse</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.lri.schora.expr.Inverse#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.lri.schora.expr.ExprPackage#getInverse()
 * @model
 * @generated
 */
public interface Inverse extends Expression {
	/**
	 * Returns the value of the '<em><b>Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' reference.
	 * @see #setExpr(Expression)
	 * @see fr.lri.schora.expr.ExprPackage#getInverse_Expr()
	 * @model required="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link fr.lri.schora.expr.Inverse#getExpr <em>Expr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

} // Inverse
