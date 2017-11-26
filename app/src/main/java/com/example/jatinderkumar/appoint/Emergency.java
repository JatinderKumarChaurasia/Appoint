package com.example.jatinderkumar.appoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class Emergency extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] Cities = {"Amritsar", "Ludhiana", "Phaghwara", "Jalandhar", "Pathankot"};

    String[] hospitalAmritsar = {"Fortis Escort Hospital", "Amandeep Hospital", "Hartej Hospital", "Uppal Neuro Hospital"};
    String[] hospitalPhaghwara = {"Swaran Hospital", "Malhotra Hospital"};
    String[] hospitalLudhiana = {"SPS Apollo Hospital", "CMC Hospital", "DMC Hospital", "Fortis Hospital"};
    String[] hospitalJalandhar = {"Patel Hospital", "Kidney Hospital", "Aashirwad Hospital", "SGL Hospital"};
    String[] hospitalPathankot = {"Care Hospital", "Sandhu Hospital", "North Central Hospital"};

    Spinner spinner;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_emergency );
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        spinner = (Spinner) findViewById( R.id.spinner );
        listView = (ListView) findViewById( R.id.listView );
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, Cities );
        spinner.setAdapter( adapter );
        spinner.setOnItemSelectedListener( this );

    }

    @Override
    public void onItemSelected(final AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                ArrayAdapter<String> adapter = new ArrayAdapter<String>( parent.getContext(), android.R.layout.simple_list_item_1, hospitalAmritsar );
                listView.setAdapter( adapter );
                //listener listener = new listener();
                //listView.setOnClickListener( listener );
                listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                Intent fe = new Intent(Emergency.this,Emergency_Call.class);
                                fe.putExtra("Phone","01833012222");
                                fe.putExtra( "Name","Fortis Escorts Hospital" );
                                fe.putExtra( "Address","Majitha-Verka Bypass Road, Amritsar, Punjab 143004" );
                                startActivity(fe);
                                break;
                            case 1:
                                Intent ah = new Intent(Emergency.this,Emergency_Call.class);
                                ah.putExtra("Phone","+919876002746");
                                ah.putExtra( "Name","Amandeep Hospital" );
                                ah.putExtra( "Address","G.T. Road, Model Town, Amritsar, Punjab 143001" );
                                startActivity(ah);
                                break;
                            case 2:
                                Intent hh = new Intent(Emergency.this,Emergency_Call.class);
                                hh.putExtra("Phone","01832503613");
                                hh.putExtra( "Name","Hartej Hospital" );
                                hh.putExtra( "Address","A-290-293, Court Rd, A - Block, Ranjit Avenue, Amritsar, Punjab 143001" );
                                startActivity(hh);
                                break;
                            case 3:
                                Intent unh = new Intent(Emergency.this,Emergency_Call.class);
                                unh.putExtra("Phone","01832211696");
                                unh.putExtra( "Name","Uppal Neuro Hospital" );
                                unh.putExtra( "Address","4, Rani Ka Bagh, Kennedy Avenue, Near SBI, Amritsar, Punjab 143001" );
                                startActivity(unh);
                                break;

                        }

                    }
                });
                break;
            case 1:
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(parent.getContext(),android.R.layout.simple_list_item_1,hospitalLudhiana);
                listView.setAdapter(adapter1);
                listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                Intent aph = new Intent(Emergency.this,Emergency_Call.class);
                                aph.putExtra("Phone","01616617111");
                                aph.putExtra( "Name","SPS Apollo Hospital" );
                                aph.putExtra( "Address","Grand Trunk Rd, Sherpur Chowk, Sherpur, Ludhiana, Punjab 141001" );
                                startActivity(aph);
                                break;
                            case 1:
                                Intent cmch = new Intent(Emergency.this,Emergency_Call.class);
                                cmch.putExtra("Phone","01612115000");
                                cmch.putExtra( "Name","CMC Hospital" );
                                cmch.putExtra( "Address","Brown Road, CMC Campus, Ludhiana, Punjab 141008" );
                                startActivity(cmch);
                                break;
                            case 2:
                                Intent hh = new Intent(Emergency.this,Emergency_Call.class);
                                hh.putExtra("Phone","01614688800");
                                hh.putExtra( "Name","DMC Hospital" );
                                hh.putExtra( "Address","Rajpura Road, Near Rose Garden, Tagore Nagar,  Civil Lines, Ludhiana, Punjab 141001" );
                                startActivity(hh);
                                break;
                            case 3:
                                Intent unh = new Intent(Emergency.this,Emergency_Call.class);
                                unh.putExtra("Phone","01615222333");
                                unh.putExtra( "Name","Fortis Hospital" );
                                unh.putExtra( "Address","Chandigarh Road, Mundian Kalan Village, Near Radha Soami " +
                                        "Satsang Bhavan, Ludhiana, Punjab 141015" );
                                startActivity(unh);
                                break;

                        }

                    }
                });
                break;
            case 2:
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(parent.getContext(),android.R.layout.simple_list_item_1,hospitalPhaghwara);
                listView.setAdapter(adapter2);
                listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                Intent swh = new Intent(Emergency.this,Emergency_Call.class);
                                swh.putExtra("Phone","01824260020");
                                swh.putExtra( "Name","Swaran Hospital" );
                                swh.putExtra( "Address"," 728,Guru Hargobind Nagar, Phagwara, Punjab 144401" );
                                startActivity(swh);
                                break;
                            case 1:
                                Intent mah = new Intent(Emergency.this,Emergency_Call.class);
                                mah.putExtra("Phone","+919814062682");
                                mah.putExtra( "Name","Malhotra Hospital" );
                                mah.putExtra( "Address","Subhash Nagar, Phagwara, Punjab 144401" );
                                startActivity(mah);
                                break;
                        }

                    }
                });
                break;
            case 3:
                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(parent.getContext(),android.R.layout.simple_list_item_1,hospitalJalandhar);
                listView.setAdapter(adapter3);
                listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                Intent pah = new Intent(Emergency.this,Emergency_Call.class);
                                pah.putExtra("Phone","01813041000");
                                pah.putExtra( "Name","Patel Hospital" );
                                pah.putExtra( "Address","Civil Lines, Jalandhar, Punjab 144001" );
                                startActivity(pah);
                                break;
                            case 1:
                                Intent kih = new Intent(Emergency.this,Emergency_Call.class);
                                kih.putExtra("Phone","+919814019603");
                                kih.putExtra( "Name","Kidney Hospital" );
                                kih.putExtra( "Address","63 & 64, Waryam Nagar, Cool Road, Waryam Nagar, Jyoti Nagar, " +
                                        "Jalandhar, Punjab 144003" );
                                startActivity(kih);
                                break;
                            case 2:
                                Intent aah = new Intent(Emergency.this,Emergency_Call.class);
                                aah.putExtra("Phone","01812411458");
                                aah.putExtra( "Name","Aashirwad Hospital" );
                                aah.putExtra( "Address","Rama Mandi, Hoshiarpur Road, Jalandhar Cantt, Jalandhar, Punjab 144007" );
                                startActivity(aah);
                                break;
                            case 3:
                                Intent sgl = new Intent(Emergency.this,Emergency_Call.class);
                                sgl.putExtra("Phone","01815043300");
                                sgl.putExtra( "Name","SGL Hospital" );
                                sgl.putExtra( "Address","Garha Road, Jalandhar, Punjab 144022" );
                                startActivity(sgl);
                                break;

                        }

                    }
                });
                break;
            // {"Care Hospital", "Sandhu Hospital", "North Central Hospital"};
            case 4:
                ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(parent.getContext(),android.R.layout.simple_list_item_1,hospitalPathankot);
                listView.setAdapter(adapter4);
                listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                Intent pah = new Intent(Emergency.this,Emergency_Call.class);
                                pah.putExtra("Phone","01862256500");
                                pah.putExtra( "Name","Care Hospital" );
                                pah.putExtra( "Address","Saili Rd, Rose Avenue, Aman Vihar, Pathankot, Punjab 145001" );
                                startActivity(pah);
                                break;
                            case 1:
                                Intent kih = new Intent(Emergency.this,Emergency_Call.class);
                                kih.putExtra("Phone","01862234040");
                                kih.putExtra( "Name","Sandhu Hospital" );
                                kih.putExtra( "Address","Near Bus Stand, Behind Kapoor Maternity Home, Indira Colony Rd," +
                                        " Indira Colony, Pathankot, Punjab 145001" );
                                startActivity(kih);
                                break;
                            case 2:
                                Intent aah = new Intent(Emergency.this,Emergency_Call.class);
                                aah.putExtra("Phone","01862229444");
                                aah.putExtra( "Name","North Central Hospital" );
                                aah.putExtra( "Address","Near Shri Shani Dev Mandir, Dalhousie Road, Bhadroya, Pathankot, Punjab 145001" );
                                startActivity(aah);
                                break;
                        }
                    }
                });
                break;


        }


    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}

