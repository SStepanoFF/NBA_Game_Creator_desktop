package gamecreator;


import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import gamecreator.framework.DataBase;
import gamecreator.framework.Loader;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.load;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.text.DefaultFormatter;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import org.apache.commons.configuration.ConfigurationException;

public class GC_JFrame extends javax.swing.JFrame {
    
    private String gameName;
    private File gameFile;
    private FileWriter fileWriter = null;
    private DataBase dataBase=null;
    private String gameID=null;
    private int game_nmb=1;
    private int gameCount=1;
    private ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/gamecreator/NBALogoSmall.png"));
    private boolean dbCheck=true;
    private Date dt = null;
   
    public GC_JFrame() {
        initComponents(); 
        JSpinner.NumberEditor jsEditor = (JSpinner.NumberEditor)gameCountSpinner.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) jsEditor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //menu bar
        JMenu fileMenu = new JMenu("File");
        JMenu properMenu = new JMenu("Properties");
        JMenu aboutMenu = new JMenu("About");
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(properMenu);
        menuBar.add(aboutMenu);
        JMenuItem openGameAction = new JMenuItem("Open created file");
        JMenuItem openPropAction = new JMenuItem("View Property file");
        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem infoAction=new JMenuItem("Info");
        JCheckBoxMenuItem dbMenuChBxCh = new JCheckBoxMenuItem("Without Data Base verification");
        fileMenu.add(openGameAction);
        fileMenu.add(exitAction);
        properMenu.add(openPropAction);
        properMenu.add(dbMenuChBxCh);
        aboutMenu.add(infoAction);
                
        infoAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {                
                JOptionPane.showMessageDialog (null, "GameCreator_v0.3", "Info",1, icon);
            }
        });
        openGameAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{      
                    openTxtFile(gameFile.getPath());
                }catch (Exception ex){                    
                    JOptionPane.showMessageDialog (null, "File was not created!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        openPropAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                      openTxtFile(System.getProperty("user.dir")+"/Game.properties");
            }
        });
        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new GC_JFrame().dispatchEvent(new WindowEvent(new GC_JFrame(), WindowEvent.WINDOW_CLOSING));
            }
        });
        dbMenuChBxCh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (dbMenuChBxCh.isSelected()) dbCheck=false;
                else dbCheck=true;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createBtn = new javax.swing.JButton();
        timeG1TextField = new javax.swing.JTextField();
        timeG2TextField = new javax.swing.JTextField();
        testChBox = new javax.swing.JCheckBox();
        prodChBox = new javax.swing.JCheckBox();
        gameCountSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        timeG3TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        teamNameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NBA Game Creator");
        setBackground(new java.awt.Color(0, 153, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(icon.getImage());
        setLocationByPlatform(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        createBtn.setText("Create Game");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        timeG1TextField.setText("05:15");
        timeG1TextField.setToolTipText("");
        timeG1TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeG1TextFieldActionPerformed(evt);
            }
        });

        timeG2TextField.setText("05:15");
        timeG2TextField.setEnabled(false);
        timeG2TextField.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                timeG2TextFieldComponentHidden(evt);
            }
        });

        testChBox.setText("Add to test portal");
        testChBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testChBoxActionPerformed(evt);
            }
        });

        prodChBox.setText("Add to production portal");

        gameCountSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));
        gameCountSpinner.setToolTipText("");
        gameCountSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gameCountSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(gameCountSpinner, ""));
        gameCountSpinner.setValue(1);
        gameCountSpinner.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                gameCountSpinnerComponentAdded(evt);
            }
        });
        gameCountSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gameCountSpinnerStateChanged(evt);
            }
        });

        jLabel1.setText("Number of games:");

        timeG3TextField.setText("05:15");
        timeG3TextField.setEnabled(false);

        jLabel2.setText("Game1 Start EST Time:");

        jLabel3.setText("Game2 Start EST Time:");

        jLabel4.setText("Game3 Start EST Time:");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamecreator/NBALogo.svg.png"))); // NOI18N

        teamNameTextField.setText("WA_HOME");

        jLabel5.setText("Team Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(timeG1TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(timeG2TextField)
                                .addComponent(timeG3TextField))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(teamNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1))
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(testChBox)
                                .addComponent(prodChBox))
                            .addGap(25, 25, 25)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gameCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeG1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(gameCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeG2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(teamNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeG3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(testChBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prodChBox)
                        .addGap(18, 18, 18)
                        .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        dt = new Date();
        gameCount=(Integer)gameCountSpinner.getValue(); 
        gameID=Loader.loadProperty("gameID");      
        createGame();
        updateProperty();
        if (testChBox.isSelected()) downloadGameToSFTP("/test/");
        if (prodChBox.isSelected()) downloadGameToSFTP("/");
        JOptionPane.showMessageDialog (null, "File was created!", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_createBtnActionPerformed

    private void gameCountSpinnerComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_gameCountSpinnerComponentAdded
     
    }//GEN-LAST:event_gameCountSpinnerComponentAdded

    private void testChBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testChBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testChBoxActionPerformed

    private void timeG2TextFieldComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_timeG2TextFieldComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_timeG2TextFieldComponentHidden

    private void gameCountSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gameCountSpinnerStateChanged
        if ((Integer)gameCountSpinner.getValue()>=2)timeG2TextField.setEnabled(true);
        else timeG2TextField.setEnabled(false);
        if ((Integer)gameCountSpinner.getValue()>=3)timeG3TextField.setEnabled(true);
        else timeG3TextField.setEnabled(false);
    }//GEN-LAST:event_gameCountSpinnerStateChanged

    private void timeG1TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeG1TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeG1TextFieldActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GC_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GC_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GC_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GC_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GC_JFrame().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createBtn;
    private javax.swing.JSpinner gameCountSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JCheckBox prodChBox;
    private javax.swing.JTextField teamNameTextField;
    private javax.swing.JCheckBox testChBox;
    private javax.swing.JTextField timeG1TextField;
    private javax.swing.JTextField timeG2TextField;
    private javax.swing.JTextField timeG3TextField;
    // End of variables declaration//GEN-END:variables

private void createGame() {         
        String game_nmbProp=Loader.loadProperty(takeCurrentDate("dd/MM/YYYY")+"_game_nmb");
        if (game_nmbProp!=null){                     //takeCurrentDate("dd/MM/YYYY")+
            game_nmb=Integer.parseInt(game_nmbProp)+gameCount;
        }else game_nmb=gameCount;    
        gameName=takeCurrentDate("YYYMMdd")+"000"+Integer.toString(game_nmb)+"_nba_todays_schedule";
        gameFile = new File(gameName+".xml"); //System.getProperty("user.dir")+"\\Games\\"+
        writeToFile("<Msg_file LeagueID=\"00\" League=\"NBA\" Season=\"2014-15\" SeasonType=\"Regular Season\">\r\n" +
                "  <Game Number=\"0\">\r\n" +              
                gameBodytext()+
                "  </Game>\r\n" +
                "</Msg_file>");
    }

    private String gameBodytext(){
        String game_time="";
        int utcDif=5;
        int month=dt.getMonth();
        int day=dt.getDate();
        int dayNum=dt.getDay();
       // if (dayNum==0) dayNum=7;
        int time=Integer.parseInt(takeCurrentDate("HH"));
        if (dt.getMonth()>=10 || dt.getMonth()<2){      //set winter time
            if(dt.getMonth()==10 && dt.getDate()<=7 && dayNum>dt.getDate()){  
                utcDif=4;
            }else utcDif=5;
            if(dt.getMonth()==10 && dt.getDate()<=7 && dayNum==0 && time<9){  
                utcDif=4;
            }
        }
        if (dt.getMonth()>=2 && dt.getMonth()<10){   //set summer time
            if(dt.getMonth()==2 && dt.getDate()<=14 && dayNum>dt.getDate()-7){ //&& dt.getDate()>=7
                utcDif=5;
            }else utcDif=4;
            if(dt.getMonth()==2 && dt.getDate()>7 && dt.getDate()<=14 && dayNum==0 && time<9){ 
                utcDif=5;}
        }
        if (dbCheck)dataBase=new DataBase();  
                  
        String text="";
        String teamName=teamNameTextField.getText();
        for (int i=0; i<gameCount; i++){
            if(i==0) game_time=timeG1TextField.getText();
            if(i==1) game_time=timeG2TextField.getText();
            if(i==2) game_time=timeG3TextField.getText();
            String UTC_time=Integer.toString(Integer.parseInt(game_time.substring(0,2))+utcDif)+game_time.substring(2,5);
            if (dbCheck)gameID=dataBase.getGameID(gameID);
            if (gameID.contains("Err")){throw new RuntimeException("ERROR! Can't create Game file.");}
            text+="\t<Msg_game_info>\r\n" +
                "\t\t<Game_info Game_id=\""+ gameID+"\" Game_date=\""+takeCurrentDate("MM/dd/YYYY")+"\" Game_time=\""+game_time+" AM\" Home_time=\""+game_time+" AM\" Visitor_time=\""+game_time+" AM\" Arena_name=\"Forbes Road Pavilion\" Location=\"Braintree, MA\" PPD_Status=\"I\" Game_date_UTC=\""+takeCurrentDate("YYYY-MM-dd")+"\" Game_time_UTC=\""+UTC_time+"\" />\r\n" +
                "\t\t<Home_team Team_id=\"7818498118\" Team_city=\"Braintree\" Team_name=\"Quality\" Team_abr=\""+teamName+"\" />\r\n" +
                "\t\t<Visitor_team Team_id=\"7818498119\" Team_city=\"\" Team_name=\"Assurance\" Team_abr=\"WA_AWAY\" />\r\n" +
                "\t\t<TV_Info Home=\"NA_QA\" Away=\"NA_QA2\" Natnl=\"NA_QA3\" Canadian=\"NA_QA4\" />\r\n" +
                "\t</Msg_game_info>\r\n";
        }
        return text;
    }

    private void writeToFile(String text) {
        try {
            fileWriter = new FileWriter(gameFile);
            fileWriter.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog (null, "ERROR! Can't write to file!", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String takeCurrentDate(String formatDate){        
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatDate);
        return dateFormat.format(dt);
    }
    
    public void updateProperty() {
        Loader.updateProperty("gameID",gameID);
        Loader.updateProperty(takeCurrentDate("dd/MM/YYYY")+"_game_nmb", Integer.toString(game_nmb));
    }
    
    private void downloadGameToSFTP(String destination) {
         JSch jsch = new JSch();
         Session session = null;
	        try {
			//open session
	            session = jsch.getSession("nba", "sftp.keysurvey.com", 22);
                    
                    //configure authentication
	            session.setConfig("nba", "Hd8kfc4xzx");
	            session.setPassword("Hd8kfc4xzx");
                    java.util.Properties config = new java.util.Properties();
                    config.put("StrictHostKeyChecking", "no");
                    session.setConfig(config);
	            session.connect();
				//open sftp channel
	            Channel channel = session.openChannel("sftp");
	            channel.connect();
	            ChannelSftp sftpChannel = (ChannelSftp) channel;
	            sftpChannel.put(gameFile.getPath(),destination);
                    sftpChannel.stat(destination+gameFile);    //verify file exists in SFTP
	            sftpChannel.exit();
	            session.disconnect();
	        } catch (JSchException e) {
	            e.printStackTrace();
                    JOptionPane.showMessageDialog (null, "Can't connect to SFTP server!", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        catch (SftpException e) {
	            e.printStackTrace();
                    if (destination=="/test/")
                    JOptionPane.showMessageDialog (null, "File was NOT downloaded to TEST SFTP server!", "Error", JOptionPane.ERROR_MESSAGE);
                    else
                    JOptionPane.showMessageDialog (null, "File was NOT downloaded to PROD SFTP server!", "Error", JOptionPane.ERROR_MESSAGE);
	        }
      }
    
    private void openTxtFile(String path){
        try {
            Runtime rt = Runtime.getRuntime();
            Process p= rt.exec("notepad.exe "+path);
        } catch (Exception ex) {           
            JOptionPane.showMessageDialog (null, "Can't find file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
