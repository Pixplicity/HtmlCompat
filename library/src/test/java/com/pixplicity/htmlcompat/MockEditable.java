package com.pixplicity.htmlcompat;

import android.text.Editable;
import android.text.InputFilter;

/**
 * Created by 소령이 on 2017-04-03.
 */

public class MockEditable implements Editable {
    String str;
    public MockEditable(String str) {
        this.str = str;
    }
    @Override
    public int length() {
        return str.length();
    }
    @Override
    public String toString() {
        return str;
    }
    @Override
    public char charAt(int index) {
        return str.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

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

    public Editable append(CharSequence charSequence) {
        str = str+charSequence;
        return this;
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
}
