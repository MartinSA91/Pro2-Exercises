import java.util.ArrayList;

public class AuctionHouse
{
  private ArrayList<AuctionListing> list;

  public AuctionHouse()
  {
    list = new ArrayList<>();
  }

  public void createListing(Item item, double minPrice,String type)
  {
    list.add(new AuctionListing(item, minPrice,type));
  }

  public void activeListing(int index)
  {
   // list.get(index).setActive();
  }



}
