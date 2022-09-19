/**************************************************************************
 * Программа сортировки орбит спутников
 * Дата создания: 31,08,2022 *
 **************************************************************************/


package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame {
    private String filePath;
    private JFrame frame;
    private JPanel panel;
    private JButton buttonSort;
    private JLabel label;
    private JLabel labelWarning = new JLabel("Параметры яркости вводить строго через ТОЧКУ!!! Нажать ENTER!");
    private JTextField textField;
    private Double brightness=18.3;

        public static void main (String[]args){
            Main main = new Main();
            main.go();
        }

        private void go () {
            frame = new JFrame("Satellite Sort");
            panel= new JPanel();
            label = new JLabel("Установите яркость: ");
            textField = new JTextField("18.3");

            buttonSort = new JButton("Сортировать");
            buttonSort.setSize(150, 50);
            buttonSort.addActionListener(new ButtonListener());

            textField.addActionListener(new TextFieldListener());

            panel.add(buttonSort);
            panel.add(label);
            panel.add(textField);
            panel.add(labelWarning);

            frame.add(panel);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(3);
            frame.setSize(500, 100);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
        private class ButtonListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent eevent) {
                JFileChooser jfc = new JFileChooser();
                //jfc.setCurrentDirectory();
                int r = jfc.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION){
                    filePath = jfc.getSelectedFile().getAbsolutePath();
                    Sort sort = new Sort();
                    try {
                        FileIO.fileOutput(filePath, sort.sort(filePath, brightness));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    frame.dispose();
                }
            }
        }
        private class TextFieldListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                brightness = Double.parseDouble(textField.getText());
                label.setText("Яркость изменена");
            }
        }
    }