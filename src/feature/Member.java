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
	private int weight;
	private int fat;
	private int muscle;
	private Map<String, String> ptPlan=new LinkedHashMap<>();
	private Map<String, String> ptMeal=new LinkedHashMap<>();
	
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getFat() {
		return fat;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public int getMuscle() {
		return muscle;
	}
	public void setMuscle(int muscle) {
		this.muscle = muscle;
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
	
	@Override
	public String toString() {
		return "[id=" + id + ", pw=" + pw + ", name=" + name + ", ageRange=" + ageRange + ", phone=" + phone
				+ ", phone2=" + phone2 + ", email=" + email + ", address=" + address + ", weight=" + weight + ", fat="
				+ fat + ", muscle=" + muscle + ", ptPlan=" + ptPlan + ", ptMeal=" + ptMeal + "]";
	}
}
