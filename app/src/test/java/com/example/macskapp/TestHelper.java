package com.example.macskapp;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {
    public static DaggerTestComponent setTestInjector() {
        ShadowLog.stream = System.out;
        MacskAppApplication application = (MacskAppApplication) RuntimeEnvironment.application;
        MacskAppApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
        return (DaggerTestComponent) injector;
    }
}
