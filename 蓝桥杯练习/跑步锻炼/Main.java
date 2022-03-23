public class Main {


    public static int weekplus(int week){
      return week % 7 + 1;
    }

    public static int[] dayplus(int year, int month, int day){
      day += 1;
      if(year % 4 == 0){
        if(month == 2){
          if(day == 30){
            day = 1;
            month++;
            int[] time2 = new int[3];
            time2[0] = year;
            time2[1] = month;
            time2[2] = day;
            return time2;
          }
        }
      }

      if(year % 4 != 0 && month == 2 && day == 29){
          month ++;
          day = 1;
          int[] time2 = new int[3];
            time2[0] = year;
            time2[1] = month;
            time2[2] = day;
            return time2;
      }


      if(month == 12 && day == 32){
        year++;
        month = 1;
        day = 1;
        int[] time2 = new int[3];
            time2[0] = year;
            time2[1] = month;
            time2[2] = day;
            return time2;
      }

      if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10){
        if(day == 32){
          month++;
          day = 1;
          int[] time2 = new int[3];
            time2[0] = year;
            time2[1] = month;
            time2[2] = day;
            return time2;
        }
      }

      if(month == 4 || month == 6 || month == 9 || month == 11){
        if(day == 31){
          month++;
          day = 1;
          int[] time2 = new int[3];
            time2[0] = year;
            time2[1] = month;
            time2[2] = day;
            return time2;
        }
      }
      int[] time2 = new int[3];
      time2[0] = year;
      time2[1] = month;
      time2[2] = day;
      return time2;
  }

    public static void main(String[] args) {
        
        int[] time = {2000, 1, 1};
        int week = 6;
        int kilo = 0;
        while(time[0] < 2021){
          if(time[0] == 2020 && time[1] == 10 && time[2] == 2)
            break;
          if(time[2] == 1 || week == 1){
            kilo += 2;
            time = dayplus(time[0], time[1], time[2]);
            week = weekplus(week);
            continue;
          }
          else{
            kilo++;
            time = dayplus(time[0], time[1], time[2]);
            week = weekplus(week);
            continue;
          }

        }
        System.out.println(kilo);
    }
}