package es.uam.eps.android.CCC26;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

public class MainActivity extends Activity implements OnClickListener {
	Game game;
	static final int SIZE = 7;

	private final int ids[][] = {
			{ 0, 0, R.id.f1, R.id.f2, R.id.f3, 0, 0 },
			{ 0, 0, R.id.f4, R.id.f5, R.id.f6, 0, 0 },
			{ R.id.f7, R.id.f8, R.id.f9, R.id.f10, R.id.f11, R.id.f12, R.id.f13 },
			{ R.id.f14, R.id.f15, R.id.f16, R.id.f17, R.id.f18, R.id.f19, R.id.f20 },
			{ R.id.f21, R.id.f22, R.id.f23, R.id.f24, R.id.f25, R.id.f26, R.id.f27 }, 
			{ 0, 0, R.id.f28, R.id.f29, R.id.f30, 0, 0 },
			{ 0, 0, R.id.f31, R.id.f32, R.id.f33, 0, 0 } };

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		registerListeners();
		game = new Game();
		setFigureFromGrid();
	}

	private void registerListeners() {
		RadioButton button;

		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				if (ids[i][j] != 0) {
					button = (RadioButton) findViewById(ids[i][j]);
					button.setOnClickListener(this);
				}
	}

	public void onClick(View v) {
		int id = ((RadioButton) v).getId();

		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				if (ids[i][j] == id) {
					game.play(i, j);
					break;
				}

		setFigureFromGrid();
		if (game.isGameFinished())
			new AlertDialogFragment()
					.show(getFragmentManager(), "ALERT DIALOG");
	}

	public void setFigureFromGrid() {
		RadioButton button;

		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				if (ids[i][j] != 0) {
					int value = game.getGrid(i, j);
					button = (RadioButton) findViewById(ids[i][j]);

					if (value == 1)
						button.setChecked(true);
					else
						button.setChecked(false);
				}
	}

	protected void onResume() {
		super.onResume();
		Music.play(this, R.raw.funkandblues);
	}

	protected void onPause() {
		super.onPause();
		Music.stop(this);
	}

	public void onSaveInstanceState(Bundle outState) {
		outState.putString("GRID", game.gridToString());
		super.onSaveInstanceState(outState);
	}

	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		String grid = savedInstanceState.getString("GRID");
		game.stringToGrid(grid);
		setFigureFromGrid();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.ccc_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menuAbout:
			startActivity(new Intent(this, About.class));
			return true;
		case R.id.sendMessage:
			Intent intent = new Intent(android.content.Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_SUBJECT, "CHA CHA CHA");
			intent.putExtra(Intent.EXTRA_TEXT,
					"Hola ..., he llegado a ... puntos en cha cha cha ...");
			startActivity(intent);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}