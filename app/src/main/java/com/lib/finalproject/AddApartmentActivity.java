package com.lib.finalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class AddApartmentActivity extends AppCompatActivity {
    private EditText edtAddress, edtRent, edtSpace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apartment);
        edtAddress = findViewById(R.id.edtAddress);
        edtRent = findViewById(R.id.edtRent);
        edtSpace = findViewById(R.id.edtSpace);
    }

    public void btnAdd_Click(View view) {
        String apartAddress = edtAddress.getText().toString();
        String apartRent = edtRent.getText().toString();
        String apartSpace = edtRent.getText().toString();

        addBook(apartAddress, apartRent, apartSpace);
    }

    private void addBook(String address, String rent, String space){
        String url = "http://192.168.1.119:5000/create";

        RequestQueue queue = Volley.newRequestQueue(AddApartmentActivity.this);



        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("address)", address);
            jsonParams.put("rent", rent);
            jsonParams.put("space", space);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Create a JsonObjectRequest with POST method
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonParams,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String str = "";
                        try {
                            str = response.getString("result");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(AddApartmentActivity.this, str,
                                Toast.LENGTH_SHORT).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("VolleyError", error.toString());
                    }
                }
        );
        queue.add(request);
    }

}