import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Scoreboard implements PropertyChangeListener
{
  private FootballGame game;
  public Scoreboard(FootballGame game)
  {
    this.game = game;
    showScore(game.getScore());
    game.addListener(this);
  }
  public void showScore(String score)
  {
    System.out.println("SCOREBOARD: " + score);
  }

  public void propertyChange(PropertyChangeEvent event)
  {
    showScore(event.getNewValue().toString());
  }
}
