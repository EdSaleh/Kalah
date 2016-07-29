/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalah;

import static java.lang.System.out;

/**
 * 
 * @author 100571571
 * 
 * This AI is a basic one, that don't check the future.
 * It's try to make the best movie possible looking just the present state
 * 
 */
public class KalahAI_Basic {
    private Houses board = new Houses(), auxBoard = new Houses();
    private Game AIgame = new Game();
    //private final Game realGame;
    private final int player, myFirstHouse, myLastHouse, enemyFirstHouse, enemyLastHouse;
    private int bestHouse;
    private int bestExtraMove, bestGetPitsFromNeighbor, bestScapeFromEnemy, bestLastPlan;
    
    KalahAI_Basic(int player, Game realGame){
        this.player = player;
        //this.realGame = realGame;
        
        if (player == 1){
            myFirstHouse = HousePos.R1.getValue();
            myLastHouse = HousePos.R6.getValue();
            enemyFirstHouse = HousePos.L1.getValue();
            enemyLastHouse = HousePos.L6.getValue();
        }
        
        else{
            myFirstHouse = HousePos.L1.getValue();
            myLastHouse = HousePos.L6.getValue();
            enemyFirstHouse = HousePos.R1.getValue();
            enemyLastHouse = HousePos.R6.getValue();
        }
    }
    
    public int calculateTheBestMovie(int player,Houses board){
        this.board = board;
        
        bestExtraMove = checkForExtraMove(player);
        bestGetPitsFromNeighbor = checkForGetPitsFromNeighbor(player);
        
        if ((bestExtraMove >= myFirstHouse) || (bestGetPitsFromNeighbor >= myFirstHouse)) {            
            if (bestExtraMove > bestGetPitsFromNeighbor)
                return bestExtraMove;
            else
                return bestGetPitsFromNeighbor;
        }
        else{
            bestScapeFromEnemy = scapeFromEnemy();
            if(bestScapeFromEnemy >= myFirstHouse)
                return bestScapeFromEnemy;
            else{
                bestLastPlan = planForNextMove();
                if (bestLastPlan > 0)
                    return bestLastPlan;
                else{
                    out.println("FUDEU NEGÃO... FUDEU MESMO!!!!");
                    return 1;
                }
            }
        } 
    }
    
    //Helper for reset to the current move
    private void resetBoard(){
        for(int i=0; i < 13; i++){
            auxBoard.setHouse(i, board.getHouse(i));
        }
    }
    
    //Check for a extra move
    private int checkForExtraMove(int player){
        int bestMove = -1;
        for (int i = myLastHouse; i >= myFirstHouse; i--) {
            resetBoard();
            AIgame.setBoard(auxBoard);
            //If the extra movie is avaiable
            if(AIgame.MakeMove(2,player, i) == 3){
                //Keep the house index
                bestMove = i;
                break;
            }
        }  
        out.println("Best Extra Move is:" + bestMove);
        return bestMove;
    }
    
    //Check for empty house to get the pits from the neighbor
    private int checkForGetPitsFromNeighbor(int player){
        House currentHouse;
        int morePits = 0, pits, bestMove = -1;
        for (int i = myFirstHouse; i <= myLastHouse; i++) {
            resetBoard();
            AIgame.setBoard(auxBoard);
            //If the move is a move to get pits
            if(AIgame.MakeMove(2,player, i) == 2){
                currentHouse = auxBoard.getHouse(i);
                //Check how many pets the neighbor has
                pits = auxBoard.getHouse(currentHouse.getNeighbor()).getPits();
                //If is the best option
                if(pits > morePits){
                    morePits = pits;
                    bestMove = i;   //Keep track of the index
                }
            }
        }
        out.println("Best Neighbor Move is:" + bestMove);
        return bestMove;
    }
    
    private int scapeFromEnemy(){
        House currentHouse;
        int morePits = 0,pits, bestMove = -1;
        for(int i=enemyFirstHouse; i<=enemyLastHouse;i++){
            if (board.getHouse(i).getPits() == 0) {
                currentHouse = board.getHouse(i);
                pits = board.getHouse(currentHouse.getNeighbor()).getPits();
                if (pits > morePits) {
                    morePits = pits;
                    bestMove = currentHouse.getNeighbor();
                }
            }
        }
        out.println("Best Scape Move is:" + bestMove);
        return bestMove;
    }
    
    private int planForNextMove(){
        House currentHouse;
        int morePits = -1, pits, bestMove = -1;
        for(int i=enemyFirstHouse; i<=enemyLastHouse; i++){
            currentHouse = board.getHouse(i);
            if (board.getHouse(currentHouse.getNeighbor()).getPits() > 0)
                pits = board.getHouse(i).getPits();
            else
                pits = 0;
            if(pits > morePits){
                morePits = pits;
                bestMove = board.getHouse(i).getNeighbor();
            }
        }
        out.println("Best Plan Move is:" + bestMove);
        return bestMove;
    }
}
