package pungfaye.itemlist;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class MainActivity extends ListActivity {

	private MyAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAdapter = new MyAdapter();
		for (int i = 0; i < 100; i++) {
			mAdapter.addItem("item" + i);
		}
		setListAdapter(mAdapter);
	}
	
	
	public class MyAdapter extends BaseAdapter {

		private ArrayList mData = new ArrayList();
		private LayoutInflater mInflater = null;
		
		public MyAdapter(){
			mInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		}
		
		public void addItem(final String item){
			mData.add(item);
			notifyDataSetChanged();
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mData.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mData.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			System.out.println("getView" + position + " " + convertView);
			
			ViewHolder holder = null;
			
			if(convertView == null)
			{
				holder = new ViewHolder();
				convertView = mInflater.inflate(R.layout.activity_main, null);
				holder.textView = (TextView)convertView.findViewById(R.id.text);
				convertView.setTag(holder);
			}
			else
			{
				holder = (ViewHolder)convertView.getTag();
			}
			
			holder.textView.setText((String)mData.get(position));
			
			
			return convertView;
		}
	}
	public static class ViewHolder{
		public TextView textView;
	}
}

