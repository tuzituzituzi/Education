package wushuu.com.education;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.net.Inet4Address;

/**
 * Created by wushuu on 2016/5/11.
 */
public class PracticeActivity extends Activity{

    private LinearLayout btnContainer;
    private final int CHARPTER_NUM = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        initView();
        initData();
        setOnClickListener();
    }

    private void initView() {
        btnContainer = (LinearLayout) findViewById(R.id.btn_container);
        for(int i = 0; i < CHARPTER_NUM; i++){
            Button btn = new Button(getApplicationContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100,100);
            btn.setText(String.valueOf(i));
            params.bottomMargin = 5;
            btn.setLayoutParams(params);
            btnContainer.addView(btn);
        }
    }

    private void initData() {
    }

    private void setOnClickListener() {
        for(int i = 0; i < CHARPTER_NUM; i++){
            final int finalI = i;
            btnContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PracticeActivity.this,ChapterPracticeActivity.class);
                    intent.putExtra("charpterName",String.valueOf(finalI));
                    startActivity(intent);
                }
            });
        }
    }
}
