package com.egorbarinov.springlevelone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientJavaConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Weapon weaponComponent = context.getBean("weapon", Weapon.class);
        weaponComponent.doSoldier();

    }
}
