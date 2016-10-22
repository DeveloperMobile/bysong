package bysong.app.domain;

import org.parceler.Parcel;

/**
 * Created by Lucas on 14/08/2016.
 */
@Parcel
public class Artist {

    private String artistName;
    private String imageFileArtist;
    private int imageFileArtistID;

    public Artist() {

    }

    public Artist(String artistName, int imageFileArtistID) {

        this.artistName = artistName;
        this.imageFileArtistID = imageFileArtistID;

    }

    public void setArtistName(String artistName) {

        this.artistName = artistName;

    }

    public String getArtistName() {

        return artistName;

    }

    public void setImageFileArtist(String imageFileArtist) {

        this.imageFileArtist = imageFileArtist;

    }

    public String getImageFileArtist() {

        return imageFileArtist;

    }
    public int getImageFileArtistID() {

        return imageFileArtistID;

    }
}

