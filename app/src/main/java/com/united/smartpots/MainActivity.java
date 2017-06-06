package com.united.smartpots;

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

import com.united.smartpots.fragment.HomeFragment;
import com.united.smartpots.fragment.MoreFragment;
import com.united.smartpots.fragment.SocialFragment;
import com.united.smartpots.fragment.TalkFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
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
        rb_home= (RadioButton) findViewById(R.id.rb_home);
        rb_social= (RadioButton) findViewById(R.id.rb_social);
        rb_talk= (RadioButton) findViewById(R.id.rb_talk);
        rb_more= (RadioButton) findViewById(R.id.rb_more);
        iv_pot= (ImageView) findViewById(R.id.iv_pot);

        /////////////////
        rb_home.setOnClickListener(this);
        rb_more.setOnClickListener(this);
        rb_social.setOnClickListener(this);
        rb_talk.setOnClickListener(this);
        showCurrentFragment(1);//将主页当成启动




    }
    @Override
    public void onClick(View view) {
        restartButton();
        switch (view.getId()){
            case R.id.rb_home:
                showCurrentFragment(1);
                break;
            case R.id.rb_talk:
                showCurrentFragment(2);
                break;
            case R.id.rb_social:
                showCurrentFragment(3);
                break;
            case R.id.rb_more:
                showCurrentFragment(4);
                break;
            default:
                Toast.makeText(getApplicationContext(),"点击监听失效",Toast.LENGTH_LONG).show();
        }

    }
    private void showCurrentFragment(int i){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragments(fragmentTransaction);
        switch (i){
            case 1:
                Drawable iv_home_clicked = ContextCompat.getDrawable(getApplication(),R.drawable.profile_ic_home_selected);
                rb_home.setCompoundDrawablesWithIntrinsicBounds(null,iv_home_clicked,null,null);
                if(homeFragment==null){
                    homeFragment=new HomeFragment();
                    fragmentTransaction.add(R.id.frame_layout,homeFragment);
                }
                else {
                    fragmentTransaction.show(homeFragment);

                }
                break;
            case 2:
                Drawable iv_talk_cliked = ContextCompat.getDrawable(getApplicationContext(),R.drawable.profile_ic_talk_selected);
                rb_talk.setCompoundDrawablesWithIntrinsicBounds(null,iv_talk_cliked,null,null);
                if(talkFragment==null){
                    talkFragment=new TalkFragment();
                    fragmentTransaction.add(R.id.frame_layout,talkFragment);
                }
                else {
                    fragmentTransaction.show(talkFragment);
                }
                break;
            case 3:
                Drawable iv_social_cliked=ContextCompat.getDrawable(getApplicationContext(),R.drawable.profile_ic_social_selected);
                rb_social.setCompoundDrawablesWithIntrinsicBounds(null,iv_social_cliked,null,null);
                if(socialFragment==null){
                    socialFragment=new SocialFragment();
                    fragmentTransaction.add(R.id.frame_layout,socialFragment);
                }
                else {
                    fragmentTransaction.show(socialFragment);
                }
                break;
            case 4:
                Drawable iv_more_clicked =ContextCompat.getDrawable(getApplicationContext(),R.drawable.profile_ic_more_selected);
                rb_more.setCompoundDrawablesWithIntrinsicBounds(null,iv_more_clicked,null,null);
                if(moreFragment==null){
                    moreFragment=new MoreFragment();
                    fragmentTransaction.add(R.id.frame_layout,moreFragment);
                }
                else{
                    fragmentTransaction.show(moreFragment);
                }
                break;
        }
        fragmentTransaction.commit();

    }
    private void restartButton(){
        Drawable home = ContextCompat.getDrawable(getApplication(),R.drawable.profile_ic_home_normal);
        Drawable talk = ContextCompat.getDrawable(getApplicationContext(),R.drawable.profile_ic_talk_normal);
        Drawable social = ContextCompat.getDrawable(getApplicationContext(),R.drawable.profile_ic_social_normal);
        Drawable more = ContextCompat.getDrawable(getApplicationContext(),R.drawable.profile_ic_more_normal);
        rb_home.setCompoundDrawablesWithIntrinsicBounds(null,home,null,null);
        rb_talk.setCompoundDrawablesWithIntrinsicBounds(null,talk,null,null);
        rb_social.setCompoundDrawablesWithIntrinsicBounds(null,social,null,null);
        rb_more.setCompoundDrawablesWithIntrinsicBounds(null,more,null,null);
    }
    private void hideFragments (FragmentTransaction transaction){
        if (potFragment!=null){
            transaction.hide(potFragment);
        }
        if (socialFragment!=null){
            transaction.hide(socialFragment);
        }
        if (moreFragment!=null){
            transaction.hide(moreFragment);
        }
        if (homeFragment!=null){
            transaction.hide(homeFragment);
        }
        if (talkFragment!=null){
            transaction.hide(talkFragment);
        }

    }




}



