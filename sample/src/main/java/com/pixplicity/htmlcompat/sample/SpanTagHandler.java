package com.pixplicity.htmlcompat.sample;

import com.pixplicity.htmlcompat.HtmlCompat;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;

class SpanTagHandler implements HtmlCompat.TagHandler {

    private String mAttribute;

    @Override
    public void handleTag(boolean opening, String tag, Attributes attributes, Editable output, XMLReader xmlReader) {
        if (opening) {
            if (attributes.getValue("class") != null) {
                mAttribute = attributes.getValue("class");

                if (mAttribute.equals("tl-dr")) {
                    start(SpannableStringBuilder.valueOf(output), new Bold());
                }
            }
        } else {
            if(mAttribute != null) {
                if (mAttribute.equals("tl-dr")) {
                    end((SpannableStringBuilder) output, Bold.class, new StyleSpan(Typeface.BOLD));
                }

                mAttribute = null;
            }
        }
    }

    private void start(SpannableStringBuilder text, Object mark) {
        int len = text.length();
        text.setSpan(mark, len, len, Spannable.SPAN_MARK_MARK);
    }

    private static void end(SpannableStringBuilder text, Class kind, Object repl) {
        int len = text.length();
        Object obj = getLast(text, kind);
        int where = text.getSpanStart(obj);

        text.removeSpan(obj);

        if (where != len) {
            text.setSpan(repl, where, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private static Object getLast(Spanned text, Class kind) {
        /*
         * This knows that the last returned object from getSpans()
         * will be the most recently added.
         */
        Object[] objs = text.getSpans(0, text.length(), kind);

        if (objs.length == 0) {
            return null;
        } else {
            return objs[objs.length - 1];
        }
    }

    private static class Bold {}
}
