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
import java.util.List;
import java.util.Set;

import fr.lri.schora.expr.BinaryExpression;
import fr.lri.schora.expr.Constance;
import fr.lri.schora.expr.ExprPackage;
import fr.lri.schora.expr.Expression;
import fr.lri.schora.expr.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.lri.schora.expr.impl.BinaryExpressionImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link fr.lri.schora.expr.impl.BinaryExpressionImpl#getRight <em>Right</em>}</li>
 *   <li>{@link fr.lri.schora.expr.impl.BinaryExpressionImpl#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BinaryExpressionImpl extends ExpressionImpl implements BinaryExpression {
	/**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected Expression left;

	/**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected Expression right;

	/**
	 * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected static final String OP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected String op = OP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExprPackage.Literals.BINARY_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLeft() {
		if (left != null && left.eIsProxy()) {
			InternalEObject oldLeft = (InternalEObject)left;
			left = (Expression)eResolveProxy(oldLeft);
			if (left != oldLeft) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExprPackage.BINARY_EXPRESSION__LEFT, oldLeft, left));
			}
		}
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetLeft() {
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft(Expression newLeft) {
		Expression oldLeft = left;
		left = newLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.BINARY_EXPRESSION__LEFT, oldLeft, left));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRight() {
		if (right != null && right.eIsProxy()) {
			InternalEObject oldRight = (InternalEObject)right;
			right = (Expression)eResolveProxy(oldRight);
			if (right != oldRight) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExprPackage.BINARY_EXPRESSION__RIGHT, oldRight, right));
			}
		}
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetRight() {
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight(Expression newRight) {
		Expression oldRight = right;
		right = newRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.BINARY_EXPRESSION__RIGHT, oldRight, right));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOp() {
		return op;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp(String newOp) {
		String oldOp = op;
		op = newOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.BINARY_EXPRESSION__OP, oldOp, op));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExprPackage.BINARY_EXPRESSION__LEFT:
				if (resolve) return getLeft();
				return basicGetLeft();
			case ExprPackage.BINARY_EXPRESSION__RIGHT:
				if (resolve) return getRight();
				return basicGetRight();
			case ExprPackage.BINARY_EXPRESSION__OP:
				return getOp();
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
			case ExprPackage.BINARY_EXPRESSION__LEFT:
				setLeft((Expression)newValue);
				return;
			case ExprPackage.BINARY_EXPRESSION__RIGHT:
				setRight((Expression)newValue);
				return;
			case ExprPackage.BINARY_EXPRESSION__OP:
				setOp((String)newValue);
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
			case ExprPackage.BINARY_EXPRESSION__LEFT:
				setLeft((Expression)null);
				return;
			case ExprPackage.BINARY_EXPRESSION__RIGHT:
				setRight((Expression)null);
				return;
			case ExprPackage.BINARY_EXPRESSION__OP:
				setOp(OP_EDEFAULT);
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
			case ExprPackage.BINARY_EXPRESSION__LEFT:
				return left != null;
			case ExprPackage.BINARY_EXPRESSION__RIGHT:
				return right != null;
			case ExprPackage.BINARY_EXPRESSION__OP:
				return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NHN-generated
	 */
	@Override
	public String toString() {
		return String.format("%s %s %s",
				left.toString(),
				op,
				right.toString());
	}

	@Override
	public EList<Variable> freeVariables(){
		EList<Variable> lst = new BasicEList<Variable>();

		EList<Variable> lst1 = left.freeVariables();
		for (Variable v : lst1)
			if (!lst.contains(v))
					lst.add(v);
		
		EList<Variable> lst2 = right.freeVariables();
		for (Variable v : lst2)
			if (!lst.contains(v))
				lst.add(v);
		return lst;
	}
	
	@Override
	public String toZ3Format(){
		return String.format("(%s %s %s)",
				op,
				left.toZ3Format(),
				right.toZ3Format());
	}
	
	@Override
	public EList<Variable> variables(){
		EList<Variable> lst = new BasicEList<Variable>();
		
		lst.addAll(left.variables());
		lst.addAll(right.variables());
		return lst;
	}
	
	public EList<Constance> getConstances(){
		EList<Constance> set = new BasicEList<Constance>(left.getConstances());
		set.addAll(right.getConstances());
		return set;
	}
} //BinaryExpressionImpl
