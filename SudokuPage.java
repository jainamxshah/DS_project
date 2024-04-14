import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SudokuPage extends JFrame implements ActionListener, MouseListener {
    
    String lab;
	static int[][] mat;
	static int[][] chk;
	JButton Solveit,reset,isValid,Exit;
	static JLabel msg;
	JTextArea note;
	static JTextField[][] num;

    SudokuPage(){

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900, 700);
        this.setVisible(false);
        this.getContentPane().setBackground(Color.BLACK);
        
        Font f1=new Font("Arial",Font.BOLD,25);
		Font f2=new Font("Arial",Font.PLAIN,20);
        
        mat=new int[9][9];
		chk=new int[9][9];
		num= new JTextField[9][9];
        for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
                num[i][j]=new JTextField();
				num[i][j].setBounds(50+(j*70),50+(i*70),50,50);
				num[i][j].setLayout(null);
				num[i][j].setFont(f1);
				num[i][j].setText("");
				num[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.white));
				num[i][j].setHorizontalAlignment(JTextField.CENTER);
                num[i][j].setForeground(Color.cyan);
                num[i][j].addKeyListener(new KeyAdapter() {
		            public void keyTyped(KeyEvent e) {
		                char caracter = e.getKeyChar();
		                if (((caracter < '1') || (caracter > '9'))
		                        && (caracter != '\b')) {
		                    e.consume();
		                }
		            }
		        });

                if((i>=3 && i<=5) || (j>=3 && j<=5))
				{
					num[i][j].setBackground(Color.GRAY);
				}
				else
				{
					num[i][j].setBackground(Color.DARK_GRAY);
				}
				add(num[i][j]);
            }
        }

        Solveit=new JButton("Solve");
		Solveit.setBounds(700,250,150,70);
		Solveit.setForeground(Color.black);
		Solveit.setBorder(null);
		Solveit.setBackground(Color.GREEN);
		Solveit.setFocusable(false);
		Solveit.setFocusPainted(false);
		Solveit.setLayout(null);
		Solveit.setFont(new Font("TimesRoman",Font.BOLD,25));
		Solveit.addActionListener(this);
		Solveit.addMouseListener(this);

        isValid=new JButton("Valid?");
        isValid.setBounds(700,330,150,70);
		isValid.setForeground(Color.black);
		isValid.setBorder(null);
		isValid.setBackground(Color.GREEN);
		isValid.setFocusable(false);
		isValid.setFocusPainted(false);
		isValid.setLayout(null);
		isValid.setFont(new Font("TimesRoman",Font.BOLD,25));
		isValid.addActionListener(this);
		isValid.addMouseListener(this);

		
		reset=new JButton("Reset");
		reset.setBounds(700,410,150,70);
		reset.setForeground(Color.black);
		reset.setBorder(null);
		reset.setBackground(Color.GREEN);
		reset.setFocusable(false);
		reset.setFocusPainted(false);
		reset.setLayout(null);
		reset.setFont(new Font("TimesRoman",Font.BOLD,25));
		reset.addActionListener(this);
		reset.addMouseListener(this);

		Exit=new JButton("Exit");
		Exit.setBounds(700,550,150,70);
		Exit.setForeground(Color.black);
		Exit.setBorder(null);
		Exit.setBackground(Color.GREEN);
		Exit.setFocusable(false);
		Exit.setFocusPainted(false);
		Exit.setLayout(null);
		Exit.setFont(new Font("TimesRoman",Font.BOLD,25));
		Exit.addActionListener(this);
		Exit.addMouseListener(this);
		
		note=new JTextArea();
		note.setBounds(690,100,200,250);
		note.setForeground(Color.yellow);
		note.setBorder(null);
		note.setOpaque(false);
		note.setFocusable(false);
		note.setLayout(null);
		note.setFont(f2);
		note.setText("          Note:\n Please Enter only \n One Digit Numbers ");
		
		msg=new JLabel();
		msg.setBounds(700,460,200,100);
		msg.setForeground(Color.magenta);
		msg.setOpaque(false);
		msg.setBorder(null);
		msg.setLayout(null);
		msg.setFont(f2);
		msg.setText("Not Solve Yet!");
		
		add(Solveit);
        add(isValid);
		add(note);
		add(msg);
		add(reset);
		add(Exit);
    }
    public static boolean isVal()	//checks if single digit,fills th value,if value not given,fills 0
	{
		int f=0;
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(num[i][j].getText().length()>1)
				{
					f=1;
					break;
				}
				if(num[i][j].getText().equals(""))
				{
					mat[i][j]=0;
					chk[i][j]=0;
				}
				else
				{
					mat[i][j]=Integer.parseInt(num[i][j].getText());
					chk[i][j]=Integer.parseInt(num[i][j].getText());
				}
			}
			if(f==1)
			{
				break;
			}
		}
		if(f==1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
    public static void printIt()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(chk[i][j]==mat[i][j])
				{
					
				}
				else
				{
					num[i][j].setForeground(Color.RED);
					num[i][j].setText(""+mat[i][j]);
				}
				num[i][j].setEditable(false);
			}
		}
		
	}
    public static boolean solveSudoku(int[][] board, int n)  
	{ 
		int row = 0; 
		int col = 0; 
		boolean isEmpty = true; 
		for (int i = 0; i < n; i++) 
		{ 
			for (int j = 0; j < n; j++)  
			{ 
				if (board[i][j] == 0)  
				{ 
				row = i; 
				col = j; 
				isEmpty = false;  
				break; 
				} 
			} 
			if (!isEmpty) 
			{ 
				break; 
			} 
		} 
		if (isEmpty)  
		{ 
		return true; 
		} 
		
		for (int num = 1; num <= n; num++) 
		{ 
			if (isSafe(board, row, col, num)) 
			{ 
				board[row][col] = num; 
				if (solveSudoku(board, n))  
				{  
					return true; 
				}  
				else
				{ 
					board[row][col] = 0; 
				} 
			} 
		} 
		return false; 
	} 
    public static boolean isSafe(int[][] board,int row, int col,int num)  
	{ 
		//Checks Column
		for (int d = 0; d < board.length; d++)  
		{ 
			if (board[row][d] == num)  
			{ 
			return false; 
			} 
		} 
		
		//Checks Row
		for (int r = 0; r < board.length; r++) 
		{ 
			if (board[r][col] == num) 
			{ 
			return false; 
			} 
		} 
		
		//Checks 3x3 Matrix 
		int boxRowStart = row - row % 3; 
		int boxColStart = col - col % 3; 
		
		for (int r = boxRowStart;r < boxRowStart + 3; r++)  
		{ 
			for (int d = boxColStart;d < boxColStart + 3; d++)  
			{ 
				if (board[r][d] == num)  
				{ 
					return false; 
				} 
			} 
		} 
		return true; 
	} 
	public static void resets()
	{
		msg.setText("Not Solve Yet!");
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				mat[i][j]=0;
				chk[i][j]=0;
				num[i][j].setEditable(true);
				num[i][j].setForeground(Color.cyan);
				num[i][j].setText("");
			}
		}
	}
	public static boolean isValidmat()
	{
		HashSet<Integer> set=new HashSet<Integer>(); 
		//checks Column
		for(int i=0;i<9;i++)
		{
			set=new HashSet<Integer>(); 
			for(int j=0;j<9;j++)
			{
				if(mat[i][j]!=0)
				{
					int s=set.size();
					set.add(mat[i][j]);
					if(set.size()==s)
					{
						return false;
					}
				}
			}
		}

		//Checks Row
		for(int i=0;i<9;i++)
		{
			set=new HashSet<Integer>(); 
			for(int j=0;j<9;j++)
			{
				if(mat[j][i]!=0)
				{
					int s=set.size();
					set.add(mat[j][i]);
					if(set.size()==s)
					{
						return false;
					}
				}
			}
		}

		//Checks 3x3 Matrix
		for(int i=0;i<9;i+=3)
		{
			for(int j=0;j<9;j+=3)
			{
				set=new HashSet<Integer>(); 
				for(int r=i;r<i+3;r++)
				{
					for(int c=j;c<j+3;c++)
					{
						if(mat[r][c]!=0)
						{
							int s=set.size();
							set.add(mat[r][c]);
							if(set.size()==s)
							{
								return false;
							}
						}
					}
				}
			}
		}
		return true;
		
	}
    public void actionPerformed(ActionEvent ae)
	{
		
		lab=ae.getActionCommand();
        if(lab.equals("Valid?")){
            if(isVal() && isValidmat())
			{
				msg.setText("Valid Move!");  
			}
			else
			{
				msg.setText("Not Valid Move!");
			}
        }
		else if(lab.equals("Solve"))
		{
			if(isVal() && isValidmat())
			{
				if (solveSudoku(mat, 9)) 
			    { 
			        printIt();
			        msg.setText("Solved Successfully!");
			    }  
			    else
			    { 
			        msg.setText("No Solution");
			    } 
			    
			}
			else
			{
				msg.setText("Something wrong!");
			}
		}
		else if(lab.equals("Reset"))
		{
			resets();
		}
		else if(lab.equals("Exit")){
			this.dispose();
			new Game();
		}
	}
	public void mouseClicked(MouseEvent e) 
	{  
		
    }  
    public void mouseEntered(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	if(EventSource.equals(Solveit))
    	{
    		EventSource.setBackground(Color.cyan);
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.white));
    	}
    	else if(EventSource.equals(reset))
    	{
    		EventSource.setBackground(Color.cyan);
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.white));
    	}
    	else if(EventSource.equals(isValid))
    	{
    		EventSource.setBackground(Color.cyan);
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.white));
    	}
    } 
    public void mouseExited(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	if(EventSource.equals(Solveit))
    	{
    		EventSource.setBackground(Color.green);
    		EventSource.setBorder(null);
    	}
    	else if(EventSource.equals(reset))
    	{
    		EventSource.setBackground(Color.green);
    		EventSource.setBorder(null);
    	}
    }  
    public void mousePressed(MouseEvent e) 
    {
    	
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    }
    /* public static void main(String[] args) {
        SudokuPage s=new SudokuPage();
    } */
}
