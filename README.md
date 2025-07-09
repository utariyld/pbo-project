# 🏛️ LiteraNusa JavaFX - Modern Library Management System

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![JavaFX](https://img.shields.io/badge/JavaFX-21.0.2-blue.svg)
![Maven](https://img.shields.io/badge/Maven-3.8+-green.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

## 📖 Overview

LiteraNusa JavaFX adalah sistem manajemen perpustakaan modern yang dibangun menggunakan JavaFX dengan tema hijau yang elegan. Aplikasi ini dirancang ulang dari versi Swing untuk memberikan pengalaman pengguna yang lebih modern dan menarik.

## ✨ Features

### 🎨 Modern UI/UX
- **Green Theme**: Tema hijau yang konsisten dan profesional
- **Responsive Design**: Antarmuka yang adaptif dan modern
- **Smooth Animations**: Animasi halus untuk transisi dan interaksi
- **Professional Icons**: Penggunaan emoji dan ikon yang konsisten

### 🔧 Core Functionality
- **Dashboard Interaktif**: Statistik perpustakaan real-time
- **Manajemen Buku**: CRUD operations untuk koleksi buku
- **Manajemen Anggota**: Pengelolaan data anggota perpustakaan
- **Analitik Visual**: Charts dan grafik untuk insights
- **Pencarian Lanjutan**: Filter dan pencarian yang powerful

### 📊 Components
- **Statistics Cards**: Kartu statistik dengan animasi hover
- **Data Tables**: Tabel data yang responsif dengan pagination
- **Charts**: Pie charts untuk visualisasi data
- **Navigation Sidebar**: Sidebar navigasi yang intuitif
- **Splash Screen**: Loading screen dengan animasi

## 🏗️ Architecture

```
src/main/java/com/literanusa/
├── LiteraNusaApp.java              # Main application class
├── javafx/
│   ├── model/                      # Data models
│   │   ├── Book.java              # Book entity with JavaFX properties
│   │   └── Member.java            # Member entity with JavaFX properties
│   ├── view/                       # UI Views
│   │   ├── DashboardView.java     # Main dashboard view
│   │   └── SplashScreenView.java  # Splash screen with animations
│   └── util/                       # Utilities
│       └── ThemeManager.java      # CSS theme management
└── resources/
    └── css/
        └── green-theme.css         # Green theme stylesheet
```

## 🚀 Getting Started

### Prerequisites
- Java 21 or higher
- Maven 3.8 or higher

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd literanusa-javafx
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run the application**
   ```bash
   mvn javafx:run
   ```

### Alternative Running Methods

**Using Maven Exec Plugin:**
```bash
mvn clean compile exec:java -Dexec.mainClass="com.literanusa.LiteraNusaApp"
```

**Create executable JAR:**
```bash
mvn clean package
java -jar target/literanusa-javafx-1.0.0.jar
```

## 🎨 UI Components

### 🏠 Dashboard
- **Welcome Header**: Pesan selamat datang dengan tanggal
- **Quick Actions**: Tombol aksi cepat untuk operasi umum
- **Statistics Cards**: 4 kartu statistik dengan animasi
- **Tabbed Interface**: Tab untuk Buku, Anggota, dan Analitik

### 📚 Book Management
- **Search & Filter**: Pencarian berdasarkan judul, pengarang, ISBN
- **Category Filter**: Filter berdasarkan kategori buku
- **Data Table**: Tabel dengan kolom lengkap dan aksi edit/delete
- **CRUD Operations**: Tambah, edit, dan hapus buku

### 👥 Member Management
- **Member Search**: Pencarian anggota berdasarkan nama/email
- **Status Filter**: Filter berdasarkan status keanggotaan
- **Member Data**: Informasi lengkap anggota dengan denda
- **Export Feature**: Export data anggota

### 📊 Analytics
- **Category Distribution**: Pie chart distribusi kategori buku
- **Membership Types**: Pie chart tipe keanggotaan
- **Visual Insights**: Grafik untuk insights perpustakaan

## 🎨 Green Theme

### Color Palette
```css
Primary Green:     #2e7d32  /* Main green color */
Primary Dark:      #1b5e20  /* Dark green for emphasis */
Primary Light:     #4caf50  /* Light green for hover states */
Background:        #f0f8f0  /* Light green background */
Card Background:   #f8fff8  /* White-green card background */
```

### Theme Features
- **140+ CSS Properties**: Comprehensive styling
- **Consistent Colors**: Unified color scheme
- **Hover Effects**: Interactive hover animations
- **Modern Components**: Rounded corners and shadows
- **Accessibility**: WCAG compliant contrast ratios

## 📋 Sample Data

Aplikasi ini dilengkapi dengan data sampel untuk demonstrasi:

### 📖 Sample Books
- Pemrograman Java Modern
- Database Design Principles
- Web Development Fundamentals
- Machine Learning Basics
- Digital Marketing Strategy

### 👤 Sample Members
- Ahmad Wijaya (Regular)
- Siti Nurhaliza (Student)
- Budi Santoso (Premium)
- Dewi Lestari (Regular)
- Eko Prasetyo (Student)

## 🔧 Development

### Project Structure
```
literanusa-javafx/
├── pom.xml                     # Maven configuration
├── README.md                   # This file
├── src/
│   └── main/
│       ├── java/              # Java source files
│       └── resources/         # Resources (CSS, images)
└── target/                    # Build output
```

### Dependencies
- **JavaFX Controls**: UI components
- **JavaFX FXML**: FXML support
- **ControlsFX**: Additional controls
- **AnimateFX**: Animation library
- **FontAwesomeFX**: Icon library
- **Jackson**: JSON processing

### Build Commands
```bash
# Compile only
mvn compile

# Run application
mvn javafx:run

# Package as JAR
mvn package

# Clean build directory
mvn clean

# Full build cycle
mvn clean compile package
```

## 🚀 Features Roadmap

### ✅ Completed
- [x] Modern JavaFX UI
- [x] Green theme implementation
- [x] Dashboard with statistics
- [x] Book and member data models
- [x] Table views with sample data
- [x] Navigation sidebar
- [x] Splash screen with animations
- [x] Basic CRUD placeholders

### 🔄 In Progress
- [ ] Complete CRUD dialogs
- [ ] Database integration
- [ ] Search functionality
- [ ] Export features
- [ ] Advanced analytics

### 📅 Planned
- [ ] User authentication
- [ ] Advanced reporting
- [ ] Book lending system
- [ ] Email notifications
- [ ] Backup and restore
- [ ] Print functionality

## 🤝 Contributing

1. Fork the project
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**LiteraNusa Development Team**
- Email: support@literanusa.com
- GitHub: [@literanusa](https://github.com/literanusa)

## 🙏 Acknowledgments

- JavaFX community for excellent documentation
- ControlsFX for additional UI components
- Material Design for color inspiration
- Indonesian Library Association for requirements

---

**🌿 Made with ❤️ and JavaFX - Creating modern library management solutions**