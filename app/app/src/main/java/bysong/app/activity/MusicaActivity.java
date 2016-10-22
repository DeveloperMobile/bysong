package bysong.app.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import bysong.app.R;
import bysong.app.fragments.MusicaFragment;

/**
 * Created by Tiago on 09/09/2016.
 */
public class MusicaActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        setUpToolbar();

        if (savedInstanceState == null) {

            MusicaFragment frag = new MusicaFragment();
            frag.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.musica_fragment, frag).commit();

        }

    }

}
