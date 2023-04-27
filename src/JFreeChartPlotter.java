import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.time.MovingAverage;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.apache.commons.math3.analysis.function.Power;
import org.apache.commons.math3.random.RandomDataGenerator;


/**
 * 
 * 
 * This class plots an exponential chart, a salted chart, and
 * smoothed chart by using the JfreeChart and Apache libraries.
 * 
 * 
 * @author galovillacis
 *
 */
public class JFreeChartPlotter {  
	/**
	 * 
	 * This method plots an exponential chart using JFree chart 
	 * to create the frame and Apache for the exponential.
	 * 
	 * References used: https://bethecoder.com/applications/tutorials/charts/jfreechart/xy-line-chart.html
	 * 
	 */
	public void ExponentialChart() {
    XYSeries xySeries = new XYSeries("Exponential Line Chart");
    Power power = new Power(2);
    
    for(int i = 0; i<=100; i++) {
    xySeries.add(i, power.value(i));
    }
    
    XYDataset xyDataset = new XYSeriesCollection(xySeries);
    
    
    JFreeChart chart = ChartFactory.createXYLineChart(
        "Normal Chart", "X axis", "Y Axis", xyDataset,
        PlotOrientation.VERTICAL, true, true, false);

   
    ChartFrame chartFrame = new ChartFrame("XYLine Chart", chart);
    chartFrame.setVisible(true);
    chartFrame.setSize(600, 600);

  }
	/**
	 * 
	 * This method salts the data for a chart by creating an xySeries, and then using a random data 
	 * generator to add or subtract random values for every other i index. The output is then
	 * depicted in a chart.
	 * 
	 */
	public void SaltChart() {
    XYSeries xySeries = new XYSeries("Exponential Line");
    
    Power power = new Power(2);
    RandomDataGenerator rng = new RandomDataGenerator();
    
    for(int i = 0; i<=100; i++) {
    	if(i % 2 == 0) {
    xySeries.add(i, power.value(i) - rng.nextInt(10, 1000));
    	} else {
    	    xySeries.add(i, power.value(i) + rng.nextInt(10, 1000));
    	}
    }
    
    XYDataset xyDataset = new XYSeriesCollection(xySeries);
    
    
    JFreeChart chart = ChartFactory.createXYLineChart(
        "Salted Chart", "X Axis", "Y Axis", xyDataset,
        PlotOrientation.VERTICAL, true, true, false);

   
    ChartFrame chartFrame = new ChartFrame("XYLine Chart", chart);
    chartFrame.setVisible(true);
    chartFrame.setSize(600, 600);

  }
	
	/**
	 * 
	 * This method smooths the salted data by creating an xySeries, and then using the MovingAverage class 
	 * from the JFreeChart library. The program is then able to calculate an average for every 50 index values.
	 * 
	 * References used: //https://www.jfree.org/jfreechart/api/javadoc/org/jfree/data/time/MovingAverage.html#MovingAverage--
	 * 
	 */
	public void SmoothChart() {
	
		XYSeries xySeries = new XYSeries("Exponential Line");
	    
	    Power power = new Power(2);
	    RandomDataGenerator rng = new RandomDataGenerator();

	    for(int i = 0; i<=100; i++) {
	    	if(i % 2 == 0) {
	    xySeries.add(i, power.value(i) - rng.nextInt(10, 1000));
	    	} else {
	    	    xySeries.add(i, power.value(i) + rng.nextInt(10, 1000));
	    	}
	    }
	    
	    XYDataset xyDataset = new XYSeriesCollection(xySeries);	    
	    XYDataset xySeries1 = MovingAverage.createMovingAverage(xyDataset, "", 50, 0);

	    
	    JFreeChart chart = ChartFactory.createXYLineChart(
	        "Smoother Chart", "X Axis", "Y Axis", xySeries1,
	        PlotOrientation.VERTICAL, true, true, false);

	   
	    ChartFrame chartFrame = new ChartFrame("XYLine Chart", chart);
	    chartFrame.setVisible(true);
	    chartFrame.setSize(600, 600);

		
	}
}
	