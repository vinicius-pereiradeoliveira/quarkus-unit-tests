package org.acme.service;

import org.acme.util.CalcUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MyUtilsService {

    @Inject
    CalcUtils calcUtils;

    public boolean isPrimeNumber(int number){
        return calcUtils.verifyPrimeNumber(number);
    }

    public int countCharacters(String input) {
        return input.length();
    }

}
