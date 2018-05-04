/*
 * ${Woolie.java} 
 *
 * File:
 *   $$Id$$
 *
 * Revisions:
 *   $$Log$$
 */
/**
 * woolie will go to bridge and leave ,letting trolls know 
 * @author Zeyar WIN 
 */
public class Woolie extends Thread {
	String name;
	int time;
	String des;
	TrollsBridge bridgeG;
	/*
	 * constructor of woolie
	 * @param String ,int,String,TrollsBridge
	 *
	 */
	public Woolie (String name,
            int crossTime,
            String destination,
            TrollsBridge bridgeGuard){
		setName(name);
		this.name=name;
		time=crossTime;
		des=destination;
		bridgeG=bridgeGuard;
	}
	/**
	 * go to bridge and leave ,letting trolls know
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		
	
		try {
			bridgeG.enterBridgePlease(this);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0; i<time;i++){
			if(i==0){
				System.out.println(getName()+" is starting cross");}
			else{
					System.out.println("\t"+getName() + ' '+i+ " seconds");
				}
			try{
				sleep(1000);
			}
			catch(InterruptedException e){}
		}
		bridgeG.leave();
		System.out.println( getName()+ " leave at "+ des);
		}
	}
	
