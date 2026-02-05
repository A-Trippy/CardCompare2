/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardcompare;

import apcscard.PlayingCard;

/**
 *
 * @author ATrippy
 */
public class VCTrickComparator implements CardComparator {
    // if pc0 beats pc1, return 1
    // if pc1 beats pc0, return -1
    // if it's a tie, return 0
    
    // For VC:
    // the highest rank wins, but note that 2s are the highest
    // rank then Jacks, then Aces, Kings, Queens, 10s, 9s, ... 3s
    // if the ranks are the same then check the suits:
    // hearts beats diamonds beats clubs beats spades
    public int compare( PlayingCard pc0, PlayingCard pc1 ) {
        if( pc0.getRank() == 2 && pc1.getRank() != 2) {
            return 1;
        }
        else if( pc0.getRank() != 2 && pc1.getRank() == 2) {
            return -1;
        }
        else if( pc0.getRank() != PlayingCard.JACK && pc1.getRank() == PlayingCard.JACK) {
            return 1;
        }
        else if( pc0.getRank() == PlayingCard.JACK && pc1.getRank() != PlayingCard.JACK) {
            return -1;
        }
        else if( pc0.getRank() == pc1.getRank()) {
            //return 0;
            if( pc0.getSuit() == PlayingCard.HEARTS && pc1.getSuit() != PlayingCard.HEARTS) {
            return 1;
            }
            else if( pc0.getSuit() != PlayingCard.HEARTS && pc1.getSuit() == PlayingCard.HEARTS) {
                return -1; 
            }
            else if( pc0.getSuit() == PlayingCard.DIAMONDS && pc1.getSuit() != PlayingCard.DIAMONDS) {
                return 1;
            }
            else if( pc0.getSuit() != PlayingCard.DIAMONDS && pc1.getSuit() == PlayingCard.DIAMONDS) {
                return -1;
            }
            else if( pc0.getSuit() == PlayingCard.CLUBS && pc1.getSuit() != PlayingCard.CLUBS) {
                return 1;
            }   
        }
        else if( pc0.getRank() > pc1.getRank()) {
            return 1;
        }
        else if( pc0.getRank() < pc1.getRank()) {
            return -1;
        }
        else {
            return -1;
        }
    return 0;
    }
}
