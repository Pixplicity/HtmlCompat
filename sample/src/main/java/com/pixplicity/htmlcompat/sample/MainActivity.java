package com.pixplicity.htmlcompat.sample;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;

import com.pixplicity.htmlcompat.HtmlCompat;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public static final boolean USE_NATIVE = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHello = (TextView) findViewById(R.id.tv_hello);

        Spanned fromHtml;
        if (USE_NATIVE && Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.ImageGetter imageGetter = new Html.ImageGetter() {
                @Override
                public Drawable getDrawable(String source) {
                    return MainActivity.this.getDrawable(source, null);
                }
            };
            Html.TagHandler tagHandler = new Html.TagHandler() {
                @Override
                public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
                    MainActivity.this.handleTag(opening, tag, null, output, xmlReader);
                }
            };
            fromHtml = Html.fromHtml(getString(R.string.html), 0, imageGetter, tagHandler);
        } else {
            HtmlCompat.ImageGetter imageGetter = new HtmlCompat.ImageGetter() {
                @Override
                public Drawable getDrawable(String source, Attributes attributes) {
                    return MainActivity.this.getDrawable(source, attributes);
                }
            };
            HtmlCompat.TagHandler tagHandler = new HtmlCompat.TagHandler() {
                @Override
                public void handleTag(boolean opening, String tag, Attributes attributes, Editable output, XMLReader xmlReader) {
                    MainActivity.this.handleTag(opening, tag, attributes, output, xmlReader);
                }
            };
            fromHtml = HtmlCompat.fromHtml(getString(R.string.html), 0, imageGetter, tagHandler);
        }
        tvHello.setText(fromHtml);
    }

    private Drawable getDrawable(String source, Attributes attributes) {
        Resources resources = getResources();
        int drawableId = resources.getIdentifier(source, "drawable", getPackageName());
        Drawable drawable = ContextCompat.getDrawable(this, drawableId);
        if (drawable != null) {
            int width = Integer.parseInt(attributes.getValue("width"));
            float ratio = (float) width / (float) drawable.getIntrinsicWidth();
            int height = (int) (drawable.getIntrinsicHeight() * ratio);
            drawable.setBounds(0, 0, width, height);
        }
        return drawable;
    }

    public void handleTag(boolean opening, String tag, Attributes attributes, Editable output, XMLReader xmlReader) {
        // Manipulate the output here for otherwise unsupported tags
        Log.d(TAG, "Unhandled tag: " + tag);
    }

}
