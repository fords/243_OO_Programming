/*
 * Course.java
 *
 * File:
 *   $$Id$$
 *
 * Revisions:
 *   $$Log$$
 */

/* Course stores the name,day,start time and end time 
 * inConflict method checks the time conflict and inDay method takes the day number and give back the time of the courses in the day
 * @Zeyar Win
 * 
 */
import java.util.ArrayList;


public class Course {
    public final static String dayString= "MTWRF";
    private String name;
    private ArrayList<Boolean>days;
    private int start;
    private int end;
    /*
     * constructor course  takes name of course, days ,start time and end time 
     */
    public Course(String n, ArrayList <Boolean> days ,int start,int end){
    	name=n;
    	this.days=days;
    	this.start = start;
    	this.end=end;
    	
    	
    }
    /* equals method take the instance of course class as parameter and compare if they are the same
     * @return true or falses
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other){
    	
    	if (!(other instanceof Course)){
    		return false;
    	}
    	Course ot=(Course)(other);
    	
    	return (days==ot.days && name==ot.name && start==ot.start
    			&& end ==ot.end);
    	
    }
    /* 
     * @parameter: time 
     * @return the time as 24 hour clock (assume start time is 8AM and end time is 7 PM)
     */
    public static int hours(int time){
    	return (time+4)%12;
    }
    /*
     * check other course is conflict with this course
     * @param course 
     * @return true if conflict or false if not
     */
    public boolean inConflict(Course ot){  	    	 
		 for (int e=0; e<5; e++){
			 if (days.get(e) && ot.days.get(e)) {
			 	if ( hours(this.start) > hours(ot.start) && hours(this.start) < hours(ot.end) ||  
			 			hours(this.start) < hours(ot.start) && hours(this.end) >hours( ot.end) || 
			 			hours(this.end) > hours(ot.start) && hours(this.end) < hours(ot.end )) {
			 		return true;
			 	}
			 }
		 }
    	 
    	 return false;
    }
    /* @return String representing the course
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString(){
    	String string= name+": ";
    	for (int i=0;i<5;i++){
    		if(days.get(i)==true){
    		  string+= dayString.charAt(i);	
    		}
    		
    	}
    	string += " at ";
    	string += Integer.toString(start)+"-"+ Integer.toString(end);
    	return string;
    }
    
    /*
     * give back the course time in the particular day
     * @param int no as a day
     *@return String of the time
     */
   public String inDay(int day){
	   if (days.get(day)==true){
		   return Integer.toString(start)+"-"+Integer.toString(end)+": "+name;
	   }
	   else{
		   return null;
	   }		  
		   
   }
   /*
    * get the day
    * @return days
    */
   public ArrayList<Boolean> getDays(){
	   return days;
   }
   /*
    * get the start time 
    *@return starttime
    **/
   public int getStart(){
	   return start;
   }
   /*
    * get the end time
    *@return end time
    */
   public int getEnd(){
	   return end;
	   
   }
   /*
    * get the courseName
    * @return String
    * 
    */
   public String getName(){
	   return name;
   }
	
   
   }
    



