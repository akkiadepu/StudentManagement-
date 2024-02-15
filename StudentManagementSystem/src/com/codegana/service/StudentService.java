package com.codegana.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.codegana.beans.Student;
import com.codegnan.dao.StudentDao;
import com.codegnan.exception.DatabaseInternalException;
import com.codegnan.exception.InvalidStudentIdException;

public class StudentService {
	Logger logger =Logger.getLogger(StudentService.class);
	public Student FindStudentbyId(int id) throws ClassNotFoundException, SQLException, InvalidStudentIdException, DatabaseInternalException {
		logger.debug("Finding studet by ID"+id);
		StudentDao studentDao=new StudentDao();
		Student student= studentDao.findById(id);
		logger.debug("returning the student");
		return student;

	}
	
	
	public List<Student> FindAllStudents() throws ClassNotFoundException, SQLException, DatabaseInternalException{
		logger.debug("Finding all the students");
		StudentDao studentDao=new StudentDao();
		List<Student> student= studentDao.findAll();
		logger.debug("sending the student list"+student.size());
		return student;		
	}
	
	public boolean saveStudent(Student student) throws DatabaseInternalException, ClassNotFoundException, SQLException {
		logger.debug("saveing the new student"+student);
		StudentDao studentDao=new StudentDao();
		if(studentDao.save(student)) {
			studentDao.commit();
			logger.debug("commiting the student"+student.getId());
			return true;
		}
		else {
			logger.debug("can not save the student"+student.getId());
			studentDao.rollback();
			return false;
		}
		
	}
	public boolean editStudent(Student student) throws ClassNotFoundException, SQLException, DatabaseInternalException {
		
		logger.debug("edit the stduent"+student);
		StudentDao studentDao=new StudentDao();
		if(studentDao.edit(student)) {
			studentDao.commit();
			logger.debug("student  edited sucessfully"+student.getId());
			return true;
		}
		else {
			logger.debug("can not edit the student"+student.getId());
			studentDao.rollback();
			return false;
		}
	}
	public boolean deleteStudent(int id) throws DatabaseInternalException, SQLException, ClassNotFoundException {
		logger.debug("delecting  the stduent with id :"+id);
		StudentDao studentDao=new StudentDao();
		if(studentDao.delete(id)) {
			
			studentDao.commit();
			logger.debug("student deleted sucessfully"+id);
			return true;
		}
		else {
			studentDao.rollback();
			logger.debug("can not delete student"+id);
			return false;
		}
	}
	

}
