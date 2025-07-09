package com.literanusa.javafx.view;

import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.util.Duration;

/**
 * Splash Screen View for LiteraNusa Application
 * Shows loading animation during application startup
 */
public class SplashScreenView {
    
    private VBox rootView;
    private ProgressBar progressBar;
    
    public SplashScreenView() {
        createView();
        startAnimations();
    }
    
    /**
     * Creates the splash screen view
     */
    private void createView() {
        rootView = new VBox(20);
        rootView.setAlignment(Pos.CENTER);
        rootView.setStyle("-fx-background-color: linear-gradient(to bottom, #2e7d32, #1b5e20);");
        rootView.setPadding(new Insets(50));
        
        // Logo
        Label logoLabel = new Label("🏛️");
        logoLabel.setStyle("-fx-font-size: 80px;");
        
        // Title
        Label titleLabel = new Label("LiteraNusa");
        titleLabel.getStyleClass().add("heading-1");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 42px;");
        
        // Subtitle
        Label subtitleLabel = new Label("Sistem Manajemen Perpustakaan Modern");
        subtitleLabel.getStyleClass().add("heading-3");
        subtitleLabel.setStyle("-fx-text-fill: rgba(255,255,255,0.9); -fx-font-size: 18px;");
        
        // Loading text
        Label loadingLabel = new Label("Memuat aplikasi...");
        loadingLabel.getStyleClass().add("body-text");
        loadingLabel.setStyle("-fx-text-fill: rgba(255,255,255,0.8); -fx-font-size: 14px;");
        
        // Progress bar
        progressBar = new ProgressBar();
        progressBar.setPrefWidth(300);
        progressBar.setPrefHeight(6);
        progressBar.setStyle("-fx-accent: #4caf50;");
        
        // Version info
        Label versionLabel = new Label("Version 1.0.0 - JavaFX Edition");
        versionLabel.getStyleClass().add("caption-text");
        versionLabel.setStyle("-fx-text-fill: rgba(255,255,255,0.6); -fx-font-size: 12px;");
        
        rootView.getChildren().addAll(
            logoLabel,
            titleLabel,
            subtitleLabel,
            loadingLabel,
            progressBar,
            versionLabel
        );
    }
    
    /**
     * Starts the loading animations
     */
    private void startAnimations() {
        // Fade in animation for the whole view
        FadeTransition fadeIn = new FadeTransition(Duration.millis(800), rootView);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
        
        // Scale animation for logo
        Label logoLabel = (Label) rootView.getChildren().get(0);
        ScaleTransition logoScale = new ScaleTransition(Duration.millis(1000), logoLabel);
        logoScale.setFromX(0.5);
        logoScale.setFromY(0.5);
        logoScale.setToX(1.0);
        logoScale.setToY(1.0);
        logoScale.setInterpolator(Interpolator.EASE_OUT);
        logoScale.play();
        
        // Progress bar animation
        Timeline progressTimeline = new Timeline();
        progressTimeline.getKeyFrames().addAll(
            new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), 0)),
            new KeyFrame(Duration.millis(2500), new KeyValue(progressBar.progressProperty(), 1.0))
        );
        progressTimeline.play();
        
        // Pulsing animation for loading text
        Label loadingLabel = (Label) rootView.getChildren().get(3);
        FadeTransition pulse = new FadeTransition(Duration.millis(800), loadingLabel);
        pulse.setFromValue(0.6);
        pulse.setToValue(1.0);
        pulse.setCycleCount(Timeline.INDEFINITE);
        pulse.setAutoReverse(true);
        pulse.play();
    }
    
    /**
     * Gets the root view
     * @return The splash screen view
     */
    public Region getView() {
        return rootView;
    }
}