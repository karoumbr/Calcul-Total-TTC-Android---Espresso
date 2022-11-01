package com.bentechprotv.android.calcultotalttc;

import junit.framework.TestCase;

import static androidx.test.espresso.Espresso.onView;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;

import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static java.lang.Thread.sleep;





import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends TestCase {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestrule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void exemple1(){
        onView(withId(R.id.edtHT)).perform(typeText("10"),closeSoftKeyboard());
        onView(withId(R.id.edtTVA)).perform(typeText("19"),closeSoftKeyboard());
        onView(withId(R.id.edtQte)).perform(typeText("1"),closeSoftKeyboard());

        onView(withId(R.id.btnTTC)).perform(click());
        onView(withId(R.id.txtTVA)).check(matches(withText("1.900")));
        onView(withId(R.id.txtTTC)).check(matches(withText("11.900")));
        try{
            sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Test
    public void exemple2(){
        onView(withId(R.id.edtHT)).perform(typeText("10"),closeSoftKeyboard());
        onView(withId(R.id.edtTVA)).perform(typeText("19"),closeSoftKeyboard());
        onView(withId(R.id.edtQte)).perform(typeText("2"),closeSoftKeyboard());

        onView(withId(R.id.btnTTC)).perform(click());
        onView(withId(R.id.txtTVA)).check(matches(withText("3.800")));
        onView(withId(R.id.txtTTC)).check(matches(withText("23.800")));
        try{
            sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Test
    public void exemple3(){
        onView(withId(R.id.edtHT)).perform(typeText("10"),closeSoftKeyboard());
        onView(withId(R.id.edtTVA)).perform(typeText("19"),closeSoftKeyboard());
        onView(withId(R.id.edtQte)).perform(typeText(""),closeSoftKeyboard());

        onView(withId(R.id.btnTTC)).perform(click());
        onView(withId(R.id.edtQte)).check(matches(withText("1")));
        try{
            sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Test
    public void exemple4(){
        onView(withId(R.id.edtHT)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.edtTVA)).perform(typeText("19"),closeSoftKeyboard());
        onView(withId(R.id.edtQte)).perform(typeText("1"),closeSoftKeyboard());

        onView(withId(R.id.btnTTC)).perform(click());
        //tester l'affichage d'un Toast (message indiquant que le montant HT est vide
     onView(withText(R.string.edtHT_Vide)).inRoot(withDecorView(not(is(mActivityTestrule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
        try{
            sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Test
    public void exemple5(){
        onView(withId(R.id.edtHT)).perform(typeText("10"),closeSoftKeyboard());
        onView(withId(R.id.edtTVA)).perform(typeText("19"),closeSoftKeyboard());
        onView(withId(R.id.edtQte)).perform(typeText("1"),closeSoftKeyboard());

        onView(withId(R.id.btnTTC)).perform(click());
        onView(withId(R.id.txtTTC)).check(matches(isDisplayed()));

        try{
            sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
