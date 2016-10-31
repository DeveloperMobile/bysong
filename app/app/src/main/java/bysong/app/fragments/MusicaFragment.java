package bysong.app.fragments;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.parceler.Parcel;
import org.parceler.Parcels;

import java.io.IOException;

import bysong.app.R;
import bysong.app.domain.PlayerMp3;
import bysong.app.domain.Song;
import bysong.app.visualControls.TextViewAnimated;

import static bysong.app.R.id.tvSongVerse;

/**
 * Created by Tiago on 09/09/2016.
 */
public class MusicaFragment extends Fragment implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener,
        TextViewAnimated.OnTextFinishedListener{

    private static final String TAG = "songplayer";

    private TextViewAnimated letra;
    private Button btnNextVerse;
    private EditText etCompleteVerse;
    private PlayerMp3 playerMp3;
    private boolean isPlaying;
    private Song song;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_musica, container, false);
        song = Parcels.unwrap(getArguments().getParcelable("verso"));
        inicializar(view);
        tutorialFromBobMarley(0, song.getVersesList().getList().get(0).getIiStartTime(),
                song.getVersesList().getList().get(0).getIiEndTime());
        return view;

    }

    private void inicializar(View view) {

        etCompleteVerse = (EditText) view.findViewById(R.id.etCompleteVerse);
        letra = (TextViewAnimated) view.findViewById(R.id.letra);
        btnNextVerse = (Button) view.findViewById(R.id.btnNextVerse);
        btnNextVerse.setOnClickListener(onClickNext());

    }

    private void tutorialFromBobMarley(int id, int startTime, int duration) {

        PlayerMp3 playerPreview = new PlayerMp3(this.getContext());
        playerPreview.playLocalFile(R.raw.bob_marley_is_this_love, startTime, duration);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        letra.setDelay(300);
        letra.showTextWordByWord(song.getVersesList().getList().get(id).getOriginalWriting(), this);
        Log.d("song", song.getVersesList().getList().get(id).getOriginalWriting());
    }

    /*private void tocarMusica() {

        try {

            isPlaying = true;
            playerMp3 = PlayerMp3.getInstance((MediaPlayer.OnPreparedListener) MusicaFragment.this,
                    (MediaPlayer.OnCompletionListener)MusicaFragment.this);
            AssetFileDescriptor asset = getActivity().getAssets().openFd("pra_nao_morrer_de_paixao_refrao.mp3");
            playerMp3.start(asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength());

        } catch (IOException e) { e.printStackTrace(); }

    }*/

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

        Log.d(TAG, "onCompletion()");
        playerMp3.stop();
        playerMp3.killMyInstance();
        letra.setVisibility(View.VISIBLE);
        //btn_tocar_musica.setEnabled(true);

    }


    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

        Log.d(TAG, "onPrepared()");
        isPlaying = true;
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

    }

    private View.OnClickListener onClickNext() {

        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String verso = etCompleteVerse.getText().toString();

                if (song.getVersesList().getList().get(1).getOriginalWriting().equals(verso)) {
                    tutorialFromBobMarley(1, song.getVersesList().getList().get(1).getIiStartTime(),
                            song.getVersesList().getList().get(1).getIiEndTime());
                    btnNextVerse.setText("Continuar");

                } else {

                    btnNextVerse.setText("Tentar Novamente");

                }

            }

        };

    }

    @Override
    public void onTextFinished() {

        etCompleteVerse.setFocusable(true);

    }

}
