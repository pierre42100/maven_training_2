package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;

import static fr.lernejo.tester.internal.TestClassDescriptionLernejoTests.assertEq;
import static fr.lernejo.tester.internal.TestClassDescriptionLernejoTests.assertTrue;

public class TestClassDiscovererLernejoTests {
    @TestMethod
    public void testCount() {
        var set = new TestClassDiscoverer("fr.lernejo.tester").listTestClasses();

        assertEq(set.size(), 3);
        assertTrue(set.contains(new TestClassDescription(TestClassDiscovererLernejoTests.class)));
        assertTrue(set.contains(new TestClassDescription(TestClassDiscovererLernejoTests.class)));
        assertTrue(set.contains(new TestClassDescription(SomeLernejoTests.class)));

    }
}
