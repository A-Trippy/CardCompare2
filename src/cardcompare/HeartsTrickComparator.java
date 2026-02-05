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
public class HeartsTrickComparator implements CardComparator {
    private int suitLead;
    
    public HeartsTrickComparator( int sl ) {
        suitLead = sl;
    }
    
    public int getSuitLead() { return suitLead; }
    
    // if pc0 beats pc1, return 1
    // if pc1 beats pc0, return -1
    // if it's a tie, return 0
    
    // For Hearts:
    // if the suit of both cards are suitLead then compare the ranks
    //      highest rank wins
    // if the suit of one of the cards is the suitLead and the other
    //      isn't then the one that IS suitLead
    //      wins regardless of rank
    // if the neither of the suits is suitLead or SPADES then it's a tie
    //      regardless of rank
    @Override
    public int compare(PlayingCard o1, PlayingCard o2) {
        if ( o1.getSuit() == suitLead && o1.getSuit() == o2.getSuit()) {
            if ( o1.getRank() > o2.getRank()) {
                return 1;
            }
            else {
                return -1;
            }
        }
        else if ( o1.getSuit() == suitLead) {
            return 1;
        }
        else if (o2.getSuit() == suitLead) {
            return -1;
        }
        else {
            return 0;
        }
    }
    
}
