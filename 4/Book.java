import java.lang.Math;
public abstract class Book {
	private String title;
	private String author;
	private int cost;
	private Media media;
    public Book(String title, String author, int cost, Media media){
    	this.title=title;
    	this.author=author;
    	this.cost=cost;
    	this.media=media;
    } 
    public abstract boolean isForSale();
    
    public String getTitle(){
    	return "("+title+")";
    }
    public String getAuthor(){
    	return author;
    }
    public double getCost(){
    	double cent=(cost%100);
    	cent /=100;
    	System.out.println(cent);
    	double dollar=Math.floor(cost/100);
        System.out.println(dollar);
        
        return dollar+cent;
    }
    public String getMedia(){
    	return ""+media;
    }
    /* print the standard form
     * @return String
     */
    public String toString(){
    	String s= "\""+getTitle()+"\".\n\"";
    	s += "\t"+getAuthor()+".\n";
    	s +="\t"+getMedia()+".\n";
    	return s;
    }
    	
    
}
