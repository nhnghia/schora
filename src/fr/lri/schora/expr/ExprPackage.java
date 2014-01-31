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
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lri.schora.expr;

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
 * @see fr.lri.schora.expr.ExprFactory
 * @model kind="package"
 * @generated
 */
public interface ExprPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expr";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.lri.fr/schora/expr";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "expr";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExprPackage eINSTANCE = fr.lri.schora.expr.impl.ExprPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.ExpressionImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 5;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.VariableImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.ConditionImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 1;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.UnaryConditionImpl <em>Unary Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.UnaryConditionImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getUnaryCondition()
	 * @generated
	 */
	int UNARY_CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION__EXPR = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_CONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.BinaryConditionImpl <em>Binary Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.BinaryConditionImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getBinaryCondition()
	 * @generated
	 */
	int BINARY_CONDITION = 3;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CONDITION__EXPR = UNARY_CONDITION__EXPR;

	/**
	 * The feature id for the '<em><b>Expr2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CONDITION__EXPR2 = UNARY_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Binary Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CONDITION_FEATURE_COUNT = UNARY_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.RelationalConditionImpl <em>Relational Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.RelationalConditionImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getRelationalCondition()
	 * @generated
	 */
	int RELATIONAL_CONDITION = 4;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_CONDITION__LEFT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_CONDITION__OP = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_CONDITION__RIGHT = CONDITION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relational Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_CONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.InverseImpl <em>Inverse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.InverseImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getInverse()
	 * @generated
	 */
	int INVERSE = 6;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVERSE__EXPR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inverse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVERSE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.ConstanceImpl <em>Constance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.ConstanceImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getConstance()
	 * @generated
	 */
	int CONSTANCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANCE__NAME = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANCE__TYPE = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.IntegerImpl <em>Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.IntegerImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER__NAME = CONSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER__TYPE = CONSTANCE__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER__VALUE = CONSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_FEATURE_COUNT = CONSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.StringValueImpl <em>String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.StringValueImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getStringValue()
	 * @generated
	 */
	int STRING_VALUE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__NAME = CONSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__TYPE = CONSTANCE__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__VALUE = CONSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_FEATURE_COUNT = CONSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.BooleanImpl <em>Boolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.BooleanImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getBoolean()
	 * @generated
	 */
	int BOOLEAN = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN__NAME = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN__TYPE = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.FunctionImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__VARIABLES = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.AndImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 12;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__EXPR = BINARY_CONDITION__EXPR;

	/**
	 * The feature id for the '<em><b>Expr2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__EXPR2 = BINARY_CONDITION__EXPR2;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = BINARY_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.OrImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getOr()
	 * @generated
	 */
	int OR = 13;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__EXPR = BINARY_CONDITION__EXPR;

	/**
	 * The feature id for the '<em><b>Expr2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__EXPR2 = BINARY_CONDITION__EXPR2;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = BINARY_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.ImplyImpl <em>Imply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.ImplyImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getImply()
	 * @generated
	 */
	int IMPLY = 14;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLY__EXPR = BINARY_CONDITION__EXPR;

	/**
	 * The feature id for the '<em><b>Expr2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLY__EXPR2 = BINARY_CONDITION__EXPR2;

	/**
	 * The number of structural features of the '<em>Imply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLY_FEATURE_COUNT = BINARY_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.NotImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 15;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__EXPR = UNARY_CONDITION__EXPR;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = UNARY_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.BTrueImpl <em>BTrue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.BTrueImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getBTrue()
	 * @generated
	 */
	int BTRUE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTRUE__NAME = BOOLEAN__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTRUE__TYPE = BOOLEAN__TYPE;

	/**
	 * The number of structural features of the '<em>BTrue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTRUE_FEATURE_COUNT = BOOLEAN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.BFalseImpl <em>BFalse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.BFalseImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getBFalse()
	 * @generated
	 */
	int BFALSE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFALSE__NAME = BOOLEAN__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFALSE__TYPE = BOOLEAN__TYPE;

	/**
	 * The number of structural features of the '<em>BFalse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFALSE_FEATURE_COUNT = BOOLEAN_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.ForAllImpl <em>For All</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.ForAllImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getForAll()
	 * @generated
	 */
	int FOR_ALL = 18;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL__EXPR = UNARY_CONDITION__EXPR;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL__VARIABLES = UNARY_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>For All</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_FEATURE_COUNT = UNARY_CONDITION_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.BracketImpl <em>Bracket</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.BracketImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getBracket()
	 * @generated
	 */
	int BRACKET = 19;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRACKET__EXPR = UNARY_CONDITION__EXPR;

	/**
	 * The number of structural features of the '<em>Bracket</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRACKET_FEATURE_COUNT = UNARY_CONDITION_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link fr.lri.schora.expr.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.lri.schora.expr.impl.BinaryExpressionImpl
	 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getBinaryExpression()
	 * @generated
	 */
	int BINARY_EXPRESSION = 20;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see fr.lri.schora.expr.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link fr.lri.schora.expr.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.lri.schora.expr.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.lri.schora.expr.Variable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see fr.lri.schora.expr.Variable#getType()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Type();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see fr.lri.schora.expr.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.UnaryCondition <em>Unary Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Condition</em>'.
	 * @see fr.lri.schora.expr.UnaryCondition
	 * @generated
	 */
	EClass getUnaryCondition();

	/**
	 * Returns the meta object for the reference '{@link fr.lri.schora.expr.UnaryCondition#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expr</em>'.
	 * @see fr.lri.schora.expr.UnaryCondition#getExpr()
	 * @see #getUnaryCondition()
	 * @generated
	 */
	EReference getUnaryCondition_Expr();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.BinaryCondition <em>Binary Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Condition</em>'.
	 * @see fr.lri.schora.expr.BinaryCondition
	 * @generated
	 */
	EClass getBinaryCondition();

	/**
	 * Returns the meta object for the reference '{@link fr.lri.schora.expr.BinaryCondition#getExpr2 <em>Expr2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expr2</em>'.
	 * @see fr.lri.schora.expr.BinaryCondition#getExpr2()
	 * @see #getBinaryCondition()
	 * @generated
	 */
	EReference getBinaryCondition_Expr2();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.RelationalCondition <em>Relational Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Condition</em>'.
	 * @see fr.lri.schora.expr.RelationalCondition
	 * @generated
	 */
	EClass getRelationalCondition();

	/**
	 * Returns the meta object for the reference '{@link fr.lri.schora.expr.RelationalCondition#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see fr.lri.schora.expr.RelationalCondition#getLeft()
	 * @see #getRelationalCondition()
	 * @generated
	 */
	EReference getRelationalCondition_Left();

	/**
	 * Returns the meta object for the attribute '{@link fr.lri.schora.expr.RelationalCondition#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see fr.lri.schora.expr.RelationalCondition#getOp()
	 * @see #getRelationalCondition()
	 * @generated
	 */
	EAttribute getRelationalCondition_Op();

	/**
	 * Returns the meta object for the reference '{@link fr.lri.schora.expr.RelationalCondition#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see fr.lri.schora.expr.RelationalCondition#getRight()
	 * @see #getRelationalCondition()
	 * @generated
	 */
	EReference getRelationalCondition_Right();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see fr.lri.schora.expr.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.Inverse <em>Inverse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inverse</em>'.
	 * @see fr.lri.schora.expr.Inverse
	 * @generated
	 */
	EClass getInverse();

	/**
	 * Returns the meta object for the reference '{@link fr.lri.schora.expr.Inverse#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expr</em>'.
	 * @see fr.lri.schora.expr.Inverse#getExpr()
	 * @see #getInverse()
	 * @generated
	 */
	EReference getInverse_Expr();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.Constance <em>Constance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constance</em>'.
	 * @see fr.lri.schora.expr.Constance
	 * @generated
	 */
	EClass getConstance();

	/**
	 * Returns the meta object for the attribute '{@link fr.lri.schora.expr.Constance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.lri.schora.expr.Constance#getName()
	 * @see #getConstance()
	 * @generated
	 */
	EAttribute getConstance_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.lri.schora.expr.Constance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see fr.lri.schora.expr.Constance#getType()
	 * @see #getConstance()
	 * @generated
	 */
	EAttribute getConstance_Type();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.Integer <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer</em>'.
	 * @see fr.lri.schora.expr.Integer
	 * @generated
	 */
	EClass getInteger();

	/**
	 * Returns the meta object for the attribute '{@link fr.lri.schora.expr.Integer#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.lri.schora.expr.Integer#getValue()
	 * @see #getInteger()
	 * @generated
	 */
	EAttribute getInteger_Value();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value</em>'.
	 * @see fr.lri.schora.expr.StringValue
	 * @generated
	 */
	EClass getStringValue();

	/**
	 * Returns the meta object for the attribute '{@link fr.lri.schora.expr.StringValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.lri.schora.expr.StringValue#getValue()
	 * @see #getStringValue()
	 * @generated
	 */
	EAttribute getStringValue_Value();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.Boolean <em>Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean</em>'.
	 * @see fr.lri.schora.expr.Boolean
	 * @generated
	 */
	EClass getBoolean();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see fr.lri.schora.expr.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the attribute '{@link fr.lri.schora.expr.Function#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.lri.schora.expr.Function#getName()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Name();

	/**
	 * Returns the meta object for the reference list '{@link fr.lri.schora.expr.Function#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see fr.lri.schora.expr.Function#getVariables()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Variables();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see fr.lri.schora.expr.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see fr.lri.schora.expr.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.Imply <em>Imply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imply</em>'.
	 * @see fr.lri.schora.expr.Imply
	 * @generated
	 */
	EClass getImply();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see fr.lri.schora.expr.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.BTrue <em>BTrue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BTrue</em>'.
	 * @see fr.lri.schora.expr.BTrue
	 * @generated
	 */
	EClass getBTrue();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.BFalse <em>BFalse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BFalse</em>'.
	 * @see fr.lri.schora.expr.BFalse
	 * @generated
	 */
	EClass getBFalse();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.ForAll <em>For All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For All</em>'.
	 * @see fr.lri.schora.expr.ForAll
	 * @generated
	 */
	EClass getForAll();

	/**
	 * Returns the meta object for the reference list '{@link fr.lri.schora.expr.ForAll#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see fr.lri.schora.expr.ForAll#getVariables()
	 * @see #getForAll()
	 * @generated
	 */
	EReference getForAll_Variables();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.Bracket <em>Bracket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bracket</em>'.
	 * @see fr.lri.schora.expr.Bracket
	 * @generated
	 */
	EClass getBracket();

	/**
	 * Returns the meta object for class '{@link fr.lri.schora.expr.BinaryExpression <em>Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Expression</em>'.
	 * @see fr.lri.schora.expr.BinaryExpression
	 * @generated
	 */
	EClass getBinaryExpression();

	/**
	 * Returns the meta object for the reference '{@link fr.lri.schora.expr.BinaryExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see fr.lri.schora.expr.BinaryExpression#getLeft()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_Left();

	/**
	 * Returns the meta object for the reference '{@link fr.lri.schora.expr.BinaryExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see fr.lri.schora.expr.BinaryExpression#getRight()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_Right();

	/**
	 * Returns the meta object for the attribute '{@link fr.lri.schora.expr.BinaryExpression#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see fr.lri.schora.expr.BinaryExpression#getOp()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EAttribute getBinaryExpression_Op();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExprFactory getExprFactory();

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
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.VariableImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__TYPE = eINSTANCE.getVariable_Type();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.ConditionImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.UnaryConditionImpl <em>Unary Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.UnaryConditionImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getUnaryCondition()
		 * @generated
		 */
		EClass UNARY_CONDITION = eINSTANCE.getUnaryCondition();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_CONDITION__EXPR = eINSTANCE.getUnaryCondition_Expr();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.BinaryConditionImpl <em>Binary Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.BinaryConditionImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getBinaryCondition()
		 * @generated
		 */
		EClass BINARY_CONDITION = eINSTANCE.getBinaryCondition();

		/**
		 * The meta object literal for the '<em><b>Expr2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_CONDITION__EXPR2 = eINSTANCE.getBinaryCondition_Expr2();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.RelationalConditionImpl <em>Relational Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.RelationalConditionImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getRelationalCondition()
		 * @generated
		 */
		EClass RELATIONAL_CONDITION = eINSTANCE.getRelationalCondition();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_CONDITION__LEFT = eINSTANCE.getRelationalCondition_Left();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONAL_CONDITION__OP = eINSTANCE.getRelationalCondition_Op();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_CONDITION__RIGHT = eINSTANCE.getRelationalCondition_Right();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.ExpressionImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.InverseImpl <em>Inverse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.InverseImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getInverse()
		 * @generated
		 */
		EClass INVERSE = eINSTANCE.getInverse();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVERSE__EXPR = eINSTANCE.getInverse_Expr();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.ConstanceImpl <em>Constance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.ConstanceImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getConstance()
		 * @generated
		 */
		EClass CONSTANCE = eINSTANCE.getConstance();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANCE__NAME = eINSTANCE.getConstance_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANCE__TYPE = eINSTANCE.getConstance_Type();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.IntegerImpl <em>Integer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.IntegerImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getInteger()
		 * @generated
		 */
		EClass INTEGER = eINSTANCE.getInteger();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER__VALUE = eINSTANCE.getInteger_Value();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.StringValueImpl <em>String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.StringValueImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getStringValue()
		 * @generated
		 */
		EClass STRING_VALUE = eINSTANCE.getStringValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.BooleanImpl <em>Boolean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.BooleanImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getBoolean()
		 * @generated
		 */
		EClass BOOLEAN = eINSTANCE.getBoolean();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.FunctionImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__VARIABLES = eINSTANCE.getFunction_Variables();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.AndImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.OrImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.ImplyImpl <em>Imply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.ImplyImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getImply()
		 * @generated
		 */
		EClass IMPLY = eINSTANCE.getImply();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.NotImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.BTrueImpl <em>BTrue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.BTrueImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getBTrue()
		 * @generated
		 */
		EClass BTRUE = eINSTANCE.getBTrue();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.BFalseImpl <em>BFalse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.BFalseImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getBFalse()
		 * @generated
		 */
		EClass BFALSE = eINSTANCE.getBFalse();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.ForAllImpl <em>For All</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.ForAllImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getForAll()
		 * @generated
		 */
		EClass FOR_ALL = eINSTANCE.getForAll();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_ALL__VARIABLES = eINSTANCE.getForAll_Variables();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.BracketImpl <em>Bracket</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.BracketImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getBracket()
		 * @generated
		 */
		EClass BRACKET = eINSTANCE.getBracket();

		/**
		 * The meta object literal for the '{@link fr.lri.schora.expr.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.lri.schora.expr.impl.BinaryExpressionImpl
		 * @see fr.lri.schora.expr.impl.ExprPackageImpl#getBinaryExpression()
		 * @generated
		 */
		EClass BINARY_EXPRESSION = eINSTANCE.getBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__LEFT = eINSTANCE.getBinaryExpression_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__RIGHT = eINSTANCE.getBinaryExpression_Right();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_EXPRESSION__OP = eINSTANCE.getBinaryExpression_Op();

	}

} //ExprPackage
