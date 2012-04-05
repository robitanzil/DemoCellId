package edu.robitanzil.cellid;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.widget.TextView;

public class Main extends Activity {

	private TextView txtResult;
	
	private GsmCellLocation location;
	private int cellId;
	private int lac;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        txtResult = (TextView) findViewById(R.id.text_result);
        
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        location = (GsmCellLocation) tm.getCellLocation();
        
        cellId = location.getCid();
        lac = location.getLac();
        
        String result = "Cell Id : " + cellId + " - " + "Lac : " + lac;
        txtResult.setText(result);
    }
}