package entities;

import common.Conditions;

abstract class Entity {
    final private String name;
    private Conditions condition = Conditions.ALIVE;

    public Entity(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
    public void setCondition(Conditions condition){
        this.condition = condition;
        System.out.println(this + " теперь " + this.condition);
    }
    public Conditions getCondition(){
        return condition;
    }
}
