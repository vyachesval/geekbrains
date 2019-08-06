package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public TextField text;
    char znak = ' ';
    double memory = 0;

    public void pressBtnPlus(ActionEvent actionEvent) {
        znak = '+';
        memory = readDoubleFromText();
        text.setText("");
        text.requestFocus();
    }

    public void pressBtnMinus(ActionEvent actionEvent) {
        znak = '-';
        memory = readDoubleFromText();
        text.setText("");
        text.requestFocus();
    }


    private double readDoubleFromText() {
        try {
            return Double.parseDouble(text.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void pressBtnCalc(ActionEvent actionEvent) {
        double num = readDoubleFromText();
        if (znak == '+') {
            memory += num;
        }
        if (znak == '-') {
            memory -= num;
        }

        text.setText(""+memory);
    }
}
