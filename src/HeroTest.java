import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void testCreate()
    {
        String name = "jim";
        int[] stats = {10,5,5,5,5};
        Hero hero = new Hero(name,stats, 13);
        assertEquals("Name: " + name + "\nInteligence: " + stats[0] + "\nDexterity: " + stats[1] + "\nConstitution: " + stats[2] + "\nPerception: " + stats[3] + "\nStrength: " + stats[4], hero.getStats());
    }

}