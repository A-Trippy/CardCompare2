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
public class WarComparator implements CardComparator {

    public WarComparator() {

    }

    // if pc0 beats pc1, return 1
    // if pc1 beats pc0, return -1
    // if it's a tie, return 0
    // For war, compare the ranks.  Highest rank wins
    // If the ranks are the same, it's a tie
    public int compare(PlayingCard pc1, PlayingCard pc2) {

        if (pc1.getRank() > pc2.getRank()) {
            return 1;
        } else if (pc1.getRank() < pc2.getRank()) {
            return -1;
        } else {
            return 0;
        }
    }

}

