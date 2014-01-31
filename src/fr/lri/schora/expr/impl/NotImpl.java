/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lri.schora.expr.impl;

import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.ExprPackage;
import fr.lri.schora.expr.Not;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class NotImpl extends UnaryConditionImpl implements Not {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExprPackage.Literals.NOT;
	}

	@Override
	public String toString(){
		return String.format("NOT (%s)", expr.toString());
	}
	
	@Override
	public String toLaTEX(){
		return String.format("\\neg (%s)", expr.toLaTEX());
	}
	
	@Override
	public String toZ3Format(){
		return String.format("(not %s)", expr.toZ3Format());
	}
	
	public Not clone(){
		Not not = ExprFactory.eINSTANCE.createNot();
		not.setExpr(expr.clone());
		return not;
	}
} //NotImpl
