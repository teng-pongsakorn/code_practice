package easy;

public class DayOfTheWeek {

    // 1 Jan 1971 = Friday
    // 1 Jan 1972 = Saturday -- leap year
    // 1 Jan 1973 = Monday
    public String dayOfTheWeek(int day, int month, int year) {
        String[] dowStr = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int dow = 3;    // day of week of 31 Dec 1970
        int totalDays = 0;
        for (int y=1971; y<year; y++) {
            totalDays += getYearDays(y);
        }
        int feb = isLeap(year) ? 29 : 28;
        int[] monthDays = {31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int m=0; m<month-1; m++) {
            totalDays += monthDays[m];
        }
        totalDays += day;

        return dowStr[(dow + totalDays) % 7];
    }

    private int getYearDays(int year) {
        if (isLeap(year)) {
            return 366;
        }
        return 365;
    }

    private boolean isLeap(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DayOfTheWeek sol = new DayOfTheWeek();
        // Saturday
        System.out.println(sol.dayOfTheWeek(31, 8, 2019));
        // Sunday
        System.out.println(sol.dayOfTheWeek(18, 7, 1999));
        // Sunday
        System.out.println(sol.dayOfTheWeek(15, 8, 1993));
        // Friday
        System.out.println(sol.dayOfTheWeek(1,1,1971));
        // Friday
        System.out.println(sol.dayOfTheWeek(31,12,2100));
    }
}
