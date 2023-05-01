package com.example.milkmantra;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import model.User;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    Context c;
    ArrayList<User> User;

    private RecyclerView recyclerView;

    private int ADS = 1;
    private int CONTENT = 2;

    /*
 CONSTRUCTOR
  */
    public MyAdapter(Context c, ArrayList<User> User, RecyclerView recyclerView) {
        this.c = c;
        this.User = User;
        this.recyclerView = recyclerView;


    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return CONTENT;
        } else
            //return ADS;
            return CONTENT;
    }

    //INITIALIE VH
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == CONTENT) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, parent, false);
            MyHolder holder = new MyHolder(v);
            return holder;
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_model, parent, false);
            MyHolder holder = new MyHolder(v);
            return holder;
        }

    }

    //BIND DATA
    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        try {
            if (getItemViewType(position) == CONTENT) {



                //Toast.makeText(c, User.get(position).gettaluka_current().toString() + " " + User.get(position).gettaluka_to_transfer().toString(), Toast.LENGTH_SHORT).show();

                if (User.get(position).gettaluka_current().toString().equalsIgnoreCase("0")) {
                    holder.txtcurrent_taluka.setVisibility(View.GONE);
                    holder.txttranfer_to_taluka.setVisibility(View.GONE);
                    holder.txtthi2_1.setVisibility(View.GONE);
                } else {
                    try {
                       // holder.txtcurrent_taluka.setText(TalukatArray[Integer.valueOf(User.get(position).gettaluka_current().toString())]);
                      //  holder.txttranfer_to_taluka.setText(TalukatArray[Integer.valueOf(User.get(position).gettaluka_to_transfer().toString())]);
                    } catch (Exception e) {
                    }
                }


                Typeface typefacename = Typeface.createFromAsset(c.getAssets(), "fonts/shruti.ttf");

                holder.txtjavano_Rasto_che.setTypeface(typefacename);
                holder.txtshala_nu_naam.setTypeface(typefacename);
                holder.txtname.setTypeface(typefacename);
                holder.txtvatna.setTypeface(typefacename);
                holder.txttransfer_option_1.setTypeface(typefacename);
                holder.txttransfer_option_2.setTypeface(typefacename);
                holder.txttransfer_option_3.setTypeface(typefacename);
                holder.txttransfer_option_4.setTypeface(typefacename);
                holder.txttransfer_option_5.setTypeface(typefacename);
                holder.txtaapeloptin.setTypeface(typefacename);
                holder.txtthi.setTypeface(typefacename);
                holder.txtthi1.setTypeface(typefacename);
                holder.txtshala.setTypeface(typefacename);
                holder.txtthi2.setTypeface(typefacename);
                holder.txtthi2_1.setTypeface(typefacename);
                holder.txtthi3.setTypeface(typefacename);
                holder.txtdob.setTypeface(typefacename);
                holder.txtvatna.setTypeface(typefacename);

                //If no data make it invisible
                Make_Invisible(holder, position);
                holder.bind(position);
            } else {
                holder.txtposition.setText("" + position);



                //  Toast.makeText(c, User.get(position).gettaluka_current().toString() + " " + User.get(position).gettaluka_to_transfer().toString(), Toast.LENGTH_SHORT).show();
                if (User.get(position).gettaluka_current().toString().equalsIgnoreCase("0")) {
                    holder.txtcurrent_taluka.setVisibility(View.GONE);
                    holder.txttranfer_to_taluka.setVisibility(View.GONE);
                    holder.txtthi2_1.setVisibility(View.GONE);
                } else {
                    try {
                      //   holder.txtcurrent_taluka.setText(TalukatArray[Integer.valueOf(User.get(position).gettaluka_current().toString())]);
                      //  holder.txttranfer_to_taluka.setText(TalukatArray[Integer.valueOf(User.get(position).gettaluka_to_transfer().toString())]);
                    } catch (Exception e) {
                    }
                }


                Typeface typefacename = Typeface.createFromAsset(c.getAssets(), "fonts/shruti.ttf");

                holder.txtjavano_Rasto_che.setTypeface(typefacename);
                holder.txtshala_nu_naam.setTypeface(typefacename);
                holder.txtname.setTypeface(typefacename);
                holder.txtvatna.setTypeface(typefacename);
                holder.txttransfer_option_1.setTypeface(typefacename);
                holder.txttransfer_option_2.setTypeface(typefacename);
                holder.txttransfer_option_3.setTypeface(typefacename);
                holder.txttransfer_option_4.setTypeface(typefacename);
                holder.txttransfer_option_5.setTypeface(typefacename);
                holder.txtaapeloptin.setTypeface(typefacename);
                holder.txtthi.setTypeface(typefacename);
                holder.txtthi1.setTypeface(typefacename);
                holder.txtshala.setTypeface(typefacename);
                holder.txtthi2.setTypeface(typefacename);
                holder.txtthi3.setTypeface(typefacename);
                holder.txtdob.setTypeface(typefacename);
                holder.txtvatna.setTypeface(typefacename);
                holder.txtthi2_1.setTypeface(typefacename);
                //If no data make it invisible
                Make_Invisible(holder, position);
                holder.bind(position);
            }
        } catch (Exception e) {

        }
    }

    private void Make_Invisible(MyHolder holder, int position) {

        if (User.get(position).getName().toString().trim().equals("") || User.get(position).getName().toString().trim().equals("null"))
            holder.txtname.setText("  -");
        if (User.get(position).gethome_Address().toString() == "")
            holder.txtvatna.setVisibility(View.GONE);
        if (User.get(position).getEmail().toString().trim().equals(""))
            holder.txtemail.setVisibility(View.GONE);
        if (User.get(position).getphone_number().toString().trim().equals(""))
            holder.txtphone.setVisibility(View.GONE);
        if (User.get(position).getdob().toString().trim().equals("") || User.get(position).getdob().toString().trim().equals("null"))
            holder.txtdob.setVisibility(View.GONE);


        if (User.get(position).getq1().toString().trim().equals(""))
            holder.txtnajik_nu_shaer.setVisibility(View.GONE);
        if (User.get(position).getq2().toString().trim().equals(""))
            holder.txtcity_thi_antar.setVisibility(View.GONE);

        if (User.get(position).getq3().toString().trim().equals(""))
            holder.txtjavano_Rasto_che.setVisibility(View.GONE);

        int count = 0;
        if (User.get(position).getTransplace1().toString().trim().equals("") || User.get(position).getTransplace1().toString().trim().equals("null")) {
            holder.txttransfer_option_1.setVisibility(View.GONE);
            count++;
        }
        if (User.get(position).getTransplace2().toString().trim().equals("") || User.get(position).getTransplace2().toString().trim().equals("null")) {
            holder.txttransfer_option_2.setVisibility(View.GONE);
            count++;
        }
        if (User.get(position).getTransplace3().toString().trim().equals("") || User.get(position).getTransplace3().toString().trim().equals("null")) {
            holder.txttransfer_option_3.setVisibility(View.GONE);
            count++;
        }

        if (User.get(position).getTransplace4().toString().trim().equals("") || User.get(position).getTransplace4().toString().trim().equals("null")) {
            holder.txttransfer_option_4.setVisibility(View.GONE);
            count++;
        }
        if (User.get(position).getTransplace5().toString().trim().equals("") || User.get(position).getTransplace5().toString().trim().equals("null")) {
            holder.txttransfer_option_5.setVisibility(View.GONE);
            count++;
        }

        if (count >= 5) {
            holder.txttransfer_option_1.setText("-");
        }

        count = 0;
    }

    /*
    TOTAL ITEMS
     */
    @Override
    public int getItemCount() {
        return User.size();

    }

    /*
    ADD DATA TO ADAPTER
     */
    public void add(User s) {
        User.add(s);
        notifyDataSetChanged();
    }

    public User getItem(int position) {
        return User.get(position);
    }

    /*
    CLEAR DATA FROM ADAPTER
     */
    public void clear() {
        User.clear();
        notifyDataSetChanged();
    }

    /*
    VIEW HOLDER CLASS
     */
    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtname, txtvatna, txtshala_nu_naam, txtemail, txtphone, txtdob, txtthi1, txtthi2, txtthi2_1, txtthi3, txtthi, txtnajik_nu_shaer, txtcity_thi_antar, txtjavano_Rasto_che, txttransfer_option_1,
                txttransfer_option_2, txttransfer_option_3, txttransfer_option_4, txttransfer_option_5, txtaapeloptin, txtcurrent_dist, txttranfer_to, txtshala, txtcurrent_taluka, txttranfer_to_taluka, txtviewmore, txtposition;
        LinearLayout detail_linear_layout;
        private int position;
        ImageView imgview_call, imgview_email;

        public void bind(int position) {
            this.position = position;

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.imgview_call:
                    String phone = txtphone.getText().toString().replace("\\", "#");
                    if (phone.contains("#")) {
                        String Str_Phone_with_slash[] = phone.split("#");
                        phone = Str_Phone_with_slash[0];
                    }

                    Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts(
                            "tel", phone, null));
                    c.startActivity(phoneIntent);
                    break;

                case R.id.imgview_email:
                    String email = txtemail.getText().toString();
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto", email, null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                    c.startActivity(Intent.createChooser(emailIntent, "Send email..."));
                    break;
                case R.id.txtviewmore:
                    final Dialog dialog = new Dialog(c);

                    dialog.setTitle("Title...");
                    Window window = dialog.getWindow();
                    window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    ////////////////////////////////////////////

                    final TextView txtname, txtvatna, txtshala_nu_naam, txtemail, txtphone, txtdob, txtthi1, txtthi2, txtthi2_1, txtthi3, txtthi, txtnajik_nu_shaer, txtcity_thi_antar, txtjavano_Rasto_che, txttransfer_option_1,
                            txttransfer_option_2, txttransfer_option_3, txttransfer_option_4, txttransfer_option_5, txtaapeloptin, txtcurrent_dist, txttranfer_to, txtshala, txtcurrent_taluka, txttranfer_to_taluka, txtviewmore;
                    final LinearLayout detail_linear_layout;

                    txtname = (TextView) dialog.findViewById(R.id.txtname);
                    txtvatna = (TextView) dialog.findViewById(R.id.txtvatna);
                    txtemail = (TextView) dialog.findViewById(R.id.txtemail);
                    txtphone = (TextView) dialog.findViewById(R.id.txtphone);
                    txtdob = (TextView) dialog.findViewById(R.id.txtdob);
                    txtcurrent_dist = (TextView) dialog.findViewById(R.id.txtcurrent_dist);
                    txtshala_nu_naam = (TextView) dialog.findViewById(R.id.txtshala_nu_naam);
                    txtnajik_nu_shaer = (TextView) dialog.findViewById(R.id.txtnajik_nu_shaer);
                    txtcity_thi_antar = (TextView) dialog.findViewById(R.id.txtcity_thi_antar);
                    txtjavano_Rasto_che = (TextView) dialog.findViewById(R.id.txtjavano_Rasto_che);
                    txttranfer_to = (TextView) dialog.findViewById(R.id.txttranfer_to);
                    txttransfer_option_1 = (TextView) dialog.findViewById(R.id.txttransfer_option_1);
                    txttransfer_option_2 = (TextView) dialog.findViewById(R.id.txttransfer_option_2);
                    txttransfer_option_3 = (TextView) dialog.findViewById(R.id.txttransfer_option_3);
                    txttransfer_option_4 = (TextView) dialog.findViewById(R.id.txttransfer_option_4);
                    txttransfer_option_5 = (TextView) dialog.findViewById(R.id.txttransfer_option_5);
                    txtaapeloptin = (TextView) dialog.findViewById(R.id.txtaapel_option);
                    txtthi = (TextView) dialog.findViewById(R.id.txtthi);
                    txtthi1 = (TextView) dialog.findViewById(R.id.txtthi1);
                    txtshala = (TextView) dialog.findViewById(R.id.txtshala);
                    txtthi2 = (TextView) dialog.findViewById(R.id.txtthi2);
                    txtthi2_1 = (TextView) dialog.findViewById(R.id.txtthi2_1);
                    txtthi3 = (TextView) dialog.findViewById(R.id.txtthi3);
                    txtcurrent_taluka = (TextView) dialog.findViewById(R.id.txtcurrent_taluka);
                    txttranfer_to_taluka = (TextView) dialog.findViewById(R.id.txttranfer_to_taluka);
                    txtviewmore = (TextView) dialog.findViewById(R.id.txtviewmore);
                    detail_linear_layout = (LinearLayout) dialog.findViewById(R.id.detail_linear_layout);

                    imgview_call = (ImageView) dialog.findViewById(R.id.imgview_call);
                    imgview_email = (ImageView) dialog.findViewById(R.id.imgview_email);
                    imgview_call.setVisibility(View.GONE);
                    imgview_email.setVisibility(View.GONE);

                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialogInterface) {
                            detail_linear_layout.setVisibility(View.GONE);
                            txtviewmore.setVisibility(View.VISIBLE);
                            txtviewmore.setText("View Details");
                        }
                    });


                    detail_linear_layout.setVisibility(View.VISIBLE);
                    txtviewmore.setText("Close");
                    txtviewmore.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });



                    //Toast.makeText(c, User.get(position).gettaluka_current().toString() + " " + User.get(position).gettaluka_to_transfer().toString(), Toast.LENGTH_SHORT).show();

                    if (User.get(position).gettaluka_current().toString().equalsIgnoreCase("0")) {
                        txtcurrent_taluka.setVisibility(View.GONE);
                        txttranfer_to_taluka.setVisibility(View.GONE);
                        txtthi2_1.setVisibility(View.GONE);
                    } else {
                        try {

                        } catch (Exception e) {
                        }
                    }



                    Typeface typefacename = Typeface.createFromAsset(c.getAssets(), "fonts/shruti.ttf");

                    txtjavano_Rasto_che.setTypeface(typefacename);
                    txtshala_nu_naam.setTypeface(typefacename);
                    txtname.setTypeface(typefacename);
                    txtvatna.setTypeface(typefacename);
                    txttransfer_option_1.setTypeface(typefacename);
                    txttransfer_option_2.setTypeface(typefacename);
                    txttransfer_option_3.setTypeface(typefacename);
                    txttransfer_option_4.setTypeface(typefacename);
                    txttransfer_option_5.setTypeface(typefacename);
                    txtaapeloptin.setTypeface(typefacename);
                    txtthi.setTypeface(typefacename);
                    txtthi1.setTypeface(typefacename);
                    txtshala.setTypeface(typefacename);
                    txtthi2.setTypeface(typefacename);
                    txtthi2_1.setTypeface(typefacename);
                    txtthi3.setTypeface(typefacename);
                    txtdob.setTypeface(typefacename);
                    txtvatna.setTypeface(typefacename);
                    /////////////////////////////////////////////

                    dialog.show();
                    break;
            }

        }


        public MyHolder(View itemView) {
            super(itemView);


            this.detail_linear_layout = (LinearLayout) itemView.findViewById(R.id.detail_linear_layout);
            this.txtname = (TextView) itemView.findViewById(R.id.txtname);
            this.txtvatna = (TextView) itemView.findViewById(R.id.txtvatna);

            this.txtemail = (TextView) itemView.findViewById(R.id.txtemail);
            this.txtphone = (TextView) itemView.findViewById(R.id.txtphone);
            this.txtdob = (TextView) itemView.findViewById(R.id.txtdob);
            this.txtposition = (TextView) itemView.findViewById(R.id.txtposition);


            this.txtcurrent_dist = (TextView) itemView.findViewById(R.id.txtcurrent_dist);
            this.txtshala_nu_naam = (TextView) itemView.findViewById(R.id.txtshala_nu_naam);

            this.txtnajik_nu_shaer = (TextView) itemView.findViewById(R.id.txtnajik_nu_shaer);
            this.txtcity_thi_antar = (TextView) itemView.findViewById(R.id.txtcity_thi_antar);
            this.txtjavano_Rasto_che = (TextView) itemView.findViewById(R.id.txtjavano_Rasto_che);

            this.txttranfer_to = (TextView) itemView.findViewById(R.id.txttranfer_to);
            this.txttransfer_option_1 = (TextView) itemView.findViewById(R.id.txttransfer_option_1);

            this.txttransfer_option_2 = (TextView) itemView.findViewById(R.id.txttransfer_option_2);

            this.txttransfer_option_3 = (TextView) itemView.findViewById(R.id.txttransfer_option_3);

            this.txttransfer_option_4 = (TextView) itemView.findViewById(R.id.txttransfer_option_4);

            this.txttransfer_option_5 = (TextView) itemView.findViewById(R.id.txttransfer_option_5);


            this.txtaapeloptin = (TextView) itemView.findViewById(R.id.txtaapel_option);

            this.txtthi = (TextView) itemView.findViewById(R.id.txtthi);

            this.txtthi1 = (TextView) itemView.findViewById(R.id.txtthi1);

            this.txtshala = (TextView) itemView.findViewById(R.id.txtshala);

            this.txtthi2 = (TextView) itemView.findViewById(R.id.txtthi2);
            this.txtthi2_1 = (TextView) itemView.findViewById(R.id.txtthi2_1);

            this.txtthi3 = (TextView) itemView.findViewById(R.id.txtthi3);

            this.txtcurrent_taluka = (TextView) itemView.findViewById(R.id.txtcurrent_taluka);
            this.txttranfer_to_taluka = (TextView) itemView.findViewById(R.id.txttranfer_to_taluka);

            imgview_email = (ImageView) itemView.findViewById(R.id.imgview_email);
            imgview_email.setOnClickListener(this);

            txtviewmore = (TextView) itemView.findViewById(R.id.txtviewmore);
            txtviewmore.setOnClickListener(this);

            imgview_call = (ImageView) itemView.findViewById(R.id.imgview_call);
            imgview_call.setOnClickListener(this);

        }


    }

}
