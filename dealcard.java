/*U10316029
 * 郭政慶
 */
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dealcard extends JFrame implements ActionListener{
	private ImageIcon[] cards = new  ImageIcon[52]; //Create a array to store 52 images
	static JButton button = new JButton("Refresh");//Create a button "ReFresh"
	int mycard[] = new int[4];
	int deck[] = new int[52];
	JLabel cardJLabel1;
	JLabel cardJLabel2;
	JLabel cardJLabel3;
	JLabel cardJLabel4;
	
	public dealcard(){
		shuffle();//Shuffle the cards
		print();//Print the cards
		button.addActionListener(this);//Register the listener with the button
	} 
	
	public void print(){
		setLayout(new GridLayout(1,4,5,5));//Set GridLayout, 1 row, 4 columns,and gaps 5 between components horizontally and vertically
		//Add labels with images to the frame  
		cardJLabel1= new JLabel(cards[mycard[0]]);
		add(cardJLabel1);
		
		cardJLabel2	= new JLabel(cards[mycard[1]]);
		add(cardJLabel2);
		
		cardJLabel3 = new JLabel(cards[mycard[2]]);
		add(cardJLabel3);
		
		cardJLabel4 = new JLabel(cards[mycard[3]]);
		add(cardJLabel4);
	}
	
	public void shuffle(){   
		   String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
		   String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9","10", "Jack", "Queen", "King"};
		    // Initialize cards
		   for (int i = 0; i < deck.length; i++){
			   deck[i] = i;
		   }
		    // Shuffle the cards
		   for (int i = 0; i < deck.length; i++) {
		   // Generate an index randomly
			   int index = (int)(Math.random() * deck.length);
			   int temp = deck[i];
			   deck[i] = deck[index]; 
			   deck[index] = temp;
		   }
		   // Display the first four cards
		   for (int i = 0; i < 4; i++) {
			   mycard[i] = deck[i];
		   }
		   for(int i=1; i <= 52; i++ ){
			   cards[i-1] = createImageIcon("images/"+i+".png");//Assign 52 images to the array
		   }		
	}
	
	@Override/**Implement actionPerformed*/
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button){
			shuffle();
			//Change 4 images to the labels
			cardJLabel1.setIcon(cards[mycard[0]]);
			cardJLabel2.setIcon(cards[mycard[1]]);
			cardJLabel3.setIcon(cards[mycard[2]]);
			cardJLabel4.setIcon(cards[mycard[3]]);
		}  
	}
	
	protected ImageIcon createImageIcon(String path){//Get the image path
	        java.net.URL imgURL=getClass().getResource(path);
	        if(imgURL!=null)
	            return new ImageIcon(imgURL);
	        else
	            System.out.println("couldn't find file "+path);
	        return null;
	}  
	
	/** Main method */    
	public static void main(String[] args) {
		dealcard frame = new dealcard();
		frame.setSize(800,500);//Set the frame size
		frame.setVisible(true);//Display the frame
		frame.setTitle("Pick Your Card");//Set the frame title
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);//Make the frame unable to change size
		frame.setLayout(null);//Let us change button's size or location 
		
		button.setBounds(frame.getWidth()/2-100, frame.getHeight()-100, 200, 50);//Set the button's size and location
		frame.add(button);//Add a button to the frame
	}
}
