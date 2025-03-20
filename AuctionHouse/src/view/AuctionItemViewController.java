package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.util.converter.NumberStringConverter;
import javafx.util.converter.TimeStringConverter;
import viewmodel.AuctionItemViewModel;

public class AuctionItemViewController
{
  @FXML private Label itemLabel;
  @FXML private Label timeLabel;
  @FXML private Label currentBidTitle;
  @FXML private Label currentBidLabel;
  @FXML private Label currentBidderLabel;
  @FXML private TextField bidField;
  @FXML private Label errorLabel;
  private Region root;
  private AuctionItemViewModel viewModel;
  private ViewHandler viewHandler;

  public AuctionItemViewController()
  {

  }

  public void init(ViewHandler viewHandler, AuctionItemViewModel viewModel, Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;
    itemLabel.textProperty().bind(viewModel.getItemProperty());
    timeLabel.textProperty().bind(viewModel.getTimeProperty()), new TimeStringConverter());
    currentBidTitle.textProperty().bind(viewModel.getCurrentBidTitleProperty());
    currentBidLabel.textProperty().bind(viewModel.getCurrentBidProperty().asString());
    currentBidderLabel.textProperty().bind(viewModel.getCurrentBidderProperty());
    bidField.textProperty().bindBidirectional(viewModel.getBidProperty(), new NumberStringConverter());
    errorLabel.textProperty().bind(viewModel.getErrorProperty());
  }
  public void reset()
  {
    viewModel.clear();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void bidOnAction()
  {
    viewModel.bid(Integer.parseInt(bidField.getText()));
  }

}
