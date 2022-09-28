package studentexcel.jsondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



public class ReadDb {
	
private static Logger logger = LogManager.getLogger(ReadDb .class);
private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[]args) throws SQLException {
		
	
		logger.info("1.Search for Student by Name");
		logger.info("2.Search for Student by Admission No");
		logger.info("Enter 1 or 2:");
		int choice = Integer.parseInt(sc.nextLine());
		
		switch(choice) {
		
		case 1:
			logger.info("By Name");
			name();
			break;
		case 2:
			logger.info("By AdmissionNo");
			admissionNo();
			break;
			default:
				break;
		}
	}
	private static Connection connection() throws SQLException {
		String password = System.getProperty("database.password");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root",password);
		
	}
	
	
	private static void name() throws SQLException {
		logger.info("Enter Name:");
		String c = sc.nextLine();
		String sql = "select * from student where name='"+c+"' " ;  
	    selectRecord(sql);
	}
	private static void admissionNo() throws SQLException {
		logger.info("Enter AdmissionNo:");
		int d = sc.nextInt();
		String sql = "select * from student where admissionno= "+d;
		selectRecord(sql);
	}
	public static void selectRecord(String query)throws SQLException {
		
		
		try(Connection con=connection();
		Statement stmt = con.createStatement();){
		ResultSet rs = stmt.executeQuery(query);
		
		Gson gson = new GsonBuilder().create();
		List<Student> details = new ArrayList<>();
		while(rs.next()){
			
			
			Student student=new Student();
			student.setName( rs.getString("name"));	
			student.setAdmissionNo(rs.getDouble("admissionno"));    
			student.setMaths(rs.getDouble("maths"));
			student.setChemistry(rs.getDouble("chemistry"));
			student.setPhysics(rs.getDouble("Physics"));
			details.add(student);
		
		}
		
        String jg = gson.toJson(details);
        logger.info(jg);
		
		}
	}

}
