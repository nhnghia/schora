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


import fr.lri.schora.basicEvent.BasicEvent;
import fr.lri.schora.basicEvent.BasicEventFactory;
import fr.lri.schora.basicEvent.BasicEventPackage;
import fr.lri.schora.basicEvent.BoundEvent;
import fr.lri.schora.basicEvent.BoundInteraction;
import fr.lri.schora.basicEvent.BoundSending;
import fr.lri.schora.basicEvent.Event;
import fr.lri.schora.basicEvent.FreeEvent;
import fr.lri.schora.basicEvent.FreeInteraction;
import fr.lri.schora.basicEvent.FreeSending;
import fr.lri.schora.basicEvent.GlobalEvent;
import fr.lri.schora.basicEvent.LocalEvent;
import fr.lri.schora.basicEvent.Reception;
import fr.lri.schora.basicEvent.Tau;
import fr.lri.schora.basicEvent.Tick;
import fr.lri.schora.expr.ExprPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BasicEventPackageImpl extends EPackageImpl implements BasicEventPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass freeInteractionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundInteractionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass receptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass freeSendingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundSendingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tauEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass freeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundEventEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see fr.lri.schora.basicEvent.BasicEventPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BasicEventPackageImpl() {
		super(eNS_URI, BasicEventFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link BasicEventPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BasicEventPackage init() {
		if (isInited) return (BasicEventPackage)EPackage.Registry.INSTANCE.getEPackage(BasicEventPackage.eNS_URI);

		// Obtain or create and register package
		BasicEventPackageImpl theBasicEventPackage = (BasicEventPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BasicEventPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BasicEventPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExprPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBasicEventPackage.createPackageContents();

		// Initialize created meta-data
		theBasicEventPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBasicEventPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BasicEventPackage.eNS_URI, theBasicEventPackage);
		return theBasicEventPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicEvent() {
		return basicEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicEvent_Sender() {
		return (EAttribute)basicEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicEvent_Receiver() {
		return (EAttribute)basicEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicEvent_OperationName() {
		return (EAttribute)basicEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicEvent_Variable() {
		return (EReference)basicEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalEvent() {
		return globalEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFreeInteraction() {
		return freeInteractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundInteraction() {
		return boundInteractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalEvent() {
		return localEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReception() {
		return receptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFreeSending() {
		return freeSendingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundSending() {
		return boundSendingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTau() {
		return tauEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTick() {
		return tickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFreeEvent() {
		return freeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundEvent() {
		return boundEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicEventFactory getBasicEventFactory() {
		return (BasicEventFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		basicEventEClass = createEClass(BASIC_EVENT);
		createEAttribute(basicEventEClass, BASIC_EVENT__SENDER);
		createEAttribute(basicEventEClass, BASIC_EVENT__RECEIVER);
		createEAttribute(basicEventEClass, BASIC_EVENT__OPERATION_NAME);
		createEReference(basicEventEClass, BASIC_EVENT__VARIABLE);

		globalEventEClass = createEClass(GLOBAL_EVENT);

		freeInteractionEClass = createEClass(FREE_INTERACTION);

		boundInteractionEClass = createEClass(BOUND_INTERACTION);

		localEventEClass = createEClass(LOCAL_EVENT);

		receptionEClass = createEClass(RECEPTION);

		freeSendingEClass = createEClass(FREE_SENDING);

		boundSendingEClass = createEClass(BOUND_SENDING);

		tauEClass = createEClass(TAU);

		tickEClass = createEClass(TICK);

		eventEClass = createEClass(EVENT);

		freeEventEClass = createEClass(FREE_EVENT);

		boundEventEClass = createEClass(BOUND_EVENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ExprPackage theExprPackage = (ExprPackage)EPackage.Registry.INSTANCE.getEPackage(ExprPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		basicEventEClass.getESuperTypes().add(this.getEvent());
		globalEventEClass.getESuperTypes().add(this.getBasicEvent());
		freeInteractionEClass.getESuperTypes().add(this.getGlobalEvent());
		freeInteractionEClass.getESuperTypes().add(this.getFreeEvent());
		boundInteractionEClass.getESuperTypes().add(this.getGlobalEvent());
		boundInteractionEClass.getESuperTypes().add(this.getBoundEvent());
		localEventEClass.getESuperTypes().add(this.getBasicEvent());
		receptionEClass.getESuperTypes().add(this.getLocalEvent());
		receptionEClass.getESuperTypes().add(this.getBoundEvent());
		freeSendingEClass.getESuperTypes().add(this.getLocalEvent());
		freeSendingEClass.getESuperTypes().add(this.getFreeEvent());
		boundSendingEClass.getESuperTypes().add(this.getLocalEvent());
		boundSendingEClass.getESuperTypes().add(this.getBoundEvent());
		tauEClass.getESuperTypes().add(this.getFreeEvent());
		tickEClass.getESuperTypes().add(this.getFreeEvent());
		freeEventEClass.getESuperTypes().add(this.getEvent());
		boundEventEClass.getESuperTypes().add(this.getEvent());

		// Initialize classes and features; add operations and parameters
		initEClass(basicEventEClass, BasicEvent.class, "BasicEvent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBasicEvent_Sender(), ecorePackage.getEString(), "sender", null, 1, 1, BasicEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicEvent_Receiver(), ecorePackage.getEString(), "receiver", null, 1, 1, BasicEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicEvent_OperationName(), ecorePackage.getEString(), "operationName", null, 1, 1, BasicEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicEvent_Variable(), theExprPackage.getVariable(), null, "variable", null, 0, 1, BasicEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(globalEventEClass, GlobalEvent.class, "GlobalEvent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(freeInteractionEClass, FreeInteraction.class, "FreeInteraction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boundInteractionEClass, BoundInteraction.class, "BoundInteraction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(localEventEClass, LocalEvent.class, "LocalEvent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(receptionEClass, Reception.class, "Reception", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(freeSendingEClass, FreeSending.class, "FreeSending", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boundSendingEClass, BoundSending.class, "BoundSending", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tauEClass, Tau.class, "Tau", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tickEClass, Tick.class, "Tick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(eventEClass, null, "getFreeVariables", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(theExprPackage.getVariable());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(eventEClass, null, "getBoundVariables", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(theExprPackage.getVariable());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		addEOperation(eventEClass, ecorePackage.getEString(), "toDotFormat", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(freeEventEClass, FreeEvent.class, "FreeEvent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boundEventEClass, BoundEvent.class, "BoundEvent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //BasicEventPackageImpl
