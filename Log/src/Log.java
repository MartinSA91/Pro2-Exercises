import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Log
{
private ArrayList<LogLine> logs;
private static Map<String, Log> allInstances = new HashMap<>();
private String fileName;

private Log(String fileName)
{
  logs = new ArrayList<>();
  this.fileName = fileName;

}

public static Log getInstance(String logFile)
{
  Log instance = allInstances.get(logFile);
  if (instance == null)
  {
    instance = new Log(logFile);
    allInstances.put(logFile, instance);
  }
  return instance;
}

public void addLog(String text)
{
  LogLine log = new LogLine(text);
  logs.add(log);
  addToFile(log);
}



public ArrayList<LogLine> getAll()
{
  return logs;
}

public String toString()
{
  return "Log: " + logs;
}


  private void addToFile(LogLine log)
  {
    if (log == null)
    {
      return;
    }
    BufferedWriter out = null;
    try
    {

      out = new BufferedWriter(new FileWriter(fileName, true));
      out.write(log + "\n");
    }
    catch (Exception e) {e.printStackTrace();}
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}
