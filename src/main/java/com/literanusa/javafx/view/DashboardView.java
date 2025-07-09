package com.literanusa.javafx.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;
import com.literanusa.javafx.model.Book;
import com.literanusa.javafx.model.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Dashboard View for LiteraNusa Application
 * Main dashboard showing library statistics and book management
 */
public class DashboardView {
    
    private VBox rootView;
    private ObservableList<Book> bookData;
    private ObservableList<Member> memberData;
    private TableView<Book> bookTable;
    private TableView<Member> memberTable;
    
    public DashboardView() {
        initializeData();
        createView();
        loadSampleData();
    }
    
    /**
     * Initializes the data collections
     */
    private void initializeData() {
        bookData = FXCollections.observableArrayList();
        memberData = FXCollections.observableArrayList();
    }
    
    /**
     * Creates the main dashboard view
     */
    private void createView() {
        rootView = new VBox(20);
        rootView.getStyleClass().add("application-background");
        rootView.setPadding(new Insets(30));
        
        // Header section
        VBox headerSection = createHeaderSection();
        
        // Statistics cards section
        HBox statsSection = createStatsSection();
        
        // Main content with tabs
        TabPane mainContent = createMainContentTabs();
        
        rootView.getChildren().addAll(headerSection, statsSection, mainContent);
    }
    
    /**
     * Creates the header section
     */
    private VBox createHeaderSection() {
        VBox header = new VBox(10);
        header.getStyleClass().add("header");
        
        // Welcome message
        Label welcomeLabel = new Label("Selamat Datang di Dashboard LiteraNusa");
        welcomeLabel.getStyleClass().add("heading-1");
        
        // Current date and time
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy"));
        Label dateLabel = new Label(currentDate);
        dateLabel.getStyleClass().add("body-text");
        
        // Quick action buttons
        HBox quickActions = createQuickActionButtons();
        
        header.getChildren().addAll(welcomeLabel, dateLabel, quickActions);
        
        return header;
    }
    
    /**
     * Creates quick action buttons
     */
    private HBox createQuickActionButtons() {
        HBox quickActions = new HBox(15);
        quickActions.setAlignment(Pos.CENTER_LEFT);
        
        Button addBookBtn = new Button("➕ Tambah Buku");
        addBookBtn.getStyleClass().add("btn-primary");
        addBookBtn.setOnAction(e -> showAddBookDialog());
        
        Button addMemberBtn = new Button("👤 Tambah Anggota");
        addMemberBtn.getStyleClass().add("btn-secondary");
        addMemberBtn.setOnAction(e -> showAddMemberDialog());
        
        Button searchBtn = new Button("🔍 Pencarian Lanjutan");
        searchBtn.getStyleClass().add("btn-secondary");
        searchBtn.setOnAction(e -> showSearchDialog());
        
        Button reportsBtn = new Button("📊 Laporan");
        reportsBtn.getStyleClass().add("btn-secondary");
        reportsBtn.setOnAction(e -> showReportsDialog());
        
        quickActions.getChildren().addAll(addBookBtn, addMemberBtn, searchBtn, reportsBtn);
        
        return quickActions;
    }
    
    /**
     * Creates the statistics section
     */
    private HBox createStatsSection() {
        HBox statsSection = new HBox(20);
        statsSection.setAlignment(Pos.CENTER);
        
        // Stats cards
        VBox totalBooksCard = createStatCard("📚", "Total Buku", "1,247", "buku dalam koleksi");
        VBox activeMembersCard = createStatCard("👥", "Anggota Aktif", "589", "anggota terdaftar");
        VBox borrowedBooksCard = createStatCard("📖", "Buku Dipinjam", "234", "sedang dipinjam");
        VBox finesCard = createStatCard("💰", "Denda Terkumpul", "Rp 125,000", "total denda bulan ini");
        
        statsSection.getChildren().addAll(totalBooksCard, activeMembersCard, borrowedBooksCard, finesCard);
        
        // Add animations
        addStatsAnimation(statsSection);
        
        return statsSection;
    }
    
    /**
     * Creates a statistics card
     */
    private VBox createStatCard(String icon, String title, String value, String subtitle) {
        VBox card = new VBox(10);
        card.getStyleClass().add("stat-card");
        card.setAlignment(Pos.CENTER);
        card.setPrefWidth(200);
        card.setPrefHeight(150);
        
        Label iconLabel = new Label(icon);
        iconLabel.setStyle("-fx-font-size: 32px;");
        
        Label valueLabel = new Label(value);
        valueLabel.getStyleClass().add("heading-2");
        valueLabel.setStyle("-fx-text-fill: -fx-primary-green;");
        
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("body-text");
        titleLabel.setStyle("-fx-font-weight: bold;");
        
        Label subtitleLabel = new Label(subtitle);
        subtitleLabel.getStyleClass().add("caption-text");
        
        card.getChildren().addAll(iconLabel, valueLabel, titleLabel, subtitleLabel);
        
        // Add hover effect
        card.setOnMouseEntered(e -> {
            ScaleTransition scale = new ScaleTransition(Duration.millis(200), card);
            scale.setToX(1.05);
            scale.setToY(1.05);
            scale.play();
        });
        
        card.setOnMouseExited(e -> {
            ScaleTransition scale = new ScaleTransition(Duration.millis(200), card);
            scale.setToX(1.0);
            scale.setToY(1.0);
            scale.play();
        });
        
        return card;
    }
    
    /**
     * Adds animations to stats section
     */
    private void addStatsAnimation(HBox statsSection) {
        for (int i = 0; i < statsSection.getChildren().size(); i++) {
            VBox card = (VBox) statsSection.getChildren().get(i);
            
            FadeTransition fade = new FadeTransition(Duration.millis(300 + i * 100), card);
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.setDelay(Duration.millis(i * 150));
            fade.play();
        }
    }
    
    /**
     * Creates the main content tabs
     */
    private TabPane createMainContentTabs() {
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        // Books tab
        Tab booksTab = new Tab("📚 Manajemen Buku");
        booksTab.setContent(createBooksManagementView());
        
        // Members tab
        Tab membersTab = new Tab("👥 Manajemen Anggota");
        membersTab.setContent(createMembersManagementView());
        
        // Analytics tab
        Tab analyticsTab = new Tab("📊 Analitik");
        analyticsTab.setContent(createAnalyticsView());
        
        tabPane.getTabs().addAll(booksTab, membersTab, analyticsTab);
        
        return tabPane;
    }
    
    /**
     * Creates the books management view
     */
    private VBox createBooksManagementView() {
        VBox booksView = new VBox(15);
        booksView.setPadding(new Insets(20));
        
        // Search and filter section
        HBox searchSection = createBookSearchSection();
        
        // Books table
        bookTable = createBooksTable();
        
        booksView.getChildren().addAll(searchSection, bookTable);
        
        return booksView;
    }
    
    /**
     * Creates the book search section
     */
    private HBox createBookSearchSection() {
        HBox searchSection = new HBox(10);
        searchSection.setAlignment(Pos.CENTER_LEFT);
        
        Label searchLabel = new Label("Pencarian:");
        searchLabel.getStyleClass().add("body-text");
        
        TextField searchField = new TextField();
        searchField.setPromptText("Cari berdasarkan judul, pengarang, atau ISBN...");
        searchField.setPrefWidth(300);
        
        ComboBox<String> categoryFilter = new ComboBox<>();
        categoryFilter.getItems().addAll("Semua Kategori", "Teknologi", "Sains", "Sastra", "Sejarah", "Ekonomi");
        categoryFilter.setValue("Semua Kategori");
        categoryFilter.setPrefWidth(150);
        
        Button searchBtn = new Button("🔍 Cari");
        searchBtn.getStyleClass().add("btn-primary");
        
        Button refreshBtn = new Button("🔄 Refresh");
        refreshBtn.getStyleClass().add("btn-secondary");
        refreshBtn.setOnAction(e -> loadSampleData());
        
        searchSection.getChildren().addAll(searchLabel, searchField, categoryFilter, searchBtn, refreshBtn);
        
        return searchSection;
    }
    
    /**
     * Creates the books table
     */
    private TableView<Book> createBooksTable() {
        TableView<Book> table = new TableView<>();
        table.setItems(bookData);
        table.setPrefHeight(400);
        
        // Create columns
        TableColumn<Book, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setPrefWidth(80);
        
        TableColumn<Book, String> titleCol = new TableColumn<>("Judul");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleCol.setPrefWidth(200);
        
        TableColumn<Book, String> authorCol = new TableColumn<>("Pengarang");
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        authorCol.setPrefWidth(150);
        
        TableColumn<Book, String> categoryCol = new TableColumn<>("Kategori");
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        categoryCol.setPrefWidth(120);
        
        TableColumn<Book, Integer> yearCol = new TableColumn<>("Tahun");
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        yearCol.setPrefWidth(80);
        
        TableColumn<Book, Integer> availableCol = new TableColumn<>("Tersedia");
        availableCol.setCellValueFactory(new PropertyValueFactory<>("availableCopies"));
        availableCol.setPrefWidth(80);
        
        TableColumn<Book, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusCol.setPrefWidth(100);
        
        // Actions column
        TableColumn<Book, Void> actionsCol = new TableColumn<>("Aksi");
        actionsCol.setPrefWidth(150);
        actionsCol.setCellFactory(col -> new TableCell<Book, Void>() {
            private final Button editBtn = new Button("✏️");
            private final Button deleteBtn = new Button("🗑️");
            private final HBox buttons = new HBox(5, editBtn, deleteBtn);
            
            {
                editBtn.getStyleClass().add("btn-icon");
                deleteBtn.getStyleClass().add("btn-icon");
                editBtn.setOnAction(e -> {
                    Book book = getTableView().getItems().get(getIndex());
                    showEditBookDialog(book);
                });
                deleteBtn.setOnAction(e -> {
                    Book book = getTableView().getItems().get(getIndex());
                    showDeleteConfirmation(book);
                });
            }
            
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : buttons);
            }
        });
        
        table.getColumns().addAll(idCol, titleCol, authorCol, categoryCol, yearCol, availableCol, statusCol, actionsCol);
        
        return table;
    }
    
    /**
     * Creates the members management view
     */
    private VBox createMembersManagementView() {
        VBox membersView = new VBox(15);
        membersView.setPadding(new Insets(20));
        
        // Search section
        HBox searchSection = createMemberSearchSection();
        
        // Members table
        memberTable = createMembersTable();
        
        membersView.getChildren().addAll(searchSection, memberTable);
        
        return membersView;
    }
    
    /**
     * Creates the member search section
     */
    private HBox createMemberSearchSection() {
        HBox searchSection = new HBox(10);
        searchSection.setAlignment(Pos.CENTER_LEFT);
        
        Label searchLabel = new Label("Pencarian:");
        searchLabel.getStyleClass().add("body-text");
        
        TextField searchField = new TextField();
        searchField.setPromptText("Cari berdasarkan nama atau email...");
        searchField.setPrefWidth(300);
        
        ComboBox<String> statusFilter = new ComboBox<>();
        statusFilter.getItems().addAll("Semua Status", "Active", "Inactive", "Suspended");
        statusFilter.setValue("Semua Status");
        statusFilter.setPrefWidth(120);
        
        Button searchBtn = new Button("🔍 Cari");
        searchBtn.getStyleClass().add("btn-primary");
        
        Button exportBtn = new Button("📥 Export");
        exportBtn.getStyleClass().add("btn-secondary");
        
        searchSection.getChildren().addAll(searchLabel, searchField, statusFilter, searchBtn, exportBtn);
        
        return searchSection;
    }
    
    /**
     * Creates the members table
     */
    private TableView<Member> createMembersTable() {
        TableView<Member> table = new TableView<>();
        table.setItems(memberData);
        table.setPrefHeight(400);
        
        // Create columns
        TableColumn<Member, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setPrefWidth(100);
        
        TableColumn<Member, String> nameCol = new TableColumn<>("Nama");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setPrefWidth(150);
        
        TableColumn<Member, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailCol.setPrefWidth(200);
        
        TableColumn<Member, String> membershipCol = new TableColumn<>("Tipe");
        membershipCol.setCellValueFactory(new PropertyValueFactory<>("membershipType"));
        membershipCol.setPrefWidth(100);
        
        TableColumn<Member, Integer> borrowedCol = new TableColumn<>("Dipinjam");
        borrowedCol.setCellValueFactory(new PropertyValueFactory<>("borrowedBooks"));
        borrowedCol.setPrefWidth(80);
        
        TableColumn<Member, Double> finesCol = new TableColumn<>("Denda");
        finesCol.setCellValueFactory(new PropertyValueFactory<>("fines"));
        finesCol.setPrefWidth(100);
        
        TableColumn<Member, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusCol.setPrefWidth(100);
        
        table.getColumns().addAll(idCol, nameCol, emailCol, membershipCol, borrowedCol, finesCol, statusCol);
        
        return table;
    }
    
    /**
     * Creates the analytics view
     */
    private VBox createAnalyticsView() {
        VBox analyticsView = new VBox(20);
        analyticsView.setPadding(new Insets(20));
        
        Label titleLabel = new Label("📊 Analitik Perpustakaan");
        titleLabel.getStyleClass().add("heading-2");
        
        // Charts section
        HBox chartsSection = new HBox(30);
        chartsSection.setAlignment(Pos.CENTER);
        
        // Book categories pie chart
        PieChart categoryChart = createCategoryChart();
        
        // Member types pie chart
        PieChart memberChart = createMemberTypeChart();
        
        chartsSection.getChildren().addAll(categoryChart, memberChart);
        
        analyticsView.getChildren().addAll(titleLabel, chartsSection);
        
        return analyticsView;
    }
    
    /**
     * Creates the book category pie chart
     */
    private PieChart createCategoryChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Teknologi", 35),
            new PieChart.Data("Sains", 25),
            new PieChart.Data("Sastra", 20),
            new PieChart.Data("Sejarah", 15),
            new PieChart.Data("Ekonomi", 5)
        );
        
        PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Distribusi Kategori Buku");
        chart.setPrefSize(350, 300);
        
        return chart;
    }
    
    /**
     * Creates the member type pie chart
     */
    private PieChart createMemberTypeChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Regular", 60),
            new PieChart.Data("Student", 30),
            new PieChart.Data("Premium", 10)
        );
        
        PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Tipe Keanggotaan");
        chart.setPrefSize(350, 300);
        
        return chart;
    }
    
    /**
     * Loads sample data for demonstration
     */
    private void loadSampleData() {
        // Sample books
        bookData.clear();
        bookData.addAll(
            new Book("B001", "Pemrograman Java Modern", "John Doe", "978-0123456789", "Teknologi", "TechBooks", 2023, 5, 3, "Panduan lengkap Java modern", "Available"),
            new Book("B002", "Database Design Principles", "Jane Smith", "978-0987654321", "Teknologi", "DataPress", 2022, 3, 1, "Prinsip desain database", "Available"),
            new Book("B003", "Web Development Fundamentals", "Bob Johnson", "978-0456789123", "Teknologi", "WebBooks", 2024, 4, 4, "Dasar-dasar web development", "Available"),
            new Book("B004", "Machine Learning Basics", "Alice Brown", "978-0789123456", "Sains", "SciencePublish", 2023, 2, 0, "Pengenalan machine learning", "Borrowed"),
            new Book("B005", "Digital Marketing Strategy", "Mike Wilson", "978-0321654987", "Ekonomi", "BusinessBooks", 2023, 3, 2, "Strategi pemasaran digital", "Available")
        );
        
        // Sample members
        memberData.clear();
        memberData.addAll(
            new Member("M001", "Ahmad Wijaya", "ahmad@email.com", "081234567890", "Jakarta", "Regular", LocalDate.of(2023, 1, 15), LocalDate.of(2024, 1, 15), 2, 0.0, "Active"),
            new Member("M002", "Siti Nurhaliza", "siti@email.com", "081234567891", "Bandung", "Student", LocalDate.of(2023, 3, 10), LocalDate.of(2024, 3, 10), 1, 0.0, "Active"),
            new Member("M003", "Budi Santoso", "budi@email.com", "081234567892", "Surabaya", "Premium", LocalDate.of(2022, 12, 5), LocalDate.of(2023, 12, 5), 5, 25000.0, "Active"),
            new Member("M004", "Dewi Lestari", "dewi@email.com", "081234567893", "Yogyakarta", "Regular", LocalDate.of(2023, 6, 20), LocalDate.of(2024, 6, 20), 0, 0.0, "Active"),
            new Member("M005", "Eko Prasetyo", "eko@email.com", "081234567894", "Medan", "Student", LocalDate.of(2023, 2, 28), LocalDate.of(2024, 2, 28), 3, 0.0, "Inactive")
        );
    }
    
    // Dialog methods
    private void showAddBookDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tambah Buku");
        alert.setHeaderText("Fitur Tambah Buku");
        alert.setContentText("Dialog form untuk menambah buku baru akan ditampilkan di sini.");
        alert.showAndWait();
    }
    
    private void showAddMemberDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tambah Anggota");
        alert.setHeaderText("Fitur Tambah Anggota");
        alert.setContentText("Dialog form untuk menambah anggota baru akan ditampilkan di sini.");
        alert.showAndWait();
    }
    
    private void showSearchDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pencarian Lanjutan");
        alert.setHeaderText("Fitur Pencarian Lanjutan");
        alert.setContentText("Dialog pencarian dengan filter advanced akan ditampilkan di sini.");
        alert.showAndWait();
    }
    
    private void showReportsDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Laporan");
        alert.setHeaderText("Fitur Laporan");
        alert.setContentText("Dialog untuk generate berbagai laporan akan ditampilkan di sini.");
        alert.showAndWait();
    }
    
    private void showEditBookDialog(Book book) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Edit Buku");
        alert.setHeaderText("Edit Buku: " + book.getTitle());
        alert.setContentText("Dialog form untuk mengedit data buku akan ditampilkan di sini.");
        alert.showAndWait();
    }
    
    private void showDeleteConfirmation(Book book) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi Hapus");
        alert.setHeaderText("Hapus Buku: " + book.getTitle());
        alert.setContentText("Apakah Anda yakin ingin menghapus buku ini?");
        
        if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            bookData.remove(book);
        }
    }
    
    /**
     * Gets the root view
     */
    public Region getView() {
        return rootView;
    }
}