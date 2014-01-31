/**
 */
package fr.lri.schora.basicEvent.impl;

import fr.lri.schora.basicEvent.BasicEventPackage;
import fr.lri.schora.basicEvent.BoundSending;
import fr.lri.schora.basicEvent.Reception;
import fr.lri.schora.expr.Variable;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reception</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ReceptionImpl extends LocalEventImpl implements Reception {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReceptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasicEventPackage.Literals.RECEPTION;
	}

	public EList<Variable> getBoundVariables() {
		EList<Variable> lst =  new BasicEList<Variable>();
		if (variable != null)
			lst.add(variable);
		return lst;
	}
	
	public String toString(){
		StringBuffer result = new StringBuffer(super.toString());
		result.append("?");
		if (variable != null){
			result.append("<");
			result.append(variable.getName());
			result.append(">");
		}
		return result.toString() ;
	}
	
	public String toDotFormat(){
		StringBuffer result = new StringBuffer(super.toDotFormat());
		result.append("?");
		if (variable != null){
			result.append("<");
			result.append(variable.getName());
			result.append(">");
		}
		return result.toString() ;
	}
	
	public boolean equals(Object obj){
		if (!(obj instanceof Reception))
			return false;
		return super.equals(obj);
	}
} //ReceptionImpl
