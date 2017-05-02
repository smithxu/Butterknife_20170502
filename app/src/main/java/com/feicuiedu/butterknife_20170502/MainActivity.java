package com.feicuiedu.butterknife_20170502;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
 *      compile 'com.jakewharton:butterknife:8.5.1'
 *      annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1'
 *
 * 2. 绑定控件
 *      使用Butterknife，一定要记得Butterknife.bind();
 *      @BindView(int)
 *      TextView tvShow
 *
 * 3. 绑定资源:通过调用不同的注解，完成不同的绑定
 *      @BindColor、@BindString等
 *
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
