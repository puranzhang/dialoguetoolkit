/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diet.server.IsTypingController;

import diet.server.Participant;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author gj
 */
public class FakeTypingActivity extends Thread {
    
     Vector fakeactivity = new Vector();
     IsTypingOrNotTyping itnt;
     
     public FakeTypingActivity(IsTypingOrNotTyping itnt){
         this.itnt=itnt;
         this.start();
     }
     
     //10
     
     
     
     public synchronized void addIsTypingInfo(Participant p, long timeOfEvent){
          
         FakeTyping ftNEW = new FakeTyping(p, timeOfEvent);
         if(fakeactivity.size()==0){
             fakeactivity.add(ftNEW);
             notifyAll();
             return;
         }
          
          int indexToInsert =0;
          
          for(int i=0;i<fakeactivity.size();i++){
              Object o = fakeactivity.elementAt(i);
              if(o instanceof FakeTyping){
                  FakeTyping ft = (FakeTyping)o;
                  indexToInsert = i;
                  if(timeOfEvent < ft.timeOfTyping){
                      
                     
                      break;
                  }
                  
              }
              else if(o instanceof FakeNotTyping){
                  FakeNotTyping fnt = (FakeNotTyping)o;
                  indexToInsert = i;
                  if(timeOfEvent < fnt.timeOfNotTyping){
                      
                      break;
                  }
              }
              
              
          }
           System.err.println("INSERTING AT: "+indexToInsert+"....size is"+fakeactivity.size());
          this.fakeactivity.insertElementAt(ftNEW,indexToInsert );
          System.err.println("ADDING TIME: "+ftNEW.timeOfTyping);
         
          notifyAll();
     }
     
     
     
     
          public synchronized void addIsNotTypingInfo(Participant p, long timeOfEvent){
          
         FakeNotTyping fntNEW = new FakeNotTyping(p, timeOfEvent);
         if(fakeactivity.size()==0){
             fakeactivity.add(fntNEW);
             notifyAll();
             return;
         }
          
          int indexToInsert =0;
          
          for(int i=0;i<fakeactivity.size();i++){
              Object o = fakeactivity.elementAt(i);
              if(o instanceof FakeTyping){
                  FakeTyping ft = (FakeTyping)o;
                  indexToInsert = i;
                  if(timeOfEvent < ft.timeOfTyping){
                      
                     
                      break;
                  }
                  
              }
              else if(o instanceof FakeNotTyping){
                  FakeNotTyping fnt = (FakeNotTyping)o;
                  indexToInsert = i;
                  if(timeOfEvent < fnt.timeOfNotTyping){
                      
                      break;
                  }
              }
              
              
          }
           System.err.println("INSERTING AT: "+indexToInsert+"....size is"+fakeactivity.size());
          this.fakeactivity.insertElementAt(fntNEW,indexToInsert );
          System.err.println("ADDING TIME: "+fntNEW.timeOfNotTyping);
         
          notifyAll();
     }
     
     
     
     
     
     
     
     private synchronized void getNextLoop(){
      long waitduration=0;
      while(2<5){
             
          
           while(this.fakeactivity.size()==0){
               try{
                   System.err.println("HERE(A)");
                   wait(); 
               }
               catch(Exception e){
                   e.printStackTrace();
               }
           }
           
           
           System.err.println("HERE(B)");
           Object o = this.fakeactivity.elementAt(0);
           long currentTime = new Date().getTime();
           if(o instanceof FakeTyping){
                    FakeTyping ft = (FakeTyping)o;
                    waitduration =  ft.timeOfTyping-currentTime;
                    System.err.println("HERE(B1)");
           }     
           else if  (o instanceof FakeNotTyping){
                   FakeNotTyping fnt = (FakeNotTyping)o;
                   waitduration =  fnt.timeOfNotTyping-currentTime;
                    System.err.println("HERE(B2)");
                   
            }
           

           System.err.println("HERE(C)");
           if(waitduration > 0){
               System.err.println("NEED TO WAIT");
                try{
                  System.err.println("HERE(C1)");
                  wait(waitduration+1);
            }catch (Exception e){
                 e.printStackTrace();
            }
           }
           
           
           
           
          // System.exit(-432);
            
            //Need to try again - it might be that a new action has been added
            o = this.fakeactivity.elementAt(0);
            currentTime = new Date().getTime();
            System.err.println("HERE(D)");
            if(o instanceof FakeTyping){
                  FakeTyping ft = (FakeTyping)o;
                   System.err.println("HERE(DD)");
                  if(ft.timeOfTyping<=currentTime){
                      System.err.println("HERE(DDD)...DIFFERENCE "+(ft.timeOfTyping-currentTime));
                      System.err.println("HERE(DDD)...fttimeoftyping: "+ft.timeOfTyping);
                      System.err.println("HERE(DDD)...currtentTime: "+currentTime);
                      itnt.processDoingsByClient(ft.apparentOrigin);
                      fakeactivity.remove(ft);
                     /// this.itnt.cC.c.newsendInstructionToParticipant(ft.apparentOrigin, " YOU ARE FAKE TPYING NOW");
                      //System.exit(-234);
                  }   
                  else{
                     /// this.itnt.cC.c.newsendInstructionToParticipant(ft.apparentOrigin, " REJECTING BECAUSE IS NOT LESSTHAN");
                      this.printQueue();
                      
                  }
            }
            else if(o instanceof FakeNotTyping){
                  FakeNotTyping fnt = (FakeNotTyping)o;
                  if(fnt.timeOfNotTyping<=currentTime){
                      itnt.processTurnSentByClient(fnt.apparentOrigin);
                      fakeactivity.remove(fnt);
                  }    
                 
            }
            
            
            
            
            
     }
     }
     
     
     public void run(){
        getNextLoop();
     }
    
    
     
     
     public void printQueue(){
         for(int i=0;i<fakeactivity.size();i++){
                 Object o = this.fakeactivity.elementAt(i);
                         
                 if(o instanceof FakeTyping){
                              FakeTyping fttt = (FakeTyping)o;
                            ///  this.itnt.cC.c.newsendInstructionToParticipant(fttt.apparentOrigin,""+fttt.timeOfTyping);
                 }
         }
     }
     
     
     
     
     
     
     
     
     
     
     class FakeAction{
         
     }
     
     
     class FakeTyping extends FakeAction {
         
         public FakeTyping(Participant apparentOrigin, long timeOfTyping){
             this.apparentOrigin=apparentOrigin;
             this.timeOfTyping=timeOfTyping;
         }
         
         public long timeOfTyping ;
         public Participant apparentOrigin;
     }
     
     class FakeNotTyping extends FakeAction{
         
          public FakeNotTyping(Participant apparentOrigin, long timeOfTyping){
             this.apparentOrigin=apparentOrigin;
             this.timeOfNotTyping=timeOfNotTyping;
         }
         
         public long timeOfNotTyping;
         public Participant apparentOrigin;
     }
    
}
