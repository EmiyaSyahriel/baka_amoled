package id.psw.baka_amoled;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;

public class ColorActivity extends Activity {
    
    private ColorView v = null;
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        v = new ColorView(this);
        setContentView(v);
        int t = getIntent().getIntExtra("mode", 0);
        v.setActiveStyle(t);
        getActionBar().hide();
        setBrightness(true);
        makeFullscreen();
    }
    
    @Override
    public void onConfigurationChanged(Configuration arg0) {
        super.onConfigurationChanged(arg0);
        // TODO: Implement this method
        v.postInvalidate();
        makeFullscreen();
    }
    
    @SuppressWarnings("DEPRECATION")
    private void makeFullscreen(){
        int i = Build.VERSION.SDK_INT;
        if(i >= Build.VERSION_CODES.P){
            getWindow().getAttributes().layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS;
        }
        
        if(i >= Build.VERSION_CODES.R){
            Window window = getWindow();
            window.setDecorFitsSystemWindows(false);
            WindowInsetsController ctrl= window.getInsetsController();
            ctrl.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
            ctrl.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
        }else if(i >= Build.VERSION_CODES.KITKAT){
            getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }
    }
    
    private void setBrightness(boolean isUp){
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        float b = lp.screenBrightness + (isUp ? 0.1f : -0.1f);
        b = Math.min(1.0f, Math.max(0.0f, b));
        lp.screenBrightness = b;
        getWindow().setAttributes(lp);
    }
    
    @Override
    public boolean onKeyDown(int arg0, KeyEvent key) {
        switch(key.getKeyCode()){
            case KeyEvent.KEYCODE_VOLUME_DOWN:
            setBrightness(false);
            return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
            setBrightness(true);
            return true;
        }
        return super.onKeyDown(arg0, key);
    }
    
    @Override
    public boolean onKeyUp(int arg0, KeyEvent key) {
        switch(key.getKeyCode()){
            case KeyEvent.KEYCODE_VOLUME_DOWN:
            case KeyEvent.KEYCODE_VOLUME_UP:
            return true;
        }
        return super.onKeyUp(arg0, key);
    }
    
    
}
