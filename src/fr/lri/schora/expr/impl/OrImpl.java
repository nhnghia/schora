/*******************************************************************************
 * This code is distributed under GPL v2 licence.
 * 
 * This code is provided solely "as is". 
 * There is no warranty or other guarantee of fitness of this code.
 * The author disclaims all responsibility and liability 
 * with respect to this code's usage
 * or its effect upon hardware or computer systems.
 * 
 * author: Huu-Nghia Nguyen
 * email : nhnghia@me.com
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lri.schora.expr.impl;

import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.ExprPackage;
import fr.lri.schora.expr.Not;
import fr.lri.schora.expr.Or;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Or</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrImpl extends BinaryConditionImpl implements Or {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExprPackage.Literals.OR;
	}

	@Override
	public String toString(){
		return String.format("(%s) or (%s)", expr.toString(), expr2.toString());
	}
	
	@Override
	public String toLaTEX(){
		return String.format("%s \\vee %s", expr.toLaTEX(), expr2.toLaTEX());
	}
	
	@Override
	public String toZ3Format(){
		return String.format("(or %s %s)", expr.toZ3Format(), expr2.toZ3Format());
	}
	
	public Or clone(){
		Or or = ExprFactory.eINSTANCE.createOr();
		or.setExpr(expr.clone());
		or.setExpr2(expr2.clone());
		return or;
	}
} //OrImpl
