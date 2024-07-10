package Pizza_order;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaOrderSystem {
    private JFrame frame;
    private JPanel panel;
    private JButton smallButton, mediumButton, largeButton, veggieButton, meatButton, orderButton;
    private JLabel sizeLabel, toppingLabel, orderLabel;
    private String size, topping;

    public PizzaOrderSystem() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Pizza Order System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        sizeLabel = new JLabel("Select Size:");
        panel.add(sizeLabel);

        smallButton = new JButton("Small");
        smallButton.addActionListener(new SizeButtonListener());
        panel.add(smallButton);

        mediumButton = new JButton("Medium");
        mediumButton.addActionListener(new SizeButtonListener());
        panel.add(mediumButton);

        largeButton = new JButton("Large");
        largeButton.addActionListener(new SizeButtonListener());
        panel.add(largeButton);

        toppingLabel = new JLabel("Select Topping:");
        panel.add(toppingLabel);

        veggieButton = new JButton("Veggie");
        veggieButton.addActionListener(new ToppingButtonListener());
        panel.add(veggieButton);

        meatButton = new JButton("Meat");
        meatButton.addActionListener(new ToppingButtonListener());
        panel.add(meatButton);

        orderButton = new JButton("Place Order");
        orderButton.addActionListener(new OrderButtonListener());
        panel.add(orderButton);

        orderLabel = new JLabel("");
        panel.add(orderLabel);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private class SizeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            size = button.getText();
        }
    }

    private class ToppingButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            topping = button.getText();
        }
    }

    private class OrderButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (size != null && topping != null) {
                orderLabel.setText("You have ordered a " + size + " pizza with " + topping + " topping.");
            } else {
                orderLabel.setText("Please select size and topping.");
            }
        }
    }

    public static void main(String[] args) {
        new PizzaOrderSystem();
    }
}