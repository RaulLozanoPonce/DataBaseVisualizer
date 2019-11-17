package databasevisualizer;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.*;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;

public class DataBaseVisualizer extends javax.swing.JFrame {
    
    private String accountName;
    private String accountPassword;
    private ResultSet rs;
    private Map<String, List<String>> data;
    private int selectionMode;

    public DataBaseVisualizer() {
        initComponents();
        tableList.setModel(new DefaultListModel());
        tableList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        columnList.setModel(new DefaultListModel());;
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jToggleButton1);
        buttonGroup.add(jToggleButton2);
        buttonGroup.add(jToggleButton3);
        jToggleButton1.setSelected(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        columnList = new javax.swing.JList<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Iniciar Sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        tableList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableList);

        columnList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(columnList);

        jToggleButton1.setText("Un intervalo");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Muchos intervalos");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Uno a uno");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getLogin();
        Connection con = databaseConnect();
        data = (con != null) ? databaseGetData(con) : null;
        DefaultListModel tableListModel = new DefaultListModel();
        tableListModel.clear();
        data.forEach((k,v) -> tableListModel.addElement(k));
        tableList.setModel(tableListModel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListMouseClicked
        DefaultListModel columnListModel = new DefaultListModel();
        columnListModel.clear();
        tableList.getSelectedValuesList().forEach((key) -> {
            data.get(key).forEach((column) -> {
                columnListModel.addElement(key + "." + column);
            });
        });
        columnList.setModel(columnListModel);
    }//GEN-LAST:event_tableListMouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        selectionMode = ListSelectionModel.SINGLE_INTERVAL_SELECTION;
        tableList.setSelectionMode(selectionMode);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        selectionMode = ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
        tableList.setSelectionMode(selectionMode);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        selectionMode = ListSelectionModel.SINGLE_SELECTION;
        tableList.setSelectionMode(selectionMode);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void getLogin(){
        JOptionPane optionPane = new JOptionPane();
        JTextField accountNameTextField = new JTextField("");
        JPasswordField accountPasswordTextField = new JPasswordField("");
        optionPane.setMessage(new Object[] {"Nombre de cuenta: ", accountNameTextField, "Contraseña: ", accountPasswordTextField});
        optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
        optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
        JDialog dialog = optionPane.createDialog(this, "Iniciar Sesión");
        dialog.setVisible(true);
        accountName = accountNameTextField.getText();
        accountPassword = String.valueOf(accountPasswordTextField.getPassword());
    }
    
    private Connection databaseConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {System.out.println("classnotfound"); return null;}
        
        try {
            return DriverManager.getConnection("jdbc:mysql://mozart.dis.ulpgc.es/DIU_BD?useSSL=true", "estudiante-DIU", "DIU-aed56-noi");
        } catch (SQLException ex) {System.out.println("SQLEXC1");}
        return null;
    }
    
    private Map<String, List<String>> databaseGetData(Connection con){
        Map<String, List<String>> tables = new HashMap<>();
        List<String> columns;
        try {
            DatabaseMetaData md = con.getMetaData();
            rs = md.getTables(null, null, "%", new String[] {"TABLE"});
            while(rs.next()){
                String nombreTabla = rs.getString("TABLE_NAME");
                ResultSet rs2 = md.getColumns(null, null, nombreTabla, null);
                columns = new ArrayList<>();
                while(rs2.next()){
                    String nombreCampo = rs2.getString("COLUMN_NAME");
                    columns.add(nombreCampo);
                }
                tables.put(nombreTabla, columns);
            }
            con.close();
            return tables;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseVisualizer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String args[]) throws Exception {
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        new DataBaseVisualizer().setVisible(true);
    }
    public void pepe(){
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> columnList;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JList<String> tableList;
    // End of variables declaration//GEN-END:variables
}
