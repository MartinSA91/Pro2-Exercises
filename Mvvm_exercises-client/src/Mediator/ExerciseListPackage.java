package Mediator;

import model.Exercise;

import java.util.ArrayList;

public class ExerciseListPackage
{
  private String type;
  private ArrayList<Exercise> exercises;

  public ExerciseListPackage(String type, ArrayList<Exercise> exercises)
  {
    this.type = type;
    this.exercises = exercises;
  }

  public String getType()
  {
    return type;
  }
  public ArrayList<Exercise> getExercises()
  {
    return exercises;
  }

  @Override public String toString()
  {
    return super.toString();
  }
}
