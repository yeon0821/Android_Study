package org.techtown.teamproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TextView  viewDatePick;
    EditText edtDiary;
    Button btnSave;

    String fileName;
    String readDay;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("내장메모리에 일기를 저장하고 읽을 수 있는 간단한 일기장 앱");


        datePicker = (DatePicker) findViewById(R.id.datePicker);
        viewDatePick = (TextView) findViewById(R.id.viewDatePick);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnSave = (Button) findViewById(R.id.btnSave);

        Calendar c = Calendar.getInstance();
        int cYear = c.get(Calendar.YEAR);
        int cMonth = c.get(Calendar.MONTH);
        int cDay = c.get(Calendar.DAY_OF_MONTH);

        checkedDay(cYear, cMonth, cDay);

        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                checkedDay(year,monthOfYear,dayOfMonth);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDiary(fileName);
            }

            private void saveDiary(String fileName) {
            }
        }


            private void checkedDay(int year, int monthOfYear, int dayOfMonth) {
                viewDatePick.setText(year + " - " + monthOfYear + " - " + dayOfMonth);

                fileName = year + "" + monthOfYear + "" + dayOfMonth + ".txt";

                FileInputStream fis = null;
                try {
                    fis = openFileInput(fileName);

                    byte[] fileDate = new byte[fis.available()];
                    fis.read(fileDate);
                    fis.close();

                    String str = new String(fileDate, "EUC-KR");
                    Toast.makeText(getApplicationContext(), "일기 써둔 날", Toast.LENGTH_SHORT).show();
                    edtDiary.setText(str);
                    btnSave.setText("수정하기");
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "일기 없는 날", Toast.LENGTH_SHORT).show();
                    edtDiary.setText("");;
                    btnSave.setText("새 일기 저장");
                    e.printStackTrace();
                }
            }

            // 일기 저장하는 메소드
            private void saveDiary(String readDay) {

                FileOutputStream fos = null;

                try {
                    fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS); //MODE_WORLD_WRITEABLE
                    String content = edtDiary.getText().toString();

                    // String.getBytes() = 스트링을 배열형으로 변환?
                    fos.write(content.getBytes());
                    //fos.flush();
                    fos.close();

                    // getApplicationContext() = 현재 클래스.this ?
                    Toast.makeText(getApplicationContext(), "일기 저장됨", Toast.LENGTH_SHORT).show();

                } catch (Exception e) { // Exception - 에러 종류 제일 상위 // FileNotFoundException , IOException
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "오류오류", Toast.LENGTH_SHORT).show();
                }
            }










}

    private void checkedDay(int cYear, int cMonth, int cDay) {
    }