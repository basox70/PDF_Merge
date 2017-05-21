/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pdf.merge.application.DTO;

import pdf.merge.application.BLL.*;

import javax.swing.JFrame;
import javax.swing.JFileChooser;

import java.awt.event.*;
import java.io.File;

public class MainWindow extends javax.swing.JFrame {
    
	private static final long serialVersionUID = 1L;
	private String windowTitle = "Fusionneur de PDF";
    private String chooserDialogTitle = "Sélectionnez un dossier";
    private String noFolderSelectedMessage = "Aucun dossier n'a été sélectionné";
    
    private File[] fileList;
    private String absolutePath;
    
    private javax.swing.JMenu Aide;
    private javax.swing.JMenu Editer;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem MergePDF;
    private javax.swing.JMenuItem AddText;
    private javax.swing.JMenuItem OpenFolder;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem Settings;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea listContainer;
    
    /**
     * Creates new form mainWindow
     */
    public MainWindow() {
        initComponents();
        this.setTitle(windowTitle);
        this.setSize(750, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Editer.setEnabled(false);
        this.setVisible(true);
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listContainer = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        OpenFolder = new javax.swing.JMenuItem();
        Settings = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        Editer = new javax.swing.JMenu();
        MergePDF = new javax.swing.JMenuItem();
        AddText = new javax.swing.JMenuItem();
        Aide = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        listContainer.setEditable(false);
        listContainer.setColumns(20);
        listContainer.setRows(5);
        listContainer.setText("Sélectionnez un dossier");
        listContainer.setFocusable(false);
        listContainer.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jScrollPane1.setViewportView(listContainer);

        File.setText("Fichier");

        OpenFolder.setText("Ouvrir un dossier");
        OpenFolder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                OpenFolderActionPerformed(evt);
            }
        });
        File.add(OpenFolder);
        OpenFolder.getAccessibleContext().setAccessibleDescription("");

        Settings.setText("Réglages");

        File.add(Settings);

        Exit.setText("Quitter");
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        jMenuBar1.add(File);

        Editer.setText(" Editer");

        MergePDF.setText("Fusionner les fichiers");
        MergePDF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	MergePDFActionPerformed(evt);
            }
        });
        
        AddText.setText("Ajouter du texte");
        AddText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AddTextActionPerformed(evt);
            }
        });

        Editer.add(MergePDF);
        
        Editer.add(AddText);

        jMenuBar1.add(Editer);

        Aide.setText("Aide");

        jMenuBar1.add(Aide);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
    protected void MergePDFActionPerformed(ActionEvent evt) {
    	
	}

	private void AddTextActionPerformed(ActionEvent evt) {
		PDFEdit.Edit(fileList);
	}
    
    private void OpenFolderActionPerformed(ActionEvent evt) {//GEN-FIRST:event_OpenFolderActionPerformed
        displayBrowserWindow();
    }

    private void ExitActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }


    private void displayBrowserWindow() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("Desktop"));
        chooser.setDialogTitle(chooserDialogTitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            absolutePath = chooser.getSelectedFile().getAbsolutePath();
            fileList = FileFinder.find(absolutePath);
            printFileNames(fileList);
            Editer.setEnabled(true);
        } else {
            listContainer.setText("");
            listContainer.append(noFolderSelectedMessage);
        }
    }
    
    private void printFileNames(File[] fileList) {
        String fileNames = "";
        
        for (int i = 0; i < fileList.length; i++) {
            fileNames += fileList[i].getName() + "\n";
        }
        
        listContainer.setText("");
        listContainer.append(fileNames);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

}
