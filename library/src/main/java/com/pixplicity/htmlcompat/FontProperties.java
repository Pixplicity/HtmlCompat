package com.pixplicity.htmlcompat;

import android.text.Layout;

/**
 * Created by admin on 2017-05-07.
 */

public class FontProperties {

    static class Bold {}

    static class Italic {}

    static class Underline {}

    static class Strikethrough {}

    static class Big {}

    static class Small {}

    static class Monospace {}

    static class Blockquote {}

    static class Super {}

    static class Sub {}

    static class Bullet {}

    static class Font {
        String mFace;

        Font(String face) {
            mFace = face;
        }
    }

    static class Href {
        String mHref;

        Href(String href) {
            mHref = href;
        }
    }

    static class Foreground {
        private int mForegroundColor;

        Foreground(int foregroundColor) {
            mForegroundColor = foregroundColor;
        }

        public int getmForegroundColor(){
            return mForegroundColor;
        }
    }

    static class Background {
        private int mBackgroundColor;

        Background(int backgroundColor) {
            mBackgroundColor = backgroundColor;
        }

        public int getmBackgroundColor(){
            return mBackgroundColor;
        }
    }

    static class Heading {
        private int mLevel;

        Heading(int level) {
            mLevel = level;
        }

        public int getmLevel(){
            return mLevel;
        }
    }

    static class Newline {
        private int mNumNewlines;

        Newline(int numNewlines) {
            mNumNewlines = numNewlines;
        }

        public int getmNumNewlines(){
            return mNumNewlines;
        }
    }

    static class Alignment {
        private Layout.Alignment mAlignment;

        Alignment(Layout.Alignment alignment) {
            mAlignment = alignment;
        }

        public Layout.Alignment getmAlignment(){
            return mAlignment;
        }
    }
}
