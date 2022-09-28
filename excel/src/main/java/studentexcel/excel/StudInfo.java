package studentexcel.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager; 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class StudInfo {
	
	private static Logger logger = LogManager.getLogger(StudInfo.class);
	
static ArrayList<StudentDetails> studentList= new ArrayList<>();
	
	public static void main(String[]args) throws IOException {
		
		
		XSSFWorkbook workbook = null;
		File fil = new File("Students.xlsx");
		
			
            // Reading file from local directory
            
            
		try (FileInputStream file=  new FileInputStream(fil );){
  
            // Create Workbook instance holding reference to.xlsx file
            workbook = new XSSFWorkbook(file);
  
            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            
            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            
            while (rowIterator.hasNext()) {
            	
            	
                Row row = rowIterator.next();
              
                // For each row, iterate through all the columns
                 
                Iterator<Cell> cellIterator = row.cellIterator();
                
                StudentDetails std = new StudentDetails();
                
                while (cellIterator.hasNext()) {
  
                    Cell nextcell = cellIterator.next();
                
                    int columnIndex = nextcell.getColumnIndex();
                    
                    switch (columnIndex) {
  
                    case 0:
                        
                            
                        std.setName(nextcell.getStringCellValue());
                        break;
                        
                    case 1:
                        
                            
                        std.setAdmissionNo((int)nextcell.getNumericCellValue());
                        break;
                        
                    case 2:
                       
                       
                      std.setPhysics((int)nextcell.getNumericCellValue());
                      break;
                        
                    case 3:
                        
                            
                        std.setChemistry((int)nextcell.getNumericCellValue());
                        
                        break;
                        
                    case 4:
                        
                        std.setMaths((int)nextcell.getNumericCellValue());
                        
                      break;
                      default:
                    	  break;
                   
                    }
                    
                }
                std.setResult(std.getPhysics(),std.getChemistry(),std.getMaths());
                studentList.add(std) ;
  
                
            }
            
            
        
		}catch (Exception e){logger.info(e); }
		finally {
        	
        	if (workbook != null) {
                workbook.close();
            }
        }
  
       
		name();
    }
	public static void name() {
		Scanner nm = new Scanner(System.in);
		
		logger.info("Enter Name :" );
		String name = nm.nextLine();
		
        for (StudentDetails st : studentList) {       	
         if(st.getName().equals(name) ) {
        	 logger.info("Name:{}" ,name);
        	 printStudentDetails(st);
         }
         
        }
		nm.close();
        
}
	private static void printStudentDetails(StudentDetails st) {
		logger.info("AdmissionNO ={} ",st.getAdmissionNo() );
		logger.info("Percentage ={}" ,st.getPercentage() );
		logger.info("Physics " );
		logger.info("PhysicsMark ={}" , st.getPhysics() );
		logger.info("Grade ={}" ,st.getPhysicsGrade() );
		logger.info("Gradepoint ={}" ,st.getPhysicsGradepoint() );
		logger.info("Chemistry " );
		logger.info("ChemistryMark ={}" , st.getChemistry() );
		logger.info("Grade ={}" ,st.getChemistryGrade() );
		logger.info("Gradepoint ={}" ,st.getChemistryGradepoint() );
		logger.info("Maths " );
		logger.info("MathsMark ={}" , st.getMaths() );
		logger.info("Grade ={}" ,st.getMathsGrade() );
		logger.info("Gradepoint ={}" ,st.getMathsGradepoint() );
        
        }
	

}
