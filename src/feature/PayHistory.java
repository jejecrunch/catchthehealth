package feature;

import java.util.Calendar;

public class PayHistory {
	Calendar c = Calendar.getInstance(); //객체 생성 및 현재 일시분초...셋팅
	String ntime = new String();
	boolean payingForExercise;
	String payMoney;
	MemberDAO m=MemberDAO.getInstance();
	Member user;
	int year=c.get ( Calendar.YEAR );
	int month=c.get ( Calendar.MONTH );
	int day=c.get ( Calendar.DATE );
	String exerciseSeason;
	String subject;
	public String getNtime() {
		return ntime;
	}


	public void setNtime() {
		ntime = String.valueOf(year) + "년 ";
		ntime += String.valueOf(month) + "월 ";
		ntime += String.valueOf(day) + "일";
	}


	public boolean isPayingForExercise() {
		return payingForExercise;
	}


	public void setPayingForExercise(boolean payingForExercise) {
		this.payingForExercise = payingForExercise;
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
