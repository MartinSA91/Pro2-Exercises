public class Cookie
{
  private String type;

  public Cookie(String type)
  {
    this.type = type;
  }
  public String getType()
  {
    return type;
  }
  public void setType(String type)
  {
    this.type = type;
  }
  public String toString()
  {
    return "cookie: " + type;
  }
}
