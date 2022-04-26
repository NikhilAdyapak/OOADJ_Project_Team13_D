package quiz;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("unused")
public class MCQTwo implements Question
{
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private JPanel contentPane; 
	private JButton Next;
	private JButton Back;
	private ButtonGroup opg;
	private JRadioButton op1;
	private JRadioButton op2;
	private JRadioButton op3;
	private JRadioButton op4;
	private JLabel question;
	@SuppressWarnings("unused")
	private JLabel username;
	@SuppressWarnings("unused")
	private JSeparator separator;
	 String[][] a;
	 String[][] q;
	static int score=0;
	int count=0;
	int c=0;
	static String usernameq;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			@SuppressWarnings("unused")
			public void run()
			{
				try 
				{
					MCQTwo frame = new MCQTwo();
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	public MCQTwo() {
        score=0;
        
        Game();
      q =new String[10][5];
      //MCQTwo are stored in q[][]
      
      q[6][0]=" Cohesion and coupling are represented by using a…";
      q[6][1]="structure part";
      q[6][2]="structure effect";
      q[6][3]="dependence matrix";
      q[6][4]="all of these";
      
      q[7][0]="The vertical dimension of a sequence diagram shows";
      q[7][1]="abstract";
      q[7][2]="line";
      q[7][3]="time";
      q[7][4]="messages";
      
      q[8][0]="To hide the internal implementation of an object we use a…";
      q[8][1]="inheritance";
      q[8][2]="encapsulation";
      q[8][3]="polymorphism";
      q[8][4]="none of these";
      
      q[9][0]="CRC approach and noun phrase approach are used to identify a…";
      q[9][1]="classes";
      q[9][2]="collaborators";
      q[9][3]="use cases";
      q[9][4]="objects";
      //Answers are stored in a[][]
      a=new String[10][5];
      a[6][1]="dependence matrix";
      a[6][2]="structure effect";
      a[7][1]="time";
      a[7][2]="messages";
      a[8][1]="encapsulation";
      a[8][2]="polymorphism";
      a[9][1]="classes";
      a[9][2]="objects";
     


      start(0);
	}
	 
	 public String[][] qarray() {
	        return q.clone();
	    }
	 public String[][] ansarray() {
	        return a.clone();
	    }
	public void Game()
	{	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(null);
		
		//Initializations
		opg=new ButtonGroup();
		op1=new JRadioButton();
		op2=new JRadioButton();
		op3=new JRadioButton();
		op4=new JRadioButton();
		question=new JLabel();
		username=new JLabel();
		separator=new JSeparator();
		Next=new JButton();
		Back=new JButton();

        final JLabel timer = new JLabel("01:00");
        final Timer t = new Timer(1000, new ActionListener() {
            int time = 60;
            public void actionPerformed(ActionEvent e) {
            	
                time--;
                timer.setText(format(time / 60) + ":" + format(time % 60));
                if(c==10) {
                    final Timer timer = (Timer) e.getSource();
                	timer.stop();
                }else {
                if (time == 0) {
                	if(c>=10) {
                    final Timer timer = (Timer) e.getSource();
                    timer.stop();
                	}else {
                    JOptionPane.showMessageDialog(null,"Time Up Click Ok To Check Your Score","bye..",JOptionPane.ERROR_MESSAGE);
                    System.out.println(score);
                    final Timer timer = (Timer) e.getSource();
        			timer.stop();
                }
                }
            }
            }
            
        });
        t.start();

        opg.add(op1);
        op1.setText("option1");
        op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1Selected(evt);
            }

		
        });

        opg.add(op2);
        op2.setText("option2");
        op2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op2selected(evt);
            }

		
        });

        opg.add(op3);
        op3.setText("option3");
        op3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op3selected(evt);
            }

        });

        opg.add(op4);
        op4.setText("option4");
        op4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op4selected(evt);
            }

			
        });

        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("question");
        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextClicked(evt);
            }

        });
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClicked(evt);
            }

        });
	
	//GUI
        
                    	}    

	

	protected void BackClicked(ActionEvent evt) {
		// TODO Auto-generated method stub
		if(c==0) {
			
		}else {
			if(score==c)
			{
		score--;
		c--;
		start(c);
			}
			else {
				c--;
				start(c);
			}
		}
		
	}
	protected void NextClicked(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		if(getSelectedButtonText(opg)==a[c][1]) {
			score++;
			count++;
			c++;
		}
		else
		{
			c++;
			count++;
		}
			if(c!=10)
		{
			start(c);
		System.out.println(score);
		}
		else {
			System.out.println(score);
		}
	}
	protected void op4selected(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
	protected void op3selected(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
	protected void op2selected(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
	protected void op1Selected(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
	String getSelectedButtonText(ButtonGroup buttonGroup) {
		    for (Enumeration<?> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
		        AbstractButton button = (AbstractButton) buttons.nextElement();

		        if (button.isSelected()) {
		            return button.getText();
		        }
		    }
		    return null;
	}
	public void start(int i) {
		
		 question.setText(q[i][0]);
	        op1.setText(q[i][1]);
	        op2.setText(q[i][2]);
	        op3.setText(q[i][3]);
	        op4.setText(q[i][4]);
	        opg.clearSelection();

	        


		
	}
	private static String format(int i) {
        String result = String.valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }
	

		 }
