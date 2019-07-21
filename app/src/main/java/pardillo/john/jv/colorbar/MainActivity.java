package pardillo.john.jv.colorbar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    // declaration
    private TextView txtResult;
    private SeekBar redBar, greenBar, blueBar;
    private int redValue, greenValue, blueValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialization
        this.txtResult = this.findViewById(R.id.textView);
        this.redBar = this.findViewById(R.id.seekBar);
        this.greenBar = this.findViewById(R.id.seekBar2);
        this.blueBar = this.findViewById(R.id.seekBar3);

        // set seek event on seekBar
        this.redBar.setOnSeekBarChangeListener(this);
        this.greenBar.setOnSeekBarChangeListener(this);
        this.blueBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // determine which seekBar is managed
        switch(seekBar.getId()) {
            case R.id.seekBar: // redBar
                redValue = seekBar.getProgress();

                break;
            case R.id.seekBar2: // greenBar
                greenValue = seekBar.getProgress();

                break;
            case R.id.seekBar3: // blueBar
                blueValue = seekBar.getProgress();

                break;
        }

        // get the hex equivalent of the color integer value
        String red = String.format("%2x", redValue);
        String green = String.format("%2x", greenValue);
        String blue = String.format("%2x", blueValue);

        // show hex color code
        String colorName = "#" + red + green + blue;
        this.txtResult.setText(colorName);

        // mix all colors
        this.txtResult.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
