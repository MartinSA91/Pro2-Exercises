import java.time.LocalTime;
import java.util.Date;

public class Notification implements Runnable
{

  private LocalTime targetTime;
  private LocalTime currentTime;

  public Notification(LocalTime targetTime,LocalTime timeUntilTarget)
  {
    this.targetTime = targetTime;
    this.currentTime = currentTime;
  }

  @Override
  public void run()
  {
  while(true)
  {
    System.out.println("Husk dine opgaver for i dag!");
    break;
  } else {
      try {
        System.out.println("Venter i " + currentTime.now());
      }
    }
  }
}
