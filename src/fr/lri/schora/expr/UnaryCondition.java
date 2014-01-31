/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lri.schora.expr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.lri.schora.expr.UnaryCondition#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.lri.schora.expr.ExprPackage#getUnaryCondition()
 * @model abstract="true"
 * @generated
 */
public interface UnaryCondition extends Condition {
	/**
	 * Returns the value of the '<em><b>Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' reference.
	 * @see #setExpr(Condition)
	 * @see fr.lri.schora.expr.ExprPackage#getUnaryCondition_Expr()
	 * @model required="true"
	 * @generated
	 */
	Condition getExpr();

	/**
	 * Sets the value of the '{@link fr.lri.schora.expr.UnaryCondition#getExpr <em>Expr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Condition value);

} // UnaryCondition
