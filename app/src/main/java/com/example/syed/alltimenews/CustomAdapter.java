package com.example.syed.alltimenews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Syed on 13/6/2016.
 */
public class CustomAdapter extends BaseAdapter{

    private int[] image;
    private String[] siteName;
    Context context;
    LayoutInflater inflater = null;
    int possition;
    View view;


    public CustomAdapter(MainActivity mainActivities,int[] image, String[] siteName) {
        this.image = image;
        this.siteName=siteName;
        context = mainActivities;
        inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class MyHolder{
        ImageView imageView;
    }

    public int getPossition(){
        return possition;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        MyHolder holder = new MyHolder();
        view = inflater.inflate(R.layout.item_list_view,null);
        holder.imageView = (ImageView) view.findViewById(R.id.image_item);
        holder.imageView.setImageResource(image[position]);

        view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    possition = position;
                    context.startActivity(new Intent(context,NewsViewer.class).putExtra("siteName",siteName[position]));
                }
        });
        return view;


    }


}
