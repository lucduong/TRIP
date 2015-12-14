package vn.com.ltv.tab;

import java.util.ArrayList;
import java.util.List;

import vn.com.ltv.adaptor.ItemDayAdapter;
import vn.com.ltv.adaptor.ItemDayAdapter.ItemDayListener;
import vn.com.ltv.adaptor.LocationAdapter;
import vn.com.ltv.adaptor.ScheduleAdapter;
import vn.com.ltv.dto.StationVO;
import vn.com.ltv.trip.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TabSchedule extends Fragment implements ItemDayListener {

	private ListView lstViewStation;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.tab_schedule, null);

		int[] days = { 20, 21, 22 };

		String l1 = "7h00: Xuống bến xe Lai Châu, ăn sang, sắp xếp xe ôm gọi chuẩn bị thủ tục";
		String l2 = "8h00: Xuất phát vào Dền Sung";
		String l3 = "10h00: Vào tới nơi (ăn uống tùy các bác)";
		String l4 = "13h00: Bắt đầu leo, vừa leo vừa nghỉ.";
		String l5 = "6h:00 Tới suối hoặc khu rừng phong lan cắm trại tùy sức khỏe của các bác.";

		String[] values = new String[] { l1, l2, l3, l4, l5, };
		List<StationVO> lstDataView = new ArrayList<StationVO>();

		for (int i = 0; i < values.length; ++i) {
			StationVO obj = new StationVO();
			obj.setStationNm(values[i]);
			lstDataView.add(obj);
		}
		lstViewStation = (ListView) view.findViewById(R.id.listViewStation);
		ScheduleAdapter adapter = new ScheduleAdapter(getActivity(),
				lstDataView);
		lstViewStation.setAdapter(adapter);

		ListView listView_days = (ListView) view
				.findViewById(R.id.listView_days);
		listView_days.setAdapter(new ItemDayAdapter(getActivity(), days,
				TabSchedule.this));
		return view;
	}

	@Override
	public void onItemDayClick(View view, int key) {

		String l1 = "7h00: Xuống bến xe Lai Châu, ăn sang, sắp xếp xe ôm gọi chuẩn bị thủ tục";
		String l2 = "8h00: Xuất phát vào Dền Sung";
		String l3 = "10h00: Vào tới nơi (ăn uống tùy các bác)";
		String l4 = "13h00: Bắt đầu leo, vừa leo vừa nghỉ.";
		String l5 = "6h:00 Tới suối hoặc khu rừng phong lan cắm trại tùy sức khỏe của các bác.";

		String[] values1 = new String[] { l1, l2, l3, l4, l5, };

		String l6 = "6h00: dậy sớm ăn uống, và treck lên đỉnh.";
		String l7 = "9h10 : Lên tới đèo gió kiếm chỗ giấu đồ, mang theo máy ảnh đồ có giá trị và trek lên đỉnh.";
		String l8 = "12h00: Lên đỉnh, ăn trưa trên đỉnh chụp ảnh và đi xuống. Tổng thời gian leo lên và xuống đỉnh tính từ đèo gió là khoảng 4 tiếng.";
		String l9 = "1h00: Trek xuống lấy đồ và bắt đầu tụt dốc.";
		String l10 = "19h00: Tới lán thảo quả của dân dừng nghỉ chân.";

		String[] values2 = new String[] { l6, l7, l8, l9, l10, };

		String l11 = "Sáng dậy thong thả ăn uống café, dọc đường xuống chụp ảnh suối rất đẹp.";
		String l12 = "Khoảng trưa về tới bản, thanh toán tiền nong ăn trưa rồi xe ôm ra Lai Châu.";
		String l13 = "20h: Lên ô tô về Hà Nội.";
		String[] values3 = new String[] { l11, l12, l13 };

		String[] values = new String[] {};
		List<StationVO> lstDataView = new ArrayList<StationVO>();

		if (key == 20) {
			values = values1;
		} else if (key == 21) {
			values = values2;
		} else if (key == 22) {
			values = values3;
		}

		for (int i = 0; i < values.length; ++i) {
			StationVO obj = new StationVO();
			obj.setStationNm(values[i]);
			lstDataView.add(obj);
		}
		LocationAdapter adapter = new LocationAdapter(getActivity(),
				lstDataView);
		lstViewStation.setAdapter(adapter);
	}

}
