public class Computer
{
  public static void main(String[] args) throws InterruptedException
  {
    Mailbox mailbox = new Mailbox(20);
    Program[] programs = new Program[4];
    programs[0] = new Program("Windows", "update", 30);
    programs[1] = new Program("AVG", "update virus database", 5);
    programs[2] = new Program("FBackup", "perform a scheduled backup", 3);
    programs[3] = new Program("Skype", "notify: a person logging in", 17);
    System.out.println("---->Turning on the computer");
    Thread[] threads = new Thread[5];
    for (int i = 0; i < programs.length; i++)
    {
      threads[i] = new Thread(
          programs[i]);    // creating thread
          threads[i].start();                      // starting thread
    }
        threads[4] = new Thread(mailbox);
        threads[4].start();
        for (int i=0; i<threads.length; i++)
        {
          threads[i].join();                      // waiting for thread to terminate
          }
        System.out.println("<----Turning off the computer");
          }
        }

        // First part of the output ---->Turning on the computer
        // Windows wants to update
        // New mail in your mailbox...
        // Skype wants to notify: a person logging in
        // Windows wants to update
        // Windows wants to updateNew mail in your mailbox...
        // Skype wants to notify: a person logging in
