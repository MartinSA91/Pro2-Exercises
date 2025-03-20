import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;

public class ObservableClock implements Runnable {
  private final PropertyChangeSupport support;

  public ObservableClock() {
    support = new PropertyChangeSupport(this);
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener);
  }

  @Override
  public void run() {
    while (true) {
      String timeString = LocalTime.now().toString();
      support.firePropertyChange("time", null, timeString);

      try {
        Thread.sleep(1000); // Opdatering hver sekund
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
