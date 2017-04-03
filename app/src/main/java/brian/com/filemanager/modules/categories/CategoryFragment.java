package brian.com.filemanager.modules.categories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import brian.com.filemanager.R;

public class CategoryFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.category_frag_layout, container, false);
        initViews(root);
        return root;
    }

    private void initViews(View root) {
        View view = root.findViewById(R.id.category_video_wrapper);
        view.setOnClickListener(this);
        view = root.findViewById(R.id.category_music_wrapper);
        view.setOnClickListener(this);
        view = root.findViewById(R.id.category_zip_wrapper);
        view.setOnClickListener(this);
        view = root.findViewById(R.id.category_image_wrapper);
        view.setOnClickListener(this);
        view = root.findViewById(R.id.category_doc_wrapper);
        view.setOnClickListener(this);
        view = root.findViewById(R.id.category_bluetooth_wrapper);
        view.setOnClickListener(this);
        view = root.findViewById(R.id.category_favorite_wrapper);
        view.setOnClickListener(this);
        view = root.findViewById(R.id.category_usb_wrapper);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.category_video_wrapper:
            case R.id.category_music_wrapper:
            case R.id.category_zip_wrapper:
            case R.id.category_image_wrapper:
            case R.id.category_doc_wrapper:
            case R.id.category_bluetooth_wrapper:
            case R.id.category_favorite_wrapper:
            case R.id.category_usb_wrapper:
        }
    }
}
