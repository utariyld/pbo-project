package com.literanusa;

import com.literanusa.util.GreenThemeManagerStandalone;
import javax.swing.*;
import java.awt.*;

/**
 * Standalone Green Theme Demo for LiteraNusa Application
 * Works without external dependencies using standard Java Swing
 */
public class GreenThemeMainStandalone {
    
    public static void main(String[] args) {
        // Set system properties for better UI experience
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        
        // Apply green theme before any UI components are created
        SwingUtilities.invokeLater(() -> {
            try {
                // Apply the green theme
                GreenThemeManagerStandalone.applyGreenTheme();
                
                // Launch the demo application
                createAndShowDemo();
                
            } catch (Exception e) {
                System.err.println("Error launching application with green theme: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }
    
    /**
     * Creates and shows the green theme demo
     */
    private static void createAndShowDemo() {
        // Create main frame
        JFrame frame = new JFrame("LiteraNusa - Green Theme Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        
        // Apply green theme styling to the frame
        frame.getContentPane().setBackground(GreenThemeManagerStandalone.getBackgroundColor());
        
        // Create the main demo panel
        JPanel mainPanel = createDemoContent();
        frame.add(new JScrollPane(mainPanel));
        
        // Show the frame
        frame.setVisible(true);
        
        // Update all components with the new theme
        GreenThemeManagerStandalone.updateAllComponents();
        
        System.out.println("🌿 Green Theme Demo berhasil diluncurkan!");
        System.out.println("Tema hijau telah diterapkan pada semua komponen UI.");
    }
    
    /**
     * Creates the demo content showcasing green theme components
     */
    private static JPanel createDemoContent() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(GreenThemeManagerStandalone.getBackgroundColor());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Header
        mainPanel.add(createHeaderSection());
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Dashboard Cards Section
        mainPanel.add(createDashboardSection());
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Book Cards Section
        mainPanel.add(createBookCardsSection());
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Forms Section
        mainPanel.add(createFormsSection());
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Data Display Section
        mainPanel.add(createDataDisplaySection());
        
        return mainPanel;
    }
    
    /**
     * Creates the header section
     */
    private static JPanel createHeaderSection() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(GreenThemeManagerStandalone.getPrimaryColor());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        JLabel titleLabel = new JLabel("LiteraNusa - Green Theme Showcase");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel subtitleLabel = new JLabel("Sistem Manajemen Perpustakaan dengan Tema Hijau");
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(GreenThemeManagerStandalone.getPrimaryColor());
        textPanel.add(titleLabel, BorderLayout.CENTER);
        textPanel.add(subtitleLabel, BorderLayout.SOUTH);
        
        headerPanel.add(textPanel, BorderLayout.CENTER);
        
        return headerPanel;
    }
    
    /**
     * Creates the dashboard cards section
     */
    private static JPanel createDashboardSection() {
        JPanel section = new JPanel();
        section.setLayout(new BorderLayout());
        section.setBackground(GreenThemeManagerStandalone.getBackgroundColor());
        
        JLabel sectionTitle = new JLabel("Dashboard Cards");
        sectionTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        sectionTitle.setForeground(GreenThemeManagerStandalone.getTextPrimaryColor());
        sectionTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        JPanel cardsPanel = new JPanel(new GridLayout(1, 4, 15, 0));
        cardsPanel.setBackground(GreenThemeManagerStandalone.getBackgroundColor());
        
        // Statistics cards
        cardsPanel.add(createStatCard("Total Buku", "1,247", "📚"));
        cardsPanel.add(createStatCard("Anggota Aktif", "589", "👥"));
        cardsPanel.add(createStatCard("Buku Dipinjam", "234", "📖"));
        cardsPanel.add(createStatCard("Denda Terkumpul", "Rp 125,000", "💰"));
        
        section.add(sectionTitle, BorderLayout.NORTH);
        section.add(cardsPanel, BorderLayout.CENTER);
        
        return section;
    }
    
    /**
     * Creates a statistics card
     */
    private static JPanel createStatCard(String title, String value, String icon) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(GreenThemeManagerStandalone.getSurfaceColor());
        card.setBorder(GreenThemeManagerStandalone.createCardBorder());
        
        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        iconLabel.setFont(new Font("SansSerif", Font.PLAIN, 32));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);
        valueLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        valueLabel.setForeground(GreenThemeManagerStandalone.getPrimaryColor());
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        titleLabel.setForeground(GreenThemeManagerStandalone.getTextSecondaryColor());
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        card.add(Box.createVerticalStrut(10));
        card.add(iconLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(valueLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(titleLabel);
        card.add(Box.createVerticalStrut(10));
        
        return card;
    }
    
    /**
     * Creates the book cards section
     */
    private static JPanel createBookCardsSection() {
        JPanel section = new JPanel(new BorderLayout());
        section.setBackground(GreenThemeManagerStandalone.getBackgroundColor());
        
        JLabel sectionTitle = new JLabel("Koleksi Buku Populer");
        sectionTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        sectionTitle.setForeground(GreenThemeManagerStandalone.getTextPrimaryColor());
        sectionTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        JPanel booksPanel = new JPanel(new GridLayout(1, 3, 15, 0));
        booksPanel.setBackground(GreenThemeManagerStandalone.getBackgroundColor());
        
        booksPanel.add(createBookCard("Pemrograman Java", "John Doe", "2023"));
        booksPanel.add(createBookCard("Database Design", "Jane Smith", "2022"));
        booksPanel.add(createBookCard("Web Development", "Bob Johnson", "2024"));
        
        section.add(sectionTitle, BorderLayout.NORTH);
        section.add(booksPanel, BorderLayout.CENTER);
        
        return section;
    }
    
    /**
     * Creates a book card
     */
    private static JPanel createBookCard(String title, String author, String year) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(GreenThemeManagerStandalone.getSurfaceColor());
        card.setBorder(GreenThemeManagerStandalone.createCardBorder());
        
        // Book icon
        JLabel bookIcon = new JLabel("📕", SwingConstants.CENTER);
        bookIcon.setFont(new Font("SansSerif", Font.PLAIN, 48));
        bookIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Title
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setForeground(GreenThemeManagerStandalone.getTextPrimaryColor());
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Author
        JLabel authorLabel = new JLabel("oleh " + author, SwingConstants.CENTER);
        authorLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        authorLabel.setForeground(GreenThemeManagerStandalone.getTextSecondaryColor());
        authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Year
        JLabel yearLabel = new JLabel("(" + year + ")", SwingConstants.CENTER);
        yearLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        yearLabel.setForeground(GreenThemeManagerStandalone.getTextSecondaryColor());
        yearLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Action button
        JButton borrowButton = GreenThemeManagerStandalone.createPrimaryButton("Pinjam");
        borrowButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        card.add(Box.createVerticalStrut(10));
        card.add(bookIcon);
        card.add(Box.createVerticalStrut(10));
        card.add(titleLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(authorLabel);
        card.add(yearLabel);
        card.add(Box.createVerticalStrut(15));
        card.add(borrowButton);
        card.add(Box.createVerticalStrut(10));
        
        return card;
    }
    
    /**
     * Creates the forms section
     */
    private static JPanel createFormsSection() {
        JPanel section = new JPanel(new BorderLayout());
        section.setBackground(GreenThemeManagerStandalone.getBackgroundColor());
        
        JLabel sectionTitle = new JLabel("Form Input dengan Tema Hijau");
        sectionTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        sectionTitle.setForeground(GreenThemeManagerStandalone.getTextPrimaryColor());
        sectionTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(GreenThemeManagerStandalone.getSurfaceColor());
        formPanel.setBorder(GreenThemeManagerStandalone.createCardBorder());
        
        // Form components
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row1.setBackground(GreenThemeManagerStandalone.getSurfaceColor());
        row1.add(new JLabel("Nama Lengkap:"));
        JTextField nameField = new JTextField(20);
        nameField.setText("Contoh Nama");
        row1.add(nameField);
        
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row2.setBackground(GreenThemeManagerStandalone.getSurfaceColor());
        row2.add(new JLabel("Email:"));
        JTextField emailField = new JTextField(20);
        emailField.setText("contoh@email.com");
        row2.add(emailField);
        
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row3.setBackground(GreenThemeManagerStandalone.getSurfaceColor());
        row3.add(new JLabel("Kategori:"));
        JComboBox<String> categoryCombo = new JComboBox<>(new String[]{"Mahasiswa", "Dosen", "Staff", "Umum"});
        row3.add(categoryCombo);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(GreenThemeManagerStandalone.getSurfaceColor());
        buttonPanel.add(GreenThemeManagerStandalone.createPrimaryButton("Simpan"));
        buttonPanel.add(GreenThemeManagerStandalone.createSecondaryButton("Batal"));
        
        formPanel.add(row1);
        formPanel.add(row2);
        formPanel.add(row3);
        formPanel.add(buttonPanel);
        
        section.add(sectionTitle, BorderLayout.NORTH);
        section.add(formPanel, BorderLayout.CENTER);
        
        return section;
    }
    
    /**
     * Creates the data display section
     */
    private static JPanel createDataDisplaySection() {
        JPanel section = new JPanel(new BorderLayout());
        section.setBackground(GreenThemeManagerStandalone.getBackgroundColor());
        
        JLabel sectionTitle = new JLabel("Data Display Components");
        sectionTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        sectionTitle.setForeground(GreenThemeManagerStandalone.getTextPrimaryColor());
        sectionTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        JPanel displayPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        displayPanel.setBackground(GreenThemeManagerStandalone.getBackgroundColor());
        
        // Table
        String[] columnNames = {"ID", "Judul Buku", "Pengarang", "Status"};
        String[][] data = {
            {"001", "Java Programming", "John Doe", "Tersedia"},
            {"002", "Database Systems", "Jane Smith", "Dipinjam"},
            {"003", "Web Development", "Bob Johnson", "Tersedia"},
            {"004", "Mobile Apps", "Alice Brown", "Dipinjam"}
        };
        
        JTable table = new JTable(data, columnNames);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(400, 150));
        tableScrollPane.setBorder(GreenThemeManagerStandalone.createThemedBorder());
        
        // Progress and other components
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(GreenThemeManagerStandalone.getSurfaceColor());
        rightPanel.setBorder(GreenThemeManagerStandalone.createCardBorder());
        
        rightPanel.add(new JLabel("Progress Upload:"));
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(75);
        progressBar.setStringPainted(true);
        progressBar.setString("75% Complete");
        rightPanel.add(progressBar);
        
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(new JLabel("Kategori Buku:"));
        
        String[] categories = {"Teknologi", "Sains", "Sastra", "Sejarah", "Ekonomi"};
        JList<String> categoryList = new JList<>(categories);
        categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        categoryList.setSelectedIndex(0);
        JScrollPane listScrollPane = new JScrollPane(categoryList);
        listScrollPane.setPreferredSize(new Dimension(200, 100));
        rightPanel.add(listScrollPane);
        
        displayPanel.add(tableScrollPane);
        displayPanel.add(rightPanel);
        
        section.add(sectionTitle, BorderLayout.NORTH);
        section.add(displayPanel, BorderLayout.CENTER);
        
        return section;
    }
}