/**
 */
package fr.lri.schora.basicEvent;

import fr.lri.schora.expr.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.lri.schora.basicEvent.BasicEvent#getSender <em>Sender</em>}</li>
 *   <li>{@link fr.lri.schora.basicEvent.BasicEvent#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link fr.lri.schora.basicEvent.BasicEvent#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link fr.lri.schora.basicEvent.BasicEvent#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.lri.schora.basicEvent.BasicEventPackage#getBasicEvent()
 * @model abstract="true"
 * @generated
 */
public interface BasicEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Sender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sender</em>' attribute.
	 * @see #setSender(String)
	 * @see fr.lri.schora.basicEvent.BasicEventPackage#getBasicEvent_Sender()
	 * @model required="true"
	 * @generated
	 */
	String getSender();

	/**
	 * Sets the value of the '{@link fr.lri.schora.basicEvent.BasicEvent#getSender <em>Sender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender</em>' attribute.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(String value);

	/**
	 * Returns the value of the '<em><b>Receiver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receiver</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receiver</em>' attribute.
	 * @see #setReceiver(String)
	 * @see fr.lri.schora.basicEvent.BasicEventPackage#getBasicEvent_Receiver()
	 * @model required="true"
	 * @generated
	 */
	String getReceiver();

	/**
	 * Sets the value of the '{@link fr.lri.schora.basicEvent.BasicEvent#getReceiver <em>Receiver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiver</em>' attribute.
	 * @see #getReceiver()
	 * @generated
	 */
	void setReceiver(String value);

	/**
	 * Returns the value of the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Name</em>' attribute.
	 * @see #setOperationName(String)
	 * @see fr.lri.schora.basicEvent.BasicEventPackage#getBasicEvent_OperationName()
	 * @model required="true"
	 * @generated
	 */
	String getOperationName();

	/**
	 * Sets the value of the '{@link fr.lri.schora.basicEvent.BasicEvent#getOperationName <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Name</em>' attribute.
	 * @see #getOperationName()
	 * @generated
	 */
	void setOperationName(String value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variable)
	 * @see fr.lri.schora.basicEvent.BasicEventPackage#getBasicEvent_Variable()
	 * @model
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link fr.lri.schora.basicEvent.BasicEvent#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

} // BasicEvent
