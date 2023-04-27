/**
 * 
 * This class tests the methods from the StatLibrary class. The methods that are
 * tested are hypergeometric, poisson, and tchebysheffs.
 * 
 * @author galovillacis
 *
 */

public class StatLibraryTester {

	public static void main(String [] args) {
		
		StatLibrary test = new StatLibrary();
		
		System.out.println("Hypergeometric Distribution: " + test.hypergeometric(10, 5, 5, 20));
		System.out.println("Poisson Distribution: " + test.poisson(5, 0));
		System.out.println("Tchebysheff's Theorem test: " + test.tchebysheffs(5));
	}
}
