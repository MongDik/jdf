package com.mong.jdf.admin.model;

import java.io.Serializable;
import java.util.Date;

public class StudentEntity implements Serializable {

	private static final long serialVersionUID = 3096154202413606831L;
	private String classId;
	private Date studentBirthday;
	private String studentID;
	private String studentName;
	private String studentSex;

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public Date getStudentBirthday() {
		return studentBirthday;
	}

	public void setStudentBirthday(Date studentBirthday) {
		this.studentBirthday = studentBirthday;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

}
