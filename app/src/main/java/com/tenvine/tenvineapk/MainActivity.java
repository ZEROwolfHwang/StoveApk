package com.tenvine.tenvineapk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tenvine.channel.helper.ChannelReaderUtil;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // default channel :  10#星空屋
        TextView mTextView = findViewById(R.id.channel);
        String channel = ChannelReaderUtil.getChannel(getApplicationContext());

        mTextView.setText("channel代号: "+channel);
    }
}
