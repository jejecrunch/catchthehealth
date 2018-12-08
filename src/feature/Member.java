package feature;

import java.util.HashMap;
import java.util.Map;

public class Member {
	private String id;
	private String name;
	private int age;
	private String phone;
	private String email;
	private String address;
	private int weight;
	private int fat;
	private int muscle;
	private Map<String, String> ptPlan = new HashMap<String, String>();
	private Map<String, String> ptMeal = new HashMap<String, String>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public void setPtPlan(String day, String time) {
		ptPlan.put(day, time);
	}
	public String getPtMeal(String day) {
		return ptMeal.get(day);
	}
	public void setPtMeal(String day, String meal) {
		ptMeal.put(day, meal);
	}
}
