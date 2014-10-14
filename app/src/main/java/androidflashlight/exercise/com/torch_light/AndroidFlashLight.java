package androidflashlight.exercise.com.torch_light;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AndroidFlashLight extends Activity {

    Camera camera = null;
    Parameters parameters;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_flash_light);

        final Button FlashLightControl = (Button)findViewById(R.id.flashcontrol);
        FlashLightControl.setText("Set FLASH_MODE_TORCH");

        FlashLightControl.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(camera == null){
                    camera = Camera.open();
                    parameters = camera.getParameters();
                    parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                    FlashLightControl.setText("Set FLASH_MODE_OFF");
                }else{
                    parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
                    camera.setParameters(parameters);
                    camera.release();
                    camera = null;
                    FlashLightControl.setText("Set FLASH_MODE_TORCH");
                }

            }});
    }
}