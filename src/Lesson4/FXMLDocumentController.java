package Lesson4;

import javafx.application.Platform;
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
    public MenuBar menuBar;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (!textField.getText().equals("")) {
            textArea.appendText(textField.getText() + System.lineSeparator());
            textField.clear();
        }
    }

    @FXML
    private void handleAboutAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Create by PavelNazaro");
        alert.setHeaderText("About");
        alert.show();
    }

    @FXML
    private void handleExitAction(ActionEvent event) {
        Platform.exit();
    }
}