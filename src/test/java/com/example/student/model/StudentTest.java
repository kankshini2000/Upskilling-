package com.example.student.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void test() {
	
		 Student std = new Student();
	        std.setId("11");
	        std.setName("Megha");
	        std.setAge(20);
	        std.setSalary(3333.0);

	        assertEquals("11", std.getId());
	        assertEquals("Megha", std.getName());
	        assertEquals(20, std.getAge());
	        assertEquals(3333.0, std.getSalary());

	        assertEquals("Student [id=11, name=Megha, age=20, salary=3333.0]", std.toString());

	        Student std2 = new Student("22", "Alice", 25, 4000.0);
	        assertNotNull(std2);
	        assertEquals("22", std2.getId());
	        assertEquals("Alice", std2.getName());
	        assertEquals(25, std2.getAge());
	        assertEquals(4000.0, std2.getSalary());

}
}
