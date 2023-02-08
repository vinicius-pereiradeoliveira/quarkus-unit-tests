package org.acme.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class MyUtilsServiceTest {

    @Inject
    MyUtilsService service;

    @Test
    public void testPrimeNumberValidation(){
        Assertions.assertEquals(true, service.isPrimeNumber(5));
        Assertions.assertEquals(false, service.isPrimeNumber(0));
    }

    @Test
    public void testTextSizeValidation(){
        Assertions.assertEquals(19, service.countCharacters("Testing this method")); // consider blank space between words
        Assertions.assertEquals(7, service.countCharacters("Testing")); // 1 word
    }

}
