package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

  public static String getRandomString(int length) {
    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder result = new StringBuilder();
    Random rnd = new Random();
    while (result.length() < length) {
      int index = (int) (rnd.nextFloat() * SALTCHARS.length());
      result.append(SALTCHARS.charAt(index));
    }
    return result.toString();
  }

  public static String getRandomGender() {
    List<String> list = Arrays.asList("Female", "Male", "Other");
    return getRandomElementFromList(list);
  }

  public static String getRandomHobby() {
    List<String> list = Arrays.asList("Sports", "Reading", "Music");
    return getRandomElementFromList(list);
  }

  public static String getRandomElementFromList(List<String>list){
    int size = list.size();
    int randIdx = ThreadLocalRandom.current().nextInt(size);
    String randomElem = list.get(randIdx);
    return randomElem;
  }

  public static String getRandomMonth() {
    List<String> list = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December");
    return getRandomElementFromList(list);
  }

  public static String getRandomDay() {
    List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
    return getRandomElementFromList(list);
  }

  public static String getRandomYear() {
    List<String> list = Arrays.asList("1990", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "1991");
    return getRandomElementFromList(list);
  }
}