import common.Conditions;
import common.Devotions;
import entities.Hattifattener;
import common.RitualItems;
import common.Places;
public class Gathering {
    private Hattifattener[] hattifatteners;
    private RitualItems ritualItem;
    private Places place;
    Gathering(Hattifattener[] hattifatteners,RitualItems ritual_item,Places place){
        this.hattifatteners = hattifatteners;
        this.ritualItem = ritual_item;
        this.place = place;
    }
    private int[] getIndex(Devotions devotion){
        boolean someoneAlive = false;
        int [] ind = new int[2];
        for (int i = 0; i < 300; ++i)
        {
         if (hattifatteners[i].getDevotion() == devotion && (hattifatteners[i].getCondition() == Conditions.ALIVE || hattifatteners[i].getCondition() == Conditions.UNDEAD))
             someoneAlive = true;
        }
        if (!someoneAlive)
        {
            ind[0] = 0;
            ind[1] = 0;
            return ind;
        }
         ind[0] = (int)(Math.random() * (hattifatteners.length -1));
        while (hattifatteners[ind[0]].getDevotion() != devotion && (hattifatteners[ind[0]].getCondition() == Conditions.ALIVE || hattifatteners[ind[0]].getCondition() == Conditions.UNDEAD))
            ind[0] = (int)(Math.random() * (hattifatteners.length -1));
        ind[1] = (int)(Math.random() * (hattifatteners.length -1));
        while (ind[0] == ind[1])
            ind[1] = (int)(Math.random() * (hattifatteners.length -1));
        return ind;
    }
    public void ritual(){
        switch (this.ritualItem) {
            case BAROMETER ->{
                System.out.println("В " + this.place + " начался ритуал барометра");
                int ind[] = this.getIndex(Devotions.BAROMETER);
                int hat1 = ind[0];
                int hat2 = ind[1];
                if (hat1 == hat2)
                {
                    System.out.println("Нет достуаных последователей, ритуал не удался.");
                    break;
                }
                else
                {
                    switch (hattifatteners[hat2].getDevotion()){
                        case Devotions.BAROMETER -> {
                            hattifatteners[hat1].kneelHat(hattifatteners[hat2]);
                            hattifatteners[hat2].kneelHat(hattifatteners[hat1]);
                            hattifatteners[hat1].kneelRitItem(ritualItem);
                            hattifatteners[hat2].kneelRitItem(ritualItem);
                        }
                        case Devotions.LIGHT -> {
                            hattifatteners[hat1].kneelHat(hattifatteners[hat2]);
                            hattifatteners[hat2].kneelHat(hattifatteners[hat1]);
                            hattifatteners[hat1].kneelRitItem(ritualItem);
                        }
                        case Devotions.BOETHIAH -> {
                            hattifatteners[hat1].kneelHat(hattifatteners[hat2]);
                            hattifatteners[hat2].kneelHat(hattifatteners[hat1]);
                            hattifatteners[hat1].kneelRitItem(ritualItem);
                            hattifatteners[hat2].killHat(hattifatteners[hat1]);
                        }
                        default -> {
                            hattifatteners[hat1].kneelHat(hattifatteners[hat2]);
                            hattifatteners[hat2].scornfulGlanceHat(hattifatteners[hat1]);
                            hattifatteners[hat1].kneelRitItem(ritualItem);
                            hattifatteners[hat2].scornfulGlanceRitItem(ritualItem);
                        }
                    }
                }
            }
            case VAERMINA_ALTAR -> {
                System.out.println("В " + this.place + " начался ритуал Вермины");
                int ind[] = this.getIndex(Devotions.VAERMINA);
                int hat1 = ind[0];
                int hat2 = ind[1];
                if (hat1 == hat2)
                {
                    System.out.println("Нет достуаных последователей, ритуал не удался.");
                    break;
                }
                switch (hattifatteners[hat2].getCondition()) {
                    case ALIVE, UNDEAD ->  {
                        hattifatteners[hat1].killHat(hattifatteners[hat2]);
                        hattifatteners[hat1].eatHat(hattifatteners[hat2]);
                    }
                    case DEAD ->  hattifatteners[hat1].eatHat(hattifatteners[hat2]);
                    default -> System.out.println("У " + hattifatteners[hat1] + " не получилось провести ритуал Вермины с " + hattifatteners[hat2] + " потому что " + hattifatteners[hat2] + " " + hattifatteners[hat2].getCondition());
                }
            }
            case RESURRECTION_ALTAR -> {
                System.out.println("В " + this.place + " начался ритуал воскрешения");
                for (int i = 0; i < hattifatteners.length; i++) {
                    if (hattifatteners[i].getCondition() == Conditions.DEAD)
                        if (hattifatteners[i].getDevotion() == Devotions.LIGHT)
                            hattifatteners[i].setCondition(Conditions.ALIVE);
                        else hattifatteners[i].setCondition(Conditions.UNDEAD);
                }
            }
            case BOETHIAH_ALTAR -> {
                System.out.println("В " + this.place + " начался ритуал Боэтии");
                for (int i = 0; i < hattifatteners.length; i++) {
                    if (hattifatteners[i].getDevotion() == Devotions.BOETHIAH && (hattifatteners[i].getCondition() == Conditions.ALIVE || hattifatteners[i].getCondition() == Conditions.UNDEAD))
                        hattifatteners[i].killHat(hattifatteners[(int)(Math.random() * (hattifatteners.length -1))]);
                }
            }
        }

    }

}
