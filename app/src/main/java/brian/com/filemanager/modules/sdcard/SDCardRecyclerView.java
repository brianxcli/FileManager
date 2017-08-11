package brian.com.filemanager.modules.sdcard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import brian.com.filemanager.R;

public class SDCardRecyclerView extends RecyclerView {

    public SDCardRecyclerView(Context context) {
        super(context);
    }

    public SDCardRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SDCardRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void init() {
        setOverScrollMode(OVER_SCROLL_ALWAYS);
        setScrollBarStyle(SCROLLBARS_OUTSIDE_OVERLAY);
        addItemDecoration(new SDCardItemDecoration(getContext()));

        System.out.println("scrollbar width:" + getVerticalScrollbarWidth());
    }

    private static class SDCardItemDecoration extends ItemDecoration {
        private Drawable mDivider;
        private Context mContext;

        public SDCardItemDecoration(Context context) {
            mContext = context;
            mDivider = mContext.getResources().getDrawable(R.color.lightGray);
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, State state) {
            super.onDraw(c, parent, state);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, State state) {
            int childCnt = parent.getChildCount();
            for (int i = 0; i < childCnt; i++) {
                View child = parent.getChildAt(i);
                int left = child.getLeft();
                int right = left + child.getWidth();
                int bottom = child.getTop() + child.getHeight();
                mDivider.setBounds(left, bottom - 1, right, bottom);
                mDivider.draw(c);
            }
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
            super.getItemOffsets(outRect, view, parent, state);
        }
    }
}
