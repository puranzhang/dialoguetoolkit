


package diet.server.ParticipantPartnering;
import diet.server.Conversation;
import diet.server.Participant;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Vector;





public class ParticipantPartnering {
    
   
    Hashtable htSubdialogues = new Hashtable();
    public Conversation c;
    
    long unqiueSubDialogueID=0;
    
    public ParticipantPartnering(Conversation c) {
        this.c=c;
    }   
    
    
    public String getSubdialogueID(Participant p){
        try{
           SubDialogue sd = (SubDialogue)this.htSubdialogues.get(p);
           if(sd==null) return null;
           return sd.getID();
        
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error: could not find subdialogue";
    }
    
    public Vector getRecipients(Participant p){
         try{
           SubDialogue sd = (SubDialogue)this.htSubdialogues.get(p);
           return sd.getAllOtherParticipants(p);
        
        }catch (Exception e){
           // e.printStackTrace();
            System.err.println("THER ARE NO RECIPIENTS FOR "+p.getUsername());
        }
        return new Vector();
    }
    
   
    public void createNewSubdialogue(Participant...ps){
        Vector v = new Vector(Arrays.asList(ps));
        this.createNewSubdialogue(v);
    }
    public void createNewSubdialogue(Vector vps){
        ///First need to remove them from all other subdialogues
        for(int i=0;i<vps.size();i++){
            Participant p = (Participant)vps.elementAt(i);
            SubDialogue sd = (SubDialogue)this.htSubdialogues.get(p);
            if(sd!=null){
               sd.vps.remove(p);
               sd.id=sd.id+"_removed("+p.getParticipantID()+","+p.getUsername()+"";
            }
            
            
        }
        
        
        
        String id =  ""+unqiueSubDialogueID;
        unqiueSubDialogueID++;
        SubDialogue sd = new SubDialogue(id,vps);
        for(int i=0;i<vps.size();i++){
            Participant p = (Participant)vps.elementAt(i);
            this.htSubdialogues.put(p, sd);
        }
        
        
    }
    
    
    
    
    
    public Vector getRecipientsSettings_DEPRECATEDFOROLDCOMPATIBILITY(Participant p){
        //Returns Vector with first element vector of Participants, 2nd element is vector of Participants' names'
        //Default seetting is that all other participants are enabled.
        Vector participants = c.getParticipants().getAllParticipants(); 
        Vector vRecipients = new Vector();
        Vector vRecipientsEmails = new Vector();
        Vector vRecipientsUsernames = new Vector();
        Vector vRecipientsWindowNumbers = new Vector();
        Vector v = new Vector();
        int pIndex = participants.indexOf(p);
        for(int i=0;i<participants.size();i++){
            //System.err.println("Getting permission for "+p.getUsername());
            Participant p2 = (Participant)participants.elementAt(i);
            if(p!=p2){//Doesn't need to be able to send to self'
                
                        vRecipients.addElement(p2);
                        vRecipientsEmails.addElement(p2.getParticipantID());
                        vRecipientsUsernames.addElement(p2.getUsername());
                        vRecipientsWindowNumbers.addElement(0);
    
            }
        }
        v.addElement(vRecipients);
        v.addElement(vRecipientsEmails);
        v.addElement(vRecipientsUsernames);
        v.addElement(vRecipientsWindowNumbers);                
        return v;
     }     
        
    
    
   
    
    
  
    
    
    

}
