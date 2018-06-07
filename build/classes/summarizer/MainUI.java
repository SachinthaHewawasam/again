package summarizer;

import Database.ConnectDB;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class MainUI extends javax.swing.JFrame {

    ConnectDB db;
    Generator g = new Generator();
    String uname, inputDocLocation, summaryLocation;
    LoginUI lui;
    ImageIcon loadingGif = new ImageIcon(getClass().getResource("loading.gif"));

    public MainUI() {
        initComponents();
        setIcon();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }

    public void setVariables(String uName, ConnectDB DB, LoginUI l) {
        uname = uName;
        db = DB;
        lui = l;
        welcome.setText("Welcome " + uName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        Main = new javax.swing.JPanel();
        summaryLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        summary = new javax.swing.JTextPane();
        keywordLabel = new javax.swing.JLabel();
        ttsread = new javax.swing.JButton();
        summarize = new javax.swing.JButton();
        keyword = new javax.swing.JTextField();
        fileSelect = new javax.swing.JButton();
        logOut = new javax.swing.JButton();
        welcome = new javax.swing.JLabel();
        FileName = new javax.swing.JLabel();
        fileName = new javax.swing.JLabel();
        allResults = new javax.swing.JCheckBox();
        ttsstop = new javax.swing.JButton();
        loading = new javax.swing.JLabel();
        history = new javax.swing.JButton();

        fileChooser.setFileFilter(new MyCustomFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Main.setBackground(new java.awt.Color(0, 0, 0));

        summaryLabel.setForeground(new java.awt.Color(255, 255, 255));
        summaryLabel.setText("Summary");

        jScrollPane2.setViewportView(summary);

        keywordLabel.setForeground(new java.awt.Color(255, 255, 255));
        keywordLabel.setText("Enter Keyword");

        ttsread.setBackground(new java.awt.Color(0, 0, 0));
        ttsread.setText("Read");
        ttsread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttsreadActionPerformed(evt);
            }
        });

        summarize.setBackground(new java.awt.Color(0, 0, 0));
        summarize.setText("Summarize");
        summarize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summarizeActionPerformed(evt);
            }
        });

        keyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keywordActionPerformed(evt);
            }
        });

        fileSelect.setBackground(new java.awt.Color(0, 0, 0));
        fileSelect.setText("Select File");
        fileSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSelectActionPerformed(evt);
            }
        });

        logOut.setBackground(new java.awt.Color(0, 0, 0));
        logOut.setText("Log Out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        FileName.setForeground(new java.awt.Color(255, 255, 255));

        fileName.setForeground(new java.awt.Color(255, 255, 255));
        fileName.setText("Current File:");

        allResults.setBackground(new java.awt.Color(0, 0, 0));
        allResults.setForeground(new java.awt.Color(255, 255, 255));
        allResults.setText("Show all results");
        allResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allResultsActionPerformed(evt);
            }
        });

        ttsstop.setText("Stop");
        ttsstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttsstopActionPerformed(evt);
            }
        });

        loading.setText("jLabel1");

        history.setText("History");
        history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(summaryLabel)
                        .addGap(42, 42, 42)
                        .addComponent(fileSelect)
                        .addGap(18, 18, 18)
                        .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FileName, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                        .addGap(28, 28, 28)
                        .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(keywordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(summarize)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(4, 4, 4)))
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loading, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(allResults, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logOut)
                            .addComponent(ttsread, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ttsstop, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(history, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(MainLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(summaryLabel)
                                .addComponent(fileSelect)))
                        .addGroup(MainLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(logOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(welcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(MainLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(fileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(FileName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(summarize)
                            .addComponent(keywordLabel)))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(allResults)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(history)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(loading, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ttsread)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ttsstop)
                        .addGap(5, 5, 5)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ttsstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttsstopActionPerformed
        g.stopReadSummary();
    }//GEN-LAST:event_ttsstopActionPerformed

    private void allResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allResultsActionPerformed
        if (allResults.isSelected()) {
            summary.setText(g.allResults);
        } else {
            summary.setText(g.summary);
        }
    }//GEN-LAST:event_allResultsActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        this.setEnabled(false);
        summary.setText("");
        keyword.setText("");
        welcome.setText("");
        lui.setLocationRelativeTo(null);
        lui.setVisible(true);
    }//GEN-LAST:event_logOutActionPerformed

    private void fileSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSelectActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == fileChooser.APPROVE_OPTION) {
            loading.setIcon(loadingGif);
            Runnable filechooser = new Runnable() {
                public void run() {
                    g.reset();
                    File file = fileChooser.getSelectedFile();

                    g.loadFile(file.getAbsolutePath());
                    inputDocLocation = g.extractSentences(file.getName());
                    String temp = db.inputDoc(inputDocLocation, uname);
                    if (temp != null) {
                        inputDocLocation = temp;
                        FileName.setText(file.getName());
                    }
                    loading.setIcon(null);
                }
            };
            (new Thread(filechooser)).start();
        }
    }//GEN-LAST:event_fileSelectActionPerformed

    private void keywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keywordActionPerformed

    private void summarizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summarizeActionPerformed
        loading.setIcon(loadingGif);
        Runnable summarizer = new Runnable() {
            public void run() {
                summaryLocation = db.checkSummaryKey(inputDocLocation, keyword.getText());
                if (summaryLocation == null) {
                    g.setKeyword(keyword.getText());
                    summary.setText(null);
                    try {
                        g.generateSummary();
                        if (allResults.isSelected()) {
                            summary.setText(g.allResults);
                        } else {
                            summary.setText(g.summary);
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Scanner file = new Scanner(new File(summaryLocation));
                        summary.setText(file.next());
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                loading.setIcon(null);
            }
        };
        (new Thread(summarizer)).start();
    }//GEN-LAST:event_summarizeActionPerformed

    private void ttsreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttsreadActionPerformed
        if (allResults.isSelected()) {
            Runnable speaker = new Runnable() {
                public void run() {
                    g.readSummary(g.readAll);
                }
            };
            (new Thread(speaker)).start();
        } else {
            Runnable speaker = new Runnable() {
                public void run() {
                    g.readSummary(g.readSummary);
                }
            };
            (new Thread(speaker)).start();
        }
    }//GEN-LAST:event_ttsreadActionPerformed

    private void historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyActionPerformed
        
    }//GEN-LAST:event_historyActionPerformed

    class MyCustomFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getAbsolutePath().endsWith(".pdf");
        }

        @Override
        public String getDescription() {
            return "PDF documents (*.pdf)";
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //    new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FileName;
    private javax.swing.JPanel Main;
    private javax.swing.JCheckBox allResults;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel fileName;
    private javax.swing.JButton fileSelect;
    private javax.swing.JButton history;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keyword;
    private javax.swing.JLabel keywordLabel;
    private javax.swing.JLabel loading;
    private javax.swing.JButton logOut;
    private javax.swing.JButton summarize;
    private javax.swing.JTextPane summary;
    private javax.swing.JLabel summaryLabel;
    private javax.swing.JButton ttsread;
    private javax.swing.JButton ttsstop;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.jpg")));
    }
}
