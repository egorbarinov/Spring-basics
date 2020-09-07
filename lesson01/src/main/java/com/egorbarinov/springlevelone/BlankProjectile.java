package com.egorbarinov.springlevelone;

import org.springframework.stereotype.Component;

@Component("blankProjectile")
public class BlankProjectile implements Magazine{
    @Override
    public void processing() {
        System.out.println("Scared");
    }
}
