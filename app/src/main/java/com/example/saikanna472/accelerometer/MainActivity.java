package com.example.saikanna472.accelerometer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private static final String TAG = "MainActivity";
    private SensorManager sensorManager;
    private Sensor accelerometer, mGyro , mMagno ,mLight , mPressure , mTemp , mHumi ;

    TextView xValue,yValue,zValue,xGyroValue,yGyroValue,zGyroValue,xMagnoValue,yMagnoValue,zMagnoValue,light,pressure,temp,humi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xValue=(TextView) findViewById(R.id.xValue);
        yValue=(TextView) findViewById(R.id.yValue);
        zValue=(TextView) findViewById(R.id.zValue);

        xGyroValue=(TextView) findViewById(R.id.xGyroValue);
        yGyroValue=(TextView) findViewById(R.id.yGyroValue);
        zGyroValue=(TextView) findViewById(R.id.zGyroValue);

        xMagnoValue=(TextView) findViewById(R.id.xMagnoValue);
        yMagnoValue=(TextView) findViewById(R.id.yMagnoValue);
        zMagnoValue=(TextView) findViewById(R.id.zMagnoValue);

        light=(TextView) findViewById(R.id.light);
        pressure=(TextView) findViewById(R.id.pressure);
        temp=(TextView) findViewById(R.id.temp);
        humi=(TextView) findViewById(R.id.humi);


        Log.d(TAG, "onCreate: Initializing Sensor Services");

        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(accelerometer != null){
            sensorManager.registerListener(MainActivity.this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Accelerometer listener");
        }else {
            xValue.setText("Accelerometer not supported");
            yValue.setText("Accelerometer not supported");
            zValue.setText("Accelerometer not supported");
        }
         mGyro= sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if(mGyro != null){
            sensorManager.registerListener(MainActivity.this,mGyro,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Gyro listener");
        }else {
            xGyroValue.setText("Gyro not supported");
            yGyroValue.setText("Gyro not supported");
            zGyroValue.setText("Gyro not supported");
        }
        mMagno = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if(mMagno != null){
            sensorManager.registerListener(MainActivity.this,mMagno,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Magno listener");
        }else {
            xMagnoValue.setText("Magno not supported");
            yMagnoValue.setText("Magno not supported");
            zMagnoValue.setText("Magno not supported");
        }
        mLight= sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(mLight != null){
            sensorManager.registerListener(MainActivity.this,mLight,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Light listener");
        }else {
            light.setText("Light not supported");
        }
        mPressure= sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if(mPressure != null){
            sensorManager.registerListener(MainActivity.this,mPressure,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Pressure listener");
        }else {
            pressure.setText("Pressure not supported");
        }
        mTemp= sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if(mTemp != null){
            sensorManager.registerListener(MainActivity.this,mTemp,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Temp listener");
        }else {
            temp.setText("Temp not supported");
        }
        mHumi= sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if(mHumi != null){
            sensorManager.registerListener(MainActivity.this,mHumi,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Humi listener");
        }else {
            humi.setText("Humi not supported");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
         Sensor sensor = sensorEvent.sensor;
         if (sensor.getType()== Sensor.TYPE_ACCELEROMETER){
             Log.d(TAG, "onSensorChanged: X:" + sensorEvent.values[0] + "Y:" + sensorEvent.values[1] + "Z:" + sensorEvent.values[2] );

             xValue.setText("xValue: " + sensorEvent.values[0]);
             yValue.setText("yValue: " + sensorEvent.values[1]);
             zValue.setText("zValue: " + sensorEvent.values[2]);

         }else if (sensor.getType()==Sensor.TYPE_GYROSCOPE){
             xGyroValue.setText("xGyroValue: " + sensorEvent.values[0]);
             yGyroValue.setText("yGyroValue: " + sensorEvent.values[1]);
             zGyroValue.setText("zGyroValue: " + sensorEvent.values[2]);

         }else if (sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){
             xMagnoValue.setText("xMagnoValue: " + sensorEvent.values[0]);
             yMagnoValue.setText("yMagnoValue: " + sensorEvent.values[1]);
             zMagnoValue.setText("zMagnoValue: " + sensorEvent.values[2]);

         }else if (sensor.getType()==Sensor.TYPE_LIGHT){
             light.setText("Light: " + sensorEvent.values[0]);
         }else if (sensor.getType()==Sensor.TYPE_PRESSURE){
             pressure.setText("Pressure: " + sensorEvent.values[0]);
         }else if (sensor.getType()==Sensor.TYPE_AMBIENT_TEMPERATURE){
             temp.setText("Temp: " + sensorEvent.values[0]);
         }else if (sensor.getType()==Sensor.TYPE_RELATIVE_HUMIDITY){
             humi.setText("Humi: " + sensorEvent.values[0]);
         }


    }
}
