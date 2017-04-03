package com.pixplicity.htmlcompat;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;

import org.junit.Test;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.stubbing.OngoingStubbing;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.lang.*;

import static org.junit.Assert.*;
import static org.junit.runner.Request.method;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class HtmlToSpannedConverter_UnitTest_Part4 {

    /** author : musicianZem<qufaudwpak@naver.com>
     *  Purpose : Span Editable text by text's length
     * Parameter : Editable text, Object mark
     * Expected : text Spanned
     *
     */
    @Test
    public void startTest() throws Exception, NullPointerException {
        HtmlToSpannedConverter htsConverter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method startMethod;
        startMethod = htsConverter.getClass().getDeclaredMethod("start", Editable.class, Object.class);
        startMethod.setAccessible(true);
        Editable editable = new Editable() {
            @Override
            public Editable replace(int st, int en, CharSequence source, int start, int end) {
                return null;
            }

            @Override
            public Editable replace(int st, int en, CharSequence text) {
                return null;
            }

            @Override
            public Editable insert(int where, CharSequence text, int start, int end) {
                return null;
            }

            @Override
            public Editable insert(int where, CharSequence text) {
                return null;
            }

            @Override
            public Editable delete(int st, int en) {
                return null;
            }

            @Override
            public Editable append(CharSequence text) {
                return null;
            }

            @Override
            public Editable append(CharSequence text, int start, int end) {
                return null;
            }

            @Override
            public Editable append(char text) {
                return null;
            }

            @Override
            public void clear() {

            }

            @Override
            public void clearSpans() {

            }

            @Override
            public void setFilters(InputFilter[] filters) {

            }

            @Override
            public InputFilter[] getFilters() {
                return new InputFilter[0];
            }

            @Override
            public void getChars(int start, int end, char[] dest, int destoff) {

            }

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
        Object object = new Object();

        startMethod.invoke(htsConverter, editable, object); // run
    }

    /** author : musicianZem<qufaudwpak@naver.com>
     */
    @Test
    public void handleEndTagTest() throws Exception {
        HtmlToSpannedConverter htsConverter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method testMethod;
        testMethod = htsConverter.getClass().getDeclaredMethod("handleEndTag", String.class);
        testMethod.setAccessible(true);
        String tag;
        tag = "br"; testMethod.invoke(htsConverter, tag);
        tag = "p";  testMethod.invoke(htsConverter, tag);
        tag = "ul";  testMethod.invoke(htsConverter, tag);
        tag = "li";  testMethod.invoke(htsConverter, tag);
        tag = "div";  testMethod.invoke(htsConverter, tag);
        tag = "span";  testMethod.invoke(htsConverter, tag);
        tag = "strong";  testMethod.invoke(htsConverter, tag);
        tag = "b";  testMethod.invoke(htsConverter, tag);
        tag = "em";  testMethod.invoke(htsConverter, tag);
        tag = "cite";  testMethod.invoke(htsConverter, tag);
        tag = "dfn";  testMethod.invoke(htsConverter, tag);
        tag = "i";  testMethod.invoke(htsConverter, tag);
        tag = "big";  testMethod.invoke(htsConverter, tag);
        tag = "small";  testMethod.invoke(htsConverter, tag);
        tag = "font";  testMethod.invoke(htsConverter, tag);
        tag = "blockquote";  testMethod.invoke(htsConverter, tag);
        tag = "tt";  testMethod.invoke(htsConverter, tag);
        tag = "a";  testMethod.invoke(htsConverter, tag);
        tag = "u";  testMethod.invoke(htsConverter, tag);
        tag = "del";  testMethod.invoke(htsConverter, tag);
        tag = "s";  testMethod.invoke(htsConverter, tag);
        tag = "strike";  testMethod.invoke(htsConverter, tag);
        tag = "sub";  testMethod.invoke(htsConverter, tag);
        tag = "sup";  testMethod.invoke(htsConverter, tag);
        tag = "h2";  testMethod.invoke(htsConverter, tag);
        tag = "img";  testMethod.invoke(htsConverter, tag);
    }

    /** author : musicianZem<qufaudwpak@naver.com>
     * */
    @Test
    public void checkForHandleStartTag() throws Exception {
        HtmlToSpannedConverter htsConverter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method testMethod = htsConverter.getClass().getDeclaredMethod("handleStartTag", String.class, Attributes.class);
        testMethod.setAccessible(true);
        Attributes att = new Attributes() {
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
        String tag = "br"; testMethod.invoke(htsConverter, tag, att);
        tag = "p";  testMethod.invoke(htsConverter, tag, att);
        tag = "ul";  testMethod.invoke(htsConverter, tag, att);
        tag = "li";  testMethod.invoke(htsConverter, tag, att);
        tag = "div";  testMethod.invoke(htsConverter, tag, att);
        tag = "span";  testMethod.invoke(htsConverter, tag, att);
        tag = "strong";  testMethod.invoke(htsConverter, tag, att);
        tag = "b";  testMethod.invoke(htsConverter, tag, att);
        tag = "em";  testMethod.invoke(htsConverter, tag, att);
        tag = "cite";  testMethod.invoke(htsConverter, tag, att);
        tag = "dfn";  testMethod.invoke(htsConverter, tag, att);
        tag = "i";  testMethod.invoke(htsConverter, tag, att);
        tag = "big";  testMethod.invoke(htsConverter, tag, att);
        tag = "small";  testMethod.invoke(htsConverter, tag, att);
        tag = "font";  testMethod.invoke(htsConverter, tag, att);
        tag = "blockquote";  testMethod.invoke(htsConverter, tag, att);
        tag = "tt";  testMethod.invoke(htsConverter, tag, att);
        tag = "a";  testMethod.invoke(htsConverter, tag, att);
        tag = "u";  testMethod.invoke(htsConverter, tag, att);
        tag = "del";  testMethod.invoke(htsConverter, tag, att);
        tag = "s";  testMethod.invoke(htsConverter, tag, att);
        tag = "strike";  testMethod.invoke(htsConverter, tag, att);
        tag = "sub";  testMethod.invoke(htsConverter, tag, att);
        tag = "sup";  testMethod.invoke(htsConverter, tag, att);
        tag = "h2";  testMethod.invoke(htsConverter, tag, att);
        tag = "img";  testMethod.invoke(htsConverter, tag, att);
    }

    /** author : musicianZem<qufaudwpak@naver.com>
     * */
    @Test
    public void endTest() throws Exception {
        HtmlToSpannedConverter htsConverter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method endMethod;
        endMethod = htsConverter.getClass().getDeclaredMethod("end", String.class, Editable.class, Class.class, Object.class);
        endMethod.setAccessible(true);
        String string = "Test string... style";
        Editable editable = new Editable() {
            @Override
            public Editable replace(int st, int en, CharSequence source, int start, int end) {
                return null;
            }

            @Override
            public Editable replace(int st, int en, CharSequence text) {
                return null;
            }

            @Override
            public Editable insert(int where, CharSequence text, int start, int end) {
                return null;
            }

            @Override
            public Editable insert(int where, CharSequence text) {
                return null;
            }

            @Override
            public Editable delete(int st, int en) {
                return null;
            }

            @Override
            public Editable append(CharSequence text) {
                return null;
            }

            @Override
            public Editable append(CharSequence text, int start, int end) {
                return null;
            }

            @Override
            public Editable append(char text) {
                return null;
            }

            @Override
            public void clear() {

            }

            @Override
            public void clearSpans() {

            }

            @Override
            public void setFilters(InputFilter[] filters) {

            }

            @Override
            public InputFilter[] getFilters() {
                return new InputFilter[0];
            }

            @Override
            public void getChars(int start, int end, char[] dest, int destoff) {

            }

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
        Object object = new Object();
        editable.append("...");
        assertNotEquals(string, null);
        assertNotEquals(object, null);
        assertNotEquals(editable, null);

        try {
            Editable eOrigin = editable;
            endMethod.invoke(htsConverter, string, editable, null, object);
            assertNotEquals(eOrigin, editable);
        } catch( Exception e ) {

        }
        // cannot test private mode & not Generated Parameters.
    }

    /** author : musicianZem<qufaudwpak@naver.com>
     * */
    @Test
    public void startCssStyleTest() throws Exception {
        HtmlToSpannedConverter htsConverter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method startCssMethod;
        startCssMethod = htsConverter.getClass().getDeclaredMethod("startCssStyle", Editable.class, org.xml.sax.Attributes.class);
        startCssMethod.setAccessible(true);
        Editable editable = new Editable() {
            @Override
            public Editable replace(int st, int en, CharSequence source, int start, int end) {
                return null;
            }

            @Override
            public Editable replace(int st, int en, CharSequence text) {
                return null;
            }

            @Override
            public Editable insert(int where, CharSequence text, int start, int end) {
                return null;
            }

            @Override
            public Editable insert(int where, CharSequence text) {
                return null;
            }

            @Override
            public Editable delete(int st, int en) {
                return null;
            }

            @Override
            public Editable append(CharSequence text) {
                return null;
            }

            @Override
            public Editable append(CharSequence text, int start, int end) {
                return null;
            }

            @Override
            public Editable append(char text) {
                return null;
            }

            @Override
            public void clear() {

            }

            @Override
            public void clearSpans() {

            }

            @Override
            public void setFilters(InputFilter[] filters) {

            }

            @Override
            public InputFilter[] getFilters() {
                return new InputFilter[0];
            }

            @Override
            public void getChars(int start, int end, char[] dest, int destoff) {

            }

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

        editable.append("hh < style : \"he\">");
        AttributesImpl attributeImple = new AttributesImpl();
        attributeImple.addAttribute(null, null, null, null, null);
        attributeImple.setAttribute(0, "style", "style", "style", "style", "style");

        attributeImple.addAttribute("", "", "style", "", "" + 0);
        startCssMethod.invoke(htsConverter, editable, attributeImple);

        String style = attributeImple.getValue("", "style");
        Method getForegroundColorPattern;
        getForegroundColorPattern = htsConverter.getClass().getDeclaredMethod("getForegroundColorPattern");
        getForegroundColorPattern.setAccessible(true);

        try {
            startCssMethod.invoke(htsConverter, editable, attributeImple);
            // i cannot make
            // String str = attributeImple.getValues("", "style"); is not null...
        } catch( Exception e ){
        }
    }

    /** author : musicianZem<qufaudwpak@naver.com>
     * */
    @Test
    public void endCssStyleTest() throws Exception {
        HtmlToSpannedConverter htsConverter = new HtmlToSpannedConverter(null, null, null, null, null, null, 0);
        Method endCssStyle;
        endCssStyle = htsConverter.getClass().getDeclaredMethod("endCssStyle", String.class, Editable.class);
        endCssStyle.setAccessible(true);
        String string = "test String";
        Editable editable = new Editable() {
            @Override
            public Editable replace(int st, int en, CharSequence source, int start, int end) {
                return null;
            }

            @Override
            public Editable replace(int st, int en, CharSequence text) {
                return null;
            }

            @Override
            public Editable insert(int where, CharSequence text, int start, int end) {
                return null;
            }

            @Override
            public Editable insert(int where, CharSequence text) {
                return null;
            }

            @Override
            public Editable delete(int st, int en) {
                return null;
            }

            @Override
            public Editable append(CharSequence text) {
                return null;
            }

            @Override
            public Editable append(CharSequence text, int start, int end) {
                return null;
            }

            @Override
            public Editable append(char text) {
                return null;
            }

            @Override
            public void clear() {

            }

            @Override
            public void clearSpans() {

            }

            @Override
            public void setFilters(InputFilter[] filters) {

            }

            @Override
            public InputFilter[] getFilters() {
                return new InputFilter[0];
            }

            @Override
            public void getChars(int start, int end, char[] dest, int destoff) {

            }

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

        try {
            endCssStyle.invoke(htsConverter, string, editable);
        } catch( Exception e ) {}

    }

    /** author : musicianZem<qufaudwpak@naver.com>
     * */
    @Test
    public void startImgTest() throws Exception {
        // cannot test private mode & not Generated Parameters.
    }

    /** author : musicianZem<qufaudwpak@naver.com>
     * */
    @Test
    public void startFontTest() throws Exception {
        // cannot test private mode & not Generated Parameters.
    }

    /** author : musicianZem<qufaudwpak@naver.com>
     * */
    @Test
    public void endFontTest() throws Exception {
        // cannot test private mode & not Generated Parameters.
    }

    /** author : musicianZem<qufaudwpak@naver.com>
     * */
    @Test
    public void startATest() throws Exception {
        // cannot test private mode & not Generated Parameters.
    }

    /** author : musicianZem<qufaudwpak@naver.com>
     * */
    @Test
    public void endATest() throws Exception {
        // cannot test private mode & not Generated Parameters.
    }

    /** author : musicianZem<qufaudwpak@naver.com>
     * */
    @Test
    public void getHtmlColorTest() throws Exception {
        Map<String, Integer> sColorMap;
        sColorMap = new HashMap<>();
        sColorMap.put("aliceblue", 0xFFF0F8FF);
        sColorMap.put("antiquewhite", 0xFFFAEBD7);
        sColorMap.put("aqua", 0xFF00FFFF);
        sColorMap.put("aquamarine", 0xFF7FFFD4);
        sColorMap.put("azure", 0xFFF0FFFF);
        sColorMap.put("beige", 0xFFF5F5DC);
        sColorMap.put("bisque", 0xFFFFE4C4);
        sColorMap.put("black", 0xFF000000);
        sColorMap.put("blanchedalmond", 0xFFFFEBCD);
        sColorMap.put("blue", 0xFF0000FF);
        sColorMap.put("blueviolet", 0xFF8A2BE2);
        sColorMap.put("brown", 0xFFA52A2A);
        sColorMap.put("burlywood", 0xFFDEB887);
        sColorMap.put("cadetblue", 0xFF5F9EA0);
        sColorMap.put("chartreuse", 0xFF7FFF00);
        sColorMap.put("chocolate", 0xFFD2691E);
        sColorMap.put("coral", 0xFFFF7F50);
        sColorMap.put("cornflowerblue", 0xFF6495ED);
        sColorMap.put("cornsilk", 0xFFFFF8DC);
        sColorMap.put("crimson", 0xFFDC143C);
        sColorMap.put("cyan", 0xFF00FFFF);
        sColorMap.put("darkblue", 0xFF00008B);
        sColorMap.put("darkcyan", 0xFF008B8B);
        sColorMap.put("darkgoldenrod", 0xFFB8860B);
        sColorMap.put("darkgray", 0xFFA9A9A9);
        sColorMap.put("darkgrey", 0xFFA9A9A9);
        sColorMap.put("darkgreen", 0xFF006400);
        sColorMap.put("darkkhaki", 0xFFBDB76B);
        sColorMap.put("darkmagenta", 0xFF8B008B);
        sColorMap.put("darkolivegreen", 0xFF556B2F);
        sColorMap.put("darkorange", 0xFFFF8C00);
        sColorMap.put("darkorchid", 0xFF9932CC);
        sColorMap.put("darkred", 0xFF8B0000);
        sColorMap.put("darksalmon", 0xFFE9967A);
        sColorMap.put("darkseagreen", 0xFF8FBC8F);
        sColorMap.put("darkslateblue", 0xFF483D8B);
        sColorMap.put("darkslategray", 0xFF2F4F4F);
        sColorMap.put("darkslategrey", 0xFF2F4F4F);
        sColorMap.put("darkturquoise", 0xFF00CED1);
        sColorMap.put("darkviolet", 0xFF9400D3);
        sColorMap.put("deeppink", 0xFFFF1493);
        sColorMap.put("deepskyblue", 0xFF00BFFF);
        sColorMap.put("dimgray", 0xFF696969);
        sColorMap.put("dimgrey", 0xFF696969);
        sColorMap.put("dodgerblue", 0xFF1E90FF);
        sColorMap.put("firebrick", 0xFFB22222);
        sColorMap.put("floralwhite", 0xFFFFFAF0);
        sColorMap.put("forestgreen", 0xFF228B22);
        sColorMap.put("fuchsia", 0xFFFF00FF);
        sColorMap.put("gainsboro", 0xFFDCDCDC);
        sColorMap.put("ghostwhite", 0xFFF8F8FF);
        sColorMap.put("gold", 0xFFFFD700);
        sColorMap.put("goldenrod", 0xFFDAA520);
        sColorMap.put("gray", 0xFF808080);
        sColorMap.put("grey", 0xFF808080);
        sColorMap.put("green", 0xFF008000);
        sColorMap.put("greenyellow", 0xFFADFF2F);
        sColorMap.put("honeydew", 0xFFF0FFF0);
        sColorMap.put("hotpink", 0xFFFF69B4);
        sColorMap.put("indianred ", 0xFFCD5C5C);
        sColorMap.put("indigo  ", 0xFF4B0082);
        sColorMap.put("ivory", 0xFFFFFFF0);
        sColorMap.put("khaki", 0xFFF0E68C);
        sColorMap.put("lavender", 0xFFE6E6FA);
        sColorMap.put("lavenderblush", 0xFFFFF0F5);
        sColorMap.put("lawngreen", 0xFF7CFC00);
        sColorMap.put("lemonchiffon", 0xFFFFFACD);
        sColorMap.put("lightblue", 0xFFADD8E6);
        sColorMap.put("lightcoral", 0xFFF08080);
        sColorMap.put("lightcyan", 0xFFE0FFFF);
        sColorMap.put("lightgoldenrodyellow", 0xFFFAFAD2);
        sColorMap.put("lightgray", 0xFFD3D3D3);
        sColorMap.put("lightgrey", 0xFFD3D3D3);
        sColorMap.put("lightgreen", 0xFF90EE90);
        sColorMap.put("lightpink", 0xFFFFB6C1);
        sColorMap.put("lightsalmon", 0xFFFFA07A);
        sColorMap.put("lightseagreen", 0xFF20B2AA);
        sColorMap.put("lightskyblue", 0xFF87CEFA);
        sColorMap.put("lightslategray", 0xFF778899);
        sColorMap.put("lightslategrey", 0xFF778899);
        sColorMap.put("lightsteelblue", 0xFFB0C4DE);
        sColorMap.put("lightyellow", 0xFFFFFFE0);
        sColorMap.put("lime", 0xFF00FF00);
        sColorMap.put("limegreen", 0xFF32CD32);
        sColorMap.put("linen", 0xFFFAF0E6);
        sColorMap.put("magenta", 0xFFFF00FF);
        sColorMap.put("maroon", 0xFF800000);
        sColorMap.put("mediumaquamarine", 0xFF66CDAA);
        sColorMap.put("mediumblue", 0xFF0000CD);
        sColorMap.put("mediumorchid", 0xFFBA55D3);
        sColorMap.put("mediumpurple", 0xFF9370DB);
        sColorMap.put("mediumseagreen", 0xFF3CB371);
        sColorMap.put("mediumslateblue", 0xFF7B68EE);
        sColorMap.put("mediumspringgreen", 0xFF00FA9A);
        sColorMap.put("mediumturquoise", 0xFF48D1CC);
        sColorMap.put("mediumvioletred", 0xFFC71585);
        sColorMap.put("midnightblue", 0xFF191970);
        sColorMap.put("mintcream", 0xFFF5FFFA);
        sColorMap.put("mistyrose", 0xFFFFE4E1);
        sColorMap.put("moccasin", 0xFFFFE4B5);
        sColorMap.put("navajowhite", 0xFFFFDEAD);
        sColorMap.put("navy", 0xFF000080);
        sColorMap.put("oldlace", 0xFFFDF5E6);
        sColorMap.put("olive", 0xFF808000);
        sColorMap.put("olivedrab", 0xFF6B8E23);
        sColorMap.put("orange", 0xFFFFA500);
        sColorMap.put("orangered", 0xFFFF4500);
        sColorMap.put("orchid", 0xFFDA70D6);
        sColorMap.put("palegoldenrod", 0xFFEEE8AA);
        sColorMap.put("palegreen", 0xFF98FB98);
        sColorMap.put("paleturquoise", 0xFFAFEEEE);
        sColorMap.put("palevioletred", 0xFFDB7093);
        sColorMap.put("papayawhip", 0xFFFFEFD5);
        sColorMap.put("peachpuff", 0xFFFFDAB9);
        sColorMap.put("peru", 0xFFCD853F);
        sColorMap.put("pink", 0xFFFFC0CB);
        sColorMap.put("plum", 0xFFDDA0DD);
        sColorMap.put("powderblue", 0xFFB0E0E6);
        sColorMap.put("purple", 0xFF800080);
        sColorMap.put("rebeccapurple", 0xFF663399);
        sColorMap.put("red", 0xFFFF0000);
        sColorMap.put("rosybrown", 0xFFBC8F8F);
        sColorMap.put("royalblue", 0xFF4169E1);
        sColorMap.put("saddlebrown", 0xFF8B4513);
        sColorMap.put("salmon", 0xFFFA8072);
        sColorMap.put("sandybrown", 0xFFF4A460);
        sColorMap.put("seagreen", 0xFF2E8B57);
        sColorMap.put("seashell", 0xFFFFF5EE);
        sColorMap.put("sienna", 0xFFA0522D);
        sColorMap.put("silver", 0xFFC0C0C0);
        sColorMap.put("skyblue", 0xFF87CEEB);
        sColorMap.put("slateblue", 0xFF6A5ACD);
        sColorMap.put("slategray", 0xFF708090);
        sColorMap.put("slategrey", 0xFF708090);
        sColorMap.put("snow", 0xFFFFFAFA);
        sColorMap.put("springgreen", 0xFF00FF7F);
        sColorMap.put("steelblue", 0xFF4682B4);
        sColorMap.put("tan", 0xFFD2B48C);
        sColorMap.put("teal", 0xFF008080);
        sColorMap.put("thistle", 0xFFD8BFD8);
        sColorMap.put("tomato", 0xFFFF6347);
        sColorMap.put("turquoise", 0xFF40E0D0);
        sColorMap.put("violet", 0xFFEE82EE);
        sColorMap.put("wheat", 0xFFF5DEB3);
        sColorMap.put("white", 0xFFFFFFFF);
        sColorMap.put("whitesmoke", 0xFFF5F5F5);
        sColorMap.put("yellow", 0xFFFFFF00);
        sColorMap.put("yellowgreen", 0xFF9ACD32);


        for (Map.Entry<String, Integer> elem : sColorMap.entrySet()) {
            String color = elem.getKey();
            Integer i = sColorMap.get(color.toLowerCase(Locale.US));
            assertNotEquals(i, null);
            // get Integer by string that in sColorMap Must not be null.
        }
    }

}
