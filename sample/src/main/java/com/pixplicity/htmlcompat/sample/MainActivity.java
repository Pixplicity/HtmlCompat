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
import android.text.method.LinkMovementMethod;
import android.text.style.BulletSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.pixplicity.htmlcompat.HtmlCompat;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mTvHello;

    private int mBulletGapWidth;

    private boolean mUseNative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvHello = findViewById(R.id.tv_hello);

        mBulletGapWidth = getResources().getDimensionPixelOffset(R.dimen.bullet_gap_width);

        update();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        mUseNative = menu.findItem(R.id.action_native).isChecked();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_native:
                mUseNative = !item.isChecked();
                item.setChecked(mUseNative);
                update();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void update() {
        Spanned fromHtml;
        String source = getString(R.string.html);
        if (mUseNative) {
            Html.ImageGetter imageGetter = new Html.ImageGetter() {
                @Override
                public Drawable getDrawable(String source) {
                    return MainActivity.this.getDrawable(source, null);
                }
            };
            Html.TagHandler tagHandler = new Html.TagHandler() {
                @Override
                public void handleTag(boolean opening, String tag, Editable output,
                                      XMLReader xmlReader) {
                    MainActivity.this.handleTag(opening, tag, null, output, xmlReader);
                }
            };
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                fromHtml = Html.fromHtml(source, 0, imageGetter, tagHandler);
            } else {
                fromHtml = Html.fromHtml(source, imageGetter, tagHandler);
            }
        } else {
            HtmlCompat.ImageGetter imageGetter = new HtmlCompat.ImageGetter() {
                @Override
                public Drawable getDrawable(String source, Attributes attributes) {
                    return MainActivity.this.getDrawable(source, attributes);
                }
            };
            HtmlCompat.TagHandler tagHandler = new HtmlCompat.TagHandler() {
                @Override
                public void handleTag(boolean opening, String tag, Attributes attributes,
                                      Editable output, XMLReader xmlReader) {
                    MainActivity.this.handleTag(opening, tag, attributes, output, xmlReader);
                }
            };
            HtmlCompat.SpanCallback spanCallback = new HtmlCompat.SpanCallback() {
                @Override
                public Object onSpanCreated(String tag, Object span) {
                    Log.d(TAG, "New span for <" + tag + ">: " + span);
                    if (span instanceof BulletSpan) {
                        return new BulletSpan(mBulletGapWidth);
                    }
                    return span;
                }
            };
            fromHtml = HtmlCompat.fromHtml(this, source,
                    HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM,
                    imageGetter, tagHandler, spanCallback);
        }
        mTvHello.setMovementMethod(LinkMovementMethod.getInstance());
        mTvHello.setText(fromHtml);
    }

    private Drawable getDrawable(String source, Attributes attributes) {
        Resources resources = getResources();
        int drawableId = resources.getIdentifier(source, "drawable", getPackageName());
        Drawable drawable = ContextCompat.getDrawable(this, drawableId);
        if (drawable != null) {
            int width, height;
            if (attributes == null) {
                width = drawable.getIntrinsicWidth();
                height = drawable.getIntrinsicHeight();
            } else {
                width = Integer.parseInt(attributes.getValue("width"));
                width = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, resources.getDisplayMetrics()));
                float ratio = (float) width / (float) drawable.getIntrinsicWidth();
                height = (int) (drawable.getIntrinsicHeight() * ratio);
            }
            drawable.setBounds(0, 0, width, height);
        }
        return drawable;
    }

    public void handleTag(boolean opening, String tag, Attributes attributes, Editable output,
                          XMLReader xmlReader) {
        // Manipulate the output here for otherwise unsupported tags
        Log.d(TAG, "Unhandled tag <" + tag + ">");
    }

}
