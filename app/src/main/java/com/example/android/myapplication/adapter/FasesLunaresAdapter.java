package com.example.android.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.myapplication.R;
import com.example.android.myapplication.newmodels.FaseLunar;

import com.example.android.myapplication.newmodels.FaseLunar;
import java.util.ArrayList;



public class FasesLunaresAdapter extends BaseAdapter {

    public static final int ADAPTER_MODE_LISTVIEW = 0;
    public static final int ADAPTER_MODE_GRIDVIEW = 1;

    private ArrayList<FaseLunar> items;
    private Context mContext;
    private LayoutInflater mInflater;

    private int adapterMode = ADAPTER_MODE_LISTVIEW; //valor por defecto

    public FasesLunaresAdapter(ArrayList<FaseLunar> mList, Context ctx, int mode)
    {
        items = mList;
        mContext = ctx;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        adapterMode = mode;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FaseLunar mFase = items.get(position);
        ViewHolder holder;

        //Si converview es null, no tenemos referencias, por lo que habrá que crear un objeto ViewHolder
        //y asignárselo a esta vista
        if(convertView == null)
        {
            // Si estamos en modo lista, cargamos un layout para cada item
            if (adapterMode == ADAPTER_MODE_LISTVIEW) {
                convertView = mInflater.inflate(R.layout.item_list, null);
            }


            holder = new ViewHolder();
            holder.imagen = (ImageView)convertView.findViewById(R.id.image);
            holder.nombre = (TextView)convertView.findViewById(R.id.titre_annonce);
            holder.nombreAlt = (TextView)convertView.findViewById(R.id.price);
            holder.ville = (TextView)convertView.findViewById(R.id.address);
            holder.heure = (TextView)convertView.findViewById(R.id.bed);
            holder.date = (TextView)convertView.findViewById(R.id.bath);
            holder.state = (TextView)convertView.findViewById(R.id.square);

            convertView.setTag(holder);
        }
        //En cambio si convertView no es null, sabemos que viene un objeto ViewHolder con referencias a
        //sus vistas hijas relevantes
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        //En este punto las referencias las tenemos seguro
        holder.imagen.setImageResource(mFase.getImageResource());
        holder.nombre.setText(mFase.getName());
        holder.nombreAlt.setText(mFase.getAltName() == null ? "" : mFase.getAltName());
        holder.ville.setText(mFase.getVille());
        holder.heure.setText(mFase.getHeure());
        holder.date.setText(mFase.getDate());
        holder.state.setText(mFase.getState());
        return convertView;
    }


    private static class ViewHolder{
        public ImageView imagen;
        public TextView nombre;
        public TextView nombreAlt;

        public TextView ville;
        public TextView date;
        public TextView heure;
        public TextView state;

    }
}
