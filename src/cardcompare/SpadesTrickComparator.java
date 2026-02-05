/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardcompare;

import apcscard.PlayingCard;
import static apcscard.PlayingCard.SPADES;

/**
 *
 * @author DSTIGANT
 */
public class SpadesTrickComparator implements CardComparator {
    private int suitLead;
    
    public SpadesTrickComparator( int sl ) {
        suitLead = sl;
    }

    public int getSuitLead() { return suitLead; }
    // if pc0 beats pc1, return 1
    // if pc1 beats pc0, return -1
    // if it's a tie, return 0
    
    // For Spades:
    // if the suits of both cards are SPADES then compare the ranks
    //      highest rank wins
    // if the suit of one of the cards is SPADES and the other isn't
    //      the SPADES card wins
    // if the suit of both cards are suitLead then compare the ranks
    //      highest rank wins
    // if the suit of one of the cards is the suitLead and the other
    //      isn't the suitLead or SPADES, then the one that IS suitLead
    //      wins
    // if the neither of the suits is suitLead or SPADES then it's a tie
    //      regardless of rank
    @Override
    public int compare(PlayingCard pc0, PlayingCard pc1) {
        if( pc0.getSuit() == PlayingCard.SPADES && pc1.getSuit() != PlayingCard.SPADES) {
            return 1;
        }
        else if( pc0.getSuit() != PlayingCard.SPADES && pc1.getSuit() == PlayingCard.SPADES) {
            return -1;
        }
        else if( pc0.getSuit() == PlayingCard.SPADES && pc1.getSuit() == PlayingCard.SPADES) {
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
