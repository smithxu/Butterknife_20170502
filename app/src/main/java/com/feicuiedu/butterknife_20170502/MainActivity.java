package com.feicuiedu.butterknife_20170502;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.Unbinder;

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
 * @BindColor、@BindString等
 *
 * 4. 绑定视图列表：
 * @BindViews(int[]) 操作：Butterknife.apply()
 * <p>
 * 5. 监听的绑定
 *
 *      @OnClick(int) 单个
 *      @OnClick({XX,XX}) 多个控件
 *      @OnItemClick()等
 *      注意：设置的监听一定是该控件具有的，不然会报错
 *
 * 6. 绑定的重置
 *      Unbinder mUnbinder = Butterknife.bind();
 *      mUnbinder.unbind()
 *
 * 7. 无法直接绑定的：Butterknife.findById();
 *
 * <p>
 * <p>
 * 介绍一个小工具：插件
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

    // 绑定视图列表
    @BindViews({R.id.tv1, R.id.tv2, R.id.tv3})
    List<TextView> mViewList;

    // 绑定资源:通过调用不同的注解，完成不同的绑定
    @BindColor(R.color.colorAccent)
    int color;
    @BindString(R.string.app_name)
    String appName;
    @BindDimen(R.dimen.activity_horizontal_margin)
    float margin;
    @BindView(R.id.btnShow1)
    Button mBtnShow1;
    @BindView(R.id.btnShow2)
    Button mBtnShow2;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 绑定当前的视图
        mUnbinder = ButterKnife.bind(this);

//        TextView textView = (TextView) findViewById(R.id.tvShow);
//        Button button = (Button) findViewById(R.id.btnShow);

        // 之前绑定资源
//        int color = getResources().getColor(R.color.colorAccent);
//        String string = getResources().getString(R.string.app_name);

//        mBtnShow.setOnClickListener(this);
//        mBtnShow1.setOnClickListener(this);

        ButterKnife.apply(mViewList, action);

    }

    // 单个监听的绑定
//    @OnClick(R.id.btnShow)
//    public void onClick(View view){
//        mTextView.setText(appName);
//    }

    // 多个控件的监听绑定
    @OnClick({R.id.btnShow,R.id.btnShow1,R.id.btnShow2})
    public void clickButton(View view){
        switch (view.getId()){
            case R.id.btnShow:
                Toast.makeText(this, "点击了按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnShow1:
                Toast.makeText(this, "点击了按钮1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnShow2:
                Toast.makeText(this, "点击了按钮2", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    // 视图列表的视图操作
    private ButterKnife.Action<TextView> action = new ButterKnife.Action<TextView>() {
        @Override
        public void apply(@NonNull TextView view, int index) {
            view.setText("视图列表的文本" + index);
        }
    };

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btnShow:
//                break;
//            case R.id.btnShow1:
//                break;
//        }
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Butterknife的解绑
        mUnbinder.unbind();// 绑定重置
    }
}
