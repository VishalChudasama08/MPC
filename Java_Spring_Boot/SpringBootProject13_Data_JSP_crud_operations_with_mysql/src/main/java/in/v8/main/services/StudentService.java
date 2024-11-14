package in.v8.main.services;

import java.util.List;

import in.v8.main.entities.Student;

public interface StudentService {
	public boolean addStudentDetails(Student std);
	public List<Student> getAllStudentsDitails();
	public Student getStudentDetails(Long id);
	public boolean updateStudentDetails(long id, float mark);
	public boolean deleteStudentDetails(long id);
}
