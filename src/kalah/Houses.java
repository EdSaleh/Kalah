/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalah;

/**
 *
 * @author Guilherme Fetter Damasio
 */
public class Houses {
    
    //Private Variables
    private House[] houses = new House[14];
    
    Houses(){
        createHouses();
    }
    
    private void createHouses(){
        House R1 = new House(1, 3, HousePos.R1.getValue(), HousePos.R2.getValue(), HousePos.L6.getValue());
        House R2 = new House(1, 3, HousePos.R2.getValue(), HousePos.R3.getValue(), HousePos.L5.getValue());
        House R3 = new House(1, 3, HousePos.R3.getValue(), HousePos.R4.getValue(), HousePos.L4.getValue());
        House R4 = new House(1, 3, HousePos.R4.getValue(), HousePos.R5.getValue(), HousePos.L3.getValue());
        House R5 = new House(1, 3, HousePos.R5.getValue(), HousePos.R6.getValue(), HousePos.L2.getValue());
        House R6 = new House(1, 3, HousePos.R6.getValue(), HousePos.R0.getValue(), HousePos.L1.getValue());
        House R0 = new House(1, 0, HousePos.R0.getValue(), HousePos.L1.getValue(), -1);
        House L1 = new House(2, 3, HousePos.L1.getValue(), HousePos.L2.getValue(), HousePos.R6.getValue());
        House L2 = new House(2, 3, HousePos.L2.getValue(), HousePos.L3.getValue(), HousePos.R5.getValue());
        House L3 = new House(2, 3, HousePos.L3.getValue(), HousePos.L4.getValue(), HousePos.R4.getValue());
        House L4 = new House(2, 3, HousePos.L4.getValue(), HousePos.L5.getValue(), HousePos.R3.getValue());
        House L5 = new House(2, 3, HousePos.L5.getValue(), HousePos.L6.getValue(), HousePos.R2.getValue());
        House L6 = new House(2, 3, HousePos.L6.getValue(), HousePos.L0.getValue(), HousePos.R1.getValue());
        House L0 = new House(2, 0, HousePos.L0.getValue(), HousePos.R1.getValue(), -1);
        
        houses[0] = R1;
        houses[1] = R2;
        houses[2] = R3;
        houses[3] = R4;
        houses[4] = R5;
        houses[5] = R6;
        houses[6] = R0;
        houses[7] = L1;
        houses[8] = L2;
        houses[9] = L3;
        houses[10] = L4;
        houses[11] = L5;
        houses[12] = L6;
        houses[13] = L0;
    }
    
    public House getHouse(int position){
        return houses[position];
    }
    
    public void setHouse(int position, House house){
        this.houses[position].setPits(house.getPits());
    }
    
}
