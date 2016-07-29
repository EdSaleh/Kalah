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
 */
public class Game {
    
    private House house;
    private Houses houses = new Houses();
    
    Game(){
        //this.houses = houses;
    }
    
    public void setBoard(Houses houses){
        this.houses = houses;
    }
    
    public Houses getHouses(){
        return houses;
    }
    
    public int MakeMove(int currentPlayer, int player, int positionClicked){
        //Get the house where the player clicked and the number of pits
        house = houses.getHouse(positionClicked);
        House store;
        int nOfPits = house.getPits();
        int whatHappened;
        
        if(player == house.getPlayer() && house.getPits() != 0 && player == currentPlayer){
            
            whatHappened = 1;
            //Now as we move all pits from the house clicked, the new amount will be 0
            houses.getHouse(positionClicked).setPits(0);

            for(int i=0; i< nOfPits; i++){
                house = houses.getHouse(house.getNextHouse());  // Get the next house
                if ((house.getCurrentHouse() == HousePos.L0.getValue() || house.getCurrentHouse() == HousePos.R0.getValue())
                        && house.getPlayer() != player)
                {
                    house = houses.getHouse(house.getNextHouse());  // Get the next house
                }
                houses.getHouse(house.getCurrentHouse()).setPits(house.getPits()+1); // And add 1 to this house
            }
                       
            if((house.getCurrentHouse() == HousePos.L0.getValue() || house.getCurrentHouse() == HousePos.R0.getValue()) 
                    && house.getPlayer() == player)
            {
                whatHappened = 3;
            }
            
            //If the number of Pits is 1 means that this house was empty before the game
            //Check if the house is on the player side and if has pits in the neighbor
            else{ 
                int currentHousePits = house.getPits();
                int neighborPits = houses.getHouse(house.getNeighbor()).getPits();
            
                if(currentHousePits == 1 && house.getPlayer() == player && neighborPits != 0){   
                    if(house.getPlayer() == 1)
                        store = houses.getHouse(HousePos.R0.getValue());
                    else
                        store = houses.getHouse(HousePos.L0.getValue());

                    //Take the pits from the current house and the neighbor and put in the Player Store
                    house.setPits(0);
                    houses.getHouse(house.getNeighbor()).setPits(0);
                    store.setPits(store.getPits() + currentHousePits + neighborPits);
                    whatHappened = 2;
                }
            }
        }
        
        else{
           whatHappened = -1; 
        }

        return whatHappened;
    }
   
    
}
