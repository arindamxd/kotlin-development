package com.arindam.android.training.kotlin.jvmstatic;

/**
 * Created by Arindam Karmakar on 9/8/19.
 */

public class JvmStatic {
    public static void main(String[] args) {
        System.out.println(Avenger.Companion.getNonStaticProperty()); // > I'm not static!
        System.out.println(Avenger.Companion.getStaticProperty()); // > I'm static!

        System.out.println(Avenger.getStaticProperty()); // > I'm static!
    }
}
