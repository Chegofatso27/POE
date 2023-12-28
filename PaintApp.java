import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintApp {
    private JFrame frame;
    private JLabel lengthLabel, widthLabel, heightLabel, areaLabel, tinsLabel, costLabel, vatLabel, totalCostLabel, tenderedLabel, changeLabel;
    private JTextField lengthField, widthField, heightField, tenderedField;
    private JButton calculateButton;

    public PaintApp() {
        frame = new JFrame("Paint Calculator");
        frame.setLayout(new FlowLayout());
        
        lengthLabel = new JLabel("Length (m):");
        widthLabel = new JLabel("Width (m):");
        heightLabel = new JLabel("Height (m):");
        areaLabel = new JLabel("Wall Area (sqm):");
        tinsLabel = new JLabel("Tins of Paint Needed:");
        costLabel = new JLabel("Total Paint Cost (R):");
        vatLabel = new JLabel("VAT (R):");
        totalCostLabel = new JLabel("Total Cost with VAT (R):");
        tenderedLabel = new JLabel("Tendered Amount (R):");
        changeLabel = new JLabel("Change (R):");
        
        lengthField = new JTextField(10);
        widthField = new JTextField(10);
        heightField = new JTextField(10);
        tenderedField = new JTextField(10);
        
        calculateButton = new JButton("Calculate");

        frame.add(lengthLabel);
        frame.add(lengthField);
        frame.add(widthLabel);
        frame.add(widthField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(calculateButton);
        frame.add(areaLabel);
        frame.add(tinsLabel);
        frame.add(costLabel);
        frame.add(vatLabel);
        frame.add(totalCostLabel);
        frame.add(tenderedLabel);
        frame.add(tenderedField);
        frame.add(changeLabel);
        
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }

    public void calculate() {
        try {
            double length = Double.parseDouble(lengthField.getText());
            double width = Double.parseDouble(widthField.getText());
            double height = Double.parseDouble(heightField.getText());
            
            double wallArea = 2 * (length * height + width * height);
            int tinsNeeded = (int) Math.ceil(wallArea / 10);
            double cost = tinsNeeded * 30;
            double vat = cost * 0.15;
            double totalCost = cost + vat;
            
            double tenderedAmount = Double.parseDouble(tenderedField.getText());
            double change = tenderedAmount - totalCost;

            areaLabel.setText("Wall Area (sqm): " + wallArea);
            tinsLabel.setText("Tins of Paint Needed: " + tinsNeeded);
            costLabel.setText("Total Paint Cost (R): " + cost);
            vatLabel.setText("VAT (R): " + vat);
            totalCostLabel.setText("Total Cost with VAT (R): " + totalCost);
            changeLabel.setText("Change (R): " + change);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers for dimensions and tendered amount.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaintApp();
            }
        });
    }
}
