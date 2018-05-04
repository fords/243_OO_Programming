/*
 * ${Parse.java} 
 *
 * File:
 *   $$Id$$
 *
 * Revisions:
 *   $$Log$$
 */


/*
 * parse calculates the prefix expression and gives the result integer
 * @Zeyar Win
 */

public class Parse {
    
	
	/* call the method parseData to calculate
     * @param String 
     * @return  integer
     */
	public static Expression parseString(String s) {
		return parseData(new Data(s));
	}
	
     /*
      * call recursively itself to calculate the prefix expression with the aid of Data class which goes to the next data after it is called
      * @param Data 
      * @return integer
      */
	private static Expression parseData(Data d) {
		Expression i;
		String token = d.next();

		if (token.equals("+")) {
			Expression sub1 = parseData(d);
			Expression sub2 = parseData(d);
			i = new AddExpression(sub1, sub2);
		}
		else if (token.equals("-")) {
			Expression sub1 = parseData(d);
			Expression sub2 = parseData(d);
			i = new SubExpression(sub1, sub2);

		}
		else if (token.equals("*")) {
			Expression sub1 = parseData(d);
			Expression sub2 = parseData(d);
			i = new MulExpression(sub1, sub2);
		} else {
			i = new IntExpression(token);

		}
		return i;
	}
    /*
     * goes to the next data of the argument
     * @param String
     * @return String
     */
	private static class Data {

		int i;
		String s;

		public Data(String s) {
			this.s = s;
			i = 0;

		}
		public String next(){
			int start=i;
			int end=s.indexOf(" ",start);
			if (end==-1){
				end=s.length();
				String token=s.substring(start,end);
				i=-1;
				return token;
			}
			
			String token = s.substring(start,end);
			i=end+1;
			return token;
		}

	}
}

