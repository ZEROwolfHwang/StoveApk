package com.tenvine.stoveapk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.leon.channel.helper.ChannelReaderUtil;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.channel);
        String channel = ChannelReaderUtil.getChannel(getApplicationContext());
        mTextView.setText(channel);
    }
}
