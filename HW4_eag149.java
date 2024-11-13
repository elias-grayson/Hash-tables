package Assignment4;
import java.util.Arrays;

/* Elias Grayson */
/* This class represents a hash table */
public class HW4_eag149 {
     
    private String[] hashTable; // The hash table
    int size; // Controls the size of the hash table
    int key = 0; // Controls individual elements in the hash table

    // Constructor initializes a hash table with a specified size
    public HW4_eag149(int size) {
        this.size = size; // Initializes size
        this.hashTable = new String[size]; // Initializes table
        Arrays.fill(hashTable, null); // Makes every emptyslot null
    }

    // Inserts given key into hash table using linear probing for resolving collisions
    public void linearProbingInsert(int key) {
        int i = key % this.size; // Hash function
            
            // Keeps going while next slot is occupied 
            while (hashTable[i] != (null)) {

                // Loops back to beginning if end of table is reached
                if (i == hashTable.length - 1) {
                    i = 0;
                }
                i++;
            }
            hashTable[i] = Integer.toString(key);
            printTable(); // Show table in terminal
        }

    // Inserts given key into hash table using double hashing for resolving collisions
    public void doubleHashingInsert(int key, int prime) {
        int h1 = key % this.size; // First hash function
        int h2 = prime - (key % prime); // Second hash function
        int i = h1; // Index for the table
            
        // Keeps going while next slot is occupied 
        while (hashTable[i] != (null)) {

            i += h2; // Count up by second hash function

            // Loops back to beginning if end of table is reached
            if (i >= hashTable.length - 1) {
                i %= this.size;
            }
        }
        hashTable[i] = Integer.toString(key);
        printTable(); // Show table in terminal
    }

    // Prints the table 
    void printTable() {
        System.out.println(Arrays.toString(hashTable));
        }

        // Test method
        public static void main(String[] args) {
        HW4_eag149 hash1 = new HW4_eag149(10); // Linear probing test instaniation
        HW4_eag149 hash2 = new HW4_eag149(10); // Double hashing test instantiation

        // Testing 10, 3, 17, 14, 18, 3, 8, 1, 18, 11
        hash1.linearProbingInsert(10);
        hash1.linearProbingInsert(3);
        hash1.linearProbingInsert(17);
        hash1.linearProbingInsert(14);       
        hash1.linearProbingInsert(18);
        hash1.linearProbingInsert(3);
        hash1.linearProbingInsert(8);
        hash1.linearProbingInsert(1);
        hash1.linearProbingInsert(18);
        hash1.linearProbingInsert(11);

        // Testing 7, 17, 27, 37, 47, 57, 67, 77, 87, 97 with prime = 7
        hash2.doubleHashingInsert(7, 7);
        hash2.doubleHashingInsert(17, 7);
        hash2.doubleHashingInsert(27, 7);
        hash2.doubleHashingInsert(37, 7);
        hash2.doubleHashingInsert(47, 7);
        hash2.doubleHashingInsert(57, 7);
        hash2.doubleHashingInsert(67, 7);
        hash2.doubleHashingInsert(77, 7);
        hash2.doubleHashingInsert(87, 7);
        hash2.doubleHashingInsert(97, 7);
        
    }

}
