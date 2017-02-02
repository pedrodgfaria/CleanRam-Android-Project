package devpf.cleanram;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

public class CleanRam extends AppCompatActivity {

    public void toast()
    {
        ActivityManager actvityManager = (ActivityManager) getApplicationContext().getSystemService( getApplicationContext().ACTIVITY_SERVICE );
        List<ActivityManager.RunningAppProcessInfo> procInfos = actvityManager.getRunningAppProcesses();

        for(int pnum = 0; pnum < procInfos.size(); pnum++)
        {
            if(!(procInfos.get(pnum)).processName.contains("cleanram"))
            {
                actvityManager.killBackgroundProcesses(procInfos.get(pnum).processName);
            }
        }
        Toast.makeText(this,"System Clean :)",Toast.LENGTH_SHORT).show();
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean_ram);
        toast();
    }
}
