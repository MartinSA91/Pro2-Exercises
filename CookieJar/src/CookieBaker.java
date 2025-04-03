public class CookieBaker implements Runnable
{
  private CookieJar cookieJar;

  public CookieBaker(CookieJar jar)
  {
    this.cookieJar = jar;
  }

  private void spendSomeTime()
  {
    try
    {
      Thread.sleep(2500);
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
      Cookie cookie = new Cookie("cookie");
      System.out.println("Baking " + cookie);
      cookieJar.add(cookie);
      System.out.println("Cookie jar: " + cookieJar);
    }
  }
}
