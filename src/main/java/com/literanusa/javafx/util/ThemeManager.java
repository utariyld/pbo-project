package com.literanusa.javafx.util;

import javafx.scene.Scene;
import java.util.Objects;

/**
 * Theme Manager for LiteraNusa JavaFX Application
 * Handles CSS theme application and management
 */
public class ThemeManager {
    
    private static final String GREEN_THEME_CSS = "/css/green-theme.css";
    
    /**
     * Applies the green theme to a scene
     * @param scene The scene to apply the theme to
     */
    public static void applyTheme(Scene scene) {
        try {
            String css = Objects.requireNonNull(
                ThemeManager.class.getResource(GREEN_THEME_CSS)
            ).toExternalForm();
            
            scene.getStylesheets().clear();
            scene.getStylesheets().add(css);
            
        } catch (Exception e) {
            System.err.println("Warning: Could not load green theme CSS: " + e.getMessage());
            // Application will continue with default JavaFX styling
        }
    }
    
    /**
     * Gets the green theme CSS URL
     * @return CSS URL string
     */
    public static String getThemeCSS() {
        try {
            return Objects.requireNonNull(
                ThemeManager.class.getResource(GREEN_THEME_CSS)
            ).toExternalForm();
        } catch (Exception e) {
            System.err.println("Warning: Could not locate green theme CSS: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Checks if theme CSS is available
     * @return true if theme CSS is available
     */
    public static boolean isThemeAvailable() {
        return ThemeManager.class.getResource(GREEN_THEME_CSS) != null;
    }
}