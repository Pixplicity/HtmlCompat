package com.pixplicity.htmlcompat;

import android.text.Editable;

import org.ccil.cowan.tagsoup.Parser;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.XMLReader;

import static org.junit.Assert.assertFalse;

public class HtmlToSpannedConverter_UnitTest_Part5 {
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

    /*
    * author : suheeeee
    * description : test startElement. startElement have no content and return value.
    *               just check method have no exception or unexpected error.
    *               this can be removed.
    * */
    @Test
    public void startElementTest() throws Exception {
        boolean isException = false;
        try {
            htmlToSpannedConverter.startElement("uri", "local name", "qName", new Attributes() {
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
    public void endElementTest() throws Exception {
        boolean isException = false;

        try {
            htmlToSpannedConverter.endElement("uri", "localName", "qName");
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
        String str = "";
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
}
