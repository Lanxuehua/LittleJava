/**
 * File Merger
 * Read from a lists of file location, and merge all the csv file into 1 file
 * @author xuehua
 * @version SE-17
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
    public static void main(String[] args) {
    	
        // File containing the list of CSV file locations
        String fileList = "file_list.txt";

        // Output file to append all the CSV data
        String output = "file_merged.csv"; // Replace with the path for the merged output file

        List<String> csvFileLocations = new ArrayList<>();

        try {
            // Read the list of CSV file
            BufferedReader fileReader = new BufferedReader(new FileReader(fileList));
            String line;
            while ((line = fileReader.readLine()) != null) {
                csvFileLocations.add(line);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            // Append each CSV file
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(output));
            for (String csvFileLocation : csvFileLocations) {
                BufferedReader csvReader = new BufferedReader(new FileReader(csvFileLocation));
                String csvLine;
                while ((csvLine = csvReader.readLine()) != null) {
                    outputWriter.write(csvLine);
                    outputWriter.write(csvFileLocation);
                    outputWriter.newLine();
                }
                csvReader.close();
            }
            
            outputWriter.close();
            System.out.println("CSV File append completed.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
