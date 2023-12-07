import common.Phrases;
import entities.Hattifattener;
import common.Devotions;
import common.Places;
import common.RitualItems;
import entities.Hemulen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "/home/egor/IdeaProjects/PROG_LAB3.1/src/HattifattenerNames";

        Hattifattener[] hattifatteners = new Hattifattener[300];
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null && index < 75) {
                hattifatteners[index] = new Hattifattener(line,Devotions.BAROMETER);
                index++;
            }
            while ((line = reader.readLine()) != null && index < 150) {
                hattifatteners[index] = new Hattifattener(line,Devotions.BOETHIAH);
                index++;
            }
            while ((line = reader.readLine()) != null && index < 225) {
                hattifatteners[index] = new Hattifattener(line,Devotions.VAERMINA);
                index++;
            }
            while ((line = reader.readLine()) != null && index < 300) {
                hattifatteners[index] = new Hattifattener(line,Devotions.LIGHT);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0;i<300;i++)
            if (hattifatteners[i] == null)
                System.out.println(i);
        Gathering gathering1 = new Gathering(hattifatteners, RitualItems.VAERMINA_ALTAR, Places.LAWN_MIDDLE_OF_ISLAND);
        gathering1.ritual();
        Hemulen hemulen = new Hemulen("Хемуль", Phrases.NUMBER_TWO_HUNDREED_NINTEEN_IN_MY_HERBARIUM);
        hemulen.collectFlowers(7);
        hemulen.countPetals();
    }
}