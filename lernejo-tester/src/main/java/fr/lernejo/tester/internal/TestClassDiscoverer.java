package fr.lernejo.tester.internal;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.List;
import java.util.Set;

public class TestClassDiscoverer {
    private final String pkgName;

    public TestClassDiscoverer(String pkgName) {
        this.pkgName = pkgName;
    }

    List<TestClassDescription> listTestClasses() {
        Reflections reflections = new Reflections(pkgName, new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);

        return allTypes.stream()
            .filter(s -> s.getName().endsWith("LernejoTests"))
            .map(TestClassDescription::new)
            .filter(s -> !s.listTestMethods().isEmpty())
            .toList();
    }
}
