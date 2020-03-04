import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainForm;
    private JButton collapseButton;
    private JButton expandButton;
    private JTextField lastName;
    private JTextField firstName;
    private JTextField paterName;
    private JPanel lastnamePanel;
    private JPanel paterNamePanel;
    private JPanel firstNamePanel;
    private JPanel initPanel;
    private JLabel paterNameLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JTextField commulativeField;
    private JLabel comLabel;
    String[] values;

    public MainForm() {
        collapseButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String lastNameValue = lastName.getText().trim();
                String firstNameValue = firstName.getText().trim();
                String paterNameValue = paterName.getText().trim();

                if (firstNameValue.length() != 0 && lastNameValue.length() != 0) {
                    // Удаляем все существующие элементы
                    lastnamePanel.remove(lastName);
                    lastnamePanel.remove(lastNameLabel);

                    firstNamePanel.remove(firstName);
                    firstNamePanel.remove(firstNameLabel);

                    paterNamePanel.remove(paterName);
                    paterNamePanel.remove(paterNameLabel);

                    // Создаем и размещаем на форме новые элементы
                    commulativeField = new JTextField();
                    commulativeField.setHorizontalAlignment(0);


                    comLabel = new JLabel();
                    comLabel.setText("ФИО");

                    comLabel.setHorizontalAlignment(0);
                    comLabel.setVerticalAlignment(1);
                    commulativeField.setPreferredSize(new Dimension(150, 30));
                    commulativeField.setText(lastNameValue + " " + firstNameValue + " " + paterNameValue);
                    firstNamePanel.add(commulativeField, BorderLayout.NORTH);

                    firstNamePanel.add(comLabel);
                    //Обновляем интерфейс
                    mainForm.updateUI();
                } else {
                    getErrorDialog();
                }
            }
        });

        expandButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {

                values = commulativeField.getText().split("\\s");
                //System.out.println(values.length);
                if (values.length >= 2) {

                    lastnamePanel.add(lastName, BorderLayout.NORTH);
                    lastName.setText(values[0]);
                    lastnamePanel.add(lastNameLabel);

                    firstNamePanel.add(firstName, BorderLayout.NORTH);
                    firstName.setText(values[1]);
                    firstNamePanel.add(firstNameLabel);

                    if (values.length == 3) {
                        paterName.setText(values[2]);
                    } else {
                        paterName.setText("");
                    }

                    paterNamePanel.add(paterName, BorderLayout.NORTH);
                    paterNamePanel.add(paterNameLabel);
                    mainForm.updateUI();
                } else {
                    getErrorDialog();
                }
            }
        });
    }

    public JPanel getForm() { return mainForm; }

    private void getErrorDialog ()
    {
        JOptionPane.showMessageDialog(
                mainForm,
                "Ошибка!",
                "Ощибка ввода",
                JOptionPane.PLAIN_MESSAGE
        );
    }
}
