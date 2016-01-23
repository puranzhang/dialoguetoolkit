/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package diet.server.experimentmanager;

import diet.task.mazegame.JSetupFrame;
import diet.task.mazegame.SetupIO;
import diet.server.Conversation;
import diet.server.ConversationController.DefaultConversationController;
import diet.server.ConversationController.ui.CustomDialog;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;


import diet.utils.postprocessing.collatingdata.CollatingData;
import java.awt.Color;
import javax.swing.JCheckBoxMenuItem;

/**
 *
 * @author user
 */
public class MenuBarHandler implements ActionListener{

    JExperimentManagerMainFrame jemmf;
   
    JLeftTabbedPanel jltp;
    EMUI emui;
    
    public MenuBarHandler(JExperimentManagerMainFrame jemmf){
        this.jemmf = jemmf;
      
        this.emui=jemmf.getExpmanUI();
        this.jltp = jemmf.getJltp();
    }
    
    
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        
        if(s.equalsIgnoreCase("Collate multiple experiments")){
             CollatingData cd = new CollatingData();   
        }
        else if (s.equalsIgnoreCase("Design mazes")){
            SetupIO sIO = new SetupIO(System.getProperty("user.dir"));
            JSetupFrame jsf = new JSetupFrame(sIO);
        }
        else if(s.equalsIgnoreCase("Dynamic text entry")){
            try{
              emui.displayONOFFDynamicTextDisplayOfConversationCorrespondingToTabbedPane(jltp.getSelectedTab().getContentComponent());
            }catch(Exception e2){}  
        }
        else if(s.equalsIgnoreCase("Auto-scroll conversation")){
            Object o = e.getSource();
            if(o instanceof JCheckBoxMenuItem){
               JCheckBoxMenuItem jcb = (JCheckBoxMenuItem)o;
               emui.toggleScrolling(jcb.isSelected());
            }
            else{
                Conversation.printWSln("Main", "SOME ERROR WITH THE UI TRIGGERING INTERFACE");
            }
            
        }
         else if(s.equalsIgnoreCase("Auto-scroll text in Output windows")){
            Object o = e.getSource();
            if(o instanceof JCheckBoxMenuItem){
               JCheckBoxMenuItem jcb = (JCheckBoxMenuItem)o;
               JOutput.doOutputScroll = jcb.isSelected();
            }
            else{
                Conversation.printWSln("Main", "SOME ERROR WITH THE UI TRIGGERING INTERFACE");
            }
             
        }
         else if(s.equalsIgnoreCase("About")){
            
             
             String text = DefaultConversationController.aboutstring+"\n\n"+
                     "Version: "+DefaultConversationController.softwareversion;
             CustomDialog.showDialog(text);
         }
  
        
        //public static boolean doOutputScroll = true;
        
        
    }
    
    
      public void buildMenu(){
        
        JMenuBar menuBar;
        JMenu menu, submenu;
       
        JMenuItem menuItem;        
       
        menuBar = new JMenuBar();
        //Build the first menu.
        menu = new JMenu("File"); 
        menuBar.add(menu);
        
         menuItem = new JMenuItem("Create settings for client on USB stick"); menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Open previous data for replay"); menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Exit"); menuItem.addActionListener(this);  
        menu.add(menuItem);
        JSeparator js = new JSeparator();
        menu.add(js);
        
        
       
        menuBar.add(menu);
        menu = new JMenu("View");
        menuBar.add(menu);
       
        js = new JSeparator();
        menu.add(js);
        menuItem = new JCheckBoxMenuItem("Auto-scroll conversation",true); menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JCheckBoxMenuItem("Auto-scroll text in Output windows",true); menuItem.addActionListener(this);
        menu.add(menuItem);
        
        
        menu = new JMenu("Utils"); 
        menuBar.add(menu);
        menuItem = new JMenuItem("Collate multiple experiments"); menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Design mazes"); menuItem.addActionListener(this);
        menu.add(menuItem);
        //menuBar.add(menu);
        
        
        menu = new JMenu("Help");menu.addActionListener(this);
        menuBar.add(menu);
        //menuItem = new JMenuItem("Online help"); menuItem.addActionListener(this);
        //menu.add(menuItem);
        menuItem = new JMenuItem("About"); menuItem.addActionListener(this);
        menu.add(menuItem);
        js = new JSeparator();
        menu.add(js);
        
        
        JMenu jmen = new JMenu("Help");  menu.add(jmen);
        
        //JMenuItem menuItem2 = new JMenuItem("How urgent is it?"); menuItem.addActionListener(this);
        //jmen.add(menuItem2);
        
        JMenu jmenn = new JMenu("How urgent is it?");
        jmen.add(jmenn);
        
        JMenu jmenn2itcnwait = new JMenu("It can wait 24 hours");
        jmenn.add(jmenn2itcnwait);
        
        JMenu jmenn2itcntwait = new JMenu("Panic while running an experiment!!!!");
        jmenn.add(jmenn2itcntwait);
        
        
        
        
        JMenuItem jmenn2itcntwaitcontact = new JMenuItem("Please call this number: "+DefaultConversationController.tcontact+ "..if I can I will answer immediately!");
        jmenn2itcntwait.add(jmenn2itcntwaitcontact);
        
        JMenuItem jmenn2itcnwaitcontact = new JMenuItem("Please email "+ DefaultConversationController.econtact);
        jmenn2itcnwait.add(jmenn2itcnwaitcontact);
        
        
        //JMenuItem menuItem3 = new JMenuItem("It can wait 12 hours"); menuItem3.addActionListener(this);
        //menuItem2.add(menuItem3);
        
        //JMenuItem menuItem4 = new JMenuItem("Urgent panic!"); menuItem2.addActionListener(this);
        //menuItem2.add(menuItem4);
        
         
        
        jemmf.setJMenuBar(menuBar);      
        
        
        
        
        
    }
    

}
