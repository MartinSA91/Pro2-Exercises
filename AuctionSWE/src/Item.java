public class Item
{
  private String itemName;


  public Item(String itemName)
  {
    this.itemName = itemName;
  }

  public String getItemName()
  {
    return itemName;
  }

  public void setItemName(String itemName)
  {
    this.itemName = itemName;
  }

  @Override public String toString()
  {
    return "Item: " + itemName;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Item))
    {
      return false;
    }
    Item other = (Item) obj;
    return itemName.equals(other.itemName);
  }



}
