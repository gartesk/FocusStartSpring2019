package ru.ftc.focusstart.list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.ftc.focusstart.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    private TextView titleView;
    private TextView textView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.title);
        textView = itemView.findViewById(R.id.text);
    }

    public void bind(CustomModel model) {
        titleView.setText(model.getTitle());
        textView.setText(model.getText());
    }
}
