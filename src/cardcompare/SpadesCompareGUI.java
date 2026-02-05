/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardcompare;

import static apcscard.PlayingCard.DIAMONDS;
import static apcscard.PlayingCard.HEARTS;
import static apcscard.PlayingCard.SPADES;
import apcscvm.DefaultGraphicalObject;
import apcscvm.GraphicsUtilityFunctions;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author DSTIGANT
 */
public class SpadesCompareGUI extends CardCompareGUI {
    public static final Font FONT = GraphicsUtilityFunctions.getFont( 30 );
    @Override
    protected void createGraphicalObjects(CardCompareModel m, int w, int h) {
        super.createGraphicalObjects(m, w, h); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    
        SpadesTrickComparator comp = (SpadesTrickComparator) m.getComparator();
    
        int sl = comp.getSuitLead();
        String suit = "";
        if ( sl == SPADES ) {
            suit = "spades";
        } else if ( sl == HEARTS ) {
            suit = "hearts";
        } else if ( sl == DIAMONDS ) {
            suit = "diamonds";
        } else {
            suit = "clubs";
        }
        
        DefaultGraphicalObject suitGO = new DefaultGraphicalObject( 300, 30 );
        Graphics2D g = suitGO.getGraphics();
        g.setColor( Color.BLACK );
        GraphicsUtilityFunctions.drawStringWithFontInRectangle( g,
                suit + " lead", FONT, 0, 0, 300, 30 );
        getObjectContainer().addObject( suitGO, w/2 - 150, h*7/10);
    }
}
