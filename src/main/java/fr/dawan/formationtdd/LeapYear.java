package fr.dawan.formationtdd;

public class LeapYear {

//  public static boolean isLeapYear(int year) {
//  return true;
//}

//  public static boolean isLeapYear(int year) {
//  return year%4==0;
//}

//  public static boolean isLeapYear(int year) {
//  return year%4==0 && year%100!=0;
//}

//    public static boolean isLeapYear(int year) {
//        return (year%4==0 && year%100!=0) || year%400 ==0;
//    }

    // refactor
    public static boolean isLeapYear(int year) {
        return (isDivisible(year, 4) && !isDivisible(year, 100)) || isDivisible(year, 400);
    }

    private static boolean isDivisible(int num, int div) {
        return num % div == 0;
    }
}
