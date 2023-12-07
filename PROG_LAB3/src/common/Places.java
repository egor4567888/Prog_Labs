package common;

public enum Places {
    LAWN_MIDDLE_OF_ISLAND("лужайкa в середине острова");
    String place;
    Places(String place){
        this.place = place;
    }
    @Override
    public String toString() {
        return place;
    }
}
