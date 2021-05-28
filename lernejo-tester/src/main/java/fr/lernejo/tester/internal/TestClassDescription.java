package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestClassDescription {
    final Class<?> cls;

    public TestClassDescription(Class<?> cls) {
        this.cls = cls;
    }

    public List<Method> listTestMethods() {
        return Arrays.stream(cls.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .filter(m -> !Modifier.isStatic(m.getModifiers()))
            .filter(m -> m.getParameterCount() == 0)
            .filter(m -> m.getReturnType() == void.class)
            .filter(m -> m.isAnnotationPresent(TestMethod.class))
            .toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestClassDescription that = (TestClassDescription) o;
        return Objects.equals(cls, that.cls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cls);
    }
}
