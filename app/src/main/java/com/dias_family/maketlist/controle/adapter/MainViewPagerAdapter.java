package com.dias_family.maketlist.controle.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.dias_family.maketlist.view.CourseListFragment;
import com.dias_family.maketlist.view.ItemListFragment;

public class MainViewPagerAdapter  extends FragmentStateAdapter {


    private ItemListFragment page1;
    private CourseListFragment page2;

    public MainViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.page1 = new ItemListFragment();
        this.page2 = new CourseListFragment();
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 1){
            return this.page2;
        }
        else{
            return  this.page1;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
