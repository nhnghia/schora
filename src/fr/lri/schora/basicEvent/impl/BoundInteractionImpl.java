/**
 */
package fr.lri.schora.basicEvent.impl;

import fr.lri.schora.basicEvent.BasicEventPackage;
import fr.lri.schora.basicEvent.BoundEvent;
import fr.lri.schora.basicEvent.BoundInteraction;
import fr.lri.schora.basicEvent.BoundSending;
import fr.lri.schora.expr.Variable;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bound Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BoundInteractionImpl extends GlobalEventImpl implements BoundInteraction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundInteractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasicEventPackage.Literals.BOUND_INTERACTION;
	}

	public String toString(){
		StringBuffer result = new StringBuffer(super.toString());
		if (variable != null){
			result.append(".<");
			result.append(variable.getName());
			result.append(">");
		}
		return result.toString() ;
	}
	
	public String toDotFormat(){
		StringBuffer result = new StringBuffer(super.toDotFormat());
		if (variable != null){
			result.append(".<");
			result.append(variable.getName());
			result.append(">");
		}
		return result.toString() ;
	}
	
	public EList<Variable> getBoundVariables() {
		EList<Variable> lst =  new BasicEList<Variable>();
		if (variable != null)
			lst.add(variable);
		return lst;
	}
	
	public boolean equals(Object obj){
		if (!(obj instanceof BoundInteraction))
			return false;
		return super.equals(obj);
	}
} //BoundInteractionImpl
