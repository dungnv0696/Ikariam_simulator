/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JDialog;
import javax.swing.JFrame;

import model.Army;
import model.House;
import model.RealArmy;
import model.SendingArmy;
import model.SentArmy;
/**
 *
 * @author Dat Ngo
 */
public class PnWaveAttack extends JPanel {
    //  public static JLabel lblMissionTitle, lblArrivalTimeTitle, lblMunitionTitle, lblUnitTitle, lblOriginTitle, lblTargetTitle, lblActionTitle;

    private JLabel lblMission, lblArrivalTime, lblMunition, lblUnit, lblOrigin, lblTarget, lblMissionName;
    private JButton btnDirection, btnAction;
    private int timeRound;
    SentArmy sentArmy;
    int id;
    SendingArmy sendingArmy;
    PriorityQueue<SendingArmy> sendingArmys;
    
    public PnWaveAttack(SentArmy sentArmy, int id) {
    	
        lblMission = new JLabel();
        lblArrivalTime = new JLabel();
        lblMunition = new JLabel();
        lblUnit = new JLabel();
        lblOrigin = new JLabel();
        lblTarget = new JLabel();
        lblMissionName = new JLabel();
        btnAction = new JButton();
        this.sentArmy = sentArmy;
        this.id = id;
        setSize(820, 65);
        setLayout(null);
        addControl();
        addEvents();
    }

    public PnWaveAttack(SendingArmy sendingArmy, int id, PriorityQueue pq) {
    	
        lblMission = new JLabel();
        lblArrivalTime = new JLabel();
        lblMissionName = new JLabel();
        lblMunition = new JLabel();
        lblUnit = new JLabel();
        lblOrigin = new JLabel();
        lblTarget = new JLabel();
        btnAction = new JButton();
        this.sendingArmy = sendingArmy;
        this.id = id;
        this.sendingArmys = pq;
        setSize(820, 65);
        setLayout(null);
        addControl();
        addEvents();
    }

    private void addControl() {
        this.setBackground(new Color(251,232,193));
        lblMission.setBounds(10, 0, 100, 50);
        lblMission.setIcon(new ImageIcon(getClass().getResource("/Image/Pillage_Enabled.PNG")));
        lblArrivalTime.setBounds(135, -5, 150, 30);
        lblArrivalTime.setText("Test1");
        lblMissionName.setBounds(120, 10, 150, 30);
        lblMissionName.setText("Test2");
        lblMunition.setBounds(240, 10, 100, 30);
        lblMunition.setText(""); 
        lblUnit.setBounds(340, 10, 100, 30);
        lblUnit.setText("Test3");
        lblOrigin.setBounds(450, 10, 100, 30);
        lblOrigin.setText("Test4");
        lblTarget.setBounds(560, 10, 100, 30);
        lblTarget.setText("Test5");
        btnAction.setBounds(670, 10, 50, 35);
        btnAction.setIcon(new ImageIcon(getClass().getResource("/Image/wave.PNG")));
        this.add(lblMission);
        this.add(lblArrivalTime);
        this.add(lblMunition);
        this.add(lblUnit);
        this.add(lblOrigin);
        this.add(lblTarget);
        this.add(btnAction);
        this.add(lblMissionName);
        
        
    }

    private void addEvents() {
        SentArmy sentArmy1 = this.sentArmy;
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           	
                if (sentArmy1 != null && sentArmy1.getRealArmy()!=null) {
                    if (IsLandUI.house[id].getWaitingWaveAttack() == null) {
                        IsLandUI.house[id].setWaitingWaveAttack(new ArrayList<RealArmy>());
                    }
                    IsLandUI.house[id].getWaitingWaveAttack().add(sentArmy1.getRealArmy());
                    IsLandUI.myHouse.getSentRealArmy().get(id).remove(sentArmy1);
                    
                }
                else{
                    sendingArmy.getTimer().cancel();
                    IsLandUI.myHouse.getSendingArmy().get(id).remove(sendingArmy);  
                    Timer timer = new Timer();                          
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            IsLandUI.myHouse.getArmy().addArmy(sendingArmy.getArmy());
                            JOptionPane.showMessageDialog(null, "Sending Army Come Back Home!");
                        }
                    },sendingArmy.getFinishTime() - sendingArmy.getStartTime()); //Thoi gian rut quan khi dang di quan den nha dich    
                }              
            }
        });
    }

    public JLabel getLblMission() {
        return lblMission;
    }

    public void setLblMission(JLabel lblMission) {
        this.lblMission = lblMission;
    }
    
    public JLabel getLblMissionName() {
        return lblMissionName;
    }

    public void setLblMissionName(JLabel lblMissionName) {
        this.lblMission = lblMissionName;
    }

    public JLabel getLblArrivalTime() {
        return lblArrivalTime;
    }

    public void setLblArrivalTime(JLabel lblArrivalTime) {
        this.lblArrivalTime = lblArrivalTime;
    }

    public JLabel getLblMunition() {
        return lblMunition;
    }

    public void setLblMunition(JLabel lblMunition) {
        this.lblMunition = lblMunition;
    }

    public JLabel getLblUnit() {
        return lblUnit;
    }

    public void setLblUnit(JLabel lblUnit) {
        this.lblUnit = lblUnit;
    }

    public JLabel getLblOrigin() {
        return lblOrigin;
    }

    public void setLblOrigin(JLabel lblOrigin) {
        this.lblOrigin = lblOrigin;
    }

    public JLabel getLblTarget() {
        return lblTarget;
    }

    public void setLblTarget(JLabel lblTarget) {
        this.lblTarget = lblTarget;
    }

    public JButton getBtnDirection() {
        return btnDirection;
    }

    public void setBtnDirection(JButton btnDirection) {
        this.btnDirection = btnDirection;
    }

    public JButton getBtnAction() {
        return btnAction;
    }

    public void setBtnAction(JButton btnAction) {
        this.btnAction = btnAction;
    }

}
