package fr.chose;


import fr.lernejo.tester.api.TestMethod;

public class StatsTestLernejoTests {

    @TestMethod
    public void testStats() {
        var s = Stats.of(1, 2, 3);

        if(s.min() != 1 || s.max() != 3 || s.avg() != 2)
            throw new RuntimeException("Invalid values!");
    }
}
