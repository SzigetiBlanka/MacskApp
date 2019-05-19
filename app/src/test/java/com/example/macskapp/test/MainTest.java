package com.example.macskapp.test;

import com.example.macskapp.ui.macskMain.MacskMainPresenter;
import com.example.macskapp.ui.macskMain.MacskMainScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import javax.inject.Inject;

import static com.example.macskapp.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class MainTest {
    @Inject
    MacskMainPresenter mainPresenter;

    private MacskMainScreen mainScreen;

    @Before
    public void setup() {
        DaggerTestComponent injector = setTestInjector();
        injector.inject(this);
        mainScreen = mock(MacskMainScreen.class);
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void testSearch() {
        mainPresenter.showCatsList();
        verify(mainScreen).showCats();
    }


    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}
