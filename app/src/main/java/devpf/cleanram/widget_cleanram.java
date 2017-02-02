package devpf.cleanram;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;


public class widget_cleanram extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_cleanram);
        appWidgetManager.updateAppWidget(appWidgetId, views);

    }
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int i = 0; i < appWidgetIds.length; i++) {
            int appWidgetId = appWidgetIds[i];

            Intent intent = new Intent(context, CleanRam.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_cleanram);
            views.setOnClickPendingIntent(R.id.text, pendingIntent);
            //Toast.makeText(context ,"This works :)",Toast.LENGTH_SHORT).show();
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }


}

