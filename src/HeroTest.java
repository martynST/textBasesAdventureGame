import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void testCreate()
    {
        String name = "jim";
        int[] stats = {16,5,14,1,20};
        Hero hero = new Hero(name,stats, 13);
        int[] statMod = hero.getStatModifiers();
        assertEquals( "Name: " + "jim" + "\nIntelligence: " + "16" + " (" + "3" + ")\nDexterity: " + "5" + " (" + "-3" + ")\nConstitution: " + "14" + " (" + "2" + ")\nPerception: " + "1" + " (" + "-5" + ")\nStrength: " + "20" + " (" + "5" + ")", hero.getStats());
    }

}