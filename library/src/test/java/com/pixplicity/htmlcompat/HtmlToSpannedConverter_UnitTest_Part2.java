package com.pixplicity.htmlcompat;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.Attributes;

import java.io.NotActiveException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static org.junit.Assert.assertEquals;

/**
 * Created by eunsdaily.
 * HtmlToSpannedConverterTest Part 3.
 * Kwon Eun
 */

public class HtmlToSpannedConverter_UnitTest_Part2{
    private HtmlToSpannedConverter htmlToSpannedConverter ;
    Editable edit = new SpannableStringBuilder("I'm STRING");

    @Before
    public void before(){
        htmlToSpannedConverter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
    }

    @Test
    public void getMarginParagraphtest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(invoke(htmlToSpannedConverter, "getMarginParagraph"), 2);
    }
    @Test
    public void getMarginHeadingtest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(invoke(htmlToSpannedConverter, "getMarginHeading"), 2);
    }
    @Test
    public void getMarginListItemtest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(invoke(htmlToSpannedConverter, "getMarginListItem"), 2);
    }
    @Test
    public void getMarginListtest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(invoke(htmlToSpannedConverter, "getMarginList"), 2);
    }
    @Test
    public void getMarginDivtest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(invoke(htmlToSpannedConverter, "getMarginDiv"), 2);
    }
    @Test
    public void getMarginBlockquotetest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(invoke(htmlToSpannedConverter, "getMarginBlockquote"), 2);
    }
 /*   @Test
    public void getMargintest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(invoke(htmlToSpannedConverter, "getMargin",1), 2);
    }
    @Test
    public void appendNewlinestest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //Class[] types = new Class[]{Editable.class,int.class};
        //Object[] args = {edit,2};
        invoke(htmlToSpannedConverter, "appendNewlines",edit,2);
        assertEquals(edit,"I'm STRING\n\n");
    }
*/

    private Object invoke(Object ut, String methodName, Class<?>[] argTypes, Object ... args) throws SecurityException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = ut.getClass().getDeclaredMethod(methodName, argTypes);
        method.setAccessible(true);
        return method.invoke(ut, args);
    }

    private Object invoke(Object ut, String methodName, Object ... args) throws SecurityException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int argSize = args.length;
        Class<?>[] argTypes = new Class<?>[argSize];
        for(int i=0;i< argSize;i++){
            argTypes[i] = args[i].getClass();
        }
        return invoke(ut,methodName, argTypes, args);
    }
}
