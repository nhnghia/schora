package fr.lri.schora.stg.conformance;

import java.util.List;
import java.util.Set;

import xsmt.solver.z3.Z3Solver;

import fr.lri.schora.expr.Variable;
import fr.lri.schora.stg.STG;
import fr.lri.schora.stg.conformance.Verdict.VERDICT;

public class Conformance {
	
	/**
	 * Verify whether the impl conforms to the spec
	 * @param impl : STG of implementation
	 * @param spec : STG of specification
	 * @param z3SolverPath : path to executable Z3 Solver, e.g. in Mac OS: /Users/toto/soft/z3/bin/z3
	 * @return 
	 */
	public static Verdict conform(STG impl, STG spec, Z3Solver z3Solver) throws Exception{
		//Restriction
		_Restriction rs = new _Restriction();
		STG stg = rs.restrict(impl, spec); 
		
		_ConformanceRelation conRel = new _ConformanceRelation();
		List<_Result> results = conRel.conform(stg, spec);
		
		String str = "";
		for (_Result r : results)
			str += r.toString();
		
		_Solver solver = new _Solver();
		Set<Variable> freeVars = spec.freeVariables.get(spec.initialState);
		freeVars.addAll(impl.freeVariables.get(impl.initialState));
		int d = solver.isSatisfy(results, impl.initialState, spec.initialState, freeVars, z3Solver);
		Verdict v = new Verdict();
		if (d == 0)
			v.verdict = VERDICT.MAYBE;
		else if (d == 1)
			v.verdict = VERDICT.PASS;
		else
			v.verdict = VERDICT.FAIL;
		v.explication = str;
		return v;
	}
}
