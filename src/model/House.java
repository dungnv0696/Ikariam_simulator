package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import ui.IsLandUI;
import ui.MenuUI;

public class House {

    private int id;
    private int levelOfHouse;
    private int levelOfWall;
    private int garrisonLimit;
    private int numberOfUnit;
    private boolean isUpgraded = false;
    private Wall wall;
    private int typeOfHouse = 3; //0: của mình, 1: của đồng minh, 2: của địch, 3: Chưa có nhà
    private int levelOfForge = 0; //0: inactive, 1->5: lv1->5
    private int armourForge;
    private double damageForge;
    private Army army;
    private HashMap<Integer, PriorityQueue<SendingArmy>> sendingArmy;
    private HashMap<Integer, ArrayList<SentArmy>> sentRealArmy;
    private ArrayList<RealArmy> waitingWaveAttack;
    private BattleFieldFighting battleFieldFighting;
    private String name = "";

    public House() {
        army = new Army();
        wall = new Wall(0);
        sendingArmy = new HashMap<Integer, PriorityQueue<SendingArmy>>();
        battleFieldFighting = new BattleFieldFighting(id);
        waitingWaveAttack = new ArrayList<RealArmy>();
        sentRealArmy = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        battleFieldFighting = new BattleFieldFighting(id);
    }

    public House(int id) {
        this.id = id;
    }

    public HashMap<Integer, ArrayList<SentArmy>> getSentRealArmy() {
        return sentRealArmy;
    }

    public void setSentRealArmy(HashMap<Integer, ArrayList<SentArmy>> sentRealArmy) {
        this.sentRealArmy = sentRealArmy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public int getLevelOfWall() {
        return levelOfWall;
    }

    public int getLevelOfHouse() {
        return levelOfHouse;
    }

    public void setLevelOfHouse(int levelOfHouse) {
        this.levelOfHouse = levelOfHouse;
    }

    public void setLevelOfWall(int levelOfWall) {
        this.levelOfWall = levelOfWall;
    }

    public boolean getIsUpgraded() {
    	return isUpgraded;
    }
    
    public void setIsUpgraded(boolean isUpgraded) {
    	this.isUpgraded = isUpgraded;
    }
    
    // Cap do cua lo
    public int getLevelOfForge() {
        return levelOfForge;
    }

    public void setLevelOfForge(int levelOfForge) {
        this.levelOfForge = levelOfForge;
    }

    // kich hoat lo
    public double getDamageForge() {
    	return damageForge;
    }
    
    public void setDamageForge(int levelOfForge) {
    	if 		(	levelOfForge == 0) 
    		this.damageForge = 1.0;
    	else if (   levelOfForge == 1 
    			|| 	levelOfForge == 2)
    		this.damageForge = 1.1;
    	else if (	levelOfForge == 3
    			||	levelOfForge == 4)
    		this.damageForge = 1.15;
    	else if (	levelOfForge == 5)
    		this.damageForge = 1.2;   		
    }
    
    public int getArmourForge() {
    	return armourForge;
    }
    
    public void setArmourForge(int levelOfForge) {
    	if 		(	levelOfForge == 0 
    			|| 	levelOfForge == 1)
    		this.armourForge = 0;
    	else if (	levelOfForge == 2
    			||	levelOfForge == 3)
    		this.armourForge = 1;
    	else if (	levelOfForge == 4
    			||  levelOfForge == 5)
    		this.armourForge = 2; 
    }
    
    //Garrison Limit
    public int getGarrisonLimit() {
    	return garrisonLimit;
    }
    
    public void setGarrisonLimit(int levelOfHouse,int levelOfWall) {
    	this.garrisonLimit = 250 + 50 * levelOfHouse + 50 * levelOfWall;
    }
    
    public Army getArmy() {
        return army;
    }

    public int getNumberOfUnit() {
    	return numberOfUnit;
    }
    
    public void setNumberOfUnit(Army army) {
    	int NumberOfUnit = 0;
        for (Army.Unit unit : Army.Unit.values()) {
            NumberOfUnit += army.getNumberOf(unit);
            this.numberOfUnit = NumberOfUnit;
        }
    }
    
    public void setArmy(Army army) {
        this.army = army;
    }

    public int getTypeOfHouse() {
        return typeOfHouse;
    }

    public void setTypeOfHouse(int typeOfHouse) {
        this.typeOfHouse = typeOfHouse;
    }

    public HashMap<Integer, PriorityQueue<SendingArmy>> getSendingArmy() {
        return sendingArmy;
    }

    public void setSendingArmy(HashMap<Integer, PriorityQueue<SendingArmy>> sendingArmy) {
        this.sendingArmy = sendingArmy;
    }

    public BattleFieldFighting getBattleFieldFighting() {
        return battleFieldFighting;
    }

    public void setBattleFieldFighting(BattleFieldFighting battleFieldFighting) {
        this.battleFieldFighting = battleFieldFighting;
    }

    public ArrayList<RealArmy> getWaitingWaveAttack() {
        return waitingWaveAttack;
    }

    public void setWaitingWaveAttack(ArrayList<RealArmy> waitingWaveAttack) {
        this.waitingWaveAttack = waitingWaveAttack;
    }

    public void addArmyToBattleField(Army attackArmy, SendingArmy sendingArmy) {
        Timer timer = new Timer();
        Army defenceArmy = this.army;
        int houseID = this.getId();
        IsLandUI.house[houseID].setNumberOfUnit(defenceArmy);
        IsLandUI.house[houseID].setGarrisonLimit(IsLandUI.house[houseID].getLevelOfHouse(), IsLandUI.house[houseID].getLevelOfWall());
        sendingArmy.setTimer(timer);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	if (attackArmy.cannotWin()) {
            		IsLandUI.myHouse.getSendingArmy().get(id).remove(sendingArmy); 
            		JOptionPane.showMessageDialog(null, "My Army Is Missing");
            	}
            	else {
            		battleFieldFighting.getAttackBattleField().addToReserve(battleFieldFighting.getAttackBattleField().getReserve(), attackArmy, houseID);
            		if (!battleFieldFighting.isWar()) {
                		battleFieldFighting.getDefenceBattleField().addToReserve(battleFieldFighting.getDefenceBattleField().getReserve(), defenceArmy, houseID);
                		army.clear();
                		battleFieldFighting.setWar(true);         		
                		if(IsLandUI.house[houseID].getNumberOfUnit() < IsLandUI.house[houseID].getGarrisonLimit()) {
                			Stack<Wall> walls = new Stack<>();
                			for (int i = 0; i < battleFieldFighting.getDefenceBattleField().getNumberOfSlotForHI(); i++) {
                				walls.add(new Wall(levelOfWall));
                			}              		
                			battleFieldFighting.getDefenceBattleField().getReserve().setWall(walls);
                			boolean isAllWall = battleFieldFighting.getDefenceBattleField().isAllWall();
                			battleFieldFighting.getDefenceBattleField().addToField(isAllWall,true);
                			battleFieldFighting.getAttackBattleField().addToField(false,false);          			
                		}
                		else {              			
                			battleFieldFighting.getDefenceBattleField().addToField(false,false);
                			battleFieldFighting.getAttackBattleField().addToField(false,false);
                		}
                		battleFieldFighting.startAttack();
                		JOptionPane.showMessageDialog(null, "Send Army Success");               	
            		}
            		IsLandUI.myHouse.getSendingArmy().get(id).poll();
            	}
            }
        },attackArmy.getSpeedTimeForWholeRoute()/MenuUI.speed); //thoi gian di quan
    }

}
