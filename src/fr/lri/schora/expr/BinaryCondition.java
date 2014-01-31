/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lri.schora.expr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.lri.schora.expr.BinaryCondition#getExpr2 <em>Expr2</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.lri.schora.expr.ExprPackage#getBinaryCondition()
 * @model abstract="true"
 * @generated
 */
public interface BinaryCondition extends UnaryCondition {
	/**
	 * Returns the value of the '<em><b>Expr2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr2</em>' reference.
	 * @see #setExpr2(Condition)
	 * @see fr.lri.schora.expr.ExprPackage#getBinaryCondition_Expr2()
	 * @model required="true"
	 * @generated
	 */
	Condition getExpr2();

	/**
	 * Sets the value of the '{@link fr.lri.schora.expr.BinaryCondition#getExpr2 <em>Expr2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr2</em>' reference.
	 * @see #getExpr2()
	 * @generated
	 */
	void setExpr2(Condition value);

} // BinaryCondition
