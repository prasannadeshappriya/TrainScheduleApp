package com.example.prasanna.trainscheduleapp.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.prasanna.trainscheduleapp.R;
import com.example.prasanna.trainscheduleapp.Utilities.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prasanna on 5/14/17.
 */

public class FeedBackFragment extends Fragment {
    private EditText etEmail;
    private EditText etMessage;
    private Button btnSend;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback,container,false);

        //Initialize variables
        etEmail = (EditText) view.findViewById(R.id.etEmail);
        etMessage = (EditText) view.findViewById(R.id.etMessage);
        btnSend = (Button) view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        send_message();
                    }
                }
        );
        return view;
    }

    private void send_message() {
        Map<String,String> parameters = new HashMap<>();
        parameters.put("email",etEmail.getText().toString());
        parameters.put("message",etMessage.getText().toString());
        parameters.put("token",Constants.SERVER_TOKEN);
        ProgressDialog pd = new ProgressDialog(getContext(),R.style.AppTheme_Dark_Dialog);
        message msg = new message(getContext(),parameters,pd);
        msg.execute();
    }

    private class message extends AsyncTask<Void,Void,Void>{
        private String server_url = Constants.SERVER_HOST_URL;
        private String server_response;
        private Context context;
        private Map<String, String> parameters;
        private ProgressDialog pd;

        public message(Context context, Map<String,String> parameters, ProgressDialog pd){
            this.parameters = parameters;
            this.context = context;
            this.pd = pd;
        }

        @Override
        protected void onPreExecute() {
            pd.setIndeterminate(true);
            pd.setCanceledOnTouchOutside(false);
            pd.setMessage("Sending..");
            pd.show();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            try {
                StringRequest request = new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                server_response = response;
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                server_response = error.toString();
                                printLog("Error caught during request transmission :- " + error.toString());
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> paramMap;
                        paramMap = parameters;
                        return paramMap;
                    }
                };

                request.setTag(Constants.TAG);
                RequestQueue requestQueue = Volley.newRequestQueue(context);
                requestQueue.add(request);

                long start_time = System.currentTimeMillis();
                long duration = 0;
                while (server_response ==null){
                    long present_time = System.currentTimeMillis();
                    duration = (present_time-start_time);
                }
                printLog("Time taken :- " + String.valueOf(duration));
            }catch (Exception e){
                server_response = "Internal Error :- " + e.toString();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            printLog("Response :- " + server_response);
            Toast.makeText(context,"Message Sent",Toast.LENGTH_LONG).show();
            try {
                JSONObject obj = new JSONObject(server_response);
                if (obj.has("error")) {
                    Toast.makeText(context,"Error occurred! [" + obj.getString("error") + "]",Toast.LENGTH_LONG).show();
                    printLog("Error :- " + obj.getString("error"));
                } else {
                    Toast.makeText(context,"Message Sent",Toast.LENGTH_LONG).show();
                    printLog("Message sending successfully");
                }
            } catch (JSONException e) {
                printLog("Invalid response from server :- " + e.toString());
            }
            pd.dismiss();
            TrainScheduleFragment trainScheduleFragment = new TrainScheduleFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
            transaction.replace(R.id.frmMain,trainScheduleFragment);
            transaction.commit();
        }
    }

    private void printLog(String message){
        Log.i(Constants.TAG,"[FeedBackFragment] " + message);
    }
}
