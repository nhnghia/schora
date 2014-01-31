/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lri.schora.expr.impl;

import fr.lri.schora.expr.Constance;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.ExprPackage;
import fr.lri.schora.expr.Function;
import fr.lri.schora.expr.Variable;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.lri.schora.expr.impl.FunctionImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.lri.schora.expr.impl.FunctionImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionImpl extends ExpressionImpl implements Function {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExprPackage.Literals.FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.FUNCTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectResolvingEList<Variable>(Variable.class, this, ExprPackage.FUNCTION__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExprPackage.FUNCTION__NAME:
				return getName();
			case ExprPackage.FUNCTION__VARIABLES:
				return getVariables();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExprPackage.FUNCTION__NAME:
				setName((String)newValue);
				return;
			case ExprPackage.FUNCTION__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends Variable>)newValue);
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
			case ExprPackage.FUNCTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExprPackage.FUNCTION__VARIABLES:
				getVariables().clear();
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
			case ExprPackage.FUNCTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExprPackage.FUNCTION__VARIABLES:
				return variables != null && !variables.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString(){
		String str = "";
		for (Variable v : variables)
			str += ", " + v.toString();
		if (str.length() > 0)
			str = str.substring(2);
		
		return String.format("%s(%s)", name, str);
	}
	
	@Override
	public String toLaTEX(){
		String str = "";
		for (Variable v : variables)
			str += ", " + v.toLaTEX();
		if (str.length() > 0)
			str = str.substring(2);
		
		return String.format("%s(%s)", name, str);
	}
	
	@Override
	public String toZ3Format(){
		if (name.equalsIgnoreCase("number"))
			return variables.get(0).toZ3Format();
		
		String str = "";
		for (Variable v : variables)
			str += " " + v.toString();
		if (str.length() > 0)
			return String.format("(%s %s)", name, str);
		else
			return name;
	}

	@Override
	public EList<Variable> freeVariables(){
		EList<Variable> lst = new BasicEList<Variable>();
		for (Variable v : variables)
				lst.add(v);
		return lst;
	}
	
	@Override
	public EList<Variable> variables(){
		EList<Variable> lst = new BasicEList<Variable>();
		for (Variable v : variables)
				lst.add(v);
		return lst;
	}
	
	public Function clone(){
		Function fun = ExprFactory.eINSTANCE.createFunction();
		fun.setName(new String(name));
		EList<Variable> lst = new BasicEList<Variable>();
		for (Variable v : variables)
			lst.add(v.clone());
		fun.getVariables().addAll(lst);
		return fun;
	}
	
	public EList<Constance> getConstances(){
		return new BasicEList<Constance>();
	}
} //FunctionImpl
