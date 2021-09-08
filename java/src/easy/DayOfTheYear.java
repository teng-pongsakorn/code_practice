package easy;

public class DayOfTheYear {
    int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
    public int dayOfYear(String date) {
        String[] yearMonthDay = date.split("-");
        int year = Integer.valueOf(yearMonthDay[0]);
        int month = Integer.valueOf(yearMonthDay[1]);
        int day = Integer.valueOf(yearMonthDay[2]);
        for (int m=0; m<month-1; m++) {
            day += months[m];
        }
        if (month > 2 && isLeapYear(year)) {
            day += 1;
        }
        return day;
    }

    private boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DayOfTheYear sol = new DayOfTheYear();

        // 9
        System.out.println(sol.dayOfYear("2019-01-09"));

        // 41
        System.out.println(sol.dayOfYear("2019-02-10"));

        // 60
        System.out.println(sol.dayOfYear("2003-03-01"));

        // 61
        System.out.println(sol.dayOfYear("2004-03-01"));
    }
}
