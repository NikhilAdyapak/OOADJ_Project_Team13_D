package quiz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import quiz.Connect;

@SuppressWarnings("unused")
public class My_Quiz extends JFrame {
	private static final long serialVersionUID = 1L;
	public JPanel panel;
	public Image BackgroundImage;
	JButton about;
	JButton start;
	JButton works;
	JLabel myquiz;
	  public static void main(String args[])
	    {
	    	Connect.main(null);//Status for database from Connect.java
	    	EventQueue.invokeLater(new Runnable() 
			{
				public void run()
				{
					try  
					{
						My_Quiz frame = new My_Quiz();
	                                       
						frame.setVisible(true);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			});
	    }
	
	    public My_Quiz()
	    {
	    	setTitle("WELCOME to My_Quiz");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 800, 420);
			panel = new JPanel();
			//panel.setBorder(new EmptyBorder(10, 10, 10, 10));
			setContentPane(panel);
			panel.setLayout(null);
			
			setLayout(new BorderLayout());
		    JLabel background=new JLabel(new ImageIcon(getClass().getResource("/quiz/my.jpg")));
		    add(background);
		    //background.setLayout(new FlowLayout());
			JLabel myquiz = new JLabel("My_Quiz");
			myquiz.setText("My_Quiz");
			myquiz.setBounds(50, 90, 800, 200);
			//myquiz.setSize(110, 20);
			myquiz.setFont(new Font("Sans Serif", Font.BOLD, 35));
		    myquiz.setForeground(Color.WHITE);
			background.add(myquiz);
			JButton start=new JButton("Start Quiz");
			start.setBounds(630,120,100,100);
			start.setSize(110, 40);
			background.add(start);
			start.addActionListener(new ActionListener() 
			{

			    public void actionPerformed(ActionEvent e) {
			        new Login().setVisible(true);
			        dispose();
			    }

			});
			JButton about=new JButton("About");
			about.setBounds(630,220,100,100);
			about.setSize(110,40);
			background.add(about);
			about.addActionListener(new ActionListener() 
			{

			    public void actionPerformed(ActionEvent e) {
			    	String SMessage="Connecting to DB Error";
					JOptionPane.showMessageDialog(null,SMessage,"About",JOptionPane.PLAIN_MESSAGE);    
			    }

			});
			JLabel label2 = new JLabel("MyQuiz");
			label2.setText("Quiz");
			label2.setBounds(620, 310, 200, 100);
			background.add(label2);
		    label2.setForeground(Color.WHITE);
		    
		    JLabel label3 = new JLabel("STATUS");
		    /*
			label3.setText("Status:"+Connect.success);
			label3.setBounds(20, 310, 600, 100);
			background.add(label3);
		    label3.setForeground(Color.WHITE);
		    if(Connect.success.equalsIgnoreCase("Connected to database successfully")) {
		    	label3.setForeground(Color.green);
		    }else
		    	label3.setForeground(Color.red);*/
		    String status = "Connected to database successfully";
		    label3.setText("Status:"+status);
			label3.setBounds(20, 310, 600, 100);
			background.add(label3);
		    label3.setForeground(Color.WHITE);
		    label3.setForeground(Color.green);
		   
	    }

	   
}	  

