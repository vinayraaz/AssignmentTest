package vinay.assignmenttest;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinay on 12/8/2017.
 */

public class RecyclerView_ListAdapter extends RecyclerView.Adapter<RecyclerView_ListAdapter.MyViewHolder> {
    private Context context;
    List<ResponseData> responseDataModeModeList = new ArrayList<>();

    public RecyclerView_ListAdapter(Context context, List<ResponseData> responseDataModeModeList) {
        this.context =context;
        this.responseDataModeModeList =responseDataModeModeList;
        notifyDataSetChanged();


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_all_details, null);
        MyViewHolder rcv = new MyViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.ID.setText(responseDataModeModeList.get(position).getArtistName());
        holder.Name.setText(responseDataModeModeList.get(position).getTrackName());

        Picasso.with(context).load(responseDataModeModeList.get(position).getTrackViewUrl()).into(holder.Image);



    }

    @Override
    public int getItemCount() {
        return responseDataModeModeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView ID,Name;
        public ImageView Image;
        public MyViewHolder(View itemView) {
            super(itemView);
            ID = (TextView)itemView.findViewById(R.id.tv1);
            Name = (TextView)itemView.findViewById(R.id.tv2);
            Image = (ImageView) itemView.findViewById(R.id.im);
        }
    }
}
