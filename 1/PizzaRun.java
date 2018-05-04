
import java.lang.Math;
//import java.util.Scanner;

public class PizzaRun {

	/**
	 * @param args
	 */
	public static final int SLICE_PER_PIE=8;
	
	public static void calcWholePies(double money,int sum){
		/* access the money and the total slices as parameters and return
		   total money of pizzas and extra slices
		*/
		double j= (double)sum/8;
		j = Math.ceil(j);
		System.out.println(j);
		double Tmoney=money*j;
		System.out.println("Buy "+j+"pizzas for"+Tmoney);
		int extraSlice= sum%8;
		extraSlice=8-extraSlice;
		System.out.println("There are"+extraSlice+" extra slices");
	}
	
	public static void main(String[] args) {
		// call the function calcWholePies by passing the parameters 
		// money float type and the total of slices integer type
		int sum=0;
		double money =Double.parseDouble(args[0]);
//		Scanner input= new Scanner(System.in);
		for (int i=1;i<args.length;i++){
			int slice= Integer.parseInt(args[i]);
			
		    sum = sum+slice;
		
		}		     			
	    calcWholePies(money,sum);
	}
		

}

