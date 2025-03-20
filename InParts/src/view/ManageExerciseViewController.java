package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import javax.swing.plaf.synth.Region;

public class ManageExerciseViewController
{
  @FXML private Label headerLabel;
  @FXML private TextField sessionField;
  @FXML private TextField numberField;
  @FXML private TextField topicField;
  @FXML private RadioButton completedButton;
  @FXML private Label errorLabel;
  @FXML Button submitButton;
  private Region root;
  private ViewHandler viewHandler
}
