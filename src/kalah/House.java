/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalah;

/**
 *
 * @author 100571571
 */
public class House {
    
    //Private Variables
    private final int player;
    private int nOfPits;
    private final int currentHouse;
    private final int nextHouse;
    private final int neighbor;
    
    House(int player, int pits, int currentHouse, int next, int neighbor){
        this.player = player;
        nOfPits = pits;
        this.currentHouse = currentHouse;
        nextHouse = next;
        this.neighbor = neighbor;
    }
    
    public int getPlayer(){
        return player;
    }
    
    public int getPits(){
        return nOfPits;
    }
    
    public int getNextHouse(){
        return nextHouse;
    }
    
    public int getCurrentHouse(){
        return currentHouse;
    }
    
    public int getNeighbor() {
        return neighbor;
    }
    
    public void setPits(int pits){
        nOfPits = pits;
    }
}
