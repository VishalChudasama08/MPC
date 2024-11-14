package in.v8.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.v8.main.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{ 
	// inherit JpaRepository and provide class (as @Table) and it's ID (@ID) type 
	// A custom repository interface (StudentRepository in this case) in Spring Data JPA allows us to 
	// define additional query methods or business logic beyond the standard CRUD operations.
	// It extends "JpaRepository" and provides a way to implement complex or specialized database operations.
	// here (move cursor in StudentRepository interface block) press ctrl + space than you see all CRUD operations methods. (this is IDE feature)
	
}
