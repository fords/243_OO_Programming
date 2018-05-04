
/*
 * ${MulExpression.java} 
 *
 * File:
 *   $$Id$$
 *
 * Revisions:
 *   $$Log$$
 */

/*
 * the class does the multiplication 
 * @Zeyar Win
 */
public class MulExpression implements Expression {
	private Expression left;
	private Expression right;
	/*
	 * it is adding left and right values 
	 * @param Expression,Expression
	 * @return 
	 */
	public MulExpression(Expression left,Expression right){
		this.left=left;
		this.right=right;
	}
	/*express as String
	 *@return String
	 */
	public String emit(){
		return "("+left.emit()+" * "+right.emit()+")";
	}
	/*
	 * it do the multiplication left and right
	 * @return expression
	 */
	public int evaluate(){
		return left.evaluate()*right.evaluate();
	}

}
