package com.example.myhealthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Name : Dr.Shishir Gupta","Hospital Address : Vijay Nagar", "Exp : 30yrs", "Mobile No:9416400248","600"},
                    {"Name : Dr.Neelima Deshmukh","Hospital Address : Manorama Ganj", "Exp : 28yrs", "Mobile No:9669431993","700"},
                    {"Name : Dr.Pravin Dani","Hospital Address : Vijay Nagar", "Exp : 23yrs", "Mobile No:7312558778","300"},
                    {"Name : Dr.Sanjay Gujrati","Hospital Address : Vishesh Jupiter Hospital", "Exp : 25yrs", "Mobile No:7314718111","500"},
                    {"Name : Dr.Fatema Chahwala","Hospital Address : Sneh nagar", "Exp : 20yrs", "Mobile No:9098938521","800"}
            };
    private String[][] doctor_details2 =
            {
                    {"Name : Dr.Preeti Shukla","Hospital Address : Old Palasia", "Exp : 20yrs", "Mobile No:9977600104","600"},
                    {"Name : Dr.Shivani Lodha","Hospital Address : Chappan Dukan", "Exp : 12yrs", "Mobile No:9165306356","900"},
                    {"Name : Dr.Vinita Jaiswal","Hospital Address : Shivaji Nagar", "Exp : 24yrs", "Mobile No:9009013363","300"},
                    {"Name : Dr.Priya Chitale","Hospital Address :  Vijay Nagar", "Exp : 20yrs", "Mobile No:7312362491","500"},
                    {"Name : Dr.Vibhooti Trivedi","Hospital Address : Raj Twp", "Exp : 19yrs", "Mobile No:7312362491","800"}
            };
    private String[][] doctor_details3 =
            {
                    {"Name : Dr.Ashok Paranjape","Hospital Address : LIG Main Rd", "Exp : 35yrs", "Mobile No:7312553627","600"},
                    {"Name : Dr.Surendra Dilliwal","Hospital Address : Old Palasia", "Exp : 37yrs", "Mobile No:7312560127","900"},
                    {"Name : Dr.Shailendra Bhandari","Hospital Address : Old Palasia", "Exp :35yrs", "Mobile No:9826610050","300"},
                    {"Name : Dr.Avijit Mitra","Hospital Address : Opposite Starlit Tower", "Exp : 36yrs", "Mobile No:9826043434","500"},
                    {"Name : Dr.Manoj Patni","Hospital Address : Rajwada", "Exp : 35yrs", "Mobile No:7312341122","800"}
            };
    private String[][] doctor_details4 =
            {
                    {"Name : Dr.Sandeep Rathore","Hospital Address : Vijay Nagar", "Exp : 25yrs", "Mobile No:7947293390","600"},
                    {"Name : Dr.Amitabh Goel","Hospital Address : Old Palasia", "Exp : 15yrs", "Mobile No:7947292574","900"},
                    {"Name : Dr.Vijay Nichani","Hospital Address : Sapna Sangeeta", "Exp : 28yrs", "Mobile No:7947292202","300"},
                    {"Name : Dr.Ajay Padmakar Choudhary","Hospital Address : Rajendra Nagar", "Exp : 26yrs", "Mobile No:7947293335","500"},
                    {"Name : Dr.Achal Agrawal","Hospital Address : Janjeerwala Square", "Exp : 32yrs", "Mobile No:7574858085","800"}
            };
    private String[][] doctor_details5 =
            {
                    {"Name : Dr.Manoj Bansal","Hospital Address : Bombay", "Exp : 21yrs", "Mobile No:7314771111","700"},
                    {"Name : Dr.Mohammed Ali","Hospital Address : Apollo", "Exp : 19yrs", "Mobile No:7312445566","1200"},
                    {"Name : Dr.Kshitij Dubey","Hospital Address : Vijay Nagar", "Exp : 18yrs", "Mobile No:7312445566","500"},
                    {"Name : Dr.Nirag Tupkar","Hospital Address : HealthHare Clinic", "Exp : 14yrs", "Mobile No:7312552422","600"},
                    {"Name : Dr.Sarita Rao","Hospital Address : Apollo", "Exp : 21yrs", "Mobile No:7312445566","900"}
            };
    TextView tv;
    Button btn;
    String [] [] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list ;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<doctor_details.length;i++){
          item = new HashMap<String, String>();
          item.put("line1",doctor_details[i][0]);
          item.put("line2",doctor_details[i][1]);
          item.put("line3",doctor_details[i][2]);
          item.put("line4",doctor_details[i][3]);
          item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
          list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.muli_lines,
                new String[]{"line1","line2","line3","line4","line5",},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}