package com.sourceit.swing;
import com.sourceit.calculation.PolishStrategy;
import com.sourceit.exceptions.ConversionException;
import com.sourceit.exceptions.WrongCalculationOperator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConvertorCalculatorSwing extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConvertorCalculatorSwing frame = new ConvertorCalculatorSwing();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ConvertorCalculatorSwing() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 424, 155);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(95, 11, 286, 20);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(95, 42, 286, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblA = new JLabel("function: ");
        lblA.setBounds(15, 14, 60, 14);
        panel.add(lblA);

        JLabel lblB = new JLabel("result: ");
        lblB.setBounds(15, 45, 60, 14);
        panel.add(lblB);

        JButton btnResult = new JButton("Calculate");
        btnResult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{
                    try {
                        String result = new PolishStrategy().eval(textField.getText()).toString();
                        textField_1.setText(result);
                    } catch (WrongCalculationOperator wrongCalculationOperator) {
                        wrongCalculationOperator.printStackTrace();
                    } catch (ConversionException e) {
                        e.printStackTrace();
                    }
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "NumberFormatException");
                }
            }
        });
        btnResult.setBounds(70, 75, 89, 23);
        panel.add(btnResult);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{
                    textField.setText("");
                    textField_1.setText("");
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "NumberFormatException");
                }
            }
        });
        btnDelete.setBounds(240, 75, 89, 23);
        panel.add(btnDelete);
    }
}

