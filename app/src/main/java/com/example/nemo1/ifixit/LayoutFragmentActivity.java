package com.example.nemo1.ifixit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.example.nemo1.ifixit.V.DetailFragment;

public class LayoutFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search);
        getLayout();
    }

    private void getLayout() {
        String search = getIntent().getStringExtra("search");
        Bundle bundle = new Bundle();
        bundle.putString("search",search);
        Fragment fragment = new DetailFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_layout,fragment);
        fragmentTransaction.commit();
    }
}
