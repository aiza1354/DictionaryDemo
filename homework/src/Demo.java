import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        demonstrateHashmap();
    }

    public static void demonstrateHashmap() {
        System.out.println("Hashmap Demo");

        // Connecting the key with datatype string and integer
        // used for quick operations (instead of creating a class/custom data type with multople attributes)
        Map<String, Integer> studentScores = new HashMap<>();

        // put = append / add in an array
        studentScores.put("Alice", 95);
        studentScores.put("Bob", 2);
        studentScores.put("Charlie", 88);
        studentScores.put("Diana", 91);

        System.out.println("All scores" + studentScores);
        System.out.println("Alice's score: " + studentScores.get("Alice"));

        if (studentScores.containsKey("Bob")) {
            System.out.println("Bobs is in the class");

            // a key is always unique
            // if you put same key again it will pick up the latest value
            studentScores.put("Alice", 98);
            System.out.println("Alice's updates score: " + studentScores.get("Alice"));


            studentScores.remove("Charlie");
            System.out.println("After removing charlie: " + studentScores);

            System.out.println("\n Iterating through entries: ");

            // syntax just to memorise
            // Map.Entry is essential, followed by the data type of your Hashmap
            // Then type any variable
            // : then HashmapName.entrySet
            // To get the key and the value say entry.getKey and entry.getValue
            for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

            // iterating through keys
            System.out.println("\n Student names: ");
            for (String name : studentScores.keySet()) {
                System.out.println("- " + name);
            }

            // Iterating through values only
            System.out.println("\n Scores only ");
            for (Integer score : studentScores.values()) {
                System.out.println(" - " + score);
            }

            System.out.println("Number of students: " + studentScores.size());
            System.out.println("Is empty? " + studentScores.isEmpty());

        }
    }
}
