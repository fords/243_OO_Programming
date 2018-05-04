/*
 * Schedule.java 
 *
 * 
 * File:
 *   $Id$
 *
 * Revisions:
 *   $Log$
 */

import java.util.ArrayList;

/*
 * schedule stores a list of courses and add a course if not conflict with courses in the list
 * can be printed the courses in the list 
 * @Zeyar Win
 */
    public class Schedule {
	ArrayList<Course> courselist;
    /*
     * constructor initialize the array list 
     */
	public Schedule() {
		courselist = new ArrayList<Course>();

	}
    /*
     * add the course to the list if not conflict
     * @param course
     * @return true
     */
	public boolean add(Course c) {
		if (courselist.size()==0) {
			courselist.add(c);
			return true;
		}
		for (Course a : courselist) {
			if ((c.inConflict(a))) {
				return false;
			}
		}
		courselist.add(c);
		return true;

	}
	
    /*
     *  check the course is in the courselist
     *  @param course
     *  @return boolean true if the same course is in the list ,otherwise false 
     */
	public boolean contains(Course c) {
		for (Object a : courselist) {
			return c.equals(a);
		}
		return false;
	}
    /*
     * print the courses in the list
     * @return the string representing the courses in the list
     * 
     */
	public void prettyPrint() {
	    final String[] days={"----Monday----","----Tuesday----","----Wednesday----","----Thursday----","----Friday----"};

		for (int j = 0; j < 5; j++) {
			System.out.println(days[j]);
			int i = 0;
			while (i < courselist.size()) {
				
				String entry = courselist.get(i).inDay(j);
				if (entry != null)
					
					System.out.println(entry);
				
				i++;
			}

			
		}

	}
    /*
     * return String the number of courses  
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
	public String toString() {
		return "Schedule with " + courselist.size() + "courses";
	}

}
