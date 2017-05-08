package com.pixplicity.htmlcompat;

import android.text.Editable;
import android.text.Spannable;

import junit.framework.Assert;

import org.ccil.cowan.tagsoup.Parser;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.XMLReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HtmlToSpannedConverterTest {
    private HtmlToSpannedConverter htmlToSpannedConverter;

    /*
    * author : suheeeee
    * description : initialization of member variable htmlToSpannedConverter.
    * */
    @Before
    public void before(){
        String source = "source\n";
        HtmlCompat.ImageGetter imageGetter = null;
        HtmlCompat.SpanCallback spanCallback = new HtmlCompat.SpanCallback() {
            @Override
            public Object onSpanCreated(String tag, Object span) {
                return null;
            }
        };
        HtmlCompat.TagHandler tagHandler = new HtmlCompat.TagHandler() {
            @Override
            public void handleTag(boolean opening, String tag, Attributes attributes, Editable output, XMLReader xmlReader) {

            }
        };
        Parser parser = new Parser();
        int flags = 0;

        htmlToSpannedConverter = new HtmlToSpannedConverter(null, source, imageGetter, tagHandler, spanCallback, parser, flags);
    }

    /*
    * author : gayoung
    * description : construct htmlToSpannedConverter.
    * */
    @Test
    public void HtmlToSpannedConverterTest(){
        assertTrue(htmlToSpannedConverter != null);
    }

    /*
    * author : gayoung
    * description : test pattern.compile method in getTextAlignPattern
    * return :(?:\s+|\A)text-align\s*:\s*(\S*)\b")
    * */
    @Test
    public void getTextAlignPatternTest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals(((Pattern)invoke(htmlToSpannedConverter, "getTextAlignPattern")).toString(),"(?:\\s+|\\A)text-align\\s*:\\s*(\\S*)\\b");
    }

    /*
    * author : Kwonsoryeong
    * description : if flag(parameter) and mFlags(constroctor) is both set, reuturn 1, else return 2
    * */
    @Test
    public void getMargintest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Assert.assertEquals(invoke(htmlToSpannedConverter, "getMargin",new Class<?>[]{int.class},1), 2);

        HtmlToSpannedConverter htmlToSpannedConverter2 = new HtmlToSpannedConverter(null, null, null, null, null, null, 1);
        Assert.assertEquals(invoke(htmlToSpannedConverter2, "getMargin",new Class<?>[]{int.class},1), 1);
        Assert.assertEquals(invoke(htmlToSpannedConverter2, "getMargin",new Class<?>[]{int.class},0), 2);
    }

    /*
    * author : Kwonsoryeong
    * description : this class is that text have Newline same as minNewline(parameter) or much than minNewline(parameter)
    * */
    @Test
    public void appendNewlinestest() throws SecurityException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        MockEditable edit = new MockEditable("I'm STRING\n"); // Editable work such as String in class, therefore I can Mock Editable as MockEditable(this is class about String implements Editable)
        invoke(htmlToSpannedConverter, "appendNewlines", new Class<?>[]{Editable.class, int.class}, edit, 3);
        Assert.assertEquals(edit.toString(),"I'm STRING\n\n\n");

        edit = new MockEditable("");
        invoke(htmlToSpannedConverter, "appendNewlines", new Class<?>[]{Editable.class, int.class}, edit, 2);
        Assert.assertEquals(edit.toString(),"");
    }

    /*
    * Eun : private setSpanFromMark : all null, half cover
    */
    @Test
    public void setSpanFromMarkTest() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        HtmlToSpannedConverter converter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method setspanfrommark;
        setspanfrommark = converter.getClass().getDeclaredMethod("setSpanFromMark", String.class, Spannable.class, Object.class, Object[].class);
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
        setspanfrommark.invoke(converter, str, span, obj1, obj2);
    }

    /*
    * author : suheeeee
    * description : test setDocumentLocator. setDocumentLocator have no content and return value.
    *               just check method have no exception or unexpected error.
    *               this can be removed.
    * */
    @Test
    public void setDocumentLocatorTest() {
        boolean isException = false;
        try {
            htmlToSpannedConverter.setDocumentLocator(new Locator() {
                @Override
                public String getPublicId() {
                    return null;
                }

                @Override
                public String getSystemId() {
                    return null;
                }

                @Override
                public int getLineNumber() {
                    return 0;
                }

                @Override
                public int getColumnNumber() {
                    return 0;
                }
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    /*
    * author : suheeeee
    * description : test startDocument. startDocument have no content and return value.
    *               just check method have no exception or unexpected error.
    *               this can be removed.
    * */
    @Test
    public void startDocumentTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.startDocument();
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    /*
    * author : suheeeee
    * description : test endDocument. endDocument have no content and return value.
    *               just check method have no exception or unexpected error.
    *               this can be removed.
    * */
    @Test
    public void endDocumentTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endDocument();
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    /*
    * author : suheeeee
    * description : test startPrefixMapping. startPrefixMapping have no content and return value.
    *               just check method have no exception or unexpected error.
    *               this can be removed.
    * */
    @Test
    public void startPrefixMappingTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.startPrefixMapping("prefix","uri");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);

    }
    /*
    * author : suheeeee
    * description : test endPrefixMapping. endPrefixMapping have no content and return value.
    *               just check method have no exception or unexpected error.
    *               this can be removed.
    * */
    @Test
    public void endPrefixMappingTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endPrefixMapping("prefix");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
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
* author : suheeeee
* description : test startElement. startElement have no content and return value.
*               just check method have no exception or unexpected error.
*               this can be removed.
* */
    @Test
    public void startElementBrTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "br", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementPTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "p", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementUlTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "ul", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementLiTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "li", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementDivTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "div", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementSpanTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "span", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementStrongTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "strong", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementBTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "b", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementEmTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "em", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementCiteTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "cite", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementDfnTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "dfn", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementITest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "i", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementBigTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "big", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementSmallTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "small", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementFontTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "font", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementBlockquoteTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "blockquote", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementTtTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "tt", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }


    @Test
    public void startElementATest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "a", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }


    @Test
    public void startElementUTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "u", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementDelTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "del", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }


    @Test
    public void startElementSTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "s", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }


    @Test
    public void startElementStrikeTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "strike", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }


    @Test
    public void startElementSubTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "sub", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementH1Test() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "h1", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementH6Test() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "h6", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementImgTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "img", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }


    @Test
    public void startElementH7Test() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "h7", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void startElementSupTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "sup", "qName", new Attributes() {
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
            });
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }


    /*
    * author : suheeeee
    * description : test sendElement. endElement have no content and return value.
    *               just check method have no exception or unexpected error.
    *               this can be removed.
    * */
    @Test
    public void endElementBrTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "br", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }
    @Test
    public void endElementPTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "p", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementUlTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "ul", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementLiTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "li", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }
    @Test
    public void endElementDivTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "div", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementSpanTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "span", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementStrongTest1() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "strong", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementBTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "b", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementEmTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "em", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }


    @Test
    public void endElementCiteTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "cite", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }
    @Test
    public void endElementDfnTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "dfn", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }
    @Test
    public void endElementITest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "i", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }
    @Test
    public void endElementBigTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "big", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }
    @Test
    public void endElementSmallTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "small", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }
    @Test
    public void endElementFontTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "font", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }
    @Test
    public void endElementBlockquoteTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "blockquote", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }
    @Test
    public void endElementTteTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "tt", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementATest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "a", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementUTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "u", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementDelTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "del", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementSTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "s", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementStrikeTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "strike", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementSupTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "sup", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementSubTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "sub", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementH1Test() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "h1", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementH6Test() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "h6", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    @Test
    public void endElementH7Test() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "h7", "qName");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }
    /*
    * author : suheeeee
    * description : test characters. it append mSpannableStringBuilder. this test some some issue.
    *               1. mSpannableStringBuilder is private various and class doesn't have getter method.
    *               2. method convert() return mSpannableStringBuilder but there is no proper method to read data of that.
    *               3. there is something error with jacoco, i can check code coverage.
    *               if we solve these issue, we can modify this test case.
    * */
    @Test
    public void charactersTest() throws Exception {
        String str = "characters Test";
        char[] charArray = str.toCharArray();
        boolean isException = false;

        try {
            htmlToSpannedConverter.characters(charArray, 0, str.length());
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    /*
     * author : suheeeee
     * description : test characters when len of cha[] is zero.
     *                this case have same issue with charactersTest.
     * */
    @Test
    public void charactersLenZeorTest() throws Exception {
        String str = " test";
        char[] charArray = str.toCharArray();
        boolean isException = false;

        try {
            htmlToSpannedConverter.characters(charArray, 0, str.length());
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    /*
    * author : suheeeee
    * description : test ignorableWhitespace. ignorableWhitespace have no content and return value.
    *               just check method have no exception or unexpected error.
    *               this can be removed.
    * */
    @Test
    public void ignorableWhitespaceTest() throws Exception {
        String str = "ignorable Whitespace Test";
        char[] charArray = str.toCharArray();
        boolean isException = false;

        try {
            htmlToSpannedConverter.ignorableWhitespace(charArray, 0, str.length());
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    /*
    * author : suheeeee
    * description : test processingInstruction. processingInstruction have no content and return value.
    *               just check method have no exception or unexpected error.
    *               this can be removed.
    * */
    @Test
    public void processingInstructionTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.processingInstruction("target", "data");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }

    /*
    * author : suheeeee
    * description : test skippedEntity. skippedEntity have no content and return value.
    *               just check method have no exception or unexpected error.
    *               this can be removed.
    * */
    @Test
    public void skippedEntityTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.skippedEntity("name");
        }catch (RuntimeException e){
            isException = true;
        }
        assertFalse(isException);
    }
    /*
    * author : suheeeee
    * description : we can't enough test this method, because it use 'real' background in html.
    * */
    @Test
    public void startCssStyleTest() throws NullPointerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        boolean isException = false;
        MockEditable text = new MockEditable("startCssStyle Test");
        Attributes attributes = new Attributes() {
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
                return "white";
            }

            @Override
            public String getValue(String qName) {
                return null;
            }
        };

        try {
            Method m_startCssStyle;
            m_startCssStyle = htmlToSpannedConverter.getClass().getDeclaredMethod("startCssStyle", Editable.class, Attributes.class);
            m_startCssStyle.setAccessible(true);
            m_startCssStyle.invoke(htmlToSpannedConverter, text, attributes);
        }catch (Exception e){
            isException = true;
        }
        assertFalse(isException);
    }

    /*
    * author : suheeeee
    * description : we can't enough test this method. and this case have error with Editable class
    * */
    @Test
    public void endCssStyleTest() throws NullPointerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        boolean isException = false;
        String tag = "p";
        MockEditable text = new MockEditable("endCssStyle Test p");

        try {
            Method m_startCssStyle;
            m_startCssStyle = htmlToSpannedConverter.getClass().getDeclaredMethod("endCssStyle", String.class, MockEditable.class);
            m_startCssStyle.setAccessible(true);
            m_startCssStyle.invoke(htmlToSpannedConverter, tag, text);
        }catch (Exception e){
            isException = true;
        }
        assertFalse(isException);
    }

}
