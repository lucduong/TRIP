package vn.com.ltv.component;

import vn.com.ltv.trip.R;
import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;

public class LTVCalendar extends EditText {
	private Dialog dialogCalendar;
	private LTVCalendar calendar = this;

	public LTVCalendar(Context context, AttributeSet attrs) {
		super(context, attrs);

		this.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showCalendar();
				return false;
			}
		});
	}

	public LTVCalendar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

	}

	public LTVCalendar(Context context) {
		super(context);

	}

	private void showCalendar() {
		if (dialogCalendar == null) {
			dialogCalendar = new Dialog(getContext());
			LayoutParams params = new LayoutParams(600, 800);
			dialogCalendar.requestWindowFeature(Window.FEATURE_NO_TITLE);

			View view = LayoutInflater.from(getContext()).inflate(
					R.layout.activity_calendar_view, null);

			dialogCalendar.setContentView(view, params);
			CalendarView calendarView = (CalendarView) view
					.findViewById(R.id.calendarView);
			calendarView.setOnDateChangeListener(new OnDateChangeListener() {

				@Override
				public void onSelectedDayChange(CalendarView view, int year,
						int month, int dayOfMonth) {

					String day = dayOfMonth + "/" + month + "/" + year;
					calendar.setText(day);
					dialogCalendar.dismiss();

				}
			});

		}
		dialogCalendar.show();
	}

}
