package wushuu.com.education;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.wushuu.education.util.Expression;
import com.wushuu.education.util.Rule;

import java.util.ArrayList;
import java.util.List;

public class ChapterPracticeActivity extends Activity{

    private String mChapterName;
    private List<Expression> mPracticeList;
    private GridView listPractice;
    private PracticeAdapter adapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_practice);
        initData();
        initView();
    }

    private void initData() {
        mContext = this;
        mChapterName = getIntent().getStringExtra("charpterName");
        mPracticeList = new ArrayList<Expression>();
        mPracticeList = Rule.getInstance().getPracticeList(mChapterName);
        System.out.println("PracticeList="+mPracticeList);
        adapter = new PracticeAdapter();
    }

    private void initView() {
        TextView tvCharpterName = (TextView) findViewById(R.id.tv_charpter_name);
        tvCharpterName.setText(mChapterName);
        listPractice = (GridView) findViewById(R.id.list_practice);
        listPractice.setAdapter(adapter);
    }


    private class PracticeAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mPracticeList==null?0:mPracticeList.size();
        }

        @Override
        public Object getItem(int position) {
            return mPracticeList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView ;
            if(convertView == null){
                textView = new TextView(mContext);
                textView.setLayoutParams(new GridView.LayoutParams(150, 80));
            }else{
                textView = (TextView) convertView;
            }
//            textView.setText(mPracticeList.get(position).getQuestion() + String.valueOf(mPracticeList.get(position).getResult()));
            textView.setText(mPracticeList.get(position).getQuestion() + mPracticeList.get(position).getResult());
            return textView;
        }
    }
}
