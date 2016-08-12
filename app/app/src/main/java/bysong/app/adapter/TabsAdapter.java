package bysong.app.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bysong.app.R;
import bysong.app.fragments.NovasMusicasFragment;
import bysong.app.fragments.PorGeneroFragment;
import bysong.app.fragments.Top10Fragment;

/**
 * Created by Tiago on 10/08/2016.
 */
public class TabsAdapter extends FragmentPagerAdapter {

    private Context context;

    public TabsAdapter(Context context, FragmentManager fm){

        super(fm);
        this.context = context;

    }

    // Retorna o número de páginas do view pager(equivalente ao número de abas)
    @Override
    public int getCount() {

        return 3;

    }

    // Título das páginas da viewPager (Tabs)
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {

            return context.getString(R.string.top_10);

        } else if (position == 1) {

            return context.getString(R.string.novas_musicas);

        }

        return context.getString(R.string.por_genero);

    }

    @Override
    public Fragment getItem(int position) {

        Fragment f = null;

        if (position == 0) {

            f = new Top10Fragment();

        } else if (position == 1) {

            f = new PorGeneroFragment();

        } else {

            f = new NovasMusicasFragment();

        }

        return f;

    }

}
