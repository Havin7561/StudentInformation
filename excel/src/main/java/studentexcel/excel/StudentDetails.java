package studentexcel.excel;

public class StudentDetails {
	String name;
	String physicsGrade;
	String chemistryGrade;
	String mathsGrade;
	String physicsGradepoint;
	String chemistryGradepoint;
	String mathsGradepoint;
     
	
	double admissionNo;
	double percentage;
	double physics;
	double chemistry;
	double maths;
	double totalmark;
	
   
    
	

	public String getName() {
		return name;
	}



	public void setName(String newname) {
		name = newname;
	}



	public double getAdmissionNo() {
		return admissionNo;
	}



	public void setAdmissionNo(double newadmissionNo) {
		admissionNo = newadmissionNo;
	}



	public double getPhysics() {
		return physics;
	}
	public String getPhysicsGrade() {
		return physicsGrade;
	}
	public String getPhysicsGradepoint() {
		return physicsGradepoint;
	}
	public void setPhysics(double newphysics) {
		physics = newphysics;
	}
	


	public double getChemistry() {
		return chemistry;
	}
	public String getChemistryGrade() {
		return chemistryGrade;
	}
	public String getChemistryGradepoint() {
		return chemistryGradepoint;
	}
	public void setChemistry(double newchemistry) {
		chemistry = newchemistry;
	}



	public double getMaths() {
		return maths;
	}
	public String getMathsGrade() {
		return mathsGrade;
	}
	public String getMathsGradepoint() {
		return mathsGradepoint;
	}
	public void setMaths(double newmaths) {
		maths = newmaths;
	}



	public double getTotalmark() {
		return totalmark;
	}


	public double getPercentage() {
		return percentage;
	}
	
	public void setResult(double mPhysics, double mChemistry, double mMaths) {
		physicsGrade = findGrade(mPhysics);
		chemistryGrade = findGrade(mChemistry);
		mathsGrade = findGrade(mMaths);
		
		physicsGradepoint = findGradepoint(mPhysics);
		chemistryGradepoint = findGradepoint(mChemistry);
		mathsGradepoint = findGradepoint(mMaths);
		
		totalmark = (mPhysics + mChemistry + mMaths);
		percentage = (totalmark/3);
	}



	public String findGradepoint(double mark) {
		if(mark > 91 && mark <= 100)
			return "10.0" ;
		if(mark > 81 && mark <= 90)
			return "9.0" ;
		if(mark > 71 && mark <= 80)
			return "8.0" ;
		if(mark > 61 && mark <= 70)
			return "7.0" ;
		if(mark > 51 && mark <= 60)
			return "6.0" ;
		if(mark > 41 && mark <= 50)
			return "5.0" ;
		if(mark > 33 && mark <= 40)
			return "4.0" ;
		else 
			return "c" ;
		
	}



	public String findGrade(double mark) {
		if(mark > 91 && mark <= 100)
			return "A1";
		if(mark > 81 && mark <= 90)
			return "A2" ;
		if(mark > 71 && mark <= 80)
			return "B1" ;
		if(mark > 61 && mark <= 70)
			return "B2" ;
		if(mark > 51 && mark <= 60)
			return "C1" ;
		if(mark > 41 && mark <= 50)
			return "C2" ;
		if(mark > 33 && mark <= 40)
			return "D" ;
		else 
			return "E1" ;
		
	}
	
	}

