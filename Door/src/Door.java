public class Door
{
  private DoorState state;

  public Door() {
    state = new DoorClosed();
  }

  public void setState(DoorState state) {
    this.state = state;
    System.out.println("Tilstand ændret til: " + state.getClass());
  }

  public void click() {
    state.click(this);
  }

  public void complete() {
    state.complete(this);
  }

  public void timeout() {
    state.timeout(this);
  }

  public DoorState status()
  {
    return state;
  }
}

