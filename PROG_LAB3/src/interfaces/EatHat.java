package interfaces;

import common.Conditions;
import entities.Hattifattener;

public interface EatHat {
    default public void eatHat(Hattifattener hattifattener){
        if (hattifattener.getCondition() == Conditions.DEAD){
            System.out.println(this + " съел " + hattifattener);
            hattifattener.setCondition(Conditions.EATEN);
        }
        else
            System.out.println("У " + this + " не получилось съесть " + hattifattener + " потому что " + hattifattener + " " + hattifattener.getCondition());
    }
}
