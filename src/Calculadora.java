import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    private JTextField numField1;
    private JTextField numField2;
    private JButton calculateButton;
    private JLabel resultLabel;
    private JRadioButton sumRadioButton;
    private JRadioButton resRadioButton;
    private JRadioButton mulRadioButton;
    private JRadioButton divRadioButton;
    private JList<Double> resultList;
    private DefaultListModel<Double> listModel;
    private JScrollPane scrollPane;

    public Calculadora(){
        setTitle("Calculadora");
        setSize(400, 250);
        setLayout(null);

        numField1 = new JTextField();
        numField2 = new JTextField();

        sumRadioButton = new JRadioButton("Suma");
        resRadioButton = new JRadioButton("Resta");
        mulRadioButton = new JRadioButton("Multiplicación");
        divRadioButton = new JRadioButton("División");

        ButtonGroup operationGroup = new ButtonGroup();
        operationGroup.add(sumRadioButton);
        operationGroup.add(resRadioButton);
        operationGroup.add(mulRadioButton);
        operationGroup.add(divRadioButton);

        calculateButton = new JButton("Calcular");

        resultLabel = new JLabel("Resultado: ");

        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        scrollPane = new JScrollPane(resultList);

        numField1.setBounds(10, 10, 100, 25);
        numField2.setBounds(10, 40, 100, 25);
        sumRadioButton.setBounds(10, 70, 100, 25);
        resRadioButton.setBounds(10, 100, 100, 25);
        mulRadioButton.setBounds(10, 130, 120, 25);
        divRadioButton.setBounds(10, 160, 100, 25);
        calculateButton.setBounds(120, 10, 100, 25);
        resultLabel.setBounds(120, 40, 150, 25);
        scrollPane.setBounds(250, 10, 120, 175);

        add(numField1);
        add(numField2);
        add(sumRadioButton);
        add(resRadioButton);
        add(mulRadioButton);
        add(divRadioButton);
        add(calculateButton);
        add(resultLabel);
        add(scrollPane);

        setVisible(true);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
    }

    public void calcular(){
        double resultado;
        double n1 = Double.parseDouble(numField1.getText());
        double n2 = Double.parseDouble(numField2.getText());
        if (sumRadioButton.isSelected()) {
            resultado = n1 + n2;
        } else if (resRadioButton.isSelected()) {
            resultado = n1 - n2;
        } else if (mulRadioButton.isSelected()) {
            resultado = n1 * n2;
        } else if (divRadioButton.isSelected()) {
            if (n2 != 0) {
                resultado = n1 / n2;
            } else {
                resultLabel.setText("Error: División por cero");
                return;
            }
        } else {
            resultLabel.setText("Error: Selecciona una operación");
            return;
        }
        listModel.addElement(resultado);
        resultLabel.setText("Resultado: " + String.valueOf(resultado));
    }
}
