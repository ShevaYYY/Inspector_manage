package myClusses;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.coursework.R;

import java.util.List;

public class inspectionAdapter extends RecyclerView.Adapter<inspectionAdapter.ViewHolder> {
    private List<inspection> mData;
    private List<String> id_of_inspections;
    private OnItemClickListener mListener;
    public inspectionAdapter(List<inspection> data, List<String> inspections) {
        mData = data;
        this.id_of_inspections = inspections;
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    @Override
    public inspectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inspection_item, parent, false);
        return new inspectionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(inspectionAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        inspection item = mData.get(position);
        holder.object.setText(item.getObject().getTitle());
        holder.inspector.setText(item.getInspector().getName()+" "+item.getInspector().getSurname()+" "+item.getInspector().getMiddle_name());
        holder.data.setText((CharSequence) item.getDate_of_inspection());
        //if(item.getResult().isEmpty()){
          //  holder.checked.setText("Ні");
        //}
        //else
        //{
         //   holder.checked.setText("Так");
        //}
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(position);
                }
            }
        });
    }
    public inspection getTask(int position){
        inspection inspection = mData.get(position);
        return inspection;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView object;
        public TextView inspector;
        public TextView data;
        public ViewHolder(View itemView) {
            super(itemView);
            object = (TextView) itemView.findViewById(R.id.textView104);
            inspector = (TextView) itemView.findViewById(R.id.textView105);
            data = (TextView) itemView.findViewById(R.id.textView106);
        }
    }
}
