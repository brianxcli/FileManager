package brian.com.filemanager.modules.sdcard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.ArrayList;

import brian.com.filemanager.R;
import brian.com.filemanager.utils.FileUtils;

public class SDCardRecyclerViewAdapter extends RecyclerView.Adapter {
    private String mPath;
    private ArrayList<FileUtils.FileInfo> mFileList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;

    public SDCardRecyclerViewAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setPath(String path) {
        mPath = path;
        File filePath = new File(mPath);
        if (filePath.exists() && filePath.isDirectory()) {
            ArrayList<FileUtils.FileInfo> fileArrayList = new ArrayList<FileUtils.FileInfo>();
            File[] files = filePath.listFiles();
            for (File file : files) {
                FileUtils.FileInfo info = new FileUtils.FileInfo(file);
                fileArrayList.add(info);
            }
            reset(fileArrayList);
        } else {
            clear();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.sdcard_filelist_item, parent, false);
        SDCardRecyclerViewHolder holder = new SDCardRecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SDCardRecyclerViewHolder) holder).setItem(mFileList.get(position));
    }

    @Override
    public int getItemCount() {
        return mFileList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private void clear() {
        mFileList.clear();
    }

    /**
     * Clear the current content list and set a new one
     * @param list
     */
    private void reset(ArrayList<FileUtils.FileInfo> list) {
        clear();
        mFileList.addAll(list);
        notifyDataSetChanged();
    }
}
