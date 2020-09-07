package com.egorbarinov.springlevelone;

import org.springframework.stereotype.Component;

@Component("realProjectile")
public class RealProjectile implements Magazine {
    @Override
    public void processing() {
        System.out.println("Damage caused");
    }
}
