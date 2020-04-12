package com.lx.utils;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")//抑制警告
public class Idutils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(Idutils.getId());
        System.out.println(Idutils.getId());
        System.out.println(Idutils.getId());

    }
}
