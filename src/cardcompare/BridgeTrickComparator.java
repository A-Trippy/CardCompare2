/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardcompare;

import apcscard.PlayingCard;

/**
 *
 * @author DSTIGANT
 */
public class BridgeTrickComparator implements CardComparator {
    private int suitLead;
    private int trumpSuit;
    
    public BridgeTrickComparator( int sl, int ts ) {
        suitLead = sl;
        trumpSuit = ts;
    }
    
    public int getSuitLead() { return suitLead; }
    public int getTrumpSuit() { return trumpSuit; }
    
    // if pc0 beats pc1, return 1
    // if pc1 beats pc0, return -1
    // if it's a tie, return 0
    
    // For Bridge:
    // if the suits of both cards are trumpSuit then compare the ranks
    //      highest rank wins
    // if the suit of one of the cards is trumpSuit and the other isn't
    //      the trumpSuit card wins
    // if the suit of both cards are suitLead then compare the ranks
    //      highest rank wins
    // if the suit of one of the cards is the suitLead and the other
    //      isn't the suitLead or trumpSuit, then the one that IS suitLead
    //      wins regardless of rank
    // if the neither of the suits is suitLead or trumpSuit then it's a tie
    //      regardless of rank
    public int compare( PlayingCard pc0, PlayingCard pc1 ) {
        if( pc0.getSuit() == trumpSuit && pc1.getSuit() != trumpSuit) {
            return 1;
        }
        else if( pc0.getSuit() != trumpSuit && pc1.getSuit() == trumpSuit) {
            return -1;
        }
        else if( pc0.getSuit() == trumpSuit && pc1.getSuit() == trumpSuit) {
            if (pc0.getRank() > pc1.getRank()) {
                return 1;
            }
            else if (pc0.getRank() < pc1.getRank()) {
                return -1;
            }  
        }
        else if (pc0.getSuit() == suitLead && pc1.getSuit() != suitLead) {
            return 1;
        }
        else if (pc0.getSuit() != suitLead && pc1.getSuit() == suitLead) {
            return -1;
        }
        else if (pc0.getSuit() == suitLead && pc1.getSuit() == suitLead) {
            if (pc0.getRank() > pc1.getRank()) {
                return 1;
            }
            else if (pc0.getRank() < pc1.getRank()) {
                return -1;
            }  
        }
        else {
            return 0;
        }
        return 0;   
    }
}
