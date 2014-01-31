/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lri.schora.expr.impl;

import fr.lri.schora.expr.Bracket;
import fr.lri.schora.expr.ExprPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bracket</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BracketImpl extends UnaryConditionImpl implements Bracket {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BracketImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExprPackage.Literals.BRACKET;
	}

	@Override
	public String toString(){
		return String.format("(%s)", expr.toString());
	}
	
	@Override
	public String toLaTEX(){
		return String.format("(%s)", expr.toLaTEX());
	}
	
	@Override
	public String toZ3Format(){
		return String.format("%s", expr.toZ3Format());
	}
} //BracketImpl
