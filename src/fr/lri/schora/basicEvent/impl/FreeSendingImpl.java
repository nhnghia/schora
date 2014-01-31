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
 */
package fr.lri.schora.basicEvent.impl;

import fr.lri.schora.basicEvent.BasicEventPackage;
import fr.lri.schora.basicEvent.BoundSending;
import fr.lri.schora.basicEvent.FreeSending;
import fr.lri.schora.expr.Variable;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Free Sending</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FreeSendingImpl extends LocalEventImpl implements FreeSending {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FreeSendingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasicEventPackage.Literals.FREE_SENDING;
	}

	public String toString(){
		StringBuffer result = new StringBuffer(super.toString());
		result.append("!");
		if (variable != null){
			result.append(variable.getName());
		}
		return result.toString() ;
	}
	
	public String toDotFormat(){
		StringBuffer result = new StringBuffer(super.toDotFormat());
		result.append("!");
		if (variable != null){
			result.append(variable.getName());
		}
		return result.toString() ;
	}
	@Override
	public EList<Variable> getFreeVariables() {
		EList<Variable> lst = new BasicEList<Variable>();
		if (variable != null)
			lst.add(variable);
		return lst;
	}
	
	public boolean equals(Object obj){
		if (!(obj instanceof FreeSending))
			return false;
		return super.equals(obj);
	}
} //FreeSendingImpl
