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

import fr.lri.schora.basicEvent.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BasicEventFactoryImpl extends EFactoryImpl implements BasicEventFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BasicEventFactory init() {
		try {
			BasicEventFactory theBasicEventFactory = (BasicEventFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.lri.fr/schora/event"); 
			if (theBasicEventFactory != null) {
				return theBasicEventFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BasicEventFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicEventFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BasicEventPackage.FREE_INTERACTION: return createFreeInteraction();
			case BasicEventPackage.BOUND_INTERACTION: return createBoundInteraction();
			case BasicEventPackage.RECEPTION: return createReception();
			case BasicEventPackage.FREE_SENDING: return createFreeSending();
			case BasicEventPackage.BOUND_SENDING: return createBoundSending();
			case BasicEventPackage.TAU: return createTau();
			case BasicEventPackage.TICK: return createTick();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FreeInteraction createFreeInteraction() {
		FreeInteractionImpl freeInteraction = new FreeInteractionImpl();
		return freeInteraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundInteraction createBoundInteraction() {
		BoundInteractionImpl boundInteraction = new BoundInteractionImpl();
		return boundInteraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reception createReception() {
		ReceptionImpl reception = new ReceptionImpl();
		return reception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FreeSending createFreeSending() {
		FreeSendingImpl freeSending = new FreeSendingImpl();
		return freeSending;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundSending createBoundSending() {
		BoundSendingImpl boundSending = new BoundSendingImpl();
		return boundSending;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tau createTau() {
		TauImpl tau = new TauImpl();
		return tau;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tick createTick() {
		TickImpl tick = new TickImpl();
		return tick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicEventPackage getBasicEventPackage() {
		return (BasicEventPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BasicEventPackage getPackage() {
		return BasicEventPackage.eINSTANCE;
	}

} //BasicEventFactoryImpl
