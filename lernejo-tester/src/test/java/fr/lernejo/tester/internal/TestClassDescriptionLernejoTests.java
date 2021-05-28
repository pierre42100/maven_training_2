package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;

public class TestClassDescriptionLernejoTests {
    private static void assertEq(int expect, int got) {
        if (expect != got)
            throw new RuntimeException("Assertion failed, expected " + expect + ", got " + got + "!");
    }

    private static void myAssert(boolean test) {
        if (!test)
            throw new RuntimeException("Assertion failed!");
    }

    public static void test() {
        try {
            var list = new TestClassDescription(SomeLernejoTests.class).listTestMethods();

            assertEq(2, list.size());

            myAssert(list.contains(SomeLernejoTests.class.getMethod("ok")));
            myAssert(list.contains(SomeLernejoTests.class.getMethod("ko")));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            myAssert(false);
        }
    }

    public static void main(String[] args) {
        test();
    }
}
