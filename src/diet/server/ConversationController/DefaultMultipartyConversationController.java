package diet.server.ConversationController;
import diet.message.MessageChatTextFromClient;
import diet.message.MessageKeypressed;
import diet.message.MessageTask;
import diet.message.MessageWYSIWYGDocumentSyncFromClientInsert;
import diet.message.MessageWYSIWYGDocumentSyncFromClientRemove;
import diet.server.ConnectionListener;
import diet.server.Conversation;
import diet.server.Participant;
import java.awt.event.KeyEvent;
import java.util.Date;




public class DefaultMultipartyConversationController extends DefaultConversationController{

    
    
    
    public static boolean showcCONGUI(){
        return true;
    } 

    
    
    public DefaultMultipartyConversationController(Conversation c) {
        super(c);
        String portNumberOfServer = ""+ConnectionListener.staticGetPortNumber();
        param_experimentID = "DefaultMultiPartyConversation";
     
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
          itnt.processTurnSentByClient(sender);
          
          c.newrelayTurnToPermittedParticipants(sender, mct);
                      
    }
    
    
    
    
    
    
    
    @Override
    public void processKeyPress(Participant sender,MessageKeypressed mkp){
         super.processKeyPress(sender, mkp);
         this.itnt.processDoingsByClient(sender);
         
         Participant other = (Participant)c.getParticipants().getAllOtherParticipants(sender).elementAt(0);
         System.err.println("THE KEYCODE IS: "+mkp.getKeypressed().getKeycode());
         
        
         
         if(mkp.getKeypressed().getKeycode()!=KeyEvent.VK_ENTER){
            //System.exit(-234);
             //itnt.addSpoofTypingInfo(other, new Date().getTime()+200+r.nextInt(800));
             
             for(long l = new Date().getTime(); l < new Date().getTime()+ r.nextInt(5000); l = l+ 900){
                  itnt.addSpoofTypingInfo(other, l);
             }     
         }
         
        
    }

    
    @Override
    public void processWYSIWYGTextInserted(Participant sender,MessageWYSIWYGDocumentSyncFromClientInsert mWYSIWYGkp){
 
           //this.itnt.processDoingsByClient(sender);
    }
    
    
    
    @Override
    public void processWYSIWYGTextRemoved(Participant sender,MessageWYSIWYGDocumentSyncFromClientRemove mWYSIWYGkp){
          // this.itnt.processDoingsByClient(sender);
    }
    
   
    
   
   


    
    
   

   

}
