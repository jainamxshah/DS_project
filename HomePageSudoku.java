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

public class HomePageSudoku extends JFrame implements ActionListener,MouseListener{
    
    String lab;
	JLabel mainname1,mainname2,mainname3,mainimg;
	JButton play;

    HomePageSudoku(){

		this.setSize(900, 700);
        this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        
        Font f1=new Font("Algerian",Font.BOLD,80);
		Font f3=new Font("TimesRoman",Font.BOLD,30);

        mainname1=new JLabel("Sudoku");
		mainname1.setForeground(Color.MAGENTA);
        mainname1.setBorder(null);
		mainname1.setLayout(null);
        mainname1.setBackground(Color.white);
		mainname1.setBounds(70,60,500,100);
		mainname1.setFont(f1);

        mainname2=new JLabel("Solver");
		mainname2.setForeground(Color.cyan);
        mainname2.setBorder(null);
		mainname2.setLayout(null);
        mainname2.setBackground(Color.white);
		mainname2.setBounds(430,60,400,100);
		mainname2.setFont(f1);
		
		mainimg=new JLabel();
		mainimg.setBorder(null);
		mainimg.setOpaque(false);
        mainimg.setBorder(null);
		mainimg.setLayout(null);
        mainimg.setBackground(Color.white);
		mainimg.setBounds(330,160,150,150);
		mainimg.setIcon(new ImageIcon("s2.png"));
		
		play=new JButton("Play");
		play.setLayout(null);
		play.setBounds(290,350,200,100);
        play.setBorder(null);
        play.setFocusable(false);
		play.setBackground(Color.YELLOW);
		play.setForeground(Color.black);
        play.setFont(f3); 
		play.addActionListener(this);
		play.addMouseListener(this);
        
        this.add(mainname1);
        this.add(mainname2);
        this.add(mainimg);
        this.add(play);
        
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==play){
			SudokuPage sp=new SudokuPage();
			sp.setVisible(true);
			//System.out.println("dfghj");
			this.dispose();
		}
		
	}
	public void mouseClicked(MouseEvent e) 
	{  
		
    }  
    public void mouseEntered(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	if(EventSource.equals(play))
    	{
    		EventSource.setBackground(Color.cyan);
    		EventSource.setForeground(Color.MAGENTA);
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.white));
    	}
    } 
    public void mouseExited(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	if(EventSource.equals(play))
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

}