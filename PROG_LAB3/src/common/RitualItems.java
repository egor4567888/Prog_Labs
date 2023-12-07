package common;

public enum RitualItems {
    BAROMETER("барометр"),
    RESURRECTION_ALTAR("алтарь воскрешения"),
    BOETHIAH_ALTAR("алтарь Боэтии"),
    VAERMINA_ALTAR("алтарь Вермины");

    private String ritual_item;
    RitualItems(String ritual_item){

        this.ritual_item = ritual_item;
    }
    @Override
    public String toString() {
        return ritual_item;
    }
}
