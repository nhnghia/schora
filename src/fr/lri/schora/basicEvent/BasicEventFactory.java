/**
 */
package fr.lri.schora.basicEvent;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.lri.schora.basicEvent.BasicEventPackage
 * @generated
 */
public interface BasicEventFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasicEventFactory eINSTANCE = fr.lri.schora.basicEvent.impl.BasicEventFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Free Interaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Free Interaction</em>'.
	 * @generated
	 */
	FreeInteraction createFreeInteraction();

	/**
	 * Returns a new object of class '<em>Bound Interaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bound Interaction</em>'.
	 * @generated
	 */
	BoundInteraction createBoundInteraction();

	/**
	 * Returns a new object of class '<em>Reception</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reception</em>'.
	 * @generated
	 */
	Reception createReception();

	/**
	 * Returns a new object of class '<em>Free Sending</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Free Sending</em>'.
	 * @generated
	 */
	FreeSending createFreeSending();

	/**
	 * Returns a new object of class '<em>Bound Sending</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bound Sending</em>'.
	 * @generated
	 */
	BoundSending createBoundSending();

	/**
	 * Returns a new object of class '<em>Tau</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tau</em>'.
	 * @generated
	 */
	Tau createTau();

	/**
	 * Returns a new object of class '<em>Tick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tick</em>'.
	 * @generated
	 */
	Tick createTick();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BasicEventPackage getBasicEventPackage();

} //BasicEventFactory
