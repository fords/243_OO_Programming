/*
 * ${BarneysBooks.java} 
 *
 * File:
 *   $$Id$$
 *
 * Revisions:
 *   $$Log$$
 */
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;
/* by using GUI ,build the buttons and action listeners listen to button and do what the particular button should
 * @Zeyar Win
 */
public class BarneysBooks extends JFrame{
	boolean bool;
	Book book;
	static Store store;
	String string[]=new String[34];
	JList jlist;
	private ArrayList <Book> a;
	JTextField TextTitle;
	JTextField TextAuthor;
	JTextField TextMedia;
	JTextField TextPrice;
	int i;
	JComponent textBox;
	JButton buy;
	JButton rent;
	//public static JRadioButton titleB = null;
	//public static JRadioButton titleA = null;
	
	//public static JRadioButton titleMedia = null;
	
	
	
	// the constructor creates the GUI and does some functions
	public BarneysBooks(final Store store){
		
		super("Barneys Books");
		this.store=store;
		JPanel p=new JPanel();
		JLabel labelimage=new JLabel(" ");
		ImageIcon image=new ImageIcon("BarneysBooksNBytes.png");
		labelimage.setIcon(image);
		p.add(labelimage);
		
		//stores radiobutton
		ButtonGroup group=new ButtonGroup();
		final JRadioButton title=new JRadioButton("title");
		final JRadioButton Author=new JRadioButton("author");
		final JRadioButton media=new JRadioButton("Media Format");
		group.add(title);
		group.add(Author);
		group.add(media);
		JPanel groupPanel=new JPanel();
		groupPanel.setLayout(new GridLayout(1,3));
	//	groupPanel.add(title,BorderLayout.WEST);
	//	groupPanel.add(Author,BorderLayout.CENTER);
	//	groupPanel.add(media,BorderLayout.EAST);
		groupPanel.add(title);
		groupPanel.add(Author);
		groupPanel.add(media);
		
		JPanel panel1= new JPanel();
		panel1.setLayout(new GridLayout(2,1));
		final JTextField text1=new JTextField();
		JButton search=new JButton("Search");
		search.setSize(new Dimension(1,1));
		
		// search by radio button when the search button is pressed
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(Author.isSelected()){
				 a=store.listMatching(text1.getText(),Store.AUTHOR_SEARCH);
				 string=new String[a.size()];
				 for (int i=0;i<a.size();i++){
					 string[i]=a.get(i).getTitle();
				 }
				 jlist.setListData(string); 
				}
				else if(title.isSelected()){
					 a=store.listMatching(text1.getText(),Store.TITLE_SEARCH);
					 string=new String[a.size()];
					 for (int i=0;i<a.size();i++){
						 string[i]=a.get(i).getTitle();
					 }
					 jlist.setListData(string);
				}else if(media.isSelected()){
					a=store.listMatching( text1.getText(),Store.MEDIA_SEARCH);
					 string=new String[a.size()];
					 for (int i=0;i<a.size();i++){
						 string[i]=a.get(i).getTitle();
					 }
					 jlist.setListData(string);
				}
			}
		});
		
		panel1.add(text1,BorderLayout.NORTH);
		panel1.add(search,BorderLayout.SOUTH);
		
		jlist=new JList();
		
		//JComponent panel2= new JScrollPane(new JList(new String[] {"a", "b","C","D","E","F","G","G","h"}));
		JComponent panel2= new JScrollPane(jlist);
		// populate title ,author ,media and price textfield when the user select a particular book
		jlist.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				JList jl=  (JList) e.getSource();
				i =jl.getSelectedIndex();
				if(i<0){
					return;
				}
				//System.out.println(a.get(i));
				if (a.get(i).isForSale()){
					rent.setEnabled(false);
					buy.setEnabled(true);
				}else{
				buy.setEnabled(false);
				rent.setEnabled(true);}
				TextTitle.setText(a.get(i).getTitle());
				TextAuthor.setText(a.get(i).getAuthor());
				TextMedia.setText(a.get(i).getMedia());
				String b;
				TextPrice.setText(b=""+a.get(i).getCost());
			}
			
		});
		
		JPanel gridpanel=new JPanel();
		GridLayout grd= new GridLayout(4,2);
		gridpanel.setLayout(grd);
		gridpanel.add(  new JLabel("Title"));
		 TextTitle=new JTextField();
		gridpanel.add( TextTitle);
		gridpanel.add(  new JLabel("Author"));
		TextAuthor=new JTextField();
		gridpanel.add(TextAuthor);
		gridpanel.add(  new JLabel("Media Format"));
		 TextMedia=new JTextField();
		gridpanel.add(  TextMedia);
		
		gridpanel.add(  new JLabel("Price"));
		 TextPrice=new JTextField();
		gridpanel.add( TextPrice);		
		
		
		
		JPanel buyRentPanel= new JPanel();
		 buy=new JButton("Buy");
		buyRentPanel.add(buy);
		// populate the textfield for buying a particular book
		buy.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (a.get(i).isForSale()){
					 ((JTextComponent) textBox).setText("have bought "+a.get(i).getTitle()+ " for US$ "+a.get(i).getCost());
				}
				else
					((JTextComponent) textBox).setText("It is not for sale");
			}
			
		});
	    rent=new JButton("Rent");
		buyRentPanel.add( rent);
		// populate a particular textfield for renting a particular book
		rent.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				((JTextComponent) textBox).setText("have rent "+a.get(i).getTitle()+ " for US$ "+a.get(i).getCost());
				
				
			}
		});
		
		
		textBox=new JTextField();
		
		setLayout(new GridLayout(7,1));
		add(p);
		add(groupPanel);
		add(panel1);
		add(panel2);
		add(gridpanel);
		add(buyRentPanel);
		add(textBox);
	}
	public static void main(String []args) throws FileNotFoundException{
		
		 if ( args.length != 1 ) {
	            System.out.println( "Usage: java Store filename" );

	        } else {
                store = new Store();

	            // read the inventory, which may throw a FileNotFoundException.
	            store.fillInventory( args[0] );
	        }
	           
		BarneysBooks Book=new BarneysBooks(store);
		Book.pack();
		Book.setVisible(true);
		Book.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        
}
}