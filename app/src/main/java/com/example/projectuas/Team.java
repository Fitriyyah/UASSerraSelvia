package com.example.projectuas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Team extends AppCompatActivity {

    android.widget.ListView listView;
    String mTitle[] = {"Chocolate De Ville", "Triple Chocolate","Chocomaltine Cheese Cake", "Strawberry Cheesecake","Regal Chocolate",  "Vanilla Fruits", "Magnifique","Tiramisu"};
    String mDescription[] = {"Rp.377", "Rp.220", "", "Rp.330", "Rp.330", "Rp.290","Rp.190","Rp.190" };
    int image[] = {R.drawable.hv, R.drawable.hv3, R.drawable.hv11, R.drawable.hv4, R.drawable.hv12, R.drawable.hv10, R.drawable.hv5, R.drawable.hv15};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        listView = findViewById(R.id.mylistview);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, image);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), store.class);
                    intent.putExtra("Position",id);
                    startActivity(intent);
                    Toast.makeText(Team.this, "The Harvest Desc", Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), store.class);
                    intent.putExtra("Position",id);
                    startActivity(intent);
                    Toast.makeText(Team.this, "The Harvest Desc", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), store.class);
                    intent.putExtra("Position",id);
                    startActivity(intent);
                    Toast.makeText(Team.this, "The Harvest Desc", Toast.LENGTH_SHORT).show();
                }
                if (position == 3) {
                    Toast.makeText(Team.this, "The Harvest Desc", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView (int position, View convertView, ViewGroup parent){

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView image = row.findViewById(R.id.imagee);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            image.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }

}
