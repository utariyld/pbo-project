# LiteraNusa Green Theme Integration Guide

## Overview
This guide explains how to integrate the custom green theme into the existing LiteraNusa library management application. The green theme provides a modern, nature-inspired color scheme that enhances the user experience while maintaining professional aesthetics.

## Theme Color Palette

### Primary Colors
- **Primary Green**: `#2e7d32` - Main brand color
- **Primary Variant**: `#1b5e20` - Darker shade for emphasis
- **Primary Light**: `#4caf50` - Lighter shade for hover states
- **Primary Container**: `#c8e6c9` - Light green for backgrounds

### Background Colors
- **Background**: `#f0f8f0` - Main application background
- **Surface**: `#ffffff` - Card and component backgrounds
- **Card**: `#f8fff8` - Specific card background with subtle green tint

### Text Colors
- **Primary Text**: `#1b5e20` - Dark green for main text
- **Secondary Text**: `#4a4a4a` - Gray for secondary information
- **Tertiary Text**: `#757575` - Lighter gray for labels

## Integration Steps

### 1. Apply Theme at Application Startup

#### Option A: Modify Existing Main Class
Add the following code to your existing `Main.java` file at the beginning of the `main` method:

```java
import com.literanusa.util.GreenThemeManager;

public class Main {
    public static void main(String[] args) {
        // Apply green theme before creating any UI components
        SwingUtilities.invokeLater(() -> {
            GreenThemeManager.applyGreenTheme();
            
            // Your existing application startup code here
            // ...
        });
    }
}
```

#### Option B: Use the New GreenThemeMain Class
Replace your existing main class with `GreenThemeMain.java` and modify the `launchApplication()` method to call your existing application startup code.

### 2. Update Individual View Classes

#### For LoginView
```java
public class LoginView extends JFrame {
    public LoginView() {
        // Apply green theme colors
        setBackground(GreenThemeManager.getBackgroundColor());
        
        // For login card/panel
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(GreenThemeManager.getSurfaceColor());
        loginPanel.setBorder(GreenThemeManager.createRoundedBorder());
        
        // For primary login button
        JButton loginButton = new JButton("Login");
        loginButton.putClientProperty("style", "primary");
        
        // Apply theme after all components are added
        GreenThemeManager.updateAllComponents();
    }
}
```

#### For Dashboard Views
```java
public class UserDashboardView extends JFrame {
    public UserDashboardView() {
        // Set main background
        getContentPane().setBackground(GreenThemeManager.getBackgroundColor());
        
        // For navigation buttons
        private JButton createNavButton(String text, String iconPath) {
            JButton button = new JButton(text);
            button.setBackground(UIManager.getColor("NavButton.background"));
            button.setForeground(UIManager.getColor("NavButton.foreground"));
            // Add hover effects through mouse listeners
            return button;
        }
        
        // For book cards
        private void styleBookCard(JPanel card) {
            card.setBackground(UIManager.getColor("BookCard.background"));
            card.setBorder(BorderFactory.createLineBorder(
                UIManager.getColor("BookCard.border"), 1));
        }
    }
}
```

#### For Book Cards
```java
public class BookCard extends JPanel {
    public BookCard(Book book) {
        setBackground(UIManager.getColor("BookCard.background"));
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(UIManager.getColor("BookCard.border"), 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        // Title styling
        JLabel titleLabel = new JLabel(book.getTitle());
        titleLabel.setForeground(UIManager.getColor("BookCard.titleColor"));
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 14f));
        
        // Author styling
        JLabel authorLabel = new JLabel(book.getAuthor());
        authorLabel.setForeground(UIManager.getColor("BookCard.authorColor"));
        
        // Add hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(
                    UIManager.getColor("BookCard.hoverBorder"), 2));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(
                    UIManager.getColor("BookCard.border"), 1));
            }
        });
    }
}
```

### 3. Update Custom Components

#### Navigation Buttons
```java
public class NavButton extends JButton {
    public NavButton(String text) {
        super(text);
        applyGreenStyling();
    }
    
    private void applyGreenStyling() {
        setBackground(UIManager.getColor("NavButton.background"));
        setForeground(UIManager.getColor("NavButton.foreground"));
        setBorder(GreenThemeManager.createRoundedBorder());
        setFocusPainted(false);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(UIManager.getColor("NavButton.hoverBackground"));
                setForeground(UIManager.getColor("NavButton.hoverForeground"));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(UIManager.getColor("NavButton.background"));
                setForeground(UIManager.getColor("NavButton.foreground"));
            }
        });
    }
}
```

#### Animated Cards
```java
public class AnimatedCard extends JPanel {
    public AnimatedCard() {
        setBackground(UIManager.getColor("Card.background"));
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(UIManager.getColor("Card.border"), 1),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        // Add subtle shadow effect using multiple borders
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 2, 2, UIManager.getColor("Card.shadow")),
            getBorder()
        ));
    }
}
```

## Advanced Customizations

### 1. Dynamic Theme Switching
```java
public class ThemeManager {
    public static void switchToGreenTheme() {
        GreenThemeManager.applyGreenTheme();
        GreenThemeManager.updateAllComponents();
    }
    
    public static void refreshCurrentTheme() {
        GreenThemeManager.updateAllComponents();
    }
}
```

### 2. Component-Specific Styling
```java
// For tables with alternating row colors
JTable table = new JTable();
table.setBackground(UIManager.getColor("Table.background"));
table.setAlternateRowColor(UIManager.getColor("Table.alternateRowColor"));

// For progress bars with green theme
JProgressBar progressBar = new JProgressBar();
progressBar.setForeground(GreenThemeManager.getPrimaryColor());
progressBar.setBackground(GreenThemeManager.getPrimaryContainerColor());
```

### 3. Custom Dialogs
```java
public class ThemedDialog extends JDialog {
    public ThemedDialog(Frame parent, String title) {
        super(parent, title, true);
        getContentPane().setBackground(GreenThemeManager.getBackgroundColor());
        
        // Style OK/Cancel buttons
        JButton okButton = new JButton("OK");
        okButton.putClientProperty("style", "primary");
        
        JButton cancelButton = new JButton("Cancel");
        // cancelButton uses default styling (secondary)
    }
}
```

## Build and Run Instructions

### 1. Compile the Application
```bash
# Make sure FlatLaf library is in classpath
javac -cp "lib/flatlaf-3.6.jar:lib/mysql-connector-j-9.3.0.jar:lib/timingframework-*.jar" \
    src/main/java/com/literanusa/**/*.java \
    -d out/production/PBOProject/
```

### 2. Run with Green Theme
```bash
# Run the new green theme main class
java -cp "out/production/PBOProject/:lib/*" \
    com.literanusa.GreenThemeMain
```

### 3. Package Resources
Make sure the `green-theme.properties` file is included in your JAR:
```bash
jar -cf literanusa-green.jar \
    -C out/production/PBOProject/ . \
    -C src/main/resources/ .
```

## Troubleshooting

### Theme Not Applied
1. Ensure `GreenThemeManager.applyGreenTheme()` is called before any UI components are created
2. Check that FlatLaf library is properly included in classpath
3. Verify that `green-theme.properties` is in the resources folder

### Components Not Updating
1. Call `GreenThemeManager.updateAllComponents()` after theme application
2. Use `SwingUtilities.updateComponentTreeUI(component)` for specific components
3. Call `repaint()` on containers after theme changes

### Custom Colors Not Working
1. Verify color codes are properly formatted (e.g., `#2e7d32`)
2. Check that property names match exactly in the properties file
3. Ensure variable substitution is working (e.g., `@primary` resolves correctly)

## Color Accessibility

The green theme has been designed with accessibility in mind:
- **Contrast Ratio**: Primary text on background meets WCAG AA standards (4.5:1)
- **Color Blindness**: Uses different shades and intensities, not just color differences
- **Focus Indicators**: Clear focus outlines with high contrast

## Best Practices

1. **Consistency**: Use the predefined color constants from `GreenThemeManager`
2. **Performance**: Apply theme once at startup, not repeatedly
3. **Maintainability**: Use UIManager colors instead of hardcoded values
4. **Testing**: Test with different screen resolutions and operating systems
5. **Fallback**: Always provide fallback colors for theme loading failures

## Future Enhancements

- Dark green theme variant
- User preference for theme selection
- High contrast mode for accessibility
- Custom accent color selection
- Theme persistence across application restarts