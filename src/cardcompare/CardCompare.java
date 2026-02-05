/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardcompare;

import apcscvm.CVMProgram;

/**
 *
 * @author DSTIGANT
 */
public class CardCompare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testWar();
        testHearts();
        //testVC();
        //testSpades();
        //testBridge();
    }
    
    public static void testWar() {
        CardCompareGUI gui = new CardCompareGUI();
        
        new CVMProgram(
            "War Card Compare", 800, 600, gui, gui,
            new CardCompareModel( new WarComparator() )
        ).start();
    }
    
    public static void testHearts() {
        CardCompareGUI gui = new HeartsCompareGUI();
        
        new CVMProgram(
            "Hearts Card Compare", 800, 600, gui, gui,
            new CardCompareModel( 
                    new HeartsTrickComparator( (int)(Math.random()*4) ) 
            )
        ).start();
    }
    
    public static void testVC() {
        CardCompareGUI gui = new CardCompareGUI();
        
        new CVMProgram(
            "VC Card Compare", 800, 600, gui, gui,
            new CardCompareModel( new VCTrickComparator() )
        ).start();
    }
    
    public static void testSpades() {
        CardCompareGUI gui = new SpadesCompareGUI();
        
        new CVMProgram(
            "Spades Card Compare", 800, 600, gui, gui,
            new CardCompareModel( 
                    new SpadesTrickComparator( (int)(Math.random()*4) ) 
            )
        ).start();
    }
    
    public static void testBridge() {
        CardCompareGUI gui = new BridgeCompareGUI();
        
        new CVMProgram(
            "Bridge Card Compare", 800, 600, gui, gui,
            new CardCompareModel( 
                    new BridgeTrickComparator( (int)(Math.random()*4), (int)(Math.random()*4)) 
             
            )
        ).start();
    }    
}
