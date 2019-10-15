package Lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

public class FXMLDocumentController {

    @FXML
    public TextArea textArea;

    @FXML
    public Button button;

    @FXML
    public TextField textField;

    @FXML
    public MenuBar menuBar;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (!textField.getText().equals("")) {
            textArea.appendText(textField.getText() + "\n");
            textField.clear();
        }
    }

    @FXML
    private void handleAboutAction(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Create by PavelNazaro");
    }

    @FXML
    private void handleExitAction(ActionEvent event) {
        System.exit(0);
    }
}