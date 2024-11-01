package application;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
	
	private SimpleStringProperty id;
	private SimpleIntegerProperty grade;
	private SimpleStringProperty nameKorean;
	private SimpleStringProperty nameEnglish;
	private SimpleBooleanProperty isHonors;
	private SimpleStringProperty honors;
	private SimpleBooleanProperty isLivingDorm;
	private SimpleStringProperty dorm;
	private School campus;
	private SimpleIntegerProperty blessingTotal;
	private SimpleIntegerProperty tallyTotal;
	private SimpleStringProperty doB;
	private SimpleStringProperty gender;
	private ArrayList<Blessing> blessings=new ArrayList<Blessing>();
	private ArrayList<Tally> tallies=new ArrayList<Tally>();
	private ArrayList<Subject> subjects=new ArrayList<Subject>();
	private SimpleStringProperty enrollmentDate;
	private SimpleStringProperty campusName;
	
	
	private SimpleStringProperty subjectList;
	
	public Student(int grade, String nameEnglish) {
		this.grade = new SimpleIntegerProperty(grade);
		this.nameEnglish = new SimpleStringProperty(nameEnglish);
	}
	
	//input
	public Student(int grade, String nameEnglish, String nameKorean, String campus, String gender, String doB, boolean isHonors, boolean isLivingDorm) {
		this.grade= new SimpleIntegerProperty(grade);
		this.nameEnglish= new SimpleStringProperty(nameEnglish);
		this.nameKorean= new SimpleStringProperty(nameKorean);
		this.campus= new School(campus);
		this.gender= new SimpleStringProperty(gender);
		this.doB= new SimpleStringProperty(doB);
		this.isHonors=new SimpleBooleanProperty(isHonors);
		this.honors = isHonors ? new SimpleStringProperty("Yes") : new SimpleStringProperty("No");
		this.dorm= isLivingDorm ? new SimpleStringProperty("Yes") : new SimpleStringProperty("No");
		this.isLivingDorm=new SimpleBooleanProperty(isLivingDorm);
		this.id=new SimpleStringProperty(Data.generateId());
		this.campusName=new SimpleStringProperty(campus);
		
	}
	
	//update
		public Student(String studentId, int grade, String nameEnglish, String nameKorean, String campus, String gender, String doB, String enroll, boolean isHonors, boolean isLivingDorm) {
			this.grade= new SimpleIntegerProperty(grade);
			this.nameEnglish= new SimpleStringProperty(nameEnglish);
			this.nameKorean= new SimpleStringProperty(nameKorean);
			this.campus= new School(campus);
			this.gender= new SimpleStringProperty(gender);
			this.doB= new SimpleStringProperty(doB);
			this.isHonors=new SimpleBooleanProperty(isHonors);
			this.honors = isHonors ? new SimpleStringProperty("Yes") : new SimpleStringProperty("No");
			this.dorm= isLivingDorm ? new SimpleStringProperty("Yes") : new SimpleStringProperty("No");
			this.isLivingDorm=new SimpleBooleanProperty(isLivingDorm);
			this.id=new SimpleStringProperty(studentId);
			this.enrollmentDate=new SimpleStringProperty(enroll);
			this.campusName=new SimpleStringProperty(campus);
			
		}
	
	//output
	
	public Student(String id, int grade, String nameEnglish, String nameKorean, String campus, String isHonors, String isLivingDorm, String gender, String doB, int blessings, int tallies, String enrollmentDate, String subjects) {
		super();
		this.id = new SimpleStringProperty(id);
		this.grade = new SimpleIntegerProperty(grade);
		this.nameEnglish = new SimpleStringProperty(nameEnglish);
		this.nameKorean = new SimpleStringProperty(nameKorean);
		this.campus= new School(campus);
		this.isHonors = isHonors.equals("true") ? new SimpleBooleanProperty(true) : new SimpleBooleanProperty(false);
		this.honors = this.isHonors.get() ? new SimpleStringProperty("Yes") : new SimpleStringProperty("No");
		this.isLivingDorm= isLivingDorm.equals("true") ? new SimpleBooleanProperty(true) : new SimpleBooleanProperty(false);
		this.dorm = isLivingDorm.equals("true") ? new SimpleStringProperty("Yes") : new SimpleStringProperty("No");
		this.blessingTotal= new SimpleIntegerProperty(blessings);
		this.tallyTotal= new SimpleIntegerProperty(tallies);
		this.gender= new SimpleStringProperty(gender);
		this.doB= new SimpleStringProperty(doB);
		this.enrollmentDate= new SimpleStringProperty(enrollmentDate);
		this.subjectList= new SimpleStringProperty(subjects);
		this.campusName=new SimpleStringProperty(campus);
	}

	public Integer getGrade() {
		return this.grade.get();
	}

	public void setGrade(int grade) {
		this.grade.set(grade);
	}
	
	public IntegerProperty gradeProperty() {
		return this.grade;
	}


	public String getNameKorean() {
		return nameKorean.get();
	}

	public void setNameKorean(String nameKorean) {
		this.nameKorean.set(nameKorean);
	}
	
	public StringProperty nameKoreanProperty() {
		return nameKorean;
	}

	public String getNameEnglish() {
		return nameEnglish.get();
	}

	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish.set(nameEnglish);
	}
	
	public StringProperty nameEnglishProperty() {
		return nameEnglish;
	}


	public Boolean isHonors() {
		return isHonors.get();
	}

	public void setIsHonors(boolean isHonors) {
		this.isHonors.set(isHonors);
	}
	
	public BooleanProperty isHonorsProperty() {
		return isHonors;
	}
	
	public StringProperty honorsProperty() {
		return this.honors;
	}

	public Boolean isLivingDorm() {
		return isLivingDorm.get();
		
	}

	public void setIsLivingDorm(boolean isLivingDorm) {
		this.isLivingDorm.set(isLivingDorm);
	}
	
	public BooleanProperty isLivingDormProperty() {
		return isLivingDorm;
	}
		

	public String getDorm() {
		return dorm.get();
	}

	public void setDorm(String dorm) {
		this.dorm.set(dorm);;
	}
	
	public StringProperty dormProperty() {
		return this.dorm;
	}

	public String getId() {
		return this.id.get();
	}

	public void setId(String id) {
		this.id.set(id);
	}
	
	public StringProperty idProperty() {
		return this.id;
	}

	public School getCampus() {
		return campus;
	}

	public void setCampus(School campus) {
		this.campus = campus;
	}

	public String getGender() {
		return gender.get();
	}

	public void setGender(String gender) {
		this.gender.set(gender);
	}
	
	public StringProperty genderProperty() {
		return this.gender;
	}

	public String getDoB() {
		return doB.get();
	}

	public void setDoB(String doB) {
		this.doB.set(doB);
	}
	
	public StringProperty doBProperty() {
		return this.doB;
	}

	public String getHonors() {
		return honors.get();
	}

	public void setHonors(String honors) {
		this.honors.set(honors);
	}

	public Integer getBlessingTotal() {
		return blessingTotal.get();
	}

	public void setBlessingTotal(int blessingTotal) {
		this.blessingTotal.set(blessingTotal);
	}
	
	public IntegerProperty blessingTotalProperty() {
		return this.blessingTotal;
	}

	public Integer getTallyTotal() {
		return tallyTotal.get();
	}

	public void setTallyTotal(int tallyTotal) {
		this.tallyTotal.set(tallyTotal);
	}
	
	public IntegerProperty tallyTotalProperty() {
		return this.tallyTotal;
	}

	public String getSubjectList() {
		return subjectList.get();
	}

	public void setSubjectList(String subjectList) {
		this.subjectList.set(subjectList);
	}
	
	public StringProperty subjectListProperty() {
		return subjectList;
	}
	
	
	public String getEnrollmentDate() {
		return enrollmentDate.get();
	}

	public void setEnrollmentDate(String enrollmentDate) {
		this.enrollmentDate.set(enrollmentDate);
	}
	
	public StringProperty enrollmentDateProperty() {
		return enrollmentDate;
	}
	
	public String getCampusName() {
		return campusName.get();
	}

	public void setCampusName(String campusName) {
		this.campusName.set(campusName);
	}
	
	public StringProperty campusNameProperty() {
		return this.campusName;
	}
	
	
	public String toString() {
		return this.grade.get()+" "+this.nameEnglish.get()+" "+this.nameKorean.get()+" "+this.doB.get()+" "+this.gender.get()+" "+this.enrollmentDate.get()+" "+this.tallyTotal.get()+" "+this.blessingTotal.get()+" "+this.subjectList.get();
	}

	
	

}
