package diet.message;
import diet.attribval.AttribVal;
import java.io.Serializable;
import java.util.Date;
import java.util.Vector;



public class MessageChatTextFromClient extends Message implements Serializable {

  private Vector keyPresses;
  private boolean processed =false;
 // private long startOfTypingCalculatedForServer;
 // private long endOfTypingCalculatedForServer;
  private String text;
  private boolean hasBeenBlocked;

  public boolean hasBeenRelayedByServer = false;
  
  public long startOfTypingOnClient;
   String[] mostRecentChatTextByPrior ;
   
  
  
  public MessageChatTextFromClient(String email,String username,String t, long startOfTypingOnClient, boolean currentTurnBeingConstructedHasBeenBlocked, Vector keyPresses, String[] mostRecentPriorChatText) {
    super(email,username);
    setText(t);
    this.setKeyPresses(keyPresses);
    this.startOfTypingOnClient = startOfTypingOnClient;
    if(startOfTypingOnClient <0) startOfTypingOnClient = super.getTimeOfSending().getTime();
   
    this.setHasBeenBlocked(currentTurnBeingConstructedHasBeenBlocked);
    this.mostRecentChatTextByPrior=mostRecentPriorChatText;
    
    if(diet.debug.Debug.debugtimers){
        this.saveTime("client.created");
    }
  }

   public Vector allTimes = new Vector();
   
   
   public void saveTime(String eventName){
       AttribVal av = new AttribVal(eventName, new Date().getTime());
       allTimes.addElement(av);
   }

    


  public String getText() {
    return text;
  }

  public Vector getKeypresses(){
     return keyPresses;
  }

  public int getNoOfDeletes(){
    //if(2<5)return 5;
    //8 or 127
    int delcount = 0;
    try{
    for (int i =0 ; i < getKeyPresses().size();i++){
       Keypress keyp = (Keypress)getKeyPresses().elementAt(i);
       if(keyp.isDel()){
          delcount = delcount+1;
       }
    }
    }catch(Exception e){}
    return delcount;
  }
  
  public boolean hasBeenBlocked(){
      return this.isHasBeenBlocked();
  }
  
  public String getMessageClass(){
      return "ChatTextFromClient";
  }

    public Vector getKeyPresses() {
        return keyPresses;
    }

    public void setKeyPresses(Vector keyPresses) {
        this.keyPresses = keyPresses;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

   

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHasBeenBlocked() {
        return hasBeenBlocked;
    }

    public void setHasBeenBlocked(boolean hasBeenBlocked) {
        this.hasBeenBlocked = hasBeenBlocked;
    }
  
  
    public void setChatTextHasBeenRelayedByServer(){
        this.hasBeenRelayedByServer=true;
    }
 
    public String[] getMostRecentPriorChatText(){
        //////FOR DEBUGGING: this.mostRecentChatTextByPrior[2]="PRIORTEXT3"+this.mostRecentChatTextByPrior[2];
        return this.mostRecentChatTextByPrior;
    }
    
    public long getStartOfTypingOnClient(){
        return this.startOfTypingOnClient;
    }
    
    
    
}
