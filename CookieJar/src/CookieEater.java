public class CookieEater implements Runnable
{
  private CookieJar cookieJar;

  public CookieEater(CookieJar jar)
  {
    this.cookieJar = jar;
  }

  private void spendSomeTime()
  {
    try
    {
      Thread.sleep(8000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  public void run()
  {
    while (true)
    {
      spendSomeTime();
      Cookie cookie = cookieJar.eatCookie();
      System.out.println("Eating " + cookie);
      System.out.println("Cookie jar: " + cookieJar);
    }
  }
}
