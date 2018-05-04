
public class PaperbackBook extends Book{
	public PaperbackBook(String title,String author,int cost){
		super(title,author,cost,Media.Paperback);
	}
	
	public boolean isForSale(){
		return true;
	}
	
	public String toString(){
		String s= "\""+getTitle()+"\".\n\"";
    	s += "\t"+getAuthor()+".\n";
    	s +="\t"+getMedia()+".\n";
    	return s;
	}

}