package flobee.cognatesproofofconcept;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

public class EndActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.end_ex2);
    final TextView yellowTextView = (TextView)findViewById(R.id.yellow);
    final TextView blueTextView   = (TextView)findViewById(R.id.blue);
    yellowTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(EndActivity.this, StartActivity.class);
        ActivityOptions transitionActivityOptions
          = ActivityOptions.makeSceneTransitionAnimation(EndActivity.this,
                                                         new Pair<View, String>(yellowTextView, "yellow_diagonal"),
                                                         new Pair<View, String>(blueTextView, "blue_diagonal"));
        startActivity(i, transitionActivityOptions.toBundle());
      }
    });
  }
}
