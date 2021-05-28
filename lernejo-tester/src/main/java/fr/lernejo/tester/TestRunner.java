package fr.lernejo.tester;

import fr.lernejo.tester.internal.TestClassDiscoverer;

import java.lang.reflect.Method;
import java.time.Instant;

public class TestRunner {
    public static void main(String[] args) {
        int numberTests = 0;
        int numberFails = 0;
        Instant begin = Instant.now();

        for (String pkg : args) {
            for (var classesList : new TestClassDiscoverer(pkg).listTestClasses()) {
                for (var testMethod : classesList.listTestMethods()) {
                    numberTests++;

                    Instant before = Instant.now();
                    boolean success = new TestRunner().doTest(testMethod);
                    Instant after = Instant.now();

                    if (!success)
                        numberFails++;

                    System.out.println(testMethod.getDeclaringClass().getName() + "#" + testMethod.getName() + " " + (success ? "OK" : "KO") + " " + (after.toEpochMilli() - before.toEpochMilli()) + " ms");
                }
            }
        }

        Instant testsEnd = Instant.now();

        System.out.println();

        System.out.println("Launched " + numberTests + " tests, got " + numberFails + " fails. Total time: " + (testsEnd.toEpochMilli() - begin.toEpochMilli()) + " ms");
    }

    private boolean doTest(Method method) {
        try {
            Object testInstance = method.getDeclaringClass().getConstructor().newInstance();
            method.invoke(testInstance);

            return true;
        } catch (Throwable t) {
            return false;
        }
    }
}

