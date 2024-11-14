package in.v8.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.v8.main.entities.Student;
import in.v8.main.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public boolean addStudentDetails(Student std) {
		boolean status = false;
		try {
			studentRepository.save(std);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return status;
	}

	@Override
	public List<Student> getAllStudentsDitails() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentDetails(Long id) {
		Optional<Student> optional = studentRepository.findById(id); // findById return in Optional<list>
		if (optional.isPresent()) { // isPresent() method to check any value present in optional object if value present than return true  
			return optional.get(); // get() use method to get value
		}
		return null;
	}

	@Override
	public boolean updateStudentDetails(long id, float mark) {
		Student std = getStudentDetails(id);
		if (std != null) {
			std.setMarks(mark);
			studentRepository.save(std);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudentDetails(long id) {
		try {
			studentRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
