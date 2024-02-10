package com.lib.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ApartmentActivity extends AppCompatActivity {
    private RequestQueue queue;
    private ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment);

        queue = Volley.newRequestQueue(this);
        lst = findViewById(R.id.lstApartments);
    }

    public void btnView_Click(View view){

        EditText edtAddress = findViewById(R.id.edtAddress);
        String address = edtAddress.getText().toString().trim();

        String url = "http://192.168.1.119:5000/apartment/"+address;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList<String> addresses = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        addresses.add(obj.getString("address"));
                    } catch (JSONException exception) {
                        Log.d("volley_error", exception.toString());
                    }
                }

                String[] arr = new String[addresses.size()];
                arr = addresses.toArray(arr);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        ApartmentActivity.this, android.R.layout.simple_list_item_1,
                        arr);
                lst.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("volley_error", error.toString());
            }
        });

        queue.add(request);
    }
}