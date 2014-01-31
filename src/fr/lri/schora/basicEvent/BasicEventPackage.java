/**
 */
package fr.lri.schora.basicEvent;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.lri.schora.basicEvent.BasicEventFactory
 * @model kind="package"
 * @generated
 */
public interface BasicEventPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "basicEvent";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.lri.fr/schora/event";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "be";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasicEventPackage eINSTANCE = fr.lri.schora.basicEvent.impl.BasicEventPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.EventImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 10;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.BasicEventImpl <em>Basic Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.BasicEventImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getBasicEvent()
	 * @generated
	 */
	int BASIC_EVENT = 0;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_EVENT__SENDER = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_EVENT__RECEIVER = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_EVENT__OPERATION_NAME = EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_EVENT__VARIABLE = EVENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Basic Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.GlobalEventImpl <em>Global Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.GlobalEventImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getGlobalEvent()
	 * @generated
	 */
	int GLOBAL_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_EVENT__SENDER = BASIC_EVENT__SENDER;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_EVENT__RECEIVER = BASIC_EVENT__RECEIVER;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_EVENT__OPERATION_NAME = BASIC_EVENT__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_EVENT__VARIABLE = BASIC_EVENT__VARIABLE;

	/**
	 * The number of structural features of the '<em>Global Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_EVENT_FEATURE_COUNT = BASIC_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.FreeInteractionImpl <em>Free Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.FreeInteractionImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getFreeInteraction()
	 * @generated
	 */
	int FREE_INTERACTION = 2;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_INTERACTION__SENDER = GLOBAL_EVENT__SENDER;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_INTERACTION__RECEIVER = GLOBAL_EVENT__RECEIVER;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_INTERACTION__OPERATION_NAME = GLOBAL_EVENT__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_INTERACTION__VARIABLE = GLOBAL_EVENT__VARIABLE;

	/**
	 * The number of structural features of the '<em>Free Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_INTERACTION_FEATURE_COUNT = GLOBAL_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.BoundInteractionImpl <em>Bound Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.BoundInteractionImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getBoundInteraction()
	 * @generated
	 */
	int BOUND_INTERACTION = 3;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_INTERACTION__SENDER = GLOBAL_EVENT__SENDER;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_INTERACTION__RECEIVER = GLOBAL_EVENT__RECEIVER;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_INTERACTION__OPERATION_NAME = GLOBAL_EVENT__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_INTERACTION__VARIABLE = GLOBAL_EVENT__VARIABLE;

	/**
	 * The number of structural features of the '<em>Bound Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_INTERACTION_FEATURE_COUNT = GLOBAL_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.LocalEventImpl <em>Local Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.LocalEventImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getLocalEvent()
	 * @generated
	 */
	int LOCAL_EVENT = 4;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_EVENT__SENDER = BASIC_EVENT__SENDER;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_EVENT__RECEIVER = BASIC_EVENT__RECEIVER;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_EVENT__OPERATION_NAME = BASIC_EVENT__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_EVENT__VARIABLE = BASIC_EVENT__VARIABLE;

	/**
	 * The number of structural features of the '<em>Local Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_EVENT_FEATURE_COUNT = BASIC_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.ReceptionImpl <em>Reception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.ReceptionImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getReception()
	 * @generated
	 */
	int RECEPTION = 5;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEPTION__SENDER = LOCAL_EVENT__SENDER;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEPTION__RECEIVER = LOCAL_EVENT__RECEIVER;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEPTION__OPERATION_NAME = LOCAL_EVENT__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEPTION__VARIABLE = LOCAL_EVENT__VARIABLE;

	/**
	 * The number of structural features of the '<em>Reception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEPTION_FEATURE_COUNT = LOCAL_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.FreeSendingImpl <em>Free Sending</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.FreeSendingImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getFreeSending()
	 * @generated
	 */
	int FREE_SENDING = 6;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_SENDING__SENDER = LOCAL_EVENT__SENDER;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_SENDING__RECEIVER = LOCAL_EVENT__RECEIVER;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_SENDING__OPERATION_NAME = LOCAL_EVENT__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_SENDING__VARIABLE = LOCAL_EVENT__VARIABLE;

	/**
	 * The number of structural features of the '<em>Free Sending</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_SENDING_FEATURE_COUNT = LOCAL_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.BoundSendingImpl <em>Bound Sending</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.BoundSendingImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getBoundSending()
	 * @generated
	 */
	int BOUND_SENDING = 7;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_SENDING__SENDER = LOCAL_EVENT__SENDER;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_SENDING__RECEIVER = LOCAL_EVENT__RECEIVER;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_SENDING__OPERATION_NAME = LOCAL_EVENT__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_SENDING__VARIABLE = LOCAL_EVENT__VARIABLE;

	/**
	 * The number of structural features of the '<em>Bound Sending</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_SENDING_FEATURE_COUNT = LOCAL_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.FreeEventImpl <em>Free Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.FreeEventImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getFreeEvent()
	 * @generated
	 */
	int FREE_EVENT = 11;

	/**
	 * The number of structural features of the '<em>Free Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.TauImpl <em>Tau</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.TauImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getTau()
	 * @generated
	 */
	int TAU = 8;

	/**
	 * The number of structural features of the '<em>Tau</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAU_FEATURE_COUNT = FREE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.TickImpl <em>Tick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.TickImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getTick()
	 * @generated
	 */
	int TICK = 9;

	/**
	 * The number of structural features of the '<em>Tick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TICK_FEATURE_COUNT = FREE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.basicEvent.impl.BoundEventImpl <em>Bound Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.basicEvent.impl.BoundEventImpl
	 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getBoundEvent()
	 * @generated
	 */
	int BOUND_EVENT = 12;

	/**
	 * The number of structural features of the '<em>Bound Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.BasicEvent <em>Basic Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Event</em>'.
	 * @see fr.lri.schora.basicEvent.BasicEvent
	 * @generated
	 */
	EClass getBasicEvent();

	/**
	 * Returns the meta object for the attribute '{@link fr.lri.schora.basicEvent.BasicEvent#getSender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sender</em>'.
	 * @see fr.lri.schora.basicEvent.BasicEvent#getSender()
	 * @see #getBasicEvent()
	 * @generated
	 */
	EAttribute getBasicEvent_Sender();

	/**
	 * Returns the meta object for the attribute '{@link fr.lri.schora.basicEvent.BasicEvent#getReceiver <em>Receiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Receiver</em>'.
	 * @see fr.lri.schora.basicEvent.BasicEvent#getReceiver()
	 * @see #getBasicEvent()
	 * @generated
	 */
	EAttribute getBasicEvent_Receiver();

	/**
	 * Returns the meta object for the attribute '{@link fr.lri.schora.basicEvent.BasicEvent#getOperationName <em>Operation Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation Name</em>'.
	 * @see fr.lri.schora.basicEvent.BasicEvent#getOperationName()
	 * @see #getBasicEvent()
	 * @generated
	 */
	EAttribute getBasicEvent_OperationName();

	/**
	 * Returns the meta object for the reference '{@link fr.lri.schora.basicEvent.BasicEvent#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see fr.lri.schora.basicEvent.BasicEvent#getVariable()
	 * @see #getBasicEvent()
	 * @generated
	 */
	EReference getBasicEvent_Variable();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.GlobalEvent <em>Global Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Event</em>'.
	 * @see fr.lri.schora.basicEvent.GlobalEvent
	 * @generated
	 */
	EClass getGlobalEvent();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.FreeInteraction <em>Free Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Free Interaction</em>'.
	 * @see fr.lri.schora.basicEvent.FreeInteraction
	 * @generated
	 */
	EClass getFreeInteraction();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.BoundInteraction <em>Bound Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Interaction</em>'.
	 * @see fr.lri.schora.basicEvent.BoundInteraction
	 * @generated
	 */
	EClass getBoundInteraction();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.LocalEvent <em>Local Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Event</em>'.
	 * @see fr.lri.schora.basicEvent.LocalEvent
	 * @generated
	 */
	EClass getLocalEvent();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.Reception <em>Reception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reception</em>'.
	 * @see fr.lri.schora.basicEvent.Reception
	 * @generated
	 */
	EClass getReception();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.FreeSending <em>Free Sending</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Free Sending</em>'.
	 * @see fr.lri.schora.basicEvent.FreeSending
	 * @generated
	 */
	EClass getFreeSending();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.BoundSending <em>Bound Sending</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Sending</em>'.
	 * @see fr.lri.schora.basicEvent.BoundSending
	 * @generated
	 */
	EClass getBoundSending();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.Tau <em>Tau</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tau</em>'.
	 * @see fr.lri.schora.basicEvent.Tau
	 * @generated
	 */
	EClass getTau();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.Tick <em>Tick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tick</em>'.
	 * @see fr.lri.schora.basicEvent.Tick
	 * @generated
	 */
	EClass getTick();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see fr.lri.schora.basicEvent.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.FreeEvent <em>Free Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Free Event</em>'.
	 * @see fr.lri.schora.basicEvent.FreeEvent
	 * @generated
	 */
	EClass getFreeEvent();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.basicEvent.BoundEvent <em>Bound Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Event</em>'.
	 * @see fr.lri.schora.basicEvent.BoundEvent
	 * @generated
	 */
	EClass getBoundEvent();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BasicEventFactory getBasicEventFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.BasicEventImpl <em>Basic Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.BasicEventImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getBasicEvent()
		 * @generated
		 */
		EClass BASIC_EVENT = eINSTANCE.getBasicEvent();

		/**
		 * The meta object literal for the '<em><b>Sender</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_EVENT__SENDER = eINSTANCE.getBasicEvent_Sender();

		/**
		 * The meta object literal for the '<em><b>Receiver</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_EVENT__RECEIVER = eINSTANCE.getBasicEvent_Receiver();

		/**
		 * The meta object literal for the '<em><b>Operation Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_EVENT__OPERATION_NAME = eINSTANCE.getBasicEvent_OperationName();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_EVENT__VARIABLE = eINSTANCE.getBasicEvent_Variable();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.GlobalEventImpl <em>Global Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.GlobalEventImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getGlobalEvent()
		 * @generated
		 */
		EClass GLOBAL_EVENT = eINSTANCE.getGlobalEvent();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.FreeInteractionImpl <em>Free Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.FreeInteractionImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getFreeInteraction()
		 * @generated
		 */
		EClass FREE_INTERACTION = eINSTANCE.getFreeInteraction();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.BoundInteractionImpl <em>Bound Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.BoundInteractionImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getBoundInteraction()
		 * @generated
		 */
		EClass BOUND_INTERACTION = eINSTANCE.getBoundInteraction();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.LocalEventImpl <em>Local Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.LocalEventImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getLocalEvent()
		 * @generated
		 */
		EClass LOCAL_EVENT = eINSTANCE.getLocalEvent();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.ReceptionImpl <em>Reception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.ReceptionImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getReception()
		 * @generated
		 */
		EClass RECEPTION = eINSTANCE.getReception();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.FreeSendingImpl <em>Free Sending</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.FreeSendingImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getFreeSending()
		 * @generated
		 */
		EClass FREE_SENDING = eINSTANCE.getFreeSending();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.BoundSendingImpl <em>Bound Sending</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.BoundSendingImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getBoundSending()
		 * @generated
		 */
		EClass BOUND_SENDING = eINSTANCE.getBoundSending();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.TauImpl <em>Tau</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.TauImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getTau()
		 * @generated
		 */
		EClass TAU = eINSTANCE.getTau();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.TickImpl <em>Tick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.TickImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getTick()
		 * @generated
		 */
		EClass TICK = eINSTANCE.getTick();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.EventImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.FreeEventImpl <em>Free Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.FreeEventImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getFreeEvent()
		 * @generated
		 */
		EClass FREE_EVENT = eINSTANCE.getFreeEvent();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.basicEvent.impl.BoundEventImpl <em>Bound Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.basicEvent.impl.BoundEventImpl
		 * @see fr.lri.schora.basicEvent.impl.BasicEventPackageImpl#getBoundEvent()
		 * @generated
		 */
		EClass BOUND_EVENT = eINSTANCE.getBoundEvent();

	}

} //BasicEventPackage
