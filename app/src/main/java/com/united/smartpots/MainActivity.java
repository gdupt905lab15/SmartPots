package com.united.smartpots;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.united.smartpots.fragment.HomeFragment;
import com.united.smartpots.fragment.MoreFragment;
import com.united.smartpots.fragment.SocialFragment;
import com.united.smartpots.fragment.TalkFragment;

public class MainActivity extends AppCompatActivity{
    private RadioButton rb_home;//主页
    private RadioButton rb_social;//圈子
    private RadioButton rb_talk;//
    private RadioButton rb_more;//更多
    private ImageView iv_pot;//花盆
    private Fragment homeFragment,moreFragment,talkFragment,socialFragment,potFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("首页", R.mipmap.profile_ic_home_normal, R.color.colorAccent);//花盆
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("", R.mipmap.profile_ic_social_normal, R.color.base);//话题
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("", R.mipmap.profile_ic_talk_normal, R.color.base);//圈子
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("", R.mipmap.profile_ic_talk_normal, R.color.base);//更多

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        //设置背景颜色
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#EDEBDE"));

        // Disable the translation inside the CoordinatorLayout（可能是动画效果）
        bottomNavigation.setBehaviorTranslationEnabled(false);

        bottomNavigation.setAccentColor(Color.parseColor("#FF4081"));
        bottomNavigation.setInactiveColor(Color.parseColor("#3F51B5"));
        //使用彩色导航与圆显示效果
        bottomNavigation.setColored(false);

        //强制绘制（可用于例如图标的字体）
        bottomNavigation.setForceTint(true);


        //管理标题
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);

        // Add or remove notification for each item
        bottomNavigation.setNotification("", 0);//加了小红点

        //设置小红点的样式，然后添加
        /*AHNotification notification = new AHNotification.Builder()
                .setText("2")//个数
                 .setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red))
                .setTextColor(ContextCompat.getColor(MainActivity.this, R.color.base))
                .build();
        bottomNavigation.setNotification(notification, 2);*/

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // Do something cool here...
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "点击了第一个", Toast.LENGTH_LONG).show();
                }
                if (position == 1) {
                    Toast.makeText(getApplicationContext(), "点击了第er个", Toast.LENGTH_LONG).show();
                }
                if (position == 2) {
                    Toast.makeText(getApplicationContext(), "点击了第san个", Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });





    }






}



