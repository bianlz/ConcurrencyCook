package Test_2.test_2;

public class Cinema {
	private long vacanciesCinema1;
	private long vacanciesCinema2;
	private final Object controlCinema1, controlCinema2;
	public Cinema(){
		vacanciesCinema1 = 20;
		vacanciesCinema2 = 20;
		controlCinema1 = new Object();
		controlCinema2 = new Object();
	}
	public boolean sellTickets1(int num){
		synchronized (controlCinema1) {
			if(num<vacanciesCinema1){
				vacanciesCinema1 -=num;
				return true;
			} else {
				return false;
			}

		}
	}
	public boolean sellTickets2(int number){
		synchronized (controlCinema2) {
			if(number<vacanciesCinema2){
				vacanciesCinema2 -=number;
				return true;
			} else {
				return false;
			}

		}
	}
	
	public boolean returnTickets1 (int number) {
		synchronized (controlCinema1) {
			vacanciesCinema1 += number;
			return true;
		}
	}
	
	public boolean returnTickets2 (int number) {
		synchronized (controlCinema2) {
			vacanciesCinema2 += number;
			return true;
		}
	}
	public long getVacanciesCinema1() {
		return vacanciesCinema1;
	}
	public long getVacanciesCinema2() {
		return vacanciesCinema2;
	}
}
