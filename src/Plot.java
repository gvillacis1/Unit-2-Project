import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * 
 * This class uses print writer to write to a csv and generate X
 * and Y values in y=mx+b form. 
 * 
 * @author galovillacis
 *
 */
public class Plot {
	
	/**
	 * 
	 * Method to write X and Y values to the numbers.csv file.
	 * I did this by populating two array lists using for loops and implementing 
	 * the y=mx+b equation for the y values. I used this video for reference
	 * https://www.youtube.com/watch?v=fgjIk7qQong
	 * 
	 */
	public static void plotData() {
		
		String fileName = "numbers.csv";
		
		try(PrintWriter pw = new PrintWriter(fileName)) {
			
			ArrayList<Integer> xValues = new ArrayList<>();
			ArrayList<Integer> yValues = new ArrayList<>();
			
			for(int i=0; i<101; i++) {
				xValues.add(i);
			}
			
			
			int b = 2;
			int y;
			
			for(int i=0; i<101; i++) {
				y = 2 * i + b;
				
				yValues.add(y);
			}
			
			for(int i : xValues) {
				pw.write(xValues.get(i) + "," + yValues.get(i) + "\n");
			
			}
			
			
			System.out.println("Finish writing to file.");
		
		} catch (FileNotFoundException e) {
			System.out.println("Error creating/ writing to file.");
			e.printStackTrace();
		}
	}
}

