package com.literanusa.util;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Green Theme Manager for LiteraNusa Application
 * Handles the application of custom green theme using FlatLaf
 */
public class GreenThemeManager {
    
    private static final String GREEN_THEME_PROPERTIES = "/green-theme.properties";
    private static Properties themeProperties;
    
    /**
     * Initializes and applies the green theme to the application
     */
    public static void applyGreenTheme() {
        try {
            // Set the Look and Feel to FlatLaf
            UIManager.setLookAndFeel(new FlatLightLaf());
            
            // Load custom green theme properties
            loadThemeProperties();
            
            // Apply custom properties to UIManager
            applyCustomProperties();
            
            // Set additional green styling
            setAdditionalGreenStyling();
            
            System.out.println("Green theme applied successfully!");
            
        } catch (Exception e) {
            System.err.println("Failed to apply green theme: " + e.getMessage());
            // Fallback to default theme
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
            } catch (Exception fallbackException) {
                System.err.println("Failed to set fallback theme: " + fallbackException.getMessage());
            }
        }
    }
    
    /**
     * Loads theme properties from the resource file
     */
    private static void loadThemeProperties() throws IOException {
        themeProperties = new Properties();
        try (InputStream is = GreenThemeManager.class.getResourceAsStream(GREEN_THEME_PROPERTIES)) {
            if (is != null) {
                themeProperties.load(is);
            } else {
                System.out.println("Theme properties file not found, using default green colors");
                setDefaultGreenProperties();
            }
        }
    }
    
    /**
     * Sets default green properties if the properties file is not found
     */
    private static void setDefaultGreenProperties() {
        // Primary green colors
        themeProperties.setProperty("@primary", "#2e7d32");
        themeProperties.setProperty("@primaryVariant", "#1b5e20");
        themeProperties.setProperty("@primaryLight", "#4caf50");
        themeProperties.setProperty("@primaryContainer", "#c8e6c9");
        themeProperties.setProperty("@onPrimary", "#ffffff");
        themeProperties.setProperty("@background", "#f0f8f0");
        themeProperties.setProperty("@surface", "#ffffff");
        themeProperties.setProperty("@text", "#1b5e20");
    }
    
    /**
     * Applies custom properties to the UIManager
     */
    private static void applyCustomProperties() {
        // Colors
        Color primary = Color.decode(resolveProperty("@primary", "#2e7d32"));
        Color primaryVariant = Color.decode(resolveProperty("@primaryVariant", "#1b5e20"));
        Color primaryLight = Color.decode(resolveProperty("@primaryLight", "#4caf50"));
        Color primaryContainer = Color.decode(resolveProperty("@primaryContainer", "#c8e6c9"));
        Color onPrimary = Color.decode(resolveProperty("@onPrimary", "#ffffff"));
        Color background = Color.decode(resolveProperty("@background", "#f0f8f0"));
        Color surface = Color.decode(resolveProperty("@surface", "#ffffff"));
        Color text = Color.decode(resolveProperty("@text", "#1b5e20"));
        
        // Apply button styling
        UIManager.put("Button.background", primaryContainer);
        UIManager.put("Button.foreground", text);
        UIManager.put("Button.hoverBackground", primary);
        UIManager.put("Button.hoverForeground", onPrimary);
        UIManager.put("Button.pressedBackground", primaryVariant);
        UIManager.put("Button.pressedForeground", onPrimary);
        UIManager.put("Button.focusedBackground", primary);
        UIManager.put("Button.focusedForeground", onPrimary);
        UIManager.put("Button.arc", 12);
        
        // Apply panel styling
        UIManager.put("Panel.background", background);
        UIManager.put("Panel.foreground", text);
        
        // Apply text field styling
        UIManager.put("TextField.background", surface);
        UIManager.put("TextField.foreground", text);
        UIManager.put("TextField.focusColor", primary);
        UIManager.put("TextField.hoverBorderColor", primaryLight);
        UIManager.put("TextField.focusedBorderColor", primary);
        UIManager.put("TextField.arc", 8);
        
        // Apply list styling
        UIManager.put("List.background", surface);
        UIManager.put("List.foreground", text);
        UIManager.put("List.selectionBackground", primaryContainer);
        UIManager.put("List.selectionForeground", text);
        
        // Apply table styling
        UIManager.put("Table.background", surface);
        UIManager.put("Table.foreground", text);
        UIManager.put("Table.gridColor", primaryContainer);
        UIManager.put("Table.selectionBackground", primaryContainer);
        UIManager.put("Table.selectionForeground", text);
        UIManager.put("Table.alternateRowColor", Color.decode("#f8fff8"));
        
        // Apply menu styling
        UIManager.put("Menu.background", surface);
        UIManager.put("Menu.foreground", text);
        UIManager.put("Menu.hoverBackground", primaryContainer);
        UIManager.put("MenuItem.background", surface);
        UIManager.put("MenuItem.foreground", text);
        UIManager.put("MenuItem.hoverBackground", primaryContainer);
        UIManager.put("MenuItem.hoverForeground", text);
        
        // Apply scroll bar styling
        UIManager.put("ScrollBar.track", background);
        UIManager.put("ScrollBar.thumb", primary);
        UIManager.put("ScrollBar.hoverThumbColor", primaryVariant);
        
        // Apply progress bar styling
        UIManager.put("ProgressBar.background", primaryContainer);
        UIManager.put("ProgressBar.foreground", primary);
        UIManager.put("ProgressBar.selectionBackground", onPrimary);
        UIManager.put("ProgressBar.selectionForeground", primary);
        
        // Apply borders
        UIManager.put("Component.borderColor", primaryContainer);
        UIManager.put("Component.focusedBorderColor", primary);
        UIManager.put("Component.arc", 8);
        UIManager.put("Component.focusWidth", 2);
        UIManager.put("Component.focusColor", primary);
    }
    
    /**
     * Sets additional green styling for custom components
     */
    private static void setAdditionalGreenStyling() {
        // Custom card styling
        UIManager.put("Card.background", Color.decode("#f8fff8"));
        UIManager.put("Card.border", Color.decode("#c8e6c9"));
        UIManager.put("Card.shadow", Color.decode("#e8f5e8"));
        
        // Navigation button styling
        UIManager.put("NavButton.background", Color.decode("#c8e6c9"));
        UIManager.put("NavButton.hoverBackground", Color.decode("#2e7d32"));
        UIManager.put("NavButton.selectedBackground", Color.decode("#1b5e20"));
        UIManager.put("NavButton.foreground", Color.decode("#1b5e20"));
        UIManager.put("NavButton.hoverForeground", Color.decode("#ffffff"));
        UIManager.put("NavButton.selectedForeground", Color.decode("#ffffff"));
        
        // Dashboard specific styling
        UIManager.put("Dashboard.cardBackground", Color.decode("#ffffff"));
        UIManager.put("Dashboard.cardBorder", Color.decode("#c8e6c9"));
        UIManager.put("Dashboard.headerBackground", Color.decode("#2e7d32"));
        UIManager.put("Dashboard.headerForeground", Color.decode("#ffffff"));
        
        // Book card styling
        UIManager.put("BookCard.background", Color.decode("#ffffff"));
        UIManager.put("BookCard.border", Color.decode("#e8f5e8"));
        UIManager.put("BookCard.hoverBorder", Color.decode("#4caf50"));
        UIManager.put("BookCard.titleColor", Color.decode("#1b5e20"));
        UIManager.put("BookCard.authorColor", Color.decode("#4a4a4a"));
        
        // Login view styling
        UIManager.put("LoginView.background", Color.decode("#f0f8f0"));
        UIManager.put("LoginView.cardBackground", Color.decode("#ffffff"));
        UIManager.put("LoginView.headerColor", Color.decode("#2e7d32"));
    }
    
    /**
     * Resolves a property with variable substitution
     */
    private static String resolveProperty(String key, String defaultValue) {
        String value = themeProperties.getProperty(key, defaultValue);
        
        // Simple variable substitution for @variables
        while (value.startsWith("@")) {
            String newValue = themeProperties.getProperty(value, value);
            if (newValue.equals(value)) {
                break; // Prevent infinite loop
            }
            value = newValue;
        }
        
        return value;
    }
    
    /**
     * Updates all existing components with the new theme
     */
    public static void updateAllComponents() {
        // Update all open windows
        for (Window window : Window.getWindows()) {
            SwingUtilities.updateComponentTreeUI(window);
            window.repaint();
        }
    }
    
    /**
     * Creates a themed border with green color scheme
     */
    public static javax.swing.border.Border createThemedBorder() {
        return BorderFactory.createLineBorder(Color.decode("#c8e6c9"), 1);
    }
    
    /**
     * Creates a themed rounded border
     */
    public static javax.swing.border.Border createRoundedBorder() {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.decode("#c8e6c9"), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        );
    }
    
    /**
     * Gets the primary green color
     */
    public static Color getPrimaryColor() {
        return Color.decode(resolveProperty("@primary", "#2e7d32"));
    }
    
    /**
     * Gets the primary container color
     */
    public static Color getPrimaryContainerColor() {
        return Color.decode(resolveProperty("@primaryContainer", "#c8e6c9"));
    }
    
    /**
     * Gets the background color
     */
    public static Color getBackgroundColor() {
        return Color.decode(resolveProperty("@background", "#f0f8f0"));
    }
    
    /**
     * Gets the surface color
     */
    public static Color getSurfaceColor() {
        return Color.decode(resolveProperty("@surface", "#ffffff"));
    }
}