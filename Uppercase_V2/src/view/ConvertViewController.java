package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.ConvertViewModel;

import javax.swing.text.View;


public class ConvertViewController
{
  @FXML private TextField requestField;
  @FXML private TextField replyField;
  @FXML private Label errorLabel;
  private Region root;
  private ConvertViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, ConvertViewModel viewModel, Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;
    requestField.textProperty().bindBidirectional(viewModel.getRequestProperty());
    replyField.textProperty().bind(viewModel.getReplyProperty());
    errorLabel.textProperty().bind(viewModel.getErrorProperty());
  }
  public void reset()
  {

  }

  public Region getRoot()
  {
    return root;
  }
  @FXML
  private void onSubmit()
  {
    viewModel.convert();
  }

  @FXML private void onEnter() {
    onSubmit(); }

  @FXML private void onShow()
  {
    viewHandler.openView("log");
  }
}
