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
 * This class allows the user to salt the data. Salting the data
 * basically means to add random values to each y value and making the 
 * graph experience volatility. After salting the data, the data is then
 * written out to a csv file named saltedNumbers.csv. The references I used
 * for BufferedReader and PrintWriter were https://www.youtube.com/watch?v=waXvGUEjTTs and
 * https://www.youtube.com/watch?v=fgjIk7qQong
 * 
 * @author galovillacis
 *
 */
public class Salter {
	
	
	/**
	 * 
	 * This method reads the numbers.csv file that is made in the Plot class, and 
	 * parses the data, and then adds a random value between 10-20. Once this is done, 
	 * the data is then written to a csv file named saltedNumbers.
	 * 
	 * Reference: https://www.youtube.com/watch?v=2RjkWk6zOgo
	 * 
	 */
	public static void saltData() {
		
		String fileName = "numbers.csv";
		String fileName2 = "saltedNumbers.csv";
		String line = "";
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			PrintWriter pw = new PrintWriter(fileName2);
			Random rand = new Random();
			
			ArrayList<Integer> xValues = new ArrayList<>();
			ArrayList<Integer> yValues = new ArrayList<>();
			//reference https://www.youtube.com/watch?v=-Aud0cDh-J8
			
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				int x = Integer.parseInt(values[0]);
				int y = Integer.parseInt(values[1]);
				int rng = rand.nextInt(10, 20);
				
				xValues.add(x);
				
				if(y % 2 == 0 && y != 0 ) {
				 yValues.add(y += rng);
				} else {
					yValues.add(y -= rng);
				}
			}
			
			for(int i : xValues) {
				pw.write(xValues.get(i) + "," + yValues.get(i) + "\n");
			}

		 //Edit second column of data
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

