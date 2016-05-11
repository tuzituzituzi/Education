package wushuu.com.education;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.TextView;

import com.wushuu.education.util.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wushuu on 2016/5/11.
 */
public class ChapterPracticeActivity extends Activity{

    private String mChapterName;
    private List<String> mPracticeList;
    private ListView listPractice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_practice);
        initData();
        initView();

    }

    private void initData() {
        mChapterName = getIntent().getStringExtra("charpterName");
        mPracticeList = new ArrayList<String>();
        mPracticeList = Rule.getInstance().getPracticeList(mChapterName);
        System.out.println("PracticeList="+mPracticeList);
    }

    private void initView() {
        TextView tvCharpterName = (TextView) findViewById(R.id.tv_charpter_name);
        tvCharpterName.setText(mChapterName);
        listPractice = (ListView) findViewById(R.id.list_practice);
    }


}
