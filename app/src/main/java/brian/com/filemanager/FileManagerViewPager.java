package brian.com.filemanager;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class FileManagerViewPager extends ViewPager implements  FileManagerTabs.TabListener {
    private FragmentManager mFragmentManager;
    private FileManagerTabs mTabs;
    private FileManagerViewPagerAdapter mAdapter;
    private FileManagerOnPageChangeListener mListener;

    public FileManagerViewPager(Context context) {
        super(context);
    }

    public FileManagerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void initPager(FragmentManager manager, FileManagerTabs tabs) {
        mFragmentManager = manager;
        mTabs = tabs;
        mTabs.setTabListener(this);
        mAdapter = initAdapter(manager);
        setAdapter(mAdapter);
        mListener = new FileManagerOnPageChangeListener(mTabs);
        addOnPageChangeListener(mListener);
    }

    private FileManagerViewPagerAdapter initAdapter(FragmentManager manager) {
        FileManagerViewPagerAdapter adapter = new FileManagerViewPagerAdapter(manager);
        return adapter;
    }

    private static class FileManagerOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private FileManagerTabs mTabs;

        public FileManagerOnPageChangeListener(FileManagerTabs tabs) {
            mTabs = tabs;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mTabs.setCurrentTab(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    @Override
    public void onTabChanged(int position) {
        setCurrentItem(position, true);
    }
}
