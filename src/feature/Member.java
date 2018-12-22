package feature;

import java.util.*;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String ageRange;
	private String phone;
	private String phone2;
	private String email;
	private String address;
	private Map<Date, Integer> weight=new LinkedHashMap<>();
	private Map<Date, Integer> fat=new LinkedHashMap<>();
	private Map<Date, Integer> muscle=new LinkedHashMap<>();
	private String clothesSize=null; // 운동복 사이즈 지정
	private String lockerroom;//락커룸 번호(admin이 지정)
	private PayHistoryDAO paydao;


	private Map<String, String> ptPlan=new LinkedHashMap<>();
	private Date ptPlanUpDate = new Date();
	private Map<String, String> ptMeal=new LinkedHashMap<>();
	private Date ptMealUpDate = new Date();

	public Member() {

	}

	public Member(String id, String pw) {
		this.id=id;
		this.pw=pw;
	}

	public Member(String id, String pw, String name, String phone, String email) {
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.phone=phone;
		this.email=email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw=pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAgeRange() {
		return ageRange;
	}
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getWeight(Date when) {
		return weight.get(when);
	}
	public void setWeight(Date when, int value) {
		weight.put(when, value);
	}
	public int getFat(Date when) {
		return fat.get(when);
	}
	public void setFat(Date when, int value) {
		fat.put(when, value);
	}
	public int getMuscle(Date when) {
		return muscle.get(when);
	}
	public void setMuscle(Date when, int value) {
		muscle.put(when, value);
	}
	public String getPtPlan(String day) {
		return ptPlan.get(day);
	}
	public Set<String> planColumn() {
		return ptPlan.keySet();
	}
	public void setPtPlan(String day, String time) {
		ptPlan.put(day, time);
	}
	public String getPtMeal(String day) {
		return ptMeal.get(day);
	}
	public Set<String> mealColumn(){
		return ptMeal.keySet();
	}
	public void setPtMeal(String day, String meal) {
		ptMeal.put(day, meal);
	}
	public String getLockerroom() {
		return lockerroom;
	}
	public void setLockerroom(String lockerroom) {
		this.lockerroom = lockerroom;
	}
	public String getClothesSize() {
		return clothesSize;
	}
	public void setClothesSize(String clothesSize) {
		this.clothesSize = clothesSize;
	}
	public Date getPtPlanUpDate() {
		return ptPlanUpDate;
	}
	public void setPtPlanUpDate(Date date) {
		this.ptPlanUpDate=date;
	}
	public Date getPtMealUpDate() {
		return ptMealUpDate;
	}
	public void setPtMealUpDate(Date date) {
		this.ptMealUpDate=date;
	}

	public PayHistoryDAO getPaydao() {
		return paydao;
	}

	public void setPaydao(PayHistoryDAO paydao) {
		if(paydao==null) 
			this.paydao = paydao;
		}
	public void setPaydao(PayHistory p) {
		this.paydao.add(p);
	}
}

