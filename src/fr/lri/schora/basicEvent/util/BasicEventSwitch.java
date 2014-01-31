/**
 */
package fr.lri.schora.basicEvent.util;

import fr.lri.schora.basicEvent.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see fr.lri.schora.basicEvent.BasicEventPackage
 * @generated
 */
public class BasicEventSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BasicEventPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicEventSwitch() {
		if (modelPackage == null) {
			modelPackage = BasicEventPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BasicEventPackage.BASIC_EVENT: {
				BasicEvent basicEvent = (BasicEvent)theEObject;
				T result = caseBasicEvent(basicEvent);
				if (result == null) result = caseEvent(basicEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasicEventPackage.GLOBAL_EVENT: {
				GlobalEvent globalEvent = (GlobalEvent)theEObject;
				T result = caseGlobalEvent(globalEvent);
				if (result == null) result = caseBasicEvent(globalEvent);
				if (result == null) result = caseEvent(globalEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasicEventPackage.FREE_INTERACTION: {
				FreeInteraction freeInteraction = (FreeInteraction)theEObject;
				T result = caseFreeInteraction(freeInteraction);
				if (result == null) result = caseGlobalEvent(freeInteraction);
				if (result == null) result = caseFreeEvent(freeInteraction);
				if (result == null) result = caseBasicEvent(freeInteraction);
				if (result == null) result = caseEvent(freeInteraction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasicEventPackage.BOUND_INTERACTION: {
				BoundInteraction boundInteraction = (BoundInteraction)theEObject;
				T result = caseBoundInteraction(boundInteraction);
				if (result == null) result = caseGlobalEvent(boundInteraction);
				if (result == null) result = caseBoundEvent(boundInteraction);
				if (result == null) result = caseBasicEvent(boundInteraction);
				if (result == null) result = caseEvent(boundInteraction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasicEventPackage.LOCAL_EVENT: {
				LocalEvent localEvent = (LocalEvent)theEObject;
				T result = caseLocalEvent(localEvent);
				if (result == null) result = caseBasicEvent(localEvent);
				if (result == null) result = caseEvent(localEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasicEventPackage.RECEPTION: {
				Reception reception = (Reception)theEObject;
				T result = caseReception(reception);
				if (result == null) result = caseLocalEvent(reception);
				if (result == null) result = caseBoundEvent(reception);
				if (result == null) result = caseBasicEvent(reception);
				if (result == null) result = caseEvent(reception);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasicEventPackage.FREE_SENDING: {
				FreeSending freeSending = (FreeSending)theEObject;
				T result = caseFreeSending(freeSending);
				if (result == null) result = caseLocalEvent(freeSending);
				if (result == null) result = caseFreeEvent(freeSending);
				if (result == null) result = caseBasicEvent(freeSending);
				if (result == null) result = caseEvent(freeSending);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasicEventPackage.BOUND_SENDING: {
				BoundSending boundSending = (BoundSending)theEObject;
				T result = caseBoundSending(boundSending);
				if (result == null) result = caseLocalEvent(boundSending);
				if (result == null) result = caseBoundEvent(boundSending);
				if (result == null) result = caseBasicEvent(boundSending);
				if (result == null) result = caseEvent(boundSending);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasicEventPackage.TAU: {
				Tau tau = (Tau)theEObject;
				T result = caseTau(tau);
				if (result == null) result = caseFreeEvent(tau);
				if (result == null) result = caseEvent(tau);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasicEventPackage.TICK: {
				Tick tick = (Tick)theEObject;
				T result = caseTick(tick);
				if (result == null) result = caseFreeEvent(tick);
				if (result == null) result = caseEvent(tick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasicEventPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasicEventPackage.FREE_EVENT: {
				FreeEvent freeEvent = (FreeEvent)theEObject;
				T result = caseFreeEvent(freeEvent);
				if (result == null) result = caseEvent(freeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasicEventPackage.BOUND_EVENT: {
				BoundEvent boundEvent = (BoundEvent)theEObject;
				T result = caseBoundEvent(boundEvent);
				if (result == null) result = caseEvent(boundEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicEvent(BasicEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalEvent(GlobalEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Free Interaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Free Interaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFreeInteraction(FreeInteraction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Interaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Interaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundInteraction(BoundInteraction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalEvent(LocalEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reception</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reception</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReception(Reception object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Free Sending</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Free Sending</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFreeSending(FreeSending object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Sending</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Sending</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundSending(BoundSending object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tau</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tau</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTau(Tau object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTick(Tick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Free Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Free Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFreeEvent(FreeEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundEvent(BoundEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //BasicEventSwitch
