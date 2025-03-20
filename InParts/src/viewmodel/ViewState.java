package viewmodel;

public class ViewState
{
  private String number;
  private boolean remove;

  public ViewState(String number, boolean remove)
  {
    this.number = number;
    this.remove = remove;
  }

  public String getNumber()
  {
    return number;
  }

  private void setNumber(String number)
  {
    this.number = number;
  }

  public void removeNumber()
  {
    remove = true;
  }

  public boolean isRemove()
  {
    return remove;
  }

  public void setRemove(boolean remove)
  {
    this.remove = remove;
  }
}
