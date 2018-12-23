package feature;

import java.util.Calendar;

public class PayHistory {
	Calendar c = Calendar.getInstance(); //객체 생성 및 현재 일시분초...셋팅
	private String ntime = new String();
	private boolean payingForExercise;
	private String payMoney;
	private MemberDAO m=MemberDAO.getInstance();
	private Member user;
	private int year=c.get ( Calendar.YEAR );
	private int month=c.get ( Calendar.MONTH );
	private int day=c.get ( Calendar.DATE );
	private String exerciseSeason;
	private String subject;
	public String getNtime() {
		return ntime;
	}


	public void setNtime() {
		ntime = String.valueOf(year) + ". ";
		ntime += String.valueOf(month) + ". ";
		ntime += String.valueOf(day);
	}



	public String getPayMoney() {
		return payMoney;
	}


	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}


	public String getExerciseSeason() {
		return exerciseSeason;
	}


	public void setExerciseSeason(String exerciseSeason) {
		
		this.exerciseSeason = exerciseSeason;

	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public PayHistory(){



	}

}
