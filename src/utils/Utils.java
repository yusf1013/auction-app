package utils;

import java.util.Random;

public class Utils {
    Random random = new Random();

    public String getRandomString() {
        final String[] proper_noun = {"Apple", "Boxes", "Armor", "Sword"};
        int index1 = random.nextInt(proper_noun.length);

        final String[] adjective = {"Red", "Orange", "Medieval", "Very Rare"};
        int index2 = random.nextInt(adjective.length);

        return (adjective[index2] + " " + proper_noun[index1] );
    }

    public String getRandomFirstName() {
        Random random = new Random();
        final String[] name = {"Ethan", "Chris", "Leon", "Carlos"};
        int index = random.nextInt(name.length);

        return name[index];
    }

    public String getRandomLastName() {
        Random random = new Random();
        final String[] name = {"Winters", "Redfield", "S. Kennedy", "Oliveira"};
        int index = random.nextInt(name.length);

        return name[index];
    }
}
