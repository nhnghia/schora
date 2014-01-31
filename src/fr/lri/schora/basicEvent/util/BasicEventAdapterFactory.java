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
package fr.lri.schora.basicEvent.util;

import fr.lri.schora.basicEvent.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.lri.schora.basicEvent.BasicEventPackage
 * @generated
 */
public class BasicEventAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BasicEventPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicEventAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BasicEventPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicEventSwitch<Adapter> modelSwitch =
		new BasicEventSwitch<Adapter>() {
			@Override
			public Adapter caseBasicEvent(BasicEvent object) {
				return createBasicEventAdapter();
			}
			@Override
			public Adapter caseGlobalEvent(GlobalEvent object) {
				return createGlobalEventAdapter();
			}
			@Override
			public Adapter caseFreeInteraction(FreeInteraction object) {
				return createFreeInteractionAdapter();
			}
			@Override
			public Adapter caseBoundInteraction(BoundInteraction object) {
				return createBoundInteractionAdapter();
			}
			@Override
			public Adapter caseLocalEvent(LocalEvent object) {
				return createLocalEventAdapter();
			}
			@Override
			public Adapter caseReception(Reception object) {
				return createReceptionAdapter();
			}
			@Override
			public Adapter caseFreeSending(FreeSending object) {
				return createFreeSendingAdapter();
			}
			@Override
			public Adapter caseBoundSending(BoundSending object) {
				return createBoundSendingAdapter();
			}
			@Override
			public Adapter caseTau(Tau object) {
				return createTauAdapter();
			}
			@Override
			public Adapter caseTick(Tick object) {
				return createTickAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseFreeEvent(FreeEvent object) {
				return createFreeEventAdapter();
			}
			@Override
			public Adapter caseBoundEvent(BoundEvent object) {
				return createBoundEventAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.BasicEvent <em>Basic Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.BasicEvent
	 * @generated
	 */
	public Adapter createBasicEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.GlobalEvent <em>Global Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.GlobalEvent
	 * @generated
	 */
	public Adapter createGlobalEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.FreeInteraction <em>Free Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.FreeInteraction
	 * @generated
	 */
	public Adapter createFreeInteractionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.BoundInteraction <em>Bound Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.BoundInteraction
	 * @generated
	 */
	public Adapter createBoundInteractionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.LocalEvent <em>Local Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.LocalEvent
	 * @generated
	 */
	public Adapter createLocalEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.Reception <em>Reception</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.Reception
	 * @generated
	 */
	public Adapter createReceptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.FreeSending <em>Free Sending</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.FreeSending
	 * @generated
	 */
	public Adapter createFreeSendingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.BoundSending <em>Bound Sending</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.BoundSending
	 * @generated
	 */
	public Adapter createBoundSendingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.Tau <em>Tau</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.Tau
	 * @generated
	 */
	public Adapter createTauAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.Tick <em>Tick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.Tick
	 * @generated
	 */
	public Adapter createTickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.FreeEvent <em>Free Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.FreeEvent
	 * @generated
	 */
	public Adapter createFreeEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lri.schora.basicEvent.BoundEvent <em>Bound Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lri.schora.basicEvent.BoundEvent
	 * @generated
	 */
	public Adapter createBoundEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //BasicEventAdapterFactory
