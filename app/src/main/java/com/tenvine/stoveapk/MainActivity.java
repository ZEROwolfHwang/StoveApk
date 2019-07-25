package com.tenvine.stoveapk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tenvine.channel.helper.ChannelReaderUtil;

import java.nio.ByteBuffer;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

//    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mTextView = findViewById(R.id.channel);
        String channel = ChannelReaderUtil.getChannel(getApplicationContext());
        mTextView.setText(channel);

        TextView getAllIdValueMap = findViewById(R.id.getAllIdValueMap);
        Map<Integer, ByteBuffer> allIdValueMap = ChannelReaderUtil.getAllIdValueMap(getApplicationContext());
        getAllIdValueMap.setText(allIdValueMap.toString());

//        TextView getApkPath = findViewById(R.id.getApkPath);
//        String apkPath = ChannelReaderUtil.getApkPath(getApplicationContext());
//        getApkPath.setText(apkPath);


    }
}
