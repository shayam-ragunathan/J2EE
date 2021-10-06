package sample.beans;

import java.util.ArrayList;
import java.util.List;

public class ProfessionalData {
	private String role;
	private int experience;
	private List<String> skills = new ArrayList<>();
	public ProfessionalData() {
		// TODO Auto-generated constructor stub
	}
	public ProfessionalData(String role, int experience, List<String> skills) {
		super();
		this.role = role;
		this.experience = experience;
		this.skills = skills;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
}