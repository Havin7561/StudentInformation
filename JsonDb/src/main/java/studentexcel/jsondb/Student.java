package studentexcel.jsondb;

public class Student {
	
	String name;
	double admissionNo;
	double physics;
	double chemistry;
	double maths;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(double admissionNo) {
		this.admissionNo = admissionNo;
	}
	public double getPhysics() {
		return physics;
	}
	public void setPhysics(double physics) {
		this.physics = physics;
	}
	public double getChemistry() {
		return chemistry;
	}
	public void setChemistry(double chemistry) {
		this.chemistry = chemistry;
	}
	public double getMaths() {
		return maths;
	}
	public void setMaths(double maths) {
		this.maths = maths;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", admissionNo=" + admissionNo + ", physics=" + physics + ", chemistry="
				+ chemistry + ", maths=" + maths + "]";
	}
	
	

}
