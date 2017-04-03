package com.pixplicity.htmlcompat;

import android.text.Editable;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static junit.framework.Assert.assertEquals;

/**
 * Created by 소령이 on 2017-04-02.
 */

public class HtmlToSpannedConverterTest_part2 {
    private HtmlToSpannedConverter htmlToSpannedConverter ;

    @Test
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
    @Test
    public void getMargintest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(invoke(htmlToSpannedConverter, "getMargin",new Class<?>[]{int.class},1), 2);

        HtmlToSpannedConverter htmlToSpannedConverter2 = new HtmlToSpannedConverter(null, null, null, null, null, null, 1);
        assertEquals(invoke(htmlToSpannedConverter2, "getMargin",new Class<?>[]{int.class},1), 1);
        assertEquals(invoke(htmlToSpannedConverter2, "getMargin",new Class<?>[]{int.class},0), 2);
    }
    @Test
    public void appendNewlinestest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        MockEditable edit = new MockEditable("I'm STRING\n");
        invoke(htmlToSpannedConverter, "appendNewlines", new Class<?>[]{Editable.class, int.class}, edit, 3);
        assertEquals(edit.toString(),"I'm STRING\n\n\n");

        edit = new MockEditable("");
        invoke(htmlToSpannedConverter, "appendNewlines", new Class<?>[]{Editable.class, int.class}, edit, 2);
        assertEquals(edit.toString(),"");
    }

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