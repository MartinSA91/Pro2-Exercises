public class Main
{
  public static void main(String[] args)
  {
      CookieJar jar= new CookieJar(40, new Cookie("cookie"), 5);
      Thread baker1 = new Thread(new CookieBaker(jar));
      Thread eater1 = new Thread(new CookieEater(jar));
      Thread eater2 = new Thread(new CookieEater(jar));
      Thread eater3 = new Thread(new CookieEater(jar));
      Thread eater4 = new Thread(new CookieEater(jar));

      baker1.start();
      eater1.start();
      eater2.start();
      eater3.start();
      eater4.start();



  }
}
