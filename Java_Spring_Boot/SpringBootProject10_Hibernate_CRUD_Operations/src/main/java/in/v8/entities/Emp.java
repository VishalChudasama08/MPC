package in.v8.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Emp {
	@Column
	@Id
	private long empno;
	
	@Column
	private String ename, job;
	@Column
	private Long mgr, sal, comm, deptno;
	@Column
	private Date hiredate;
	
	// Default constructor
	public Emp() {}
	
	public long getEmpno() {
		return empno;
	}
	public void setEmpno(long empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public long getMgr() {
		return mgr;
	}
	public void setMgr(long mgr) {
		this.mgr = mgr;
	}
	public long getSal() {
		return sal;
	}
	public void setSal(long sal) {
		this.sal = sal;
	}
	public long getComm() {
		return comm;
	}
	public void setComm(long comm) {
		this.comm = comm;
	}
	public long getDeptno() {
		return deptno;
	}
	public void setDeptno(long deptno) {
		this.deptno = deptno;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public void displayAll() {
		System.out.println("Employee Number: " + this.empno + "\tName: " + this.ename + "\tJob Rol: " + this.job + "   \tmrg: " + this.mgr + "\tHire Date: " + this.hiredate + "\tSalary: " + this.sal + "\tcomm: " + this.comm + "\tdeptno: " + this.deptno);
	}
}
