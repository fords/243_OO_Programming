
/*
 * ${SubExpression.java} 
 *
 * File:
 *   $$Id$$
 *
 * Revisions:
 *   $$Log$$
 */

/*
 * the class does the subtraction 
 * @Zeyar Win
 */
public class SubExpression implements Expression{
    private Expression left;
    private Expression right;
    /*
     * construct the expression with left and right to do calculation
     * @param Expression,Expression
     */
    public SubExpression(Expression left, Expression right){
    	this.left=left;
    	this.right=right;
    }
    /* express as String
     * @return String
     */
	public String emit(){
		return "("+left.emit()+" - "+right.emit()+")";
	}
	/*subtract right from left
	 * @return Expression
	 */
	public int evaluate(){
		return left.evaluate()-right.evaluate();
	}
	

}
