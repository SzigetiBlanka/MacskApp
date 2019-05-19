package com.example.macskapp.test;

import com.example.macskapp.model.Cat;
import com.example.macskapp.ui.macsklist.MacskListPresenter;
import com.example.macskapp.ui.macsklist.MacskListScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;


import javax.inject.Inject;

import static com.example.macskapp.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class CatTest {

        @Inject
        MacskListPresenter macskListPresenter;
        private MacskListScreen macskListScreen;

        @Before
        public void setup() {
            DaggerTestComponent injector = setTestInjector();
            injector.inject(this);
            macskListScreen = mock(MacskListScreen.class);
            macskListPresenter.attachScreen(macskListScreen);
        }

        @Test
        public void testArtists() {
            String query = "Tita";
            macskListPresenter.refreshCats(query);

            ArgumentCaptor<Cat> catCaptor = ArgumentCaptor.forClass(Cat.class);
            verify(macskListScreen).showCat(catCaptor.capture());
            assertTrue(catCaptor.getValue().getCatName() != null);
        }


        @After
        public void tearDown() {
            macskListPresenter.detachScreen();
        }

    }
}
