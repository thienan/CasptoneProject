package com.vpaliy.domain.loader;

import android.content.Context;

import com.vpaliy.domain.R;
import com.vpaliy.domain.model.MelophileTheme;
import com.vpaliy.domain.repository.Repository;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PlaylistsFactory extends ThemeFactory<GetPlaylists>{

    @Inject
    public PlaylistsFactory(Context context, Repository repository){
        super(context,repository);
    }

    @Override
    protected void initThemes(){
        themes= Arrays.asList(
                MelophileTheme.create(context.getString(R.string.popular),"popular","2017"),
                MelophileTheme.create(context.getString(R.string.chilling),"chills","party","friends","pool-party"),
                MelophileTheme.create(context.getString(R.string.rock),"rock2017",
                        "alternative2017","pop-rock2017","indie2017","indie","heavy metal","guitar"),
                MelophileTheme.create(context.getString(R.string.working_out),"training","epic","work","fitness"),
                MelophileTheme.create(context.getString(R.string.travel),"travel","road"),
                MelophileTheme.create(context.getString(R.string.pop),"pop2017","pop"));
    }

    public GetPlaylists forTheme(int themeIndex){
        if(themeIndex<0||themeIndex>=themes.size()) {
            return null;
        }
        GetPlaylists getPlaylists=new GetPlaylists(context,repository);
        getPlaylists.setParams(themes.get(themeIndex));
        return getPlaylists;
    }
}
