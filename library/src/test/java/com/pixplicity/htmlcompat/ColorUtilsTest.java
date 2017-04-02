package com.pixplicity.htmlcompat;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.CYAN;
import static android.graphics.Color.DKGRAY;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.LTGRAY;
import static android.graphics.Color.MAGENTA;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

/**
 * Created by zaiha on 2017-03-30.
 */

public class ColorUtilsTest {
    /*
    * author : gayoung
    * description : construct Color
    * Input : null
    * return : -1
    * description : try-catch doesn't work.
    * */
    @Test//(expected=  NullPointerException.class)
    public void Colornull() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(C.getHtmlColor(null), -1);
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : black
    * return : BLACK
    * */
    @Test
    public void ColorBlack() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(BLACK, C.getHtmlColor("black"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : darkgray
    * return : DKGRAY
    * */
    @Test
    public void Colordarkgray() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(DKGRAY, C.getHtmlColor("darkgray"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : gray
    * return : GRAY
    * */
    @Test
    public void Colorgray() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(GRAY, C.getHtmlColor("gray"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : lightgray
    * return : LTGRAY
    * */
    @Test
    public void Colorlightgray() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(LTGRAY, C.getHtmlColor("lightgray"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : white
    * return : WHITE
    * */
    @Test
    public void Colorwhite() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(WHITE, C.getHtmlColor("white"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : red
    * return : RED
    * */
    @Test
    public void Colorred() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(RED, C.getHtmlColor("red"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : green
    * return : GREEN
    * */
    @Test
    public void Colorgreen() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(GREEN, C.getHtmlColor("green"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : blue
    * return : BLUE
    * */
    @Test
    public void Colorblue() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(BLUE, C.getHtmlColor("blue"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : yellow
    * return : YELLOW
    * */
    @Test
    public void Coloryellow() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(YELLOW, C.getHtmlColor("yellow"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : cyan
    * return : CYAN
    * */
    @Test
    public void Colorcyan() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(CYAN, C.getHtmlColor("cyan"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : magenta
    * return : MAGENTA
    * */
    @Test
    public void Colormagenta() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(MAGENTA, C.getHtmlColor("magenta"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : aqua
    * return : 0xFF00FFFF
    * */
    @Test
    public void Coloraqua() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(0xFF00FFFF, C.getHtmlColor("aqua"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : fuchsia
    * return : 0xFFFF00FF
    * */
    @Test
    public void Colorfuchsia() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(0xFFFF00FF, C.getHtmlColor("fuchsia"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : darkgrey
    * return : DKGRAY
    * */
    @Test
    public void Colordarkgrey() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(DKGRAY, C.getHtmlColor("darkgrey"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : grey
    * return : GRAY
    * */
    @Test
    public void Colorgrey() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(GRAY, C.getHtmlColor("grey"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : lightgrey
    * return : LTGRAY
    * */
    @Test
    public void Colorlightgrey() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(LTGRAY, C.getHtmlColor("lightgrey"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : lime
    * return : 0xFF00FF00
    * */
    @Test
    public void Colorlime() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(0xFF00FF00, C.getHtmlColor("lime"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : maroon
    * return : 0xFF800000
    * */
    @Test
    public void Colormaroon() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(0xFF800000, C.getHtmlColor("maroon"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : navy
    * return : 0xFF000080
    * */
    @Test
    public void Colornavy() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(0xFF000080, C.getHtmlColor("navy"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : olive
    * return : 0xFF808000
    * */
    @Test
    public void Colorolive() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(0xFF808000, C.getHtmlColor("olive"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : purple
    * return : 0xFF800080
    * */
    @Test
    public void Colorpurple() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(0xFF800080, C.getHtmlColor("purple"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : silver
    * return : 0xFFC0C0C0
    * */
    @Test
    public void Colorsilver() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(0xFFC0C0C0, C.getHtmlColor("silver"));
    }
    /*
    * author : gayoung
    * description : test colors in hashmap
    * input : teal
    * return : 0xFF008080
    * */
    @Test
    public void Colorteal() throws Exception {
        ColorUtils C = new ColorUtils();
        assertEquals(0xFF008080, C.getHtmlColor("teal"));
    }


}
