package com.egorbarinov.springlevelone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Weapon weapon = context.getBean("weapon", Weapon.class);
        weapon.doSoldier();

        Weapon weaponInnerBean = context.getBean("weaponInnerBean", Weapon.class);
        weaponInnerBean.doSoldier();

        Weapon weaponConstructor = context.getBean("weaponConstructor", Weapon.class);
        weaponConstructor.doSoldier();

    }
}
