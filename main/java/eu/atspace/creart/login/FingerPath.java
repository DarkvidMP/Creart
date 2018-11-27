package eu.atspace.creart.login;


import android.graphics.Path;

public class FingerPath {

    public int color;
    public boolean emboss;
    public boolean blur;
    public int strokeWidth;
    private Path path;

    public FingerPath(int c,boolean em,boolean bl,int strok,Path pa){
        this.color = c;
        this.emboss = em;
        this.blur = bl;
        this.strokeWidth = strok;
        this.path = pa;
    }

    public Path getPath() {

        return path;
    }


}
