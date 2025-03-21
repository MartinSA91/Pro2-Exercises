package Mediator;

import model.Exercise;

public class ExercisePackage
{
  private String type;
  private String number;
  private String error;
  private Exercise exercise;

  public ExercisePackage(String type, Exercise exercice, String error)
  {
    this.type = type;
    this.exercise = exercise;
    this.error = error;
  }

  public ExercisePackage(String type, String error)
  {
    this.type = type;
    this.error = error;
  }
  public Exercise getExercise()
  {
    return exercise;
  }

  public String getType()
  {
    return type;
  }
  public String  getNumber()
  {
    return number;
  }

  public String getError()
  {
    return error;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof ExercisePackage))
    {
      return false;
    }
    ExercisePackage other = (ExercisePackage) obj;
    return type.equals(other.type) && number.equals(other.number) && error.equals(other.error) && exercise.equals(other.exercise);
  }

  public String toString()
  {
    return "ExercisePackage{" + "type='" + type + '\'' + ", number='" + number + '\'' + ", error='" + error + '\'' + ", exercise=" + exercise + '}';
  }
}
