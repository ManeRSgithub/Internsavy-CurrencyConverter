import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CurrencyConverterGUI extends JFrame {
    private JTextField amountField;
    private JLabel resultLabel;

    public CurrencyConverterGUI() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2));

        JLabel titleLabel = new JLabel("Currency Converter", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel amountLabel = new JLabel("Amount in INR:");
        amountField = new JTextField(10);

        JButton convertButton = new JButton("Convert");

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));

        mainPanel.add(titleLabel);
        mainPanel.add(new JLabel());
        mainPanel.add(amountLabel);
        mainPanel.add(amountField);

        add(mainPanel, BorderLayout.CENTER);
        add(convertButton, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountText = amountField.getText();
                double amount;
                try {
                    amount = Double.parseDouble(amountText);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid amount!");
                    return;
                }

                // Assuming a fixed exchange rate of 1 USD = 75 INR
                double convertedAmount = amount / 75;

                DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                String resultText = decimalFormat.format(amount) + " INR = " +
                        decimalFormat.format(convertedAmount) + " USD";
                resultLabel.setText(resultText);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CurrencyConverterGUI converterGUI = new CurrencyConverterGUI();
                converterGUI.setVisible(true);
            }
        });
    }
}
