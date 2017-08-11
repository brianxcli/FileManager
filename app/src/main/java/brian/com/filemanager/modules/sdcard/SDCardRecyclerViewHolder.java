package brian.com.filemanager.modules.sdcard;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import brian.com.filemanager.R;
import brian.com.filemanager.utils.FileUtils;

public class SDCardRecyclerViewHolder extends RecyclerView.ViewHolder {
    public SDCardRecyclerViewHolder(View itemView) {
        super(itemView);
    }

    public void setItem(FileUtils.FileInfo info) {
        AppCompatImageView image = (AppCompatImageView) itemView.findViewById(R.id.file_icon);
        image.setImageResource(info.iconRes);
        image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        TextView titleText = (TextView) itemView.findViewById(R.id.file_title);
        titleText.setText(info.name);

        TextView pathText = (TextView) itemView.findViewById(R.id.file_path);
        pathText.setText(info.path);
    }
}
