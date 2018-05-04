
public class HardcoverBook extends Book {
    String material;
    public HardcoverBook(String title, String author,int cost,
    		String coverMaterial){
    	super(title,author,cost,Media.Hardcover);
    	material=coverMaterial;
    }
    public String getCoverMaterial(){
    	return material;
    }
    public boolean isForSale(){
    	return true;
    }
    public String getMedia(){
    	return Media.Hardcover +" from "+getCoverMaterial()+".";
    }
    public String toString(){
    	String s= "\""+getTitle()+"\".\n\"";
    	s += "\t"+getAuthor()+".\n";
    	s +="\t"+getMedia();
    	return s;
    }
    
    
}
