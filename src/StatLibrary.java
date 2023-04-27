import java.lang.Math;

/**
 * 
 * 
 * This class allows the ability for users to do hypergeometric,
 * poisson, and tchebysheffs calculations.
 * 
 * 
 * @author galovillacis
 *
 */
public class StatLibrary {

	public StatLibrary() {
		
	}
	
	/**
	 * 
	 * This is a factorial method that calculates the factorial 
	 * of the paramater n. This method is necessary for the calculateCombination,
	 * hypergeometric, poisson, and tchebysheffs methods.
	 * @param n
	 * @return factorial
	 */
	public static double factorial(double n) {
		double factorial = 1;
		
		for(double i = n; i > 0; i--) {
			factorial = factorial * i;
		}
		return factorial;
	}
	/**
	 * 
	 * This method calculates the combinations of n and r. This method is 
	 * necessary for hypergeometric and poisson methods.
	 * 
	 * @param n
	 * @param r
	 * @return combination
	 */
	public double calculateCombination(double n, double r) {
		
		double denominator = factorial(r) * (factorial(n-r));
		double combination = factorial(n) / (denominator);
		
		return combination;
	}	
	/**
	 * 
	 * This method calculates the hypergeometric distribution of 
	 * n, r, y, and N. 
	 * 
	 * @param n
	 * @param r
	 * @param y
	 * @param N
	 * @return hypergeometric
	 */
	public double hypergeometric(double n, double r, double y, double N) {
		double hypergeometric = (calculateCombination(r, y) * calculateCombination(N-r, n-y)) / calculateCombination(N,n);
		return hypergeometric;
	}
	/**
	 * 
	 * This method calculates the poisson distribution of l and y.
	 * 
	 * @param l
	 * @param y
	 * @return poissonDist
	 */
	public double poisson(double l, double y) {
		
		double poissonDist = Math.pow(l, y) * Math.pow(Math.E, -l) / factorial(y);
		return poissonDist;
	}
	/**
	 * 
	 * This method calculates tchebysheffs theorem of paramater k.
	 * 
	 * @param k
	 * @return ans
	 */
	public double tchebysheffs(double k) {
		
		double ans = 1 / (Math.pow(k, 2));
		return ans;
		
	}
	
	
}
