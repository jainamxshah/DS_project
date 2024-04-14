import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends JFrame implements ActionListener, MouseListener{

    JLabel mainname1,mainname2,mainname3,mainimg;
	JButton Sudoku,NQueens;

    Game(){
        this.setSize(900, 700);
        this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        
        Font f1=new Font("Algerian",Font.BOLD,80);
		Font f3=new Font("TimesRoman",Font.BOLD,30);

        mainname1=new JLabel("Game");
		mainname1.setForeground(Color.MAGENTA);
        mainname1.setBorder(null);
		mainname1.setLayout(null);
        mainname1.setBackground(Color.white);
		mainname1.setBounds(150,60,300,100);
		mainname1.setFont(f1);

        mainname2=new JLabel("Zone");
		mainname2.setForeground(Color.cyan);
        mainname2.setBorder(null);
		mainname2.setLayout(null);
        mainname2.setBackground(Color.white);
		mainname2.setBounds(410,60,300,100);
		mainname2.setFont(f1);
		
		mainimg=new JLabel();
		mainimg.setBorder(null);
		mainimg.setOpaque(false);
        mainimg.setBorder(null);
		mainimg.setLayout(null);
        mainimg.setBackground(Color.white);
		mainimg.setBounds(330,160,150,150);
		mainimg.setIcon(new ImageIcon("s2.png"));
		
		Sudoku=new JButton("Sudoku Solver");
		Sudoku.setLayout(null);
		Sudoku.setBounds(100,350,250,100);
        Sudoku.setBorder(null);
        Sudoku.setFocusable(false);
		Sudoku.setBackground(Color.YELLOW);
		Sudoku.setForeground(Color.black);
        Sudoku.setFont(f3); 
		Sudoku.addActionListener(this);
        Sudoku.addMouseListener(this);

		NQueens=new JButton("N Queens Solver");
		NQueens.setLayout(null);
		NQueens.setBounds(480,350,250,100);
        NQueens.setBorder(null);
        NQueens.setFocusable(false);
		NQueens.setBackground(Color.YELLOW);
		NQueens.setForeground(Color.black);
        NQueens.setFont(f3); 
		NQueens.addActionListener(this);
        NQueens.addMouseListener(this);
        
        this.add(mainname1);
        this.add(mainname2);
        this.add(mainimg);
        this.add(NQueens);
        this.add(Sudoku);
        
        this.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) 
	{  
		
    }  
    public void mouseEntered(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	if(EventSource.equals(Sudoku))
    	{
    		EventSource.setBackground(Color.cyan);
    		EventSource.setForeground(Color.MAGENTA);
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.white));
    	}

    	if(EventSource.equals(NQueens))
    	{
    		EventSource.setBackground(Color.cyan);
    		EventSource.setForeground(Color.MAGENTA);
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.white));
    	}
    } 
    public void mouseExited(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	if(EventSource.equals(Sudoku))
    	{
    		EventSource.setBackground(Color.yellow);
    		EventSource.setForeground(Color.black);
    		EventSource.setBorder(null);
    	}

    	if(EventSource.equals(NQueens))
    	{
    		EventSource.setBackground(Color.yellow);
    		EventSource.setForeground(Color.black);
    		EventSource.setBorder(null);
    		
    	}
    }  
    public void mousePressed(MouseEvent e) 
    {
    	
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    }

    public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==Sudoku){
			this.dispose();
			new HomePageSudoku();
			//new Game();
            
		}
		if(ae.getSource()==NQueens){
			this.dispose();
			new HomePageNQueens();
			//new Game();
		}
		
	}

    public static void main(String[] args) {
        new Game();
    }
}