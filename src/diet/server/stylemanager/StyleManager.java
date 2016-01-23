/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package diet.server.stylemanager;


import diet.server.ConversationController.DefaultConversationController;
import diet.server.Participant;
import java.awt.Color;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Greg
 */
public class StyleManager {

     
     DefaultConversationController cC;
     
     public SimpleAttributeSet defaultFONTSETTINGSOTHER = new SimpleAttributeSet();
     public SimpleAttributeSet defaultFONTSETTINGSSELF = new SimpleAttributeSet();
     public SimpleAttributeSet defaultFONTSETTINGSSERVER = new SimpleAttributeSet();

     
     
     
     
     public StyleManager(DefaultConversationController cC){
         
         //These should all be initialized from the ConversationController
         
         this.cC=cC;
       
         StyleConstants.setFontFamily(defaultFONTSETTINGSSELF, cC.param_fontfamily_SELF);
         StyleConstants.setFontSize(defaultFONTSETTINGSSELF, cC.param_fontsize_SELF);
         StyleConstants.setBold(defaultFONTSETTINGSSELF, cC.param_fontisbold_SELF);
         StyleConstants.setItalic(defaultFONTSETTINGSSELF, cC.param_fontisitalic_SELF);
         StyleConstants.setForeground(defaultFONTSETTINGSSELF,cC.param_fontforegroundcolor_SELF);
        
         
         
         StyleConstants.setFontFamily(defaultFONTSETTINGSOTHER, cC.param_fontfamily_OTHER);
         StyleConstants.setFontSize(defaultFONTSETTINGSOTHER, cC.param_fontsize_OTHER);
         StyleConstants.setBold(defaultFONTSETTINGSOTHER, cC.param_fontisbold_OTHER);
         StyleConstants.setItalic(defaultFONTSETTINGSOTHER, cC.param_fontisitalic_OTHER);
         StyleConstants.setForeground(defaultFONTSETTINGSOTHER, cC.param_fontforegroundcolor_OTHER);
         
         
       
         
         StyleConstants.setFontFamily(defaultFONTSETTINGSSERVER, cC.param_fontfamily_SERVER);
         StyleConstants.setFontSize(defaultFONTSETTINGSSERVER, cC.param_fontsize_SERVER);
         StyleConstants.setBold(defaultFONTSETTINGSSERVER, cC.param_fontisbold_SERVER);
         StyleConstants.setItalic(defaultFONTSETTINGSSERVER, cC.param_fontisitalic_SERVER);
         StyleConstants.setForeground(defaultFONTSETTINGSSERVER,cC.param_fontforegroundcolor_SERVER);
     }
    
    
     public MutableAttributeSet getStyleForRecipient(Participant sender, Participant recipient){
         if(recipient==sender){      
             return defaultFONTSETTINGSSELF;  
         }
         return defaultFONTSETTINGSOTHER;
     }
     
     public MutableAttributeSet getStyleForInstructionMessages(Participant recipient){
         return this.defaultFONTSETTINGSSERVER;
     }
     
     public MutableAttributeSet getDefaultStyleForInstructionMessages(){
         return this.defaultFONTSETTINGSSERVER;
     }
     
     public MutableAttributeSet  getStyleForSelf(){
         return this.defaultFONTSETTINGSSELF;
     }
     public int getWindowNumberInWhichParticipantBReceivesTextFromParticipantA(Participant senderA, Participant recipientB){
         return 0;
     }
      public int getWindowNumberInWhichParticipantBReceivesTextFromServer(Participant recipientB){
         return 0;
     }
      
     
     
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
  
     
     
}
