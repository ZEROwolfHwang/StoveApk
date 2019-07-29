
## Installation
> ### channelVersion v1.1
```
git clone https://github.com/ZEROwolfHwang/TenvineApk.git
```

## Setup

```
将 TenvineApk/app/libs 目录下的 tenvine-channel-v1.1.aar 引入工程项目中的 libs/ 文件夹下

在app目录下的build.gradle中添加依赖:

    1. 在android{}节点中添加:
        repositories {
            flatDir {
                dirs 'libs'
            }
        }
        
    2. 然后在dependencies{}节点中添加:
        
        implementation (name: 'tenvine-channel-v1.1', ext: 'aar')
```

## Basic Usage

```
import com.tenvine.channel.helper.ChannelReaderUtil;

TextView mTextView = findViewById(R.id.channel);
String channel = ChannelReaderUtil.getChannel(getApplicationContext());
mTextView.setText("channelCode: "+channel);
```

