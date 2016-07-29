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
public class KalahAI_Advanced {
    private Game AIgame = new Game();
    private Houses board = new Houses(), auxBoard = new Houses();
    private House house;
    private final int player, myFirstHouse, myLastHouse, myStore;
    
    KalahAI_Advanced(int player){
        this.player = player;
        
        if (player == 1){
            myStore = HousePos.R0.getValue();
            myFirstHouse = HousePos.R1.getValue();
            myLastHouse = HousePos.R6.getValue();
        }
        
        else{
            myStore = HousePos.L0.getValue();
            myFirstHouse = HousePos.L1.getValue();
            myLastHouse = HousePos.L6.getValue();
        }
    }
    
    private void resetAuxBoard(){
        for(int i=0; i < 13; i++){
            auxBoard.setHouse(i, board.getHouse(i));
        }
    }
        
    public void calculateBestMovie(int player, Houses board){
        int actPlayer = player;
        this.board = auxBoard = board;
        
        for(int i = myFirstHouse; i <= myLastHouse; i++){
            actPlayer = AIgame.MakeMove(2, player, i);
            if (actPlayer == 1) {
                
            }
        }
    }
    
    
   
}
