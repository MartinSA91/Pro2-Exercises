public class AuctionListing
{
  private Item item;
  private double minPrice;
  private String type;

  public AuctionListing(Item item, double minPrice, String type)
  {
    this.item = item;
    this.minPrice = minPrice;
    this.type = type;
  }

  public Item getItem()
  {
    return item;
  }
  public double getMinPrice()
  {
    return minPrice;
  }

  public String getType()
  {
    return type;
  }

  public String setMinPrice(double minPrice)
  {
    this.minPrice = minPrice;
    return "Minimum price has been set to " + minPrice;
  }

  @Override public String toString()
  {
    return String.format("%s: %s, %s", item, minPrice, type);
  }

  public boolean equals(AuctionListing auctionListing)
  {
    return item.equals(auctionListing.getItem()) && minPrice == auctionListing.getMinPrice() && type.equals(auctionListing.getType());
  }

}
