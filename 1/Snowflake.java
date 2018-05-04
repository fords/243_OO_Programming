public class Snowflake {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    // call the function init to create an instance of turtle class. and draw by calling function snowfalke
		Turtle t = Snowflake.init(Integer.parseInt(args[0]));

		Snowflake.snowflake(Integer.parseInt(args[0]),
				Integer.parseInt(args[1]), t);

	}

	public static Turtle init(int S) {
	// create an instance of class turtle
		Turtle t = new Turtle(0, 0, 0);
		t.setWorldCoordinates(-1.5 * S, -1.5 * S, 1.5 * S, 1.5 * S);
		return t;
	}

	public static void snowflakeSide(int S, int N, Turtle t) {
	// draw a snowflake side by recursion with respect to N 
		if (N == 1) {
			t.goForward(S);
		} else {
			S = S / 3;
			Snowflake.snowflakeSide(S, N - 1, t);
			t.turnLeft(60);
			Snowflake.snowflakeSide(S, N - 1, t);
			t.turnRight(120);
			Snowflake.snowflakeSide(S, N - 1, t);
			t.turnLeft(60);
			Snowflake.snowflakeSide(S, N - 1, t);
		}
	}

	public static void snowflake(int S, int N, Turtle t)
    //  draw the snowflake by for loop 
	{
		for (int i = 1; i <= 3; i++) {
			Snowflake.snowflakeSide(S, N, t);
			t.turnRight(120);

		}
	}

}
