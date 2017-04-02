package com.pixplicity.htmlcompat;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.BulletSpan;
import android.util.Log;

import org.ccil.cowan.tagsoup.Parser;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.XMLReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.*;


import static java.lang.System.out;
import static org.junit.Assert.*;

/**
 * Created by zaiha on 2017-03-31.
 */

public class HtmlToSpannedConverterTest {

    private static Pattern sTextAlignPattern;
    private Context myContext = null;
    private String mySource= null;
    private HtmlCompat.SpanCallback mSpanCallback= null;
    private XMLReader mReader= null;
    private SpannableStringBuilder mSpannableStringBuilder= null;
    private HtmlCompat.ImageGetter mImageGetter= null;
    private HtmlCompat.TagHandler mTagHandler= null;
    private HtmlToSpannedConverter htmlToSpannedConverter ;
    private static Matcher M;
    private int mFlags= 0;
    /*
    * author : gayoung
    * description : construct htmlToSpannedConverter.
    * */
    @Test
    public void HtmlToSpannedConverterTest(){
        HtmlToSpannedConverter H = new HtmlToSpannedConverter(myContext, mySource,mImageGetter,mTagHandler,mSpanCallback,null,mFlags);
        assertTrue(H != null);
    }

    @Before
    public void before(){
        htmlToSpannedConverter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
    }
    /*
    * author : gayoung
    * description : test pattern.compile method in getTextAlignPattern
    * return :(?:\s+|\A)text-align\s*:\s*(\S*)\b")
    * */
    @Test
    public void testCallPrivate1() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(((Pattern)invoke(htmlToSpannedConverter, "getTextAlignPattern")).toString(),"(?:\\s+|\\A)text-align\\s*:\\s*(\\S*)\\b");
    }
    /*
    * author : gayoung
    * description : test pattern.compile method in getForegroundColorPattern
    * return :(?:\s+|\A)color\s*:\s*(\S*)\b
    * */
    @Test
    public void testCallPrivate2() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(((Pattern)invoke(htmlToSpannedConverter, "getForegroundColorPattern")).toString(),"(?:\\s+|\\A)color\\s*:\\s*(\\S*)\\b");
    }
    /*
    * author : gayoung
    * description : test pattern.compile method in getBackgroundColorPattern
    * return :(?:\s+|\A)background(?:-color)?\s*:\s*(\S*)\b
    * */
    @Test
    public void testCallPrivate3() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(((Pattern)invoke(htmlToSpannedConverter, "getBackgroundColorPattern")).toString(),"(?:\\s+|\\A)background(?:-color)?\\s*:\\s*(\\S*)\\b");
    }
    /*
    * author : gayoung
    * description : test pattern.compile method in
    * return :(?:\s+|\A)text-decoration\s*:\s*(\S*)\b
    * */
    @Test
    public void testCallPrivate4() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(((Pattern)invoke(htmlToSpannedConverter, "getTextDecorationPattern")).toString(),"(?:\\s+|\\A)text-decoration\\s*:\\s*(\\S*)\\b");
    }
    /*
    * author : gayoung
    * description : not yet
    * */
    @Test
    public void handleStartTag() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
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
    /*
    * author : gayoung
    * description : null pointer exception. can't get span util emulator working.
    *
    * */
    @Test
    public void convertTest() throws NullPointerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Parser parser = new Parser();
        HtmlToSpannedConverter H = new HtmlToSpannedConverter(myContext, "my text please let me go \n i want sleep all day",mImageGetter,mTagHandler,mSpanCallback,parser,mFlags);
        Method convert;
        convert = H.getClass().getDeclaredMethod("convert");
        convert.setAccessible(true);

        H.convert();
        //assertEquals();
    }

}
