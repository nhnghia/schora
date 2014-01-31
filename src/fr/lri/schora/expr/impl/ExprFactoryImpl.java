/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lri.schora.expr.impl;

import fr.lri.schora.expr.And;
import fr.lri.schora.expr.BFalse;
import fr.lri.schora.expr.BTrue;
import fr.lri.schora.expr.BinaryExpression;
import fr.lri.schora.expr.Bracket;
import fr.lri.schora.expr.Constance;
import fr.lri.schora.expr.ExprFactory;
import fr.lri.schora.expr.ExprPackage;
import fr.lri.schora.expr.ForAll;
import fr.lri.schora.expr.Function;
import fr.lri.schora.expr.Imply;
import fr.lri.schora.expr.Inverse;
import fr.lri.schora.expr.Not;
import fr.lri.schora.expr.Or;
import fr.lri.schora.expr.RelationalCondition;
import fr.lri.schora.expr.StringValue;
import fr.lri.schora.expr.Variable;

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
public class ExprFactoryImpl extends EFactoryImpl implements ExprFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExprFactory init() {
		try {
			ExprFactory theExprFactory = (ExprFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.lri.fr/schora/expr"); 
			if (theExprFactory != null) {
				return theExprFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExprFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExprFactoryImpl() {
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
			case ExprPackage.VARIABLE: return createVariable();
			case ExprPackage.RELATIONAL_CONDITION: return createRelationalCondition();
			case ExprPackage.INVERSE: return createInverse();
			case ExprPackage.CONSTANCE: return createConstance();
			case ExprPackage.INTEGER: return createInteger();
			case ExprPackage.STRING_VALUE: return createStringValue();
			case ExprPackage.BOOLEAN: return createBoolean();
			case ExprPackage.FUNCTION: return createFunction();
			case ExprPackage.AND: return createAnd();
			case ExprPackage.OR: return createOr();
			case ExprPackage.IMPLY: return createImply();
			case ExprPackage.NOT: return createNot();
			case ExprPackage.BTRUE: return createBTrue();
			case ExprPackage.BFALSE: return createBFalse();
			case ExprPackage.FOR_ALL: return createForAll();
			case ExprPackage.BRACKET: return createBracket();
			case ExprPackage.BINARY_EXPRESSION: return createBinaryExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalCondition createRelationalCondition() {
		RelationalConditionImpl relationalCondition = new RelationalConditionImpl();
		return relationalCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inverse createInverse() {
		InverseImpl inverse = new InverseImpl();
		return inverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constance createConstance() {
		ConstanceImpl constance = new ConstanceImpl();
		return constance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fr.lri.schora.expr.Integer createInteger() {
		IntegerImpl integer = new IntegerImpl();
		return integer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringValue createStringValue() {
		StringValueImpl stringValue = new StringValueImpl();
		return stringValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fr.lri.schora.expr.Boolean createBoolean() {
		BooleanImpl boolean_ = new BooleanImpl();
		return boolean_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public And createAnd() {
		AndImpl and = new AndImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Or createOr() {
		OrImpl or = new OrImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Imply createImply() {
		ImplyImpl imply = new ImplyImpl();
		return imply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Not createNot() {
		NotImpl not = new NotImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BTrue createBTrue() {
		BTrueImpl bTrue = new BTrueImpl();
		return bTrue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BFalse createBFalse() {
		BFalseImpl bFalse = new BFalseImpl();
		return bFalse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForAll createForAll() {
		ForAllImpl forAll = new ForAllImpl();
		return forAll;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bracket createBracket() {
		BracketImpl bracket = new BracketImpl();
		return bracket;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryExpression createBinaryExpression() {
		BinaryExpressionImpl binaryExpression = new BinaryExpressionImpl();
		return binaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExprPackage getExprPackage() {
		return (ExprPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExprPackage getPackage() {
		return ExprPackage.eINSTANCE;
	}

} //ExprFactoryImpl
