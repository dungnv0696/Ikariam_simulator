/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.Timer;
import java.util.TimerTask;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.BattleField;
import model.BattleFieldFighting;
import model.RealArmy;
import model.Wall;

import ui.PanelBattlefield;
import ui.BattleFieldUI;

/**
 *
 * @author admin
 */
public class HouseInfoUI extends JDialog {

    JPanel pnMain, pnTitle, pnLvHou, pnLvWall, pnTypeOfHou, pnButton, pnLvForge, pnNameHouse; //them pnLvForge
    JLabel lblLvHou, lblLvWall, lblTypeOfHou, lblLvForge, lblNameHouse, lblTimeActive, lblTimeRemain, lblTittle1, lblTittle2; //them lblLvForge
    JLabel lblImg, lblTitle, lblImgTitle;
    JSlider sldLevelHouse, sldLevelWall;
    JTextField txtLevelHouse, txtLevelWall, txtNameHouse;
    JComboBox<String> cbTypeOfHou, cbLvForge; //Sua cbo -> cbTypeOfHou,them cbLvForge
    JButton btnDispose, btnPillage, btnBarrack, btnOK, btnBattleFighting, btnUpgradeUnit;

    public HouseInfoUI() throws HeadlessException {
        addControls();
        addEvents();
    }

    public void addControls() {
        Container con = getContentPane();
        con.setLayout(null);
        lblImgTitle = new JLabel(new ImageIcon(getClass().getResource("/Image/lblHouTitle.PNG")));
        lblImgTitle.setBounds(20, 0, 60, 60);
        con.add(lblImgTitle);

        pnMain = new JPanel(null);
        pnMain.setBounds(0, 30, 600, 500);
        pnMain.setBackground(new Color(253, 247, 221));

        pnTitle = new JPanel(null);
        pnTitle.setBounds(0, 0, 600, 20);
        pnTitle.setBackground(new Color(215, 172, 116));
        pnMain.add(pnTitle);
        lblTitle = new JLabel("House's Information");
        lblTitle.setBounds(250, 0, 125, 15);
        pnTitle.add(lblTitle);
        btnDispose = new JButton(new ImageIcon(getClass().getResource("/Image/xButton.PNG")));
        btnDispose.setBounds(580, 0, 20, 20);
        pnTitle.add(btnDispose);

        pnLvHou = new JPanel(null);
        pnLvHou.setBounds(0, 30, 600, 50);
        pnLvHou.setBackground(new Color(251, 232, 193));
        pnMain.add(pnLvHou);
        lblLvHou = new JLabel("Level of House");
        lblLvHou.setBounds(50, 15, 90, 20);
        pnLvHou.add(lblLvHou);
        sldLevelHouse = new JSlider(0, 40);
        sldLevelHouse.setBounds(180, 15, 300, 20);
        sldLevelHouse.setBackground(new Color(251, 232, 193));
        pnLvHou.add(sldLevelHouse);
        txtLevelHouse = new JTextField(40);
        txtLevelHouse.setBounds(500, 15, 20, 20);
        pnLvHou.add(txtLevelHouse);

        pnLvWall = new JPanel(null);
        pnLvWall.setBounds(0, 90, 600, 50);
        pnLvWall.setBackground(new Color(251, 232, 193));
        pnMain.add(pnLvWall);
        lblLvWall = new JLabel("Level of Wall");
        lblLvWall.setBounds(50, 15, 90, 20);
        pnLvWall.add(lblLvWall);
        sldLevelWall = new JSlider(0, 42);
        sldLevelWall.setBounds(180, 15, 300, 20);
        sldLevelWall.setBackground(new Color(251, 232, 193));
        pnLvWall.add(sldLevelWall);
        txtLevelWall = new JTextField(40);
        txtLevelWall.setBounds(500, 15, 20, 20);
        pnLvWall.add(txtLevelWall);

        //Fix cbo -> cbTypeOfHou
        pnTypeOfHou = new JPanel(null);
        pnTypeOfHou.setBounds(0, 150, 600, 50);
        pnTypeOfHou.setBackground(new Color(251, 232, 193));
        pnMain.add(pnTypeOfHou);
        lblTypeOfHou = new JLabel("Type of House");
        lblTypeOfHou.setBounds(50, 15, 90, 20);
        pnTypeOfHou.add(lblTypeOfHou);
        cbTypeOfHou = new JComboBox<>();
        cbTypeOfHou.setBounds(200, 15, 200, 20);
        cbTypeOfHou.addItem("My House");
        cbTypeOfHou.addItem("My Ally");
        cbTypeOfHou.addItem("Enemy");
        cbTypeOfHou.addItem("Moor");
        pnTypeOfHou.add(cbTypeOfHou);
        
        //Hien thi lua chon kich hoat lo
        pnLvForge = new JPanel(null);
        pnLvForge.setBounds(0, 210, 600, 50);
        pnLvForge.setBackground(new Color(251,232,193));
        pnMain.add(pnLvForge);
        lblLvForge = new JLabel("Hephaistos' Forge");
        lblLvForge.setBounds(50, 15, 150, 20);
        pnLvForge.add(lblLvForge);
        cbLvForge = new JComboBox<>();
        cbLvForge.setBounds(200, 15, 100, 20);
        cbLvForge.addItem("Inactive");
        cbLvForge.addItem("Level 1");
        cbLvForge.addItem("Level 2");
        cbLvForge.addItem("Level 3");
        cbLvForge.addItem("Level 4");
        cbLvForge.addItem("Level 5");
        pnLvForge.add(cbLvForge);
        lblTittle1 = new JLabel("Duration");
        lblTittle1.setBounds(350, 0, 100, 20);
        lblTittle2 = new JLabel("Cooldown");
        lblTittle2.setBounds(450, 0, 100, 20);
        pnLvForge.add(lblTittle1);
        pnLvForge.add(lblTittle2);
        lblTimeActive = new JLabel("-------------");
        lblTimeActive.setBounds(350, 20, 100, 20);
        lblTimeRemain = new JLabel("-------------");
        lblTimeRemain.setBounds(450, 20, 100, 20);
        pnLvForge.add(lblTimeActive);
        pnLvForge.add(lblTimeRemain);
        
        //Dat ten cho nha
        pnNameHouse = new JPanel(null);
        pnNameHouse.setBounds(0, 270, 300, 50);
        pnNameHouse.setBackground(new Color(251,232,193));
        pnMain.add(pnNameHouse);
        lblNameHouse = new JLabel("House's Name");
        lblNameHouse.setBounds(50, 15, 90, 20);
        pnNameHouse.add(lblNameHouse);
        txtNameHouse = new JTextField(10);
        txtNameHouse.setBounds(200, 15, 90, 20);
        pnNameHouse.add(txtNameHouse);

        btnPillage = new JButton();
        btnPillage.setBounds(50, 330, 50, 30);
        btnPillage.setIcon(new ImageIcon(getClass().getResource("/Image/Pillage_Enabled.PNG")));
        pnMain.add(btnPillage);

        btnBarrack = new JButton("Set Barrack");
        btnBarrack.setBounds(50, 370, 110, 30);
        btnBarrack.setBackground(new Color(248, 222, 164));
        pnMain.add(btnBarrack);

        btnBattleFighting = new JButton("Fighting");
        btnBattleFighting.setBounds(50, 410, 110, 30);
        btnBattleFighting.setBackground(new Color(248, 222, 164));
        pnMain.add(btnBattleFighting);

        btnUpgradeUnit = new JButton("Upgrade Unit");
        btnUpgradeUnit.setBounds(50, 450, 110, 30);
        btnUpgradeUnit.setBackground(new Color(248, 222, 164));
        pnMain.add(btnUpgradeUnit);

        lblImg = new JLabel(new ImageIcon(getClass().getResource("/Image/HouseInfo.PNG")));
        lblImg.setBounds(385, 330, 180, 180);
        pnMain.add(lblImg);

        btnOK = new JButton("OK");
        btnOK.setBounds(240, 450, 110, 30);
        btnOK.setBackground(new Color(248, 222, 164));
        pnMain.add(btnOK);

        con.add(pnMain);

    }

    public void addEvents() {
        this.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                sldLevelHouse.setValue(IsLandUI.currentHouse.getLevelOfHouse());
                sldLevelWall.setValue(IsLandUI.currentHouse.getLevelOfWall());
                cbTypeOfHou.setSelectedIndex(IsLandUI.currentHouse.getTypeOfHouse());
                txtNameHouse.setText(IsLandUI.currentHouse.getName());
                //them event lua chon cap do lo`
                cbLvForge.setSelectedIndex(IsLandUI.currentHouse.getLevelOfForge());
                if (IsLandUI.currentHouse.getTypeOfHouse() == 2) {
                    btnPillage.setEnabled(true);
                    btnPillage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Pillage_Enabled.PNG")));
                } else {
                    btnPillage.setEnabled(false);
                    btnPillage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Pillage_Disabled.PNG")));
                }
                if (IsLandUI.currentHouse.getBattleFieldFighting().isWar()) {
                    sldLevelHouse.setEnabled(false);
                    sldLevelWall.setEnabled(false);
                } else {
                    sldLevelHouse.setEnabled(true);
                    sldLevelWall.setEnabled(true);
                }
            }
        });

        btnDispose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        txtNameHouse.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent evt) {
        		String StringVal = txtNameHouse.getText();
        		if(StringVal.length() > 11)
        			txtNameHouse.setText(StringVal.substring(0, 11));
        		IsLandUI.currentHouse.setName(txtNameHouse.getText()); 
        	}
        });
        
        sldLevelHouse.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                txtLevelHouse.setText(String.valueOf(sldLevelHouse.getValue()));
            }
        });

        txtLevelHouse.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String StringVal = txtLevelHouse.getText();
                Integer IntVal = 0;
                try {
                    IntVal = Integer.valueOf(StringVal);
                } catch (NumberFormatException e) {
                    txtLevelHouse.setText("0");
                }
                if (IntVal < 0) {
                    txtLevelHouse.setText("0");
                } else if (IntVal >= 40) {
                    txtLevelHouse.setText("40");
                }
                sldLevelHouse.setValue(Integer.valueOf(txtLevelHouse.getText()));
            }
        });
        

        sldLevelWall.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                txtLevelWall.setText(String.valueOf(sldLevelWall.getValue()));
            }
        });

        txtLevelWall.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String StringVal = txtLevelWall.getText();
                Integer IntVal = 0;
                try {
                    IntVal = Integer.valueOf(StringVal);
                } catch (NumberFormatException e) {
                    txtLevelWall.setText("0");
                }
                if (IntVal < 0) {
                    txtLevelWall.setText("0");
                } else if (IntVal >= 40) {
                    txtLevelWall.setText("42");
                }
                sldLevelWall.setValue(Integer.valueOf(txtLevelWall.getText()));
            }
        });

        cbTypeOfHou.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (cbTypeOfHou.getSelectedIndex() == 3) {
                    sldLevelHouse.setValue(0);
                    sldLevelHouse.setValue(0);
                    sldLevelWall.setEnabled(false);
                    sldLevelHouse.setEnabled(false);
                    txtLevelHouse.setEnabled(false);
                    txtLevelWall.setEnabled(false);
                    btnBarrack.setEnabled(false);
                } else {
                    sldLevelHouse.setMinimum(1);
                    sldLevelWall.setMinimum(0);
                    sldLevelWall.setEnabled(true);
                    sldLevelHouse.setEnabled(true);
                    txtLevelHouse.setEnabled(true);
                    txtLevelWall.setEnabled(true);
                    btnBarrack.setEnabled(true);
                }
                if (cbTypeOfHou.getSelectedIndex() == 2) {
                    btnPillage.setEnabled(true);
                    btnPillage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Pillage_Enabled.PNG")));
                } else {
                    btnPillage.setEnabled(false);
                    btnPillage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Pillage_Disabled.PNG")));
                }
            }
        });
        
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setHouseInfo();
            }
        });
        btnPillage.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnPillage.setBorder(new BevelBorder(BevelBorder.RAISED));
            }

            public void mouseExited(MouseEvent evt) {
                btnPillage.setBorder(null);
            }

            public void mouseClicked(MouseEvent evt) {
                if (IsLandUI.myHouse == null) {
                    JOptionPane.showMessageDialog(null, "Chưa có các thông số của My house");
                } else {
//                    setHouseInfo();
                    setHouseInfo();
                    BattleFieldUI ui = new BattleFieldUI();
                    ui.showWindow();

                }
            }
        });
        btnBarrack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setHouseInfo();
                setBarrackInfo();
            }
        });
        btnBattleFighting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!IsLandUI.currentHouse.getBattleFieldFighting().isWar()) {
                    JOptionPane.showMessageDialog(null, "War haven't happened");
                } else {
//                    IsLandUI.bffUI = new BattleFieldFightingUI(IsLandUI.currentHouse.getBattleFieldFighting());
                    System.out.println("" + IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField().reserve.getArcher().size());
                    IsLandUI.bffUI = new BattleFieldFightingUI(IsLandUI.currentHouse.getBattleFieldFighting());
                    IsLandUI.bffUI.showWindow();

                }
            }
        });

        btnUpgradeUnit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setHouseInfo();
                UpgradeUnitUI upgradeUnit = new UpgradeUnitUI();
                upgradeUnit.showWindow();
            }
        });

        cbTypeOfHou.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (cbTypeOfHou.getSelectedItem().equals("My House")) {
                    IsLandUI.currentHouse.setTypeOfHouse(0);
                }
                if (cbTypeOfHou.getSelectedItem().equals("My Ally")) {
                    IsLandUI.currentHouse.setTypeOfHouse(1);
                }
                if (cbTypeOfHou.getSelectedItem().equals("Enemy")) {
                    IsLandUI.currentHouse.setTypeOfHouse(2);
                }
                if (cbTypeOfHou.getSelectedItem().equals("Moor")) {
                    IsLandUI.currentHouse.setTypeOfHouse(3);
                }
            }
        });

        //Them event khi chon lvForge
/*        cbLvForge.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (cbLvForge.getSelectedItem().equals("Inactive")) {
                    IsLandUI.currentHouse.setLevelOfForge(0);
                }
                if (cbLvForge.getSelectedItem().equals("Level 1")) {
                    IsLandUI.currentHouse.setLevelOfForge(1);
                }
                if (cbLvForge.getSelectedItem().equals("Level 2")) {
                    IsLandUI.currentHouse.setLevelOfForge(2);
                }
                if (cbLvForge.getSelectedItem().equals("Level 3")) {
                    IsLandUI.currentHouse.setLevelOfForge(3);
                }
                if (cbLvForge.getSelectedItem().equals("Level 4")) {
                    IsLandUI.currentHouse.setLevelOfForge(4);
                }
                if (cbLvForge.getSelectedItem().equals("Level 5")) {
                    IsLandUI.currentHouse.setLevelOfForge(5);
                }
            }
        });        
*/        
    }

    protected void setBarrackInfo() {
        SetUnitJDialog ui = new SetUnitJDialog();
        ui.showWindows();
    }

    //Set house's attributes
    protected void setHouseInfo() {
        IsLandUI.currentHouse.setLevelOfHouse(Integer.parseInt(txtLevelHouse.getText()));
        IsLandUI.currentHouse.setLevelOfWall(Integer.parseInt(txtLevelWall.getText()));
        IsLandUI.currentHouse.setName(txtNameHouse.getText());
//        Wall wall = new Wall(Integer.parseInt(txtLevelWall.getText()));

        if (!IsLandUI.currentHouse.getBattleFieldFighting().isWar()) {
            if (IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField() == null) {
                IsLandUI.currentHouse.getBattleFieldFighting().setAttackBattleField(
                        new BattleField(IsLandUI.currentHouse.getLevelOfHouse(), BattleField.TypeOfBattleField.ATTACK));
            } else {
                RealArmy realArmy = IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField().getReserve();
                IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField().resetAll(IsLandUI.currentHouse.getLevelOfHouse());
                IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField().setReserve(realArmy);
            }
            if (IsLandUI.currentHouse.getBattleFieldFighting().getDefenceBattleField() == null) {
                IsLandUI.currentHouse.getBattleFieldFighting().setDefenceBattleField(
                        new BattleField(IsLandUI.currentHouse.getLevelOfHouse(), BattleField.TypeOfBattleField.DEFENCE));
            } else {
                RealArmy realArmy = IsLandUI.currentHouse.getBattleFieldFighting().getDefenceBattleField().getReserve();
                IsLandUI.currentHouse.getBattleFieldFighting().getDefenceBattleField().resetAll(IsLandUI.currentHouse.getLevelOfHouse());
                IsLandUI.currentHouse.getBattleFieldFighting().getDefenceBattleField().setReserve(realArmy);
            }

        }
//        IsLandUI.currentHouse.setWall(wall);
//        if(!IsLandUI.currentHouse.getBattleField().isSetBattleField())
//            IsLandUI.currentHouse.getBattleField().resetAll(IsLandUI.currentHouse.getLevelOfHouse());
        String type = cbTypeOfHou.getSelectedItem().toString();
        if (type.equals("My House")) {
            IsLandUI.currentHouse.setTypeOfHouse(0);
            setIconHouse();
            IsLandUI.myHouse = IsLandUI.currentHouse;
        } else if (type.equals("My Ally")) {
            IsLandUI.currentHouse.setTypeOfHouse(1);
            setIconHouse();
        } else if (type.equals("Enemy")) {
            IsLandUI.currentHouse.setTypeOfHouse(2);
            setIconHouse();
        } else {
            IsLandUI.currentHouse.setTypeOfHouse(3);
            IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/flag.PNG")));
        }
        
        //Kich hoat lo
        String levelOfForge = cbLvForge.getSelectedItem().toString();
        SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
        long date = System.currentTimeMillis();
        Timer dongho = new Timer(1000, new ActionListener() {                   	
            public void actionPerformed(ActionEvent e) {                     	
                lblTimeActive.setText(ft.format(new Date(date+24*60*60*1000/MenuUI.speed-System.currentTimeMillis()-7*60*60*1000)));
                lblTimeRemain.setText(ft.format(new Date(date+7*24*60*60*1000/MenuUI.speed-System.currentTimeMillis()-7*60*60*1000)));
            }
        });
        if (levelOfForge.equals("Inactive")) {
            IsLandUI.currentHouse.setLevelOfForge(0);
        }
        if (levelOfForge.equals("Level 1")) {
            if(cbLvForge.isEnabled()) {
            	IsLandUI.currentHouse.setLevelOfForge(1);
            	dongho.start();
            	JOptionPane.showMessageDialog(null, "All combat units cause +10% damage");
            	IsLandUI.currentHouse.setIsUpgraded(true);
            }
            cbLvForge.setEnabled(false);
        }
        if (levelOfForge.equals("Level 2")) {
            if(cbLvForge.isEnabled()) {
            	IsLandUI.currentHouse.setLevelOfForge(2);
            	dongho.start();
            	JOptionPane.showMessageDialog(null, "All combat units receive +1 armor and cause +10% damage");
            	IsLandUI.currentHouse.setIsUpgraded(true);
            }
            cbLvForge.setEnabled(false);
        }
        if (levelOfForge.equals("Level 3")) {          
            if(cbLvForge.isEnabled()) {
            	IsLandUI.currentHouse.setLevelOfForge(3);
            	dongho.start();
            	JOptionPane.showMessageDialog(null, "All combat units receive +1 armor and cause +15% damage");
            	IsLandUI.currentHouse.setIsUpgraded(true);
            }
            cbLvForge.setEnabled(false);
        }
        if (levelOfForge.equals("Level 4")) {          
            if(cbLvForge.isEnabled()) {
            	IsLandUI.currentHouse.setLevelOfForge(4);
            	dongho.start();
            	JOptionPane.showMessageDialog(null, "All combat units receive +2 armor and cause +15% damage");
            	IsLandUI.currentHouse.setIsUpgraded(true);
            }
            cbLvForge.setEnabled(false);
        }
        if (levelOfForge.equals("Level 5")) {          
            if(cbLvForge.isEnabled()) {
            	IsLandUI.currentHouse.setLevelOfForge(5);
            	dongho.start();
            	JOptionPane.showMessageDialog(null, "All combat units 	receive +2 armor and cause +20% damage");
            	IsLandUI.currentHouse.setIsUpgraded(true);
            }
            cbLvForge.setEnabled(false);
        }        
        int lv = IsLandUI.currentHouse.getLevelOfForge();
        IsLandUI.currentHouse.setDamageForge(lv);
        IsLandUI.currentHouse.setArmourForge(lv);      
        
        IsLandUI.currentTextField.setText(IsLandUI.currentHouse.getName());
        IsLandUI.currentTextField.setVisible(true);
        this.dispose();

    }

    private void setIconHouse() {
    	int typeOfHouse = IsLandUI.currentHouse.getTypeOfHouse();
        if (IsLandUI.currentHouse.getLevelOfHouse() == 1) {
            IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/House/"+typeOfHouse+"houseLv1.PNG")));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 2 && IsLandUI.currentHouse.getLevelOfHouse() <= 3) {
            IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/House/"+typeOfHouse+"houseLv2.PNG")));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 4 && IsLandUI.currentHouse.getLevelOfHouse() <= 6) {
            IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/House/"+typeOfHouse+"houseLv4.PNG")));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 7 && IsLandUI.currentHouse.getLevelOfHouse() <= 9) {
            IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/House/"+typeOfHouse+"houseLv7.PNG")));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 10 && IsLandUI.currentHouse.getLevelOfHouse() <= 12) {
            IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/House/"+typeOfHouse+"houseLv10.PNG")));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 13 && IsLandUI.currentHouse.getLevelOfHouse() <= 15) {
            IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/House/"+typeOfHouse+"houseLv13.PNG")));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() == 16 || IsLandUI.currentHouse.getLevelOfHouse() == 17) {
            IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/House/"+typeOfHouse+"houseLv16.PNG")));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 18) {
            IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/House/"+typeOfHouse+"houseLv18+.PNG")));
        }
    }

    //Show the HouseInfoUI dialog
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
