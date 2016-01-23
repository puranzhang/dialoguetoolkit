package diet.server.ConversationController;
import diet.attribval.AttribVal;
import diet.message.MessageChatTextFromClient;
import diet.message.MessageKeypressed;
import diet.message.MessageTask;
import diet.message.MessageWYSIWYGDocumentSyncFromClientInsert;
import diet.message.MessageWYSIWYGDocumentSyncFromClientRemove;
import diet.server.ConnectionListener;
import diet.server.Conversation;
import diet.server.ConversationController.ui.CustomDialog;
import diet.server.Participant;
import diet.task.mazegame.MazeGameController2WAY;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Vector;




public class EDI2016DyadicSingleOrSplitScreen extends DefaultConversationController{

    
    
    
    public static boolean showcCONGUI(){
        return true;
    } 

    
    
    public EDI2016DyadicSingleOrSplitScreen(Conversation c) {
        super(c);
        String portNumberOfServer = ""+ConnectionListener.staticGetPortNumber();
        param_experimentID = "DefaultMultiPartyConversation";
        
        String[] interfacechoice = {"single","split"};
        
        String option = CustomDialog.show2OptionDialog(interfacechoice, "Choose an interface", "");
        if(option.equalsIgnoreCase("single")) { 
            super.param_numberOfWindows=1;
        }
        else{
            super.param_numberOfWindows = 2;
        }
        
        
        
    }
   
    
    
    
    
    
     @Override
    public boolean requestParticipantJoinConversation(String participantID) {
        
        
        return true;
        
        
        
    }
    
    
    @Override
    public synchronized void participantJoinedConversation(final Participant p) {
        super.participantJoinedConversation(p);
        if(c.getParticipants().getAllParticipants().size()==2) {
             pp.createNewSubdialogue(c.getParticipants().getAllParticipants());
             this.itnt.setWhoSeesEachOthersTyping( pp);
        }
        
    }
    
    
    
    

    
    @Override
    public void participantRejoinedConversation(Participant p) {     
        super.participantRejoinedConversation(p);      
    }
    
    
    
   
   
   
   
   
   
   
   public synchronized void processTaskMove(MessageTask mtm, Participant origin) {            
    }
   
   
   
    
    @Override
    public synchronized void processChatText(Participant sender, MessageChatTextFromClient mct){    
      this.itnt.processTurnSentByClient(sender);
          
         
              Vector additionalData = new Vector();
              additionalData.addElement(new AttribVal("splitscreen","split"));
              c.newrelayTurnToPermittedParticipants(sender, mct,additionalData);        
             
         
          
                      
    }
    
    
    
    
    
    
    
    @Override
    public void processKeyPress(Participant sender,MessageKeypressed mkp){
         //super.processKeyPress(sender, mkp);
         if(super.param_numberOfWindows==1)    this.itnt.processDoingsByClient(sender);
         
         
         
        
         
        
    }

    
    @Override
    public void processWYSIWYGTextInserted(Participant sender,MessageWYSIWYGDocumentSyncFromClientInsert mWYSIWYGkp){
            if(super.param_numberOfWindows==1) return;
            Participant recipient = (Participant)pp.getRecipients(sender).elementAt(0);
            Vector additionalValues = this.getAdditionalInformationForParticipant(sender);
            c.changeClientInterface_clearMainWindowsExceptWindow0(recipient);  
            c.newsendArtificialTurnFromApparentOrigin(sender, recipient, mWYSIWYGkp.getAllTextInWindow()  , 1, additionalValues);

    }
    
    
    
    @Override
    public void processWYSIWYGTextRemoved(Participant sender,MessageWYSIWYGDocumentSyncFromClientRemove mWYSIWYGkp){
         if(super.param_numberOfWindows==1) return;
         Participant recipient = (Participant)pp.getRecipients(sender).elementAt(0);
         Vector additionalValues = this.getAdditionalInformationForParticipant(sender);
         c.changeClientInterface_clearMainWindowsExceptWindow0(recipient);
         c.newsendArtificialTurnFromApparentOrigin(sender, recipient, mWYSIWYGkp.getAllTextInWindow()  , 1, additionalValues);

    }
    
   
    
   
   


    
    
   

   

}
