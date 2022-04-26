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
public class MCQOne implements Question
{
	
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
	private JLabel username;
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
			public void run()
			{
				try 
				{
					@SuppressWarnings("unused")
					MCQOne frame = new MCQOne();
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	public MCQOne() {
        score=0;
        
        Game();
      q =new String[10][5];
      //MCQOne are stored in q[][]
      q[0][0]="To distunguish between active and non-active object which property is applied?";
      q[0][1]="abstraction";
      q[0][2]="polymophism";
      q[0][3]="concurrency";
      q[0][4]="aggregation";
      
      q[1][0]="Refinement is a process of";
      q[1][1]="inheritance";
      q[1][2]="colaboration";
      q[1][3]="elaboration";
      q[1][4]="polymophism";
      
      q[2][0]="Object-Oriented Modelling allows";
      q[2][1]="Higher productivity";
      q[2][2]="lower maintenance cost";
      q[2][3]="better quality can be achieved";
      q[2][4]="All of the above";
      
      q[3][0]="During the design phase, the overall  of the system is described.";
      q[3][1]="Architecture";
      q[3][2]="System flow";
      q[3][3]="Data flow";
      q[3][4]="None";
      
      q[4][0]="Aggregation is ";
      q[4][1]="set of relationship";
      q[4][2]="composed of relationship";
      q[4][3]="part of relationship";
      q[4][4]="all of these";
      
      q[5][0]="A model is a _________ of reality.";
      q[5][1]="Complication";
      q[5][2]="Simplification";
      q[5][3]="Realization";
      q[5][4]="Generalization";
      //Answers are stored in a[][]
      a=new String[10][5];
      a[0][1]="concurrency";
      a[1][1]="elaboration";
      a[2][1]="All of the above";
      a[3][1]="Architecture";
      a[4][1]="composed of relationship";
      a[5][1]="Simplification";
     


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
