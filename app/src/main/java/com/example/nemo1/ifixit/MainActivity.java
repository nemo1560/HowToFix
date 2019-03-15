package com.example.nemo1.ifixit;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nemo1.ifixit.Interfaces.onCallBack;
import com.example.nemo1.ifixit.V.DetailFragment;
import com.example.nemo1.ifixit.V.SearchFragment;
import com.example.nemo1.ifixit.V.WebViewFragment;

public class MainActivity extends AppCompatActivity implements onCallBack {
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_layout,new SearchFragment());
        fragmentTransaction.commit();
    }

    //Nhan thong tin interface tu fragment SearchFragment truyen ve activity
    //Activity ko implement interface duoc.
    @Override
    public void CallBack(String search) {
        Bundle bundle = new Bundle();
        Fragment fragment = new DetailFragment();
        bundle.putString("search",search);
        fragment.setArguments(bundle);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //Nhan thong tin interface tu fragment DetailFragment truyen ve activity
    @Override
    public void CallBackURL(String url) {
        Bundle bundle = new Bundle();
        Fragment fragment = new WebViewFragment();
        bundle.putString("url",url);
        fragment.setArguments(bundle);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
