package View.Fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utility.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("Registered")
public class CollapsingToolbarGoalActivity extends AppCompatActivity {

    private AppBarLayout appBarlayout;
    private CollapsingToolbarLayout collapsingLayout;
    private AppCompatTextView layoutTitle;
    private Toolbar toolbar;
    private AppCompatButton acceptButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_collapsing_toolbar_goal_layout);

        appBarlayout = findViewById(R.id.app_bar_layout);

        collapsingLayout = findViewById(R.id.collapsing_toolbar_layout);
        layoutTitle = findViewById(R.id.collapsing_toolbar_layout_TextView);
        toolbar = findViewById(R.id.toolbar);

        String title = getIntent().getStringExtra("title");
        layoutTitle.setText(title);

    }
}
