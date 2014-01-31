/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lri.schora.expr.impl;

import fr.lri.schora.expr.BFalse;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.ExprPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BFalse</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BFalseImpl extends BooleanImpl implements BFalse {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BFalseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExprPackage.Literals.BFALSE;
	}

	@Override
	public String toString(){
		return String.format("false");
	}
	
	@Override
	public String toLaTEX(){
		return String.format("false");
	}
	
	@Override
	public String toZ3Format(){
		return String.format("false");
	}
	
	public BFalse clone(){
		return ExprFactory.eINSTANCE.createBFalse();
	}
} //BFalseImpl
