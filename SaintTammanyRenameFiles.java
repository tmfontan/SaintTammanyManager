import java.io.File;

public class SaintTammanyRenameFiles {

    public static void main(String[] args) {
		
        // Specify the directory to search in
        File directory = new File("S:\\STTAMNEW\\[DELETE]");

        // Specify the phrase you are looking for
		String HOSPITAL_BUISNESS_FILE = "SOUTHERNCR_HB_CHARGE_";
		String PHYSICIAN_BUISNESS_FILE = "SOUTHERNCR_PB_DETAIL_";
		String HOSPITAL_PAYMENT_FILE = "SOUTHERNCR_HB_PMTADJ_";
		String PHYSICIAN_PAYMENT_FILE = "SOUTHERNCR_PB_PAY_ADJ_";
		String HOSPITAL_CODING_FILE = "SOUTHERNCR_HB_CODING_";
		String HOSPITAL_DETAIL_FILE = "SOUTHERNCR_HB_DETAIL_";
		String HOSPITAL_INFO_FILE = "SOUTHERNCR_HB_INS_INFO_";
		
		// Create new custom object
		RelabelerObject RELABELER = new RelabelerObject();

        // Check if the directory exists and is a directory
        if (directory.exists() && directory.isDirectory()) {
            // Get all files in the directory
            File[] files = directory.listFiles();

            // Check if files are found in the directory
            if (files != null) {
                // Loop through each file in the directory
                for (File file : files) {
                	
                	//System.out.println("Current File Name: " + file.getName());
					RELABELER.setCurrentFile(file);

                    // Check if the file name contains the search phrase
                    if (file.getName().startsWith(HOSPITAL_BUISNESS_FILE)) {
                    	//System.out.println("St Tammany Rename Files: A");
						RELABELER.setWriteOffDate();
						RELABELER.renameHospitalBuisnessFile();
						//System.out.println(RELABELER.getWriteOffDate());
                    }
					else if (file.getName().startsWith(PHYSICIAN_BUISNESS_FILE)) {
						//System.out.println("St Tammany Rename Files: B");
						RELABELER.setWriteOffDate();
						RELABELER.renamePhysicianBuisnessFile();
						//System.out.println(RELABELER.getWriteOffDate());
					}
					else if (file.getName().startsWith(HOSPITAL_PAYMENT_FILE)) {
						//System.out.println("St Tammany Rename Files: C");
						RELABELER.setWriteOffDate();
						RELABELER.renameHospitalPaymentFile();
						//System.out.println(RELABELER.getWriteOffDate());
					}
					else if (file.getName().startsWith(PHYSICIAN_PAYMENT_FILE)) {
						//System.out.println("St Tammany Rename Files: D");
						RELABELER.setWriteOffDate();
						RELABELER.renamePhysicianPaymentFile();
						//System.out.println(RELABELER.getWriteOffDate());
					}
					else if (file.getName().startsWith(HOSPITAL_CODING_FILE) || file.getName().startsWith(HOSPITAL_DETAIL_FILE) || file.getName().startsWith(HOSPITAL_INFO_FILE)) {
						//System.out.println("St Tammany Rename Files: E");
						RELABELER.deleteFile(file);
					}
					else {
						System.out.println("File " + file.getName() + " was created . Please remove it from the '\\STTAMNEW'");
					}
                }
            }
        } else {
            System.out.println("The directory does not exist or is not a directory.");
        }
    }
}