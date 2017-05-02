package com.feicuiedu.butterknife_20170502;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 1. 添加依赖：
 * compile 'com.jakewharton:butterknife:8.5.1'
 * annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1'
 * <p>
 * 版本在2.2 以下
 * 1. 项目的build.gradle里面：
 * // 使用"android-apt"插件，用于ButterKnife
 * classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
 * 2. app模块的build.gradle里面：
 * compile 'com.jakewharton:butterknife:8.4.0'
 * apt 'com.jakewharton:butterknife-compiler:8.4.0'
 * 3. 顶部添加：apply plugin: 'android-apt'
 * <p>
 * 2. 绑定控件
 * 使用Butterknife，一定要记得Butterknife.bind();
 *
 * @BindView(int) TextView tvShow
 * <p>
 * 3. 绑定资源:通过调用不同的注解，完成不同的绑定
 * @BindColor、@BindString等 介绍一个小工具：插件
 * Butterknife zelezny插件
 * 下载的位置：settings--plugins--搜索Butterknife zelezny
 * 使用：点击到布局上，alt+insert，快速的生成控件绑定和监听
 */
public class MainActivity extends AppCompatActivity {

    // 绑定控件
    @BindView(R.id.tvShow)
    TextView mTextView;
    @BindView(R.id.btnShow)
    Button mBtnShow;

    // 绑定资源:通过调用不同的注解，完成不同的绑定
    @BindColor(R.color.colorAccent)
    int color;
    @BindString(R.string.app_name)
    String appName;
    @BindDimen(R.dimen.activity_horizontal_margin)
    float margin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 绑定当前的视图
        ButterKnife.bind(this);

//        TextView textView = (TextView) findViewById(R.id.tvShow);
//        Button button = (Button) findViewById(R.id.btnShow);

        // 之前绑定资源
//        int color = getResources().getColor(R.color.colorAccent);
//        String string = getResources().getString(R.string.app_name);

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(appName);
                mTextView.setTextColor(color);
            }
        });

    }
}
