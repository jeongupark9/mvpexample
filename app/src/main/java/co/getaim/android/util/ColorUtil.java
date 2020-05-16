package co.getaim.android.util;

/**
 * Created by arange on 2017. 11. 20..
 */

public class ColorUtil {

    public static int fadeColor(int start, int end, float ratio) {
        int sr = (start & 0xff0000) >> 16;
        int sg = (start & 0x00ff00) >> 8;
        int sb = (start & 0x0000ff);

        int dr = (end & 0xff0000) >> 16;
        int dg = (end & 0x00ff00) >> 8;
        int db = (end & 0x0000ff);

        int r = (int) (((1 - ratio) * sr) + (ratio * dr));
        int g = (int) (((1 - ratio) * sg) + (ratio * dg));
        int b = (int) (((1 - ratio) * sb) + (ratio * db));

        int ret = 0xff000000 | r << 16 | g << 8 | b;
        return ret;
    }


    public static int fadeAlphaColor(int color, int alpha) {
        int a = (alpha & 0xff000000) >> 24;
        int r = (color & 0xff0000) >> 16;
        int g = (color & 0x00ff00) >> 8;
        int b = (color & 0x0000ff);
        int ret = a << 24 | r << 16 | g << 8 | b;
        return ret;
    }

    public static int getHexAlpha(float alpha){
        String hex = "";
        int rounded = (int) Math.round(alpha * 255);
        hex = Integer.toHexString(rounded);
        if (hex.length() == 1) hex = "0" + hex;
        int a = Integer.parseInt(hex, 16);
        return a << 24;
    }
}
