package com.arindam.android.training.kotlin.interop;

/**
 * Need to use checked exceptions 🔥 during Kotlin-Java interop?
 * Don't worry, the `Throws` annotation is here for the rescue 🆘.
 *
 * Created by Arindam Karmakar on 9/8/19.
 */

public class Vacation {

    public static void main(String[] args) throws AllWorkNoPlayException {
        Developer developer = new Developer("John", true);
        developer.goToVacation();
    }
}
