Approach Description:
OS1Assignment.java simulates memory address mapping for virtual memory management. It takes a sequence of virtual memory accesses as input, reads each address, translates it into the corresponding physical address based on a provided page table, and outputs the physical addresses in hexadecimal format.

To run the program:
Compile the program using:
javac OS1Assignment.java

Run the program using:
java OS1Assignment.java <input_filename>

Note: Replace <input_filename> with the name of the input sequence file containing virtual memory accesses. Ensure that the input file is properly formatted, with each virtual address stored as 8 bytes (unsigned long type).

After running the program, the output will be stored in a file named output-OS1, containing the hexadecimal representations of the translated physical addresses.
