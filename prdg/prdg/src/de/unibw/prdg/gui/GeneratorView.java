/*
 * GeneratorView.java
 */

package de.unibw.prdg.gui;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jdesktop.application.Action;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.SingleFrameApplication;

import de.unibw.prdg.ScenarioGenerator;
import de.unibw.prdg.Verteilung;
import de.unibw.prdg.Verteilungsparameter;

/**
 * The application's main frame.
 */
public class GeneratorView extends FrameView {
	private ImageViewer imageViewer;
	private JFileChooser generatorFileChooser;


    public GeneratorView(SingleFrameApplication app) {
        super(app);
        getFrame().setTitle("Szenario Generator");

        initComponents();
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = GeneratorApp.getApplication().getMainFrame();
            aboutBox = new GeneratorAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        GeneratorApp.getApplication().show(aboutBox);
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        this.getFrame().addWindowListener(
                new WindowListener() {
					
					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowClosing(WindowEvent e) {
	                      System.exit(0);	
					}
					
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
    	
    	imageViewer = new ImageViewer();
    	GeneratorApp.getApplication().show(imageViewer);
    	imageViewer.setSize(505,410);
    	imageViewer.setResizable(false);
    	imageViewer.setLocation(0, 0);
    	
    	generatorFileChooser = new javax.swing.JFileChooser();
    	generatorFileChooser.setCurrentDirectory(new java.io.File("data"));
    	generatorFileChooser.setDialogTitle("Erzeugten Datensatz speichern");
    	generatorFileChooser.setFileFilter(new FileNameExtensionFilter(
                        "INT-Dateien", "int"));
        mainPanel = new javax.swing.JPanel();
        panelZeitraum = new javax.swing.JPanel();
        labelZeitraum = new javax.swing.JLabel();
        labelZeitraumBeginn = new javax.swing.JLabel();
        labelZeitraumEnde = new javax.swing.JLabel();
        textZeitraumBeginn = new javax.swing.JTextField();
        textZeitraumEnde = new javax.swing.JTextField();
        labelAnzahl = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        panelParameter = new javax.swing.JPanel();
        labelParameter = new javax.swing.JLabel();
        labelParameterBeginn = new javax.swing.JLabel();
        labelParameterDauer = new javax.swing.JLabel();
        comboBoxParameterBeginnVerteilung = new javax.swing.JComboBox();
        labelParameterBeginnMittel = new javax.swing.JLabel();
        labelParameterBeginnVarianz = new javax.swing.JLabel();
        textParameterBeginnVarianz = new javax.swing.JTextField();
        textParameterBeginnMittel = new javax.swing.JTextField();
        comboBoxParameterDauerVerteilung = new javax.swing.JComboBox();
        labelParameterDauerA = new javax.swing.JLabel();
        textParameterDauerA = new javax.swing.JTextField();
        labelParameterDauerB = new javax.swing.JLabel();
        textParameterDauerB = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        labelSeed = new javax.swing.JLabel();
        textSeed = new javax.swing.JTextField();
        buttonErzeugen = new javax.swing.JButton();
        buttonSeedGenerieren = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.BorderLayout());

        panelZeitraum.setName("panelZeitraum"); // NOI18N

        labelZeitraum.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelZeitraum.setText("Zeitraum");
        labelZeitraum.setName("labelZeitraum"); // NOI18N

        labelZeitraumBeginn.setText("Beginn:");
        labelZeitraumBeginn.setName("labelZeitraumBeginn"); // NOI18N

        labelZeitraumEnde.setText("Ende:");
        labelZeitraumEnde.setName("labelZeitraumEnde"); // NOI18N

        textZeitraumBeginn.setText("0");
        textZeitraumBeginn.setName("textZeitraumBeginn"); // NOI18N
        textZeitraumBeginn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textZeitraumBeginnActionPerformed(evt);
            }
        });

        textZeitraumEnde.setText("200");
        textZeitraumEnde.setName("textZeitraumEnde"); // NOI18N
        textZeitraumEnde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textZeitraumEndeActionPerformed(evt);
            }
        });

        labelAnzahl.setText("Anzahl:");
        labelAnzahl.setName("labelAnzahl"); // NOI18N

        jTextField2.setText("100");
        jTextField2.setName("jTextField2"); // NOI18N

        javax.swing.GroupLayout panelZeitraumLayout = new javax.swing.GroupLayout(panelZeitraum);
        panelZeitraum.setLayout(panelZeitraumLayout);
        panelZeitraumLayout.setHorizontalGroup(
            panelZeitraumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelZeitraumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelZeitraumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelZeitraumEnde)
                    .addComponent(labelZeitraumBeginn)
                    .addComponent(labelZeitraum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelZeitraumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textZeitraumBeginn)
                    .addComponent(textZeitraumEnde, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelAnzahl)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        panelZeitraumLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField2, textZeitraumBeginn, textZeitraumEnde});

        panelZeitraumLayout.setVerticalGroup(
            panelZeitraumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelZeitraumLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelZeitraum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelZeitraumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelZeitraumBeginn)
                    .addComponent(textZeitraumBeginn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAnzahl)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelZeitraumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelZeitraumEnde)
                    .addComponent(textZeitraumEnde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        mainPanel.add(panelZeitraum, java.awt.BorderLayout.PAGE_START);

        panelParameter.setName("panelParameter"); // NOI18N

        labelParameter.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelParameter.setText("Auftr�ge");
        labelParameter.setName("labelParameter"); // NOI18N

        labelParameterBeginn.setText("Beginn:");
        labelParameterBeginn.setName("labelParameterBeginn"); // NOI18N

        labelParameterDauer.setText("Dauer:");
        labelParameterDauer.setName("labelParameterDauer"); // NOI18N

        comboBoxParameterBeginnVerteilung.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normalverteilung", "Gleichverteilung", "Exponentialverteilung", "Chi-Quadrat Verteilung" }));
        comboBoxParameterBeginnVerteilung.setName("comboBoxParameterBeginnVerteilung"); // NOI18N
        comboBoxParameterBeginnVerteilung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionBeginnVerteilung(evt);
            }
        });
        comboBoxParameterBeginnVerteilung.addActionListener(imageViewer);
        comboBoxParameterBeginnVerteilung.setSelectedIndex(0);

        labelParameterBeginnMittel.setText("Mittelwert:");
        labelParameterBeginnMittel.setName("labelParameterBeginnMittel"); // NOI18N

        labelParameterBeginnVarianz.setText("Varianz:");
        labelParameterBeginnVarianz.setName("labelParameterBeginnVarianz"); // NOI18N

        textParameterBeginnVarianz.setText("3");
        textParameterBeginnVarianz.setName("textParameterBeginnVarianz"); // NOI18N
        textParameterBeginnVarianz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textParameterBeginnVarianzActionPerformed(evt);
            }
        });

        textParameterBeginnMittel.setText("10");
        textParameterBeginnMittel.setName("textParameterBeginnMittel"); // NOI18N
        textParameterBeginnMittel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textParameterBeginnMittelActionPerformed(evt);
            }
        });

        comboBoxParameterDauerVerteilung.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normalverteilung", "Gleichverteilung", "Exponentialverteilung", "Chi-Quadrat Verteilung" }));
        comboBoxParameterDauerVerteilung.setName("comboBoxParameterDauerVerteilung"); // NOI18N
        comboBoxParameterDauerVerteilung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxParameterDauerVerteilungActionPerformed(evt);
            }
        });
        comboBoxParameterDauerVerteilung.addActionListener(imageViewer);

        labelParameterDauerA.setText("Mittelwert:");
        labelParameterDauerA.setName("labelParameterDauerA"); // NOI18N

        textParameterDauerA.setMinimumSize(new Dimension(75,12));
        textParameterDauerA.setText("10");
        textParameterDauerA.setName("textParameterDauerA"); // NOI18N
        textParameterDauerA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textParameterDauerAActionPerformed(evt);
            }
        });

        labelParameterDauerB.setText("Varianz:");
        labelParameterDauerB.setName("labelParameterDauerB"); // NOI18N

        textParameterDauerB.setMinimumSize(new Dimension(75,12));
        textParameterDauerB.setText("3");
        textParameterDauerB.setName("textParameterDauerB"); // NOI18N
        textParameterDauerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textParameterDauerBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelParameterLayout = new javax.swing.GroupLayout(panelParameter);
        panelParameter.setLayout(panelParameterLayout);
        panelParameterLayout.setHorizontalGroup(
            panelParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParameterLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelParameterBeginnVarianz)
                    .addGroup(panelParameterLayout.createSequentialGroup()
                        .addGroup(panelParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelParameter, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelParameterBeginn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelParameterDauer, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelParameterLayout.createSequentialGroup()
                                .addComponent(comboBoxParameterBeginnVerteilung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelParameterBeginnMittel))
                            .addGroup(panelParameterLayout.createSequentialGroup()
                                .addComponent(comboBoxParameterDauerVerteilung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelParameterDauerA))))
                    .addComponent(labelParameterDauerB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textParameterDauerA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textParameterDauerB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(textParameterBeginnVarianz, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(textParameterBeginnMittel))
                .addContainerGap())
        );
        panelParameterLayout.setVerticalGroup(
            panelParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParameterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelParameter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelParameterBeginn)
                    .addComponent(comboBoxParameterBeginnVerteilung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelParameterBeginnMittel)
                    .addComponent(textParameterBeginnMittel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelParameterBeginnVarianz)
                    .addComponent(textParameterBeginnVarianz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelParameterDauer)
                    .addComponent(comboBoxParameterDauerVerteilung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelParameterDauerA)
                    .addComponent(textParameterDauerA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelParameterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelParameterDauerB)
                    .addComponent(textParameterDauerB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(panelParameter, java.awt.BorderLayout.CENTER);

        jPanel1.setName("jPanel1"); // NOI18N

        labelSeed.setText("Seed:");
        labelSeed.setName("labelSeed"); // NOI18N

        textSeed.setMinimumSize(new Dimension(160, 12));
        textSeed.setText("1");
        textSeed.setName("textSeed"); // NOI18N
        textSeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSeedActionPerformed(evt);
            }
        });

        buttonErzeugen.setText("Erzeugen & Speichern..");
        buttonErzeugen.setName("buttonErzeugen"); // NOI18N
        buttonErzeugen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonErzeugenActionPerformed(evt);
            }
        });

        buttonSeedGenerieren.setText("Seed generieren");
        buttonSeedGenerieren.setName("buttonSeedGenerieren"); // NOI18N
        buttonSeedGenerieren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSeedGenerierenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelSeed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textSeed, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSeedGenerieren, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonErzeugen)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSeed)
                    .addComponent(buttonSeedGenerieren))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonErzeugen)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText("Datei");
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(de.unibw.prdg.gui.GeneratorApp.class).getContext().getActionMap(GeneratorView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setText("Schlie�en");
        exitMenuItem.setToolTipText("Schlie�en der Anwendung");
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Hilfe");
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    private void actionBeginnVerteilung(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionBeginnVerteilung 
		
    	switch (comboBoxParameterBeginnVerteilung.getSelectedIndex()) {
		case 0: {
            labelParameterBeginnMittel.setVisible(true);
            labelParameterBeginnVarianz.setVisible(true);
            textParameterBeginnVarianz.setVisible(true);
            textParameterBeginnMittel.setVisible(true);
            labelParameterBeginnMittel.setText("Mittelwert:");
            labelParameterBeginnVarianz.setText("Varianz:");
            textParameterBeginnMittel.setText("10");
            textParameterBeginnVarianz.setText("3");
		}
			break;
		case 1: {
            labelParameterBeginnMittel.setVisible(false);
            labelParameterBeginnVarianz.setVisible(false);
            textParameterBeginnVarianz.setVisible(false);
            textParameterBeginnMittel.setVisible(false);
		}
			break;
		case 2: {
            labelParameterBeginnMittel.setVisible(true);
            labelParameterBeginnVarianz.setVisible(false);
            textParameterBeginnVarianz.setVisible(false);
            textParameterBeginnMittel.setVisible(true);
            labelParameterBeginnMittel.setText("Lambda:");
            textParameterBeginnMittel.setText("0.5");
		}
			break;
		case 3: {
            labelParameterBeginnMittel.setVisible(true);
            labelParameterBeginnVarianz.setVisible(false);
            textParameterBeginnVarianz.setVisible(false);
            textParameterBeginnMittel.setVisible(true);
            labelParameterBeginnMittel.setText("n:");
            textParameterBeginnMittel.setText("3");
		}
			break;

		default:
			break;
		}
    }//GEN-LAST:event_actionBeginnVerteilung

    private void comboBoxParameterDauerVerteilungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxParameterDauerVerteilungActionPerformed
		switch (comboBoxParameterDauerVerteilung.getSelectedIndex()) {
		case 0: {
            labelParameterDauerA.setVisible(true);
            labelParameterDauerB.setVisible(true);
            textParameterDauerA.setVisible(true);
            textParameterDauerB.setVisible(true);
            labelParameterDauerA.setText("Mittelwert:");
            labelParameterDauerB.setText("Varianz:");
            textParameterDauerA.setText("10");
            textParameterDauerB.setText("3");
		}
			break;
		case 1: {
            labelParameterDauerA.setVisible(true);
            labelParameterDauerB.setVisible(true);
            textParameterDauerA.setVisible(true);
            textParameterDauerB.setVisible(true);
            labelParameterDauerA.setText("Beginn:");
            labelParameterDauerB.setText("Ende:");
            textParameterDauerA.setText("0");
            textParameterDauerB.setText("10");
		}
			break;
		case 2: {
            labelParameterDauerA.setVisible(true);
            labelParameterDauerB.setVisible(false);
            textParameterDauerA.setVisible(true);
            textParameterDauerB.setVisible(false);
            labelParameterDauerA.setText("Lambda:");
            textParameterDauerA.setText("0.5");
		}
			break;
		case 3: {
            labelParameterDauerA.setVisible(true);
            labelParameterDauerB.setVisible(false);
            textParameterDauerA.setVisible(true);
            textParameterDauerB.setVisible(false);
            labelParameterDauerA.setText("n:");
            textParameterDauerA.setText("3");
		}
			break;

		default:
			break;
		}
    }//GEN-LAST:event_comboBoxParameterDauerVerteilungActionPerformed

    private void buttonErzeugenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonErzeugenActionPerformed
        // Variablendeklaration
    	File dataFile;
		int jobCount;
		int start;
		int ende;
		long seed;
		
		double parameterBeginn1;
		double parameterBeginn2;
		
		double parameterDauer1;
		double parameterDauer2;
		
		try {
			 jobCount = Integer.parseInt(jTextField2.getText());
			 start = Integer.parseInt(textZeitraumBeginn.getText());
			 ende = Integer.parseInt(textZeitraumEnde.getText());
			 seed = Long.parseLong(textSeed.getText());

			 parameterBeginn1 = Double.parseDouble(textParameterBeginnMittel.getText());
			 parameterBeginn2 = Double.parseDouble(textParameterBeginnVarianz.getText());

			 parameterDauer1 = Double.parseDouble(textParameterDauerA.getText());
			 parameterDauer2 = Double.parseDouble(textParameterDauerB.getText());
			 
			Verteilungsparameter beginn; 
			Verteilungsparameter dauer;
			 
			 switch (comboBoxParameterBeginnVerteilung.getSelectedIndex()) {
				case 0: {
					double[] parameterB = {parameterBeginn1, parameterBeginn2};
		            beginn = new Verteilungsparameter(Verteilung.Normal, parameterB);
				}
					break;
				case 1: {
					double[] parameterB = {start, ende};
		            beginn = new Verteilungsparameter(Verteilung.Uniform, parameterB);
				}
					break;
				case 2: {
					double[] parameterB = {parameterBeginn1};
		            beginn = new Verteilungsparameter(Verteilung.Exponential, parameterB);
				}
					break;
				case 3: {
					double[] parameterB = {parameterBeginn1};
		            beginn = new Verteilungsparameter(Verteilung.ChiSqr, parameterB);
				}
					break;

				default:
					throw new Exception(); 
				}
			 
			 switch (comboBoxParameterDauerVerteilung.getSelectedIndex()) {
				case 0: {
					double[] parameterD = {parameterDauer1, parameterDauer2};
					dauer = new Verteilungsparameter(Verteilung.Normal, parameterD);
				}
					break;
				case 1: {
					double[] parameterD = {parameterDauer1, parameterDauer2};
					dauer = new Verteilungsparameter(Verteilung.Uniform, parameterD);
				}
					break;
				case 2: {
					double[] parameterD = {parameterDauer1};
					dauer = new Verteilungsparameter(Verteilung.Exponential, parameterD);
				}
					break;
				case 3: {
					double[] parameterD = {parameterDauer1};
					dauer = new Verteilungsparameter(Verteilung.ChiSqr, parameterD);
				}
					break;

				default:
					throw new Exception(); 
				}
			 
			 ScenarioGenerator generator = new ScenarioGenerator(jobCount, start, ende, seed, beginn, dauer);
   	
   	int returnVal = generatorFileChooser.showSaveDialog(this.getFrame());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			dataFile = generatorFileChooser.getSelectedFile();
			generator.saveDataFile(dataFile);
		}
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage() + " Erzeugung der Daten abgebrochen.", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		       
    }//GEN-LAST:event_buttonErzeugenActionPerformed

    private void textZeitraumBeginnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textZeitraumBeginnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textZeitraumBeginnActionPerformed

    private void textZeitraumEndeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textZeitraumEndeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textZeitraumEndeActionPerformed

    private void textParameterBeginnMittelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textParameterBeginnMittelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textParameterBeginnMittelActionPerformed

    private void textParameterBeginnVarianzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textParameterBeginnVarianzActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textParameterBeginnVarianzActionPerformed

    private void textParameterDauerAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textParameterDauerAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textParameterDauerAActionPerformed

    private void textParameterDauerBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textParameterDauerBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textParameterDauerBActionPerformed

    private void textSeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSeedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSeedActionPerformed

    private void buttonSeedGenerierenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSeedGenerierenActionPerformed
       textSeed.setText(Long.toString((new SecureRandom()).nextLong()));
    }//GEN-LAST:event_buttonSeedGenerierenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonErzeugen;
    private javax.swing.JButton buttonSeedGenerieren;
    private javax.swing.JComboBox comboBoxParameterBeginnVerteilung;
    private javax.swing.JComboBox comboBoxParameterDauerVerteilung;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelAnzahl;
    private javax.swing.JLabel labelParameter;
    private javax.swing.JLabel labelParameterBeginn;
    private javax.swing.JLabel labelParameterBeginnMittel;
    private javax.swing.JLabel labelParameterBeginnVarianz;
    private javax.swing.JLabel labelParameterDauer;
    private javax.swing.JLabel labelParameterDauerA;
    private javax.swing.JLabel labelParameterDauerB;
    private javax.swing.JLabel labelSeed;
    private javax.swing.JLabel labelZeitraum;
    private javax.swing.JLabel labelZeitraumBeginn;
    private javax.swing.JLabel labelZeitraumEnde;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelParameter;
    private javax.swing.JPanel panelZeitraum;
    private javax.swing.JTextField textParameterBeginnMittel;
    private javax.swing.JTextField textParameterBeginnVarianz;
    private javax.swing.JTextField textParameterDauerA;
    private javax.swing.JTextField textParameterDauerB;
    private javax.swing.JTextField textSeed;
    private javax.swing.JTextField textZeitraumBeginn;
    private javax.swing.JTextField textZeitraumEnde;
    // End of variables declaration//GEN-END:variables


    private JDialog aboutBox;
}
