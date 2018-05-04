/*
 * ${AddExpression.java} 
 *
 * File:
 *   $$Id$$
 *
 * Revisions:
 *   $$Log$$
 */

/*
 * the class does the adding 
 * @Zeyar Win
 */
public class AddExpression implements Expression {
   private Expression left;
   private Expression right;
   /*
    * construct the expression with left and right to do calculation
    * @param Expression,Expression
    */
   public AddExpression(Expression left,Expression right){
	   this.left=left;
	   this.right=right;
	   
   }
   /* express as String
    * @return String
    */
   public String emit(){
	    return "("+left.emit()+" + "+ right.emit()+")";   
   }  
   /*add right and left
	 * @return Expression
	 */
   public int evaluate(){
	   //if (left==int && right==int)
		   return left.evaluate() + right.evaluate();
   }


}