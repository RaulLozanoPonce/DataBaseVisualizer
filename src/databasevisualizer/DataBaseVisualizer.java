package databasevisualizer;

import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

public class DataBaseVisualizer extends javax.swing.JFrame {
    
    private String accountName;
    private String accountPassword;
    private ResultSet rs;
    private Map<String, List<String>> data;
    private int selectionMode;

    public DataBaseVisualizer() {
        initComponents();
        setApp();
        setMnemonic();
        
        tableList.setModel(new DefaultListModel());
        tableList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        columnList.setModel(new DefaultListModel());
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(singleIntervalButton);
        buttonGroup.add(multipleIntervalButton);
        buttonGroup.add(singleSelectionButton);
        singleIntervalButton.setSelected(true);
        
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(singleIntervalMenuItem);
        buttonGroup2.add(multipleIntervalMenuItem);
        buttonGroup2.add(singleSelectionMenuItem);
        singleIntervalMenuItem.setSelected(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        singleIntervalButton = new javax.swing.JToggleButton();
        multipleIntervalButton = new javax.swing.JToggleButton();
        singleSelectionButton = new javax.swing.JToggleButton();
        loginButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        columnList = new javax.swing.JList<>();
        menuBar = new javax.swing.JMenuBar();
        conectionMenu = new javax.swing.JMenu();
        loginMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        selectionModeMenu = new javax.swing.JMenu();
        singleIntervalMenuItem = new javax.swing.JRadioButtonMenuItem();
        multipleIntervalMenuItem = new javax.swing.JRadioButtonMenuItem();
        singleSelectionMenuItem = new javax.swing.JRadioButtonMenuItem();
        helpMenu = new javax.swing.JMenu();
        infoMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modo de Selección"));

        singleIntervalButton.setText("Un intervalo");
        singleIntervalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleIntervalButtonActionPerformed(evt);
            }
        });

        multipleIntervalButton.setText("Muchos intervalos");
        multipleIntervalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multipleIntervalButtonActionPerformed(evt);
            }
        });

        singleSelectionButton.setText("Uno a uno");
        singleSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleSelectionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(multipleIntervalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(singleSelectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(singleIntervalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(singleIntervalButton)
                .addGap(18, 18, 18)
                .addComponent(multipleIntervalButton)
                .addGap(18, 18, 18)
                .addComponent(singleSelectionButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        loginButton.setText("Iniciar Sesion");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Tablas"));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Columnas"));

        columnList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(columnList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        conectionMenu.setText("Conexión");

        loginMenuItem.setText("Iniciar Sesión");
        loginMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMenuItemActionPerformed(evt);
            }
        });
        conectionMenu.add(loginMenuItem);
        conectionMenu.add(jSeparator1);

        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        conectionMenu.add(exitMenuItem);

        menuBar.add(conectionMenu);

        editMenu.setText("Editar");

        selectionModeMenu.setText("Modo de Seleccíon");

        singleIntervalMenuItem.setSelected(true);
        singleIntervalMenuItem.setText("Un Intervalo");
        singleIntervalMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleIntervalMenuItemActionPerformed(evt);
            }
        });
        selectionModeMenu.add(singleIntervalMenuItem);

        multipleIntervalMenuItem.setSelected(true);
        multipleIntervalMenuItem.setText("Muchos Intervalos");
        multipleIntervalMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multipleIntervalMenuItemActionPerformed(evt);
            }
        });
        selectionModeMenu.add(multipleIntervalMenuItem);

        singleSelectionMenuItem.setSelected(true);
        singleSelectionMenuItem.setText("Uno a Uno");
        singleSelectionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleSelectionMenuItemActionPerformed(evt);
            }
        });
        selectionModeMenu.add(singleSelectionMenuItem);

        editMenu.add(selectionModeMenu);

        menuBar.add(editMenu);

        helpMenu.setText("Ayuda");

        infoMenuItem.setText("Info.");
        infoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(infoMenuItem);
        helpMenu.add(jSeparator2);

        aboutMenuItem.setText("Acerca De");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(loginButton)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        login();
    }//GEN-LAST:event_loginButtonActionPerformed

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

    private void singleIntervalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleIntervalButtonActionPerformed
        selectionMode = ListSelectionModel.SINGLE_INTERVAL_SELECTION;
        tableList.setSelectionMode(selectionMode);
        singleIntervalMenuItem.setSelected(true);
    }//GEN-LAST:event_singleIntervalButtonActionPerformed

    private void multipleIntervalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multipleIntervalButtonActionPerformed
        selectionMode = ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
        tableList.setSelectionMode(selectionMode);
        multipleIntervalMenuItem.setSelected(true);
    }//GEN-LAST:event_multipleIntervalButtonActionPerformed

    private void singleSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleSelectionButtonActionPerformed
        selectionMode = ListSelectionModel.SINGLE_SELECTION;
        tableList.setSelectionMode(selectionMode);
        singleSelectionMenuItem.setSelected(true);
    }//GEN-LAST:event_singleSelectionButtonActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, "Diseñado por:\n ➡ Raúl Lozano Ponce\n ➡ Pablo Perdomo Falcón", "Acerca De MultiPhotoEditor", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        if(closeWindow()) System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(closeWindow()) System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void infoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoMenuItemActionPerformed
        String url_open ="https://es.wikipedia.org/wiki/Base_de_datos";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "La página web no ha sido cargada.", 
                    "Página web no cargada", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_infoMenuItemActionPerformed

    private void loginMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMenuItemActionPerformed
        login();
    }//GEN-LAST:event_loginMenuItemActionPerformed

    private void singleIntervalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleIntervalMenuItemActionPerformed
        selectionMode = ListSelectionModel.SINGLE_INTERVAL_SELECTION;
        tableList.setSelectionMode(selectionMode);
        singleIntervalButton.setSelected(true);
    }//GEN-LAST:event_singleIntervalMenuItemActionPerformed

    private void multipleIntervalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multipleIntervalMenuItemActionPerformed
        selectionMode = ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
        tableList.setSelectionMode(selectionMode);
        multipleIntervalButton.setSelected(true);
    }//GEN-LAST:event_multipleIntervalMenuItemActionPerformed

    private void singleSelectionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleSelectionMenuItemActionPerformed
        selectionMode = ListSelectionModel.SINGLE_SELECTION;
        tableList.setSelectionMode(selectionMode);
        singleSelectionButton.setSelected(true);
    }//GEN-LAST:event_singleSelectionMenuItemActionPerformed

    private void setApp(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setMinimumSize(getPreferredSize());
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Photos/Logo.png")));
        setTitle("DataBaseVisualizer");
    }
    
    private void setMnemonic() {
        //fileMenu.setMnemonic('A');
    }
    
    private void login() {
        getLogin();
        Connection con = databaseConnect();
        data = (con != null) ? databaseGetData(con) : null;
        DefaultListModel tableListModel = new DefaultListModel();
        tableListModel.clear();
        if(data != null) data.forEach((k,v) -> tableListModel.addElement(k));
        tableList.setModel(tableListModel);
    }
    
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
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "No se ha podido encontrar la clase \"Driver\".",
                    "Clase no encontrada", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        try {
            return DriverManager.getConnection("jdbc:mysql://mozart.dis.ulpgc.es/DIU_BD?useSSL=true", accountName, accountPassword);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "No se ha podido conectar con la base de datos.",
                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
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
            JOptionPane.showMessageDialog(null,
                    "No se han podido cargar los datos de la base de datos.",
                    "Datos no cargados", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    private boolean closeWindow(){
        return JOptionPane.showConfirmDialog(null,
                "¿Desea salir de DataBaseVisualizer?", "Salir",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    
    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        new DataBaseVisualizer().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JList<String> columnList;
    private javax.swing.JMenu conectionMenu;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem infoMenuItem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JButton loginButton;
    private javax.swing.JMenuItem loginMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JToggleButton multipleIntervalButton;
    private javax.swing.JRadioButtonMenuItem multipleIntervalMenuItem;
    private javax.swing.JMenu selectionModeMenu;
    private javax.swing.JToggleButton singleIntervalButton;
    private javax.swing.JRadioButtonMenuItem singleIntervalMenuItem;
    private javax.swing.JToggleButton singleSelectionButton;
    private javax.swing.JRadioButtonMenuItem singleSelectionMenuItem;
    private javax.swing.JList<String> tableList;
    // End of variables declaration//GEN-END:variables
}