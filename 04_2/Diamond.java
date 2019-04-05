package prog_assign04;

import java.util.Comparator;

public class Diamond {
	String IP;
	String Time;
	String URL;
	String Status;
	
	public Diamond(String ip, String time, String url, String status) {
		IP = ip;
		Time = time;
		URL = url;
		Status = status;
	}
	
	public static Comparator<Diamond> IpComparator = new Comparator<Diamond>() {
		public int compare(Diamond ip1, Diamond ip2) {
			String ipcheck1 = ip1.IP.split("\\.")[1];
			String ipcheck2 = ip2.IP.split("\\.")[1];
			if(ipcheck1 == ipcheck2)
				return sortTime(ip1, ip2);
			else
				return ipcheck1.compareTo(ipcheck2);
		}
		
	};
	public static Comparator<Diamond> TimeComparator = new Comparator<Diamond>() {
		public int compare(Diamond time1, Diamond time2) {
			return sortTime(time1, time2);
		}		
	};
	private static int sortTime(Diamond time1, Diamond time2) {
		int year1 = Integer.parseInt(time1.Time.split("/")[2].split(":")[0]);
		int year2 = Integer.parseInt(time2.Time.split("/")[2].split(":")[0]);
		if (year1 != year2)
			return year1 - year2;
		else {
			int mon1 = monthch(time1.Time.split("/")[1]);
			int mon2 = monthch(time2.Time.split("/")[1]);
			if(mon1 != mon2)
				return mon1 - mon2;
			else {
				int day1 = Integer.parseInt(time1.Time.split("/")[0]);
				int day2 = Integer.parseInt(time2.Time.split("/")[0]);
				if(day1 != day2)
					return day1 - day2;
				else {
					int hour1 = Integer.parseInt(time1.Time.split("/")[2].split(":")[1]);
					int hour2 = Integer.parseInt(time2.Time.split("/")[2].split(":")[1]);
					if(hour1 != hour2)
						return hour1 - hour2;
					else {
						int min1 = Integer.parseInt(time1.Time.split("/")[2].split(":")[2]);
						int min2 = Integer.parseInt(time2.Time.split("/")[2].split(":")[2]);
						if(min1 != min2)
							return min1 - min2;
						else {
							int sec1 = Integer.parseInt(time1.Time.split("/")[2].split(":")[3]);
							int sec2 = Integer.parseInt(time2.Time.split("/")[2].split(":")[3]);
							return sec1 - sec2;
						}
					}
				}
			}
		}
	}
	private static int monthch(String mon) {
		if(mon.equals("Jan"))
			return 1;
		else if(mon.equals("Feb"))
			return 2;
		else if(mon.equals("Mar"))
			return 3;
		else if(mon.equals("Apr"))
			return 4;
		else if(mon.equals("May"))
			return 5;
		else if(mon.equals("Jun"))
			return 6;
		else if(mon.equals("Jul"))
			return 7;
		else if(mon.equals("Aug"))
			return 8;
		else if(mon.equals("Sep"))
			return 9;
		else if(mon.equals("Jul"))
			return 7;
		else if(mon.equals("Aug"))
			return 8;
		else if(mon.equals("Sep"))
			return 9;
		else if(mon.equals("Oct"))
			return 10;
		else if(mon.equals("Nov"))
			return 11;
		else if(mon.equals("Dec"))
			return 11;
		else
			return 0;
	}
}
