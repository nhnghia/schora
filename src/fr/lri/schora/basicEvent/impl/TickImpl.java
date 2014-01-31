/**
 */
package fr.lri.schora.basicEvent.impl;

import fr.lri.schora.basicEvent.BasicEventPackage;
import fr.lri.schora.basicEvent.BoundSending;
import fr.lri.schora.basicEvent.Tick;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TickImpl extends FreeEventImpl implements Tick {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasicEventPackage.Literals.TICK;
	}

	public String toDotFormat(){
		return "&#x2713;";	//checkmark unicode
	}
	
	public String toString(){
		return "tick;";	//checkmark unicode
	}
	
	public boolean equals(Object obj){
		return (obj instanceof Tick);
	}
} //TickImpl
