package tictaktoe;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ticktacktoe extends JPanel implements ActionListener{
	Random random = new Random();
	JPanel tittle_pannel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JFrame frame = new JFrame();
	JButton[] buttons = new JButton[9];
	boolean player_turn;
Ticktacktoe(){
	frame.getContentPane().setBackground(new Color (50,50,50));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setSize(600,600);
	frame.setResizable(true);
	frame.setLocation(0, 100);
	
	frame.getContentPane().setBackground(new Color (50,50,50));
	textfield .setBackground(new Color(25,25,25));
	textfield.setForeground(new Color(25,255,0));
	textfield.setFont(new Font("Helvetica", Font.BOLD, 75));
	textfield.setHorizontalAlignment(JLabel.CENTER);
	textfield.setText("Tak-tac-toe");
	textfield.setOpaque(true);
	tittle_pannel.setLayout(new BorderLayout());
	tittle_pannel.setBounds(0,0,800,100);
	
	button_panel.setLayout(new GridLayout(3,3));
	button_panel.setBackground(new Color(125,125,125));
	for(int i =0; i<9;i++) {
		buttons[i] = new JButton();
		button_panel.add(buttons[i]);
		buttons[i].setFont(new Font("MV Boli", Font.BOLD, 125));
		buttons[i].setFocusable(false);
		buttons[i].addActionListener(this);
	}
	
	tittle_pannel.add(textfield);
	frame.add(tittle_pannel,BorderLayout.NORTH);
	frame.add(button_panel);
	firstTurn();
}
	@Override
	public void actionPerformed(ActionEvent e) {
for(int i= 0;i<9;i++) {
	if(e.getSource()==buttons[i]) {
		if(player_turn) {
			if(buttons[i].getText()=="") {
				buttons[i].setForeground(new Color(255,0,0));
				buttons[i].setText("X");
				player_turn=false;
				textfield.setText("O turn");
				check();
			}
		}else {
			
				if(buttons[i].getText()=="") {
					buttons[i].setForeground(new Color(0,0,255));
					buttons[i].setText("O");
					player_turn=true;
					textfield.setText("X turn");
					check();
				}
		}
	}
	}}
	
	public void firstTurn(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(random.nextInt(2)==0) {
			player_turn=true;
			textfield.setText("X turn");
		}else {
			player_turn=false;
			textfield.setText("O turn");	
		}
	}
//check winner 
	public void check() {
	//check if first row won
		if((buttons[0].getText()=="X"&&
				buttons[1].getText()=="X"&&
				buttons[2].getText()=="X")) {
			xWins(0,1,2);
		}
		if((buttons[3].getText()=="X"&&
				buttons[4].getText()=="X"&&
				buttons[5].getText()=="X")) {
			xWins(3,4,5);
		}
		if((buttons[6].getText()=="X"&&
				buttons[7].getText()=="X"&&
				buttons[8].getText()=="X")) {
			xWins(6,7,8);
		}
		if((buttons[0].getText()=="X"&&
				buttons[3].getText()=="X"&&
				buttons[6].getText()=="X")) {
			xWins(0,3,6);
		}
		if((buttons[1].getText()=="X"&&
				buttons[4].getText()=="X"&&
				buttons[7].getText()=="X")) {
			xWins(1,4,7);
		}
		if((buttons[2].getText()=="X"&&
				buttons[5].getText()=="X"&&
				buttons[8].getText()=="X")) {
			xWins(2,5,8);
		}
		if((buttons[0].getText()=="X"&&
				buttons[4].getText()=="X"&&
				buttons[8].getText()=="X")) {
			xWins(0,4,8);
		}
		if((buttons[2].getText()=="X"&&
				buttons[4].getText()=="X"&&
				buttons[6].getText()=="X")) {
			xWins(2,4,6);
		}
		//if o wins
		if((buttons[0].getText()=="O"&&
				buttons[1].getText()=="O"&&
				buttons[2].getText()=="O")) {
			oWins(0,1,2);
		}
		if((buttons[3].getText()=="O"&&
				buttons[4].getText()=="O"&&
				buttons[5].getText()=="O")) {
			oWins(3,4,5);
		}
		if((buttons[6].getText()=="O"&&
				buttons[7].getText()=="O"&&
				buttons[8].getText()=="O")) {
			oWins(6,7,8);
		}
		if((buttons[0].getText()=="O"&&
				buttons[3].getText()=="O"&&
				buttons[6].getText()=="O")) {
			oWins(0,3,6);
		}
		if((buttons[1].getText()=="O"&&
				buttons[4].getText()=="O"&&
				buttons[7].getText()=="O")) {
			oWins(1,4,7);
		}
		if((buttons[2].getText()=="O"&&
				buttons[5].getText()=="O"&&
				buttons[8].getText()=="O")) {
			oWins(2,5,8);
		}
		if((buttons[0].getText()=="O"&&
				buttons[4].getText()=="O"&&
				buttons[8].getText()=="O")) {
			oWins(0,4,8);
		}
		if((buttons[2].getText()=="O"&&
				buttons[4].getText()=="O"&&
				buttons[6].getText()=="O")) {
			oWins(2,4,6);}
	}
	public void xWins(int a,int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for(int i = 0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
	}
public void oWins(int a,int b, int c) {
	buttons[a].setBackground(Color.GREEN);
	buttons[b].setBackground(Color.GREEN);
	buttons[c].setBackground(Color.GREEN);
	for(int i = 0;i<9;i++) {
		buttons[i].setEnabled(false);
	}
	textfield.setText("O wins");
	}
}
