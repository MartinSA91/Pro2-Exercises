package viewmodel;

import javafx.beans.property.*;
import model.AuctionModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AuctionItemViewModel implements PropertyChangeListener
{
  private StringProperty item;
  private StringProperty time;
  private IntegerProperty bid;
  private StringProperty bidder;
  private IntegerProperty currentBid;
  private StringProperty currentBidder;
  private StringProperty error;
  private BooleanProperty end;
  private StringProperty currentBidTitle;
  private AuctionModel model;

  public AuctionItemViewModel(AuctionModel model)
  {
    this.item = new SimpleStringProperty(model.getItem());
    this.time = new SimpleStringProperty();
    this.bid = new SimpleIntegerProperty();
    this.bidder = new SimpleStringProperty();
    this.currentBid = new SimpleIntegerProperty(model.getCurrentBid());
    this.currentBidder = new SimpleStringProperty(model.getCurrentBidder());
    this.error = new SimpleStringProperty();
    this.end = new SimpleBooleanProperty();
    this.currentBidTitle = new SimpleStringProperty("Current Bid");
  }

  public void clear()
  {

  }

public void bid(int amount)
{
  if (amount > currentBid.get() && !"You".equals(currentBidder.get()))
  {
    model.placeBid(amount, "You");
  }
}

  public StringProperty getItemProperty()
  {
    return item;
  }

  public IntegerProperty getBidProperty()
  {
    return bid;
  }

  public StringProperty getBidderProperty()
  {
    return bidder;
  }

  public IntegerProperty getCurrentBidProperty()
  {
    return currentBid;
  }

  public StringProperty getCurrentBidderProperty()
  {
    return currentBidder;
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }

  public StringProperty getTimeProperty()
  {
    return time;
  }

  public BooleanProperty getEndProperty()
  {
    return null;
  }

public StringProperty getCurrentBidTitleProperty()
  {
    return currentBidTitle;
  }

public void propertyChange(PropertyChangeEvent evt)
  {
    System.out.println("-->"+evt.getPropertyName() + ": " + evt.getNewValue());
  }


}
