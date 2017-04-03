package brian.com.filemanager;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

public class FileManagerTabs {
    private static final int GRAY_LEVEL = 48;
    private static final int GRAY = Color.rgb(GRAY_LEVEL, GRAY_LEVEL, GRAY_LEVEL);
    private static final int TEXT_COLOR_FOCUS_RES = Color.WHITE;
    private static final int BG_COLOR_FOCUS_RES = GRAY;
    private static final int TEXT_COLOR_NORMAL_RES = GRAY;
    private static final int BG_COLOR_NORMAL_RES = Color.TRANSPARENT;
    private int mCurrentTab;
    private TabListener mListener;
    private TextView mViews[];

    private View.OnClickListener mViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int pos = findTabPosition(v.getId());
            if (pos > -1 && pos != mCurrentTab) {
                setCurrentTab(pos);
            }
        }

        private int findTabPosition(int id) {
            if (mViews == null || mViews.length == 0) {
                return -1;
            }

            for (int i = 0; i < mViews.length; i++) {
                int curId = mViews[i].getId();
                if (curId == id) {
                    return i;
                }
            }
            return -1;
        }
    };

    public FileManagerTabs(TextView... views) {
        mViews = views;
        initListener();
        mCurrentTab = 0;
        changeStyles(mCurrentTab);
    }

    private void initListener() {
        for (View view : mViews) {
            view.setOnClickListener(mViewOnClickListener);
        }
    }

    public void setTabListener(TabListener listener) {
        this.mListener = listener;
    }

    public void setCurrentTab(int position) {
        if (position != mCurrentTab) {
            changeStyles(position);
            if (this.mListener != null) {
                this.mListener.onTabChanged(position);
            }
            mCurrentTab = position;
        }
    }

    private void changeStyles(int position) {
        if (mViews == null || mViews.length == 0) {
            return;
        }

        for (int i = 0; i < mViews.length; i++) {
            if (position == i) {
                mViews[i].setTextColor(TEXT_COLOR_FOCUS_RES);
                mViews[i].setBackgroundColor(BG_COLOR_FOCUS_RES);
            } else {
                mViews[i].setTextColor(TEXT_COLOR_NORMAL_RES);
                mViews[i].setBackgroundColor(BG_COLOR_NORMAL_RES);
            }
        }
    }

    public interface TabListener {
        void onTabChanged(int position);
    }
}
