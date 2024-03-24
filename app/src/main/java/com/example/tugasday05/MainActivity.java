package com.example.tugasday05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText nama1;
    EditText kode1;
    EditText jumlah1;
    Button button;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    Integer diskon, harga, total_harga, diskon_harga,diskon_member, jumlah_bayar,jumlah2;
    String nama_barang,member;
    String kode2,nama2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void Hitung(View v){
        nama1 = findViewById(R.id.nama);
        kode1 = findViewById(R.id.kode);
        jumlah1 = findViewById(R.id.jumlah);
        jumlah2 = Integer.parseInt(jumlah1.getText().toString());
        button = findViewById(R.id.proses);
        radio1 = findViewById(R.id.Gold);
        radio2 = findViewById(R.id.Silver);
        radio3 = findViewById(R.id.Biasa);

        kode2 =kode1.getText().toString();
        nama2 =nama1.getText().toString();

        if (radio1.isChecked()) {
            diskon = 10;
            member = "Gold";
        }
        else if (radio2.isChecked()) {
            diskon = 5;
            member = "Silver";
        }
        else  {
            diskon = 2;
            member = "Biasa";
        }

        if (kode1.getText().toString().equals("AAE")){
            nama_barang = "Acer aspire E14";
            harga = 8676981;
        }else if (kode1.getText().toString().equals("AV4")){
            nama_barang = "Asus Vivobook 14";
            harga = 9150999;
        }else{
            nama_barang = "Macbook Pro";
            harga = 28999999;
        }

        total_harga = harga * jumlah2 ;
        if(total_harga>10000000){
            diskon_harga = 100000;
        }else{
            diskon_harga =0;
        }
        diskon_member = total_harga * diskon/100;
        jumlah_bayar= total_harga-diskon_harga-diskon_member;
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("kode", kode2);
        intent.putExtra("nama", nama2);
        intent.putExtra("nama_bar", nama_barang);
        intent.putExtra("harga", harga.toString());
        intent.putExtra("total", total_harga.toString());
        intent.putExtra("diskon_har", diskon_harga.toString());
        intent.putExtra("diskon_mem", diskon_member.toString());
        intent.putExtra("tipe_mem", member.toString());
        intent.putExtra("jumlah", jumlah_bayar.toString());
        startActivity(intent);
    }
}