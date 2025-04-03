import java.util.ArrayList;
import java.util.Random;

public class CookieJar
{
  private ArrayList<Cookie> cookies;
  private int cookieCountWhenToBake;
  private int numberOfCookiesInOven;
  private int CookiePlateSize;
  private int jarSize;
  private boolean bakingInProgress;

  public CookieJar(int jarSize, Cookie cookie, int cookieCountWhenToBake)
  {
    this.jarSize = jarSize;
    this.cookies = new ArrayList<>();
    this.cookieCountWhenToBake = 0;

  }
  public boolean shouldBake()
  {
    return cookies.size()<= cookieCountWhenToBake && !bakingInProgress;
  }

  public void add(Cookie cookie)
  {
    cookies.add(cookie);
    System.out.println("Added " + cookie + ". Total cookies in jar: " + cookies.size());
    if(shouldBake())
    {
      bakingInProgress = true;
      bakeCookies();
    }
  }

  private synchronized void bakeCookies()
  {
    Random random = new Random();
    int cookiesToBake = random.nextInt(9) + 16;
    for(int i =0; i <cookiesToBake; i++)
    {
      cookies.add (new Cookie("cookie"));
    }
    System.out.println("baked " + cookiesToBake + " cookies. Total cookies in Jar" + cookies.size());
    bakingInProgress = false;
  }

  public synchronized Cookie eatCookie()
  {
    if (cookies.size() > 0)
    {
      Cookie cookie = cookies.remove(0); // Remove the first element
      System.out.println("Eating " + cookie + ". Total cookies left in jar: "
          + cookies.size());
      return cookie;
    }
    else
    {
      System.out.println(
          "No cookies to eat. Total cookies left in jar: " + cookies.size());
      return null;
    }
  }

  @Override
  public String toString()
  {
    return "CookieJar{cookies=" + cookies.size() + '}';
  }
}
