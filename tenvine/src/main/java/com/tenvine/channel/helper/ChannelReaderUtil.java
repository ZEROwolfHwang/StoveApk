
package com.tenvine.channel.helper;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;

import com.tenvine.channel.reader.ChannelReader;
import com.tenvine.channel.reader.IdValueReader;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.Map;


public class ChannelReaderUtil {
    private static final String TAG = "ChannelReaderUtil";
    private static String mChannelCache;


    public static String getChannel(Context context) {
        if (mChannelCache == null) {
            String channel = getChannelByV2(context);
            if (channel == null) {
                channel = getChannelByV1(context);
            }
            mChannelCache = channel;
        }
        return mChannelCache;
    }

    /**
     * if apk use v2 signature , please use this method to get channel info
     *
     * @param context
     * @return
     */
    public static String getChannelByV2(Context context) {
        String apkPath = getApkPath(context);
        String channel = ChannelReader.getChannelByV2(new File(apkPath));
        Log.i(TAG, "getChannelByV2 , channel = " + channel);
        if (channel != null) {
            return channel;
        }
        return "10";
    }

    /**
     * if apk only use v1 signature , please use this method to get channel info
     *
     * @param context
     * @return
     */
    public static String getChannelByV1(Context context) {
        String apkPath = getApkPath(context);
        String channel = ChannelReader.getChannelByV1(new File(apkPath));
        Log.i(TAG, "getChannelByV1 , channel = " + channel);
        if (channel != null) {
            return channel;
        }
        return "10";
    }


    /**
     * get String value from apk by id in the v2 signature mode
     *
     * @param context
     * @param id
     * @return
     */
    public static String getStringValueById(Context context, int id) {
        String apkPath = getApkPath(context);
        String value = IdValueReader.getStringValueById(new File(apkPath), id);
        Log.i(TAG, "id = " + id + " , value = " + value);
        return value;
    }

    /**
     * get byte[] from apk by id in the v2 signature mode
     *
     * @param context
     * @param id
     * @return
     */
    public static byte[] getByteValueById(Context context, int id) {
        String apkPath = getApkPath(context);
        return IdValueReader.getByteValueById(new File(apkPath), id);
    }

    /**
     * find all Id-Value Pair from Apk in the v2 signature mode
     *
     * @param context
     * @return
     */
    public static Map<Integer, ByteBuffer> getAllIdValueMap(Context context) {
        String apkPath = getApkPath(context);
        return IdValueReader.getAllIdValueMap(new File(apkPath));
    }

    /**
     * 获取已安装的APK路径
     *
     * @param context
     * @return
     */
    private static String getApkPath(Context context) {
        String apkPath = null;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            } else {
                apkPath = applicationInfo.sourceDir;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return apkPath;
    }
}
