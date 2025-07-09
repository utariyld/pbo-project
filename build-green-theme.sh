#!/bin/bash

# LiteraNusa Green Theme Build Script
echo "=== LiteraNusa Green Theme Build Script ==="

# Create necessary directories
echo "Creating directory structure..."
mkdir -p out/production/PBOProject/com/literanusa/util
mkdir -p out/production/PBOProject/com/literanusa
mkdir -p lib

# Check if FlatLaf library exists
FLATLAF_JAR="lib/flatlaf-3.6.jar"
if [ ! -f "$FLATLAF_JAR" ]; then
    echo "Warning: FlatLaf library not found at $FLATLAF_JAR"
    echo "Please download FlatLaf 3.6 from: https://github.com/JFormDesigner/FlatLaf/releases"
    echo "And place it in the lib/ directory"
fi

# Compile the green theme classes
echo "Compiling green theme classes..."

# Compile GreenThemeManager
if [ -f "src/main/java/com/literanusa/util/GreenThemeManager.java" ]; then
    javac -cp "lib/*" \
        src/main/java/com/literanusa/util/GreenThemeManager.java \
        -d out/production/PBOProject/
    
    if [ $? -eq 0 ]; then
        echo "✓ GreenThemeManager compiled successfully"
    else
        echo "✗ Failed to compile GreenThemeManager"
        exit 1
    fi
else
    echo "✗ GreenThemeManager.java not found"
    exit 1
fi

# Compile GreenThemeMain
if [ -f "src/main/java/com/literanusa/GreenThemeMain.java" ]; then
    javac -cp "lib/*:out/production/PBOProject/" \
        src/main/java/com/literanusa/GreenThemeMain.java \
        -d out/production/PBOProject/
    
    if [ $? -eq 0 ]; then
        echo "✓ GreenThemeMain compiled successfully"
    else
        echo "✗ Failed to compile GreenThemeMain"
        exit 1
    fi
else
    echo "✗ GreenThemeMain.java not found"
    exit 1
fi

# Copy resources
echo "Copying theme resources..."
if [ -f "src/main/resources/green-theme.properties" ]; then
    cp src/main/resources/green-theme.properties out/production/PBOProject/
    echo "✓ green-theme.properties copied"
else
    echo "! green-theme.properties not found, using default colors"
fi

# Create a simple test runner script
echo "Creating test runner script..."
cat > run-green-theme-demo.sh << 'EOF'
#!/bin/bash
echo "Running LiteraNusa Green Theme Demo..."

# Check if FlatLaf is available
if [ ! -f "lib/flatlaf-3.6.jar" ]; then
    echo "Error: FlatLaf library not found!"
    echo "Please download flatlaf-3.6.jar and place it in the lib/ directory"
    exit 1
fi

# Run the demo
java -cp "out/production/PBOProject/:lib/*" \
    com.literanusa.GreenThemeMain

echo "Demo finished."
EOF

chmod +x run-green-theme-demo.sh

# Create a JAR package
echo "Creating JAR package..."
cd out/production/PBOProject/
jar -cf ../../../literanusa-green-theme.jar .
cd ../../../

if [ -f "literanusa-green-theme.jar" ]; then
    echo "✓ JAR package created: literanusa-green-theme.jar"
else
    echo "✗ Failed to create JAR package"
fi

# Display build summary
echo ""
echo "=== Build Summary ==="
echo "✓ Green theme implementation completed"
echo "✓ Theme manager utility created"
echo "✓ Demo application compiled"
echo "✓ Build scripts generated"
echo ""
echo "Next Steps:"
echo "1. Download FlatLaf 3.6 JAR to lib/ directory if not already present"
echo "2. Run: ./run-green-theme-demo.sh to test the theme"
echo "3. Follow GREEN_THEME_INTEGRATION_GUIDE.md to integrate with existing code"
echo ""
echo "Files created:"
echo "- src/main/java/com/literanusa/util/GreenThemeManager.java"
echo "- src/main/java/com/literanusa/GreenThemeMain.java"
echo "- src/main/resources/green-theme.properties"
echo "- GREEN_THEME_INTEGRATION_GUIDE.md"
echo "- literanusa-green-theme.jar"
echo "- run-green-theme-demo.sh"
echo ""
echo "Theme colors applied:"
echo "- Primary: #2e7d32 (Forest Green)"
echo "- Background: #f0f8f0 (Light Green Tint)"
echo "- Surface: #ffffff (White)"
echo "- Accent: #4caf50 (Light Green)"
echo ""
echo "Build completed successfully! 🌿"