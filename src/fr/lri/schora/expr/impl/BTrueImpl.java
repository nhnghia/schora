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

import fr.lri.schora.expr.BTrue;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.ExprPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BTrue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BTrueImpl extends BooleanImpl implements BTrue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BTrueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExprPackage.Literals.BTRUE;
	}

	@Override
	public String toString(){
		return String.format("true");
	}
	
	@Override
	public String toLaTEX(){
		return String.format("true");
	}
	
	@Override
	public String toZ3Format(){
		return String.format("true");
	}
	
	public BTrue clone(){
		return ExprFactory.eINSTANCE.createBTrue();
	}
} //BTrueImpl
