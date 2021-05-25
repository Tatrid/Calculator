package sample;


import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;


import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;


public class Controller implements Initializable {


     public TextField jTextFiel;
     private double nextNum;
    private double ans = 0;
    private double num = 0;

    private enum Operation {
        None,
        Plus,
        Minus,
        Multiple,
        Divide
    }
    private Operation operatia = Operation.None;

    public void Button1(MouseEvent mouseEvent) {
        
        jTextFiel.setText(jTextFiel.getText() + "1");
    }
    public void Button2(MouseEvent mouseEvent) {

        jTextFiel.setText(jTextFiel.getText() + "2");
    }
    public void Button3(MouseEvent mouseEvent) {
        jTextFiel.setText(jTextFiel.getText() + "3");
    }
    public void Button4(MouseEvent mouseEvent) {
        jTextFiel.setText(jTextFiel.getText() + "4");
    }
    public void Button5(MouseEvent mouseEvent) {
        jTextFiel.setText(jTextFiel.getText() + "5");
    }
    public void Button6(MouseEvent mouseEvent) {
        jTextFiel.setText(jTextFiel.getText() + "6");
    }
    public void Button7(MouseEvent mouseEvent) {
        jTextFiel.setText(jTextFiel.getText() + "7");
    }
    public void Button8(MouseEvent mouseEvent) {
        jTextFiel.setText(jTextFiel.getText() + "8");
    }
    public void Button9(MouseEvent mouseEvent) {
        jTextFiel.setText(jTextFiel.getText() + "9");
    }
    public void Button0(MouseEvent mouseEvent) {
       jTextFiel.setText(jTextFiel.getText() + "0");
    }
    public void ButtonC(MouseEvent mouseEvent) {
        jTextFiel.setText("");
    }
    public void Button_Point(MouseEvent mouseEvent) {
        jTextFiel.setText(jTextFiel.getText() +".");
    }


    private void ProcessOperation(double number)
    {
        if (operatia == Operation.None)
            return;

        switch (operatia)
        {
            case Minus:
            {
                num = num - number;
            }
            case Plus:
            {
                num = num + number;
            }
            case Multiple:
            {
                num = num * number;

            }
            case Divide:
            {
                num = num / number;
            }
            break;
        }
    }
    public void Button_Add(MouseEvent mouseEvent) {
        double currentNumber = Double.parseDouble((jTextFiel.getText()));
        if (operatia != Operation.None) {
            ProcessOperation(currentNumber);
        }
        else {
            num = currentNumber;
        }
        operatia = Operation.Plus;

        jTextFiel.setText("");
    }
    public void Button_Minus(MouseEvent mouseEvent) {
        double currentNumber = Double.parseDouble((jTextFiel.getText()));
        if (operatia != Operation.None) {
            ProcessOperation(currentNumber);
        }
        else {
            num = currentNumber;
        }
        operatia = Operation.Minus;

        jTextFiel.setText("");
    }
    public void Button_Multiple(MouseEvent mouseEvent) {
        double currentNumber = Double.parseDouble((jTextFiel.getText()));
        if (operatia != Operation.None) {
            ProcessOperation(currentNumber);
        }
        else {
            num = currentNumber;
        }
        operatia = Operation.Multiple;

        jTextFiel.setText("");
    }
    public void Button_Divide(MouseEvent mouseEvent) {
        double currentNumber = Double.parseDouble((jTextFiel.getText()));
        if (operatia != Operation.None) {
            ProcessOperation(currentNumber);
        }
        else {
            num = currentNumber;
        }
        operatia = Operation.Divide;

        jTextFiel.setText("");
    }
    public void Button_Equals(MouseEvent mouseEvent) {
        double currentNumber = Double.parseDouble((jTextFiel.getText()));
        if (operatia != Operation.None)
            ProcessOperation(currentNumber);
        operatia = Operation.None;
        jTextFiel.setText(String.valueOf(num));
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jTextFiel.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    Platform.runLater(() -> {
                        jTextFiel.setText(newValue.replaceAll("[^\\d.]", ""));
                    });

                }
            }
        });

    }


    @FXML
    private void TextFieldDigit(javafx.scene.input.KeyEvent evt) {
 /*       KeyCode b = evt.getCode();
      String a = evt.getCharacter();
        Character c = a.charAt(0);
        if (!Character.isDigit(c)){
            evt.consume();
    }*/}

}
/*public void TextField(MouseEvent mouseEvent){
        TextFieldDigit( );

}*/



