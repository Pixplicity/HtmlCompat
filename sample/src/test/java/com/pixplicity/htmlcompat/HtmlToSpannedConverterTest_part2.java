package com.pixplicity.htmlcompat;

import android.text.Editable;
//import android.text.SpannableStringBuilder;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;


public class HtmlToSpannedConverterTest_part2 {
    private HtmlToSpannedConverter htmlToSpannedConverter ;
    //Editable edit = new SpannableStringBuilder("Im STRING");

    @Before
    public void before(){
        htmlToSpannedConverter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
    }

    @Test
    public void getMarginParagraphtest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(invoke(htmlToSpannedConverter, "getMarginParagraph"),2);
    }
    @Test
    public void getMarginHeadingtest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(invoke(htmlToSpannedConverter, "getMarginHeading"),2);
    }
    @Test
    public void getMarginListItemtest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(invoke(htmlToSpannedConverter, "getMarginListItem"),2);
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
    }
    /*     @Test
       public void appendNewlinestest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
            //Log.d("TEXT" , edit+"kaka");
            System.out.println(edit+"kaka");
            invoke(htmlToSpannedConverter, "appendNewlines", new Class<?>[]{Editable.class, int.class}, edit, 2);
            System.out.println(edit+"lala");
            assertEquals("Im STRING\n\n", edit.toString()); //매개변수 Editable의 뒤에 매개변수 int의 수만큼 '\n' 넣기작동이 이상없이 실행됨 //void를 return하는 함수이기에 전역변수 사용하여 assert
        }*/
    private Object invoke(Object ut, String methodName, Class<?>[] argTypes, Object ... args) throws SecurityException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = ut.getClass().getDeclaredMethod(methodName, argTypes);
        method.setAccessible(true);
        return method.invoke(ut, args);
    }

    private Object invoke(Object ut, String methodName, Object ... args) throws SecurityException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int argSize = args.length;
        Class<?>[] argTypes = new Class<?>[argSize];
        for (int i = 0; i < argSize; i++) {
            argTypes[i] = args[i].getClass();
        }
        return invoke(ut, methodName, argTypes, args);
    }
}