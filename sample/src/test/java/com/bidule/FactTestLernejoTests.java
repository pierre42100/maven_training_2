package com.bidule;


import fr.lernejo.tester.api.TestMethod;

public class FactTestLernejoTests {

    @TestMethod
    public void simple() {
        if(new Fact().fact(3) != 6)
            throw new RuntimeException("Invalid test!");
    }
}
