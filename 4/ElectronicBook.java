
public class ElectronicBook extends Book{
	private String URL;
	public ElectronicBook(String title,String author,int cost,String theURL){
		super(title,author,cost,Media.Electronic);
		URL= theURL;
	}
	public String getMedia(){
		return "("+ Media.Electronic +")"+" from "+ URL+".";
	}
	
	public boolean isForSale(){
		return false;
	}
	public double getCost(){
		return 0.0;
	}
	public String toString(){
		String s= "\""+getTitle()+"\".\n\"";
    	s += "\t"+getAuthor()+".\n";
    	s +="\t"+getMedia();
    	return s;
	}
}
