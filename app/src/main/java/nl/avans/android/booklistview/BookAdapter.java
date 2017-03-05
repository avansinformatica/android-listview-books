package nl.avans.android.booklistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {

    private final String TAG = this.getClass().getSimpleName();

    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList<Book> bookArrayList;

    public BookAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Book> bookArrayList) {
        mContext = context;
        mInflator = layoutInflater;
        this.bookArrayList = bookArrayList;
    }

    @Override
    public int getCount() {
        int size = bookArrayList.size();
        Log.i(TAG, "getCount() = " + size);
        return size;
    }

    @Override
    public Object getItem(int position) {
        Log.i(TAG, "getItem() at " + position);
        return bookArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i(TAG, "getView at " + position);

        ViewHolder viewHolder;

        if(convertView == null){

            Log.i(TAG, "convertView is NULL - nieuwe maken");

            // Koppel de convertView aan de layout van onze eigen row
            convertView = mInflator.inflate(R.layout.list_book_row, null);

            // Maak een ViewHolder en koppel de schermvelden aan de velden uit onze eigen row.
            viewHolder = new ViewHolder();
            viewHolder.textViewAuthor = (TextView) convertView.findViewById(R.id.rowBookAuthor);
            viewHolder.textViewTitle = (TextView) convertView.findViewById(R.id.rowBookTitle);

            // Sla de viewholder op in de convertView
            convertView.setTag(viewHolder);
        } else {
            Log.i(TAG, "convertView BESTOND AL - hergebruik");
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Book book = bookArrayList.get(position);
        viewHolder.textViewAuthor.setText(book.getAuthor());
        viewHolder.textViewTitle.setText(book.getTitle());

        return convertView;
    }

    private static class ViewHolder {
        public TextView textViewTitle;
        public TextView textViewAuthor;
    }
}

