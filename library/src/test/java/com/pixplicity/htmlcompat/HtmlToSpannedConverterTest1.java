package com.pixplicity.htmlcompat;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.EditText;

import org.junit.Test;
import org.xml.sax.Attributes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static org.junit.Assert.assertEquals;

/**
 * Created by eun on 2017-03-31.
 */

public class HtmlToSpannedConverterTest1 {
    @Test
    public void endBlockElementTest1() throws NullPointerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        HtmlToSpannedConverter converter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method endblockelement;
        endblockelement = converter.getClass().getDeclaredMethod("endBlockElement", String.class, Editable.class);
        endblockelement.setAccessible(true);

        Editable edit = new SpannableStringBuilder("123\n13\n14");
        String tag = "tag";
        endblockelement.invoke(converter, tag, edit);
    }

    @Test
    public void handleBrTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        HtmlToSpannedConverter converter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method handlebr;
        handlebr = converter.getClass().getDeclaredMethod("handleBr", Editable.class);
        handlebr.setAccessible(true);

        Editable edit = new SpannableStringBuilder();
        handlebr.invoke(converter, edit);
    }

    @Test
    public void startliTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        HtmlToSpannedConverter converter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method startli;
        startli = converter.getClass().getDeclaredMethod("startLi", Editable.class, Attributes.class);
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
        startli.invoke(converter, edit, attr);
    }

    @Test
    public void endliTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        HtmlToSpannedConverter converter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method endli;
        endli = converter.getClass().getDeclaredMethod("endLi", String.class, Editable.class);
        endli.setAccessible(true);

        String tag = "tag";
        Editable edit = new SpannableStringBuilder("10\ntest\nhello");
        endli.invoke(converter, tag, edit);
    }

    @Test
    public void startblockquoteTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        HtmlToSpannedConverter converter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method startblockquote;
        startblockquote = converter.getClass().getDeclaredMethod("startBlockquote", Editable.class, Attributes.class);
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
        startblockquote.invoke(converter, edit, attr);
    }

    @Test
    public void endblockquoteTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        HtmlToSpannedConverter converter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method endblockquote;
        endblockquote = converter.getClass().getDeclaredMethod("endBlockquote", String.class, Editable.class);
        endblockquote.setAccessible(true);

        String tag = "tag";
        Editable edit = new SpannableStringBuilder("10\ntest\nhello");
        endblockquote.invoke(converter, tag, edit);
    }

    @Test
    public void startheadingTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        HtmlToSpannedConverter converter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method startheading;
        startheading = converter.getClass().getDeclaredMethod("startHeading", Editable.class, Attributes.class, int.class);
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
        startheading.invoke(converter, edit, attr, 0);
    }

    @Test
    public void endheadingTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        HtmlToSpannedConverter converter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method endheading;
        endheading = converter.getClass().getDeclaredMethod("endHeading", String.class, Editable.class);
        endheading.setAccessible(true);

        String tag = "tag";
        Editable edit = new SpannableStringBuilder("10\ntest\nhello");
        endheading.invoke(converter, tag, edit);
    }

    @Test
    public void getlastTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        HtmlToSpannedConverter converter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method endheading;
        endheading = converter.getClass().getDeclaredMethod("getLast", Spanned.class, Class.class);
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
        // endheading.invoke(converter, span, kind);
    }

    public void setspanfrommarkTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        HtmlToSpannedConverter converter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method setspanfrommark;
        setspanfrommark = converter.getClass().getDeclaredMethod("setSpanFromMark", String.class, Spannable.class, Class.class, Object.class, Object.class);
        setspanfrommark.setAccessible(true);


    }

}
