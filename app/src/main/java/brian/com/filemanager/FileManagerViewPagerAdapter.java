package brian.com.filemanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import brian.com.filemanager.modules.categories.CategoryFragment;
import brian.com.filemanager.modules.sdcard.SDCardFragment;

public class FileManagerViewPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_NO_CATEGORY = 0;
    private static final int PAGE_NO_SDCARD = 1;

    private static final int PAGE_COUNT = 2;

    public FileManagerViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case PAGE_NO_CATEGORY:
                return new CategoryFragment();
            case PAGE_NO_SDCARD:
                return new SDCardFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
