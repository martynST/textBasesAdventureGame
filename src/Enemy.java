public class Enemy extends Character{
    private String encounterText;
    public Enemy(String name, int[] stats, String encounterText)
    {
        super(name, stats);
        this.encounterText = encounterText;
    }

    public String getEncounterText() {
        return encounterText;
    }
}
