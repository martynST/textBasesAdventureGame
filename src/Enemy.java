public class Enemy extends Character{
    private String encounterText;
    public Enemy(String name, int[] stats, int ac, String encounterText)
    {
        super(name, stats, ac);
        this.encounterText = encounterText;
    }

    public String getEncounterText() {
        return encounterText;
    }
}
