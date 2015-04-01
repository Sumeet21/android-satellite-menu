package android.view.ext;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.ext.SatelliteMenu.SateliteClickedListener;
import android.widget.ImageView;
import android.widget.Toast;

public class SatelliteMenuActivity extends Activity {

	static int zoom = 1, effect = 1;
	final static int btnZoom = 1234, btnEffects = 12345;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		SatelliteMenu menu = (SatelliteMenu) findViewById(R.id.menu);

		// Set from XML, possible to programmatically set
		// float distance =
		// TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 170,
		// getResources().getDisplayMetrics());
		// menu.setSatelliteDistance((int) distance);
		// menu.setExpandDuration(500);
		// menu.setCloseItemsOnClick(false);
		// menu.setTotalSpacingDegree(60);

		List<SatelliteMenuItem> items = new ArrayList<SatelliteMenuItem>();
		items.add(new SatelliteMenuItem(4, R.drawable.ic_1));
		items.add(new SatelliteMenuItem(btnEffects, getEffectsButton()));
		items.add(new SatelliteMenuItem(4, R.drawable.ic_4));
		items.add(new SatelliteMenuItem(btnZoom, getZoomButton()));
		items.add(new SatelliteMenuItem(2, R.drawable.ic_6));
		items.add(new SatelliteMenuItem(1, R.drawable.ic_2));
		// items.add(new SatelliteMenuItem(5, R.drawable.sat_item));
		menu.addItems(items);
		menu.setOnItemClickedListener(new SateliteClickedListener() {

			@Override
			public void onClick(int id) {
				Toast.makeText(getApplicationContext(), "clicked on " + id, 0)
						.show();

			}

			@Override
			public void changeIcon(int id, ImageView cloneview,
					ImageView ItemView) {

				if (id == 2) {
					// example to change button icon
					cloneview.setImageResource(R.drawable.ic_launcher);
					ItemView.setImageResource(R.drawable.ic_launcher);
				} else if (id == btnZoom) {
					zoom++;
					cloneview.setImageResource(getZoomButton());
					ItemView.setImageResource(getZoomButton());
				} else if (id == btnEffects) {
					effect++;
					cloneview.setImageResource(getEffectsButton());
					ItemView.setImageResource(getEffectsButton());
				}
			}

		});
	}

	private int getZoomButton() {
		switch (zoom) {
		case 1:
			return R.drawable.x1;
		case 2:
			return R.drawable.x2;
		case 3:
			return R.drawable.x3;
		case 4:
			zoom = 0;
			return R.drawable.x4;
		default:
			return R.drawable.x1;
		}
	}

	private int getEffectsButton() {
		switch (effect) {
		case 1:
			return R.drawable.e1;
		case 2:
			return R.drawable.e2;
		case 3:
			return R.drawable.e3;
		case 4:
			return R.drawable.e4;
		case 5:
			effect = 0;
			return R.drawable.e5;
		default:
			return R.drawable.e1;
		}
	}
}
