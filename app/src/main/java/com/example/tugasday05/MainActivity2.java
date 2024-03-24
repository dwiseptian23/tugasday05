package com.example.tugasday05;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    String nama1,kode1,nama_barang1,harga1,total_harga1,diskon_harga1,diskon_member1,tipe_member1,jumlah1;
    TextView selamat, tipe_member2,kode_bar2,nama_bar2,harga2,total_harga2,discount_bar2,discount_mem2,jumlah_harga2;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tampilan();
    }
    public void tampilan(){
        Intent intent = getIntent();
        nama1 = intent.getStringExtra("nama");
        kode1 = intent.getStringExtra("kode");
        nama_barang1 = intent.getStringExtra("nama_bar");
        harga1=intent.getStringExtra("harga");
        total_harga1=intent.getStringExtra("total");
        diskon_harga1=intent.getStringExtra("diskon_har");
        diskon_member1=intent.getStringExtra("diskon_mem");
        tipe_member1=intent.getStringExtra("tipe_mem");
        jumlah1 =intent.getStringExtra("jumlah");

        selamat=findViewById(R.id.Hello);
        tipe_member2=findViewById(R.id.tipe_member);
        kode_bar2=findViewById(R.id.kode_bar);
        nama_bar2=findViewById(R.id.nama_bar);
        harga2=findViewById(R.id.harga);
        total_harga2=findViewById(R.id.total_harga);
        discount_bar2=findViewById(R.id.discount_bar);
        discount_mem2=findViewById(R.id.discount_mem);
        jumlah_harga2=findViewById(R.id.jumlah_harga);

        selamat.setText(getString(R.string.selamat_datang)+nama1.toString());
        tipe_member2.setText(getString(R.string.tipe_pelanggan)+tipe_member1.toString());
        kode_bar2.setText(getString(R.string.kode_barang)+kode1.toString());
        nama_bar2.setText(getString(R.string.nama_barang)+nama_barang1.toString());
        harga2.setText(getString(R.string.harga)+harga1.toString());
        total_harga2.setText(getString(R.string.total_harga) +total_harga1.toString());
        discount_bar2.setText(getString(R.string.diskon_harga) +diskon_harga1.toString());
        discount_mem2.setText(getString(R.string.diskon_member)+diskon_member1.toString());
        jumlah_harga2.setText(getString(R.string.jumlah_bayar) +jumlah1.toString());

    }
    public void share1(View v){
        Intent i = new Intent(android.content.Intent.ACTION_SEND);
        i.setType("text/plain");
        String pesan= ("nama barang : "+nama_barang1.toString()+"/nTotal Transaksi Anda "+jumlah1.toString());
        i.putExtra(android.content.Intent.EXTRA_TEXT, pesan);
        startActivity(Intent.createChooser(i, "Choose an Email client :"));
    }
}