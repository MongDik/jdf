package com.mong.jdf.admin.dao;

import java.util.List;

import com.mong.jdf.admin.model.Student;

public interface StudentMapper {

	public Student getStudent(String studentID);  
    
    public Student getStudentAndClass(String studentID);  
      
    public List<Student> getStudentAll();  
      
    public void insertStudent(Student entity);  
      
    public void deleteStudent(Student entity);  
      
    public void updateStudent(Student entity);  
}
