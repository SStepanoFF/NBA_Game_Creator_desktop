package gamecreator;


import gamecreator.framework.DataBase;
import gamecreator.framework.Loader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GC_JFrame extends javax.swing.JFrame {
    
    private String gameName;
    private File outputDir= new File(System.getProperty("user.dir")+"\\Games1\\"); //System.getProperty("user.dir")+
    private File gameFile;
    private FileWriter fileWriter = null;
    private DataBase dataBase=new DataBase();
    private String gameID=Loader.loadProperty("gameID");
   // private String game_time="08:37";
    

    
    public GC_JFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createBtn = new javax.swing.JButton();
        timeTextField = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createBtn.setText("Create");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        timeTextField.setText("10:10");
        timeTextField.setToolTipText("");

        jTextField2.setText("jTextField2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(createBtn)
                .addGap(115, 115, 115))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed

        String time=timeTextField.getText();
        jTextField2.setText(time);
        createGame(timeTextField.getText());
    }//GEN-LAST:event_createBtnActionPerformed

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
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField timeTextField;
    // End of variables declaration//GEN-END:variables

public void createGame(String game_time) {
        String UTC_time=Integer.toString(Integer.parseInt(game_time.substring(0,2))+5)+game_time.substring(2,5);
       // gameID=dataBase.getGameID(gameID);
        if (gameID.contains("Err")){throw new RuntimeException("ERROR! Can't create Game file.");}
        gameName=takeCurrentDate("YYYMMdd")+"0001_nba_todays_schedule";
        if(!outputDir.exists()) {
            try {
                outputDir.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(GC_JFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        gameFile = new File(System.getProperty("user.dir")+"\\Games\\"+gameName+".xml");
        writeToFile("<Msg_file LeagueID=\"00\" League=\"NBA\" Season=\"2014-15\" SeasonType=\"Regular Season\">\r\n" +
                "  <Game Number=\"0\">\r\n" +
                "\t<Msg_game_info>\r\n" +
                "\t\t<Game_info Game_id=\""+ gameID+"\" Game_date=\""+takeCurrentDate("MM/dd/YYYY")+"\" Game_time=\""+game_time+" AM\" Home_time=\""+game_time+" AM\" Visitor_time=\""+game_time+" AM\" Arena_name=\"Forbes Road Pavilion\" Location=\"Braintree, MA\" PPD_Status=\"I\" Game_date_UTC=\""+takeCurrentDate("YYYY-MM-dd")+"\" Game_time_UTC=\""+UTC_time+"\" />\r\n" +
                "\t\t<Home_team Team_id=\"7818498118\" Team_city=\"Braintree\" Team_name=\"Quality\" Team_abr=\"WA_HOME\" />\r\n" +
                "\t\t<Visitor_team Team_id=\"7818498119\" Team_city=\"\" Team_name=\"Assurance\" Team_abr=\"WA_AWAY\" />\r\n" +
                "\t\t<TV_Info Home=\"NA_QA\" Away=\"NA_QA2\" Natnl=\"NA_QA3\" Canadian=\"NA_QA4\" />\r\n" +
                "\t</Msg_game_info>\r\n" +
                "  </Game>\r\n" +
                "</Msg_file>");
    }

    private void writeToFile(String text) {
        try {
            fileWriter = new FileWriter(gameFile);
            fileWriter.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR! Can't write to Game file.");
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
        Date dt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatDate);
        return dateFormat.format(dt);
    }

//    public Date dataConvertfromString(String text) {
//        Date date=null;
//        try{
//            SimpleDateFormat format=new SimpleDateFormat("HH:mm", Locale.UK);
//            date=format.parse(text);
//        }catch (ParseException e){}
//        return date;
//    }

    private void findGameID(){
        gameID=Integer.toString(Integer.parseInt(gameID)+1);
        boolean findGameId=false;
            while (!findGameId) {
                if (dataBase.getGameID(gameID) == null) {
                    findGameId = true;
                } else {
                    gameID = Integer.toString(Integer.parseInt(gameID) + 1);
                }
            }
    }
}
