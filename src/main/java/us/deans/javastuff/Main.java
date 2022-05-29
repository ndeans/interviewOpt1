package us.deans.javastuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/main/resources/datafile1.csv");
        List<Person> plist = new ArrayList<>();
        Scanner scan;

        scan = new Scanner(file);
        scan.nextLine();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");           // todo - find a better pattern for RegEx
            plist.add(new Person(Integer.parseInt(tokens[1]),tokens[0], tokens[2]));
        }

        int combinedAge = 0;
        for (Person person: plist) {
            System.out.println("..." + person.getName() + ", " + person.getAge() + ", " + person.getState());
            combinedAge += person.getAge();
        }

        System.out.println();
        System.out.println("Average Age = " + combinedAge/plist.size());

    }

}
