/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardcompare;

import apcscard.PlayingCard;
import static apcscard.PlayingCardDisplay.*;
import apcscvm.DefaultControlView;
import apcscvm.DefaultGraphicalObject;
import apcscvm.GraphicalObject;
import apcscvm.GraphicsUtilityFunctions;
import static cardcompare.CardCompareModel.TOTAL_TESTS;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

/**
 *
 * @author DSTIGANT
 */
public class CardCompareGUI extends DefaultControlView<CardCompareModel> {

    public class CardGO extends DefaultGraphicalObject {
        public CardGO( PlayingCard c, Color outline ) {
            super( c, CARD_WIDTH, CARD_HEIGHT );
            super.getGraphics().drawImage( getCardImage(c), 0, 0, null );
            if ( outline != null ) {
                getGraphics().setColor( outline );
                getGraphics().setStroke( new BasicStroke(9) );
                getGraphics().drawRect( 0, 0, CARD_WIDTH - 1, CARD_HEIGHT - 1 );
            }
        }
        
        public PlayingCard getCard() {
            return (PlayingCard)super.getData();
        }
        
    }
    
    public class ActiveCardGO extends CardGO {

        public ActiveCardGO(PlayingCard c, Color outline) {
            super(c, outline);
        }
    }
    
    public class ButtonGO extends DefaultGraphicalObject {
        private static final Font FONT = GraphicsUtilityFunctions.getFont( 20 );
        public ButtonGO( String s, int w, int h ) {
            super( s, w, h );
            getGraphics().setColor( Color.BLACK );
            getGraphics().drawRect( 0, 0, w-1, h-1 );
            GraphicsUtilityFunctions.drawStringWithFontInRectangle(
                    getGraphics(), s, FONT, 0, 0, w, h );
        }
    }
    
    @Override
    protected void createGraphicalObjects(CardCompareModel m, int w, int h ) {
        for ( int i = 0; i < m.getNumTests(); i++ ) {
            int expRes = m.getTestResult( i, 0 );
            int gotRes = m.getTestResult( i, 1 );
            
            Color out0 = null, out1 = null;
            if ( expRes == -1 && gotRes == -1 ) {
                out1 = Color.GREEN;
            } else if ( expRes == 1 && gotRes == 1 ) {
                out0 = Color.GREEN;
            } else if ( expRes == 0 && gotRes == 0 ) {
                out1 = out0 = Color.GREEN;
            } else if ( expRes == -1 && gotRes == 1 ) {
                out1 = Color.GREEN;
                out0 = Color.RED;
            } else if ( expRes == 1 && gotRes == -1 ) {
                out1 = Color.RED;
                out0 = Color.GREEN;
            } else if ( expRes == 0 ) {
                out1 = Color.RED;
                out0 = Color.RED;
            } else if ( expRes == 1 && gotRes == 0 ) {
                out0 = Color.RED;
            } else if ( expRes == -1 && gotRes == 0 ) {
                out1 = Color.RED;
            }
            
            CardGO cgo0 = new CardGO( m.getCard(i, 0), out0 );
            CardGO cgo1 = new CardGO( m.getCard(i, 1), out1 );
            
            getObjectContainer().addObject( 
                    cgo0, w - 2*CARD_WIDTH, 20*i );
            getObjectContainer().addObject(
                    cgo1, w - CARD_WIDTH, 20*i );
        }
        
        if ( m.getNumTests() < TOTAL_TESTS ) {
            CardGO cgoNow0 = new ActiveCardGO( m.getCard( m.getNumTests(), 0 ), null );
            CardGO cgoNow1 = new ActiveCardGO( m.getCard( m.getNumTests(), 1 ), null );
            getObjectContainer().addObject( cgoNow0, w/2 - CARD_WIDTH*3/2, h/2 );
            getObjectContainer().addObject( cgoNow1, w/2 + CARD_WIDTH/2, h/2 );

            ButtonGO equalButton = new ButtonGO( "equal", CARD_WIDTH * 9 / 10, 30 ); 
            getObjectContainer().addObject( equalButton, w/2 - equalButton.getWidth()/2, h/2 );
            
        }
        
        
    }
    
    @Override
    public void handleMouseClick(CardCompareModel m, int eventAge, MouseEvent me) {
        GraphicalObject go = super.getObjectContainer().getObject( me.getX(), me.getY() );
        
        if ( go != null ) {
            if ( go instanceof ActiveCardGO ) {
                m.markCorrectResult( ((CardGO)go).getCard() );
            } else if ( go instanceof ButtonGO ) {
                m.markCorrectResult( null );
            }
        }
    }

}
