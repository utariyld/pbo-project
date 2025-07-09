package com.literanusa;

import com.literanusa.util.GreenThemeManager;
import com.literanusa.view.SplashScreen;
import javax.swing.*;

/**
 * Enhanced Main class for LiteraNusa with Green Theme
 * This class applies the green theme before launching the application
 */
public class GreenThemeMain {
    
    public static void main(String[] args) {
        // Set system properties for better UI experience
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        System.setProperty("sun.java2d.noddraw", "true");
        
        // Apply green theme before any UI components are created
        SwingUtilities.invokeLater(() -> {
            try {
                // Apply the green theme
                GreenThemeManager.applyGreenTheme();
                
                // Launch the splash screen or main application
                // Note: Replace this with the actual main application entry point
                launchApplication();
                
            } catch (Exception e) {
                System.err.println("Error launching application with green theme: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }
    
    /**
     * Launches the main application
     * This method should be modified to match your actual application entry point
     */
    private static void launchApplication() {
        try {
            // Example: Create and show the splash screen
            // Replace this with your actual application startup code
            JFrame frame = new JFrame("LiteraNusa - Library Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 800);
            frame.setLocationRelativeTo(null);
            
            // Apply green theme styling to the frame
            frame.getContentPane().setBackground(GreenThemeManager.getBackgroundColor());
            
            // Create a sample panel to demonstrate the theme
            JPanel mainPanel = createDemoPanel();
            frame.add(mainPanel);
            
            frame.setVisible(true);
            
            // Update all components with the new theme
            GreenThemeManager.updateAllComponents();
            
        } catch (Exception e) {
            System.err.println("Error launching application: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Creates a demo panel to showcase the green theme
     * Remove this method when integrating with actual application
     */
    private static JPanel createDemoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(GreenThemeManager.getBackgroundColor());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Title
        JLabel titleLabel = new JLabel("LiteraNusa - Green Theme Demo");
        titleLabel.setFont(titleLabel.getFont().deriveFont(24f));
        titleLabel.setForeground(GreenThemeManager.getPrimaryColor());
        titleLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        
        panel.add(Box.createVerticalStrut(20));
        
        // Sample components
        JPanel componentsPanel = new JPanel();
        componentsPanel.setLayout(new BoxLayout(componentsPanel, BoxLayout.Y_AXIS));
        componentsPanel.setBackground(GreenThemeManager.getSurfaceColor());
        componentsPanel.setBorder(GreenThemeManager.createRoundedBorder());
        
        // Buttons
        JButton primaryButton = new JButton("Primary Button");
        primaryButton.putClientProperty("style", "primary");
        primaryButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        componentsPanel.add(primaryButton);
        
        componentsPanel.add(Box.createVerticalStrut(10));
        
        JButton secondaryButton = new JButton("Secondary Button");
        secondaryButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        componentsPanel.add(secondaryButton);
        
        componentsPanel.add(Box.createVerticalStrut(10));
        
        // Text field
        JTextField textField = new JTextField("Sample text field");
        textField.setMaximumSize(new java.awt.Dimension(300, 30));
        textField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        componentsPanel.add(textField);
        
        componentsPanel.add(Box.createVerticalStrut(10));
        
        // Progress bar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(65);
        progressBar.setStringPainted(true);
        progressBar.setString("Loading...");
        progressBar.setMaximumSize(new java.awt.Dimension(300, 20));
        progressBar.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        componentsPanel.add(progressBar);
        
        panel.add(componentsPanel);
        
        panel.add(Box.createVerticalStrut(20));
        
        // Instructions
        JLabel instructionLabel = new JLabel("<html><center>Green theme has been applied!<br/>All UI components now use the green color scheme.</center></html>");
        instructionLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(instructionLabel);
        
        return panel;
    }
}