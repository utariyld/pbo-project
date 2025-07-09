package com.literanusa;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import com.literanusa.javafx.view.DashboardView;
import com.literanusa.javafx.view.SplashScreenView;
import com.literanusa.javafx.util.ThemeManager;

/**
 * LiteraNusa JavaFX Application
 * Modern Library Management System with Green Theme
 */
public class LiteraNusaApp extends Application {
    
    private Stage primaryStage;
    private Scene mainScene;
    private BorderPane rootLayout;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        // Configure primary stage
        primaryStage.setTitle("LiteraNusa - Sistem Manajemen Perpustakaan");
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(800);
        primaryStage.setMaximized(true);
        
        // Show splash screen first
        showSplashScreen();
    }
    
    /**
     * Shows the splash screen with loading animation
     */
    private void showSplashScreen() {
        SplashScreenView splashView = new SplashScreenView();
        Scene splashScene = new Scene(splashView.getView(), 600, 400);
        
        // Apply theme to splash scene
        ThemeManager.applyTheme(splashScene);
        
        Stage splashStage = new Stage();
        splashStage.setScene(splashScene);
        splashStage.setTitle("LiteraNusa");
        splashStage.setResizable(false);
        splashStage.centerOnScreen();
        splashStage.show();
        
        // Auto close splash and show main window after 3 seconds
        Timeline timeline = new Timeline(new KeyFrame(
            Duration.seconds(3),
            e -> {
                splashStage.close();
                showMainWindow();
            }
        ));
        timeline.play();
    }
    
    /**
     * Shows the main application window
     */
    private void showMainWindow() {
        try {
            // Create root layout
            rootLayout = new BorderPane();
            rootLayout.getStyleClass().add("application-background");
            
            // Create navigation sidebar
            VBox sidebar = createNavigationSidebar();
            rootLayout.setLeft(sidebar);
            
            // Create main content area
            StackPane contentArea = new StackPane();
            contentArea.getStyleClass().add("content-area");
            rootLayout.setCenter(contentArea);
            
            // Load dashboard as default view
            DashboardView dashboardView = new DashboardView();
            contentArea.getChildren().add(dashboardView.getView());
            
            // Create main scene
            mainScene = new Scene(rootLayout, 1400, 900);
            ThemeManager.applyTheme(mainScene);
            
            // Configure and show primary stage
            primaryStage.setScene(mainScene);
            primaryStage.show();
            
            // Add fade-in animation
            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), rootLayout);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
            
        } catch (Exception e) {
            showErrorDialog("Error", "Gagal memuat aplikasi: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Creates the navigation sidebar
     */
    private VBox createNavigationSidebar() {
        VBox sidebar = new VBox(10);
        sidebar.getStyleClass().add("sidebar");
        sidebar.setPrefWidth(250);
        sidebar.setPadding(new Insets(20));
        
        // Logo and title
        Label logoLabel = new Label("🏛️");
        logoLabel.setStyle("-fx-font-size: 32px;");
        
        Label titleLabel = new Label("LiteraNusa");
        titleLabel.getStyleClass().add("heading-2");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        
        Label subtitleLabel = new Label("Perpustakaan Digital");
        subtitleLabel.getStyleClass().add("caption-text");
        subtitleLabel.setStyle("-fx-text-fill: rgba(255,255,255,0.8);");
        
        VBox logoSection = new VBox(5);
        logoSection.setAlignment(Pos.CENTER);
        logoSection.getChildren().addAll(logoLabel, titleLabel, subtitleLabel);
        logoSection.setStyle("-fx-padding: 0 0 30 0;");
        
        // Navigation buttons
        Button dashboardBtn = createNavButton("📊 Dashboard", true);
        Button booksBtn = createNavButton("📚 Koleksi Buku", false);
        Button membersBtn = createNavButton("👥 Anggota", false);
        Button loansBtn = createNavButton("📖 Peminjaman", false);
        Button reportsBtn = createNavButton("📋 Laporan", false);
        Button settingsBtn = createNavButton("⚙️ Pengaturan", false);
        
        // Navigation event handlers
        dashboardBtn.setOnAction(e -> switchView("dashboard"));
        booksBtn.setOnAction(e -> switchView("books"));
        membersBtn.setOnAction(e -> switchView("members"));
        loansBtn.setOnAction(e -> switchView("loans"));
        reportsBtn.setOnAction(e -> switchView("reports"));
        settingsBtn.setOnAction(e -> switchView("settings"));
        
        // Add spacer
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        
        // User info section
        VBox userSection = createUserSection();
        
        sidebar.getChildren().addAll(
            logoSection,
            dashboardBtn,
            booksBtn,
            membersBtn,
            loansBtn,
            reportsBtn,
            settingsBtn,
            spacer,
            userSection
        );
        
        return sidebar;
    }
    
    /**
     * Creates a navigation button
     */
    private Button createNavButton(String text, boolean active) {
        Button button = new Button(text);
        button.getStyleClass().add("nav-button");
        if (active) {
            button.getStyleClass().add("active");
        }
        button.setMaxWidth(Double.MAX_VALUE);
        button.setAlignment(Pos.CENTER_LEFT);
        
        // Add hover animation
        button.setOnMouseEntered(e -> {
            if (!button.getStyleClass().contains("active")) {
                ScaleTransition scale = new ScaleTransition(Duration.millis(100), button);
                scale.setToX(1.05);
                scale.setToY(1.05);
                scale.play();
            }
        });
        
        button.setOnMouseExited(e -> {
            if (!button.getStyleClass().contains("active")) {
                ScaleTransition scale = new ScaleTransition(Duration.millis(100), button);
                scale.setToX(1.0);
                scale.setToY(1.0);
                scale.play();
            }
        });
        
        return button;
    }
    
    /**
     * Creates the user section at the bottom of sidebar
     */
    private VBox createUserSection() {
        VBox userSection = new VBox(5);
        userSection.setAlignment(Pos.CENTER_LEFT);
        userSection.setStyle("-fx-background-color: rgba(255,255,255,0.1); " +
                           "-fx-background-radius: 8px; -fx-padding: 15px;");
        
        Label userIcon = new Label("👤");
        userIcon.setStyle("-fx-font-size: 24px;");
        
        Label userName = new Label("Admin Perpustakaan");
        userName.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        
        Label userRole = new Label("Administrator");
        userRole.setStyle("-fx-text-fill: rgba(255,255,255,0.7); -fx-font-size: 12px;");
        
        HBox userInfo = new HBox(10);
        userInfo.setAlignment(Pos.CENTER_LEFT);
        
        VBox textSection = new VBox(2);
        textSection.getChildren().addAll(userName, userRole);
        
        userInfo.getChildren().addAll(userIcon, textSection);
        
        Button logoutBtn = new Button("🚪 Keluar");
        logoutBtn.getStyleClass().add("nav-button");
        logoutBtn.setMaxWidth(Double.MAX_VALUE);
        logoutBtn.setOnAction(e -> handleLogout());
        
        userSection.getChildren().addAll(userInfo, logoutBtn);
        
        return userSection;
    }
    
    /**
     * Switches the main content view
     */
    private void switchView(String viewName) {
        StackPane contentArea = (StackPane) rootLayout.getCenter();
        
        // Clear previous content with fade out
        FadeTransition fadeOut = new FadeTransition(Duration.millis(200), contentArea);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(e -> {
            contentArea.getChildren().clear();
            
            // Load new view
            try {
                Region newView = createViewByName(viewName);
                contentArea.getChildren().add(newView);
                
                // Fade in new content
                FadeTransition fadeIn = new FadeTransition(Duration.millis(300), contentArea);
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
                
            } catch (Exception ex) {
                showErrorDialog("Error", "Gagal memuat tampilan: " + ex.getMessage());
            }
        });
        fadeOut.play();
        
        // Update navigation button states
        updateNavigationStates(viewName);
    }
    
    /**
     * Creates view based on name
     */
    private Region createViewByName(String viewName) {
        return switch (viewName) {
            case "dashboard" -> new DashboardView().getView();
            case "books" -> createPlaceholderView("📚 Manajemen Buku", "Kelola koleksi buku perpustakaan");
            case "members" -> createPlaceholderView("👥 Manajemen Anggota", "Kelola data anggota perpustakaan");
            case "loans" -> createPlaceholderView("📖 Peminjaman", "Kelola peminjaman dan pengembalian buku");
            case "reports" -> createPlaceholderView("📋 Laporan", "Lihat laporan statistik perpustakaan");
            case "settings" -> createPlaceholderView("⚙️ Pengaturan", "Konfigurasi sistem perpustakaan");
            default -> new DashboardView().getView();
        };
    }
    
    /**
     * Creates a placeholder view for non-implemented features
     */
    private Region createPlaceholderView(String title, String description) {
        VBox placeholder = new VBox(20);
        placeholder.setAlignment(Pos.CENTER);
        placeholder.setStyle("-fx-background-color: -fx-background-primary;");
        placeholder.setPadding(new Insets(50));
        
        Label iconLabel = new Label("🚧");
        iconLabel.setStyle("-fx-font-size: 64px;");
        
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("heading-1");
        
        Label descLabel = new Label(description);
        descLabel.getStyleClass().add("body-text");
        
        Label statusLabel = new Label("Fitur ini sedang dalam pengembangan");
        statusLabel.getStyleClass().add("caption-text");
        
        Button backBtn = new Button("Kembali ke Dashboard");
        backBtn.getStyleClass().add("btn-primary");
        backBtn.setOnAction(e -> switchView("dashboard"));
        
        placeholder.getChildren().addAll(iconLabel, titleLabel, descLabel, statusLabel, backBtn);
        
        return placeholder;
    }
    
    /**
     * Updates navigation button states
     */
    private void updateNavigationStates(String activeView) {
        VBox sidebar = (VBox) rootLayout.getLeft();
        sidebar.getChildren().forEach(node -> {
            if (node instanceof Button btn) {
                btn.getStyleClass().remove("active");
                String btnText = btn.getText().toLowerCase();
                if ((activeView.equals("dashboard") && btnText.contains("dashboard")) ||
                    (activeView.equals("books") && btnText.contains("buku")) ||
                    (activeView.equals("members") && btnText.contains("anggota")) ||
                    (activeView.equals("loans") && btnText.contains("peminjaman")) ||
                    (activeView.equals("reports") && btnText.contains("laporan")) ||
                    (activeView.equals("settings") && btnText.contains("pengaturan"))) {
                    btn.getStyleClass().add("active");
                }
            }
        });
    }
    
    /**
     * Handles logout action
     */
    private void handleLogout() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi Keluar");
        alert.setHeaderText("Apakah Anda yakin ingin keluar?");
        alert.setContentText("Semua data yang belum disimpan akan hilang.");
        
        if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            primaryStage.close();
        }
    }
    
    /**
     * Shows error dialog
     */
    private void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    /**
     * Main method
     */
    public static void main(String[] args) {
        launch(args);
    }
}