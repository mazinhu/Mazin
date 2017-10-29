package Minesweeper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TheMine extends JFrame {
	private final int hGap = 5;
	private final int vGap = 5;
	private JButton buttonclicked;
	//private JButton squares[][];
	private JButton[] gridButtons = new JButton[10 * 10];
	 static String easyString = "Easy";
	    static String mediumString = "Medium";
	    static String hardString = "Hard";


	public static void main(String[] args) {
		TheMine themine = new TheMine();
		MineView.View();
		themine.setResizable(true);
		themine.pack();
		//themine.setSize(700,400);
		themine.setVisible(true);
		themine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
