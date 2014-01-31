/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lri.schora.expr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For All</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.lri.schora.expr.ForAll#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.lri.schora.expr.ExprPackage#getForAll()
 * @model
 * @generated
 */
public interface ForAll extends UnaryCondition {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference list.
	 * The list contents are of type {@link fr.lri.schora.expr.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference list.
	 * @see fr.lri.schora.expr.ExprPackage#getForAll_Variables()
	 * @model required="true"
	 * @generated
	 */
	EList<Variable> getVariables();

} // ForAll
