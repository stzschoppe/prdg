/*
 * GeneratorApp.java
 */

package de.unibw.prdg;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

import de.unibw.prdg.gui.GeneratorView;

/**
 * The main class of the application.
 */
public class GeneratorApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new GeneratorView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
        this.getMainFrame().setResizable(false);
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of GeneratorApp
     */
    public static GeneratorApp getApplication() {
        return Application.getInstance(GeneratorApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(GeneratorApp.class, args);
    }
}
