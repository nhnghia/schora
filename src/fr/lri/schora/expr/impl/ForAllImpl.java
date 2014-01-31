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

import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.ExprPackage;
import fr.lri.schora.expr.ForAll;
import fr.lri.schora.expr.Variable;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For All</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.lri.schora.expr.impl.ForAllImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForAllImpl extends UnaryConditionImpl implements ForAll {
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
	protected ForAllImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExprPackage.Literals.FOR_ALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectResolvingEList<Variable>(Variable.class, this, ExprPackage.FOR_ALL__VARIABLES);
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
			case ExprPackage.FOR_ALL__VARIABLES:
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
			case ExprPackage.FOR_ALL__VARIABLES:
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
			case ExprPackage.FOR_ALL__VARIABLES:
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
			case ExprPackage.FOR_ALL__VARIABLES:
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
			str = "(" + str.substring(2) + ")";
		
		return String.format("FORALL %s (%s)", str, expr.toString());
	}
	
	@Override
	public String toLaTEX(){
		String str = "";
		for (Variable v : variables)
			str += ", " + v.toString();
		if (str.length() > 0)
			str = "(" + str.substring(2) + ")";
		
		return String.format("\\forall %s (%s)", str, expr.toLaTEX());
	}
	
	@Override
	public String toZ3Format(){
		String str = "";
		for (Variable v : variables)
			str += "(" + v.toString() + " Int)";
		
		return String.format("(forall (%s) %s)", str, expr.toZ3Format());
	}
	
	@Override
	public EList<Variable> freeVariables(){
		EList<Variable> lst = expr.freeVariables();
		lst.addAll(variables);
		return lst;
	}
	
	@Override
	public EList<Variable> variables(){
		EList<Variable> lst = expr.variables();
		lst.addAll(variables);
		return lst;
	}
	
	public ForAll clone(){
		ForAll f = ExprFactory.eINSTANCE.createForAll();
		f.setExpr(getExpr().clone());
		EList<Variable> lst = new BasicEList<Variable>();
		for (Variable v : variables)
			lst.add(v.clone());
		f.variables().addAll(lst);
		return f;
	}
} //ForAllImpl
