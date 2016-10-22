package bysong.app.activity;

import org.parceler.Parcel;

import java.util.List;

import bysong.app.domain.Verse;

/**
 * Created by Tiago on 21/10/2016.
 */
@Parcel
public class ListVerse {

    private List<Verse> list;

    public ListVerse() {

    }

    public List<Verse> getList() {
        return list;
    }

    public void setList(List<Verse> list) {
        this.list = list;
    }

}
