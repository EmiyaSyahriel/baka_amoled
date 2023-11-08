package id.psw.baka_amoled;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;

public class ColorView extends View {
    
    private Paint paint = new Paint();
    
    public ColorView(Context context) {
        super(context);
        init();
    }
    
    private void init(){
    }
    
    private int _style;
    public void setActiveStyle(int style){
        _style = style;
        postInvalidate();
    }
    
    @Override
    protected void onDraw(Canvas ctx) {
        super.onDraw(ctx);
        
        switch(_style){
            case 0: // Black
            paint.setShader(null);
            paint.setColor(Color.BLACK); 
            break;
            case 1: // White
            paint.setShader(null);
            paint.setColor(Color.WHITE); 
            break;
            case 2: // Black White
            paint.setShader(new LinearGradient(
                0f, 0f, getWidth(), 0f, 
                new int[]{ Color.BLACK, Color.WHITE },
                new float[]{ 0.499f, 0.501f }, Shader.TileMode.CLAMP
            ));
            break;
            case 3: // Black White
            paint.setShader(new LinearGradient(
                0f, 0f, getWidth(), 0f, 
                new int[]{ Color.BLACK, Color.WHITE },
                new float[]{ 0.25f, 0.75f }, Shader.TileMode.CLAMP
            ));
            break;
            case 4:
            paint.setShader(new LinearGradient(
                0f, 0f, getWidth(), 0f,
                new int[]{ Color.RED, Color.GREEN, Color.GREEN, Color.BLUE },
                new float[]{ 0.332f, 0.334f, 0.665f, 0.667f }, 
                Shader.TileMode.CLAMP
            ));
            break;
            case 5:
            paint.setShader(new LinearGradient(
                0f, 0f, getWidth(), 0f,
                new int[]{ Color.RED, Color.GREEN, Color.BLUE },
                new float[]{ 0.25f, 0.5f, 0.75f }, 
                Shader.TileMode.CLAMP
            ));
            break;
        }
        
        ctx.drawPaint(paint);
    }
    
}
