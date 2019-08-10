import java.util.*;
import java.time.*;

public class Timer{
  private static Scanner scan = new Scanner(System.in);
  private static Date time;
  public static void main(String[] args){
    displayTimer();
  }

  private static long getTimerMilliseconds(){
    long days, hours, minutes, seconds, milliseconds;
    System.out.println("Type how much time you Set your timer for.");
    System.out.print("Days: ");
    days = scan.nextLong();
    System.out.print("Hours: ");
    hours = scan.nextLong();
    System.out.print("Minutes: ");
    minutes = scan.nextLong();
    System.out.print("Seconds: ");
    seconds = scan.nextLong();
    milliseconds = 0;
    milliseconds += seconds*1000;
    milliseconds += minutes*60000;
    milliseconds += hours*3600000;
    milliseconds += days*86400000;
    //System.out.println("milliseconds = "+milliseconds);
    return milliseconds;
  }

  private static void displayTimer(){
    long milliseconds = getTimerMilliseconds();
    long timeLeft, startingTime, days, hours, minutes, seconds, startTime;
    time = new Date();
    startTime =time.getTime();
    for(;;){
      time = new Date();
      startingTime = time.getTime() - startTime;
      if(startingTime == milliseconds){
        System.out.println("Timer finished!");
        break;
      }
      timeLeft = milliseconds - startingTime;
      //System.out.print("\r Time timeLeft = "+timeLeft+" startingTime = "+startingTime);
      days = timeLeft/86400000;
      timeLeft -= days*86400000;
      hours = timeLeft/3600000;
      timeLeft -= hours*3600000;
      minutes = timeLeft/60000;
      timeLeft -= minutes*60000;
      seconds = timeLeft/1000;
      System.out.print("\r "+days+":"+hours+":"+minutes+":"+seconds+" ");
    }
  }


}
