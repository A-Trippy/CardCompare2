/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardcompare;

import apcscard.PlayingCard;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author DSTIGANT
 */
public class CardCompareModel {
    private CardComparator comparator;
    private Integer [][] results;
    private PlayingCard [][] cards;
    private ArrayList<PlayingCard> deck;
    private int numTests;
    
    
    public static final int TOTAL_TESTS = 20;
    
    public CardCompareModel( CardComparator comp ) {
        comparator = comp;
        results = new Integer[TOTAL_TESTS][2];
        cards = new PlayingCard[TOTAL_TESTS][2];
        deck = PlayingCard.createDeck();
        Collections.shuffle( deck );
        
        numTests = 0;
        drawNextTest();
    }
    
    private void drawNextTest() {
        cards[numTests][0] = deck.remove( 0 );
        cards[numTests][1] = deck.remove( 0 );
        cards[numTests][0].flipFaceUp();
        cards[numTests][1].flipFaceUp();
    }
    
    public PlayingCard getCard( int t, int i ) {
        return cards[t][i];
    }
    
    public int getNumTests() {
        return numTests;
    }
    
    public Integer getTestResult( int t, int i ) {
        return results[t][i];
    }
    
    public CardComparator getComparator() {
        return comparator;
    }
    
    public void markCorrectResult( PlayingCard c ) {
        results[numTests][1] = comparator.compare( cards[numTests][0], cards[numTests][1] );
        if ( c == cards[numTests][0] ) {
            results[numTests][0] = 1;
        } else if ( c == cards[numTests][1] ) {
            results[numTests][0] = -1;
        } else if ( c == null ) {
            results[numTests][0] = 0;
        }
        numTests++;
        if ( numTests < cards.length ) {
            drawNextTest();
        }
    }
}
