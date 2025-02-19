import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KonversiSatuan extends JFrame {
    private JTextField inputField;
    private JComboBox<String> fromUnitBox;
    private JComboBox<String> toUnitBox;
    private JLabel resultLabel;
    
    private String[] panjangUnits = {"Meter", "Kilometer", "Centimeter", "Milimeter"};
    private String[] beratUnits = {"Kilogram", "Gram", "Miligram"};
    private String[] volumeUnits = {"Liter", "Mililiter"};
    
    public KonversiSatuan() {
        setTitle("Aplikasi Konversi Satuan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setResizable(false);
        
        // Panel Utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Kategori Panel
        JPanel categoryPanel = new JPanel();
        String[] categories = {"Panjang", "Berat", "Volume"};
        JComboBox<String> categoryBox = new JComboBox<>(categories);
        categoryPanel.add(new JLabel("Pilih Kategori:"));
        categoryPanel.add(categoryBox);
        
        // Input Panel
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(10);
        inputPanel.add(new JLabel("Masukkan Nilai:"));
        inputPanel.add(inputField);
        
        // Konversi Panel
        JPanel conversionPanel = new JPanel();
        fromUnitBox = new JComboBox<>(panjangUnits);
        toUnitBox = new JComboBox<>(panjangUnits);
        conversionPanel.add(new JLabel("Dari:"));
        conversionPanel.add(fromUnitBox);
        conversionPanel.add(new JLabel("Ke:"));
        conversionPanel.add(toUnitBox);
        
        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton convertButton = new JButton("Konversi");
        buttonPanel.add(convertButton);
        
        // Result Panel
        JPanel resultPanel = new JPanel();
        resultLabel = new JLabel("Hasil: ");
        resultPanel.add(resultLabel);
        
        // Menambahkan panels ke main panel
        mainPanel.add(categoryPanel);
        mainPanel.add(inputPanel);
        mainPanel.add(conversionPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);
        
        // Event listener untuk category box
        categoryBox.addActionListener(e -> {
            String selected = (String) categoryBox.getSelectedItem();
            switch(selected) {
                case "Panjang":
                    updateComboBoxes(panjangUnits);
                    break;
                case "Berat":
                    updateComboBoxes(beratUnits);
                    break;
                case "Volume":
                    updateComboBoxes(volumeUnits);
                    break;
            }
        });
        
        // Event listener untuk convert button
        convertButton.addActionListener(e -> {
            try {
                double value = Double.parseDouble(inputField.getText());
                String from = (String) fromUnitBox.getSelectedItem();
                String to = (String) toUnitBox.getSelectedItem();
                double result = convertValue(value, from, to);
                resultLabel.setText(String.format("Hasil: %.4f %s", result, to));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, 
                    "Masukkan angka yang valid!", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        
        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }
    
    private void updateComboBoxes(String[] units) {
        fromUnitBox.setModel(new DefaultComboBoxModel<>(units));
        toUnitBox.setModel(new DefaultComboBoxModel<>(units));
    }
    
    private double convertValue(double value, String from, String to) {
        // Konversi ke satuan dasar terlebih dahulu
        double baseValue = toBase(value, from);
        // Kemudian konversi dari satuan dasar ke satuan tujuan
        return fromBase(baseValue, to);
    }
    
    private double toBase(double value, String unit) {
        switch(unit) {
            // Konversi Panjang (basis: meter)
            case "Kilometer": return value * 1000;
            case "Meter": return value;
            case "Centimeter": return value / 100;
            case "Milimeter": return value / 1000;
            
            // Konversi Berat (basis: gram)
            case "Kilogram": return value * 1000;
            case "Gram": return value;
            case "Miligram": return value / 1000;
            
            // Konversi Volume (basis: mililiter)
            case "Liter": return value * 1000;
            case "Mililiter": return value;
            
            default: return value;
        }
    }
    
    private double fromBase(double value, String unit) {
        switch(unit) {
            // Konversi Panjang (dari meter)
            case "Kilometer": return value / 1000;
            case "Meter": return value;
            case "Centimeter": return value * 100;
            case "Milimeter": return value * 1000;
            
            // Konversi Berat (dari gram)
            case "Kilogram": return value / 1000;
            case "Gram": return value;
            case "Miligram": return value * 1000;
            
            // Konversi Volume (dari mililiter)
            case "Liter": return value / 1000;
            case "Mililiter": return value;
            
            default: return value;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new KonversiSatuan().setVisible(true);
        });
    }
}
