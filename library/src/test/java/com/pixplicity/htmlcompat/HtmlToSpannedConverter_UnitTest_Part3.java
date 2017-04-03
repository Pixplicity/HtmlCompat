package com.pixplicity.htmlcompat;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.EditText;

import org.ccil.cowan.tagsoup.Parser;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;

import java.io.NotActiveException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static org.junit.Assert.assertEquals;

/**
 * Created by eunsdaily.
 * HtmlToSpannedConverter_UnitTest_Part1 Part 3.
 * Kwon Eun
 */

public class HtmlToSpannedConverter_UnitTest_Part3 {
    private HtmlToSpannedConverter htmlToSpannedConverter;

    /*
     * Eun
     */
    @Before
    public void before(){
        String src = "SRC\n";
        HtmlCompat.TagHandler tagH = new HtmlCompat.TagHandler() {
            @Override
            public void handleTag(boolean opening, String tag, Attributes attributes, Editable output, XMLReader xmlReader) {

            }
        };
        HtmlCompat.SpanCallback Scallback = new HtmlCompat.SpanCallback() {
            @Override
            public Object onSpanCreated(String tag, Object span) {
                return null;
            }
        };

        htmlToSpannedConverter = new HtmlToSpannedConverter(null, src, null, tagH, Scallback, new Parser(), 0);
    }

    /*
     * Eun : private endBlockElementTest : all null
     */
    @Test
    public void endBlockElementTest1() throws NullPointerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        try {
            Method endblockelement;
            endblockelement = htmlToSpannedConverter.getClass().getDeclaredMethod("endBlockElement", String.class, Editable.class);
            endblockelement.setAccessible(true);

            String tag = "tag";
            MockEditable edit = new MockEditable("test\n\ntest\ntest\n\n\ntest");
            endblockelement.invoke(htmlToSpannedConverter, tag, edit);
        }
        catch (Exception e){;}
    }

    /*
     * Eun : private handleBrTest : all cover
     */
    @Test
    public void handleBrTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method handlebr;
        handlebr = htmlToSpannedConverter.getClass().getDeclaredMethod("handleBr", Editable.class);
        handlebr.setAccessible(true);

        Editable edit = new SpannableStringBuilder();
        handlebr.invoke(htmlToSpannedConverter, edit);
    }

    /*
     * Eun : private startLi : all null, all cover
     */
    @Test
    public void startliTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method startli;
        startli = htmlToSpannedConverter.getClass().getDeclaredMethod("startLi", Editable.class, Attributes.class);
        startli.setAccessible(true);

        Editable edit = new SpannableStringBuilder("10\ntest\nhello");
        Attributes attr = new Attributes() {
            @Override
            public int getLength() {
                return 0;
            }

            @Override
            public String getURI(int index) {
                return null;
            }

            @Override
            public String getLocalName(int index) {
                return null;
            }

            @Override
            public String getQName(int index) {
                return null;
            }

            @Override
            public String getType(int index) {
                return null;
            }

            @Override
            public String getValue(int index) {
                return null;
            }

            @Override
            public int getIndex(String uri, String localName) {
                return 0;
            }

            @Override
            public int getIndex(String qName) {
                return 0;
            }

            @Override
            public String getType(String uri, String localName) {
                return null;
            }

            @Override
            public String getType(String qName) {
                return null;
            }

            @Override
            public String getValue(String uri, String localName) {
                return null;
            }

            @Override
            public String getValue(String qName) {
                return null;
            }
        };
        startli.invoke(htmlToSpannedConverter, edit, attr);
    }

    /*
     * Eun : private endLi : all null
     */
    @Test
    public void endliTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        try {
            Method endli;
            endli = htmlToSpannedConverter.getClass().getDeclaredMethod("endLi", String.class, Editable.class);
            endli.setAccessible(true);

            String tag = "tag";
            Editable edit = new SpannableStringBuilder("10\ntest\nhello");
            endli.invoke(htmlToSpannedConverter, tag, edit);
        }
        catch (Exception e){;}
    }

    /*
     * Eun : private startBlockQuote : all null, all cover
     */
    @Test
    public void startblockquoteTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method startblockquote;
        startblockquote = htmlToSpannedConverter.getClass().getDeclaredMethod("startBlockquote", Editable.class, Attributes.class);
        startblockquote.setAccessible(true);

        Editable edit = new SpannableStringBuilder("10\ntest\nhello");
        Attributes attr = new Attributes() {
            @Override
            public int getLength() {
                return 0;
            }

            @Override
            public String getURI(int index) {
                return null;
            }

            @Override
            public String getLocalName(int index) {
                return null;
            }

            @Override
            public String getQName(int index) {
                return null;
            }

            @Override
            public String getType(int index) {
                return null;
            }

            @Override
            public String getValue(int index) {
                return null;
            }

            @Override
            public int getIndex(String uri, String localName) {
                return 0;
            }

            @Override
            public int getIndex(String qName) {
                return 0;
            }

            @Override
            public String getType(String uri, String localName) {
                return null;
            }

            @Override
            public String getType(String qName) {
                return null;
            }

            @Override
            public String getValue(String uri, String localName) {
                return null;
            }

            @Override
            public String getValue(String qName) {
                return null;
            }
        };
        startblockquote.invoke(htmlToSpannedConverter, edit, attr);
    }

    /*
     * Eun : private endBlockQuote : all null
     */
    @Test
    public void endblockquoteTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        try {
            Method endblockquote;
            endblockquote = htmlToSpannedConverter.getClass().getDeclaredMethod("endBlockquote", String.class, Editable.class);
            endblockquote.setAccessible(true);

            String tag = "tag";
            Editable edit = new SpannableStringBuilder("10\ntest\nhello");
            endblockquote.invoke(htmlToSpannedConverter, tag, edit);
        }
        catch (Exception e){;}
    }

    /*
     * Eun : private startHeadingTest : all null, all cover
     */
    @Test
    public void startheadingTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method startheading;
        startheading = htmlToSpannedConverter.getClass().getDeclaredMethod("startHeading", Editable.class, Attributes.class, int.class);
        startheading.setAccessible(true);

        Editable edit = new SpannableStringBuilder("10\ntest\nhello");
        Attributes attr = new Attributes() {
            @Override
            public int getLength() {
                return 0;
            }

            @Override
            public String getURI(int index) {
                return null;
            }

            @Override
            public String getLocalName(int index) {
                return null;
            }

            @Override
            public String getQName(int index) {
                return null;
            }

            @Override
            public String getType(int index) {
                return null;
            }

            @Override
            public String getValue(int index) {
                return null;
            }

            @Override
            public int getIndex(String uri, String localName) {
                return 0;
            }

            @Override
            public int getIndex(String qName) {
                return 0;
            }

            @Override
            public String getType(String uri, String localName) {
                return null;
            }

            @Override
            public String getType(String qName) {
                return null;
            }

            @Override
            public String getValue(String uri, String localName) {
                return null;
            }

            @Override
            public String getValue(String qName) {
                return null;
            }
        };
        startheading.invoke(htmlToSpannedConverter, edit, attr, 0);
    }

    /*
     * Eun : private endHeadingTest : all null
     */
    @Test
    public void endheadingTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        try {
            Method endheading;
            endheading = htmlToSpannedConverter.getClass().getDeclaredMethod("endHeading", String.class, Editable.class);
            endheading.setAccessible(true);

            String tag = "tag";
            Editable edit = new SpannableStringBuilder("10\ntest\nhello");

            endheading.invoke(htmlToSpannedConverter, tag, edit);
        }
        catch (Exception e){;}
    }

    /*
     * Eun : private getLastTest : all null
     */
    @Test
    public void getlastTest() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException {
        try {
            Method endheading;
            endheading = htmlToSpannedConverter.getClass().getDeclaredMethod("getLast", Spanned.class, Class.class);
            endheading.setAccessible(true);

            Spanned span = new Spanned() {
                @Override
                public <T> T[] getSpans(int start, int end, Class<T> type) {
                    return null;
                }

                @Override
                public int getSpanStart(Object tag) {
                    return 0;
                }

                @Override
                public int getSpanEnd(Object tag) {
                    return 0;
                }

                @Override
                public int getSpanFlags(Object tag) {
                    return 0;
                }

                @Override
                public int nextSpanTransition(int start, int limit, Class type) {
                    return 0;
                }

                @Override
                public int length() {
                    return 0;
                }

                @Override
                public char charAt(int index) {
                    return 0;
                }

                @Override
                public CharSequence subSequence(int start, int end) {
                    return null;
                }
            };
            Class<?> kinds = Class.forName("inline.class");
            endheading.invoke(htmlToSpannedConverter, span, kinds);
        }
        catch (Exception e){;}
    }

    /*
     * Eun : private setSpanFromMark : all null, half cover
     */
    @Test
    public void setspanfrommarkTest() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method setspanfrommark;
        setspanfrommark = htmlToSpannedConverter.getClass().getDeclaredMethod("setSpanFromMark", String.class, Spannable.class, Object.class, Object[].class);
        setspanfrommark.setAccessible(true);

        String str = "Test";
        Spannable span = new Spannable() {
            @Override
            public void setSpan(Object what, int start, int end, int flags) {

            }

            @Override
            public void removeSpan(Object what) {

            }

            @Override
            public <T> T[] getSpans(int start, int end, Class<T> type) {
                return null;
            }

            @Override
            public int getSpanStart(Object tag) {
                return 0;
            }

            @Override
            public int getSpanEnd(Object tag) {
                return 0;
            }

            @Override
            public int getSpanFlags(Object tag) {
                return 0;
            }

            @Override
            public int nextSpanTransition(int start, int limit, Class type) {
                return 0;
            }

            @Override
            public int length() {
                return 0;
            }

            @Override
            public char charAt(int index) {
                return 0;
            }

            @Override
            public CharSequence subSequence(int start, int end) {
                return null;
            }
        };
        Object obj1 = new Object();
        Object[] obj2 = new Object[2];
        setspanfrommark.invoke(htmlToSpannedConverter, str, span, obj1, obj2);
    }

}
