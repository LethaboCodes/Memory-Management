import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OS1Assignment {
    // Page table mapping virtual page numbers to physical frame numbers
    private static final int[] PAGE_TABLE = {2, 4, 1, 7, 3, 5, 6};

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java OS1Assignment.java <input_filename>");
            return;
        }
        
        String inputFilename = args[0];
        String outputFilename = "output-OS1";
        
        try (FileInputStream inputFile = new FileInputStream(inputFilename);
             FileOutputStream outputFile = new FileOutputStream(outputFilename)) {
            
            byte[] buffer = new byte[8]; 
            StringBuilder outputContent = new StringBuilder(); // StringBuilder holds output
            
            // Read virtual addresses from input file
            while((inputFile.read(buffer)) != -1){
                long virtualAddress = byteToLong(buffer); // Convert bytes to long
                long physicalAddress = translateVirtualAddress(virtualAddress); // Translate virtual address
                String hexString = String.format("0x%01X\n", physicalAddress); // Convert to hexadecimal string
                outputContent.append(hexString); // Append to output content
            }
            
            // Write output content to output file
            outputFile.write(outputContent.toString().getBytes());
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to convert byte array to long
    private static long byteToLong(byte[] bytes){
        long value = 0;
        for(int i = 0; i < bytes.length; i++){
            value |= (bytes[i] & 0xFFL) << (8*i); // Bitwise OR operation to set bits
        }
        return value;
    }

    // Method to translate virtual address to physical address
    private static long translateVirtualAddress(long virtualAddress){
        long pageNumber = virtualAddress / 128; 
        long pageOffset = virtualAddress % 128; 
        long frameNumber = PAGE_TABLE[(int) pageNumber]; 
        return (frameNumber * 128) + pageOffset; // Calculate physical address
    }

}
