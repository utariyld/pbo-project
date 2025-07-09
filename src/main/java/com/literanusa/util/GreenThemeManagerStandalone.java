package com.literanusa.util;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.DefaultMetalTheme;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Standalone Green Theme Manager for LiteraNusa Application
 * Works without external dependencies using standard Java Swing
 */
public class GreenThemeManagerStandalone {
    
    private static final String GREEN_THEME_PROPERTIES = "/green-theme.properties";
    private static Properties themeProperties;
    
    // Green color palette
    public static final Color PRIMARY_GREEN = new Color(46, 125, 50);           // #2e7d32
    public static final Color PRIMARY_VARIANT = new Color(27, 94, 32);          // #1b5e20
    public static final Color PRIMARY_LIGHT = new Color(76, 175, 80);           // #4caf50
    public static final Color PRIMARY_CONTAINER = new Color(200, 230, 201);     // #c8e6c9
    public static final Color BACKGROUND = new Color(240, 248, 240);            // #f0f8f0
    public static final Color SURFACE = new Color(255, 255, 255);               // #ffffff
    public static final Color CARD_BACKGROUND = new Color(248, 255, 248);       // #f8fff8
    public static final Color TEXT_PRIMARY = new Color(27, 94, 32);             // #1b5e20
    public static final Color TEXT_SECONDARY = new Color(74, 74, 74);           // #4a4a4a
    
    /**
     * Custom Metal Theme with Green Colors
     */
    public static class GreenMetalTheme extends DefaultMetalTheme {
        @Override
        public String getName() {
            return "Green Theme";
        }
        
        @Override
        protected ColorUIResource getPrimary1() {
            return new ColorUIResource(PRIMARY_VARIANT);
        }
        
        @Override
        protected ColorUIResource getPrimary2() {
            return new ColorUIResource(PRIMARY_GREEN);
        }
        
        @Override
        protected ColorUIResource getPrimary3() {
            return new ColorUIResource(PRIMARY_LIGHT);
        }
        
        @Override
        protected ColorUIResource getSecondary1() {
            return new ColorUIResource(PRIMARY_CONTAINER);
        }
        
        @Override
        protected ColorUIResource getSecondary2() {
            return new ColorUIResource(BACKGROUND);
        }
        
        @Override
        protected ColorUIResource getSecondary3() {
            return new ColorUIResource(SURFACE);
        }
        
        @Override
        public ColorUIResource getControlTextColor() {
            return new ColorUIResource(TEXT_PRIMARY);
        }
        
        @Override
        public ColorUIResource getSystemTextColor() {
            return new ColorUIResource(TEXT_PRIMARY);
        }
        
        @Override
        public ColorUIResource getUserTextColor() {
            return new ColorUIResource(TEXT_PRIMARY);
        }
        
        public ColorUIResource getMenuTextColor() {
            return new ColorUIResource(TEXT_PRIMARY);
        }
    }
    
    /**
     * Applies the green theme to the application
     */
    public static void applyGreenTheme() {
        try {
            // Set Metal Look and Feel with custom green theme
            MetalLookAndFeel.setCurrentTheme(new GreenMetalTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
            
            // Apply additional custom properties
            applyCustomUIProperties();
            
            System.out.println("Green theme applied successfully using Metal L&F!");
            
        } catch (Exception e) {
            System.err.println("Failed to apply green theme: " + e.getMessage());
            // Still apply custom colors even if L&F change fails
            applyCustomUIProperties();
        }
    }
    
    /**
     * Applies custom UI properties for green theme
     */
    private static void applyCustomUIProperties() {
        // Button styling
        UIManager.put("Button.background", PRIMARY_CONTAINER);
        UIManager.put("Button.foreground", TEXT_PRIMARY);
        UIManager.put("Button.select", PRIMARY_GREEN);
        UIManager.put("Button.focus", PRIMARY_LIGHT);
        
        // Panel styling
        UIManager.put("Panel.background", BACKGROUND);
        UIManager.put("Panel.foreground", TEXT_PRIMARY);
        
        // Text component styling
        UIManager.put("TextField.background", SURFACE);
        UIManager.put("TextField.foreground", TEXT_PRIMARY);
        UIManager.put("TextField.selectionBackground", PRIMARY_CONTAINER);
        UIManager.put("TextField.selectionForeground", TEXT_PRIMARY);
        
        UIManager.put("TextArea.background", SURFACE);
        UIManager.put("TextArea.foreground", TEXT_PRIMARY);
        UIManager.put("TextArea.selectionBackground", PRIMARY_CONTAINER);
        UIManager.put("TextArea.selectionForeground", TEXT_PRIMARY);
        
        // List styling
        UIManager.put("List.background", SURFACE);
        UIManager.put("List.foreground", TEXT_PRIMARY);
        UIManager.put("List.selectionBackground", PRIMARY_CONTAINER);
        UIManager.put("List.selectionForeground", TEXT_PRIMARY);
        
        // Table styling
        UIManager.put("Table.background", SURFACE);
        UIManager.put("Table.foreground", TEXT_PRIMARY);
        UIManager.put("Table.selectionBackground", PRIMARY_CONTAINER);
        UIManager.put("Table.selectionForeground", TEXT_PRIMARY);
        UIManager.put("Table.gridColor", PRIMARY_CONTAINER);
        UIManager.put("TableHeader.background", PRIMARY_GREEN);
        UIManager.put("TableHeader.foreground", Color.WHITE);
        
        // Menu styling
        UIManager.put("Menu.background", SURFACE);
        UIManager.put("Menu.foreground", TEXT_PRIMARY);
        UIManager.put("Menu.selectionBackground", PRIMARY_CONTAINER);
        UIManager.put("Menu.selectionForeground", TEXT_PRIMARY);
        
        UIManager.put("MenuItem.background", SURFACE);
        UIManager.put("MenuItem.foreground", TEXT_PRIMARY);
        UIManager.put("MenuItem.selectionBackground", PRIMARY_CONTAINER);
        UIManager.put("MenuItem.selectionForeground", TEXT_PRIMARY);
        
        // ScrollBar styling
        UIManager.put("ScrollBar.track", BACKGROUND);
        UIManager.put("ScrollBar.thumb", PRIMARY_GREEN);
        UIManager.put("ScrollBar.trackHighlight", PRIMARY_CONTAINER);
        
        // ProgressBar styling
        UIManager.put("ProgressBar.background", PRIMARY_CONTAINER);
        UIManager.put("ProgressBar.foreground", PRIMARY_GREEN);
        UIManager.put("ProgressBar.selectionBackground", Color.WHITE);
        UIManager.put("ProgressBar.selectionForeground", PRIMARY_GREEN);
        
        // TabbedPane styling
        UIManager.put("TabbedPane.background", BACKGROUND);
        UIManager.put("TabbedPane.foreground", TEXT_PRIMARY);
        UIManager.put("TabbedPane.selected", PRIMARY_CONTAINER);
        UIManager.put("TabbedPane.selectedForeground", TEXT_PRIMARY);
        
        // ToolTip styling
        UIManager.put("ToolTip.background", PRIMARY_VARIANT);
        UIManager.put("ToolTip.foreground", Color.WHITE);
        
        // CheckBox and RadioButton styling
        UIManager.put("CheckBox.background", BACKGROUND);
        UIManager.put("CheckBox.foreground", TEXT_PRIMARY);
        UIManager.put("RadioButton.background", BACKGROUND);
        UIManager.put("RadioButton.foreground", TEXT_PRIMARY);
        
        // ComboBox styling
        UIManager.put("ComboBox.background", SURFACE);
        UIManager.put("ComboBox.foreground", TEXT_PRIMARY);
        UIManager.put("ComboBox.selectionBackground", PRIMARY_CONTAINER);
        UIManager.put("ComboBox.selectionForeground", TEXT_PRIMARY);
        
        // Custom properties for application-specific components
        UIManager.put("Card.background", CARD_BACKGROUND);
        UIManager.put("Card.border", PRIMARY_CONTAINER);
        UIManager.put("NavButton.background", PRIMARY_CONTAINER);
        UIManager.put("NavButton.hoverBackground", PRIMARY_GREEN);
        UIManager.put("NavButton.selectedBackground", PRIMARY_VARIANT);
        UIManager.put("BookCard.background", SURFACE);
        UIManager.put("BookCard.border", PRIMARY_CONTAINER);
        UIManager.put("BookCard.hoverBorder", PRIMARY_LIGHT);
        UIManager.put("Dashboard.headerBackground", PRIMARY_GREEN);
        UIManager.put("Dashboard.headerForeground", Color.WHITE);
    }
    
    /**
     * Updates all existing components with the new theme
     */
    public static void updateAllComponents() {
        for (Window window : Window.getWindows()) {
            SwingUtilities.updateComponentTreeUI(window);
            window.repaint();
        }
    }
    
    /**
     * Creates a themed border with green color scheme
     */
    public static javax.swing.border.Border createThemedBorder() {
        return BorderFactory.createLineBorder(PRIMARY_CONTAINER, 1);
    }
    
    /**
     * Creates a themed rounded border
     */
    public static javax.swing.border.Border createRoundedBorder() {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(PRIMARY_CONTAINER, 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        );
    }
    
    /**
     * Creates a card-style border
     */
    public static javax.swing.border.Border createCardBorder() {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(PRIMARY_CONTAINER, 1),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
    }
    
    /**
     * Gets the primary green color
     */
    public static Color getPrimaryColor() {
        return PRIMARY_GREEN;
    }
    
    /**
     * Gets the primary container color
     */
    public static Color getPrimaryContainerColor() {
        return PRIMARY_CONTAINER;
    }
    
    /**
     * Gets the background color
     */
    public static Color getBackgroundColor() {
        return BACKGROUND;
    }
    
    /**
     * Gets the surface color
     */
    public static Color getSurfaceColor() {
        return SURFACE;
    }
    
    /**
     * Gets the card background color
     */
    public static Color getCardBackgroundColor() {
        return CARD_BACKGROUND;
    }
    
    /**
     * Gets the primary text color
     */
    public static Color getTextPrimaryColor() {
        return TEXT_PRIMARY;
    }
    
    /**
     * Gets the secondary text color
     */
    public static Color getTextSecondaryColor() {
        return TEXT_SECONDARY;
    }
    
    /**
     * Creates a primary button with green styling
     */
    public static JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(PRIMARY_GREEN);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(createRoundedBorder());
        
        // Add hover effects
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(PRIMARY_VARIANT);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(PRIMARY_GREEN);
            }
        });
        
        return button;
    }
    
    /**
     * Creates a secondary button with green styling
     */
    public static JButton createSecondaryButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(PRIMARY_CONTAINER);
        button.setForeground(TEXT_PRIMARY);
        button.setFocusPainted(false);
        button.setBorder(createRoundedBorder());
        
        // Add hover effects
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(PRIMARY_LIGHT);
                button.setForeground(Color.WHITE);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(PRIMARY_CONTAINER);
                button.setForeground(TEXT_PRIMARY);
            }
        });
        
        return button;
    }
}