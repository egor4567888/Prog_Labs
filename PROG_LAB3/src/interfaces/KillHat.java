package interfaces;

import common.Conditions;
import entities.Hattifattener;

public interface KillHat {
    default     public void killHat(Hattifattener hattifattener){
        if (this.getCondition() == Conditions.ALIVE || this.getCondition() == Conditions.UNDEAD) {
            System.out.println(this + " убил " + hattifattener);
            hattifattener.setCondition(Conditions.DEAD);
        }
        else
            System.out.println("У " + this + " не получилось убить " + hattifattener + " потому что " + hattifattener + " " + hattifattener.getCondition());
    }
    public Conditions getCondition();
}
