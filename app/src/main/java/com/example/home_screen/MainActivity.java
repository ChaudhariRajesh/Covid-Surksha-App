package com.example.home_screen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


  /*  Toolbar tb1;
    ViewPager vp1;
    TabLayout tl1;

    HomeFragment hf;
    CovidFragment cf;
    ContactFragment ctf;
    LinksFragment lf;
    VideosFragment vf;
*/
    ImageView iv1,iv2;
    TextView tv1,tv2;

    Animation top, bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.SplashTheme);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        top = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        iv1=findViewById(R.id.splashImageView1);
        iv2=findViewById(R.id.splashImageView2);

        tv1=findViewById(R.id.splashTextView1);
        tv2=findViewById(R.id.splashTextView1);

        iv1.setAnimation(top);
        tv1.setAnimation(top);

        iv2.setAnimation(bottom);
        tv2.setAnimation(bottom);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
                finish();
            }

        },1700);


    }


}

      /*  vp1=findViewById(R.id.homeViewPager1);

        tl1=findViewById(R.id.homeTabLayout1);

        hf=new HomeFragment(this);
        cf=new CovidFragment(this);
        ctf=new ContactFragment(this);
        lf=new LinksFragment(this);
        vf=new VideosFragment(this);

        tl1.setupWithViewPager(vp1);


        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());


        adapter.addFragment(hf,"Home");
        adapter.addFragment(cf,"Covid-19");
        adapter.addFragment(ctf,"Contacts");
        adapter.addFragment(lf,"Useful Links");
        adapter.addFragment(vf,"Videos");

        vp1.setAdapter(adapter);

        tl1.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tl1.getTabAt(1).setIcon(R.drawable.coronavirus);
        tl1.getTabAt(2).setIcon(R.drawable.ic_contact_phone_black_24dp);
        tl1.getTabAt(3).setIcon(R.drawable.ic_link_black_24dp);
        tl1.getTabAt(4).setIcon(R.drawable.ic_video_library_black_24dp);

        BadgeDrawable badgeDrawable = tl1.getTabAt(0).getOrCreateBadge();
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(12);


    }

    private class ViewPagerAdapter extends FragmentPagerAdapter
    {
        List<Fragment> f=new ArrayList<>();
        List<String> ft=new ArrayList<>();


        public ViewPagerAdapter(@NonNull FragmentManager supportFragmentManager)
        {
            super(supportFragmentManager);

        }

        @NonNull
        @Override
        public Fragment getItem(int position)
        {
            return f.get(position);
        }

        @Override
        public int getCount()
        {
            return f.size();
        }

        public void addFragment(Fragment fragment,String fragmentTitle)
        {

            f.add(fragment);

            ft.add(fragmentTitle);

        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position)
        {
            return ft.get(position);
        }

    }


}
*/