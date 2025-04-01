import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class RelabelerObject {
	
	private SimpleDateFormat SDF_FORMATTER_COMPLETE;
	private SimpleDateFormat SDF_FORMATTER_MONTH;
	private SimpleDateFormat SDF_FORMATTER_DAY;
	private SimpleDateFormat SDF_FORMATTER_YEAR;

	// Store multiple file Attributes
	private File FILE_REFERENCE;
	private String WRITE_OFF;
	
	// Specify the static naming prefix of the current file.
	private final String HOSPITAL_BUISNESS_FILE = "SOUTHERNCR_HB_CHARGE_";
	private final String PHYSICIAN_BUISNESS_FILE = "SOUTHERNCR_PB_DETAIL_";
	private final String HOSPITAL_PAYMENT_FILE = "SOUTHERNCR_HB_PMTADJ_";
	private final String PHYSICIAN_PAYMENT_FILE = "SOUTHERNCR_PB_PAY_ADJ_";
	private final String HOSPITAL_CODING_FILE = "SOUTHERNCR_HB_CODING_";
	private final String HOSPITAL_DETAIL_FILE = "SOUTHERNCR_HB_DETAIL_";
	private final String HOSPITAL_INFO_FILE = "SOUTHERNCR_HB_INS_INFO_";
	
	// Specify the Save Location of the newly renamed files.
	private final String FILE_SAVE_LOCATION = "S:\\STTAMNEW\\[DELETE]\\";

	// Specify the static segment of the file naming conventions
	private final String HOSPITAL_BUISNESS_RENAME = "STPH";
	private final String PHYSICIAN_BUISNESS_RENAME = "STPY";
	private final String HOSPITAL_PAYMENT_RENAME = "STHB";
	private final String PHYSICIAN_PAYMENT_RENAME = "STPB";
	
	// Specify basic file Extensions
	private final String TXT_FILE_EXTENSION = ".txt";
	
	public RelabelerObject() {
		// Empty Constructor to Initiallize Object
		setDateFormat();
	}
	
	public void setDateFormat() {
		this.SDF_FORMATTER_COMPLETE = new SimpleDateFormat("MM/dd/yyyy");
		this.SDF_FORMATTER_MONTH = new SimpleDateFormat("MM");
		this.SDF_FORMATTER_DAY = new SimpleDateFormat("dd");
		this.SDF_FORMATTER_YEAR = new SimpleDateFormat("yyyy");
	}
	
	public void setCurrentFile(File file) {
		this.FILE_REFERENCE = file;
	}

	public void setWriteOffDate() {

		String[] DATE_ARRAY = new String[3];

		if (this.FILE_REFERENCE.getName().startsWith(HOSPITAL_BUISNESS_FILE)) {
			
			System.out.println("Hospital Buisness File: " + this.FILE_REFERENCE.getName());
			
			DATE_ARRAY[0] = "" + Integer.parseInt(this.FILE_REFERENCE.getName().substring(21, 25));
			DATE_ARRAY[1] = "" + Integer.parseInt(this.FILE_REFERENCE.getName().substring(26, 28));
			DATE_ARRAY[2] = "" + Integer.parseInt(this.FILE_REFERENCE.getName().substring(29, 31));
			
			this.WRITE_OFF = DATE_ARRAY[1] + "/" + DATE_ARRAY[2] + "/" + DATE_ARRAY[0];
		}	
		else if (this.FILE_REFERENCE.getName().startsWith(PHYSICIAN_BUISNESS_FILE)) {

			System.out.println("Physician Buisness File: " + this.FILE_REFERENCE.getName());
			
			DATE_ARRAY[0] = "" + this.FILE_REFERENCE.getName().substring(22, 26);
			DATE_ARRAY[1] = "" + this.FILE_REFERENCE.getName().substring(27, 29);
			DATE_ARRAY[2] = "" + this.FILE_REFERENCE.getName().substring(30, 32);
			
			this.WRITE_OFF = DATE_ARRAY[1] + "/" + DATE_ARRAY[2] + "/" + DATE_ARRAY[0];
		}
		else if (this.FILE_REFERENCE.getName().startsWith(HOSPITAL_PAYMENT_FILE)) {

			System.out.println("Hospital Payment File: " + this.FILE_REFERENCE.getName());
			
			DATE_ARRAY[0] = "" + Integer.parseInt(this.FILE_REFERENCE.getName().substring(21, 25));
			DATE_ARRAY[1] = "" + Integer.parseInt(this.FILE_REFERENCE.getName().substring(26, 28));
			DATE_ARRAY[2] = "" + Integer.parseInt(this.FILE_REFERENCE.getName().substring(29, 31));
			
			this.WRITE_OFF = DATE_ARRAY[1] + "/" + DATE_ARRAY[2] + "/" + DATE_ARRAY[0];
		}
		else if (this.FILE_REFERENCE.getName().startsWith(PHYSICIAN_PAYMENT_FILE)) {

			System.out.println("Physician Payment File: " + this.FILE_REFERENCE.getName());
			
			DATE_ARRAY[0] = "" + Integer.parseInt(this.FILE_REFERENCE.getName().substring(22, 26));
			DATE_ARRAY[1] = "" + Integer.parseInt(this.FILE_REFERENCE.getName().substring(27, 29));
			DATE_ARRAY[2] = "" + Integer.parseInt(this.FILE_REFERENCE.getName().substring(30, 32));
			
			this.WRITE_OFF = DATE_ARRAY[1] + "/" + DATE_ARRAY[2] + "/" + DATE_ARRAY[0];
		}
		else if (this.FILE_REFERENCE.getName().startsWith(HOSPITAL_CODING_FILE)) {

			System.out.println("File: " +  this.FILE_REFERENCE.getName() + " added to Deletion Queue.");
		}
		else if (this.FILE_REFERENCE.getName().startsWith(HOSPITAL_DETAIL_FILE)) {

			System.out.println("File: " +  this.FILE_REFERENCE.getName() + " added to Deletion Queue.");
		}
		else if (this.FILE_REFERENCE.getName().startsWith(HOSPITAL_INFO_FILE)) {

			System.out.println("File: " +  this.FILE_REFERENCE.getName() + " added to Deletion Queue.");
		}
		else if (	this.FILE_REFERENCE.getName().startsWith(HOSPITAL_BUISNESS_RENAME) 		|| 
					this.FILE_REFERENCE.getName().startsWith(PHYSICIAN_BUISNESS_RENAME) 	||
				 	this.FILE_REFERENCE.getName().startsWith(HOSPITAL_PAYMENT_RENAME) 		|| 
					this.FILE_REFERENCE.getName().startsWith(PHYSICIAN_PAYMENT_RENAME))		 {

			// If the current file starts with any of the variable names above then
			// the current file is a previous output result from Mr. Merlin's program.
		}
		else {
			System.out.println("File '" + this.FILE_REFERENCE.getName() + " doesn't belong in this directory. Please remove it.");
		}
	}
	
	public void renameHospitalBuisnessFile() {
		String MONTH = this.FILE_REFERENCE.getName().substring(26,28);
		String DAY = this.FILE_REFERENCE.getName().substring(29,31);
		
		String RENAME_VARIABLE = HOSPITAL_BUISNESS_RENAME + MONTH + DAY + TXT_FILE_EXTENSION;
		String RENAME_ABSOLUTE_PATH = FILE_SAVE_LOCATION + RENAME_VARIABLE;

		File VARIABLE_FILE = new File(RENAME_ABSOLUTE_PATH);
		this.FILE_REFERENCE.renameTo(VARIABLE_FILE);
		
		System.out.println("renameHospitalBuisnessFile(): Variable File: " + VARIABLE_FILE.getAbsolutePath());
	}

	public void renamePhysicianBuisnessFile() {
		String MONTH = this.FILE_REFERENCE.getName().substring(26,28);
		String DAY = this.FILE_REFERENCE.getName().substring(29,31);
		
		String RENAME_VARIABLE = PHYSICIAN_BUISNESS_RENAME + MONTH + DAY + TXT_FILE_EXTENSION;
		String RENAME_ABSOLUTE_PATH = FILE_SAVE_LOCATION + RENAME_VARIABLE;

		File VARIABLE_FILE = new File(RENAME_ABSOLUTE_PATH);
		this.FILE_REFERENCE.renameTo(VARIABLE_FILE);
		
		System.out.println("renamePhysicianBuisnessFile(): Variable File: " + VARIABLE_FILE.getAbsolutePath());
	}

	public void renameHospitalPaymentFile() {
		String MONTH = this.FILE_REFERENCE.getName().substring(26,28);
		String DAY = this.FILE_REFERENCE.getName().substring(29,31);
		
		String RENAME_VARIABLE = HOSPITAL_PAYMENT_RENAME + MONTH + DAY + TXT_FILE_EXTENSION;
		String RENAME_ABSOLUTE_PATH = FILE_SAVE_LOCATION + RENAME_VARIABLE;

		File VARIABLE_FILE = new File(RENAME_ABSOLUTE_PATH);
		this.FILE_REFERENCE.renameTo(VARIABLE_FILE);
		
		System.out.println("renameHospitalPaymentFile(): Variable File: " + VARIABLE_FILE.getAbsolutePath());
	}

	public void renamePhysicianPaymentFile() {
		String MONTH = this.FILE_REFERENCE.getName().substring(27,29);
		String DAY = this.FILE_REFERENCE.getName().substring(30,32);
		
		String RENAME_VARIABLE = PHYSICIAN_PAYMENT_RENAME + MONTH + DAY + TXT_FILE_EXTENSION;
		String RENAME_ABSOLUTE_PATH = FILE_SAVE_LOCATION + RENAME_VARIABLE;

		File VARIABLE_FILE = new File(RENAME_ABSOLUTE_PATH);
		this.FILE_REFERENCE.renameTo(VARIABLE_FILE);
		
		System.out.println("renamePhysicianPaymentFile(): Variable File: " + VARIABLE_FILE.getAbsolutePath());
	}
	
	public String getWriteOffDate() {
		return this.WRITE_OFF;
	}

	public static void parseDate(String date) {
		/*try {
			return new SimpleDateFormat("MM/dd/yyyy").parse(date);
		} 
		catch (ParseException e) {
			return null;
		}*/
	 }

	public void deleteFile(File file) {
		if (file.delete()) { 
			System.out.println("Deleted the file: " + file.getName());
		} 
		else {
			System.out.println("Failed to delete file " + file.getName() + ". Please try again.");
		} 
	}
 }