import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 
 * 
 * This class allows the user to smooth the data. Smoothing the data
 * basically means to get rid of the volatility of the graph and smooth out the curves.
 * After smoothing the data, the data is then written out to a 
 * csv file named smootherNumbers.csv. 
 * 
 * @author galovillacis
 *
 */
public class Smoother {
	
	/**
	 * 
	 * This method reads the saltedNumbers.csv file that is made in the Salter class, and 
	 * parses the data, and then finds the average of each y value and its neighboring values. 
	 * Once this is done, the data is then written to a csv file named smootherNumbers. This was
	 * done a few times to smooth out the volatility so thats why there are multiple csv's for smootherNumbers.
	 * 
	 * Reference: https://www.youtube.com/watch?v=2RjkWk6zOgo
	 * 
	 */
	public static void smoothData() {
		
		String fileName = "saltedNumbers.csv";
		String fileName2 = "smootherNumbers.csv";
		String fileName3 = "smootherNumbers2.csv";
		String fileName4 = "smootherNumbers3.csv";
		String fileName5 = "smootherNumbers4.csv";


		String line = "";
		int avg;
		int neighboringValues = 5;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName3));
			
			PrintWriter pw = new PrintWriter(fileName4);
			Random rand = new Random();
			
			ArrayList<Integer> xValues = new ArrayList<>();
			ArrayList<Integer> yValues = new ArrayList<>();
			//reference https://www.youtube.com/watch?v=-Aud0cDh-J8
			
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				int x = Integer.parseInt(values[0]);
				int y = Integer.parseInt(values[1]);

				xValues.add(x);

				yValues.add(y);
		
			}
			
			//reference https://stackoverflow.com/questions/68037744/how-do-i-calculate-the-moving-average-of-the-7-most-recent-values-after-the-firs
			for(int i = neighboringValues; i<yValues.size() - neighboringValues; i++) {
				
				int sum = 0;
				for(int j = i - neighboringValues; j<= i + neighboringValues; j++) {
					sum += yValues.get(j);
				}
				
				avg = sum / (2 * neighboringValues + 1);
				yValues.set(i, avg);
				
			}
			
			
			for(int i : xValues) {
				pw.write(xValues.get(i) + "," + yValues.get(i) + "\n");
			}

			 pw.close();
			 br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error creating/ writing to file.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
