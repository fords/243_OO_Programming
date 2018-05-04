/*
 * ${TrollsBridge.java} 
 *
 * File:
 *   $$Id$$
 *
 * Revisions:
 *   $$Log$$
 */
import java.util.LinkedList;

/**
 * woolie will wait on line and get to the bridge if there are less than 3 woolies on bridge
 * @author Zeyar WIN
 */
public class TrollsBridge {
	static int maxCapacity;
	int WoolieonBridge=0;
	LinkedList<Woolie> line=new LinkedList<Woolie>();
	/*
	 * fix the max number of woolies on bridge
	 * @param int
	 * 
	 */
	public TrollsBridge(int i) {
		maxCapacity=i;
	}
	/*
	 * let woolie enter to bridge
	 * @param Woolie
	 */
	public synchronized void enterBridgePlease(Woolie thisWoolie) throws InterruptedException{
		
		
			getOnBridge(thisWoolie);//add to line and add number to woolie in bridge
			System.out.println("The troll scowls \"Get in line!\" when "+thisWoolie.getName()+" shows up at the bridge." );
		
				while(true){
					
					
					if (thisWoolie==line.peek()&&WoolieonBridge<maxCapacity){// this is head of line  {
						this.notifyAll();
						break;
						}
					this.wait();
				}
				  
						
					
				
			
			getOutOfLine();
			WoolieonBridge+=1;
			 //remove line
	}
	/**
	 * leave the bridge
	 */
	public synchronized void leave(){
		{
			getOffBridge(); //decrase woolie number
			this.notifyAll();
		}
	}
	/**
	 * reduce woolie number on bridge
	 */
	public void getOffBridge(){
		WoolieonBridge -=1;
	}
	/**
	 * add woolie on line
	 * @param Woolie
	 */
	public void getOnBridge(Woolie w){
		line.add(w);
		
	}
	/**
	 * woolie get out of line
	 * 
	 */
	public Woolie getOutOfLine(){
		//System.out.println(line.peek().getName()+" is out of line");
		return line.remove();
	}
}
 