package brian.com.filemanager.modules.sdcard;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import brian.com.filemanager.R;

public class SDCardFragment extends Fragment {
    private static final String DEFAULT_PATH = Environment.getExternalStorageDirectory().getPath();
    private SDCardRecyclerView mRecyclerView;
    private SDCardRecyclerViewAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sdcard_frag_layout, container, false);
        mRecyclerView = (SDCardRecyclerView) view.findViewById(R.id.sdcard_recycler_view);
        Context context = getActivity().getApplicationContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.init();
        mAdapter = new SDCardRecyclerViewAdapter(context);
        mAdapter.setPath(DEFAULT_PATH);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
