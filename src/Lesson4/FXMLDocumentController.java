package Lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FXMLDocumentController {

    @FXML
    public TextArea textArea;

    @FXML
    public Button button;

    @FXML
    public TextField textField;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (!textField.getText().equals("")) {
            textArea.appendText(textField.getText() + "\n");
            textField.clear();
        }
    }

}