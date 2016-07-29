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
public enum HousePos {
        R1(0),R2(1),R3(2),R4(3),R5(4),R6(5),R0(6),L1(7),L2(8),L3(9),L4(10),L5(11),L6(12),L0(13);
        private final int value;
        
        private HousePos(int value){
            this.value = value;
        }
        
        public int getValue(){
            return value;
        }
}
