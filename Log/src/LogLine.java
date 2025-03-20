
public class LogLine

{
  private String text;
  private DateTime dateTime;


public LogLine(String text)
  {
    this.text = text;
    this.dateTime = new DateTime();
  }

  private String getText()
  {
    return text;
  }

  public DateTime getDateTime()
  {
    return dateTime;
  }

  public String toString()
  {
    return "LogLine{" + "text='" + text + '\'' + ", time=" + dateTime + '}';
  }

}



