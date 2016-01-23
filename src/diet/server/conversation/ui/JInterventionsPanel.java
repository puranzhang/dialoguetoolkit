/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diet.server.conversation.ui;

import diet.server.Conversation;
import diet.server.Participant;
import java.util.List;
import java.util.Vector;
import javax.swing.SwingUtilities;

/**
 *
 * @author gj
 */
public class JInterventionsPanel extends javax.swing.JPanel {

    Conversation c;
    
    /**
     * Creates new form NewJPanel
     */
    public JInterventionsPanel() {
        initComponents();
    }
    
    
     public JInterventionsPanel(Conversation c) {
        initComponents();
        this.c = c;
        
        
        
        
     }

     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(28, 5), new java.awt.Dimension(28, 5), new java.awt.Dimension(28, 60));
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 32767));
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 32767));
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
        add(filler1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Participant A (Apparent Origin)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(612, 130));
        jPanel1.setMinimumSize(new java.awt.Dimension(335, 130));
        jPanel1.setPreferredSize(new java.awt.Dimension(412, 130));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(300, 130));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 100));

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("Block");
        jButton1.setEnabled(false);
        jButton1.setMaximumSize(new java.awt.Dimension(150, 130));
        jButton1.setMinimumSize(new java.awt.Dimension(150, 130));
        jButton1.setPreferredSize(new java.awt.Dimension(150, 130));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setText("Unblock");
        jButton2.setEnabled(false);
        jButton2.setMaximumSize(new java.awt.Dimension(150, 130));
        jButton2.setMinimumSize(new java.awt.Dimension(150, 130));
        jButton2.setPreferredSize(new java.awt.Dimension(150, 130));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        add(jPanel1);
        add(filler3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Participant B:  Recipient(s) of intervention", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N
        jPanel2.setMaximumSize(new java.awt.Dimension(612, 130));
        jPanel2.setMinimumSize(new java.awt.Dimension(335, 130));
        jPanel2.setPreferredSize(new java.awt.Dimension(412, 130));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane2.setMaximumSize(new java.awt.Dimension(300, 120));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(23, 120));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 120));

        jList2.setMinimumSize(new java.awt.Dimension(33, 50));
        jList2.setPreferredSize(new java.awt.Dimension(33, 60));
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jPanel2.add(jScrollPane2);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setText("Block");
        jButton3.setEnabled(false);
        jButton3.setMaximumSize(new java.awt.Dimension(150, 120));
        jButton3.setMinimumSize(new java.awt.Dimension(150, 120));
        jButton3.setPreferredSize(new java.awt.Dimension(150, 120));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton4.setText("Unblock");
        jButton4.setEnabled(false);
        jButton4.setMaximumSize(new java.awt.Dimension(150, 120));
        jButton4.setMinimumSize(new java.awt.Dimension(150, 120));
        jButton4.setPreferredSize(new java.awt.Dimension(150, 120));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        add(jPanel2);
        add(filler5);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Message sent to B:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N
        jPanel3.setMaximumSize(new java.awt.Dimension(612, 130));
        jPanel3.setMinimumSize(new java.awt.Dimension(335, 130));
        jPanel3.setPreferredSize(new java.awt.Dimension(412, 130));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane3.setMaximumSize(new java.awt.Dimension(300, 120));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(23, 120));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(100, 120));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setPreferredSize(new java.awt.Dimension(164, 150));
        jScrollPane3.setViewportView(jTextArea1);

        jPanel3.add(jScrollPane3);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton6.setText("Artificial typing");
        jButton6.setEnabled(false);
        jButton6.setMaximumSize(new java.awt.Dimension(150, 120));
        jButton6.setMinimumSize(new java.awt.Dimension(150, 120));
        jButton6.setPreferredSize(new java.awt.Dimension(150, 120));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton7.setText("Send message");
        jButton7.setEnabled(false);
        jButton7.setMaximumSize(new java.awt.Dimension(150, 120));
        jButton7.setMinimumSize(new java.awt.Dimension(150, 120));
        jButton7.setPreferredSize(new java.awt.Dimension(150, 150));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7);

        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
      this.validateButtons();
        
    }//GEN-LAST:event_jList1ValueChanged

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
        this.validateButtons();
    }//GEN-LAST:event_jList2ValueChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
 try{
        System.err.println("Processing request");
        String message = jTextArea1.getText();
        List recipients = jList2.getSelectedValuesList();
        Vector v = new Vector(recipients);
        String apparentSenderUsername = (String)jList1.getSelectedValue();
        Participant apparentSender = c.getParticipants().findParticipantWithUsername(apparentSenderUsername);
        c.newsendArtificialTurnFromApparentOriginToMultipleRecipients(apparentSender, v, message);
      }catch (Exception e){
          e.printStackTrace();
      }


// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String s = (String)jList1.getSelectedValue();
        Participant p = c.getParticipants().findParticipantWithEmail(s);
        c.changeClientInterface_disableTextEntry(p);
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String s = (String)jList1.getSelectedValue();
        Participant p = c.getParticipants().findParticipantWithEmail(s);
        c.changeClientInterface_enableTextEntry(p);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String s = (String)jList2.getSelectedValue();
        System.err.println(s);
        Participant p = c.getParticipants().findParticipantWithEmail(s);
        c.changeClientInterface_disableTextEntry(p);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String s = (String)jList2.getSelectedValue();
        Participant p = c.getParticipants().findParticipantWithEmail(s);
        c.changeClientInterface_enableTextEntry(p);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String s = (String)jList1.getSelectedValue();
        Participant p = c.getParticipants().findParticipantWithEmail(s);
        c.typingactivity_GenerateFakeTyping(p);
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    public void validateButtons(){
        if(jList1.getSelectedValue()==null){
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
        }
        else{
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
        
        }
        if(jList2.getSelectedValue()==null){
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
        }
        else{
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
        
        }
        if(jList2.getSelectedValue()!=null && jList2.getSelectedValue()!=null ){
            jButton6.setEnabled(true);
            jButton7.setEnabled(true);
        }
        else{
            jButton6.setEnabled(false);
            jButton7.setEnabled(false);
        
        }
        
        
        
        
    }
    
    
    
     public void  updateParticipants(final Vector v){
        final Vector vNames = new Vector();
        for(int i=0;i<v.size();i++){
            String vName = ((Participant)v.elementAt(i)).getUsername();
            vNames.addElement(vName);
        }
        
        final JInterventionsPanel  jppi = this;
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                jppi.jList1.setListData(vNames);
                jppi.jList2.setListData(vNames);
            }
         });
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
