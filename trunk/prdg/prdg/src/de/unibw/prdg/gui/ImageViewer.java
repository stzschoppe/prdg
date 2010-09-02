package de.unibw.prdg.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class ImageViewer extends JFrame implements ActionListener
{
	class ViewComponent extends JComponent
	{
	  private Image image;
	  public void setImage( URL url )
	  {
	    image = Toolkit.getDefaultToolkit().getImage( url );
	    if ( image != null )
	      repaint();
	  }
	  @Override
	  protected void paintComponent( Graphics g )
	  {
	    if ( image != null )

	      g.drawImage( image, 0, 0, this );
	  }
	public ViewComponent() {
		super();

	}
	}
  public ViewComponent viewComponent = new ViewComponent();
	URL uniform = ImageViewer.class.getResource("resources/uniform.png");
	URL gausian = ImageViewer.class.getResource("resources/gausian.png");
	URL exponential = ImageViewer.class.getResource("resources/exponential.png");
	URL chi = ImageViewer.class.getResource("resources/chi.png");
	
  public ImageViewer()
  {
    super( );
    add( viewComponent );
    //setUndecorated(true);
    //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    //setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
  public void actionPerformed( ActionEvent e )
  {
	  this.show();
	      	switch (((JComboBox) e.getSource()).getSelectedIndex()) {
		case 0: {
			setTitle("Normalverteilung");
			viewComponent.setImage(gausian);
		}
			break;
		case 1: {
			setTitle("Gleichverteilung");
			viewComponent.setImage(uniform);
		}
			break;
		case 2: {
			setTitle("Exponentialverteilung");
			viewComponent.setImage(exponential);

		}
			break;
		case 3: {
			setTitle("Chi-Quadrat-Verteilung");
			viewComponent.setImage(chi);
		}
			break;

		default:
			break;
		}
	      
  }
}

