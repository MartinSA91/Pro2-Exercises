package viewmodel;

public class ViewModelFactory
{
  private Model model;

  public ViewModelFactory(Model model)
  {
    this.model = model;
  }

  public SimpleExerciseViewModel getSimpleExerciseViewModel()
  {
    return new SimpleExerciseViewModel(model.getExercise());
  }

  public ViewState getViewState()
  {
    return new ViewState();
  }
}
