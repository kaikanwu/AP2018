import java.util.ArrayList;
import java.util.Collections;

/**
 * class for creating a statistics report
 */
public class Statistics {


    private ArrayList<Double> timeArray;
    private String generatorName;
    private double elapsedTime;
    private double mean;
    private double max;
    private double min;
    private double variance;
    /**
     * class statistics constructor
     * @param timeArray
     * @param generatorName
     */
    public Statistics(ArrayList<Double> timeArray, String generatorName){
        this.timeArray = timeArray;
        this.generatorName = generatorName;

    }


    /**
     * get the mean of the time array
     * @return
     */
    public double mean(){
        int sum = 0;
        for (int i = 0; i < timeArray.size(); i++) {
            sum += timeArray.get(i);
        }
        mean = sum/(timeArray.size());

        return mean;
    }


    /**
     *  get the max in the time array
     * @return
     */
    public double max(){

        max = Collections.max(timeArray);



        return max;
    }

    /**
     * get the min of the time array
     * @return
     */
    public double min(){
        min = Collections.min(timeArray);
        return min;
    }

    /**
     * calculate the variance of the time array
     * @return
     */
    public double variance(){
        double mean = mean();
        double temp = 0;
        for (double a : timeArray){
            temp += (a-mean)*(a-mean);
        }

        return temp/(timeArray.size()-1);
    }


    /**
     * write the report to the console
     */
    public void writeReport(){
        StringBuilder sb = new StringBuilder();
        sb.append("In generator " + generatorName +  ": \r\n"  );
        sb.append("The max time is: " + max() + "\r\n" + "seconds");
        sb.append("The min time is:" + min() + "\r\n" + "seconds");
        sb.append("The mean time is " + mean() + "\r\n" + "seconds");
        sb.append("The variance time  is " + variance() + "\r\n");
        System.out.println(sb);
    }







}
