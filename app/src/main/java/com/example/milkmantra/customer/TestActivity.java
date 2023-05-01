/*package com.example.milkmantra.customer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.milkmantra.ConnectionDetector;
import com.example.milkmantra.MyAdapter;
import com.example.milkmantra.MyApplication_OnlineTransfer;
import com.example.milkmantra.R;
import com.example.milkmantra.url_cryto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.User;

public class TestActivity extends AppCompatActivity {
    RecyclerView Recycle_latest_updates;
    private MyAdapter adapter_fb;
    ConnectionDetector cd;
    Boolean isInternetPresent = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testactivity);
        cd = new ConnectionDetector(getBaseContext());
        Recycle_latest_updates = (RecyclerView) findViewById(R.id.Recycle_latest_updates);
        Recycle_latest_updates.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter_fb = new MyAdapter(this, new ArrayList<User>(), Recycle_latest_updates);
        Recycle_latest_updates.setAdapter(adapter_fb);
        Fetch_users_want_toTransfer(this, 1, 1, "", "", "", "");


    }

    private void Fetch_users_want_toTransfer(final Context context, int checked_current_district, int checked_trans_district, String name, String email, String phonenumber, String maincity) {
        adapter_fb.clear();
        //CAll If Internet is available
        cd = new ConnectionDetector(context);
        isInternetPresent = cd.isConnectingToInternet();

        final String FromId = "8";
        name = name.equalsIgnoreCase("") ? "$" : name;
        email = email.equalsIgnoreCase("") ? "$" : email;
        phonenumber = phonenumber.equalsIgnoreCase("") ? "$" : phonenumber;
        maincity = maincity.equalsIgnoreCase("") ? "$" : maincity;

        // check for Internet status
        if (isInternetPresent) {

            // Toast.makeText(context, "Name " + name + "Email " + email + " phonenumber " + phonenumber + " maincity " + maincity, Toast.LENGTH_SHORT).show();
            StringRequest strReq = new StringRequest(Request.Method.POST,
                    url_cryto.decrypt("URL"), new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    //UPDATE PROPETIES

                    try {

                        JSONObject obj = new JSONObject(response);
                        //txtmessage.setText(obj.getString("message"));

                        // check for error flag
                        if (obj.getBoolean("error") == false) {
                            //Get random_users And show it in Top Horizontal View
                            JSONArray random_usersarray = obj.getJSONArray("random_users");

                            for (int i = 0; i < random_usersarray.length(); i++) {
                                JSONObject randomuserObj = (JSONObject) random_usersarray.get(i);

                                User ObjUsr = new User();
                                //id, name, email, dob, home_Address, phone_number, current_place,
                                // transplace1, transplace2, transplace3, transplace4, transplace5,
                                if (!randomuserObj.getString("id").equals("0")) {
                                    ObjUsr.setId(randomuserObj.getString("id"));
                                    ObjUsr.setName(randomuserObj.getString("name"));
                                    ObjUsr.setEmail(randomuserObj.getString("email"));

                                    ObjUsr.setdob(randomuserObj.getString("dob"));
                                    ObjUsr.sethome_Address(randomuserObj.getString("home_Address"));
                                    ObjUsr.setphone_number(randomuserObj.getString("phone_number"));

                                    ObjUsr.setCurrent_place(randomuserObj.getString("current_place"));
                                    ObjUsr.setTransplace1(randomuserObj.getString("transplace1"));
                                    ObjUsr.setTransplace2(randomuserObj.getString("transplace2"));

                                    ObjUsr.setTransplace3(randomuserObj.getString("transplace3"));
                                    ObjUsr.setTransplace4(randomuserObj.getString("transplace4"));
                                    ObjUsr.setTransplace5(randomuserObj.getString("transplace5"));

                                    // sex, marrital_status, current_dist, dist_to_transfer, q1, q2, q3
                                    ObjUsr.setsex(randomuserObj.getString("sex"));
                                    ObjUsr.setmarrital_status(randomuserObj.getString("marrital_status"));
                                    ObjUsr.setcurrent_dist(randomuserObj.getString("current_dist"));

                                    ObjUsr.setdist_to_transfer(randomuserObj.getString("dist_to_transfer"));
                                    ObjUsr.setq1(randomuserObj.getString("q1"));
                                    ObjUsr.setq2(randomuserObj.getString("q2"));

                                    ObjUsr.setq3(randomuserObj.getString("q3"));
                                    adapter_fb.add(ObjUsr);
                                } else {
                                    Toast.makeText(context, "No more data available.", Toast.LENGTH_SHORT).show();

                                }

                                // data_user.add(new Data(R.drawable.user_top, randomuserObj.getString("user_id") + "#" + randomuserObj.getString("name") + "\nLast seen :" +randomuserObj.getString("last_online") + "#" + randomuserObj.getString("institute") + "#" + randomuserObj.getString("batch") + "#" + randomuserObj.getString("branch") + "#" + randomuserObj.getString("likes") +"#"+ randomuserObj.getString("isinterested")));
                            }
                            adapter_fb.notifyDataSetChanged();
                            /////////////////////////////////////////////////////////
                        } else {
                            // error in fetching chat rooms
                            Toast.makeText(context, "Check Internet Connection.#1", Toast.LENGTH_SHORT).show();
                        }

                    } catch (JSONException e)
                    {

                        Toast.makeText(context, "Check Internet Connection.#2" + e.toString(), Toast.LENGTH_SHORT).show();
                    }


                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                    NetworkResponse networkResponse = error.networkResponse;
                    Toast.makeText(context, "Check Internet Connection.#3" + error.toString(), Toast.LENGTH_SHORT).show();
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();

                    params.put("myid", 6);
                    return params;
                }

                ;
            };
            // disabling retry policy so that it won't make
            // multiple http calls
            int socketTimeout = 0;
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

            strReq.setRetryPolicy(new DefaultRetryPolicy(0, -1, 0));
            //Adding request to request queue
            MyApplication_OnlineTransfer.getInstance().addToRequestQueue(strReq);

        } else {
            // txtsent_0_row.setText("Check Internet connection & Retry.");
            //btnrequestsent_retry.setVisibility(View.VISIBLE);
            Toast.makeText(context, "Check Internet connection & Retry.", Toast.LENGTH_SHORT).show();
        }
    }
}
