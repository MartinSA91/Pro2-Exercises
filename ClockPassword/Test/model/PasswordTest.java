package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest
{

  @BeforeEach void setUp()
  {
  }

  @Test void constructorNull()
  {
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
        ()-> new Password(null));
    assertEquals("Password must have at least 6 characters", ex.getMessage());
  }

  @Test void constructor5Characters()
  {
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
        ()-> new Password("12345"));
    assertEquals("Password must have at least 6 characters", ex.getMessage());
  }

  @Test void constructor6Characters()
  {
    assertDoesNotThrow(()-> new Password("1Sa456"));
  }

  @Test void constructor9Characters()
  {
    assertDoesNotThrow(()-> new Password("12345As789"));
  }
}