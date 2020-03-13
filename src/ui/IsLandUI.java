/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.House;

/**
 *
 * @author Dat Ngo
 */
public class IsLandUI extends JFrame{
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, 
    btnWaveAttack, btnXspeed, btnMenu;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15, txt16, txt17;
    JLabel lblIsLand;
    public static JButton currentButton;
    public static House currentHouse;
    public static JTextField currentTextField;
    public HouseInfoUI houseInfoUI;
    public static House[] house;
    public static House myHouse;
    public static MenuUI menuUI;
    public static BattleFieldFightingUI bffUI;
    
    public IsLandUI(String title){
        super(title);
        house = new House[18];
        currentHouse = new House();
        currentButton = new JButton();
        houseInfoUI = new HouseInfoUI();
        for(int i=1; i<18; i++){
            house[i] = new House();
            if (house[i].getName().equals(""))
            	house[i].setName("Ikariam"+i);
            house[i].setId(i);
        }
        addControls();
        addEvents();
    }
    
    public void addControls(){
        Container con = getContentPane();
        
        JPanel pnMain = new JPanel();
        pnMain.setLayout(null);
        con.add(pnMain);
        
        btn1 = new MyJButtonFlag();
        btn1.setBounds(160, 190, 70, 70);
        txt1 = new JTextField();
        txt1.setBounds(160, 260, 70, 15);
        txt1.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt1.setEditable(false);
        txt1.setVisible(false);
        pnMain.add(btn1);
        pnMain.add(txt1);
        
        btn2 = new MyJButtonFlag();
        btn2.setBounds(265, 205, 70 ,70);
        txt2 = new JTextField();
        txt2.setBounds(265, 275, 70, 15);
        txt2.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt2.setEditable(false);
        txt2.setVisible(false);
        pnMain.add(txt2);
        pnMain.add(btn2);
        
        btn3 = new MyJButtonFlag();
        btn3.setBounds(345, 165, 70 ,70);
        txt3 = new JTextField();
        txt3.setBounds(345, 235, 70, 15);
        txt3.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt3.setEditable(false);
        txt3.setVisible(false);
        pnMain.add(txt3);
        pnMain.add(btn3);
        
        btn4 = new MyJButtonFlag();
        btn4.setBounds(455, 100, 70 ,70);
        txt4 = new JTextField();
        txt4.setBounds(455, 170, 70, 15);
        txt4.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt4.setEditable(false);
        txt4.setVisible(false);
        pnMain.add(txt4);
        pnMain.add(btn4);
        
        btn5 = new MyJButtonFlag();
        btn5.setBounds(745, 140, 70 ,70);
        txt5 = new JTextField();
        txt5.setBounds(745, 210, 70, 15);
        txt5.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt5.setEditable(false);
        txt5.setVisible(false);
        pnMain.add(txt5);
        pnMain.add(btn5);
        
        btn6 = new MyJButtonFlag();
        btn6.setBounds(635, 85, 70 ,70);
        txt6 = new JTextField();
        txt6.setBounds(635, 155, 70, 15);
        txt6.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt6.setEditable(false);
        txt6.setVisible(false);
        pnMain.add(txt6);
        pnMain.add(btn6);
        
        btn7 = new MyJButtonFlag();
        btn7.setBounds(120, 280, 70 ,70);
        txt7 = new JTextField();
        txt7.setBounds(120, 350, 70, 15);
        txt7.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt7.setEditable(false);
        txt7.setVisible(false);
        pnMain.add(txt7);
        pnMain.add(btn7);
        
        btn8 = new MyJButtonFlag();
        btn8.setBounds(100, 420, 70 ,70);
        txt8 = new JTextField();
        txt8.setBounds(100, 490, 70, 15);
        txt8.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt8.setEditable(false);
        txt8.setVisible(false);
        pnMain.add(txt8);
        pnMain.add(btn8);
        
        btn9 = new MyJButtonFlag();
        btn9.setBounds(320, 435, 70 ,70);
        txt9 = new JTextField();
        txt9.setBounds(320, 505, 70, 15);
        txt9.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt9.setEditable(false);
        txt9.setVisible(false);
        pnMain.add(txt9);
        pnMain.add(btn9);
        
        btn10 = new MyJButtonFlag();
        btn10.setBounds(210, 460, 70 ,70);
        txt10 = new JTextField();
        txt10.setBounds(210, 530, 70, 15);
        txt10.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt10.setEditable(false);
        txt10.setVisible(false);
        pnMain.add(txt10);
        pnMain.add(btn10);
        
        btn11 = new MyJButtonFlag();
        btn11.setBounds(360, 525, 70 ,70);
        txt11 = new JTextField();
        txt11.setBounds(360, 595, 70, 15);
        txt11.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt11.setEditable(false);
        txt11.setVisible(false);
        pnMain.add(txt11);
        pnMain.add(btn11);
        
        btn12 = new MyJButtonFlag();
        btn12.setBounds(585, 495, 70 ,70);
        txt12 = new JTextField();
        txt12.setBounds(585, 565, 70, 15);
        txt12.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt12.setEditable(false);
        txt12.setVisible(false);
        pnMain.add(txt12);
        pnMain.add(btn12);
        
        btn13 = new MyJButtonFlag();
        btn13.setBounds(700, 440, 70 ,70);
        txt13 = new JTextField();
        txt13.setBounds(700, 510, 70, 15);
        txt13.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt13.setEditable(false);
        txt13.setVisible(false);
        pnMain.add(txt13);
        pnMain.add(btn13);
        
        btn14 = new MyJButtonFlag();
        btn14.setBounds(810, 420, 70 ,70);
        txt14 = new JTextField();
        txt14.setBounds(810, 490, 70, 15);
        txt14.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt14.setEditable(false);
        txt14.setVisible(false);
        pnMain.add(txt14);
        pnMain.add(btn14);
        
        btn15 = new MyJButtonFlag();
        btn15.setBounds(810, 330, 70 ,70);
        txt15 = new JTextField();
        txt15.setBounds(810, 400, 70, 15);
        txt15.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt15.setEditable(false);
        txt15.setVisible(false);
        pnMain.add(txt15);
        pnMain.add(btn15);
        
        btn16 = new MyJButtonFlag();
        btn16.setBounds(785, 240, 70 ,70);
        txt16 = new JTextField();
        txt16.setBounds(785, 310, 70, 15);
        txt16.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt16.setEditable(false);
        txt16.setVisible(false);
        pnMain.add(txt16);
        pnMain.add(btn16);
        
        btn17 = new MyJButtonFlag();
        btn17.setBounds(660, 240, 70 ,70);
        txt17 = new JTextField();
        txt17.setBounds(660, 320, 70, 15);
        txt17.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        txt17.setEditable(false);
        txt17.setVisible(false);
        pnMain.add(txt17);
        pnMain.add(btn17);
        
        btnWaveAttack = new JButton("");
        btnWaveAttack.setBounds(775, 10, 70, 100);
        btnWaveAttack.setOpaque(false);
        btnWaveAttack.setContentAreaFilled(false);
        btnWaveAttack.setBorder(null);
        pnMain.add(btnWaveAttack);
        
        btnMenu = new MenuButton();
        btnMenu.setBounds(410,10,160,30);
        pnMain.add(btnMenu);
        
        lblIsLand = new JLabel();
        lblIsLand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/island.jpg")));
        pnMain.add(lblIsLand);
        lblIsLand.setBounds(0, 10, 1000, 665);
        
    }
    
    public void addEvents(){
        btnWaveAttack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(myHouse!=null)
                    new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy()).setVisible(true);
            }
        });
        
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[1];
                currentButton = btn1;
                currentTextField = txt1;
                houseInfoUI.showWindow();
            }
        });
        
        
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[2];
                currentButton = btn2;
                currentTextField = txt2;
                houseInfoUI.showWindow();
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[3];
                currentButton = btn3;
                currentTextField = txt3;
                houseInfoUI.showWindow();
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[4];
                currentButton = btn4;
                currentTextField = txt4;
                houseInfoUI.showWindow();
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[5];
                currentButton = btn5;
                currentTextField = txt5;
                houseInfoUI.showWindow();
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[6];
                currentButton = btn6;
                currentTextField = txt6;
                houseInfoUI.showWindow();
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[7];
                currentButton = btn7;
                currentTextField = txt7;
                houseInfoUI.showWindow();
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[8];
                currentButton = btn8;
                currentTextField = txt8;
                houseInfoUI.showWindow();
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[9];
                currentButton = btn9;
                currentTextField = txt9;
                houseInfoUI.showWindow();
            }
        });
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[10];
                currentButton = btn10;
                currentTextField = txt10;
                houseInfoUI.showWindow();
            }
        });
        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[11];
                currentButton = btn11;
                currentTextField = txt11;
                houseInfoUI.showWindow();
            }
        });
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[12];
                currentButton = btn12;
                currentTextField = txt12;
                houseInfoUI.showWindow();
            }
        });
        btn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[13];
                currentButton = btn13;
                currentTextField = txt13;
                houseInfoUI.showWindow();
            }
        });
        btn14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[14];
                currentButton = btn14;
                currentTextField = txt14;
                houseInfoUI.showWindow();
            }
        });
        btn15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[15];
                currentButton = btn15;
                currentTextField = txt15;
                houseInfoUI.showWindow();
            }
        });
        btn16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[16];
                currentButton = btn16;
                currentTextField = txt16;
                houseInfoUI.showWindow();
            }
        });
        btn17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[17];
                currentButton = btn17;
                currentTextField = txt17;
                houseInfoUI.showWindow();
            }
        });
        
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	menuUI = new MenuUI();
            	currentButton = btnMenu;
            	menuUI.showWindow();
            }
        });
    }
    
    public void showWindow(){
        setSize(1000, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }          
    
}
