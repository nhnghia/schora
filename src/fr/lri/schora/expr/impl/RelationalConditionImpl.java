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

import java.util.Hashtable;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import fr.lri.schora.expr.BTrue;
import fr.lri.schora.expr.Condition;
import fr.lri.schora.expr.Constance;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.ExprPackage;
import fr.lri.schora.expr.Expression;
import fr.lri.schora.expr.Function;
import fr.lri.schora.expr.RelationalCondition;
import fr.lri.schora.expr.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relational Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.lri.schora.expr.impl.RelationalConditionImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link fr.lri.schora.expr.impl.RelationalConditionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link fr.lri.schora.expr.impl.RelationalConditionImpl#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationalConditionImpl extends ConditionImpl implements RelationalCondition {
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
	 * The cached value of the '{@link #getRight() <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected Expression right;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationalConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExprPackage.Literals.RELATIONAL_CONDITION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExprPackage.RELATIONAL_CONDITION__LEFT, oldLeft, left));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.RELATIONAL_CONDITION__LEFT, oldLeft, left));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.RELATIONAL_CONDITION__OP, oldOp, op));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExprPackage.RELATIONAL_CONDITION__RIGHT, oldRight, right));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.RELATIONAL_CONDITION__RIGHT, oldRight, right));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExprPackage.RELATIONAL_CONDITION__LEFT:
				if (resolve) return getLeft();
				return basicGetLeft();
			case ExprPackage.RELATIONAL_CONDITION__OP:
				return getOp();
			case ExprPackage.RELATIONAL_CONDITION__RIGHT:
				if (resolve) return getRight();
				return basicGetRight();
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
			case ExprPackage.RELATIONAL_CONDITION__LEFT:
				setLeft((Expression)newValue);
				return;
			case ExprPackage.RELATIONAL_CONDITION__OP:
				setOp((String)newValue);
				return;
			case ExprPackage.RELATIONAL_CONDITION__RIGHT:
				setRight((Expression)newValue);
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
			case ExprPackage.RELATIONAL_CONDITION__LEFT:
				setLeft((Expression)null);
				return;
			case ExprPackage.RELATIONAL_CONDITION__OP:
				setOp(OP_EDEFAULT);
				return;
			case ExprPackage.RELATIONAL_CONDITION__RIGHT:
				setRight((Expression)null);
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
			case ExprPackage.RELATIONAL_CONDITION__LEFT:
				return left != null;
			case ExprPackage.RELATIONAL_CONDITION__OP:
				return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
			case ExprPackage.RELATIONAL_CONDITION__RIGHT:
				return right != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString(){
		if (right instanceof BTrue && left instanceof Function && op.equals("="))
			return String.format("%s", left.toString());
		return String.format("%s %s %s", left.toString(), op, right.toString());
	}
	
	@Override
	public String toLaTEX(){
		if (right instanceof BTrue && left instanceof Function && op.equals("="))
			return String.format("%s", left.toLaTEX());
		
		String str = op;
		if (op.equals(">="))
			str = "\\geq";
		else if (op.equals("!="))
			str = "\\neq";
		else if (op.equals("<="))
			str = "\\leq";
		
		return String.format("%s %s %s", left.toLaTEX(), str, right.toLaTEX());
	}
	
	@Override
	public String toZ3Format(){
		if (op.equals("!=")){
			return String.format("(not (= %s %s))", left.toZ3Format(), right.toZ3Format());
		}
		if (right instanceof BTrue && left instanceof Function && op.equals("="))
			return String.format("%s", left.toZ3Format());
		String str = op;
		
		Hashtable<String, String> xpath2Z3 = new Hashtable<String, String>();
		xpath2Z3.put("eq", "=");
		xpath2Z3.put("gt", ">");
		xpath2Z3.put("ge", ">=");
		xpath2Z3.put("lt", "<");
		xpath2Z3.put("le", "<=");
		xpath2Z3.put("==", "=");
		if (xpath2Z3.containsKey(str))
			str = xpath2Z3.get(str);
		
		return String.format("(%s %s %s)", str, left.toZ3Format(), right.toZ3Format());
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
	public EList<Variable> variables(){
		EList<Variable> lst = new BasicEList<Variable>();
		
		lst.addAll(left.variables());
		lst.addAll(right.variables());
		return lst;
	}
	
	
	public Condition clone(){
		RelationalCondition con = ExprFactory.eINSTANCE.createRelationalCondition();
		con.setLeft(left.clone());
		con.setRight(right.clone());
		con.setOp(new String(op));
		return con;
	}
	
	public EList<Constance> getConstances(){
		EList<Constance> set = new BasicEList<Constance>(left.getConstances());
		set.addAll(right.getConstances());
		return set;
	}
} //RelationalConditionImpl
