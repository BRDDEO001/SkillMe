package com.example.skillmesa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context context;
    private CityAdapter adapter;
    public void setConfig(RecyclerView recyclerView, Context c, List<City> cities, List<String> keys){
        context = c;
        adapter = new CityAdapter(cities, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }

    class CityViewItem extends RecyclerView.ViewHolder{
        private TextView cityC;
        private TextView txtVcity;
        private TextView prov;
        private String key;

        public CityViewItem(ViewGroup parent){
            super (LayoutInflater.from(context).inflate(R.layout.city_item, parent,false ));

            cityC = (TextView) itemView.findViewById(R.id.lblCityID);
            txtVcity = (TextView) itemView.findViewById(R.id.lblCity);
            prov = (TextView) itemView.findViewById(R.id.lblProvince);
        }

        public void Bind(City city, String key){
            cityC.setText(city.getCityID());
            txtVcity.setText(city.getCity());
            prov.setText(city.getProvince());
            this.key = key;

        }

    }

    class CityAdapter extends RecyclerView.Adapter<CityViewItem>{
        private List<City> cityList;
        private List<String> keys;

        public CityAdapter(List<City> cl, List<String> k) {
            this.cityList = cl;
            this.keys = k;
        }


        @Override
        public CityViewItem onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CityViewItem(parent);
        }

        @Override
        public void onBindViewHolder(RecyclerView_Config.CityViewItem holder, int position) {
            holder.Bind(cityList.get(position), keys.get(position));
        }

        @Override
        public int getItemCount() {
            return cityList.size();
        }
    }

}
