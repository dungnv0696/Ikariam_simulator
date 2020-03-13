package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.House;
import ui.IsLandUI;

public class MenuUI extends JDialog {
    JPanel pnMain, pnTitle, pnXspeed, pnResetSpeed;
    JLabel lblTitle, lblXspeed;
    JTextField txtXspeed;
    JButton btnReturn, btnXspeed, btnResetSpeed, btnSetMax;
    public static int speed=30;
    
    public	MenuUI() throws HeadlessException {
        addControls();
        addEvents();
    }

    public void addControls() {
        Container con = getContentPane();
        con.setLayout(null);
        
        pnMain = new JPanel(null);
        pnMain.setBounds(0, 30, 600, 500);
        pnMain.setBackground(new Color(253, 247, 221));
        
        pnTitle = new JPanel(null);
        pnTitle.setBounds(0, 0, 600, 20);
        pnTitle.setBackground(new Color(215, 172, 116));
        pnMain.add(pnTitle);
        lblTitle = new JLabel("Main Menu");
        lblTitle.setBounds(270, 0, 125, 15);
        pnTitle.add(lblTitle);
        
        //Xspeed
        pnXspeed = new JPanel(null);
        pnXspeed.setBounds(0, 50, 600, 50);
        pnXspeed.setBackground(new Color(251, 232, 193));
        pnMain.add(pnXspeed);
        lblXspeed = new JLabel("Speed: ");
        lblXspeed.setBounds(100, 15, 60, 20);
        pnXspeed.add(lblXspeed);
        txtXspeed = new JTextField(30);
        txtXspeed.setBounds(160, 15, 30, 20);
        pnXspeed.add(txtXspeed);
        btnXspeed = new JButton();
        btnXspeed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/improve.png")));
        btnXspeed.setBounds(210, 12, 77, 24);
        pnXspeed.add(btnXspeed);
        
        //Reset Speed	
        btnResetSpeed = new JButton("Reset");
        btnResetSpeed.setBounds(390, 12, 77, 24);
        btnResetSpeed.setBackground(new Color(248, 222, 164));
        pnXspeed.add(btnResetSpeed);
        
        //SetMaxSpeed
        btnSetMax = new JButton("Max");
        btnSetMax.setBounds(300, 12, 77, 24);
        btnSetMax.setBackground(new Color(248, 222, 164));
        pnXspeed.add(btnSetMax);
        
        btnReturn = new JButton("Return to Island");
        btnReturn.setBounds(230, 450, 140, 40);
        btnReturn.setBackground(new Color(248, 222, 164));
        pnMain.add(btnReturn);
        
        con.add(pnMain);
    }
    
    public void addEvents() {
    	
        this.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt){
            	txtXspeed.setText(String.valueOf(speed));      
            }
        });
    	
    	btnXspeed.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(speed < 60){
                	if (speed==59)
                		speed+=1;
                	else
                		speed+=2;
                }
                txtXspeed.setText(String.valueOf(speed));
            }
    	});
    	
        txtXspeed.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                Integer intValue = 0;
                try{
                    intValue = Integer.valueOf(txtXspeed.getText());
                }catch(Exception ex){
                	txtXspeed.setText("");
                }
                if(intValue < 0)
                	txtXspeed.setText("0");
                else if(intValue > 60)
                	txtXspeed.setText("60");
                speed = Integer.valueOf(txtXspeed.getText());
            }
        });
        
        btnSetMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speed=60;
                txtXspeed.setText(String.valueOf(speed));
            }
        });
        
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        btnResetSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	speed=1;
            	txtXspeed.setText(String.valueOf(speed));
            }
        });
	}    

    public void showWindow() {
        this.setSize(600, 530);
        setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //pnTranparent.setOpaque(false);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setVisible(true);
    }
}