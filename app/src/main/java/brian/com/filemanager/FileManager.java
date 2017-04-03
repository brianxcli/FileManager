package brian.com.filemanager;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class FileManager extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filemanager_layout);
        initViews();
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView categoryTab = (TextView) findViewById(R.id.main_tab_categories);
        TextView sdcardTab = (TextView) findViewById(R.id.main_tab_sdcard);
        FileManagerTabs tabs = new FileManagerTabs(categoryTab, sdcardTab);

        FileManagerViewPager pager = (FileManagerViewPager) findViewById(R.id.main_pager);
        pager.initPager(getSupportFragmentManager(), tabs);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
