
public class AudioBook extends Book{
	
	private int numDiscs;
	public AudioBook(String title,String author,int cost,int numDiscs){
		super(title,author,cost,Media.Audio);
		this.numDiscs=numDiscs;
	}
	
	public boolean isForSale(){
		// will be true if it is for final sale
		return false;
	}
	public double getCost(){
		return 0.0;
	}
	public String getMedia(){
		return "("+Media.Audio+")"+":"+ numDiscs+" discs.";
	}
	public String toString(){
		
		String s= "\""+getTitle()+"\".\n\"";
    	s += "\t"+getAuthor()+".\n";
    	s +="\t"+getMedia();
    	return s;
	}
	
}
