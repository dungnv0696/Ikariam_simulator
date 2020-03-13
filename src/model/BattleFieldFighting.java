/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import model.unit.Archer;
import model.unit.BalloonBombardier;
import model.unit.Catapult;
import model.unit.Gyrocopter;
import model.unit.Hoplite;
import model.unit.Mortar;
import model.unit.Ram;
import model.unit.Slinger;
import model.unit.Spearman;
import model.unit.SteamGiant;
import model.unit.SulphurCarabineer;
import model.unit.Swordsman;
import ui.BattleFieldFightingUI;
import ui.IsLandUI;
import ui.MenuUI;

/**
 *
 * @author GBlue
 */
public class BattleFieldFighting {

    private BattleField attackBattleField, defenceBattleField;
    private boolean war;
    private int houseID;
    public static int round=0;
    boolean wallHaventExisted=false;

    public BattleFieldFighting(int houseID) {
        this.houseID = houseID;
        war = false;
    }

    public void startAttack() {
    	round++;  	
        int houseID = this.houseID;
        
        if(IsLandUI.house[houseID].getIsUpgraded()) {
        	defenceBattleField.forgeUpgrade(houseID);
        	IsLandUI.house[houseID].setIsUpgraded(false);
        }
        if(IsLandUI.myHouse.getIsUpgraded()) {
        	attackBattleField.forgeUpgrade(IsLandUI.myHouse.getId());
        	IsLandUI.myHouse.setIsUpgraded(false);
        }
    	
        int totalHitpointDefenceBefore = defenceBattleField.getTotalHitpoint();
        attackBattleField.makeArtilleryAttack(defenceBattleField);
        attackBattleField.makeAirDefenseAttack(defenceBattleField);
        attackBattleField.makeBombersAttack(defenceBattleField);
        attackBattleField.makeFlanksAttack(defenceBattleField);
        attackBattleField.makeFrontLineAttack(defenceBattleField);
        attackBattleField.makeLongRangeAttack(defenceBattleField);
        defenceBattleField.makeArtilleryAttack(attackBattleField);
        defenceBattleField.makeAirDefenseAttack(attackBattleField);
        defenceBattleField.makeBombersAttack(attackBattleField);
        defenceBattleField.makeFlanksAttack(attackBattleField);
        defenceBattleField.makeFrontLineAttack(attackBattleField);
        defenceBattleField.makeLongRangeAttack(attackBattleField);
        int totalHitpointDefenceAfter = defenceBattleField.getTotalHitpoint();
        if (IsLandUI.bffUI == null) {
            IsLandUI.bffUI = new BattleFieldFightingUI(this);
        } else {
            IsLandUI.bffUI.resetBattleFieldFightingUI(this);
        }

        Timer timer = new Timer();


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(totalHitpointDefenceAfter == totalHitpointDefenceBefore) {
                    if (defenceBattleField.isAllDead()) {
                    	if(!defenceBattleField.haveWall()) {
                    		JOptionPane.showMessageDialog(null, "You Won "+IsLandUI.house[houseID].getName());
                    		war = false;
                    		Timer timer1 = new Timer();
                    		timer1.schedule(new TimerTask() {
                    			@Override
                    			public void run() {
                    				IsLandUI.myHouse.getArmy().addArmy(attackBattleField.getReserve().toArmy());
                    				JOptionPane.showMessageDialog(null, "Units came back home");
                    				IsLandUI.myHouse.getSentRealArmy().clear();
                    				attackBattleField.getReserve().getArcher().clear();
                    				attackBattleField.getReserve().getBB().clear();
                    				attackBattleField.getReserve().getCatapult().clear();
                    				attackBattleField.getReserve().getGyrocopter().clear();
                    				attackBattleField.getReserve().getHop().clear();
                    				attackBattleField.getReserve().getMortar().clear();
                    				attackBattleField.getReserve().getRam().clear();
                    				attackBattleField.getReserve().getSC().clear();
                    				attackBattleField.getReserve().getSlinger().clear();
                    				attackBattleField.getReserve().getSpear().clear();
                    				attackBattleField.getReserve().getSteam().clear();
                    				attackBattleField.getReserve().getSword().clear();
                    			}
                    		}, attackBattleField.getReserve().toArmy().getSpeedTimeForWholeRoute()/MenuUI.speed); //Thoi gian quan tro ve sau khi thang'
                    	}
                    	else {
                    		JOptionPane.showMessageDialog(null, "You Can't Do Any Damage To Wall");
                    	}
                    }	
                    else {
                    JOptionPane.showMessageDialog(null, "Enemy "+IsLandUI.house[houseID].getName()+" won");
                    IsLandUI.myHouse.getSentRealArmy().clear();
                    }
                }
                else {
                
                    attackBattleField.setUnitsBackToReserve();
                    defenceBattleField.setUnitsBackToReserve();

                for (int j = 0; j < IsLandUI.house[houseID].getWaitingWaveAttack().size(); j++) {
                    Army army = new Army();
                    RealArmy realArmy = IsLandUI.house[houseID].getWaitingWaveAttack().get(j);

                    for (int i = 0; i < realArmy.getArcher().size(); i++) {
                        if (attackBattleField.reserve.getArcher().contains(realArmy.getArcher().get(i))) {
                            Archer archer = realArmy.getArcher().get(i);                       
                            attackBattleField.reserve.getArcher().remove(archer);
                            army.setNumberOfArcher(army.getNumberOfArcher() + 1);
                        }
                    }

                    for (int i = 0; i < realArmy.getBB().size(); i++) {
                        if (attackBattleField.reserve.getBB().contains(realArmy.getBB().get(i))) {
                            BalloonBombardier bb = realArmy.getBB().get(i);
                            attackBattleField.reserve.getBB().remove(bb);
                            army.setNumberOfBB(army.getNumberOfBB() + 1);
                        }
                    }
                    for (int i = 0; i < realArmy.getCatapult().size(); i++) {
                        if (attackBattleField.reserve.getCatapult().contains(realArmy.getCatapult().get(i))) {
                            Catapult catapult = realArmy.getCatapult().get(i);
                            attackBattleField.reserve.getCatapult().remove(catapult);
                            army.setNumberOfCatapult(army.getNumberOfCatapult() + 1);
                        }
                    }
                    for (int i = 0; i < realArmy.getGyrocopter().size(); i++) {
                        if (attackBattleField.reserve.getGyrocopter().contains(realArmy.getGyrocopter().get(i))) {
                            Gyrocopter gy = realArmy.getGyrocopter().get(i);
                            attackBattleField.reserve.getGyrocopter().remove(gy);
                            army.setNumberOfGyrocopter(army.getNumberOfGyrocopter() + 1);
                        }
                    }
                    for (int i = 0; i < realArmy.getHop().size(); i++) {
                        if (attackBattleField.reserve.getHop().contains(realArmy.getHop().get(i))) {
                            Hoplite hop = realArmy.getHop().get(i);
                            attackBattleField.reserve.getHop().remove(hop);
                            army.setNumberOfHop(army.getNumberOfHop() + 1);
                        }
                    }
                    for (int i = 0; i < realArmy.getMortar().size(); i++) {
                        if (attackBattleField.reserve.getMortar().contains(realArmy.getMortar().get(i))) {
                            Mortar mortar = realArmy.getMortar().get(i);
                            attackBattleField.reserve.getMortar().remove(mortar);
                            army.setNumberOfMotar(army.getNumberOfMotar() + 1);
                        }
                    }
                    for (int i = 0; i < realArmy.getRam().size(); i++) {
                        if (attackBattleField.reserve.getRam().contains(realArmy.getRam().get(i))) {
                            Ram ram = realArmy.getRam().get(i);
                            attackBattleField.reserve.getRam().remove(ram);
                            army.setNumberOfRam(army.getNumberOfRam() + 1);
                        }
                    }
                    for (int i = 0; i < realArmy.getSC().size(); i++) {
                        if (attackBattleField.reserve.getSC().contains(realArmy.getSC().get(i))) {
                            SulphurCarabineer sul = realArmy.getSC().get(i);
                            attackBattleField.reserve.getSC().remove(sul);
                            army.setNumberOfSC(army.getNumberOfSC() + 1);
                        }
                    }
                    for (int i = 0; i < realArmy.getSlinger().size(); i++) {
                        if (attackBattleField.reserve.getSlinger().contains(realArmy.getSlinger().get(i))) {
                            Slinger slinger = realArmy.getSlinger().get(i);
                            attackBattleField.reserve.getSlinger().remove(slinger);
                            army.setNumberOfSlinger(army.getNumberOfSlinger() + 1);
                        }
                    }
                    for (int i = 0; i < realArmy.getSpear().size(); i++) {
                        if (attackBattleField.reserve.getSpear().contains(realArmy.getSpear().get(i))) {
                            Spearman spear = realArmy.getSpear().get(i);
                            attackBattleField.reserve.getSpear().remove(spear);
                            army.setNumberOfSpear(army.getNumberOfSpear() + 1);
                        }
                    }
                    for (int i = 0; i < realArmy.getSteam().size(); i++) {
                        if (attackBattleField.reserve.getSteam().contains(realArmy.getSteam().get(i))) {
                            SteamGiant steam = realArmy.getSteam().get(i);                           
                            attackBattleField.reserve.getSteam().remove(steam);
                            army.setNumberOfSteam(army.getNumberOfSteam() + 1);
                        }
                    }
                    for (int i = 0; i < realArmy.getSword().size(); i++) {
                        if (attackBattleField.reserve.getSword().contains(realArmy.getSword().get(i))) {
                            Swordsman sword = realArmy.getSword().get(i);                       
                            attackBattleField.reserve.getSword().remove(sword);
                            army.setNumberOfSword(army.getNumberOfSword() + 1);
                        }
                    }
                    

                    Timer timer1 = new Timer();
                    timer1.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            IsLandUI.myHouse.getArmy().addArmy(army);
                            JOptionPane.showMessageDialog(null, "Wave Success!");
                        }
                    },(60*60*1000 + army.getSpeedTimeForWholeRoute())/MenuUI.speed); // <=>thoi gian tan ra = 1h + thoi gian di quan
                }
                
                IsLandUI.house[houseID].getWaitingWaveAttack().clear();
                if (attackBattleField.isAllDead()) {
                    war = false;
                    IsLandUI.house[houseID].getArmy().addArmy(defenceBattleField.getReserve().toArmy());
                    JOptionPane.showMessageDialog(null, "Enemy "+IsLandUI.house[houseID].getName()+" won");
                } else if (defenceBattleField.isAllDead()) {
                    war = false;
                    Timer timer1 = new Timer();
                    timer1.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            IsLandUI.myHouse.getArmy().addArmy(attackBattleField.getReserve().toArmy());
                            JOptionPane.showMessageDialog(null, "Units came back home");
                            IsLandUI.myHouse.getSentRealArmy().clear();
                            attackBattleField.getReserve().getArcher().clear();
                            attackBattleField.getReserve().getBB().clear();
                            attackBattleField.getReserve().getCatapult().clear();
                            attackBattleField.getReserve().getGyrocopter().clear();
                            attackBattleField.getReserve().getHop().clear();
                            attackBattleField.getReserve().getMortar().clear();
                            attackBattleField.getReserve().getRam().clear();
                            attackBattleField.getReserve().getSC().clear();
                            attackBattleField.getReserve().getSlinger().clear();
                            attackBattleField.getReserve().getSpear().clear();
                            attackBattleField.getReserve().getSteam().clear();
                            attackBattleField.getReserve().getSword().clear();
                        }
                    }, attackBattleField.getReserve().toArmy().getSpeedTimeForWholeRoute()/MenuUI.speed); //Thoi gian quan tro ve sau khi thang'
                    JOptionPane.showMessageDialog(null, "You won "+IsLandUI.house[houseID].getName());
                } else {
                	IsLandUI.house[houseID].setNumberOfUnit(defenceBattleField.getReserve().toArmy());
                	if(IsLandUI.house[houseID].getNumberOfUnit() >= IsLandUI.house[houseID].getGarrisonLimit()) {
                		attackBattleField.addToField(false, false);
                		defenceBattleField.addToField(false, false);
                		wallHaventExisted = true;
                	}
                	else {
                		if (wallHaventExisted) {
                			defenceBattleField.setFrontBackToReserve();
                			Stack<Wall> walls = new Stack<>();
                			for (int i = 0; i < defenceBattleField.getNumberOfSlotForHI(); i++) {
                				walls.add(new Wall(IsLandUI.house[houseID].getLevelOfWall()));
                			}              		
                			defenceBattleField.getReserve().setWall(walls);             			
                		}     		
                		wallHaventExisted = false;
            			boolean isAllWall = defenceBattleField.isAllWall();
                		attackBattleField.addToField(false,false);
                		defenceBattleField.addToField(isAllWall,true);             		
                	}
                	//JOptionPane.showMessageDialog(null, defenceBattleField.getReserve().getArcher().get(1).getDamage());
                	//JOptionPane.showMessageDialog(null, defenceBattleField.isUpgraded+" "+attackBattleField.isUpgraded );
                	startAttack();               	
                	}
                }
            }
        }, 15*60*1000/MenuUI.speed); //Thoi gian giua cac hiep
        
        
    }
    

    public BattleField getAttackBattleField() {
        return attackBattleField;
    }

    public void setAttackBattleField(BattleField attackBattleField) {
        this.attackBattleField = attackBattleField;
    }

    public BattleField getDefenceBattleField() {
        return defenceBattleField;
    }

    public void setDefenceBattleField(BattleField defenceBattleField) {
        this.defenceBattleField = defenceBattleField;
    }

    public boolean isWar() {
        return war;
    }

    public void setWar(boolean war) {
        this.war = war;
    }

}
