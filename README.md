# HtmlCompat
Compatibility library for Android's Html class.

## Why?

Nougat introduced vast improvements to the `Html` class for converting HTML to spannables. Unfortunately, these new features lay within the Android SDK itself. This means that the behavior in which HTML is converted is subject to the version of Android that the user is running.

HtmlCompat attempts to address this problem by providing developers with a compatibility library. All logic for converting HTML is enclosed within this library and can be bundled within an app. This means that the presentation is agnostic to the version of Android of the device.

## How can I use it?

Gradle:

    compile 'com.pixplicity.htmlcompat:library:1.0'

Java:

    Spanned fromHtml = HtmlCompat.fromHtml(context, source, 0);
    // You may want to provide an ImageGetter, TagHandler and SpanCallback:
    //Spanned fromHtml = HtmlCompat.fromHtml(context, source, 0,
    //        imageGetter, tagHandler, spanCallback);
    textView.setMovementMethod(LinkMovementMethod.getInstance());
    textView.setText(fromHtml);


## What’s supported?

All the latest functionality from the current `Html` for Android Nougat is included in this library. While this may continue to be improved in the future, currently, the following tags are supported out of the box:

*   `<br>`
*   `<p>`
*   `<ul>`
*   `<li>`
*   `<div>`
*   `<span>`
*   `<strong>`, `<b>`
*   `<em>`, `<i>`
*   `<u>`
*   `<s>`, `<strike>`, `<del>`
*   `<cite>`
*   `<dfn>`
*   `<big>`
*   `<small>`
*   `<font>`
*   `<blockquote>`
*   `<tt>`
*   `<a>`
*   `<sup>`
*   `<sub>`
*   `<h1>`, `<h2>`, `<h3>`, `<h4>`, `<h5>`, `<h6>`
*   `<img>`

The following CSS inline styles are supported:

*   `text-align`
*   `color`
*   `background`, `background-color`
*   `text-decoration`

All CSS color declarations [as defined here](https://www.w3schools.com/cssref/css_colors.asp) are supported.

## What’s added?

A few new features have been added to the interface to ease the life of the developer:

*   Callbacks into ImageGetter and TagHandler provide the tag attributes;
*   SpanCallback can be registered so the implementor may be informed of new spans; this allows for spans to be modified;
*   All CSS color declarations have been added.

## What’s next?

We’re looking to support more tags and styles in future releases. Feel free to contribute with pull requests or by reporting issues on [the GitHub project page](https://github.com/pixplicity/HtmlCompat).

[Made with ❤ by Pixplicity](https://pixplicity.com)
