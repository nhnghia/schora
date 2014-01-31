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

import java.util.HashSet;
import java.util.Set;

import fr.lri.schora.expr.BinaryCondition;
import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.Constance;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.ExprPackage;
import fr.lri.schora.expr.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.lri.schora.expr.impl.BinaryConditionImpl#getExpr2 <em>Expr2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BinaryConditionImpl extends UnaryConditionImpl implements BinaryCondition {
	/**
	 * The cached value of the '{@link #getExpr2() <em>Expr2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpr2()
	 * @generated
	 * @ordered
	 */
	protected Condition expr2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExprPackage.Literals.BINARY_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getExpr2() {
		if (expr2 != null && expr2.eIsProxy()) {
			InternalEObject oldExpr2 = (InternalEObject)expr2;
			expr2 = (Condition)eResolveProxy(oldExpr2);
			if (expr2 != oldExpr2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExprPackage.BINARY_CONDITION__EXPR2, oldExpr2, expr2));
			}
		}
		return expr2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition basicGetExpr2() {
		return expr2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr2(Condition newExpr2) {
		Condition oldExpr2 = expr2;
		expr2 = newExpr2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.BINARY_CONDITION__EXPR2, oldExpr2, expr2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExprPackage.BINARY_CONDITION__EXPR2:
				if (resolve) return getExpr2();
				return basicGetExpr2();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExprPackage.BINARY_CONDITION__EXPR2:
				setExpr2((Condition)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExprPackage.BINARY_CONDITION__EXPR2:
				setExpr2((Condition)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExprPackage.BINARY_CONDITION__EXPR2:
				return expr2 != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public EList<Variable> freeVariables(){
		EList<Variable> lst = new BasicEList<Variable>();

		EList<Variable> lst1 = expr.freeVariables();
		for (Variable v : lst1)
			if (!lst.contains(v))
					lst.add(v);
		
		EList<Variable> lst2 = expr2.freeVariables();
		for (Variable v : lst2)
			if (!lst.contains(v))
				lst.add(v);
		return lst;
	}
	
	@Override
	public EList<Variable> variables(){
		EList<Variable> lst = new BasicEList<Variable>();
		
		lst.addAll(expr.variables());
		lst.addAll(expr2.variables());
		return lst;
	}
	
	public EList<Constance> getConstances(){
		EList<Constance> set = new BasicEList<Constance>(expr.getConstances());
		set.addAll(expr2.getConstances());
		return set;
	}
} //BinaryConditionImpl
