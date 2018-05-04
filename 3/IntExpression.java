/*
 * ${IntExpression.java} 
 *
 * File:
 *   $$Id$$
 *
 * Revisions:
 *   $$Log$$
 */
/*
 * the class returns string or integer itself and serve as base case in parse class
 * @Zeyar Win
 */


public class IntExpression implements Expression{
	    private int a ;
	    /*
	     * change the string to int
	     * @param String
	     * @return int
	     */
        public IntExpression(String valString){
        	a= Integer.parseInt(valString);
        }
        /*
	     * return the integer as string expression
	     * @param String
	     * @return String
	     */
        public String emit(){
        	String b= "";
        	return b+a;
        }
        
        /* @return int
         * (non-Javadoc)
         * @see Expression#evaluate()
         */
        public int evaluate(){
        	return a;
        }
}
