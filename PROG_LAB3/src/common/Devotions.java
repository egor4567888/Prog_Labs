package common;

public enum Devotions {
    BAROMETER("барометр"),
    VAERMINA("Вермина"),
    LIGHT("свет"),
    BOETHIAH("Боэтия");

    private String devotion;
    Devotions(String devotion){
        this.devotion = devotion;
    }
    @Override
    public String toString() {
        return devotion;
    }
}
