package com.example.llw.demo_tabhost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.Fragment.Blankone;
import com.Fragment.Blankthree;
import com.Fragment.Blanktwo;

public class MainActivit extends AppCompatActivity implements View.OnClickListener {
    private TabHost tabhost;
    private TabWidget tabs;
    private FrameLayout tabcontent;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;

    private Blankone blankone;
    private Blanktwo blanktwo;
    private Blankthree blankthree;

    private void assignViews() {
        tabhost = (TabHost) findViewById(android.R.id.tabhost);
        tabs = (TabWidget) findViewById(android.R.id.tabs);
        tabcontent = (FrameLayout) findViewById(android.R.id.tabcontent);
        btnOne = (Button) findViewById(R.id.btn_one);
        btnTwo = (Button) findViewById(R.id.btn_two);
        btnThree = (Button) findViewById(R.id.btn_three);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        assignViews();
        // tabhost.setup(new LocalActivityManager(this, true));
        init();
    }

    public void init() {
        blankone = new Blankone();
        blanktwo = new Blanktwo();
        blankthree = new Blankthree();

        tabhost.setup();

        tabhost.addTab(tabhost.newTabSpec("第一个").setIndicator("标签一", null).setContent(R.id.tab1));
        tabhost.addTab(tabhost.newTabSpec("第一个").setIndicator("标签一", null).setContent(R.id.tab2));
        tabhost.addTab(tabhost.newTabSpec("第一个").setIndicator("标签一", null).setContent(R.id.tab3));
/*最纯粹简单的使用tabhost的时候，根据官方文档知道tabhost有两个子类view一个是用于选择的标签，另一个是framelayout 由于填装content
* 在涉及setContent（）方法的时候可能会出现：：Caused by: java.lang.RuntimeException: Could not create tab content
* because could not find view with id ViewId 着个很有可能是fragmelayout的布局有问题，需要把要填装的view布局于FrameLayout中否则会出找不到viewID*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:

                tabhost.setCurrentTab(0);
                break;
            case R.id.btn_two:
                tabhost.setCurrentTab(1);
                break;
            case R.id.btn_three:
                tabhost.setCurrentTab(2);

                break;
        }
    }


}
